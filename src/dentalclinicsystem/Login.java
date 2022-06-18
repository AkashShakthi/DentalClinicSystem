package dentalclinicsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login extends user {

    public Login() {
        initComponents();

    }

    //for login validation
    static boolean isuserlogged = false;
    static String LogedUserRoll = "", logUserName = "";
    static int logeduserid = 0, emailuid = 0, passuid = 0;

    //This is for get first name of the LoggerName 
    public String LoggerName() {
        String[] userfirstname = logUserName.split("\\ ");
        userfirstname[0] = userfirstname[0].substring(0, 1).toUpperCase() + userfirstname[0].substring(1);
        return userfirstname[0];
    }

    //check login user
    public boolean loginValidator(String loggermail, String loggerpasword) {

        email = loggermail;
        password = PasswordEncryptor(loggerpasword);

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Con = DriverManager.getConnection("jdbc:derby:" + currentDir + "\\dentaldb", "root", "root");
            St = (Statement) Con.createStatement();
            St1 = (Statement) Con.createStatement();

            Rs = St.executeQuery("Select USERID from root.USERTBL where USEREMAIL='" + email + "'");
            Rs1 = St1.executeQuery("Select USERID from root.USERTBL where USERPASSWORD='" + password + "'");
            Rs.next();
            Rs1.next();

            emailuid = Rs.getInt("USERID");

            passuid = Rs1.getInt("USERID");

            if (emailuid == passuid) {

                logeduserid = Rs.getInt("USERID");

                St2 = (Statement) Con.createStatement();
                Rs2 = St2.executeQuery("Select * from root.USERTBL where USERID=" + logeduserid);
                Rs2.next();
                LogedUserRoll = Rs2.getString("USERROLL");
                logUserName = Rs2.getString("USERNAME");
                isuserlogged = true;

            } else {
                isuserlogged = false;
                LogedUserRoll = "";
                logeduserid = 0;
            }
        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
        return isuserlogged;
    }

    //logout
    public void logout() {

        isuserlogged = false;
        LogedUserRoll = "";
        logeduserid = 0;
        emailuid = 0;
        passuid = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        reset = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(2, 89, 0));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        reset.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        reset.setForeground(new java.awt.Color(1, 0, 0));
        reset.setText("reset");
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });

        mail.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        mail.setPreferredSize(new java.awt.Dimension(100, 20));

        pass.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 0, 0));
        jLabel4.setText("Password");

        login.setBackground(new java.awt.Color(0, 0, 0));
        login.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        login.setForeground(new java.awt.Color(0, 255, 204));
        login.setText("Login");
        login.setPreferredSize(new java.awt.Dimension(75, 26));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 0, 0));
        jLabel5.setText("Email");

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setMinimumSize(new java.awt.Dimension(193, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(169, 434));

        close.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        close.setForeground(new java.awt.Color(0, 255, 204));
        close.setText("Close");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 204));
        jLabel14.setText("Dental Clinic ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(close)))
                .addGap(0, 43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel14)
                .addGap(249, 249, 249)
                .addComponent(close)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mail, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(reset)
                        .addGap(167, 167, 167))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(72, 72, 72)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        mail.setText("");
        pass.setText("");
    }//GEN-LAST:event_resetMouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked

        if (mail.getText().isEmpty() || pass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Username and Password");

        } else if (loginValidator(mail.getText(), pass.getText()) == true) {

            new Dashboard().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username or password not Matched");
        }
    }//GEN-LAST:event_loginMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_closeMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton login;
    private javax.swing.JTextField mail;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel reset;
    // End of variables declaration//GEN-END:variables
}
