package com.bboxxproject.bboxxsurveyapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        final Intent intent = getIntent();
        int points = intent.getIntExtra("points",-1);
        //String username = intent.getStringExtra("username");
        //int age = intent.getIntExtra("age", -1);
        //int NumOfPending = intent.getIntExtra("NumOfPending", -1);

        //Integer.toString(NumOfPending);//++++not sure

        //final TextView textView1Points = (TextView) findViewById(R.id.textView1Points);
        final TextView tvRedeem = (TextView) findViewById(R.id.tvRedeem);
        final TextView tvNumPoints = (TextView) findViewById(R.id.tvNumPoints);//variable
        //final TextView textView2Points = (TextView) findViewById(R.id.textView2Points);

        final TextView tvRedeemRecord1 = (TextView) findViewById(R.id.tvRedeemRecord1);
        final TextView tvRedeemRecord2 = (TextView) findViewById(R.id.tvRedeemRecord2);
        final TextView tvRedeemRecord3 = (TextView) findViewById(R.id.tvRedeemRecord3);
        final TextView tvRedeemRecord4 = (TextView) findViewById(R.id.tvRedeemRecord4);
        final TextView tvRedeemRecord5 = (TextView) findViewById(R.id.tvRedeemRecord5);
        final TextView tvRedeemRecord6 = (TextView) findViewById(R.id.tvRedeemRecord6);
        final TextView tvNoRedeem = (TextView) findViewById(R.id.tvNoRedeem);
        final TextView tvRedeemSuccess = (TextView) findViewById(R.id.tvRedeemSuccess);

        final TextView tvPoints1 = (TextView) findViewById(R.id.tvPoints1);
        final CheckBox cbPoints1 = (CheckBox) findViewById(R.id.cbPoints1);
        final ImageView ivPoints = (ImageView) findViewById(R.id.ivPoints1);

        final Button bPoints = (Button) findViewById(R.id.bPoints);
        final Button bRedeemRecord = (Button) findViewById(R.id.bRedeemRecord);//record
        final Button bHome = (Button) findViewById(R.id.bHome);
        final Button bRedeem = (Button) findViewById(R.id.bRedeem);



        //default display
        //points
        tvRedeem.setVisibility(View.VISIBLE);
        tvNumPoints.setVisibility(View.VISIBLE);
        tvNumPoints.setText("You have "+ points+" points!");
        //redeem
        tvPoints1.setVisibility(View.GONE);
        cbPoints1.setVisibility(View.GONE);
        ivPoints.setVisibility(View.GONE);
        bRedeem.setVisibility(View.GONE);
        tvRedeemSuccess.setVisibility(View.GONE);
        //redeemhistory
        tvRedeemRecord1.setVisibility(View.GONE);
        tvRedeemRecord2.setVisibility(View.GONE);
        tvRedeemRecord3.setVisibility(View.GONE);
        tvRedeemRecord4.setVisibility(View.GONE);
        tvRedeemRecord5.setVisibility(View.GONE);
        tvRedeemRecord6.setVisibility(View.GONE);
        tvNoRedeem.setVisibility(View.GONE);




        bPoints.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                int points = intent.getIntExtra("points",-1);


                //text display
                tvNumPoints.setVisibility(View.VISIBLE);
                tvNumPoints.setText("You have "+ points+" points!");

                tvRedeem.setVisibility(View.VISIBLE);

                tvPoints1.setVisibility(View.GONE);
                cbPoints1.setVisibility(View.GONE);
                ivPoints.setVisibility(View.GONE);
                bRedeem.setVisibility(View.GONE);
                tvRedeemSuccess.setVisibility(View.GONE);

                tvRedeemRecord1.setVisibility(View.GONE);
                tvRedeemRecord2.setVisibility(View.GONE);
                tvRedeemRecord3.setVisibility(View.GONE);
                tvRedeemRecord4.setVisibility(View.GONE);
                tvRedeemRecord5.setVisibility(View.GONE);
                tvRedeemRecord6.setVisibility(View.GONE);
                tvNoRedeem.setVisibility(View.GONE);



                //intent for next activity
            }
        });

        //redeem page
        tvRedeem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //text display
                tvRedeem.setVisibility(View.GONE);
                tvNumPoints.setVisibility(View.GONE);
                //displaying a light bulb with points

                tvRedeemSuccess.setVisibility(View.GONE);

                tvRedeemRecord1.setVisibility(View.GONE);
                tvRedeemRecord2.setVisibility(View.GONE);
                tvRedeemRecord3.setVisibility(View.GONE);
                tvRedeemRecord4.setVisibility(View.GONE);
                tvRedeemRecord5.setVisibility(View.GONE);
                tvRedeemRecord6.setVisibility(View.GONE);
                tvNoRedeem.setVisibility(View.GONE);

                tvPoints1.setVisibility(View.VISIBLE);
                //display points required to redeem the product
                //get points 1 from database
                //tvPoints1.setText(points1)
                cbPoints1.setVisibility(View.VISIBLE);
                ivPoints.setVisibility(View.VISIBLE);
                bRedeem.setVisibility(View.VISIBLE);





                //intent for next activity
            }
        });





        //redeem button
        bRedeem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//redeem item checkbox
                String checkbox1 = "0";
                if(cbPoints1.isChecked()) {
                    checkbox1 = "1";
                }
                /*String checkbox2 = "0";
                if(cbPoints2.isChecked()) {
                    checkbox2 = "1";
                }*/


                //boolean checkbox2 = cbPoints2.isChecked();
                final String username = intent.getStringExtra("username");
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            int points = jsonResponse.getInt("points");

                            if (success) {
                                Integer.toString(points);
                                String message = "You have successfully redeemed an iteam!" +" Now you have " + points +" left";
                                tvRedeemSuccess.setVisibility(View.VISIBLE);
                                tvRedeemSuccess.setText(message);
                                //text display
                                tvRedeem.setVisibility(View.GONE);
                                tvNumPoints.setVisibility(View.GONE);
                                //displaying a light bulb with points
                                tvPoints1.setVisibility(View.GONE);
                                cbPoints1.setVisibility(View.GONE);
                                ivPoints.setVisibility(View.GONE);
                                bRedeem.setVisibility(View.GONE);
                                //successful
                                //tvRedeemSuccess.setVisibility(View.VISIBLE);

                                tvRedeemRecord1.setVisibility(View.GONE);
                                tvRedeemRecord2.setVisibility(View.GONE);
                                tvRedeemRecord3.setVisibility(View.GONE);
                                tvRedeemRecord4.setVisibility(View.GONE);
                                tvRedeemRecord5.setVisibility(View.GONE);
                                tvRedeemRecord6.setVisibility(View.GONE);
                                tvNoRedeem.setVisibility(View.GONE);
                            } else {
                                Integer.toString(points);
                                String message = "Sorry, you don't have enough points.. Only "+points+"points..";
                                tvRedeemSuccess.setVisibility(View.VISIBLE);
                                tvRedeemSuccess.setText(message);
                                //text display
                                tvRedeem.setVisibility(View.GONE);
                                tvNumPoints.setVisibility(View.GONE);
                                //displaying a light bulb with points
                                tvPoints1.setVisibility(View.GONE);
                                cbPoints1.setVisibility(View.GONE);
                                ivPoints.setVisibility(View.GONE);
                                bRedeem.setVisibility(View.GONE);
                                //successful
                                //tvRedeemSuccess.setVisibility(View.VISIBLE);

                                tvRedeemRecord1.setVisibility(View.GONE);
                                tvRedeemRecord2.setVisibility(View.GONE);
                                tvRedeemRecord3.setVisibility(View.GONE);
                                tvRedeemRecord4.setVisibility(View.GONE);
                                tvRedeemRecord5.setVisibility(View.GONE);
                                tvRedeemRecord6.setVisibility(View.GONE);
                                tvNoRedeem.setVisibility(View.GONE);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RedeemRequest redeemRequest = new RedeemRequest(username, checkbox1, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ProfileActivity.this);
                queue.add(redeemRequest);
            }


        });


        bRedeemRecord.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = intent.getStringExtra("username");




                //request for history
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String LightBulbStatus = jsonResponse.getString("LightBulbStatus");
                                String RadioStatus = jsonResponse.getString("RadioStatus");

                                int LightBulb = jsonResponse.getInt("LightBulb");
                                int Radio = jsonResponse.getInt("Radio");

                                Integer.toString(Radio);
                                Integer.toString(LightBulb);

                                //text display
                                tvRedeem.setVisibility(View.GONE);
                                tvNumPoints.setVisibility(View.GONE);
                                tvPoints1.setVisibility(View.GONE);
                                cbPoints1.setVisibility(View.GONE);
                                ivPoints.setVisibility(View.GONE);
                                bRedeem.setVisibility(View.GONE);
                                tvRedeemSuccess.setVisibility(View.GONE);

                                tvRedeemRecord1.setVisibility(View.VISIBLE);
                                tvRedeemRecord2.setVisibility(View.VISIBLE);
                                tvRedeemRecord3.setVisibility(View.VISIBLE);
                                tvRedeemRecord4.setVisibility(View.VISIBLE);
                                tvRedeemRecord5.setVisibility(View.VISIBLE);
                                tvRedeemRecord6.setVisibility(View.VISIBLE);
                                tvNoRedeem.setVisibility(View.GONE);
                                tvRedeemRecord4.setText(LightBulb);
                                tvRedeemRecord6.setText(Radio);

                            }else {
                                //if no item has been redeemed
                                //text display
                                tvRedeem.setVisibility(View.GONE);
                                tvNumPoints.setVisibility(View.GONE);
                                tvPoints1.setVisibility(View.GONE);
                                cbPoints1.setVisibility(View.GONE);
                                ivPoints.setVisibility(View.GONE);
                                bRedeem.setVisibility(View.GONE);
                                tvRedeemSuccess.setVisibility(View.GONE);

                                tvRedeemRecord1.setVisibility(View.GONE);
                                tvRedeemRecord2.setVisibility(View.GONE);
                                tvRedeemRecord3.setVisibility(View.GONE);
                                tvRedeemRecord4.setVisibility(View.GONE);
                                tvRedeemRecord5.setVisibility(View.GONE);
                                tvRedeemRecord6.setVisibility(View.GONE);
                                tvNoRedeem.setVisibility(View.VISIBLE);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RedeemRecordRequest redeemRecordRequest = new RedeemRecordRequest(username, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ProfileActivity.this);
                queue.add(redeemRecordRequest);


            }
        });


        bHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //get instance "username" & "password"
                Intent intent = getIntent();
                final String username = intent.getStringExtra("username");
                //final String password = etPassword.getText().toString();

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
                                String username = jsonResponse.getString("username");

                                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                                intent.putExtra("points",points);
                                intent.putExtra("name", name);
                                intent.putExtra("age", age);
                                intent.putExtra("username", username);
                                intent.putExtra("NumOfPending", NumOfPending);//number of pending survey
                                ProfileActivity.this.startActivity(intent);

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                                builder.setMessage("Connection failed...")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                HomeRequest homeRequest = new HomeRequest(username, responseListener);//note we passed username
                RequestQueue queue = Volley.newRequestQueue(ProfileActivity.this);
                queue.add(homeRequest);
            }
        });


    }
}
