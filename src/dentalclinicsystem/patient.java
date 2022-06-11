
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
public class patient extends javax.swing.JFrame {

 
    public patient() {
        initComponents();
        DisplayPatient();
        PatCount();
        
         
       //display logedusername

        Login login = new Login();
       usernameDisplay.setText(login.LoggerName());

    }
    

Connection Con = null;
Statement St = null , St1 = null;
ResultSet Rs = null, Rs1 = null;

// addpatient
    boolean Patname;
 protected void addpatient(){
   //chek patient name  is already exsit
       
        
            try{
         Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
         St = (Statement) Con.createStatement();
         Rs = St.executeQuery("Select * from root.PATIENTTBL where PATNAME='"+PatName.getText()+"'");
        
         if(Rs.next()){
          Patname = true;
         }
         else{ 
          Patname =false;
         }
     }catch(Exception Ex){
               
            }
            
            //if  name not exists then store data
        if(Patname == true){
              JOptionPane.showMessageDialog(this, "Patient Name Already exsist");
        }
        else{
        
        if(PatName.getText().isEmpty() || PatEmail.getText().isEmpty() ||PatAllergies.getText().isEmpty() ||PatMobile.getText().isEmpty() || PatAddress.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing Information");
        }else{
            try{
               // int PatKey = 1;
                PatCount();
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
                PreparedStatement add = Con.prepareStatement("insert into PatientTbl values(?,?,?,?,?,?,?,?)");
                add.setInt(1, PatId);
                add.setString(2, PatName.getText());
                add.setString(3, PatMobile.getText());
                add.setString(4, PatGender.getSelectedItem().toString() );
                add.setString(5, PatAllergies.getText());
                add.setString(6, PatAddress.getText());
                add.setString(7, PatDOB.getDate().toString());
                add.setString(8, PatEmail.getText());
          
              
               int row = add.executeUpdate();
                 JOptionPane.showMessageDialog(this, "Patient Added Successfully");
               Con.close();
                DisplayPatient();
                  Clear();
            }catch(Exception Ex){
                Ex.printStackTrace();
            }
    }}
 
 } 

  int PatId = 0;
    protected void PatCount(){
    try{
        St1 = Con.createStatement();
        Rs1 = St1.executeQuery("select Max(PatId) from Root.PatientTbl");
        Rs1.next();
        PatId = Rs1.getInt(1)+1;
       
    }
    catch(Exception Ex){
        Ex.printStackTrace();
    }
    }
    
   //edit patient
 protected void editpatient(){
   //chek patient name and email is already exsit in other ids
       
        
          try{
         Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
         St = (Statement) Con.createStatement();
         Rs = St.executeQuery("Select * from root.PATIENTTBL where PATNAME='"+PatName.getText()+"'");
        
         if(Rs.next()){
            
             if(Key != Rs.getInt("PATID")){
                
                 Patname = true;
             }else{
                   Patname = false;      
             }
         }
         else{ 
          Patname =false;
         }
         
         
     }catch(Exception Ex){
               
            }
            
              //if patient  name not exists in other records then store data
        if(Patname == true){
              JOptionPane.showMessageDialog(this, "Patient Name Already exsist" );
        }
        else{
        
        if(Key == 0){
            JOptionPane.showMessageDialog(this, "Select The Patient");
        }else{
            try{
                
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
               String Query = "Update Root.PatientTbl set PatName='"+PatName.getText()+"'"+", PatMobile='"+PatMobile.getText()+"'"+", PatEmail='"+PatEmail.getText()+"'"+", PatGender='"+PatGender.getSelectedItem()+"'"+", PatAllergies='"+PatAllergies.getText()+"'"+", PatAddress='"+PatAddress.getText()+"'"+", PatDOB='"+PatDOB.getDate().toString()+"'"+" where PatID="+Key;
               Statement Add = Con.createStatement();
               Add.executeUpdate(Query);
               JOptionPane.showMessageDialog(this, "Patient Updated Successfully");
            
                DisplayPatient();
                   Clear();
                  
            }catch(Exception Ex){
                Ex.printStackTrace();
            }
    }
       }
 }
 
 //delete patient
 protected void deletePatient(){
 
  if(Key == 0){
            JOptionPane.showMessageDialog(this, "Select The Patient");
        }else{
            try{
                
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
               String Query = "Delete from Root.PatientTbl where PatId="+Key;
               Statement Add = Con.createStatement();
               Add.executeUpdate(Query);
               JOptionPane.showMessageDialog(this, "Patient Deleted Successfully");
            
                DisplayPatient();
                     Clear();  
            }catch(Exception Ex){
                Ex.printStackTrace();
            }
    }
 }
 
 //display patient
    protected void DisplayPatient(){
    
     try{
         Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
         St = (Statement) Con.createStatement();
         Rs = St.executeQuery("Select * from root.PatientTbl ");
         PatientTable.setModel(DbUtils.resultSetToTableModel(Rs));
     }catch(Exception Ex){
               
            }
    }
    
