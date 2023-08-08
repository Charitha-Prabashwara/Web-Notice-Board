import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class NewsController extends UserController {
    public String selected_news_id;
    NewsController(){
        super();
    }

    public ResultSet GetAllNews(String userid) throws SQLException, Exception{
      
        String sql = "SELECT * FROM news WHERE user_id=" + userid + " ORDER BY id DESC;";
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

    public ResultSet GetNews() throws SQLException, Exception{
        String sql = "SELECT * FROM news WHERE id=" + selected_news_id + " LIMIT 1;";
        try {
            super.connect();
            ResultSet result = super.getStatement().executeQuery(sql);

            return result;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }
        return null;
    }

    public Boolean DeleteNews(){
        String sql = "DELETE FROM news WHERE id='" + selected_news_id + "';";
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

    public boolean updateNews(String title, String subtitle, String content)throws SQLException, Exception{
        String sql="UPDATE news SET title='" + title +"',subtitle='"+ subtitle +"',content='" + content + "' WHERE id=" + selected_news_id +";";
     
        try {
            super.connect();
            super.getStatement().execute(sql);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }
        return false;
    }
    
    public boolean insertNewNews(
        String newsTitle,
        String newsSubtitle,
        String newsContent,
        String userId
    )
    {

        String sql ="INSERT INTO news (title, subtitle, content, user_id) VALUES ('"+ newsTitle +"', '"+ newsSubtitle +"', '"+ newsContent +"', '"+ userId +"')";

        try {
            if(newsTitle.equals("") || newsTitle.equals(null)){
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
