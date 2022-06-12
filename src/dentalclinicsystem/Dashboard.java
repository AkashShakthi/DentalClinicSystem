/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dentalclinicsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author akash
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form dashboard
     */
    public Dashboard() {
        initComponents();

        Login log = new Login();
        if (log.LogedUserRoll.equals("Admin")) {
            receptionistlabel.show();
            doctorlabel.show();
            patientslabel.hide();
            appointmentslabel.hide();
            Treatmentslabel.hide();

            adminDashboard();

            P1.show();
            p2.show();
            pcount.show();

            ap1.show();
            ap2.show();
            apcount.show();

            u1.show();
            u2.show();
            ucount.show();

            t11.show();
            t22.show();
            tcount2.show();

            t1.hide();
            t2.hide();
            tcount.hide();

        }

        if (log.LogedUserRoll.equals("Doctor")) {
            receptionistlabel.hide();
            doctorlabel.hide();
            patientslabel.hide();
            appointmentslabel.hide();
            Treatmentslabel.show();

            DoctorDashboard();

            t1.show();
            t2.show();
            tcount.show();

            ap1.show();
            ap2.show();
            apcount.show();

            P1.hide();
            p2.hide();
            pcount.hide();

            u1.hide();
            u2.hide();
            ucount.hide();

            t11.hide();
            t22.hide();
            tcount2.hide();

        }
        if (log.LogedUserRoll.equals("Receptionist")) {
            receptionistlabel.hide();
            doctorlabel.hide();
            patientslabel.show();
            appointmentslabel.show();
            Treatmentslabel.hide();

            receptionistDashboard();

            P1.show();
            p2.show();
            pcount.show();

            ap1.show();
            ap2.show();
            apcount.show();

            t1.hide();
            t2.hide();
            tcount.hide();

            u1.hide();
            u2.hide();
            ucount.hide();

            t11.hide();
            t22.hide();
            tcount2.hide();

        }

        usernameDisplay.setText(log.LoggerName());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    //for sql connections
    Connection Con = null;
    Statement St = null, St1 = null, St2 = null, St3 = null;
    ResultSet Rs = null, Rs1 = null, Rs2 = null, Rs3 = null;


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        receptionistlabel = new javax.swing.JLabel();
        Treatmentslabel = new javax.swing.JLabel();
        appointmentslabel = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        patientslabel = new javax.swing.JLabel();
        doctorlabel = new javax.swing.JLabel();
        u1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        apcount = new javax.swing.JLabel();
        u2 = new javax.swing.JLabel();
        t22 = new javax.swing.JLabel();
        t11 = new javax.swing.JLabel();
        ucount = new javax.swing.JLabel();
        P1 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        pcount = new javax.swing.JLabel();
        ap1 = new javax.swing.JLabel();
        ap2 = new javax.swing.JLabel();
        tcount2 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        tcount = new javax.swing.JLabel();
        usernameDisplay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(169, 434));

        receptionistlabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        receptionistlabel.setForeground(new java.awt.Color(0, 255, 204));
        receptionistlabel.setText("Receptionists");
        receptionistlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receptionistlabelMouseClicked(evt);
            }
        });

        Treatmentslabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Treatmentslabel.setForeground(new java.awt.Color(0, 255, 204));
        Treatmentslabel.setText("Treatments");
        Treatmentslabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TreatmentslabelMouseClicked(evt);
            }
        });

        appointmentslabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        appointmentslabel.setForeground(new java.awt.Color(0, 255, 204));
        appointmentslabel.setText("Appointments");
        appointmentslabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentslabelMouseClicked(evt);
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

        patientslabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        patientslabel.setForeground(new java.awt.Color(0, 255, 204));
        patientslabel.setText("Patients");
        patientslabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientslabelMouseClicked(evt);
            }
        });

        doctorlabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        doctorlabel.setForeground(new java.awt.Color(0, 255, 204));
        doctorlabel.setText("Doctors");
        doctorlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorlabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doctorlabel)
                    .addComponent(appointmentslabel)
                    .addComponent(receptionistlabel)
                    .addComponent(jLabel14)
                    .addComponent(Treatmentslabel)
                    .addComponent(patientslabel))
                .addContainerGap(31, Short.MAX_VALUE))
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
                .addGap(93, 93, 93)
                .addComponent(doctorlabel)
                .addGap(18, 18, 18)
                .addComponent(Treatmentslabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(patientslabel)
                .addGap(18, 18, 18)
                .addComponent(receptionistlabel)
                .addGap(7, 7, 7)
                .addComponent(appointmentslabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(48, 48, 48))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 193, 600);

        u1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        u1.setText("Users");
        jPanel1.add(u1);
        u1.setBounds(330, 370, 70, 23);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel13.setText("Dashboard");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(790, 10, 100, 23);

        apcount.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        apcount.setText("NUM");
        jPanel1.add(apcount);
        apcount.setBounds(690, 270, 70, 31);

        u2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dentalclinicsystem/users.png"))); // NOI18N
        jPanel1.add(u2);
        u2.setBounds(310, 400, 100, 130);

        t22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dentalclinicsystem/treatment.png"))); // NOI18N
        jPanel1.add(t22);
        t22.setBounds(660, 410, 110, 120);

        t11.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        t11.setText("Treatments");
        jPanel1.add(t11);
        t11.setBounds(640, 370, 150, 23);

        ucount.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        ucount.setText("Num");
        jPanel1.add(ucount);
        ucount.setBounds(340, 530, 70, 30);

        P1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        P1.setText("Patients");
        jPanel1.add(P1);
        P1.setBounds(310, 90, 100, 23);

        p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dentalclinicsystem/patient.png"))); // NOI18N
        jPanel1.add(p2);
        p2.setBounds(310, 130, 110, 120);

        pcount.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        pcount.setText("Num");
        jPanel1.add(pcount);
        pcount.setBounds(340, 270, 70, 30);

        ap1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        ap1.setText("Appointments");
        jPanel1.add(ap1);
        ap1.setBounds(630, 90, 190, 23);

        ap2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dentalclinicsystem/appointment.png"))); // NOI18N
        jPanel1.add(ap2);
        ap2.setBounds(670, 130, 110, 130);

        tcount2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        tcount2.setText("Num");
        jPanel1.add(tcount2);
        tcount2.setBounds(690, 530, 70, 30);

        t2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dentalclinicsystem/treatment.png"))); // NOI18N
        jPanel1.add(t2);
        t2.setBounds(310, 130, 110, 120);

        t1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        t1.setText("Treatments");
        jPanel1.add(t1);
        t1.setBounds(290, 90, 150, 23);

        tcount.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        tcount.setText("Num");
        jPanel1.add(tcount);
        tcount.setBounds(340, 270, 70, 30);

        usernameDisplay.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        usernameDisplay.setForeground(new java.awt.Color(0, 51, 51));
        usernameDisplay.setText("User");
        jPanel1.add(usernameDisplay);
        usernameDisplay.setBounds(230, 10, 130, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dentalclinicsystem/logger.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(200, 10, 25, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void doctorlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorlabelMouseClicked
        // TODO add your handling code here:
        new doctors().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_doctorlabelMouseClicked

    private void patientslabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientslabelMouseClicked
        // TODO add your handling code here:
        new patient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_patientslabelMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        Login log = new Login();
        log.logout();

        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

    private void appointmentslabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentslabelMouseClicked
        new appointments().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_appointmentslabelMouseClicked

    private void TreatmentslabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TreatmentslabelMouseClicked
        new treatment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TreatmentslabelMouseClicked

    private void receptionistlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionistlabelMouseClicked

        new receptionists().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_receptionistlabelMouseClicked

    private void receptionistDashboard() {
        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
            St = Con.createStatement();
            St1 = Con.createStatement();
            Rs = St.executeQuery("select count(*) from Root.PATIENTTBL");
            Rs1 = St1.executeQuery("select count(*) from Root.APPOINTMENTTBL");
            while (Rs.next()) {
                pcount.setText(" " + Rs.getInt(1));
            }
            while (Rs1.next()) {
                apcount.setText(" " + Rs1.getInt(1));
            }
        } catch (Exception e) {
        }
    }

    private void DoctorDashboard() {
        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
            St = Con.createStatement();
            St1 = Con.createStatement();
            Rs = St.executeQuery("select count(*) from Root.TREATMENTTBL");
            Rs1 = St1.executeQuery("select count(*) from Root.APPOINTMENTTBL");
            while (Rs.next()) {
                tcount.setText(" " + Rs.getInt(1));
            }
            while (Rs1.next()) {
                apcount.setText(" " + Rs1.getInt(1));
            }
        } catch (Exception e) {
        }
    }

    private void adminDashboard() {
        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
            St = Con.createStatement();
            St1 = Con.createStatement();
            St2 = Con.createStatement();
            St3 = Con.createStatement();
            Rs = St.executeQuery("select count(*) from Root.USERTBL");
            Rs1 = St1.executeQuery("select count(*) from Root.APPOINTMENTTBL");
            Rs2 = St2.executeQuery("select count(*) from Root.PATIENTTBL");
            Rs3 = St3.executeQuery("select count(*) from Root.TREATMENTTBL");
            while (Rs.next()) {
                ucount.setText(" " + Rs.getInt(1));

            }
            while (Rs1.next()) {
                apcount.setText(" " + Rs1.getInt(1));
            }
            while (Rs2.next()) {
                pcount.setText(" " + Rs2.getInt(1));
            }
            while (Rs3.next()) {
                tcount2.setText(" " + Rs3.getInt(1));
            }
        } catch (Exception e) {
        }
    }

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel P1;
    private javax.swing.JLabel Treatmentslabel;
    private javax.swing.JLabel ap1;
    private javax.swing.JLabel ap2;
    private javax.swing.JLabel apcount;
    private javax.swing.JLabel appointmentslabel;
    private javax.swing.JLabel doctorlabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel patientslabel;
    private javax.swing.JLabel pcount;
    private javax.swing.JLabel receptionistlabel;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t11;
    private javax.swing.JLabel t2;
    private javax.swing.JLabel t22;
    private javax.swing.JLabel tcount;
    private javax.swing.JLabel tcount2;
    private javax.swing.JLabel u1;
    private javax.swing.JLabel u2;
    private javax.swing.JLabel ucount;
    private javax.swing.JLabel usernameDisplay;
    // End of variables declaration//GEN-END:variables
}
