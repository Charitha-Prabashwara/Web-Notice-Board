import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class mainform extends javax.swing.JFrame {

    String userID, firstName, lastName, email;
    String[] userdata = new String[4];//user data array.
 
    News newsObj;
    Notice noticeObj;
    UserController userObj;

    mainform(String[] user) {
        initComponents();

        this.userID = user[0];
        this.firstName = user[1];
        this.lastName = user[2];
        this.email= user[3];
        //create userdata 
        userdata[0] = this.userID;
        userdata[1] = this.firstName;
        userdata[2] = this.lastName;
        userdata[3] = this.email;
        //System.out.println(userdata[0]);
         
       
        newsObj = new News(userdata);// news controller
        noticeObj = new Notice(userdata);//Notice controller
        userObj = new UserController();// User Controller
        
        //set form title
        setTitle("WEB NOTICE BOARD: " + userdata[1] + " " + userdata[2] +" ( " + userdata[3] + " )");
        //check database connection
        try {
            userObj.testConnection();
            jMenu4.setText("Connection Status: Connected.");
        } catch (Exception e) {
            jMenu4.setText("Connection Status: Disconnected.");
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }

    }

    mainform(){
         initComponents();
    }



    @SuppressWarnings("unchecked")
                       
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        btnNews = new javax.swing.JButton();
        btnNotice = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WEB NOTICE BOARD: ");
        setBackground(new java.awt.Color(255, 255, 255));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        btnNews.setText("University News");
        btnNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewsActionPerformed(evt);
            }
        });

        btnNotice.setText("University Notice");
        btnNotice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoticeActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/mainbackground.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jMenuBar2.setBackground(new java.awt.Color(255, 255, 102));

        //jMenu4.setText("Connection Status: Connected");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNotice, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNews, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNews, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNotice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnNewsActionPerformed(java.awt.event.ActionEvent evt) {    
        //news form show
        try {
            newsObj.setVisible(true);
            setVisible(false);
            dispose();
        } catch (Exception e) {
            //check errors
            JOptionPane.showMessageDialog(null, e.getMessage().toString(), "ERROR", 3);
        }                                       
    }                                       

    private void btnNoticeActionPerformed(java.awt.event.ActionEvent evt) {                                          
        //notice form show
        try {
           noticeObj.setVisible(true);
            setVisible(false);
            dispose();
        } catch (Exception e) {
            //check errors
            JOptionPane.showMessageDialog(null, e.getMessage().toString(), "ERROR", 3);
        }
    }                                         

 
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new mainform(userdata).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnNews;
    private javax.swing.JButton btnNotice;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}
