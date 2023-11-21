package com.lms.LibraryManagementSystem.MainProject.repositories;

import com.lms.LibraryManagementSystem.MainProject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BooksRepository extends JpaRepository<Book,Integer>
{
}
