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

public class LoginClientActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_client);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final TextView tvClientWelcome = (TextView) findViewById(R.id.tvClientWelcome);
        final Button bLogin = (Button) findViewById(R.id.bSignIn);
        final TextView tvClientRegistration = (TextView) findViewById(R.id.tvClientRegistration);

        //Register Client click listener (It goes to register activity when it's clicked)

        tvClientRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginClientActivity.this, RegisterClientActivity.class);
                LoginClientActivity.this.startActivity(registerIntent);
            }
        });

        //when user clicks login button go to HomeClient
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

                                Intent intent = new Intent(LoginClientActivity.this, HomeClientActivity.class);
                                //put data into intent and pass them to HomeActivity
                                intent.putExtra("name", name);
                                intent.putExtra("username", username);
                                LoginClientActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginClientActivity.this);
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

                LoginClientRequest loginClientRequest = new LoginClientRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginClientActivity.this);
                queue.add(loginClientRequest);
            }
        });

    }
}
