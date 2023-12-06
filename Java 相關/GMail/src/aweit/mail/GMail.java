package aweit.mail;

import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.ArrayList;
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

public class GMail {

	private String username;
	
	private String password;
	
	private String from;
	
	private List<String> to;

	private List<String> cc;

	private List<String> bcc;

	private String personal;

	private String subject;

	private String context;
	
	private List<Path> attachements;

	public GMail(String username, String password) {
		this.username = username;
		this.password = password;
		this.from = "";
		this.to = new ArrayList<>();
		this.cc = new ArrayList<>();
		this.bcc = new ArrayList<>();
		this.personal = "";
		this.subject = "";
		this.context = "";
		this.attachements = new ArrayList<>();
	}
	
	public GMail from(String from) {
		this.from = from;
		return this;
	}

	public GMail to(String to) {
		this.to.add(to);
		return this;
	}

	public GMail cc(String cc) {
		this.cc.add(cc);
		return this;
	}
	
	public GMail bcc(String bcc) {
		this.bcc.add(bcc);
		return this;
	}
	
	public GMail personal(String personal) {
		this.personal = personal;
		return this;
	}
	
	public GMail subject(String subject) {
		this.subject = subject;
		return this;
	}
	
	public GMail context(String context) {
		this.context = context;
		return this;
	}

	public GMail attachement(Path attachement) {
		this.attachements.add(attachement);
		return this;
	}
	
	public void send() {

		try {
			
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
					return new PasswordAuthentication(username, password);
				}
			};
			Session mailSession = Session.getInstance(properties, auth);
			
			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(from, personal, "UTF-8"));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(String.join(",", to)));
			message.setRecipients(RecipientType.CC, InternetAddress.parse(String.join(",", cc)));
			message.setRecipients(RecipientType.BCC, InternetAddress.parse(String.join(",", bcc)));
			message.setSubject(subject);
			
			Multipart multipart = new MimeMultipart();
			MimeBodyPart contentBodyPart = new  MimeBodyPart();
		    contentBodyPart.setContent(context, "text/html; charset=utf-8");
		    multipart.addBodyPart(contentBodyPart);

			if (!attachements.isEmpty()) {
				for (Path aPath : attachements) {
					MimeBodyPart attachmentBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(aPath.toAbsolutePath().toString());
					attachmentBodyPart.setDataHandler(new DataHandler(source));
					attachmentBodyPart.setFileName(aPath.getFileName().toString());
					multipart.addBodyPart(attachmentBodyPart);
				}
			}
			
			message.setContent(multipart);
			Transport.send(message);
			System.out.printf("[OK] %s mail to %s%n", from, to);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
