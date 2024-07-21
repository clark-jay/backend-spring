package com.clark.backend.services;

import com.clark.backend.model.UserEntity;
import com.clark.backend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserEntity registerNewUser(UserEntity user) {
    if ("ADMIN".equals(user.getRole()) && userRepository.findByRole("ADMIN").isPresent()) {
      throw new IllegalStateException("Admin user already exists");
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public UserEntity findUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }
}
