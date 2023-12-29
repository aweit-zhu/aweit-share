import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;

public class JWTTest {

	private static final long EXPIRE_TIME = 15 * 60 * 1000; // 15 分鐘過期

	//private static final SecretKeySpec SECRET_KEY = new SecretKeySpec(KEY.getBytes(), "HmacSHA256");
	private static SecretKey SECRET_KEY;
	
	static {
		try {
			SECRET_KEY = KeyUtil.getSecretKeyFromFile("HmacSHA256", "src/secretKey.key");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String createJWT(String id, String subject, String role, Long ttlMillis) throws InvalidKeyException, Exception {

		if (ttlMillis == null) {
			ttlMillis = EXPIRE_TIME;
		}

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		long expMills = nowMillis + ttlMillis;
		Date expDate = new Date(expMills);

		JwtBuilder builder = Jwts.builder().setId(id)
				.setSubject(subject)
				.setIssuer("aweit")
				//.claim("role", encryptWithAESKey(role))
				.claim("role", role)
				.setIssuedAt(now).setExpiration(expDate).signWith(SECRET_KEY);

		return builder.compact();
	}
	
	public static Claims parseJWT(String token) {
		return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
	}

	public static boolean isTokenExpired(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
            		.setSigningKey(SECRET_KEY)
            		.build()
            		.parseClaimsJws(token)
            		.getBody();

            return claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return true;
        }
    }
	
	public static void main(String[] args) throws Exception {
		
		String token = createJWT(UUID.randomUUID().toString(), "JWT demo", "admin", 2000L);
		System.out.println(token);
		
		Claims claims = parseJWT(token);
		Set<String> keys = claims.keySet();
		for (String key : keys) {
			System.out.printf("%s=%s;", key, claims.get(key));
		}
		
		System.out.println();
		
		Thread.sleep(2000);
		
		if(isTokenExpired(token)) {
			System.out.println("Token 失效");
		} else {
			System.out.println("Token 可以繼續使用");
		}
	}

}
