package mail.demo;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

/**
 * 參考網頁：https://medium.com/@heather_programming/javamail-%E7%99%BC%E9%80%81%E4%BF%A1%E4%BB%B6%E5%8A%9F%E8%83%BD-35791225da51
 * 應用程式密碼：Google 帳戶 -> 安全性 -> 兩步驟驗證 -> 應用程式密碼 -> 輸入「send gmail」取得 Token (例如：rkrb vuai biti ssyf)
 * CC與BCC：https://english.cool/cc-vs-bcc/
 */
public class GmailDemo {

	public static void main(String[] args) throws URISyntaxException {
		
		String mailServerPwd = "rkrb vuai biti ssyf";   // 應用程式密碼
		
		String mailServerUser = "aa4192696@gmail.com";  // 寄件者
		
		MailManager manager = new MailManager(mailServerPwd, mailServerUser);
		
//		manager.sentMail(mailServerUser, 
//				List.of("aa4192696@gmail.com","a4192696@yahoo.com.tw"),          // to
//				List.of("aa4192696@gmail.com"),                                  // cc
//				List.of("aa4192696@gmail.com"),                                  // bcc
//				"阿偉",                                                          // 寄件者暱稱
//				"寄信範例",                                                      // 主旨
//				"成功出信件"                                                     // 內容
//		);
		
		manager.sentMail(mailServerUser, 
				List.of("aa4192696@gmail.com","a4192696@yahoo.com.tw"),          // to
				List.of("aa4192696@gmail.com"),                                  // cc
				List.of("aa4192696@gmail.com"),                                  // bcc
				"阿偉",                                                          // 寄件者暱稱
				"寄信範例",                                                      // 主旨
				"成功出信件",                                                    // 內容
				List.of(Path.of(GmailDemo.class.getClassLoader().getResource("123.txt").toURI()))// 附件
		);
	}

}
