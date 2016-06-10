<?php
	//myhost, my_user, my_password, my_db
	//Returns an object which represents the connection to a MySQL Server. 
    $con = mysqli_connect("mysql9.000webhost.com", "a1339558_Lin", "bboxx2016", "a1339558_BBoxx");
    
	
	$response = array();
    //$response["success"] = false;  
	
	

	
	//READ POINTS FOR EACH PRODUCT
	$readpoints = mysqli_prepare($con, "SELECT LightBulbPoints, RadioPoints FROM RedeemRecord WHERE username = ?");
	mysqli_stmt_bind_param($readpoints, "s", $_POST["username"]);
	mysqli_stmt_execute($readpoints);
	//mysqli_stmt_store_result(readpoints);
	mysqli_stmt_bind_result($readpoints, $LightBulbPoints, $RadioPoints);
	
	
	

	
	
/*	
	if($_POST["checkbox1"]==1 && $_POST["checkbox2"]==1){
		//read user points
		$userpoints = mysqli_prepare($con, "SELECT points FROM user WHERE username = ?");
		mysqli_stmt_bind_param($userpoints, "s", $_POST["username"]);
		mysqli_stmt_execute($userpoints);
		mysqli_stmt_store_result(userpoints);
		mysqli_stmt_bind_result($userpoints, $user_points);//
		
		if($user_points >= $LightBulbPoints+$RadioPoints){
			//update record
			$updatecheckbox = mysqli_prepare($con, "UPDATE RedeemRecord SET LightBulb = LightBulb+1, Radio = Radio +1 WHERE username = ?");
			mysqli_stmt_bind_param($updatecheckbox, "s", $_POST["username"]);
			mysqli_stmt_execute($updatecheckbox);
			
			//reset user's points
			$resetpoints = mysqli_prepare($con, "UPDATE user SET points = points - ? - ? WHERE username = ?");
			mysqli_stmt_bind_param($resetpoints, "iis", $LightBulbPoints, $RadioPoints, $_POST["username"]);
			mysqli_stmt_execute($resetpoints);
			
			$response["success"] = true;
		}
		else{
			$response["success"] = false;  
		}
	}
	else if($_POST["checkbox1"]==1 && $_POST["checkbox2"]==0){
		//read user points
		$userpoints = mysqli_prepare($con, "SELECT points FROM user WHERE username = ?");
		mysqli_stmt_bind_param($userpoints, "s", $_POST["username"]);
		mysqli_stmt_execute($userpoints);
		mysqli_stmt_store_result(userpoints);
		mysqli_stmt_bind_result($userpoints, $user_points);//
		if($user_points >= $LightBulbPoints){
			//update record
			$updatecheckbox1 = mysqli_prepare($con, "UPDATE RedeemRecord SET LightBulb = LightBulb+1 WHERE username = ?");
			mysqli_stmt_bind_param($updatecheckbox1, "s", $_POST["username"]);
			mysqli_stmt_execute($updatecheckbox1);
			
			//reset user's points
			$resetpoints = mysqli_prepare($con, "UPDATE user SET points = points - ? WHERE username = ?");
			mysqli_stmt_bind_param($resetpoints, "is", $LightBulbPoints, $_POST["username"]);
			mysqli_stmt_execute($resetpoints);
			
			$response["success"] = true;
		}
		else{
			$response["success"] = false;  
		}
	}
	
	
	//*********************next checkbox******************
	else if($_POST["checkbox2"]==1 && $_POST["checkbox1"]==0){
		//read user points
		$userpoints = mysqli_prepare($con, "SELECT points FROM user WHERE username = ?");
		mysqli_stmt_bind_param($userpoints, "s", $_POST["username"]);
		mysqli_stmt_execute($userpoints);
		mysqli_stmt_store_result(userpoints);
		mysqli_stmt_bind_result($userpoints, $user_points);//

		if($user_points >= $RadioPoints){
			//update record
			$updatecheckbox2 = mysqli_prepare($con, "UPDATE RedeemRecord SET Radio = Radio+1 WHERE username = ?");
			mysqli_stmt_bind_param($updatecheckbox2, "s", $_POST["username"]);
			mysqli_stmt_execute($updatecheckbox2);
			//reset user's points
			$resetpoints = mysqli_prepare($con, "UPDATE user SET points = points - ? WHERE username = ?");
			mysqli_stmt_bind_param($resetpoints, "is", $RadioPoints, $_POST["username"]);
			mysqli_stmt_execute($resetpoints);
			
			$response["success"] = true; 

		}else{
			$response["success"] = false; 
		}
		
	}	
	*/
	while(mysqli_stmt_fetch($readpoints)){
		
	}
	
	
	/* close statement */
    mysqli_stmt_close($readpoints);
	
	
	if($_POST["checkbox1"]=="1"){
		//read user points
		$userpoints = mysqli_prepare($con, "SELECT points FROM user WHERE username = ?");
		mysqli_stmt_bind_param($userpoints, "s", $_POST["username"]);
		mysqli_stmt_execute($userpoints);
		mysqli_stmt_bind_result($userpoints, $user_points);//
		
		//while(mysqli_stmt_fetch($userpoints)){}
		
		if($user_points >= $LightBulbPoints){
			//update record
			$updatecheckbox1 = mysqli_prepare($con, "UPDATE RedeemRecord SET LightBulb = LightBulb+1 WHERE username = ?");
			mysqli_stmt_bind_param($updatecheckbox1, "s", $_POST["username"]);
			mysqli_stmt_execute($updatecheckbox1);
			
			//reset user's points
			$resetpoints = mysqli_prepare($con, "UPDATE user SET points = points - ? WHERE username = ?");
			mysqli_stmt_bind_param($resetpoints, "is", $LightBulbPoints, $_POST["username"]);
			mysqli_stmt_execute($resetpoints);
			
			$response["success"] = true;
		}
		else{
			$response["success"] = false;  
		}
	}else{
		$response["success"] = false; 
	}
	
	//Prepares the SQL query, and returns a statement handle to be used for further operations on the statement. The query must consist of a single SQL statement. 
    $showpoints = mysqli_prepare($con, "SELECT points FROM user WHERE username = ?");//select user from database
    
	//Bind variables for the parameter markers in the SQL statement that was passed to mysqli_prepare(). 
	mysqli_stmt_bind_param($showpoints, "s", $_POST["username"]);
	
	//Executes a query that has been previously prepared using the mysqli_prepare() function. 
	//When executed any parameter markers which exist will automatically be replaced with the appropriate data. 
	//Returns TRUE on success or FALSE on failure. 
    mysqli_stmt_execute($showpoints);
    
	//You must call mysqli_stmt_store_result() for every query that successfully produces a result set (SELECT, SHOW, DESCRIBE, EXPLAIN), 
	//if and only if you want to buffer the complete result set by the client, so that the subsequent mysqli_stmt_fetch() call returns buffered data.
    //mysqli_stmt_store_result($statement);

	//Binds columns in the result set to variables. 
    mysqli_stmt_bind_result($showpoints, $userspoints);//status for ownership duration? 
    
	
	while(mysqli_stmt_fetch($showpoints)){
		$response["points"] = $userspoints;
	}
    

	//echo Outputs all parameters. No additional newline is appended. 
	//json_encode — Returns the JSON representation of a value
    echo json_encode($response);
?>
