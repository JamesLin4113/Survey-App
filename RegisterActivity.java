package com.bboxxproject.bboxxsurveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        //when the user click register, we have got the info from the fields above, and pass it to the RegisterRequest, and then execute the request
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();//convert to string
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final int age = Integer.parseInt(etAge.getText().toString());//converts the string to int

                //create a response listener
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //remember from RegisterRequest.php, we have a JSONObject
                            //convert the string that volley gives us to JSONObject
                            JSONObject jsonResponse = new JSONObject(response);
                            //success is returned from the php file
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {//registration is successful
                                //intent is to activate
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                //jump from registerActivity to startActivity
                                RegisterActivity.this.startActivity(intent);
                            } else {
                                //if not successful, create an alert dialog
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                //set dialog message
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                //creates a request
                RegisterRequest registerRequest = new RegisterRequest(name, username, age, password, responseListener);
                //edit a request queue
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}