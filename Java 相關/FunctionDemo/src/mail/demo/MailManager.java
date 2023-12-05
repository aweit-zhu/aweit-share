package mail.demo;

import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailManager {

	Session mailSession;

	public MailManager(String mailServerPwd, String mailServerUser) {
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.connectiontimeout", "10000");
		properties.setProperty("mail.smtp.timeout", "10000");
		properties.setProperty("mail.smtp.writetimeout", "10000");
		properties.setProperty("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailServerUser, mailServerPwd);
			}
		};

		this.mailSession = Session.getInstance(properties, auth);
	}

	/**
	 * 
	 * @param from
	 * @param sendTo
	 * @param cc
	 * @param bcc
	 * @param personal:暱稱
	 * @param subject:主旨
	 * @param context:內容
	 */
	public void sentMail(String from, List<String> sendTo, List<String> cc, List<String> bcc, String personal,
			String subject, String context) {

		try {
			Message message = new MimeMessage(this.mailSession);
			message.setFrom(new InternetAddress(from, personal, "UTF-8"));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(String.join(",", sendTo)));
			message.setRecipients(RecipientType.CC, InternetAddress.parse(String.join(",", cc)));
			message.setRecipients(RecipientType.BCC, InternetAddress.parse(String.join(",", bcc)));
			message.setSubject(subject);
			message.setText(context);
			Transport.send(message);
			System.out.printf("%s 成功寄信給 %s%n", from, sendTo);
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException("寄信失敗！");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param from
	 * @param sendTo
	 * @param cc
	 * @param bcc
	 * @param personal
	 * @param subject
	 * @param context
	 * @param attachements
	 */
	public void sentMail(String from, List<String> sendTo, List<String> cc, List<String> bcc, String personal,
			String subject, String context, List<Path> attachements) {

		try {
			Message message = new MimeMessage(this.mailSession);
			message.setFrom(new InternetAddress(from, personal, "UTF-8"));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(String.join(",", sendTo)));
			message.setRecipients(RecipientType.CC, InternetAddress.parse(String.join(",", cc)));
			message.setRecipients(RecipientType.BCC, InternetAddress.parse(String.join(",", bcc)));
			message.setSubject(subject);
			message.setText(context);
			
	        if(attachements!=null) {
	        	Multipart multipart = new MimeMultipart();
		        for(Path aPath: attachements) {
		        	 MimeBodyPart attachmentBodyPart= new MimeBodyPart();
		        	 DataSource source = new FileDataSource(aPath.toAbsolutePath().toString());
		        	 attachmentBodyPart.setDataHandler(new DataHandler(source));
		             attachmentBodyPart.setFileName(aPath.getFileName().toString());
		             multipart.addBodyPart(attachmentBodyPart);
		        }
		        message.setContent(multipart);
	        }
	        
			Transport.send(message);
			System.out.printf("%s 成功寄信給 %s%n", from, sendTo);
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException("寄信失敗！");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
