package com.mani.cabbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "🚖 Cab Backend is Running";
    }

    @GetMapping("/api/health")
    public String health() {
        return "Server Healthy ✅";
    }
}