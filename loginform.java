
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginform extends javax.swing.JFrame {

    public loginform() throws SQLException, Exception {
        
        initComponents();
        //Test database connection
        try {
            //create user controller.
            UserController usr = new UserController();
            Exception exc = usr.testConnection();

            //connection errors check
            if(exc.equals(null)){
                labelConnectionStatus.setText("State: Disconnected.");
            }else{
                 labelConnectionStatus.setText("State: Connected.");
            }
           
        } catch (Exception e) {
            labelConnectionStatus.setText("State: Disconnected.");
        }
        
    }

    
    @SuppressWarnings("unchecked")
                    
    private void initComponents() throws SQLException, Exception{

        jScrollPane1 = new javax.swing.JScrollPane();
        emailField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogIn = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        btnClose = new javax.swing.JButton();
        labelConnectionStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WEB NOTICE BOARD LOGIN");
        setAutoRequestFocus(false);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        emailField.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        emailField.setText("zed.zero.fun@gmail.com");

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel1.setText("email   :");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel2.setText("Password :");

        btnLogIn.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnLogIn.setText("Log in");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
                try {
                     btnLogInActionPerformed(evt) ;
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        });

        passwordField.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        passwordField.setText("");

        btnClose.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                btnCloseActionPerformed(evt);
            }
        });

        labelConnectionStatus.setFont(new java.awt.Font("Consolas", 0, 10)); // NOI18N
        // labelConnectionStatus.setText("State: disconnected");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogIn)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelConnectionStatus)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelConnectionStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnLogIn))
                .addContainerGap())
        );

        pack();
    }                      

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                         
       //login operation
        
        //check email and password not empty or nit null
        if(emailField.getText().equals("") || passwordField.getText().equals("")){
            //display password, email empty error msg.
            String msg1= "Please Fillout your email Address and Password";
            JOptionPane.showMessageDialog(null, msg1);
        }else{
         
             //check valid email address

             if(!new Email().isEmailValidation(emailField.getText())){
                //show invalid email error msg.
                String msg = "You enterd email isn't valid";
                JOptionPane.showMessageDialog(null, msg);
             }else{
                //check database.
                UserController user = new UserController();

                //check user account
                if(user.Authenticate(emailField.getText(), passwordField.getText())){

                    user.getUserDetails(emailField.getText(), passwordField.getText());
                    //create userdata for send other forms.
                    String[] ud = new String[4];

                    ud[0] = user.userId;
                    ud[1] = user.firstName;
                    ud[2] = user.lastName;
                    ud[3] = user.emailAddr;

                   
                    //mainform show
                    new mainform(ud).setVisible(true);
                    this.setVisible(false);

                }else{
                    //invalid user error msg.
                    String msg = "Invalid user, Please enter valid email and password";
                    JOptionPane.showMessageDialog(null, msg);
                }
             }    
                
        }
              
    }                                        

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) { 
        //login form close                                       
        setVisible(false);
        dispose();
    }                                        



    // Variables declaration - do not modify                     
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelConnectionStatus;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration 
                     
}
