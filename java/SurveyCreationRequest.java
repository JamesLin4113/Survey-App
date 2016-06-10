package com.bboxxproject.bboxxsurveyapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lizhang on 26/05/2016.
 */
public class SurveyCreationRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL = "http://bboxxproject.comxa.com/SurveyCreation.php";//****
    private Map<String, String> params;

    public SurveyCreationRequest(String username, String NameOfSurvey,
                        String type1, String Option11, String Option12, String Option13, String Question1,
                        String type2, String Option21, String Option22, String Option23, String Question2,
                        String type3, String Option31, String Option32, String Option33, String Question3,
                        String type4, String Option41, String Option42, String Option43, String Question4,
                        String type5, String Option51, String Option52, String Option53, String Question5,
                        Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("NameOfSurvey", NameOfSurvey);
        params.put("type1", type1);
        params.put("type2", type2);
        params.put("type3", type3);
        params.put("type4", type4);
        params.put("type5", type5);

        params.put("Option11", Option11);
        params.put("Option12", Option12);
        params.put("Option13", Option13);
        params.put("Option21", Option21);
        params.put("Option22", Option22);
        params.put("Option23", Option23);
        params.put("Option31", Option31);
        params.put("Option32", Option32);
        params.put("Option33", Option33);
        params.put("Option41", Option41);
        params.put("Option42", Option42);
        params.put("Option43", Option43);
        params.put("Option51", Option51);
        params.put("Option52", Option52);
        params.put("Option53", Option53);

        params.put("Question1", Question1);
        params.put("Question2", Question2);
        params.put("Question3", Question3);
        params.put("Question4", Question4);
        params.put("Question5", Question5);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
