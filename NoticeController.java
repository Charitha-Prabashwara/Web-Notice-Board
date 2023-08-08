import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class NoticeController extends UserController {
    public String selected_notice_id;
    NoticeController(){
        super();
    }

    public ResultSet GetAllNotice(String userid) throws SQLException, Exception{
      
        String sql = "SELECT * FROM notice WHERE user_id=" + userid + " ORDER BY id DESC;";
        System.out.println(userid);
        try {
            super.connect();
            ResultSet result = super.getStatement().executeQuery(sql);
            
            
            return result;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);   
        }

        return null;
    }

    public ResultSet GetNotice() throws SQLException, Exception{
        String sql = "SELECT * FROM notice WHERE id=" + selected_notice_id + " LIMIT 1;";
        try {
            super.connect();
            ResultSet result = super.getStatement().executeQuery(sql);

            return result;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }
        return null;
    }

    public Boolean DeleteNotice(){
        String sql = "DELETE FROM notice WHERE id='" + selected_notice_id + "';";
        try {
            super.connect();
            super.getStatement().execute(sql);
            super.closeConnection();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }
        return false;
    }

    public boolean updateNotice(String title, String subtitle, String content)throws SQLException, Exception{
        String sql="UPDATE notice SET title='" + title +"',subtitle='"+ subtitle +"',content='" + content + "' WHERE id=" + selected_notice_id +";";
     
        try {
            super.connect();
            super.getStatement().execute(sql);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }
        return false;
    }
    
    public boolean insertNewNotice(
        String noticeTitle,
        String noticeSubtitle,
        String noticeContent,
        String userId
    )
    {

        String sql ="INSERT INTO notice (title, subtitle, content, user_id) VALUES ('"+ noticeTitle +"', '"+ noticeSubtitle +"', '"+ noticeContent +"', '"+ userId +"')";

        try {
            if(noticeTitle.equals("") || noticeTitle.equals(null)){
                throw new RuntimeException("");
            }
            if(userId.equals("") || userId.equals(null)){
                throw new RuntimeException("");
            }
            super.connect();

            boolean result = super.getStatement().execute(sql);

            super.closeConnection();
            return true;

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }
        return false;
    }
}
