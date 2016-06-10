<?php
    
	//myhost, my_user, my_password, my_db
	//Returns an object which represents the connection to a MySQL Server. 	
	$con = mysqli_connect("mysql9.000webhost.com", "a1339558_Lin", "bboxx2016", "a1339558_BBoxx");
	
	//android app posts the following info
    $name = $_POST["name"];
        $companyname = $_POST["companyname"];
		$email = $_POST["email"];
	$username = $_POST["username"];
    $password = $_POST["password"];
	$contactnumber = $_POST["contactnumber"];
		$country = $_POST["country"];
		

    $statement = mysqli_prepare($con, "INSERT INTO client (name, username, password, companyname, email, contactnumber, country) VALUES (?, ?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sssssss", $name, $username, $password, $companyname,$email, $contactnumber, $country);
    mysqli_stmt_execute($statement);
    
    $response = array();
	
	//the person register successfully
    $response["success"] = true;  
    
    echo json_encode($response);
?>
