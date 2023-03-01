package com.example.user;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginDTO {
    private String username;
    private String password;
}
