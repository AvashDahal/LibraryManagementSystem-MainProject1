package com.lms.LibraryManagementSystem.MainProject.controllers;

import com.lms.LibraryManagementSystem.MainProject.Dtos.StudentDto;
import com.lms.LibraryManagementSystem.MainProject.Services.StudentService;
import com.lms.LibraryManagementSystem.MainProject.entity.Book;
import com.lms.LibraryManagementSystem.MainProject.entity.Student;
import com.lms.LibraryManagementSystem.MainProject.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@RestController

@RequestMapping("/student")
public class StudentController
{
   @Autowired
    private StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<List<StudentDto>> getAllStudents()
    {

            List<StudentDto> students = studentService.getAllStudents();

            return ResponseEntity.ok(students);

    }

   @PostMapping("/create")
   public ResponseEntity<String> createStudent(@RequestBody @Valid StudentDto studentDto)
   {
       studentService.createStudent(studentDto);
       return ResponseEntity.ok("Student created successfully");
   }
 @GetMapping("/{studentId}")
    public ResponseEntity <StudentDto> getStudentById(@PathVariable int studentId)
 {
     try {
         StudentDto student = studentService.getStudentById(studentId);
         if (student!=null)
         {
            return ResponseEntity.ok(student);
         }
         else
         {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }

     }
     catch (RuntimeException e)
     {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
     }
 }
 @PutMapping("/update")
    public ResponseEntity<String> updateStudentById(@PathVariable int studentId,@Valid StudentDto studentDto)
 {
     try
     {
         studentService.updateStudentById(studentId, studentDto);
         return ResponseEntity.ok("The student is updated successfully");

     }
     catch (RuntimeException e)
     {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
     }

 }
 @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id)
 {
     try{
         studentService.deleteStudentById(id);
         ResponseEntity<String> studentDeletedSuccessfully = ResponseEntity.ok("Student Deleted successfully");
         return studentDeletedSuccessfully;

     }
     catch (RuntimeException e)
     {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
     }

 }
@PostMapping("{student_id}/borrow/{book_id}")
    public ResponseEntity<String> borrowBook(@PathVariable int student_id,@PathVariable int book_id)
{
    try
    {
        studentService.borrowBook(student_id,book_id);
        return ResponseEntity.ok("The book is successfully borrowerd by: "+student_id);
    }
    catch (EntityNotFoundException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    catch(Exception e)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}

@GetMapping("/{student_id}/getBorrowedBooks")
    public ResponseEntity<Set<Book>> getBorrowedBooks(@PathVariable int student_id)
{
    try
    {
        Set<Book> getBooks= studentService.getBorrowedBooks(student_id);
        return ResponseEntity.ok(getBooks);
    }
    catch(Exception e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

}

}
