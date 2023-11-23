package com.lms.LibraryManagementSystem.MainProject.controllers;

import com.lms.LibraryManagementSystem.MainProject.Dtos.AdminDto;
import com.lms.LibraryManagementSystem.MainProject.Services.AdminService;
import com.lms.LibraryManagementSystem.MainProject.entity.Admin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.ScatteringByteChannel;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
   public ResponseEntity<String>createAdmin(@RequestBody @Valid AdminDto adminDto)
    {
        adminService.createAdmin(adminDto);
        return ResponseEntity.ok("The Admin is created successfully");

    }

    @GetMapping()
    public ResponseEntity<List<AdminDto>>getAllAdmins()
    {

            List<AdminDto> admin = adminService.getALlAdmins();
            if (admin != null) {
                return ResponseEntity.ok(admin);

            }
            else {
                return ResponseEntity.notFound().build();
            }


    }
    @GetMapping("/get/{id}")
    public ResponseEntity<AdminDto>getAdminByID(@PathVariable int id)
    {
        try {
            AdminDto adminDto = adminService.getAdminById(id);
            if (adminDto != null) {
                return ResponseEntity.ok(adminDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String>updateAdminById(@PathVariable int id, @RequestBody @Valid AdminDto adminDto) {
        try {
            AdminDto adminDto1 = adminService.updateAdminById(id, adminDto);
            if (adminDto1 != null) {
                return ResponseEntity.ok("The student is updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The student update is failed");
            }

        }
        catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteAdminById(@PathVariable int id)
    {
        try
        {
            adminService.deleteAdminById(id);
            return ResponseEntity.ok("The student is deleted successfully");

        }
        catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
