/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import html.feed;
import java.net.PasswordAuthentication;
import java.util.Properties;  

    

import javax.mail.*;  


import javax.mail.internet.AddressException;  

import javax.mail.internet.InternetAddress;  

import javax.mail.internet.MimeMessage;  

   

public class SendMail {  

    

     private String from;  

    private String to;  

     private String subject;  

     private String text;  

    

     public SendMail(String from, String to, String subject, String text){  

         this.from = from;  

         this.to = to;  

         this.subject = subject;  

         this.text = text;  

     }  


    public void send(){  

final feed f=new feed();

        Properties props = new Properties();  

         props.put("mail.smtp.host", "smtp.mail.ru");  
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", f.mailport);
        props.put("mail.smtp.socketFactory.port", f.mailport);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
         props.put("mail.smtp.port", f.mailport);  
         //props.put("mail.smtp.port", "2025");
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
             

          });
   

         Session mailSession = Session.getDefaultInstance(props); 
         
            URLName url=new URLName("smtp",f.host,f.mailport,"","mkarpoff@mail.ru",f.mailpas);
            mailSession.getPasswordAuthentication(url);
            Message mess=new MimeMessage(mailSession);
      Message simpleMessage = new MimeMessage(session);  

   

       InternetAddress fromAddress = null;  

        InternetAddress toAddress = null;  

        try {  

             fromAddress = new InternetAddress(from);  

            toAddress = new InternetAddress(to);  
            

            
         } catch (AddressException e) {  

             // TODO Auto-generated catch block  

             e.printStackTrace();  

         }  

   

        try {  

           mess.setFrom(fromAddress);  

            mess.setRecipient(Message.RecipientType.TO,toAddress);  

             mess.setSubject(subject);  

             mess.setText(text);  

    

            Transport.send(mess);  

        } catch (MessagingException e) {  

            // TODO Auto-generated catch block  

            System.out.println(e.getMessage());

        }  

    }  

 } 

