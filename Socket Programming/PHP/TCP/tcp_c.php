
   <?php
    $host = "192.168.1.4";
    $port = "9999";
	$_REQUEST['msg']="ACK";
    do{
     $msg =$_REQUEST['msg'];
     $sock = socket_create(AF_INET, SOCK_STREAM, 0);
     socket_connect($sock, $host, $port);

     socket_write($sock, $msg, strlen($msg));

     $reply = socket_read($sock, 1924);
     $reply = trim($reply);
     

     $reply = "Server says:\t".$reply;
     sleep(0);
 }while(1);
   ?>
   
