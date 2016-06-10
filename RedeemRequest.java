package com.bboxxproject.bboxxsurveyapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lizhang on 19/05/2016.
 */
public class RedeemRequest extends StringRequest{
    private static final String DoneSurveyRequest_URL = "http://bboxxproject.comxa.com/Redeem.php";//****
    private Map<String, String> params;

    public RedeemRequest(String username, String checkbox1, Response.Listener<String> listener) {
        super(Request.Method.POST, DoneSurveyRequest_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("checkbox1", checkbox1);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
