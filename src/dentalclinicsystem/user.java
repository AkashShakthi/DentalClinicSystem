package dentalclinicsystem;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

//for password hasing
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author akash
 */
public class user extends javax.swing.JFrame {
    
    

    //for sql connections
    Connection Con = null;
    Statement St = null, St1 = null, St2 = null ,St3 =null;
    ResultSet Rs = null, Rs1 = null, Rs2 = null ,Rs3 =null;

    int id = 0;
    String Name;
    String email;
    String password;
    String conPassword;
    String userRoll;
    String userMobile;
    
        // for counting users and get next user id
    public void UserIdGenerator() {
        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("select Max(USERID) from Root.USERTBL");
            Rs1.next();
            id = Rs1.getInt(1) + 1;

        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
    }

    
    // class for create new user
    public void createuser(String Name, String email, String pass, String conPass, String userRoll, String userMobile) {

        this.Name = Name;
        this.email = email;
        this.password = PasswordEncryptor(pass);
        this.conPassword = PasswordEncryptor(conPass);
        this.userRoll = userRoll;
        this.userMobile = userMobile;

        if (Name.isEmpty() || email.isEmpty() || password.isEmpty() || conPassword.isEmpty() || userMobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing Information");
        } else if (!password.equals(conPassword)) {
            JOptionPane.showMessageDialog(this, "Password Missmatch");
        } else if (checkuserexist(email) == true) {
            JOptionPane.showMessageDialog(this, "This email's user already exsist");
        } else {

            try {
                UserIdGenerator();

                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
                PreparedStatement add = Con.prepareStatement("insert into UserTbl values(?,?,?,?,?,?)");
                add.setInt(1, id);
                add.setString(2, Name);
                add.setString(3, email);
                add.setString(4, userRoll);
                add.setString(5, password);
                add.setString(6, userMobile);

                int row = add.executeUpdate();

                JOptionPane.showMessageDialog(this, userRoll + " Added Successfully");
                this.Con.close();

            } catch (Exception Ex) {
                Ex.printStackTrace();
            }

        }

    }

    
    // class for edit user
    public void edituser(int Key, String Name, String email, String pass, String conPass, String userRoll, String userMobile) {

        this.Name = Name;
        this.email = email;
        this.password = PasswordEncryptor(pass);
        this.conPassword = PasswordEncryptor(conPass);
        this.userRoll = userRoll;
        this.userMobile = userMobile;

        if (Key == 0) {
            JOptionPane.showMessageDialog(this, "Select The user");
        } else {
            try {

                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
                String Query;

                if (!Name.isEmpty()) {
                    Query = "Update Root.USERTBL set  USERNAME='" + Name + "'" + " where USERID=" + Key;
                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                }
                if (!email.isEmpty()) {
                    Query = "Update Root.USERTBL set  USEREMAIL='" + email + "'" + " where USERID=" + Key;
                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                }
                if (!password.isEmpty()) {
                    Query = "Update Root.USERTBL set  USERPASSWORD='" + password + "'" + " where USERID=" + Key;
                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                }
                if (!userMobile.isEmpty()) {
                    Query = "Update Root.USERTBL set  USERMOBILE='" + userMobile + "'" + " where USERID=" + Key;
                    Statement Add = Con.createStatement();
                    Add.executeUpdate(Query);
                }

                JOptionPane.showMessageDialog(this, "user Updated Successfully");

            } catch (Exception Ex) {
                Ex.printStackTrace();
            }
        }

    }


    
    public void deleteuser(int Key) {

        if (Key == 0) {
            JOptionPane.showMessageDialog(this, "Select The User");
        } else {
            try {

                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
                String Query = "Delete from Root.USERTBL where USERId=" + Key;
                Statement Add = Con.createStatement();
                Add.executeUpdate(Query);
                JOptionPane.showMessageDialog(this, "User Deleted Successfully");

            } catch (Exception Ex) {
                Ex.printStackTrace();
            }
        }
    }

    
    // class for display user data on table
    public ResultSet displayUserData(String UserRoll) {

        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
            St = (Statement) Con.createStatement();
            Rs = St.executeQuery("Select USERID,USERNAME,USEREMAIL,USERMOBILE from root.USERTBL where USERROLL ='" + UserRoll + "'");

        } catch (Exception Ex) {

        }
        return Rs;
    }

    
     //password encrpted
    static String text;
    public String PasswordEncryptor(String text) {
        this.text = text;
        String passwordToHash = text;
        String generatedPassword = null;

        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(passwordToHash.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;

    }

    
    
      //chek user Alradyexist
    static boolean userexsist;
    public boolean checkuserexist(String email) {
        this.email = email;

        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb", "root", "root");
            St = (Statement) Con.createStatement();
            Rs = St.executeQuery("Select * from root.USERTBL where USEREMAIL='" + email + "'");

            if (Rs.next()) {
                userexsist = true;
            } else {
                userexsist = false;
            }
        } catch (Exception Ex) {

        }
        return userexsist;

    }

    
 
    

    public static void main(String[] args) {

    }

}
