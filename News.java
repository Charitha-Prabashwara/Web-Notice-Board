import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

public class News extends javax.swing.JFrame {
    String userId, firstName, lastName, email;
    String[] userdata = new String[4];
    // news controller
    NewsController news_cont = new NewsController();
    
    public News(String[] user) {
        
        this.userId = user[0];
        this.firstName = user[1];
        this.lastName = user[2];
        this.email= user[3];
        //create userdata
        userdata[0] = this.userId;
        userdata[1] = this.firstName;
        userdata[2] = this.lastName;
        userdata[3] = this.email;

        initComponents();
        fromreset();
        

    }

    @SuppressWarnings("unchecked")
                            
    private void initComponents() {

        selectCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        // show form title
        setTitle("News : " + this.firstName + "( " + this.email + ")");

        selectCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        
        
        selectCombo.addActionListener(new java.awt.event.ActionListener() {
           
            public void actionPerformed(java.awt.event.ActionEvent evt){
                try {
                    selectComboActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        jLabel1.setText("Select News");

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        jLabel2.setText("Title");

        // jTextField1.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         jTextField1ActionPerformed(evt);
        //     }
        // });

        jLabel3.setText("Subtitle");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnUpdateActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        statusLabel.setText("Status: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(statusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInsert))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(statusLabel))
                .addContainerGap())
        );

        pack();
    }                       

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) { 
        //show insert form
    System.out.println(userdata[0]);
      insertNews ns =  new insertNews(userdata);
      setEnabled(false);
      ns.setVisible(true);
      setEnabled(true);
      
    }                                         

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, Exception {                                          
       //news update
        try {
            //send to database
            boolean result = news_cont.updateNews(jTextField1.getText().toString(), jTextField2.getText().toString(), jTextArea1.getText().toString());
            //check connection and formreset
            if(result){
                fromreset();
                statusLabel.setForeground(new java.awt.Color(10, 250, 13));
                statusLabel.setText("Status: " + "Connection Success..");
            }else{
                statusLabel.setForeground(new java.awt.Color(239, 13, 13));
                statusLabel.setText("Status: " + "Connection Error..");
            }
            
        } catch (Exception e) {
            //show updation error
            statusLabel.setForeground(new java.awt.Color(239, 13, 13));
            statusLabel.setText("Status: "+ e.getMessage().toString());
            JOptionPane.showMessageDialog(null, e.getMessage().toString(), "ERROR", 3);
        
        }
        
    }                                         

    public void fromreset(){
        //form reset
        selectCombo.removeAllItems();
        jTextField1.setText("");
        jTextField2.setText("");
        jTextArea1.setText("");
        news_cont.selected_news_id=null;
        news_cont.userId=userId;

        try {
            //get all news
            ResultSet result = news_cont.GetAllNews(userId);
            while(result.next()){
                //set combobox
                selectCombo.addItem(result.getString("id") + ":" + result.getString("title"));
            }
            statusLabel.setForeground(new java.awt.Color(10, 250, 13));
            statusLabel.setText("Status: " + "Connection Success..");
        } catch (Exception e) {
            //check connection error
            statusLabel.setForeground(new java.awt.Color(239, 13, 13));
            statusLabel.setText("Status: "+ e.getMessage().toString());
            JOptionPane.showMessageDialog(null, e.getMessage().toString(), "ERROR", 3);
        }
    }                                          

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {     
        //delete selected news                                     
        int response = JOptionPane.showConfirmDialog(this, "Do you want to delete ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.YES_OPTION){
            try {
                // connect and delete selected news.
                news_cont.DeleteNews();
                //form reset
                fromreset();
                statusLabel.setForeground(new java.awt.Color(10, 250, 13));
                statusLabel.setText("Status: " + "Connection Success..");
            } catch (Exception e) {
                //show errors.
                statusLabel.setForeground(new java.awt.Color(239, 13, 13));
                statusLabel.setText("Status: "+ e.getMessage().toString());
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
            }
        }
    }                                         

    private void selectComboActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, Exception{
         //select news                                       
        String comob_selected_item = selectCombo.getSelectedItem().toString();
        //System.out.println(comob_selected_item);
        String[] splited = comob_selected_item.split(":");
        news_cont.selected_news_id = splited[0];
        System.out.println(news_cont.selected_news_id);

        
        try {
            //get selected news
            ResultSet result = news_cont.GetNews();
            
            while(result.next()){
                //set field
                jTextField1.setText(result.getString("title"));
                jTextField2.setText(result.getString("subtitle"));
                jTextArea1.setText(result.getString("content"));
                break;
            }
            statusLabel.setForeground(new java.awt.Color(10, 250, 13));
            statusLabel.setText("Status: " + "Connection Success..");
            
        } catch (Exception e) {
            //show error
            statusLabel.setForeground(new java.awt.Color(239, 13, 13));
            statusLabel.setText("Status: "+ e.getMessage().toString());
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }

    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) { 
        //handle formclose event and show mainform                                  
        new  mainform(userdata).setVisible(true);
        dispose();  
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
            java.util.logging.Logger.getLogger(News.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(News.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(News.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(News.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> selectCombo;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration                   
}
