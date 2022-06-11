package dentalclinicsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class appointments extends javax.swing.JFrame {

    public appointments() {
        initComponents();
        getPatient();
        getTreatment();
        AppointmentCount();
        DisplayAppointment();
        Clear();

        //display logedusername

        Login login = new Login();
        usernameDisplay.setText(login.LoggerName());


    }

    Connection Con = null;
    Statement St = null, St1 = null;
    ResultSet Rs = null, Rs1 = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        PatName = new javax.swing.JComboBox<>();
        AppDate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AppointmentTable = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        TreatName = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Patientlabel = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dashboardlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameDisplay = new javax.swing.JLabel();
        AppTime = new javax.swing.JTextField();

        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setText("Appointments");

        PatName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatNameActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Patient");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setText("Date");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel17.setText("Time");

        edit.setBackground(new java.awt.Color(0, 0, 0));
        edit.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        edit.setForeground(new java.awt.Color(0, 255, 204));
        edit.setText("Edit");
        edit.setPreferredSize(new java.awt.Dimension(75, 26));
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });

        save.setBackground(new java.awt.Color(0, 0, 0));
        save.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        save.setForeground(new java.awt.Color(0, 255, 204));
        save.setText("Save");
        save.setPreferredSize(new java.awt.Dimension(75, 26));
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        delete.setBackground(new java.awt.Color(0, 0, 0));
        delete.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 255, 204));
        delete.setText("Delete");
        delete.setPreferredSize(new java.awt.Dimension(75, 26));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });

        AppointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Patient Name", "Treatment", "Date", "Time"
            }
        ));
        AppointmentTable.setSelectionBackground(new java.awt.Color(0, 204, 255));
        AppointmentTable.setSelectionForeground(new java.awt.Color(0, 51, 51));
        AppointmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppointmentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AppointmentTable);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel19.setText("Appointments List");

        TreatName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TreatNameActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel18.setText("Treatment");

        clear.setBackground(new java.awt.Color(0, 0, 0));
        clear.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        clear.setForeground(new java.awt.Color(0, 255, 204));
        clear.setText("Clear");
        clear.setPreferredSize(new java.awt.Dimension(75, 26));
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setMinimumSize(new java.awt.Dimension(193, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(169, 434));

        Patientlabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Patientlabel.setForeground(new java.awt.Color(0, 255, 204));
        Patientlabel.setText("Patients");
        Patientlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientlabelMouseClicked(evt);
            }
        });

        logout.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(0, 255, 204));
        logout.setText("Log Out");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 204));
        jLabel14.setText("Dental Clinic ");

        dashboardlabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        dashboardlabel.setForeground(new java.awt.Color(0, 255, 204));
        dashboardlabel.setText("Dashboard");
        dashboardlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardlabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardlabel)
                    .addComponent(Patientlabel)
                    .addComponent(jLabel14))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(logout)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel14)
                .addGap(113, 113, 113)
                .addComponent(Patientlabel)
                .addGap(86, 86, 86)
                .addComponent(dashboardlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(48, 48, 48))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dentalclinicsystem/logger.png"))); // NOI18N

        usernameDisplay.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        usernameDisplay.setForeground(new java.awt.Color(0, 51, 51));
        usernameDisplay.setText("User");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel19)
                        .addContainerGap(280, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(195, 195, 195))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PatName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AppDate, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(AppTime, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TreatName, javax.swing.GroupLayout.Alignment.LEADING, 0, 161, Short.MAX_VALUE)))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TreatName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PatName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AppDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AppTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(87, 87, 87))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
          Login login = new Login();
        login.logout();

        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

    private void PatientlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientlabelMouseClicked
        new patient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PatientlabelMouseClicked

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        Clear();
    }//GEN-LAST:event_clearMouseClicked

    private void TreatNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TreatNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TreatNameActionPerformed

    private void AppointmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppointmentTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) AppointmentTable.getModel();
        int MyIndex = AppointmentTable.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        PatName.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
        TreatName.setSelectedItem(model.getValueAt(MyIndex, 4).toString());

    }//GEN-LAST:event_AppointmentTableMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        if (Key == 1000) {
            JOptionPane.showMessageDialog(this, "Select The Appointment");
        } else {
            try {

                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
                String Query = "Delete from Root.AppointmentTbl where AppId=" + Key;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                JOptionPane.showMessageDialog(this, " Appointment Deleted Successfully");

                DisplayAppointment();
                Clear();
            } catch (Exception Ex) {
                Ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_deleteMouseClicked

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        // TODO add your handling code here:
        if (PatName.getSelectedIndex() == -1 || TreatName.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Missing Information");
        } else {
            try {
                // int PatKey = 1;
                AppointmentCount();
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
                PreparedStatement add = Con.prepareStatement("insert into APPOINTMENTTBL values(?,?,?,?,?)");
                add.setInt(1, AppId);
                add.setString(2, AppDate.getDate().toString());
                add.setString(3, PatName.getSelectedItem().toString());
                add.setString(4, AppTime.getText());
                add.setString(5, TreatName.getSelectedItem().toString());

                int row = add.executeUpdate();

                JOptionPane.showMessageDialog(this, "Appointment Added Successfully");
                Con.close();

                DisplayAppointment();

                //send emailSender to the patient
                emailcontroler m = new emailcontroler();
                m.getAppointmentMailData(PatName.getSelectedItem().toString(), TreatName.getSelectedItem().toString(), AppDate.getDate().toString(), AppTime.getText());
                m.emailSender();

                //clear text data
                Clear();

            } catch (Exception Ex) {
                Ex.printStackTrace();
            }

        }

    }//GEN-LAST:event_saveMouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked

        if (Key == 1000) {
            JOptionPane.showMessageDialog(this, "Select The Appointment");
        } else {
            try {

                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
                String Query = "Update Root.AppointmentTbl set AppDate='" + AppDate.getDate().toString() + "'" + ",  PATIENT='" + PatName.getSelectedItem().toString() + "'" + " ,  APPTIME='" + AppTime.getText() + "'" + " ,  TREATMENT='" + TreatName.getSelectedItem().toString() + "'" + "  where APPID=" + Key;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                JOptionPane.showMessageDialog(this, "Appointment Updated Successfully");

                DisplayAppointment();

                //send emailSender to the patient
                emailcontroler m = new emailcontroler();
                m.getAppointmentMailData(PatName.getSelectedItem().toString(), TreatName.getSelectedItem().toString(), AppDate.getDate().toString(), AppTime.getText());
                m.emailSender();

                //clear text data
                Clear();

            } catch (Exception Ex) {
                Ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_editMouseClicked

    private void PatNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatNameActionPerformed

    private void dashboardlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardlabelMouseClicked
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardlabelMouseClicked

    private void getPatient() {

        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
            St = (Statement) Con.createStatement();
            String query = "Select * from root.PatientTbl ";
            Rs = St.executeQuery(query);
            while (Rs.next()) {
                String MyPat = Rs.getString("PatName");
                PatName.addItem(MyPat);
            }

        } catch (Exception Ex) {

        }
    }

    private void getTreatment() {

        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
            St = (Statement) Con.createStatement();
            String query = "Select * from root.TreatmentTbl  ";
            Rs = St.executeQuery(query);
            while (Rs.next()) {
                String MyTreat = Rs.getString("TreatmentName");
                TreatName.addItem(MyTreat);
            }

        } catch (Exception Ex) {

        }
    }

    int AppId = 0;

    private void AppointmentCount() {
        try {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("select Max(AppId) from root.AppointmentTbl");
            Rs1.next();
            AppId = Rs1.getInt(1) + 1;

        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
    }

    private void DisplayAppointment() {

        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
            St = (Statement) Con.createStatement();
            Rs = St.executeQuery("Select * from root.APPOINTMENTTBL ");
            AppointmentTable.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
    }

    private void Clear() {
        PatName.setSelectedIndex(-1);
        TreatName.setSelectedIndex(-1);
        AppDate.setCalendar(null);
        AppTime.setText("");
        Key = 1000;
    }
    int Key = 1000;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new appointments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser AppDate;
    private javax.swing.JTextField AppTime;
    private javax.swing.JTable AppointmentTable;
    private javax.swing.JComboBox<String> PatName;
    private javax.swing.JLabel Patientlabel;
    private javax.swing.JComboBox<String> TreatName;
    private javax.swing.JButton clear;
    private javax.swing.JLabel dashboardlabel;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logout;
    private javax.swing.JButton save;
    private javax.swing.JLabel usernameDisplay;
    // End of variables declaration//GEN-END:variables
}
