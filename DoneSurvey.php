<?php
	//myhost, my_user, my_password, my_db
	//Returns an object which represents the connection to a MySQL Server. 
    $con = mysqli_connect("mysql9.000webhost.com", "a1339558_Lin", "bboxx2016", "a1339558_BBoxx");
    
	$response = array();
	$response["success"] = false;  
	
	/*
ALTER TABLE `PendingSurvey` ADD `QuestionFour` VARCHAR( 64 ) NOT NULL ,
ADD `type4` INT( 11 ) NOT NULL ,
ADD `TextAnswerFour` VARCHAR( 64 ) NOT NULL ,
ADD `RadioAnswerFourOne` VARCHAR( 64 ) NOT NULL ,
ADD `RadioAnswerFourTwo` VARCHAR( 64 ) NOT NULL ,
ADD `RadioAnswerFourThree` VARCHAR( 64 ) NOT NULL ,
ADD `group4Answer` VARCHAR( 64 ) NOT NULL ;
ALTER TABLE `PendingSurvey` ADD `QuestionFive` VARCHAR( 64 ) NOT NULL ,
ADD `type5` INT( 11 ) NOT NULL ,
ADD `TextAnswerFive` VARCHAR( 64 ) NOT NULL ,
ADD `RadioAnswerFiveOne` VARCHAR( 64 ) NOT NULL ,
ADD `RadioAnswerFiveTwo` VARCHAR( 64 ) NOT NULL ,
ADD `RadioAnswerFiveThree` VARCHAR( 64 ) NOT NULL ,
ADD `group5Answer` VARCHAR( 64 ) NOT NULL ;
	*/
/*
	
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET group1Answer = ?  WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["group1Answer"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);
		
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET group2Answer = ?  WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["group2Answer"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);
	
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET group3Answer = ?  WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["group3Answer"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);
		
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET TextAnswerFour = ? WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["TextAnswerFour"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);

		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET TextAnswerFive = ? WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["TextAnswerFive"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);

	
	*/
	if($_POST["type1"] == "1"){ //textbox
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET TextAnswerOne = ? WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["TextAnswerOne"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);
		
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET TextAnswerOne = ? WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["TextAnswerOne"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);
		
		

    }
	else if($_POST["type1"] == "2"){//radio button
	
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET group1Answer = ?  WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["group1Answer"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);
		
	}
	if($_POST["type2"] == "1"){ //textbox
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET TextAnswerTwo = ? WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["TextAnswerTwo"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);

    }
	else if($_POST["type2"] == "2"){//radio button
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET group2Answer = ?  WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["group2Answer"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);
	
	}
	if($_POST["type3"] == "1"){ //textbox
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET TextAnswerThree = ? WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["TextAnswerThree"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);
    
	}
	else if($_POST["type3"] == "2"){//radio button
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET group3Answer = ?  WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["group3Answer"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);
		
	}
	if($_POST["type4"] == "1"){ //textbox
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET TextAnswerFour = ? WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["TextAnswerFour"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);

    }
	else if($_POST["type4"] == "2"){//radio button
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET group4Answer = ?  WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["group4Answer"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);
	
	}
	if($_POST["type5"] == "1"){ //textbox
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET TextAnswerFive = ? WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["TextAnswerFive"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);

    }
	else if($_POST["type5"] == "2"){//radio button
		$update = mysqli_prepare($con, "UPDATE PendingSurvey SET group5Answer = ?  WHERE NameOfSurvey = ?");
		mysqli_stmt_bind_param($update, "ss", $_POST["group5Answer"], $_POST["NameOfSurvey"]);
		mysqli_stmt_execute($update);

	}




	$copy = mysqli_prepare($con, "INSERT INTO CompletedSurvey SELECT * FROM PendingSurvey WHERE NameOfSurvey = ?");
	mysqli_stmt_bind_param($copy, "s", $_POST["NameOfSurvey"]);
	mysqli_stmt_execute($copy);

	$delete = mysqli_prepare($con, "DELETE FROM PendingSurvey WHERE NameOfSurvey = ?");
	mysqli_stmt_bind_param($delete, "s", $_POST["NameOfSurvey"]);
	mysqli_stmt_execute($delete);
	
	$num = mysqli_prepare($con, "UPDATE user SET NumOfPending = (SELECT COUNT(*) FROM PendingSurvey) WHERE username = ? ");
	mysqli_stmt_bind_param($num, "s", $_POST["username"]);
	mysqli_stmt_execute($num);
	
	//update points
	$points = mysqli_prepare($con, "UPDATE user SET points = points+1 WHERE username = ? ");
	mysqli_stmt_bind_param($points, "s", $_POST["username"]);
	mysqli_stmt_execute($points);
	
	$statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ?");//select user from database 
	//Bind variables for the parameter markers in the SQL statement that was passed to mysqli_prepare(). 
	mysqli_stmt_bind_param($statement, "s", $_POST["username"]);
	mysqli_stmt_execute($statement);  
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $name, $username, $age, $password, $NumOfPending, $points);
	
	//returns everything from the database
	while(mysqli_stmt_fetch($statement)){//Fetch the result from a prepared statement into the variables bound by mysqli_stmt_bind_result().
		$response["success"] = true;  
		$response["name"] = $name;
		$response["age"] = $age;
		$response["username"] = $username;
		$response["password"] = $password;
		$response["NumOfPending"] = $NumOfPending;//****pending
		$response["points"] = $points;
	}
	
	
    echo json_encode($response);
?>
