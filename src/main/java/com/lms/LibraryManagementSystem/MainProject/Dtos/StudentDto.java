package com.lms.LibraryManagementSystem.MainProject.Dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto
{

    private int studentId;
    private String midName;
    @NotBlank(message = "First name can't be blank")
    private String firstName;
    @NotBlank(message = "Last name can't be blank")
    private String lastName;
    @Email(message = "Invalid email")
    private String email;
    @Size(min = 10,max = 10,message = "Phone number should be valid")
    private String phoneNo;
    @NotBlank(message = "Address can't be blank")
    private String address;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dob;

}
