package com.lms.LibraryManagementSystem.MainProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "AdminDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AdminId;
    @Column(name = "Address")
    private String AdminAddress;

    @Column(name = "DOB")
    private Date AdminDoB;
    @Column(name = "Email")
    private String AdminEmail;
    @Column(name = "Phone_No")
    private String PhoneNo;

}
