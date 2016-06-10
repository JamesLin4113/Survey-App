package com.bboxxproject.bboxxsurveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_client);


        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");

        Button bCreateSurvey = (Button) findViewById(R.id.bCreateSurvey);

        bCreateSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent survey = new Intent(HomeClientActivity.this, SurveyCreation.class);
                survey.putExtra("username", username);
                HomeClientActivity.this.startActivity(survey);
            }
        });
    }
}
