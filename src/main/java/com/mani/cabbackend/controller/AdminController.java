package com.mani.cabbackend.controller;

import com.mani.cabbackend.dto.LoginRequest;
import com.mani.cabbackend.entity.Admin;
import com.mani.cabbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Admin register(@RequestBody Admin admin) {
        return adminService.register(admin);
    }

    @PostMapping("/login")
public String login(@RequestBody LoginRequest request) {

    boolean success = adminService.login(
            request.getEmail(),
            request.getPassword()
    );

    if(success) {
        return "Login Success";
    }

    return "Invalid Email or Password";
}
}