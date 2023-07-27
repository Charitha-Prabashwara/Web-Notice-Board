<?php
include_once "database_config.php";

class GetNews extends Connection{

    function __construct(){

        //calling parent/super class constructor
       // $this.$connection = parent::__construct();
      
    }

    public function Get_latest5_News(){

        //parent::$connectionObj::select_db("news");
       
        $connection = parent::__construct();
        $connection->select_db("seu");

        $sql = "SELECT id, timestamp FROM news;";
        $result =  $connection->query($sql);

        if ( $result->num_rows>0) {
            // while($row = $result->fetch_assoc()) {
            //     echo "id: " . $row["id"]. " - TimeStamp: " . $row["timestamp"]. " " . "<br>";
            //   }
            
        }
        }
}
$ww = new GetNews();
$ww->Get_latest5_News();
?>