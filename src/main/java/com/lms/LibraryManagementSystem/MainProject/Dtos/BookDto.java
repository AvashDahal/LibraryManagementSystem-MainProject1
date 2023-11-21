package com.lms.LibraryManagementSystem.MainProject.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto
{
    private int BookId;
    @NotBlank(message = "The title can not be empty")
    private String title;
    @NotBlank(message = "The Author name can't be blank")
    private String authorName;
    @NotBlank(message = "ISBN number is mandatory")
    private String isbn;

    private int noOfBooks;

    @NotBlank(message = "Specify the edition")
    private String edition;
}
