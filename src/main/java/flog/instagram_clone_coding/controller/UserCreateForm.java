package flog.instagram_clone_coding.controller;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserCreateForm {
    @NotEmpty @Email
    private String email;
    @NotEmpty
    private String fullName;
    @NotEmpty @Size(max = 30)
    private String username;
    @NotEmpty
    private String password;

    public String getEmail() {
        return email;
    }
    public String getFullName() {
        return fullName;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
