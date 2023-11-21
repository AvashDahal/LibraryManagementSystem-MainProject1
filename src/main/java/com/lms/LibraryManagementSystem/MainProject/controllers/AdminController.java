package com.lms.LibraryManagementSystem.MainProject.controllers;

import com.lms.LibraryManagementSystem.MainProject.Dtos.AdminDto;
import com.lms.LibraryManagementSystem.MainProject.Services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController
{
    @Autowired
    private AdminService adminService;

   public ResponseEntity<String>createAdmin(@RequestBody @Valid AdminDto adminDto)
    {
        adminService.createAdmin(adminDto);
        return ResponseEntity.ok("The Admin is created successfully");

    }

}
