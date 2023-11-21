package com.lms.LibraryManagementSystem.MainProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentId;

    @Column(unique = true,nullable=false)
    @NotBlank(message = "First name can't be blank")
    private String First_name;

    private String Mid_name;
    @Column(nullable = false)
    @NotBlank(message = "Last name can't be blank")
    private String Last_name;
    @Column(unique = true)
    @Email(message = "Invalid email")
    private String email;
    @Column(unique = true,nullable=false)
    @Size(min = 10,max = 10,message = "Phone number should be valid")
    private String phone_no;
    @Column(nullable=false)
    @NotBlank(message = "Address can't be blank")
    private String address;
    @Column(nullable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dob;
    @OneToMany (mappedBy = "student",cascade =CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book>borrowedBooks = new HashSet<>();




}
