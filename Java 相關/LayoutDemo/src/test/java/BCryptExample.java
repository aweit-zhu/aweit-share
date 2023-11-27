import org.mindrot.jbcrypt.BCrypt;

public class BCryptExample {

    public static void main(String[] args) {
        // 加密密码
        String rawPassword = "123";
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
        System.out.println("Hashed Password: " + hashedPassword); // $2a$10$ms1UGigcUkZP0axeEY4JM.3bG9CawnqegKEH2Dlw.fJAv.wLF6Zf.

        // 验证密码
        String candidatePassword = "123"; // 用户输入的密码
        boolean isPasswordMatch = BCrypt.checkpw(candidatePassword, hashedPassword);
        System.out.println("Password Match: " + isPasswordMatch);
    }
}
