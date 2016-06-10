package com.bboxxproject.bboxxsurveyapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lizhang on 16/05/2016.
 */
public class DoneSurveyRequest extends StringRequest {
    private static final String DoneSurveyRequest_URL = "http://bboxxproject.comxa.com/DoneSurvey.php";//****
    private Map<String, String> params;

    public DoneSurveyRequest(String username, String NameOfSurvey,
                             int type1, String TextAnswerOne,String group1Answer,
                             int type2, String TextAnswerTwo,String group2Answer,
                             int type3, String TextAnswerThree,String group3Answer,
                             int type4, String TextAnswerFour,String group4Answer,
                             int type5, String TextAnswerFive,String group5Answer,
                             Response.Listener<String> listener) {
        super(Request.Method.POST, DoneSurveyRequest_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("NameOfSurvey", NameOfSurvey);
        String typeString1 = type1 +"";
        params.put("type1", typeString1);
        String typeString2 = type2 +"";
        params.put("type2", typeString2);
        String typeString3 = type3 +"";
        params.put("type3", typeString3);
        String typeString4 = type4 +"";
        params.put("type4", typeString4);
        String typeString5 = type5 +"";
        params.put("type5", typeString5);
        params.put("TextAnswerOne", TextAnswerOne);
        params.put("group1Answer", group1Answer);
        params.put("TextAnswerTwo", TextAnswerTwo);
        params.put("group2Answer", group2Answer);
        params.put("TextAnswerThree", TextAnswerThree);
        params.put("group3Answer", group3Answer);
        params.put("TextAnswerFour", TextAnswerFour);
        params.put("group4Answer", group4Answer);
        params.put("TextAnswerFive", TextAnswerFive);
        params.put("group5Answer", group5Answer);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
