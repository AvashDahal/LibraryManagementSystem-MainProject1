package com.lms.LibraryManagementSystem.MainProject.controllers;

import com.lms.LibraryManagementSystem.MainProject.Dtos.BookDto;
import com.lms.LibraryManagementSystem.MainProject.Dtos.StudentDto;
import com.lms.LibraryManagementSystem.MainProject.Services.BookService;
import com.lms.LibraryManagementSystem.MainProject.entity.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController
{
    @Autowired
    private BookService bookService;
    @PostMapping("/add")
    public ResponseEntity<String> createBook(@RequestBody @Valid BookDto bookDto)
    {
        bookService.createBook(bookDto);
        return ResponseEntity.ok("Student is created successfully");


    }
    @GetMapping("/get")
    public ResponseEntity<List<BookDto>> getALlBooks()
    {
        List<BookDto> bookDtoList = bookService.getALlBooks();
        return ResponseEntity.ok(bookDtoList);

    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable int id)
    {
        BookDto bookDto= bookService.getBookById(id);
        return ResponseEntity.ok(bookDto);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable Integer id, @Valid @RequestBody BookDto bookDto)
    {
        BookDto updatedBook = bookService.updateBookById(id,bookDto);
        return ResponseEntity.ok("The student is updated successfully");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Integer id)
    {
         bookService.deleteBookByID(id);
        return ResponseEntity.ok("The Book of Book id :"+ id+" is deleted successfully");
    }





}
