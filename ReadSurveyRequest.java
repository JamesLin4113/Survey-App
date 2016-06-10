package com.bboxxproject.bboxxsurveyapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lizhang on 14/05/2016.
 */
public class ReadSurveyRequest extends StringRequest {
    private static final String ReadSurveyRequest_URL = "http://bboxxproject.comxa.com/ReadSurvey.php";//****
    private Map<String, String> params;

    public ReadSurveyRequest(Response.Listener<String> listener) {
        super(Request.Method.POST, ReadSurveyRequest_URL, listener, null);
        //params = new HashMap<>();
        //params.put("NameOfSurvey", NameOfSurvey);
        //params.put("Question1", Question1);
        //params.put("Answer1", Answer1);
        //params.put("username", username);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
