package test;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MailClass {
	public void mail() {
		String to="kapilshukla1312@gmail.com";
		String from="ks.150820@gmail.com";
		
		String host="localhost";
		
		Properties properties=System.getProperties();
		
		properties.setProperty("mail.smtp.host", host);
		
		Session session=Session.getDefaultInstance(properties);
		
		try {
			MimeMessage message=new MimeMessage(session);
			
			message.setFrom(new InternetAddress(from));
			
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			
			message.setSubject("this is the subject line");
			
			message.setText("this is actual message");
			
			Transport.send(message);
			System.out.println("sent message successfully");
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
