package com.bboxxproject.bboxxsurveyapp;

/**
 * Created by Lizhang on 13/05/2016.
 */
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginClientRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://bboxxproject.comxa.com/LoginClient.php";//****
    private Map<String, String> params;

    public LoginClientRequest(String username, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}