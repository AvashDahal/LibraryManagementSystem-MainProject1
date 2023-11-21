package com.lms.LibraryManagementSystem.MainProject.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto
{

    private int AdminId;
    @NotBlank(message = "Address can't be blank")
    private String AdminAddress;

@Past(message = "The DOB should be in past")
@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date AdminDoB;
@Email(message = "Please enter a valid email")
    private String AdminEmail;
@Size(min = 10,max = 10,message = "Please enter a valid phone no")
    private String PhoneNo;

}
