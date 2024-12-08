package com.challenge.authentication.controller;

import com.challenge.authentication.dto.AuthRequestDTO;
import com.challenge.authentication.dto.AuthResponseDTO;
import com.challenge.authentication.dto.UserDTO;
import com.challenge.authentication.exception.InvalidCredentialsException;
import com.challenge.authentication.jwt.JwtUtil;
import com.challenge.authentication.mapper.UserMapper;
import com.challenge.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * The AuthController class is a REST controller that handles authentication-related
 * HTTP requests such as user registration and user login.
 *
 * It provides endpoints to register a new user and to authenticate an existing user.
 * Upon successful authentication, it returns a JWT token.
 *
 * This class uses the UserService for user management, JwtUtil for JWT operations,
 * and AuthenticationManager for authentication processing.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(UserMapper.toDTO(userService.saveUser(userDTO)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthRequestDTO request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        final UserDetails userDetails = userService.loadUserByUsername(request.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        final Long userId = userService.findUserIdByUsername(request.getUserName());

        return ResponseEntity.ok(new AuthResponseDTO(jwt, userId));
    }
}

