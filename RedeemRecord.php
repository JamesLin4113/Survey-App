<?php
	//myhost, my_user, my_password, my_db
	//Returns an object which represents the connection to a MySQL Server. 
    $con = mysqli_connect("mysql9.000webhost.com", "a1339558_Lin", "bboxx2016", "a1339558_BBoxx");
    
	
	//Prepares the SQL query, and returns a statement handle to be used for further operations on the statement. The query must consist of a single SQL statement. 
    $statement = mysqli_prepare($con, "SELECT * FROM RedeemRecord WHERE username = ?");//select user from database
    
	//Bind variables for the parameter markers in the SQL statement that was passed to mysqli_prepare(). 
	mysqli_stmt_bind_param($statement, "s", $_POST["username"]);
	
	//Executes a query that has been previously prepared using the mysqli_prepare() function. 
	//When executed any parameter markers which exist will automatically be replaced with the appropriate data. 
	//Returns TRUE on success or FALSE on failure. 
    mysqli_stmt_execute($statement);
    
	//You must call mysqli_stmt_store_result() for every query that successfully produces a result set (SELECT, SHOW, DESCRIBE, EXPLAIN), 
	//if and only if you want to buffer the complete result set by the client, so that the subsequent mysqli_stmt_fetch() call returns buffered data.
    mysqli_stmt_store_result($statement);
	
	//Binds columns in the result set to variables. 
    mysqli_stmt_bind_result($statement, $username, $LightBulb, $LightBulbPoints, $LightBulbStatus, $Radio, $RadioPoints, $RadioStatus);//status for ownership duration? 
    
    $response = array();
    $response["success"] = false;  
    
	//returns everything from the database
    while(mysqli_stmt_fetch($statement)){//Fetch the result from a prepared statement into the variables bound by mysqli_stmt_bind_result().
        $response["success"] = true;  
        $response["LightBulb"] = $LightBulb;
		$response["LightBulbPoints"] = $LightBulbPoints;
        $response["LightBulbStatus"] = $LightBulbStatus;
        $response["Radio"] = $Radio;
        $response["RadioPoints"] = $RadioPoints;
		$response["RadioStatus"] = $RadioStatus;
		
		
		//****update number of pending survey*****	
	    }
    
	//echo Outputs all parameters. No additional newline is appended. 
	//json_encode — Returns the JSON representation of a value
    echo json_encode($response);
?>
