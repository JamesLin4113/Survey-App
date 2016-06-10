package com.bboxxproject.bboxxsurveyapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        final Button bLogin = (Button) findViewById(R.id.bSignIn);
        final Button bClientArea = (Button) findViewById(R.id.bClientArea);

        //register click listener (It goes to register activity when it's clicked)
        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
        //Client Area click listener (It goes to register activity when it's clicked)
        bClientArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clientIntent = new Intent(LoginActivity.this, LoginClientActivity.class);
                LoginActivity.this.startActivity(clientIntent);
            }
        });



        //when user clicks login button
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get instance "username" & "password"
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                // Response received from php file (server)
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String name = jsonResponse.getString("name");
                                int age = jsonResponse.getInt("age");
                                int NumOfPending = jsonResponse.getInt("NumOfPending");//number of pending survey
                                int points = jsonResponse.getInt("points");
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                //put data into intent and pass them to HomeActivity
                                intent.putExtra("name", name);
                                intent.putExtra("age", age);
                                intent.putExtra("points", points);
                                intent.putExtra("username", username);
                                intent.putExtra("NumOfPending", NumOfPending);//number of pending survey
                                LoginActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });

    }
}
