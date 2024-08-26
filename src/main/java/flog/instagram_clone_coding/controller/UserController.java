package flog.instagram_clone_coding.controller;

import flog.instagram_clone_coding.domain.Users;
import flog.instagram_clone_coding.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
//    @ResponseBody
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute UserCreateForm userCreateForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for(ObjectError e : allErrors){
                System.out.println("E : " + e.getDefaultMessage());
            }
            return "signup_form";
        }
        try {
            userService.join(userCreateForm.getEmail(), userCreateForm.getFullName(), userCreateForm.getUsername(), userCreateForm.getPassword());
        } catch (DataIntegrityViolationException e){
            System.out.println("E : 중복된 회원임.");
//            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 존재하는 사용자 입니다.");
            return "signup_form";
        } catch (Exception e){
            System.out.println("E : 오류 발생." + e.getMessage());
//            e.printStackTrace();
            bindingResult.reject("signupFailed", "오류났습니다.");
            return "signup_form";
        }
        return "redirect:/";
    }
}
