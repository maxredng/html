/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import java.util.Properties;
import java.util.Properties;   
import javax.mail.Message; 
import javax.mail.MessagingException; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.AddressException; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 

public class MyEmail {
    
    public feed Feed;
    public String mess;
    public String error;
    public String to;
    
    public MyEmail(String str,String tot)
    {
    Feed=new feed();
    mess=str;
    to=tot;
    
    }
    
    public void sendMail()throws MessagingException
    {
    Properties props = new Properties();
    String host = Feed.host;
    String username = Feed.mailname;
    String password = Feed.mailpas;
    String provider = Feed.provider;
    Session session = Session.getDefaultInstance(props, null);
    
    

      
      
      String from = username+"@"+host;

      Properties properties = System.getProperties();

      properties.setProperty("mail.smtp.host", host);


         MimeMessage message = new MimeMessage(session);

         message.setFrom(new InternetAddress(from));

         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         message.setSubject("Registration at BECHUM.com");

       
         message.setText(mess);

      
         Transport.send(message);
         System.out.println("Sent message successfully....");

    }
    
    
}
