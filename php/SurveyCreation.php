<?php
	//myhost, my_user, my_password, my_db
	//Returns an object which represents the connection to a MySQL Server. 
    $con = mysqli_connect("mysql9.000webhost.com", "a1339558_Lin", "bboxx2016", "a1339558_BBoxx");
    
	$type1= (int)$_POST["type1"];
	$type2= (int)$_POST["type2"];
	$type3= (int)$_POST["type3"];
	$type4= (int)$_POST["type4"];
	$type5= (int)$_POST["type5"];

	$create = mysqli_prepare($con, "INSERT INTO  PendingSurvey (
`NameOfSurvey` ,

`QuestionOne` ,
`type1` ,
`RadioAnswerOneOne` ,
`RadioAnswerOneTwo` ,
`RadioAnswerOneThree` ,

`QuestionTwo` ,
`type2` ,
`RadioAnswerTwoOne` ,
`RadioAnswerTwoTwo` ,
`RadioAnswerTwoThree` ,

`QuestionThree` ,
`type3` ,
`RadioAnswerThreeOne` ,
`RadioAnswerThreeTwo` ,
`RadioAnswerThreeThree` ,

`QuestionFour` ,
`type4` ,
`RadioAnswerFourOne` ,
`RadioAnswerFourTwo` ,
`RadioAnswerFourThree` ,

`QuestionFive` ,
`type5` ,
`RadioAnswerFiveOne` ,
`RadioAnswerFiveTwo` ,
`RadioAnswerFiveThree`
)
VALUES (
?,  
?,  ?, ?,?,?,
?,  ?, ?,?,?,
?,  ?, ?,?,?,
?,  ?, ?,?,?,
?,  ?, ?,?,?)");
	mysqli_stmt_bind_param($create, "ssissssissssissssissssisss", $_POST["NameOfSurvey"], 
	$_POST["Question1"], $type1, $_POST["Option11"],$_POST["Option12"],$_POST["Option13"],
	$_POST["Question2"], $type2, $_POST["Option21"],$_POST["Option22"],$_POST["Option23"],
	$_POST["Question3"], $type3, $_POST["Option31"],$_POST["Option32"],$_POST["Option33"],
	$_POST["Question4"], $type4, $_POST["Option41"],$_POST["Option42"],$_POST["Option43"],
	$_POST["Question5"], $type5, $_POST["Option51"],$_POST["Option52"],$_POST["Option53"]
	);
	mysqli_stmt_execute($create);
	

    $response = array();
    $response["success"] = true;  
	$response["username"] = $_POST["username"];  

	//echo Outputs all parameters. No additional newline is appended. 
	//json_encode — Returns the JSON representation of a value
    echo json_encode($response);
?>
