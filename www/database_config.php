<?php
 class Connection{
    private $serverADDR;
    private $serverUserName;
    private $serverPassword;
    private $databaseName;
    public $connectionObj;
   
    function __construct() {
       //Databse connection information 
       $serverADDR="localhost";
       $serverUserName="root";
       $serverPassword=""; 
       //Database
       $databaseName = "seu";
       //connection Object

        // Create connection
        $conn = new mysqli($serverADDR, $serverUserName, $serverPassword);

        // Check connection
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }else{
           // echo "Connected successfully";
        }
           
        return $conn;
 
    }  
}

 $conne = new Connection();
?>