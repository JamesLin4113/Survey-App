package com.bboxxproject.bboxxsurveyapp;

import android.app.AlertDialog;
import android.content.Intent;
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

import org.json.JSONException;
import org.json.JSONObject;

public class SurveyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);


        //******************get intent from previous activities*********************
        //******************get intent from previous activities*********************
        //******************get intent from previous activities*********************
        Intent intent = getIntent();

        //String username = intent.getStringExtra("username");
        String NameOfSurvey = intent.getStringExtra("NameOfSurvey");

        String QuestionOne = intent.getStringExtra("QuestionOne");
        String QuestionTwo = intent.getStringExtra("QuestionTwo");
        String QuestionThree = intent.getStringExtra("QuestionThree");
        String QuestionFour = intent.getStringExtra("QuestionFour");
        String QuestionFive = intent.getStringExtra("QuestionFive");
        String[] Questions = new String[] {QuestionOne,QuestionTwo, QuestionThree, QuestionFour, QuestionFive};

        String TextAnswerOne = intent.getStringExtra("TextAnswerOne");
        String TextAnswerTwo = intent.getStringExtra("TextAnswerTwo");
        String TextAnswerThree = intent.getStringExtra("TextAnswerThree");
        String TextAnswerFour = intent.getStringExtra("TextAnswerFour");
        String TextAnswerFive = intent.getStringExtra("TextAnswerFive");
        String[] TextAnswers = new String[] {TextAnswerOne,TextAnswerTwo, TextAnswerThree, TextAnswerFour, TextAnswerFive};

        String RadioAnswerOneOne = intent.getStringExtra("RadioAnswerOneOne");
        String RadioAnswerOneTwo = intent.getStringExtra("RadioAnswerOneTwo");
        String RadioAnswerOneThree = intent.getStringExtra("RadioAnswerOneThree");
        String[] RadioAnswersOne = new String[] {RadioAnswerOneOne,RadioAnswerOneTwo,RadioAnswerOneThree};
        String RadioAnswerTwoOne = intent.getStringExtra("RadioAnswerTwoOne");
        String RadioAnswerTwoTwo = intent.getStringExtra("RadioAnswerTwoTwo");
        String RadioAnswerTwoThree = intent.getStringExtra("RadioAnswerTwoThree");
        String[] RadioAnswersTwo = new String[] {RadioAnswerTwoOne,RadioAnswerTwoTwo,RadioAnswerTwoThree};
        String RadioAnswerThreeOne = intent.getStringExtra("RadioAnswerThreeOne");
        String RadioAnswerThreeTwo = intent.getStringExtra("RadioAnswerThreeTwo");
        String RadioAnswerThreeThree = intent.getStringExtra("RadioAnswerThreeThree");
        String[] RadioAnswersThree = new String[] {RadioAnswerThreeOne,RadioAnswerThreeTwo,RadioAnswerThreeThree};
        String RadioAnswerFourOne = intent.getStringExtra("RadioAnswerFourOne");
        String RadioAnswerFourTwo = intent.getStringExtra("RadioAnswerFourTwo");
        String RadioAnswerFourThree = intent.getStringExtra("RadioAnswerFourThree");
        String[] RadioAnswersFour = new String[] {RadioAnswerFourOne,RadioAnswerFourTwo,RadioAnswerFourThree};
        String RadioAnswerFiveOne = intent.getStringExtra("RadioAnswerFiveOne");
        String RadioAnswerFiveTwo = intent.getStringExtra("RadioAnswerFiveTwo");
        String RadioAnswerFiveThree = intent.getStringExtra("RadioAnswerFiveThree");
        String[] RadioAnswersFive = new String[] {RadioAnswerFiveOne,RadioAnswerFiveTwo,RadioAnswerFiveThree};
        String[][] RadioAnswers = new String[][] {RadioAnswersOne, RadioAnswersTwo, RadioAnswersThree, RadioAnswersFour, RadioAnswersFive};

        final int type1 = intent.getIntExtra("type1", 0);//0 is the defalut value if type cannot be fetched
        final int type2 = intent.getIntExtra("type2", 0);//0 is the defalut value if type cannot be fetched
        final int type3 = intent.getIntExtra("type3", 0);//0 is the defalut value if type cannot be fetched
        final int type4 = intent.getIntExtra("type4", 0);//0 is the defalut value if type cannot be fetched
        final int type5 = intent.getIntExtra("type5", 0);//0 is the defalut value if type cannot be fetched
        final int[] type = new int[] {type1, type2, type3, type4, type5};


        //***********set up the layout fragments************
        //***********set up the layout fragments************
        //***********set up the layout fragments************
        //***********set up the layout fragments************
        //***********set up the layout fragments************
        final TextView tvNameOfSurvey = (TextView) findViewById(R.id.tvNameOfSurvey);

        final TextView tvQuestionOne = (TextView) findViewById(R.id.tvQuestionOne);
        final TextView tvQuestionTwo = (TextView) findViewById(R.id.tvQuestionTwo);//not used yet
        final TextView tvQuestionThree = (TextView) findViewById(R.id.tvQuestionThree);
        final TextView tvQuestionFour = (TextView) findViewById(R.id.tvQuestionFour);
        final TextView tvQuestionFive = (TextView) findViewById(R.id.tvQuestionFive);
        final TextView[] tvQuestions = new TextView[] {tvQuestionOne,tvQuestionTwo,tvQuestionThree,tvQuestionFour,tvQuestionFive};

        final TextView tvTextAnswerOne = (TextView) findViewById(R.id.tvTextAnswerOne);
        final TextView tvTextAnswerTwo = (TextView) findViewById(R.id.tvTextAnswerTwo);
        final TextView tvTextAnswerThree = (TextView) findViewById(R.id.tvTextAnswerThree);
        final TextView tvTextAnswerFour = (TextView) findViewById(R.id.tvTextAnswerFour);
        final TextView tvTextAnswerFive = (TextView) findViewById(R.id.tvTextAnswerFive);
        final TextView[] tvTextAnswers = new TextView[] {tvTextAnswerOne,tvTextAnswerTwo,tvTextAnswerThree,tvTextAnswerFour,tvTextAnswerFive};


        final Button bComplete = (Button) findViewById(R.id.bComplete);
        //final TextView tvUsername = (TextView) findViewById(R.id.tvUsername);

        final RadioButton rbRadioAnswerOneOne = (RadioButton) findViewById(R.id.rbRadioAnswerOneOne);
        final RadioButton rbRadioAnswerOneTwo = (RadioButton) findViewById(R.id.rbRadioAnswerOneTwo);
        final RadioButton rbRadioAnswerOneThree = (RadioButton) findViewById(R.id.rbRadioAnswerOneThree);
        final RadioButton[] group1Buttons= new RadioButton[] {rbRadioAnswerOneOne,rbRadioAnswerOneTwo,rbRadioAnswerOneThree};

        final RadioButton rbRadioAnswerTwoOne = (RadioButton) findViewById(R.id.rbRadioAnswerTwoOne);
        final RadioButton rbRadioAnswerTwoTwo = (RadioButton) findViewById(R.id.rbRadioAnswerTwoTwo);
        final RadioButton rbRadioAnswerTwoThree = (RadioButton) findViewById(R.id.rbRadioAnswerTwoThree);
        final RadioButton[] group2Buttons= new RadioButton[] {rbRadioAnswerTwoOne,rbRadioAnswerTwoTwo,rbRadioAnswerTwoThree};

        final RadioButton rbRadioAnswerThreeOne = (RadioButton) findViewById(R.id.rbRadioAnswerThreeOne);
        final RadioButton rbRadioAnswerThreeTwo = (RadioButton) findViewById(R.id.rbRadioAnswerThreeTwo);
        final RadioButton rbRadioAnswerThreeThree = (RadioButton) findViewById(R.id.rbRadioAnswerThreeThree);
        final RadioButton[] group3Buttons= new RadioButton[] {rbRadioAnswerThreeOne,rbRadioAnswerThreeTwo,rbRadioAnswerThreeThree};

        final RadioButton rbRadioAnswerFourOne = (RadioButton) findViewById(R.id.rbRadioAnswerFourOne);
        final RadioButton rbRadioAnswerFourTwo = (RadioButton) findViewById(R.id.rbRadioAnswerFourTwo);
        final RadioButton rbRadioAnswerFourThree = (RadioButton) findViewById(R.id.rbRadioAnswerFourThree);
        final RadioButton[] group4Buttons= new RadioButton[] {rbRadioAnswerFourOne,rbRadioAnswerFourTwo,rbRadioAnswerFourThree};

        final RadioButton rbRadioAnswerFiveOne = (RadioButton) findViewById(R.id.rbRadioAnswerFiveOne);
        final RadioButton rbRadioAnswerFiveTwo = (RadioButton) findViewById(R.id.rbRadioAnswerFiveTwo);
        final RadioButton rbRadioAnswerFiveThree = (RadioButton) findViewById(R.id.rbRadioAnswerFiveThree);
        final RadioButton[] group5Buttons= new RadioButton[] {rbRadioAnswerFiveOne,rbRadioAnswerFiveTwo,rbRadioAnswerFiveThree};

        final RadioButton[][] groupsButtons = new RadioButton[][] {group1Buttons,group2Buttons,group3Buttons,group4Buttons,group5Buttons};

        final RadioGroup rgAnswerOne = (RadioGroup) findViewById(R.id.rgAnswerOne);
        final RadioGroup rgAnswerTwo = (RadioGroup) findViewById(R.id.rgAnswerTwo);
        final RadioGroup rgAnswerThree = (RadioGroup) findViewById(R.id.rgAnswerThree);
        final RadioGroup rgAnswerFour = (RadioGroup) findViewById(R.id.rgAnswerFour);
        final RadioGroup rgAnswerFive = (RadioGroup) findViewById(R.id.rgAnswerFive);
        final RadioGroup[] rgAnswers = new RadioGroup[] {rgAnswerOne, rgAnswerTwo, rgAnswerThree, rgAnswerFour, rgAnswerFive};

        // ******************************************Display****************************************
        // ******************************************Display****************************************
        // ******************************************Display****************************************
        // ******************************************Display****************************************
        // ******************************************Display****************************************
        tvNameOfSurvey.setText(NameOfSurvey);
        for(int i=0; i<type.length; i++) {
            if (type[i] == 0) {
                rgAnswers[i].setVisibility(View.GONE);//make radio group disappear
                tvQuestions[i].setVisibility(View.GONE);//make questions disappear
                tvTextAnswers[i].setVisibility(View.GONE);//make text answer boxes disappear
            }else if(type[i] == 1){//text
                tvQuestions[i].setText(Questions[i]);
                tvTextAnswers[i].setText(TextAnswers[i]);
                rgAnswers[i].setVisibility(View.GONE);


            }else {//radio buttons
                tvQuestions[i].setText(Questions[i]);
                for (int k = 0; k < 3; k++) {
                    groupsButtons[i][k].setText(RadioAnswers[i][k]);
                }
                tvTextAnswers[i].setVisibility(View.GONE);
            }
        }

        //********************radio group is clicked*********************
        //********************radio group is clicked*********************
        //********************radio group is clicked*********************
        //********************radio group is clicked*********************
        //********************radio group is clicked*********************
        rgAnswers[0].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButtonGroup1 = (RadioButton) findViewById(checkedId);
                //String text = checkedRadioButtonGroup1.getId() + " ";
                String text = checkedId + "";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                //a message box pops up at the bottom of the screen
            }
        });
        rgAnswers[1].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButtonGroup1 = (RadioButton) findViewById(checkedId);
                //String text = checkedRadioButtonGroup1.getId() + " ";
                String text = checkedId + "";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                //a message box pops up at the bottom of the screen
            }
        });
        rgAnswers[2].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButtonGroup1 = (RadioButton) findViewById(checkedId);
                //String text = checkedRadioButtonGroup1.getId() + " ";
                String text = checkedId + "";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                //a message box pops up at the bottom of the screen
            }
        });
        rgAnswers[3].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButtonGroup1 = (RadioButton) findViewById(checkedId);
                //String text = checkedRadioButtonGroup1.getId() + " ";
                String text = checkedId + "";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                //a message box pops up at the bottom of the screen
            }
        });
        rgAnswers[4].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButtonGroup1 = (RadioButton) findViewById(checkedId);
                //String text = checkedRadioButtonGroup1.getId() + " ";
                String text = checkedId + "";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                //a message box pops up at the bottom of the screen
            }
        });

        //**********************Click on Complete Survey Button***********************
        //**********************Click on Complete Survey Button***********************
        //**********************Click on Complete Survey Button***********************
        bComplete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                final String username = intent.getStringExtra("username");
                String NameOfSurvey = tvNameOfSurvey.getText().toString();

                String TextAnswerOne = "";
                String TextAnswerTwo = "";
                String TextAnswerThree = "";
                String TextAnswerFour = "";
                String TextAnswerFive = "";

                String group1Answer = "";
                String group2Answer = "";
                String group3Answer = "";
                String group4Answer = "";
                String group5Answer = "";

                if(type1!=0) {
                    if (type1 == 1) {
                        TextAnswerOne = tvTextAnswerOne.getText().toString();
                    } else if (type1 == 2) {
                        RadioButton Group1Answer = (RadioButton) rgAnswerOne.findViewById(rgAnswerOne.getCheckedRadioButtonId());
                        group1Answer = Group1Answer.getText().toString();
                    }
                }
                if(type2!=0) {
                    if (type2 == 1) {
                        TextAnswerTwo = tvTextAnswerTwo.getText().toString();
                    } else if (type2 == 2) {
                        RadioButton Group2Answer = (RadioButton) rgAnswerTwo.findViewById(rgAnswerTwo.getCheckedRadioButtonId());
                        group2Answer = Group2Answer.getText().toString();
                    }
                }
                if(type3!=0) {
                    if (type3 == 1) {
                        TextAnswerThree = tvTextAnswerThree.getText().toString();
                    } else if (type3 == 2) {
                        final RadioButton Group3Answer = (RadioButton) rgAnswerThree.findViewById(rgAnswerThree.getCheckedRadioButtonId());
                        group3Answer = Group3Answer.getText().toString();
                    }
                }
                if(type4!=0) {
                    if (type4 == 1) {
                        TextAnswerFour = tvTextAnswerFour.getText().toString();
                    } else if (type4 == 2) {
                        final RadioButton Group4Answer = (RadioButton) rgAnswerFour.findViewById(rgAnswerFour.getCheckedRadioButtonId());
                        group4Answer = Group4Answer.getText().toString();
                    }
                }
                if(type5!=0) {
                    if (type5 == 1) {
                        TextAnswerFive = tvTextAnswerFive.getText().toString();
                    } else if (type5 == 2) {
                        final RadioButton Group5Answer = (RadioButton) rgAnswerFive.findViewById(rgAnswerFive.getCheckedRadioButtonId());
                        group5Answer = Group5Answer.getText().toString();
                    }
                }








                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                String name = jsonResponse.getString("name");
                                int age = jsonResponse.getInt("age");
                                int NumOfPending = jsonResponse.getInt("NumOfPending");
                                int points = jsonResponse.getInt("points");

                                Intent intent = new Intent(SurveyActivity.this, HomeActivity.class);
                                intent.putExtra("points",points);
                                //String username = jsonResponse.getString("username");
                                //put data into intent and pass them to HomeActivity
                                intent.putExtra("name", name);
                                intent.putExtra("age", age);
                                intent.putExtra("username", username);
                                intent.putExtra("NumOfPending", NumOfPending);//number of pending survey
                                SurveyActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SurveyActivity.this);
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
                RequestQueue queue = Volley.newRequestQueue(SurveyActivity.this);
                DoneSurveyRequest doneSurveyRequest = new DoneSurveyRequest(username, NameOfSurvey,
                        type1, TextAnswerOne,group1Answer,
                        type2, TextAnswerTwo,group2Answer,
                        type3, TextAnswerThree,group3Answer,
                        type4, TextAnswerFour,group4Answer,
                        type5, TextAnswerFive,group5Answer,
                        responseListener);
                queue.add(doneSurveyRequest);
            }

        });




