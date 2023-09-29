package com.sup1x.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "*", maxAge = 3600)
// for Angular Client (withCredentials)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@Tag(name = "Test V1", description = "Test V1 Management API")
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "[Public Content]";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "[User Content]";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public String moderatorAccess() {
        return "[Moderator Board]";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Administration Board";
    }
}
