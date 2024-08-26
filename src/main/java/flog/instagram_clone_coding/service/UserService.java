package flog.instagram_clone_coding.service;

import flog.instagram_clone_coding.domain.Users;
import flog.instagram_clone_coding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유효성 검사 결과를 처리하는 메소드
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }

    @Transactional
    public Users join(String email, String fullName, String username, String password){
        Users user = new Users();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
//        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }

//    public void validateDuplicationUser(Users user){
//
//    }
}
