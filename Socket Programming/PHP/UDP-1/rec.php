<?php
 include("dp.php");
//Reduce errors
error_reporting(~E_WARNING);
 
//Create a UDP socket
if(!($sock = socket_create(AF_INET, SOCK_DGRAM, 0)))
{
    $errorcode = socket_last_error();
    $errormsg = socket_strerror($errorcode);
     
    die("Couldn't create socket: [$errorcode] $errormsg \n");
}
 
echo "Socket created \n";
 
// Bind the source address
if( !socket_bind($sock, "0.0.0.0" , 20205) )
{
    $errorcode = socket_last_error();
    $errormsg = socket_strerror($errorcode);
     
    die("Could not bind socket : [$errorcode] $errormsg \n");
}
 
echo "Socket bind OK \n";
 $num=array(array());
	$buffer=$num1=$num2=NULL;
	$i=0;
//Do some communication, this loop can handle multiple clients
while(1)
{
    echo "Waiting for data ... \n";
     
    //Receive some data
    $r = socket_recvfrom($sock, $buf, 512, 0, $remote_ip, $remote_port);
    //echo "$remote_ip : $remote_port -- " . $buf;
    $buf=trim($buf,"\n\r");
    if($buf!="#")
    {
		$buffer=$buffer.$buf;
	}
    else if($buf=="#" && $buffer!=NULL)
    {
		$buffer = explode (",",$buffer);
		foreach ($buffer as $value)
		{
			if($num1==NULL) $num1=$value;
			else if($num2==NULL) $num2=$value;
		}
		$num[$i][0]=$num1;
		$num[$i][1]=$num2;
		$sql="INSERT INTO msg VALUES (id,'".$num1."',".$num2.")";
		
		if ($conn->query($sql) === TRUE) {
		echo "New record created successfully";
		} else {
			echo "Error: " . $sql . "<br>" . $conn->error;
		}
		$buffer=$num1=$num2=NULL;
		echo "".$num[$i][0]."=".$num[$i][1];
		$i++;
	}
    
    //Send back the data to the client
    //socket_sendto($sock, "OK " . $buf , 100 , 0 , $remote_ip , $remote_port);
}
 
//socket_close($sock);
?>
