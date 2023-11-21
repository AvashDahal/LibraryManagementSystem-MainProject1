package com.lms.LibraryManagementSystem.MainProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String authorName;
    @Column(unique = true,nullable = false)
    private String isbn;
    @Column(nullable = false)
    private int noOfBooks;

    private String edition;
    @ManyToOne
            (fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")

    private Student student;




}
