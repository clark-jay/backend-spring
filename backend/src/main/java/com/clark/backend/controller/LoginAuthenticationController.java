package com.clark.backend.controller;

import com.clark.backend.model.UserEntity;
import com.clark.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginAuthenticationController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public UserEntity registerUser(@RequestBody UserEntity user) {
    return userService.registerNewUser(user);
  }

  @GetMapping("/mylogin")
  public ResponseEntity<String> login() {
    return ResponseEntity.ok("Login Successful!");
  }
}
