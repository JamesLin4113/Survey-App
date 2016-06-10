<?php
    
	//myhost, my_user, my_password, my_db
	//Returns an object which represents the connection to a MySQL Server. 	
	$con = mysqli_connect("mysql9.000webhost.com", "a1339558_Lin", "bboxx2016", "a1339558_BBoxx");
	
	//android app posts the following info
    $name = $_POST["name"];
    $username = $_POST["username"];
	$age = $_POST["age"];
    $password = $_POST["password"];

    $statement = mysqli_prepare($con, "INSERT INTO user (name, username, age, password) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssis", $name, $username, $age, $password);
    mysqli_stmt_execute($statement);
    
    $response = array();
	
	//the person register successfully
    $response["success"] = true;  
    
    echo json_encode($response);
?>
