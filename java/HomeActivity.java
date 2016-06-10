package com.bboxxproject.bboxxsurveyapp;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        int age = intent.getIntExtra("age", -1);
        int NumOfPending = intent.getIntExtra("NumOfPending", -1);
        Integer.toString(NumOfPending);//++++not sure

        final TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        //final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        //final EditText etAge = (EditText) findViewById(R.id.etAge);
        final TextView tvPendingSurvey = (TextView) findViewById(R.id.tvPendingSurvey);
        final Button bSurvey = (Button) findViewById(R.id.bSurvey);
        final Button bLogout = (Button) findViewById(R.id.bLogout);
        final Button bProfile = (Button) findViewById(R.id.bProfile);


        // Display details
        String message = name + " welcome to your user area";
        String message_pending = "You have " + NumOfPending + " survey to complete";
        tvWelcomeMsg.setText(message);
        //etUsername.setText(username);
        //etAge.setText(age + "");
        tvPendingSurvey.setText(message_pending);
        bSurvey.setText("fill in survey");

        //button?

        bLogout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent logout = new Intent(HomeActivity.this, LoginActivity.class);
               HomeActivity.this.startActivity(logout);
           }
        });

        bProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                int points = intent.getIntExtra("points",-1);
                String username = intent.getStringExtra("username");
                Intent profile = new Intent(HomeActivity.this, ProfileActivity.class);
                profile.putExtra("points", points);
                profile.putExtra("username", username);
                HomeActivity.this.startActivity(profile);
            }
        });




        //PendingSurvey click listener (It goes to SurveyActivity when it's clicked)
        bSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get instance "username" & "password"
                final String username = intent.getStringExtra("username");
                //final String username = etUsername.getText().toString();
                //final String password = etPassword.getText().toString();

                // Response received from php file (server)
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String NameOfSurvey = jsonResponse.getString("NameOfSurvey");
                                String QuestionOne = jsonResponse.getString("QuestionOne");
                                String QuestionTwo = jsonResponse.getString("QuestionTwo");
                                String QuestionThree = jsonResponse.getString("QuestionThree");
                                String QuestionFour = jsonResponse.getString("QuestionFour");
                                String QuestionFive = jsonResponse.getString("QuestionFive");
                                int type1 = jsonResponse.getInt("type1");
                                int type2 = jsonResponse.getInt("type2");
                                int type3 = jsonResponse.getInt("type3");
                                int type4 = jsonResponse.getInt("type4");
                                int type5 = jsonResponse.getInt("type5");
                                String TextAnswerOne = jsonResponse.getString("TextAnswerOne");
                                String TextAnswerTwo = jsonResponse.getString("TextAnswerTwo");
                                String TextAnswerThree = jsonResponse.getString("TextAnswerThree");
                                String TextAnswerFour = jsonResponse.getString("TextAnswerFour");
                                String TextAnswerFive = jsonResponse.getString("TextAnswerFive");
                                String RadioAnswerOneOne = jsonResponse.getString("RadioAnswerOneOne");
                                String RadioAnswerOneTwo = jsonResponse.getString("RadioAnswerOneTwo");
                                String RadioAnswerOneThree = jsonResponse.getString("RadioAnswerOneThree");

                                String RadioAnswerTwoOne = jsonResponse.getString("RadioAnswerTwoOne");
                                String RadioAnswerTwoTwo = jsonResponse.getString("RadioAnswerTwoTwo");
                                String RadioAnswerTwoThree = jsonResponse.getString("RadioAnswerTwoThree");

                                String RadioAnswerThreeOne = jsonResponse.getString("RadioAnswerThreeOne");
                                String RadioAnswerThreeTwo = jsonResponse.getString("RadioAnswerThreeTwo");
                                String RadioAnswerThreeThree = jsonResponse.getString("RadioAnswerThreeThree");

                                String RadioAnswerFourOne = jsonResponse.getString("RadioAnswerFourOne");
                                String RadioAnswerFourTwo = jsonResponse.getString("RadioAnswerFourTwo");
                                String RadioAnswerFourThree = jsonResponse.getString("RadioAnswerFourThree");

                                String RadioAnswerFiveOne = jsonResponse.getString("RadioAnswerFiveOne");
                                String RadioAnswerFiveTwo = jsonResponse.getString("RadioAnswerFiveTwo");
                                String RadioAnswerFiveThree = jsonResponse.getString("RadioAnswerFiveThree");

                               //**************intent*****************
                                Intent intent = new Intent(HomeActivity.this, SurveyActivity.class);
                                //put data into intent and pass them to SurveyActivity
                                intent.putExtra("NameOfSurvey", NameOfSurvey);
                                intent.putExtra("QuestionOne", QuestionOne);
                                intent.putExtra("type1", type1);
                                intent.putExtra("TextAnswerOne", TextAnswerOne);
                                intent.putExtra("RadioAnswerOneOne", RadioAnswerOneOne);
                                intent.putExtra("RadioAnswerOneTwo", RadioAnswerOneTwo);
                                intent.putExtra("RadioAnswerOneThree", RadioAnswerOneThree);

                                intent.putExtra("QuestionTwo", QuestionTwo);
                                intent.putExtra("type2", type2);
                                intent.putExtra("TextAnswerTwo", TextAnswerTwo);
                                intent.putExtra("RadioAnswerTwoOne", RadioAnswerTwoOne);
                                intent.putExtra("RadioAnswerTwoTwo", RadioAnswerTwoTwo);
                                intent.putExtra("RadioAnswerTwoThree", RadioAnswerTwoThree);

                                intent.putExtra("QuestionThree", QuestionThree);
                                intent.putExtra("type3", type3);
                                intent.putExtra("TextAnswerThree", TextAnswerThree);
                                intent.putExtra("RadioAnswerThreeOne", RadioAnswerThreeOne);
                                intent.putExtra("RadioAnswerThreeTwo", RadioAnswerThreeTwo);
                                intent.putExtra("RadioAnswerThreeThree", RadioAnswerThreeThree);

                                intent.putExtra("QuestionFour", QuestionFour);
                                intent.putExtra("type4", type4);
                                intent.putExtra("TextAnswerFour", TextAnswerFour);
                                intent.putExtra("RadioAnswerFourOne", RadioAnswerFourOne);
                                intent.putExtra("RadioAnswerFourTwo", RadioAnswerFourTwo);
                                intent.putExtra("RadioAnswerFourThree", RadioAnswerFourThree);

                                intent.putExtra("QuestionFive", QuestionFive);
                                intent.putExtra("type5", type5);
                                intent.putExtra("TextAnswerFive", TextAnswerFive);
                                intent.putExtra("RadioAnswerFiveOne", RadioAnswerFiveOne);
                                intent.putExtra("RadioAnswerFiveTwo", RadioAnswerFiveTwo);
                                intent.putExtra("RadioAnswerFiveThree", RadioAnswerFiveThree);


                                intent.putExtra("username", username);
                                HomeActivity.this.startActivity(intent);



                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                                builder.setMessage("Loading survey failed...")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                ReadSurveyRequest readSurveyRequest = new ReadSurveyRequest(responseListener);//note we passed username
                RequestQueue queue = Volley.newRequestQueue(HomeActivity.this);
                queue.add(readSurveyRequest);
            }
        });

    }
}
