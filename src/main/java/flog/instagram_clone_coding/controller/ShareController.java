package flog.instagram_clone_coding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/share")
public class ShareController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Share!";
    }
}
