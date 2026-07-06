package com.mani.cabbackend.service;

import com.mani.cabbackend.entity.Admin;
import com.mani.cabbackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Admin register(Admin admin) {

        admin.setPassword(encoder.encode(admin.getPassword()));

        return adminRepository.save(admin);
    }

    public boolean login(String email, String password) {

        Optional<Admin> admin = adminRepository.findByEmail(email);

        if(admin.isPresent()) {

            return encoder.matches(password, admin.get().getPassword());

        }

        return false;
    }

}