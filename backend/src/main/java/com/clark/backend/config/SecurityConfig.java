package com.clark.backend.config;

import com.clark.backend.model.UserEntity;
import com.clark.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

/**
 * Configures the security filter chain in this class
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  UserService userService;

  /**
   * Configures the security filter chain for the application.
   * @param http the {@link HttpSecurity} object used to set up security rules.
   * @return the {@link SecurityFilterChain} that contains the security setup.
   * @throws Exception if something goes wrong while setting up security.
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .csrf(AbstractHttpConfigurer::disable)
      .authorizeHttpRequests(authorizeRequests ->
        authorizeRequests
          .requestMatchers("/auth/register").permitAll()
          .requestMatchers("/auth/mylogin").hasAuthority("USER")
          .requestMatchers("/api/status/delete/**").permitAll()
          .requestMatchers("/api/status/get/**").hasAuthority("ADMIN")
          .requestMatchers("/api/status/register").permitAll()
          .requestMatchers("/api/status/getall").hasAuthority("USER")
          .anyRequest().authenticated()
      )
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults());
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsService() {
      @Override
      public UserDetails loadUserByUsername(String username) {
        UserEntity user = userService.findUserByUsername(username);
        if (user == null) {
          throw new RuntimeException("User not found");
        }
        return new User(
          user.getUsername(),
          user.getPassword(),
          Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
        );
      }
    };
  }
}



