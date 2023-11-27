import org.mindrot.jbcrypt.BCrypt;

public class BCryptExample {

    public static void main(String[] args) {

        String rawPassword = "123";
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
        System.out.println("Hashed Password: " + hashedPassword); // $2a$10$ms1UGigcUkZP0axeEY4JM.3bG9CawnqegKEH2Dlw.fJAv.wLF6Zf.


        String candidatePassword = "123";
        boolean isPasswordMatch = BCrypt.checkpw(candidatePassword, hashedPassword);
        System.out.println("Password Match: " + isPasswordMatch);
    }
}
