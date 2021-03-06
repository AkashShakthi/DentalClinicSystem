/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentalclinicsystem;

import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author akash
 */
public class doctors extends user {

    //for selected row key in table
    int Key = 0;

    public doctors() {
        initComponents();

        //get this claa from user classs and create user count function for user counting perpuses
        IdGenerator("USERID", "USERTBL");

        //for displayData data on table
        DoctorTable.setModel(DbUtils.resultSetToTableModel(displayData(UserRolll.getSelectedItem().toString())));

        //display logedusername
        Login login = new Login();
        usernameDisplay.setText(login.LoggerName());

    }

    //clear text field data
    private void Clear() {
        DocName.setText("");
        DocEmail.setText("");
        docPass.setText("");
        docConPass.setText("");
        DocMobile.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DoctorTable = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        DocName = new javax.swing.JTextField();
        DocEmail = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        UserRolll = new javax.swing.JComboBox<>();
        DocMobile = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        receptionistslabel = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dashboardlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameDisplay = new javax.swing.JLabel();
        docPass = new javax.swing.JPasswordField();
        docConPass = new javax.swing.JPasswordField();
        openeye = new javax.swing.JLabel();
        closeeye = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(900, 600));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setText("Doctors");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setText("Name");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel17.setText("Email");

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

        DoctorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Doctor Name", "Email", "Mobile"
            }
        ));
        DoctorTable.setSelectionForeground(new java.awt.Color(0, 51, 51));
        DoctorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DoctorTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DoctorTable);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel19.setText("Doctors List");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel18.setText("Password");

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel20.setText("Conform Password");

        DocName.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        DocName.setPreferredSize(new java.awt.Dimension(100, 20));
        DocName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocNameActionPerformed(evt);
            }
        });

        DocEmail.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        DocEmail.setPreferredSize(new java.awt.Dimension(100, 20));
        DocEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocEmailActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel21.setText("User Roll");

        UserRolll.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doctor" }));
        UserRolll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserRolllActionPerformed(evt);
            }
        });

        DocMobile.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        DocMobile.setPreferredSize(new java.awt.Dimension(100, 20));
        DocMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocMobileActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel22.setText("Mobile");

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

        receptionistslabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        receptionistslabel.setForeground(new java.awt.Color(0, 255, 204));
        receptionistslabel.setText("Receptionists");
        receptionistslabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receptionistslabelMouseClicked(evt);
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
                    .addComponent(receptionistslabel)
                    .addComponent(jLabel14))
                .addContainerGap(41, Short.MAX_VALUE))
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
                .addComponent(receptionistslabel)
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

        openeye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dentalclinicsystem/open eye.png"))); // NOI18N
        openeye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openeyeMouseClicked(evt);
            }
        });

        closeeye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dentalclinicsystem/closeeye.png"))); // NOI18N
        closeeye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeeyeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel22)
                        .addGap(165, 165, 165)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(UserRolll, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addGap(155, 155, 155)
                                .addComponent(jLabel20)
                                .addGap(74, 74, 74))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DocName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DocMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(49, 49, 49))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(61, 61, 61)))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(141, 141, 141)
                                                .addComponent(jLabel17))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(98, 98, 98)
                                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(openeye)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(closeeye))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(DocEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(docConPass, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(docPass, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(46, 46, 46))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(304, 304, 304)
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(5, 5, 5)
                                        .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12))
                                    .addComponent(jScrollPane1))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1)
                    .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel18)
                        .addComponent(jLabel17))
                    .addComponent(openeye, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeeye, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DocName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DocEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(docPass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(docConPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UserRolll, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DocMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void DocNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocNameActionPerformed

    }//GEN-LAST:event_DocNameActionPerformed

    private void DocEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocEmailActionPerformed

    }//GEN-LAST:event_DocEmailActionPerformed

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked

        // save new user 
        createData(DocName.getText(), DocEmail.getText(), docPass.getText(), docConPass.getText(), UserRolll.getSelectedItem().toString(), DocMobile.getText());
        //update table
        DoctorTable.setModel(DbUtils.resultSetToTableModel(displayData(UserRolll.getSelectedItem().toString())));
        //cleat text field
        Clear();
    }//GEN-LAST:event_saveMouseClicked

    private void UserRolllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserRolllActionPerformed

    }//GEN-LAST:event_UserRolllActionPerformed


    private void DoctorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoctorTableMouseClicked

        DefaultTableModel model = (DefaultTableModel) DoctorTable.getModel();
        int MyIndex = DoctorTable.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        DocName.setText(model.getValueAt(MyIndex, 1).toString());
        DocEmail.setText(model.getValueAt(MyIndex, 2).toString());
        DocMobile.setText(model.getValueAt(MyIndex, 3).toString());


    }//GEN-LAST:event_DoctorTableMouseClicked

    private void DocMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocMobileActionPerformed

    }//GEN-LAST:event_DocMobileActionPerformed

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked

        // save new user 
        editData(Key, DocName.getText(), DocEmail.getText(), docPass.getText(), docConPass.getText(), UserRolll.getSelectedItem().toString(), DocMobile.getText());
        //update table
        DoctorTable.setModel(DbUtils.resultSetToTableModel(displayData(UserRolll.getSelectedItem().toString())));
        //clear text field
        Clear();
    }//GEN-LAST:event_editMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked

        //Delete user
        deleteData(Key, "USERID", "USERTBL");
        //update table
        DoctorTable.setModel(DbUtils.resultSetToTableModel(displayData(UserRolll.getSelectedItem().toString())));
        //clear text field
        Clear();
    }//GEN-LAST:event_deleteMouseClicked

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        Clear();
    }//GEN-LAST:event_clearMouseClicked

    private void receptionistslabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionistslabelMouseClicked
        new receptionists().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_receptionistslabelMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        login.logout();

        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

    private void dashboardlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardlabelMouseClicked
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardlabelMouseClicked

    private void openeyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openeyeMouseClicked
        // TODO add your handling code here:

        docPass.setEchoChar((char) 0);
        docConPass.setEchoChar((char) 0);
    }//GEN-LAST:event_openeyeMouseClicked

    private void closeeyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeeyeMouseClicked
        // TODO add your handling code here:

        docPass.setEchoChar('*');
        docConPass.setEchoChar('*');
    }//GEN-LAST:event_closeeyeMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doctors().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DocEmail;
    private javax.swing.JTextField DocMobile;
    private javax.swing.JTextField DocName;
    private javax.swing.JTable DoctorTable;
    private javax.swing.JComboBox<String> UserRolll;
    private javax.swing.JButton clear;
    private javax.swing.JLabel closeeye;
    private javax.swing.JLabel dashboardlabel;
    private javax.swing.JButton delete;
    private javax.swing.JPasswordField docConPass;
    private javax.swing.JPasswordField docPass;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel openeye;
    private javax.swing.JLabel receptionistslabel;
    private javax.swing.JButton save;
    private javax.swing.JLabel usernameDisplay;
    // End of variables declaration//GEN-END:variables
}
