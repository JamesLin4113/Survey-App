package com.bboxxproject.bboxxsurveyapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

public class SurveyCreation extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_creation);

        final EditText etSurveyName = (EditText) findViewById(R.id.etSurveyName);
        final TextView tvQuestionNumber = (TextView) findViewById(R.id.tvQuestionNumber);
        final EditText etQuestionNumber = (EditText) findViewById(R.id.etQuestionNumber);//please enter 1-5

        //questions & answers
        final TextView tvTitle1 = (TextView) findViewById(R.id.tvTitleOne);
        final TextView tvTitle2 = (TextView) findViewById(R.id.tvTitleTwo);
        final TextView tvTitle3 = (TextView) findViewById(R.id.tvTitleThree);
        final TextView tvTitle4 = (TextView) findViewById(R.id.tvTitleFour);
        final TextView tvTitle5 = (TextView) findViewById(R.id.tvTitleFive);

        final EditText tvQuestion1 = (EditText) findViewById(R.id.tvQuestionOne);
        final EditText tvQuestion2 = (EditText) findViewById(R.id.tvQuestionTwo);
        final EditText tvQuestion3 = (EditText) findViewById(R.id.tvQuestionThree);
        final EditText tvQuestion4 = (EditText) findViewById(R.id.tvQuestionFour);
        final EditText tvQuestion5 = (EditText) findViewById(R.id.tvQuestionFive);

        final TextView tvStyle1 = (TextView) findViewById(R.id.tvStyleOne);
        final TextView tvStyle2 = (TextView) findViewById(R.id.tvStyleTwo);
        final TextView tvStyle3 = (TextView) findViewById(R.id.tvStyleThree);
        final TextView tvStyle4 = (TextView) findViewById(R.id.tvStyleFour);
        final TextView tvStyle5 = (TextView) findViewById(R.id.tvStyleFive);

        final RadioGroup rgStyle1 = (RadioGroup) findViewById(R.id.rgStyleOne);
        final RadioGroup rgStyle2 = (RadioGroup) findViewById(R.id.rgStyleTwo);
        final RadioGroup rgStyle3 = (RadioGroup) findViewById(R.id.rgStyleThree);
        final RadioGroup rgStyle4 = (RadioGroup) findViewById(R.id.rgStyleFour);
        final RadioGroup rgStyle5 = (RadioGroup) findViewById(R.id.rgStyleFive);

        //declare radio buttons?

        final EditText tvOption11 = (EditText) findViewById(R.id.tvOption11);
        final EditText tvOption12 = (EditText) findViewById(R.id.tvOption12);
        final EditText tvOption13 = (EditText) findViewById(R.id.tvOption13);
        final EditText tvOption21 = (EditText) findViewById(R.id.tvOption21);
        final EditText tvOption22 = (EditText) findViewById(R.id.tvOption22);
        final EditText tvOption23 = (EditText) findViewById(R.id.tvOption23);
        final EditText tvOption31 = (EditText) findViewById(R.id.tvOption31);
        final EditText tvOption32 = (EditText) findViewById(R.id.tvOption32);
        final EditText tvOption33 = (EditText) findViewById(R.id.tvOption33);
        final EditText tvOption41 = (EditText) findViewById(R.id.tvOption41);
        final EditText tvOption42 = (EditText) findViewById(R.id.tvOption42);
        final EditText tvOption43 = (EditText) findViewById(R.id.tvOption43);
        final EditText tvOption51 = (EditText) findViewById(R.id.tvOption51);
        final EditText tvOption52 = (EditText) findViewById(R.id.tvOption52);
        final EditText tvOption53 = (EditText) findViewById(R.id.tvOption53);

        final Button bUpload = (Button) findViewById(R.id.bUpload);

        //initial display
        bUpload.setVisibility(View.GONE);

        tvTitle1.setVisibility(View.GONE);
        tvQuestion1.setVisibility(View.GONE);
        tvStyle1.setVisibility(View.GONE);
        rgStyle1.setVisibility(View.GONE);
        tvOption11.setVisibility(View.GONE);
        tvOption12.setVisibility(View.GONE);
        tvOption13.setVisibility(View.GONE);

        tvTitle2.setVisibility(View.GONE);
        tvQuestion2.setVisibility(View.GONE);
        tvStyle2.setVisibility(View.GONE);
        rgStyle2.setVisibility(View.GONE);
        tvOption21.setVisibility(View.GONE);
        tvOption22.setVisibility(View.GONE);
        tvOption23.setVisibility(View.GONE);

        tvTitle3.setVisibility(View.GONE);
        tvQuestion3.setVisibility(View.GONE);
        tvStyle3.setVisibility(View.GONE);
        rgStyle3.setVisibility(View.GONE);
        tvOption31.setVisibility(View.GONE);
        tvOption32.setVisibility(View.GONE);
        tvOption33.setVisibility(View.GONE);

        tvTitle4.setVisibility(View.GONE);
        tvQuestion4.setVisibility(View.GONE);
        tvStyle4.setVisibility(View.GONE);
        rgStyle4.setVisibility(View.GONE);
        tvOption41.setVisibility(View.GONE);
        tvOption42.setVisibility(View.GONE);
        tvOption43.setVisibility(View.GONE);

        tvTitle5.setVisibility(View.GONE);
        tvQuestion5.setVisibility(View.GONE);
        tvStyle5.setVisibility(View.GONE);
        rgStyle5.setVisibility(View.GONE);
        tvOption51.setVisibility(View.GONE);
        tvOption52.setVisibility(View.GONE);
        tvOption53.setVisibility(View.GONE);
        //a continue button
        final Button bContinue = (Button) findViewById(R.id.bContinue);

        bContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get the number of questions in the survey
                String sQuestionNumber = etQuestionNumber.getText().toString();
                final int QuestionNumber = Integer.parseInt(sQuestionNumber);

                //*****set display****
                bContinue.setVisibility(View.GONE);
                //tvQuestionNumber.setVisibility(View.GONE);
                //etQuestionNumber.setVisibility(View.GONE);
                if (QuestionNumber >= 1) {
                    tvTitle1.setVisibility(View.VISIBLE);
                    tvQuestion1.setVisibility(View.VISIBLE);
                    tvStyle1.setVisibility(View.VISIBLE);
                    rgStyle1.setVisibility(View.VISIBLE);
                    //tvOption11.setVisibility(View.VISIBLE);
                    //tvOption12.setVisibility(View.VISIBLE);
                    //tvOption13.setVisibility(View.VISIBLE);
                }
                if (QuestionNumber >= 2) {
                    tvTitle2.setVisibility(View.VISIBLE);
                    tvQuestion2.setVisibility(View.VISIBLE);
                    tvStyle2.setVisibility(View.VISIBLE);
                    rgStyle2.setVisibility(View.VISIBLE);

                }
                if (QuestionNumber >= 3) {
                    tvTitle3.setVisibility(View.VISIBLE);
                    tvQuestion3.setVisibility(View.VISIBLE);
                    tvStyle3.setVisibility(View.VISIBLE);
                    rgStyle3.setVisibility(View.VISIBLE);

                }
                if (QuestionNumber >= 4) {
                    tvTitle4.setVisibility(View.VISIBLE);
                    tvQuestion4.setVisibility(View.VISIBLE);
                    tvStyle4.setVisibility(View.VISIBLE);
                    rgStyle4.setVisibility(View.VISIBLE);


                }
                if (QuestionNumber == 5) {
                    tvTitle5.setVisibility(View.VISIBLE);
                    tvQuestion5.setVisibility(View.VISIBLE);
                    tvStyle5.setVisibility(View.VISIBLE);
                    rgStyle5.setVisibility(View.VISIBLE);
                    tvOption51.setVisibility(View.VISIBLE);
                    tvOption52.setVisibility(View.VISIBLE);
                    tvOption53.setVisibility(View.VISIBLE);
                }
                bUpload.setVisibility(View.VISIBLE);
            }
        });


        //********************radio group is clicked*********************
        rgStyle1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rbradioButtonOption:
                        tvOption11.setVisibility(View.VISIBLE);
                        tvOption12.setVisibility(View.VISIBLE);
                        tvOption13.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbTextBoxOption:
                        tvOption11.setVisibility(View.GONE);
                        tvOption12.setVisibility(View.GONE);
                        tvOption13.setVisibility(View.GONE);
                        break;
                }
            }
        });
        rgStyle2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rbradioButtonOptionTwo:
                        tvOption21.setVisibility(View.VISIBLE);
                        tvOption22.setVisibility(View.VISIBLE);
                        tvOption23.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbTextBoxOptionTwo:
                        tvOption21.setVisibility(View.GONE);
                        tvOption22.setVisibility(View.GONE);
                        tvOption23.setVisibility(View.GONE);
                        break;
                }
            }
        });
        rgStyle3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rbradioButtonOptionThree:
                        tvOption31.setVisibility(View.VISIBLE);
                        tvOption32.setVisibility(View.VISIBLE);
                        tvOption33.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbTextBoxOptionThree:
                        tvOption31.setVisibility(View.GONE);
                        tvOption32.setVisibility(View.GONE);
                        tvOption33.setVisibility(View.GONE);
                        break;
                }
            }
        });
        rgStyle4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rbradioButtonOptionFour:
                        tvOption41.setVisibility(View.VISIBLE);
                        tvOption42.setVisibility(View.VISIBLE);
                        tvOption43.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbTextBoxOptionFour:
                        tvOption41.setVisibility(View.GONE);
                        tvOption42.setVisibility(View.GONE);
                        tvOption43.setVisibility(View.GONE);
                        break;
                }
            }
        });
        rgStyle5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rbradioButtonOptionFive:
                        tvOption51.setVisibility(View.VISIBLE);
                        tvOption52.setVisibility(View.VISIBLE);
                        tvOption53.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbTextBoxOptionFive:
                        tvOption51.setVisibility(View.GONE);
                        tvOption52.setVisibility(View.GONE);
                        tvOption53.setVisibility(View.GONE);
                        break;
                }
            }
        });


        //*****upload button clicked******
        bUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get instance "NameOfSurvey", "QuestionOne" & "AnswerOne"
                String NameOfSurvey = etSurveyName.getText().toString();
                String type1 = "0";
                String type2 = "0";
                String type3 = "0";
                String type4 = "0";
                String type5 = "0";
                String Option11 = "";
                String Option12 = "";
                String Option13 = "";
                String Option21 = "";
                String Option22 = "";
                String Option23 = "";
                String Option31 = "";
                String Option32 = "";
                String Option33 = "";
                String Option41 = "";
                String Option42 = "";
                String Option43 = "";
                String Option51 = "";
                String Option52 = "";
                String Option53 = "";
                String Question1 = "";
                String Question2 = "";
                String Question3 = "";
                String Question4 = "";
                String Question5 = "";


                //the number of questions
                String sQuestionNumber = etQuestionNumber.getText().toString();
                final int QuestionNumber = Integer.parseInt(sQuestionNumber);
                if(QuestionNumber>=1) {
                    View style1 = rgStyle1.findViewById(rgStyle1.getCheckedRadioButtonId());
                    int indexStyle1 = rgStyle1.indexOfChild(style1);
                    Question1 = tvQuestion1.getText().toString();
                    if(indexStyle1 == 0){
                        type1 = "2";
                        Option11 = tvOption11.getText().toString();
                        Option12 = tvOption12.getText().toString();
                        Option13 = tvOption13.getText().toString();
                    }else{//text box
                        type1 = "1";
                    }
                }
                if(QuestionNumber>=2) {
                    View style2 = rgStyle2.findViewById(rgStyle2.getCheckedRadioButtonId());
                    int indexStyle2 = rgStyle2.indexOfChild(style2);
                    Question2 = tvQuestion2.getText().toString();
                    if(indexStyle2 == 0){
                        type2 = "2";
                        Option21 = tvOption21.getText().toString();
                        Option22 = tvOption22.getText().toString();
                        Option23 = tvOption23.getText().toString();
                    }else{//text box
                        type2 = "1";
                    }
                }
                if(QuestionNumber>=3) {
                    View style3 = rgStyle3.findViewById(rgStyle3.getCheckedRadioButtonId());
                    int indexStyle3 = rgStyle3.indexOfChild(style3);
                    Question3 = tvQuestion3.getText().toString();
                    if(indexStyle3 == 0){
                        type3 = "2";
                        Option31 = tvOption31.getText().toString();
                        Option32 = tvOption32.getText().toString();
                        Option33 = tvOption33.getText().toString();
                    }else{//text box
                        type3 = "1";
                    }
                }
                if(QuestionNumber>=4) {
                    View style4 = rgStyle4.findViewById(rgStyle4.getCheckedRadioButtonId());
                    int indexStyle4 = rgStyle4.indexOfChild(style4);
                    Question4 = tvQuestion4.getText().toString();
                    if(indexStyle4 == 0){
                        type4 = "2";
                        Option41 = tvOption41.getText().toString();
                        Option42 = tvOption42.getText().toString();
                        Option43 = tvOption43.getText().toString();
                    }else{//text box
                        type4 = "1";
                    }
                }
                if(QuestionNumber==5) {
                    View style5 = rgStyle5.findViewById(rgStyle5.getCheckedRadioButtonId());
                    int indexStyle5 = rgStyle5.indexOfChild(style5);
                    Question5 = tvQuestion5.getText().toString();
                    if(indexStyle5 == 0){
                        type5 = "2";
                        Option51 = tvOption51.getText().toString();
                        Option52 = tvOption52.getText().toString();
                        Option53 = tvOption53.getText().toString();
                    }else{//text box
                        type5 = "1";
                    }
                }



                Intent intent = getIntent();
                final String username = intent.getStringExtra("username");




                // Response received from php file (server)
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            String username = jsonResponse.getString("username");
                            if (success) {


                                Intent home = new Intent(SurveyCreation.this, HomeClientActivity.class);
                                home.putExtra("username", username);
                                SurveyCreation.this.startActivity(home);

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SurveyCreation.this);
                                builder.setMessage("Upload failed...")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(SurveyCreation.this);


                SurveyCreationRequest surveyCreationRequest = new SurveyCreationRequest(username, NameOfSurvey,
                        type1, Option11,Option12,Option13, Question1,
                        type2, Option21,Option22,Option23, Question2,
                        type3, Option31,Option32,Option33, Question3,
                        type4, Option41,Option42,Option43, Question4,
                        type5, Option51,Option52,Option53, Question5,
                        responseListener);
                queue.add(surveyCreationRequest);

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SurveyCreation Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.bboxxproject.bboxxsurveyapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SurveyCreation Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.bboxxproject.bboxxsurveyapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
