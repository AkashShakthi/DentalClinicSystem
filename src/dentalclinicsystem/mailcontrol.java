/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
//import javax.swing.JOptionPane;


public class mailcontrol extends javax.swing.JFrame{
    
    String from, to, host, sub,content;
    
    
    public void email(){
        
        from = "dentalclinic.official@gmail.com";
        host = "localhost";
        
        Properties p = new Properties();
        p.put("mail.debug", "true");
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.host","smtp.gmail.com");
        p.put("mail.smtp.port","587");
        p.setProperty("mail.smtp.**ssl.enable", "true");
        p.setProperty("mail.smtp.**ssl.required", "true");
       
        Session s = Session.getDefaultInstance(p, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("dentalclinic.official@gmail.com","qdklwafhdjqojwnh");
             
            }
        });
        
        
          try{
            MimeMessage m = new MimeMessage(s);
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(sub);
            m.setText(content);
            Transport transport;
           transport = s.getTransport("smtps");
            transport.send(m);
            System.out.println("Success");
            
            
        }catch(MessagingException E){
          E.printStackTrace();
    
        }
    }
    
       
        
      
        

Connection Con = null;
Statement St = null , St1 = null;
ResultSet Rs = null, Rs1 = null;



 //data needs to sending appointment data to patients
 static   String reciverName,appointDate, appointTime ;
 static   int treatcost; 
   

    
 public  void storemaildata(String name, String treat, String date, String time){
        
     try{
         Con = DriverManager.getConnection("jdbc:derby://localhost:1527/dentaldb","root","root");
         St = (Statement) Con.createStatement();
         Rs = St.executeQuery("Select * from root.PATIENTTBL where PATNAME='"+name+"'");
         St1 = (Statement) Con.createStatement();
         Rs1 = St1.executeQuery("Select TREATMENTCOST from root.TREATMENTTBL where TREATMENTNAME='"+treat+"'");
        Rs.next();
         Rs1.next();
        
        this.to = Rs.getString("PATEMAIL");
         this.reciverName = name;
         this.appointDate = date;
         this.appointTime = time;
         this.treatcost = Rs1.getInt("TREATMENTCOST");
       
         this.sub = "Hello " +reciverName+" This is your Dental Clinic Appointment Details. ";
         this.content = "Your "+treat+" Appintment Date is : "+appointDate+" and Time is : "+appointTime+". The Treatment Payment is: Rs."+treatcost+".00 /=  Thank you. "; 
        
     }catch(Exception Ex){
              Ex.printStackTrace(); 
            }
    }    
        
   
    public static void main(String[] args) {
  
       
       
         
         
  }
 
}
