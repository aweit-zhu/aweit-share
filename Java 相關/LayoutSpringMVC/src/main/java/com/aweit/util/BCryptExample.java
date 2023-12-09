package com.aweit.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aweit.dao.user.User;
import com.aweit.dao.user.UserDAOImpl;

public class BCryptExample {

    public static void main(String[] args) {

        String rawPassword = "123";
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
        System.out.println("Hashed Password: " + hashedPassword); // $2a$10$ms1UGigcUkZP0axeEY4JM.3bG9CawnqegKEH2Dlw.fJAv.wLF6Zf.

        User user = new User("user", hashedPassword);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/springMvc-servlet.xml");
        
        UserDAOImpl impl = (UserDAOImpl)context.getBean("userDAOImpl");
        
        impl.save(user);
        
//        String candidatePassword = "123";
//        boolean isPasswordMatch = BCrypt.checkpw(candidatePassword, hashedPassword);
//        System.out.println("Password Match: " + isPasswordMatch);
    }
}
