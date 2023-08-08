
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class DConnection {

    final String DRIVER ="com.mysql.jdbc.Driver";
    String DB_PATH = "jdbc:mysql://localhost:3306/seu";
    Connection conn;
    Statement stmt = null;

    String userName = null;
    String password = null;

    DConnection(){userName = "root";password = "";}

    public void connect()  throws SQLException , Exception{
        
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(DB_PATH, userName, password);
                stmt = this.conn.createStatement();
        
                if(conn != null){
                    System.out.println("Connection Seccesfull");
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
            }
        }
           
    public void closeConnection() throws SQLException, Exception{
        try {
           stmt.close();
           conn.close(); 
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }
        
    }
    public Statement getStatement(){return this.stmt;}
    public Connection getConnection(){return this.conn;}
}
