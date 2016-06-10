package com.bboxxproject.bboxxsurveyapp;

/**
 * Created by Lizhang on 13/05/2016.
 */
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

//this class makes request from Register.php file from the server and get response as string (which is why we are specifying string request)
public class RegisterClientRequest extends StringRequest{

    //we need to specify the URL where Register.php file is linked to
    private static final String REGISTER_REQUEST_URL = "http://bboxxproject.comxa.com/RegisterClient.php";//*****

    private Map<String, String> params;

    //create a constructor (the first method that runs when an instance of this class is created)
    //*************we probably need to swap age and username in the parameters
    public RegisterClientRequest(String name, String CompanyName, String ClientEmail, String ClientUsername, String ClientPassword, String ContactNumber, String Country, Response.Listener<String> listener) {//the parameters this constructor asks for
        //method.post sends some data to the php file
        //listener is when the volley has finished with the request, it's going to inform this listener here.
        //We also needs to give an error listener, however, we dont care in this case, so just put NULL.
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);

        params = new HashMap<>();
        params.put("name", name);
        params.put("companyname", CompanyName);
        params.put("email", ClientEmail);
        params.put("username", ClientUsername);
        params.put("password", ClientPassword);
        params.put("contactnumber", ContactNumber);
        params.put("country", Country);
        //keep in mind that we need to add a string here to convert an integer to a string
    }

    //when the volley is executed, it will get params
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}