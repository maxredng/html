/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html;
import java.util.Properties;
import java.util.Properties;   
import javax.mail.Address;
import javax.mail.Message; 
import javax.mail.MessagingException; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.AddressException; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 

public class Post {
    
    public feed Feed;
    public String mess;
    public String error;
    public String to;
    InternetAddress[] add;
    
    public Post(String head,String ms,String ad,feed f)
            {
   Feed=f;
   mess=ms;
   to=ad;           
     dothing();   
            }
 
    final void dothing()
    {
    Properties props = new Properties();
    
    String host = Feed.host;
    String username = Feed.mailname;
    String password = Feed.mailpas;
    String provider = Feed.provider;

    

      
      
      String from = username+"@mail.ru";

      //Properties properties = System.getProperties();

      props.setProperty("mail.smtp.host", host);

    Session session = Session.getDefaultInstance(props, null);
    
         MimeMessage message = new MimeMessage(session);
try
{
         message.setFrom(new InternetAddress(from));

         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         message.setSubject("Registration at BECHUM.com");
       
    
    
       
         message.setText(mess);
         Transport tr=session.getTransport("smtp");
      
         tr.connect(host,25,"mkarpoff@mail.ru","baraban22");
        InternetAddress an=new InternetAddress(to);
        add=new InternetAddress[1]; 
        add[0]=an;
        
         tr.sendMessage(message, add);
         
}catch(MessagingException e)
{
error=e.getLocalizedMessage();
}
         System.out.println("Sent message successfully....");

    }
}
