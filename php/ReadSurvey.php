<?php
	//***********read the context of peding survey*************
	
	//myhost, my_user, my_password, my_db
	//Returns an object which represents the connection to a MySQL Server. 
    $con = mysqli_connect("mysql9.000webhost.com", "a1339558_Lin", "bboxx2016", "a1339558_BBoxx");
	
	//Prepares the SQL query, and returns a statement handle to be used for further operations on the statement. The query must consist of a single SQL statement. 
    $read = mysqli_prepare($con, "SELECT * FROM PendingSurvey LIMIT 1");//select user from database
    mysqli_stmt_execute($read);
    
	//You must call mysqli_stmt_store_result() for every query that successfully produces a result set (SELECT, SHOW, DESCRIBE, EXPLAIN), 
	//if and only if you want to buffer the complete result set by the client, so that the subsequent mysqli_stmt_fetch() call returns buffered data.
    mysqli_stmt_store_result($read);
	
	//Binds columns in the result set to variables. 
    mysqli_stmt_bind_result($read, $NameOfSurvey, $QuestionOne, $type1, $TextAnswerOne, $RadioAnswerOneOne, $RadioAnswerOneTwo, $RadioAnswerOneThree, $group1Answer, 
	$QuestionTwo, $type2, $TextAnswerTwo, $RadioAnswerTwoOne, $RadioAnswerTwoTwo, $RadioAnswerTwoThree, $group2Answer,
	$QuestionThree, $type3, $TextAnswerThree, $RadioAnswerThreeOne, $RadioAnswerThreeTwo, $RadioAnswerThreeThree, $group3Answer,
	$QuestionFour, $type4, $TextAnswerFour, $RadioAnswerFourOne, $RadioAnswerFourTwo, $RadioAnswerFourThree, $group4Answer,
	$QuestionFive, $type5, $TextAnswerFive, $RadioAnswerFiveOne, $RadioAnswerFiveTwo, $RadioAnswerFiveThree, $group5Answer);
	
	




    $response = array();
    $response["success"] = false;  	
	
	//returns everything from the database
    while(mysqli_stmt_fetch($read)){//Fetch the result from a prepared statement into the variables bound by mysqli_stmt_bind_result().
        $response["success"] = true;  
        $response["NameOfSurvey"] = $NameOfSurvey;
        $response["QuestionOne"] = $QuestionOne;
        $response["type1"] = $type1;
		$response["TextAnswerOne"] = $TextAnswerOne;
		$response["RadioAnswerOneOne"] = $RadioAnswerOneOne;
		$response["RadioAnswerOneTwo"] = $RadioAnswerOneTwo;
		$response["RadioAnswerOneThree"] = $RadioAnswerOneThree;
		
		$response["QuestionTwo"] = $QuestionTwo;
        $response["type2"] = $type2;
		$response["TextAnswerTwo"] = $TextAnswerTwo;
		$response["RadioAnswerTwoOne"] = $RadioAnswerTwoOne;
		$response["RadioAnswerTwoTwo"] = $RadioAnswerTwoTwo;
		$response["RadioAnswerTwoThree"] = $RadioAnswerTwoThree;
				
		$response["QuestionThree"] = $QuestionThree;
        $response["type3"] = $type3;
		$response["TextAnswerThree"] = $TextAnswerThree;
		$response["RadioAnswerThreeOne"] = $RadioAnswerThreeOne;
		$response["RadioAnswerThreeTwo"] = $RadioAnswerThreeTwo;
		$response["RadioAnswerThreeThree"] = $RadioAnswerThreeThree;
		
		$response["QuestionFour"] = $QuestionFour;
        $response["type4"] = $type4;
		$response["TextAnswerFour"] = $TextAnswerFour;
		$response["RadioAnswerFourOne"] = $RadioAnswerFourOne;
		$response["RadioAnswerFourTwo"] = $RadioAnswerFourTwo;
		$response["RadioAnswerFourThree"] = $RadioAnswerFourThree;
		
		$response["QuestionFive"] = $QuestionFive;
        $response["type5"] = $type5;
		$response["TextAnswerFive"] = $TextAnswerFive;
		$response["RadioAnswerFiveOne"] = $RadioAnswerFiveOne;
		$response["RadioAnswerFiveTwo"] = $RadioAnswerFiveTwo;
		$response["RadioAnswerFiveThree"] = $RadioAnswerFiveThree;
		
    }
 
	//echo Outputs all parameters. No additional newline is appended. 
	//json_encode — Returns the JSON representation of a value
    echo json_encode($response);
?>





	

