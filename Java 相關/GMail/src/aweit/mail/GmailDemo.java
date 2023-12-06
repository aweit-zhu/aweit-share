package aweit.mail;
import java.net.URISyntaxException;
import java.nio.file.Path;

import aweit.mail.GMail;

/**
 * 應用程式密碼：Google 帳戶 -> 安全性 -> 兩步驟驗證 -> 應用程式密碼 -> 輸入「send gmail」取得 Token (例如：rkrb vuai biti ssyf)
 */
public class GmailDemo {

	public static void main(String[] args) throws URISyntaxException {
		
		GMail mail = new GMail("aa4192696@gmail.com", "rkrb vuai biti ssyf");
		
		mail.from("aa4192696@gmail.com")
		    .to("aa4192696@gmail.com")
		    .to("a4192696@yahoo.com.tw")
		    .cc("aa4192696@gmail.com")
		    .personal("阿偉特")
		    .subject("測試信件")
		    .context("測試信件，收到請勿回覆。")
		    .attachement(Path.of(GmailDemo.class.getClassLoader().getResource("123.txt").toURI()))
		    .send();

	}

}
