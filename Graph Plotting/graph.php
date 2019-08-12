<?php
            $id=$_POST['id'];
		   include("db_connect.php");
            $query = "SELECT value FROM ecg_live_values WHERE patient_id=".$id."";
	$result = mysqli_query ($GLOBALS['con'],$query);
	
	while ($row = mysqli_fetch_assoc ($result))
	{
		$ArArResult[]= $row['value']; 
	}
	echo json_encode($ArArResult);
?>
