import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UserController extends DConnection{
    
    String userId, firstName, lastName, emailAddr;
    
    UserController(){super();}

    public boolean Authenticate(String email, String password) throws SQLException, Exception{
       
        try {
        
        super.connect();
        
        String sql="SELECT id, first_name, last_name, email, password FROM user WHERE email='" 
        
         + email + "' AND password='"+ password +"' LIMIT 1;";   
        ResultSet result = super.getStatement().executeQuery(sql);
       
        String emailr="", passString="";

        while(result.next()){
        
            emailr = result.getString("email");
            passString = result.getString("password");
            break;
        }
        super.closeConnection();
      
        if(!email.equals(emailr)){

            if (!password.equals(passString)) {
                return false;
            }     
        }
        return true;

       } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
       }
       return false;       
    }
    public String[] getUserDetails(String email, String password) throws SQLException, Exception{
        
        String[] userDetails= new String[4];

        try {
            super.connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }
        
        final String sql="SELECT id, first_name, last_name, email FROM user WHERE email='" 
        
         + email + "' AND password='"+ password +"' LIMIT 1;";

        try {
            
            ResultSet result = super.getStatement().executeQuery(sql);
            
             while(result.next()){
           
            userDetails[0] = result.getString("id");
            userId =  result.getString("id");

            userDetails[1] = result.getString("first_name");
            firstName = result.getString("first_name");

            userDetails[2] = result.getString("last_name");
            lastName = result.getString("last_name");

            userDetails[3] = result.getString("email");
            emailAddr = result.getString("email");
            }
            super.closeConnection();

        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        } 
        return userDetails;
    }

    public Exception testConnection()throws SQLException, Exception{
        super.connect();
        try {
            String sql= "USE seu;";
            super.getStatement().executeQuery(sql);
        } catch (Exception e) {
            return e;
        }
        return null;
    }
}
