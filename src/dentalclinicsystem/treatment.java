package dentalclinicsystem;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author akash
 */
public class treatment extends user {

    public treatment() {
        initComponents();

        IdGenerator("TREATMENTId", "TREATMENTTbl");

        DisplayTreatment();

        //display logedusername
        Login login = new Login();
        usernameDisplay.setText(login.LoggerName());
    }

    private void AddTreatment() {
        if (TreatName.getText().isEmpty() || TreatCost.getText().isEmpty() || TreatMed.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information");
        } else {
            try {
                // int PatKey = 1;
                IdGenerator("TREATMENTId", "TREATMENTTbl");

                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
                PreparedStatement add = Con.prepareStatement("insert into TreatmentTbl values(?,?,?,?)");
                add.setInt(1, id);
                add.setString(2, TreatName.getText());
                add.setInt(3, Integer.valueOf(TreatCost.getText()));
                add.setString(4, TreatMed.getText());

                int row = add.executeUpdate();

                JOptionPane.showMessageDialog(this, "Patient Added Successfully");
                Con.close();
                DisplayTreatment();
                Clear();
            } catch (Exception Ex) {
                Ex.printStackTrace();
            }
        }
    }

    private void EditTreatment() {
        if (Key == 1000) {
            JOptionPane.showMessageDialog(this, "Select The Treatment");
        } else {
            try {

                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
                String Query = "Update Root.TreatmentTbl set TREATMENTNAME='" + TreatName.getText() + "'" + ", TREATMENTCOST=" + TreatCost.getText() + "" + ", TREATMENTMED='" + TreatMed.getText() + "'" + "  where TREATMENTID=" + Key;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                JOptionPane.showMessageDialog(this, "Treatment Updated Successfully");

                DisplayTreatment();
                Clear();

            } catch (Exception Ex) {
                Ex.printStackTrace();
            }
        }

    }

    private void DisplayTreatment() {

        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
            St = (Statement) Con.createStatement();
            Rs = St.executeQuery("Select * from root.TreatmentTbl ");
            TreatmentTable.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception Ex) {

        }
    }

    private void Clear() {
        TreatName.setText("");
        TreatCost.setText("");
        TreatMed.setText("");
        Key = 1000;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TreatmentTable = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        TreatMed = new javax.swing.JTextField();
        TreatCost = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        TreatName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dashboardlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameDisplay = new javax.swing.JLabel();

        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setText("Treatments");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Name");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setText("Cost");

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
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

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
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
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

        TreatmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Treatment Name", "Cost", "Medicines"
            }
        ));
        TreatmentTable.setSelectionBackground(new java.awt.Color(0, 204, 255));
        TreatmentTable.setSelectionForeground(new java.awt.Color(0, 51, 51));
        TreatmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TreatmentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TreatmentTable);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel19.setText("Treatment List");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel18.setText("Medicines");

        TreatMed.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        TreatMed.setPreferredSize(new java.awt.Dimension(100, 20));
        TreatMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TreatMedActionPerformed(evt);
            }
        });

        TreatCost.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        TreatCost.setPreferredSize(new java.awt.Dimension(100, 20));
        TreatCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TreatCostActionPerformed(evt);
            }
        });

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
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        TreatName.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        TreatName.setPreferredSize(new java.awt.Dimension(100, 20));
        TreatName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TreatNameActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setMinimumSize(new java.awt.Dimension(193, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(169, 434));

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
                .addGap(165, 165, 165)
                .addComponent(dashboardlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(183, 183, 183)
                        .addComponent(jLabel18)
                        .addGap(99, 99, 99))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TreatName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(TreatCost, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(TreatMed, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(288, 288, 288))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(33, 33, 33)
                        .addComponent(TreatMed, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TreatName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TreatCost, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TreatCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TreatCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TreatCostActionPerformed

    private void TreatMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TreatMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TreatMedActionPerformed

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        Clear();
    }//GEN-LAST:event_clearMouseClicked


    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        AddTreatment();

    }//GEN-LAST:event_saveMouseClicked


    private void TreatNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TreatNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TreatNameActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    int Key = 1000;
    private void TreatmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TreatmentTableMouseClicked

        DefaultTableModel model = (DefaultTableModel) TreatmentTable.getModel();
        int MyIndex = TreatmentTable.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        TreatName.setText(model.getValueAt(MyIndex, 1).toString());
        TreatCost.setText(model.getValueAt(MyIndex, 2).toString());
        TreatMed.setText(model.getValueAt(MyIndex, 3).toString());

    }//GEN-LAST:event_TreatmentTableMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked

        deleteuser(Key, "TreatmentId", "TreatmentTbl");
        DisplayTreatment();
    }//GEN-LAST:event_deleteMouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
        EditTreatment();
    }//GEN-LAST:event_editMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

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
            java.util.logging.Logger.getLogger(treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(treatment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new treatment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TreatCost;
    private javax.swing.JTextField TreatMed;
    private javax.swing.JTextField TreatName;
    private javax.swing.JTable TreatmentTable;
    private javax.swing.JButton clear;
    private javax.swing.JLabel dashboardlabel;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
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
