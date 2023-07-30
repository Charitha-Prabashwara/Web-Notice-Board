<?php
include_once "database_config.php";

    
class GetNotice extends Connection{
    public $connection;

    function __construct(){

        //calling parent/super class constructor
       // $this.$connection = parent::__construct();
       $this->connection = parent::__construct();
    }

    public function Get_latest5_Notice(){
          
        $this->connection->select_db("seu");
        $sql = "SELECT * FROM notice ORDER BY timestamp DESC LIMIT 5;";

           $result =  $this->connection->query($sql);//execute sql query

        $array = array();

        if ( $result->num_rows>0) {
            while($row = $result->fetch_assoc()) {
                //echo "id: " . " | " . $row["id"] . " | " . $row["title"] ." | ".  $row["subtitle"] . " | ".$row["content"] ."<br>";
                array_push($array, array('id' => $row["id"], 'title' => $row["title"], 'subtitle' => $row["subtitle"], 'content'=>$row["content"]));// applend latest 5 news.

                }
        }
     
        return $array;

    }
    public function Get_Notice($news_id){
        $this->connection->select_db("seu");
        $sql = "SELECT * FROM notice WHERE id='$news_id' LIMIT 1;";

        $result =  $this->connection->query($sql);//execute sql query
        
        if ($result->num_rows > 0) {
            $row = $result->fetch_assoc();
            //print_r($row['id']);
            return $row;
        }else{
            die("404");
        }
    }

    public function Get_All_Notice(){
        $this->connection->select_db("seu");
        $sql = "SELECT * FROM notice;";

        $result =  $this->connection->query($sql);//execute sql query
        
        $array = array();

        if ( $result->num_rows>0) {
            while($row = $result->fetch_assoc()) {
                //echo "id: " . " | " . $row["id"] . " | " . $row["title"] ." | ".  $row["subtitle"] . " | ".$row["content"] ."<br>";
                array_push($array, array('id' => $row["id"], 'title' => $row["title"], 'timestamp' => $row["timestamp"]));// applend latest 5 news.

                }
        }
        return $array;
    }
    public function Get_latest1_Notice(){
        $this->connection->select_db("seu");
        $sql = "SELECT * FROM notice ORDER BY id DESC LIMIT 1;";

        $result =  $this->connection->query($sql);//execute sql query
        
        $array = array();

        if ( $result->num_rows>0) {
            while($row = $result->fetch_assoc()) {
                //echo "id: " . " | " . $row["id"] . " | " . $row["title"] ." | ".  $row["subtitle"] . " | ".$row["content"] ."<br>";
                array_push($array, array('id' => $row["id"], 'subtitle' => $row["subtitle"], 'content' => $row["content"],  'title' => $row["title"], 'timestamp' => $row["timestamp"]));// applend latest 5 news.

                }
        }
        //die(echo $array[0]);
        return $array;
    }
}

?>