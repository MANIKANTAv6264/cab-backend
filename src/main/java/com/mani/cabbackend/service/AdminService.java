package com.mani.cabbackend.service;

import com.mani.cabbackend.entity.Admin;
import com.mani.cabbackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> login(String email) {
        return adminRepository.findByEmail(email);
    }

}