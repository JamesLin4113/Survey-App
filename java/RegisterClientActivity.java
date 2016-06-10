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

public class RegisterClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_client);

        final EditText etClientName = (EditText) findViewById(R.id.etClientName);
        final EditText etCompanyName = (EditText) findViewById(R.id.etCompanyName);
        final EditText etClientEmail = (EditText) findViewById(R.id.etClientEmail);
        final EditText etClientUsername = (EditText) findViewById(R.id.etClientUsername);
        final EditText etClientPassword = (EditText) findViewById(R.id.etClientPassword);
        final EditText etContactNumber = (EditText) findViewById(R.id.etContactNumber);
        final EditText etCountry = (EditText) findViewById(R.id.etCountry);

        final Button bRegistrationSub = (Button) findViewById(R.id.bRegistrationSub);

        //when the user click register, we have got the info from the fields above, and pass it to the RegisterRequest, and then execute the request
        bRegistrationSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etClientName.getText().toString();//convert to string
                final String CompanyName = etCompanyName.getText().toString();
                final String ClientEmail = etClientEmail.getText().toString();
                final String ClientUsername = etClientUsername.getText().toString();

                final String ClientPassword = etClientPassword.getText().toString();
                final String Number = etContactNumber.getText().toString();//converts the string to int
                final String Country = etCountry.getText().toString();

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
                                Intent intent = new Intent(RegisterClientActivity.this, LoginClientActivity.class);
                                //jump from registerActivity to startActivity
                                RegisterClientActivity.this.startActivity(intent);
                            } else {
                                //if not successful, create an alert dialog
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterClientActivity.this);
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
                RegisterClientRequest registerClientRequest = new RegisterClientRequest(name, CompanyName, ClientEmail, ClientUsername, ClientPassword, Number, Country, responseListener);
                //edit a request queue
                RequestQueue queue = Volley.newRequestQueue(RegisterClientActivity.this);
                queue.add(registerClientRequest);
            }
        });
    }
}