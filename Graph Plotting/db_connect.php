<?php
// Create connection

$access_token = "123";


define ("DB_HOST","localhost");
define ("DB_USERNAME","root");
define ("DB_PASS","");
define ("DB_NAME","ecgtrack_web");




//define ("DB_HOST","localhost");
//define ("DB_USERNAME","root");
//define ("DB_PASS","");
//define ("DB_NAME","ecg_web");



//define ("DB_HOST","localhost");
//define ("DB_USERNAME","ecgtrack_web");
//define ("DB_PASS","P*$#A}*hDSba");
//define ("DB_NAME","ecgtrack_web");





$con=mysqli_connect(DB_HOST,DB_USERNAME,DB_PASS,DB_NAME);


// Check connection
if (mysqli_connect_errno($con))
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }
  
    
?>
