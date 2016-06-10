package com.bboxxproject.bboxxsurveyapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Lizhang on 18/05/2016.
 */
public class HomeRequest extends StringRequest{
    private static final String HOME_URL = "http://bboxxproject.comxa.com/Home.php";//****
    private Map<String, String> params;

    public HomeRequest(String username, Response.Listener<String> listener) {
        super(Request.Method.POST, HOME_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
