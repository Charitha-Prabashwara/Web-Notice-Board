import javax.swing.JOptionPane;

public class insertNotice extends javax.swing.JFrame {
    String userid, firstName, lastName, email;

    public insertNotice(String[] user) {
        
        this.userid  = user[0];
        this.firstName= user[1];
        this.lastName = user[2];
        this.email = user[3];
        initComponents();
    }
    @SuppressWarnings("unchecked")
                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        subtitleField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentField = new javax.swing.JTextArea();
        btnInsert = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        labError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Publish New: " + this.firstName + "( " + this.email + ")");
        setType(java.awt.Window.Type.UTILITY);
        setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setText("Title");

        jLabel2.setText("Subtitle");

        titleField.setBackground(new java.awt.Color(255, 215, 213));
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        subtitleField.setBackground(new java.awt.Color(255, 215, 213));

        contentField.setColumns(20);
        contentField.setRows(5);
        jScrollPane1.setViewportView(contentField);

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        //labError.setForeground(new java.awt.Color(239, 13, 13));
        labError.setText("Status: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleField)
                            .addComponent(subtitleField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsert)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(subtitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnClose)
                    .addComponent(labError))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) { 
        String title, subtitle, content;
        
        title = titleField.getText();
        subtitle = subtitleField.getText();
        content = contentField.getText();

        try {

            if(!(title.length()>255)){

                if(!(subtitle.length()>255)){
                    

                    // null check or empty check
                    if(!(title.equals(null) || title.equals(""))){

                        if(!(subtitle.equals(null) || subtitle.equals(""))){

                            //send to database
                            
                            boolean result= new NoticeController().insertNewNotice(title, subtitle, content, userid);

                            if(!result){
                                throw new RuntimeException("Insertion incomplete");
                            }else{

                                titleField.setText("");
                                subtitleField.setText("");
                                contentField.setText("");

                                labError.setForeground(new java.awt.Color(0, 240, 13));
                                labError.setText("SUCESS: "+ "Insertion Successfully.");

                                JOptionPane.showMessageDialog(null, "Insertion Successfully.");
                            }

                        }else{
                            throw new RuntimeException("Subtitle shouldn't be empty or null.");
                        }
                    }else{
                    throw new RuntimeException("Title shouldn't be empty or null.");
                    }
                }else{
                    throw new RuntimeException("Subtitle length shouldn't be greater than 255");
                }
        }else{
            throw new RuntimeException("Title length shouldn't be greater than 255");    
        }
            
        } catch (Exception e) {

            labError.setForeground(new java.awt.Color(239, 13, 13));
            labError.setText("ERROR: "+ e.getLocalizedMessage().toString());
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 3);
        }

    }                                         

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {                                         
        setVisible(false);
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
            java.util.logging.Logger.getLogger(insertNotice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insertNotice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insertNotice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insertNotice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new insertNotice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnInsert;
    private javax.swing.JTextArea contentField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labError;
    private javax.swing.JTextField subtitleField;
    private javax.swing.JTextField titleField;
    // End of variables declaration                   
}
