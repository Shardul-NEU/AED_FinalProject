/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author priyankaskhimyani
 */
public class EmailSMTP {
    
    public EmailSMTP(String sender, String name, String medicines, String senderName) throws AddressException, MessagingException, IOException{
    
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.ssl.enable", "false");
        prop.put("mail.smtp.tls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
      
        
        
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("e3c1d12a2ab47b", "44af2b412bd9f9");

            }

        });
        
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipients(
          Message.RecipientType.TO, InternetAddress.parse("pharmacy@gmail.com"));
        
        
        message.setSubject("Medicines for "+name);

        String msg = "&nbsp;Hey Jack,"
                +"<br>"
                +"<br>"
                +"&nbsp;&nbsp;&nbsp;I have raised request for "+name+" for following medicines:"
                +"<br>"
                +"<br>"
                +"&nbsp;&nbsp;&nbsp;"+medicines
                +"<br>"
                +"<br>"
                +"<br>"
                +"<br>"
                +"&nbsp;&nbsp;&nbsp;I hope you will approve them as soon as possible."
                +"<br>"
                +"<br>"
                +"&nbsp;Thanks and Regards,"
                +"<br>"
                +"&nbsp;"+senderName
                +"<br>"
                +"&nbsp;email: "+sender;

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        
      

        message.setContent(multipart);

        Transport.send(message);
    
    }
    
}
