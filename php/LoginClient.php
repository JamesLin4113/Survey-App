<?php
	//myhost, my_user, my_password, my_db
	//Returns an object which represents the connection to a MySQL Server. 
    $con = mysqli_connect("mysql9.000webhost.com", "a1339558_Lin", "bboxx2016", "a1339558_BBoxx");
    

	//Prepares the SQL query, and returns a statement handle to be used for further operations on the statement. The query must consist of a single SQL statement. 
    $statement = mysqli_prepare($con, "SELECT * FROM client WHERE username = ? AND password = ?");//select user from database
    
	//Bind variables for the parameter markers in the SQL statement that was passed to mysqli_prepare(). 
	mysqli_stmt_bind_param($statement, "ss", $_POST["username"], $_POST["password"]);
	
	//Executes a query that has been previously prepared using the mysqli_prepare() function. 
	//When executed any parameter markers which exist will automatically be replaced with the appropriate data. 
	//Returns TRUE on success or FALSE on failure. 
    mysqli_stmt_execute($statement);
    
	//You must call mysqli_stmt_store_result() for every query that successfully produces a result set (SELECT, SHOW, DESCRIBE, EXPLAIN), 
	//if and only if you want to buffer the complete result set by the client, so that the subsequent mysqli_stmt_fetch() call returns buffered data.
    mysqli_stmt_store_result($statement);
	
	//Binds columns in the result set to variables. 
    mysqli_stmt_bind_result($statement, $name, $username, $password, $companyname, $email, $contactnumber, $country);
    
    $response = array();
    $response["success"] = false;  
    
	//returns everything from the database
    while(mysqli_stmt_fetch($statement)){//Fetch the result from a prepared statement into the variables bound by mysqli_stmt_bind_result().
        $response["success"] = true;  
        $response["name"] = $name;
        $response["companyname"] = $companyname;
        $response["username"] = $username;
        $response["password"] = $password;
		$response["email"] = $email;//****pending
		$response["contactnumber"] = $contactnumber;
		$response["country"] = $country;
		//****update number of pending survey*****	
	    }
    
	//echo Outputs all parameters. No additional newline is appended. 
	//json_encode — Returns the JSON representation of a value
    echo json_encode($response);
?>