 // clear text field data
  protected void Clear(){
     PatName.setText("");
     PatMobile.setText("");
     PatEmail.setText("");
     PatAllergies.setText("");
     PatAddress.setText("");
     PatDOB.setCalendar(null);
     PatGender.setSelectedItem("");
     
     
    }
 
 
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PatName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        PatEmail = new javax.swing.JTextField();
        PatMobile = new javax.swing.JTextField();
        PatGender = new javax.swing.JComboBox<>();
        PatDOB = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PatientTable = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        PatAddress = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        PatAllergies = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Patientlabel = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        dashboardlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameDisplay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(2, 89, 0));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));

        PatName.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        PatName.setPreferredSize(new java.awt.Dimension(100, 20));
        PatName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatNameActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setText("Patients");

        PatEmail.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        PatEmail.setPreferredSize(new java.awt.Dimension(100, 20));
        PatEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatEmailActionPerformed(evt);
            }
        });

        PatMobile.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        PatMobile.setPreferredSize(new java.awt.Dimension(100, 20));
        PatMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatMobileActionPerformed(evt);
            }
        });

        PatGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        PatGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatGenderActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Name");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setText("Mobile");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel15.setText("Email");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setText("Gender");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel17.setText("DOB");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel18.setText("Allergies");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 255, 204));
        jButton1.setText("Edit");
        jButton1.setPreferredSize(new java.awt.Dimension(75, 26));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 255, 204));
        jButton2.setText("Save");
        jButton2.setPreferredSize(new java.awt.Dimension(75, 26));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 255, 204));
        jButton3.setText("Delete");
        jButton3.setPreferredSize(new java.awt.Dimension(75, 26));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        PatientTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        PatientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Patient Name", "Mobile Number", "Address", "Gender", "DOB", "Alergies", "Email"
            }
        ));
        PatientTable.setRowHeight(24);
        PatientTable.setSelectionBackground(new java.awt.Color(0, 204, 255));
        PatientTable.setSelectionForeground(new java.awt.Color(0, 51, 51));
        PatientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PatientTable);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel19.setText("Patients List");

        PatAddress.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        PatAddress.setPreferredSize(new java.awt.Dimension(100, 20));
        PatAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatAddressActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel20.setText("Address");

        PatAllergies.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        PatAllergies.setPreferredSize(new java.awt.Dimension(100, 20));
        PatAllergies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatAllergiesActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 255, 204));
        jButton4.setText("Clear");
        jButton4.setPreferredSize(new java.awt.Dimension(75, 26));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setMinimumSize(new java.awt.Dimension(193, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(169, 434));

        Patientlabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Patientlabel.setForeground(new java.awt.Color(0, 255, 204));
        Patientlabel.setText("Appointments");
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

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 255, 204));
        jLabel21.setText("Dental Clinic ");

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
                    .addComponent(jLabel21))
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
                .addComponent(jLabel21)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(jLabel14)
                                        .addGap(144, 144, 144)
                                        .addComponent(jLabel20)
                                        .addGap(110, 110, 110)
                                        .addComponent(jLabel17))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(PatAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                            .addComponent(PatEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(141, 141, 141)
                                        .addComponent(PatAllergies, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addGap(7, 7, 7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(94, 94, 94)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(PatName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PatMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PatDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(172, 172, 172))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(PatGender, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15)
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabel16)
                                        .addGap(13, 13, 13)))
                                .addGap(89, 89, 89)
                                .addComponent(jLabel18)
                                .addGap(79, 79, 79)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(310, 310, 310))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PatAllergies, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PatName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PatEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PatGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel20)
                            .addComponent(jLabel17))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PatMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PatAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PatDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
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

    private void PatNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatNameActionPerformed

    private void PatEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatEmailActionPerformed

    private void PatMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatMobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatMobileActionPerformed

    private void PatGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatGenderActionPerformed

    private void PatAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatAddressActionPerformed


 
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:gfghfgfgfgfgfgfgdsfgdfgdfgdfdsf
        addpatient();
      
    }//GEN-LAST:event_jButton2MouseClicked

    private void PatAllergiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatAllergiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatAllergiesActionPerformed

    
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       editpatient();
    }//GEN-LAST:event_jButton1MouseClicked

    int Key=0;
    private void PatientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) PatientTable.getModel();
        int MyIndex = PatientTable.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        PatName.setText(model.getValueAt(MyIndex, 1).toString());
        PatMobile.setText(model.getValueAt(MyIndex, 2).toString());
        PatGender.setSelectedItem(model.getValueAt(MyIndex,3).toString());
        PatAllergies.setText(model.getValueAt(MyIndex, 4).toString());
        PatAddress.setText(model.getValueAt(MyIndex, 5).toString());
        //PatDOB.setText(model.getValueAt(MyIndex, 6).toString());ccccccccccccccccccccccccccccccccccccccccccccccccccccc
         PatEmail.setText(model.getValueAt(MyIndex, 7).toString());
    }//GEN-LAST:event_PatientTableMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:ddddddddddddddddddddddddddddddddddd
       deletePatient();
    }//GEN-LAST:event_jButton3MouseClicked

   
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
       Clear();
    }//GEN-LAST:event_jButton4MouseClicked

    private void PatientlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientlabelMouseClicked
        new appointments().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PatientlabelMouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        login.logout();

        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PatAddress;
    private javax.swing.JTextField PatAllergies;
    private com.toedter.calendar.JDateChooser PatDOB;
    private javax.swing.JTextField PatEmail;
    private javax.swing.JComboBox<String> PatGender;
    private javax.swing.JTextField PatMobile;
    private javax.swing.JTextField PatName;
    private javax.swing.JTable PatientTable;
    private javax.swing.JLabel Patientlabel;
    private javax.swing.JLabel dashboardlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel usernameDisplay;
    // End of variables declaration//GEN-END:variables
}
