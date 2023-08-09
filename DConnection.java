//SQL Librarys -begin
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
// SQL Librarys -end

import javax.swing.JOptionPane;//JSwING message dialog library


public class DConnection {
    //BEGIN Configuration Section-----------------------------

    final String DRIVER ="com.mysql.jdbc.Driver";//DATABASE DRIVER

    //# +++++++++++++++++++++++++++++++++++++++++++++++
        //CONFIG
    String DB_PATH = null;
    //"jdbc:mysql://localhost:3306/seu";//DATABASE LINK:PORT/DBNAME
    //# +++++++++++++++++++++++++++++++++++++++++++++++
    
    Connection conn; //connection
    Statement stmt = null;//Statement
    
    String databaseLink = null;
    String port = null;

    String userName = null;//username
    String password = null;//password
    String database = null;//databasename.

    DConnection(){
        //# ++++++++++++++++++++++++++++++++++
                //CONFIG
        //DATABASE URL
        databaseLink = "localhost";
        //DATABASE PORT
        port="3306";
        //DATABASE USERNAME
        userName = "root";
        //DATABASE PASSWORD
        password = "";
        //DATABASE NAME
        database="seu";

        //# ++++++++++++++++++++++++++++++++++
        DB_PATH = "jdbc:mysql://" + databaseLink +":" + port + "/" + database;
    }
    //END Configuration Section -------------------------------

    public void connect()  throws SQLException , Exception{
        // Crate database connection
            try {
                Class.forName(DRIVER);
                //Connection
                conn = DriverManager.getConnection(DB_PATH, userName, password);
                //Statement
                stmt = this.conn.createStatement();
        
                if(conn != null){
                    //Database connection working 
                        //System.out.println("Connection Seccesfull");
                }
                
            } catch (Exception e) {
                //Show database connection error
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
            }
        }
           
    public void closeConnection() throws SQLException, Exception{
        //Close opend database connection
        try {
            //Close Statement
           stmt.close();
            //Close Connection
           conn.close(); 
        } catch (Exception e) {
             //Show errors
             JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }
        
    }
    public Statement getStatement(){
        //Return Database connection Statement.
        return this.stmt;
    }
    public Connection getConnection(){
        //Return Database Connection.
        return this.conn;
    }
}
