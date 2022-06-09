
package dentalclinicsystem;

//import java.beans.Statement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author akash
 */



public class user extends javax.swing.JFrame {

    //for sql connections
Connection Con = null;
Statement St = null , St1 = null , St2 = null;
ResultSet Rs = null, Rs1 = null ,Rs2 = null ;

    
    int id = 0;
    
    String Name;
    String email;
    String password;
    String conPassword;
    String userRoll;
    String userMobile;
    
    
    
    static boolean userexsist;
    
    //for login
    static  boolean isuserlogged = false;
    static  String LogedUserRoll = "";
    static  int logeduserid = 0 , emailuid=0, passuid=0;
    
   //userroll controll
   //static  boolean admin=false, doctor=false,receptionist=false;
    
    // for counting users and get next user id
    public void userCount(){
    try{
        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
        St1 = Con.createStatement();
        Rs1 = St1.executeQuery("select Max(USERID) from Root.USERTBL");
        Rs1.next();
        id = Rs1.getInt(1)+1;
       
    }
    catch(Exception Ex){
        Ex.printStackTrace();
    }
    }
    
    // class for create new user
     public void createuser( String Name, String email, String password, String conPassword , String userRoll , String userMobile ){
         
         this.Name = Name;
         this.email = email;
         this.password = password;
         this.conPassword = conPassword;
         this.userRoll = userRoll;
         this.userMobile = userMobile;
         
         
         
         if (Name.isEmpty() || email.isEmpty() || password.isEmpty() || conPassword.isEmpty() || userMobile.isEmpty()){
              JOptionPane.showMessageDialog(this,"Missing Information");
         }else if (!password.equals(conPassword) ){
              JOptionPane.showMessageDialog(this,"Password Missmatch");
         }else if (checkuserexist(email) == true){
              JOptionPane.showMessageDialog(this,"This email's user already exsist");
         }else{
         
             try{
                 userCount();
               
               Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
                PreparedStatement add = Con.prepareStatement("insert into UserTbl values(?,?,?,?,?,?)");
                add.setInt(1, id);
                add.setString(2, Name);
                add.setString(3,email);
                add.setString(4, userRoll);
                add.setString(5, password);
                add.setString(6, userMobile);
               
                int row = add.executeUpdate();
               
                 JOptionPane.showMessageDialog(this, userRoll + " Added Successfully");
               this.Con.close();
              
                 
             }catch(Exception Ex){
                  Ex.printStackTrace();
             }
         
         
         }
         
         
         
         
     }
     
    // class for edit user
     public void edituser( int Key, String Name, String email, String password, String conPassword , String userRoll , String userMobile){
          
         this.Name = Name;
         this.email = email;
         this.password = password;
         this.conPassword = conPassword;
         this.userRoll = userRoll;
         this.userMobile = userMobile;
         
         
              if(Key == 0){
            JOptionPane.showMessageDialog(this, "Select The user" );
        }else{
            try{
                
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
               String Query;
             
              
              if(!Name.isEmpty()){
              Query= "Update Root.USERTBL set  USERNAME='"+Name+"'"+" where USERID="+Key;
              Statement Add = Con.createStatement();
              Add.executeUpdate(Query);
              }
              if(!email.isEmpty()){
              Query= "Update Root.USERTBL set  USEREMAIL='"+email+"'"+" where USERID="+Key;
              Statement Add = Con.createStatement();
              Add.executeUpdate(Query);
              }
                if(!password.isEmpty()){
              Query= "Update Root.USERTBL set  USERPASSWORD='"+password+"'"+" where USERID="+Key;
              Statement Add = Con.createStatement();
              Add.executeUpdate(Query);
              }
                 if(!userMobile.isEmpty()){
              Query= "Update Root.USERTBL set  USERMOBILE='"+userMobile+"'"+" where USERID="+Key;
              Statement Add = Con.createStatement();
              Add.executeUpdate(Query);
              }
              
                
               JOptionPane.showMessageDialog(this, "user Updated Successfully");
            
      
                  
            }catch(Exception Ex){
                Ex.printStackTrace();
            }
    }
         
     }
        
    public void deleteuser(int Key){
       
           if(Key == 0){
            JOptionPane.showMessageDialog(this, "Select The User");
        }else{
            try{
                
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
               String Query = "Delete from Root.USERTBL where USERId="+Key;
               Statement Add = Con.createStatement();
               Add.executeUpdate(Query);
               JOptionPane.showMessageDialog(this, "User Deleted Successfully");
            
                
            }catch(Exception Ex){
                Ex.printStackTrace();
            }
    }
     }
        
    
    // class for display user data on table
    public ResultSet displayuser(String UserRoll){
    
     try{
         Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
         St = (Statement) Con.createStatement();
         Rs = St.executeQuery("Select USERID,USERNAME,USEREMAIL,USERMOBILE from root.USERTBL where USERROLL ='"+UserRoll+"'");
        
     }catch(Exception Ex){
               
            }
     return Rs;
    }
    
    
    
    //chek user exist
    public boolean checkuserexist(String email){
        this.email = email;
        
        
       try{
         Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
         St = (Statement) Con.createStatement();
         Rs = St.executeQuery("Select * from root.USERTBL where USEREMAIL='"+email+"'");
        
         if(Rs.next()){
          userexsist = true;
         }
         else{ 
          userexsist =false;
         }
     }catch(Exception Ex){
               
            }
       return userexsist;
       
    }
     
    
    
    //check login user
    public boolean checkloginuser(String email, String password ){
         this.email = email;
         this.password = password;
       
       try{
         Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
         St = (Statement) Con.createStatement();
         St1 = (Statement) Con.createStatement();
         
         Rs = St.executeQuery("Select USERID from root.USERTBL where USEREMAIL='"+email+"'");
         Rs1 = St1.executeQuery("Select USERID from root.USERTBL where USERPASSWORD='"+password+"'");
         Rs.next();
         Rs1.next();
        
           emailuid = Rs.getInt("USERID");
          
           passuid = Rs1.getInt("USERID");
         
       
         if(emailuid == passuid){
           
          logeduserid = Rs.getInt("USERID");
       
          
          St2 = (Statement) Con.createStatement();
          Rs2 = St2.executeQuery("Select USERROLL from root.USERTBL where USERID="+logeduserid);
          Rs2.next();
          LogedUserRoll = Rs2.getString("USERROLL");
          isuserlogged =true;
          
         }
         else{ 
          isuserlogged =false;
          LogedUserRoll = "";
          logeduserid = 0;
         }
     }catch(Exception Ex){
               Ex.printStackTrace();
            }
    return isuserlogged;
    }
     
     
    
    //logout
    public void logout(){
    
    isuserlogged =false;
    LogedUserRoll = "";
    logeduserid = 0 ;
    emailuid=0 ; passuid=0;
    }
    
    
     public static void main(String[] args) {
  
       
       
         
         
  }
     

    
}
