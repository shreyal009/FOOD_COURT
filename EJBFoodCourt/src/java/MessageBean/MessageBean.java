/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageBean;

import java.util.Properties;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Shreyal
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/SendEmail")
})
public class MessageBean implements MessageListener {
    
    public MessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
         String to=null;
        try{
        to = message.getBody(String.class);
        }
        catch(JMSException e){}

      // Sender's email ID needs to be mentioned
      String from = "15030142016@sicsr.ac.in";
      final String username = "15030142016@sicsr.ac.in";//change accordingly
      final String password = "s9406634358h";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

        Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
       }
         });

      try {
       // Create a default MimeMessage object.
             javax.mail.Message emailMessage = new MimeMessage(session);

       // Set From: header field of the header.
       emailMessage.setFrom(new InternetAddress(from));
    
       // Set To: header field of the header.
       emailMessage.setRecipients(javax.mail.Message.RecipientType.TO,
               InternetAddress.parse(to));
    
       // Set Subject: header field
       emailMessage.setSubject("Welcome To FOODCOURT");
    
       // Now set the actual message
       emailMessage.setText("Greetings\n\n\nFOODCOURT team welcomes you.\n\n\nThanks,\n\n\nRegards\n\n\nFOODCOURT");

       // Send message
       Transport.send(emailMessage);

       System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
        
    }
    
}
    