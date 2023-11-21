package com.lms.LibraryManagementSystem.MainProject.repositories;

import com.lms.LibraryManagementSystem.MainProject.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer>
{
}
