package flog.instagram_clone_coding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    @Bean // password 암호화
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
