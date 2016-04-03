package com.infinityCableService.util;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
		   	   
	   public static void sendemail(String toEmail, String password) throws Exception{
		   
		   String sender = "prakashpatel3989@gmail.com";
		   String senderPswrd ="sach1234";
		   String host = "smtp.gmail.com";
		    
		   
	   try {
		    Properties props = System.getProperties();
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.user", sender);
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.password", "sach1234");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", 587);
		    Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(sender, senderPswrd);
				}
		    });
			
		    MimeMessage message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(sender));
		    message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		    message.setSubject("Your Password has been reset!");
			message.setText("Dear Mail Crawler, Your password has been reset. Please login using this password: "+password);
		    Transport.send(message, message.getAllRecipients());
		    
   			}catch (MessagingException e) {
				e.printStackTrace();
				throw e;
   			}
	   }	
}