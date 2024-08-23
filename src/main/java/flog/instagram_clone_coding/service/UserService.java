package flog.instagram_clone_coding.service;

import flog.instagram_clone_coding.domain.Users;
import flog.instagram_clone_coding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    @Autowired
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
    }

    public Users join(String email, String fullName, String username, String password){
        Users user = new Users();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setUsername(username);
        user.setUsername(password);
//        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }
}
