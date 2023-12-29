import java.io.File;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.io.Encoder;


public class SecretKeySpecProgram {

	public static void main(String[] args) throws Exception {
		String keyPath = "src/secretKey.key";
		// 生成 MAC Key
		SecretKey secretKey = null;
		if(new File(keyPath).exists()) {
			secretKey = KeyUtil.getSecretKeyFromFile("HmacSHA256", keyPath);
		} else {
			secretKey = new SecretKeySpec("0123456789abcdef0123456789abcdef".getBytes(), "HmacSHA256");
			// 儲存 MAC Key
			KeyUtil.saveSecretKeyToFile(secretKey, keyPath);
		}
		System.out.println(Base64.getEncoder().encodeToString(secretKey.getEncoded()));
	}
	
//	private static String encryptWithAESKey(String text) throws Exception {
//	Cipher cipher = Cipher.getInstance("AES");
//    cipher.init(Cipher.ENCRYPT_MODE, AES_SECRET_KEY);
//    byte[] encryptedECB = cipher.doFinal(text.getBytes());
//	return Base64.getEncoder().encodeToString(encryptedECB);
//}
//
//private static String decryptWithAESKey(String text) throws Exception {
//	byte[] encryptedData = Base64.getDecoder().decode(text);
//	Cipher cipher = Cipher.getInstance("AES");
//    cipher.init(Cipher.DECRYPT_MODE, AES_SECRET_KEY);
//    return new String(cipher.doFinal(encryptedData));
//}

}
