<?php
include_once "database_config.php";
//use \Datetime;
    
class GetNews extends Connection{
    public $connection;

    function __construct(){

        //calling parent/super class constructor
       // $this.$connection = parent::__construct();
       $this->connection = parent::__construct();
    }

    public function Get_latest5_News(){

        //parent::$connectionObj::select_db("news");
        //$connection = parent::__construct();
        //$this->connection->select_db("seu");

        //$sql = "SELECT id, timestamp FROM news;";
        //$result =  $this->connection->query($sql);//execute sql query

        // check how many data rows and greater than 0
        //if ( $result->num_rows>0) {
            // while($row = $result->fetch_assoc()) {
            //     echo "id: " . $row["id"]. " - TimeStamp: " . $row["timestamp"]. " " . "<br>";
            //   }
        //}

        // get time zone support with SQL timestamp
        // $now = new DateTime();
        // $now->setTimezone(new DateTimeZone('Asia/Colombo')); // colombo Sri Jayawardanapura time zone Reference: https://stackoverflow.com/questions/4755704/php-timezone-list
        // echo $now->format('Y-m-d H:i:s');    // MySQL datetime format

        //calculate latest recode in the database.

          
        $this->connection->select_db("seu");
        $sql = "SELECT * FROM news ORDER BY timestamp DESC LIMIT 5;";

           $result =  $this->connection->query($sql);//execute sql query

        $array = array();

        if ( $result->num_rows>0) {
            while($row = $result->fetch_assoc()) {
                //echo "id: " . " | " . $row["id"] . " | " . $row["title"] ." | ".  $row["subtitle"] . " | ".$row["content"] ."<br>";
                array_push($array, array('id' => $row["id"], 'title' => $row["title"], 'subtitle' => $row["subtitle"], 'content'=>$row["content"]));// applend latest 5 news.

                }
        }
        //$array = array_values($array);
        //echo json_encode($array);
        //print_r(json_encode($array));  
        //print_r($array);
        return $array;

    }
    public function Get_News($news_id){
        $this->connection->select_db("seu");
        $sql = "SELECT * FROM news WHERE id='$news_id' LIMIT 1;";

        $result =  $this->connection->query($sql);//execute sql query
        
        if ($result->num_rows > 0) {
            $row = $result->fetch_assoc();
            //print_r($row['id']);
            return $row;
        }else{
            die("404");
        }
    }

    public function Get_All_News(){
        $this->connection->select_db("seu");
        $sql = "SELECT * FROM news;";

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
    public function Get_latest1_News(){
        $this->connection->select_db("seu");
        $sql = "SELECT * FROM news ORDER BY id DESC LIMIT 1;";

        $result =  $this->connection->query($sql);//execute sql query
        
        $array = array();

        if ( $result->num_rows>0) {
            while($row = $result->fetch_assoc()) {
                //echo "id: " . " | " . $row["id"] . " | " . $row["title"] ." | ".  $row["subtitle"] . " | ".$row["content"] ."<br>";
                array_push($array, array('id' => $row["id"], 'subtitle' => $row["subtitle"], 'content' => $row["content"],  'title' => $row["title"], 'timestamp' => $row["timestamp"]));// applend latest 5 news.

                }
        }
        //die(echo $array[0]);
        return $array[0];
    }
}

?>