/*
        if(type1 == 1){//text
            String TextAnswerOne = intent.getStringExtra("TextAnswerOne");
            //display
            tvTextAnswerOne.setText(TextAnswerOne);
            rgAnswerOne.setVisibility(View.GONE);




            //complete click listener (It goes back to Home activity when it's clicked)
            bComplete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //get instance "NameOfSurvey", "QuestionOne" & "AnswerOne"
                    final String NameOfSurvey = tvNameOfSurvey.getText().toString();
                    Intent intent = getIntent();//
                    final String username = intent.getStringExtra("username");//
                    final String TextAnswerOne = tvTextAnswerOne.getText().toString();

                    final String group1Answer = "";
                    final int type = 1;


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
                                    int NumOfPending = jsonResponse.getInt("NumOfPending");
                                    int points = jsonResponse.getInt("points");

                                    Intent intent = new Intent(SurveyActivity.this, HomeActivity.class);
                                    intent.putExtra("points",points);
                                    //String username = jsonResponse.getString("username");
                                    //put data into intent and pass them to HomeActivity
                                    intent.putExtra("name", name);
                                    intent.putExtra("age", age);
                                    intent.putExtra("username", username);
                                    intent.putExtra("NumOfPending", NumOfPending);//number of pending survey
                                    SurveyActivity.this.startActivity(intent);

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(SurveyActivity.this);
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
                    RequestQueue queue = Volley.newRequestQueue(SurveyActivity.this);


                    DoneSurveyRequest doneSurveyRequest = new DoneSurveyRequest(username, NameOfSurvey, type, TextAnswerOne, group1Answer, responseListener);
                    queue.add(doneSurveyRequest);

                }
            });

            //put another onclickListener
        }
        else if(type1 == 2){//radio button
            String RadioAnswerOneOne = intent.getStringExtra("RadioAnswerOneOne");
            String RadioAnswerOneTwo = intent.getStringExtra("RadioAnswerOneTwo");
            String RadioAnswerOneThree = intent.getStringExtra("RadioAnswerOneThree");

            rbRadioAnswerOneOne.setText(RadioAnswerOneOne);
            rbRadioAnswerOneTwo.setText(RadioAnswerOneTwo);
            rbRadioAnswerOneThree.setText(RadioAnswerOneThree);
            tvTextAnswerOne.setVisibility(View.GONE);



            //radio group one
            rgAnswerOne.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId)
                {
                    RadioButton checkedRadioButtonGroup1 = (RadioButton) findViewById(checkedId);
                    //String text = checkedRadioButtonGroup1.getId() + " ";
                    String text = checkedId + "";
                    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                    //a message box pops up at the bottom of the screen
                }
            });

            //get selected radio button
            //RadioButton group1Answer = (RadioButton) rgAnswerOne.findViewById(rgAnswerOne.getCheckedRadioButtonId());

            //complete click listener (It goes back to Home activity when it's clicked)
            bComplete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //get instance "NameOfSurvey", "QuestionOne" & "AnswerOne"
                    final String NameOfSurvey = tvNameOfSurvey.getText().toString();
                    Intent intent = getIntent();
                    final String username = intent.getStringExtra("username");
                    final String TextAnswerOne = tvTextAnswerOne.getText().toString();

                    //get selected radio button
                    final RadioButton Group1Answer = (RadioButton) rgAnswerOne.findViewById(rgAnswerOne.getCheckedRadioButtonId());
                    final String group1Answer = Group1Answer.getText().toString();

                    final int type =2;


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
                                    int NumOfPending = jsonResponse.getInt("NumOfPending");

                                    Intent intent = new Intent(SurveyActivity.this, HomeActivity.class);

                                    //String username = jsonResponse.getString("username");
                                    //put data into intent and pass them to HomeActivity
                                    intent.putExtra("name", name);
                                    intent.putExtra("age", age);
                                    intent.putExtra("username", username);
                                    intent.putExtra("NumOfPending", NumOfPending);//number of pending survey
                                    SurveyActivity.this.startActivity(intent);

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(SurveyActivity.this);
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
                    RequestQueue queue = Volley.newRequestQueue(SurveyActivity.this);


                    DoneSurveyRequest doneSurveyRequest = new DoneSurveyRequest(username, NameOfSurvey, type, TextAnswerOne, group1Answer, responseListener);
                    queue.add(doneSurveyRequest);

                }
            });
        }else{
            //do nothing
        }
*/


/*
        //complete click listener (It goes back to Home activity when it's clicked)
        bComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get instance "NameOfSurvey", "QuestionOne" & "AnswerOne"
                final String NameOfSurvey = etNameOfSurvey.getText().toString();
                final String QuestionOne = etQuestionOne.getText().toString();
                final String AnswerOne = tvTextAnswerOne.getText().toString();
                final String username = tvUsername.getText().toString();


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
                                int NumOfPending = jsonResponse.getInt("NumOfPending");

                                Intent intent = new Intent(SurveyActivity.this, HomeActivity.class);

                                //String username = jsonResponse.getString("username");
                                //put data into intent and pass them to HomeActivity
                                intent.putExtra("name", name);
                                intent.putExtra("age", age);
                                intent.putExtra("username", username);
                                intent.putExtra("NumOfPending", NumOfPending);//number of pending survey
                                SurveyActivity.this.startActivity(intent);

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SurveyActivity.this);
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
                RequestQueue queue = Volley.newRequestQueue(SurveyActivity.this);


                DoneSurveyRequest doneSurveyRequest = new DoneSurveyRequest(username, NameOfSurvey, AnswerOne, responseListener);
                queue.add(doneSurveyRequest);

            }
        });*/


    }
}
