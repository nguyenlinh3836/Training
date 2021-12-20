package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.Account;
import com.example.demo.security.JwtResponse;
import com.example.demo.service.AccountService;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody AccountDto accountDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accountDto.getUsername(),accountDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AccountDto currentUser = accountService.findByUserName(accountDto.getUsername());
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(),jwt,userDetails.getUsername(),userDetails.getAuthorities()));
    }
    @GetMapping("/register")
    public ResponseEntity register(@RequestParam String username){
        return ResponseEntity.ok(userDetailService.loadUserByUsername(username));
    }

}
