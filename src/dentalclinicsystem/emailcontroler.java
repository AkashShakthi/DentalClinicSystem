package dentalclinicsystem;

/**
 *
 * @author akash
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.swing.JOptionPane;

public class emailcontroler extends javax.swing.JFrame {

    String from, to, host, sub, content;
    boolean chekIsEmailVerified;

    public void emailSender() {

        from = "dentalclinic.official@gmail.com";
        host = "localhost";

        Properties p = new Properties();
        p.put("mail.debug", "true");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        p.setProperty("mail.smtp.**ssl.enable", "true");
        p.setProperty("mail.smtp.**ssl.required", "true");

        Session s = Session.getDefaultInstance(p, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dentalclinic.official@gmail.com", "qdklwafhdjqojwnh");

            }
        });

        try {
            MimeMessage m = new MimeMessage(s);
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(sub);
            m.setText(content);
            Transport transport;
            transport = s.getTransport("smtps");
            transport.send(m);
            System.out.println("Success");
            this.chekIsEmailVerified = true;

        } catch (MessagingException E) {
            E.printStackTrace();
            chekIsEmailVerified = false;
        }
    }

    String currentDir = System.getProperty("user.dir");
    Connection Con = null;
    Statement St = null, St1 = null;
    ResultSet Rs = null, Rs1 = null;

    //data needs to sending appointment data to patients
    static String reciverName, appointDate, appointTime;
    static int treatcost;

    public void emailValidater(String name, String email) {
        try {
            this.to = email;
            this.sub = "Dental Clinic ";
            this.content = "Hello.." + name + " Thank you for Registering with us. You have successfully registerd with us";

        } catch (Exception Ex) {
            Ex.printStackTrace();
        }

    }

    public void getNewAppointmentMailData(String name, String treat, String date, String time) {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Con = DriverManager.getConnection("jdbc:derby:" + currentDir + "\\dentaldb", "root", "root");
            St = (Statement) Con.createStatement();
            Rs = St.executeQuery("Select * from root.PATIENTTBL where PATNAME='" + name + "'");
            St1 = (Statement) Con.createStatement();
            Rs1 = St1.executeQuery("Select TREATMENTCOST from root.TREATMENTTBL where TREATMENTNAME='" + treat + "'");
            Rs.next();
            Rs1.next();

            this.to = Rs.getString("PATEMAIL");
            this.reciverName = name;
            this.appointDate = date;
            this.appointTime = time;
            this.treatcost = Rs1.getInt("TREATMENTCOST");

            this.sub = "Hello " + reciverName + " This is your Dental Clinic Appointment Details. ";
            this.content = "Your " + treat + " Appintment Date is : " + appointDate + " and Time is : " + appointTime + ". The Treatment Payment is: Rs." + treatcost + ".00 /=  Thank you. ";

        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
    }

    public void getUpdatedAppointmentMailData(String name, String treat, String date, String time) {

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Con = DriverManager.getConnection("jdbc:derby:" + currentDir + "\\dentaldb", "root", "root");
            St = (Statement) Con.createStatement();
            Rs = St.executeQuery("Select * from root.PATIENTTBL where PATNAME='" + name + "'");
            St1 = (Statement) Con.createStatement();
            Rs1 = St1.executeQuery("Select TREATMENTCOST from root.TREATMENTTBL where TREATMENTNAME='" + treat + "'");
            Rs.next();
            Rs1.next();

            this.to = Rs.getString("PATEMAIL");
            this.reciverName = name;
            this.appointDate = date;
            this.appointTime = time;
            this.treatcost = Rs1.getInt("TREATMENTCOST");

            this.sub = "Hello " + reciverName + " This is your Dental Clinic Appointment Details. ";
            this.content = "YOUR APPOINMENT IS UPDATED....  Your " + treat + " Appintment Date is : " + appointDate + " and Time is : " + appointTime + ". The Treatment Payment is: Rs." + treatcost + ".00 /=  Thank you. ";

        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
