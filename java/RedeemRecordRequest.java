package com.bboxxproject.bboxxsurveyapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lizhang on 19/05/2016.
 */
public class RedeemRecordRequest extends StringRequest {
    private static final String DoneSurveyRequest_URL = "http://bboxxproject.comxa.com/RedeemRecord.php";//****
    private Map<String, String> params;

    public RedeemRecordRequest(String username, Response.Listener<String> listener) {
        super(Request.Method.POST, DoneSurveyRequest_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
