package com.lms.LibraryManagementSystem.MainProject.Services;

import com.lms.LibraryManagementSystem.MainProject.Dtos.BookDto;
import com.lms.LibraryManagementSystem.MainProject.Dtos.StudentDto;
import com.lms.LibraryManagementSystem.MainProject.entity.Book;
import com.lms.LibraryManagementSystem.MainProject.entity.Student;
import com.lms.LibraryManagementSystem.MainProject.repositories.BooksRepository;
import com.lms.LibraryManagementSystem.MainProject.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void  createBook(BookDto bookDto)
{
    Book book = new Book();

    book.setNoOfBooks(bookDto.getNoOfBooks());
    book.setAuthorName(bookDto.getAuthorName());
    book.setEdition(bookDto.getEdition());
    book.setTitle(bookDto.getTitle());
    book.setIsbn(bookDto.getIsbn());
    booksRepository.save(book);
}
    public List<BookDto> getALlBooks()
    {
        List<Book> books= booksRepository.findAll();
        List<BookDto> bookDtoList= new ArrayList<>();
        for (Book book:books)
        {
            BookDto bookDto = new BookDto();
            bookDto.setBookId(book.getBookId());
            bookDto.setNoOfBooks(book.getNoOfBooks());
            bookDto.setAuthorName(book.getAuthorName());
            bookDto.setEdition(book.getEdition());
            bookDto.setTitle(book.getTitle());
            bookDto.setIsbn(book.getIsbn());
            bookDtoList.add(bookDto);

        }
        return bookDtoList;


    }
    public BookDto getBookById(int id)
    {
        Optional<Book> optionalBook= booksRepository.findById(id);

        if(optionalBook.isPresent())
        {
            Book book = optionalBook.get();
            BookDto bookDto= new BookDto();
            bookDto.setIsbn(book.getIsbn());
            bookDto.setBookId(book.getBookId());
            bookDto.setNoOfBooks(book.getNoOfBooks());
            bookDto.setAuthorName(book.getAuthorName());
            bookDto.setEdition(book.getEdition());
            bookDto.setTitle(book.getTitle());
            return bookDto;



        }
            else
            {
                throw new RuntimeException("The book "+id +"is not found");

        }

    }
    public BookDto updateBookById(int id,BookDto updatedBookDto )
    {
        Optional<Book> optionalBook= booksRepository.findById(id);
        if(optionalBook.isPresent())
        {
            Book book = optionalBook.get();


            book.setNoOfBooks(updatedBookDto.getNoOfBooks());
            book.setAuthorName(updatedBookDto.getAuthorName());
            book.setEdition(updatedBookDto.getEdition());
            book.setTitle(updatedBookDto.getTitle());
            book.setIsbn(updatedBookDto.getIsbn());
            booksRepository.save(book);
            BookDto newUpdatedDto = new BookDto();

            newUpdatedDto.setNoOfBooks(book.getNoOfBooks());
            newUpdatedDto.setAuthorName(book.getAuthorName());
            newUpdatedDto.setEdition(book.getEdition());
            newUpdatedDto.setTitle(book.getTitle());
            newUpdatedDto.setIsbn(book.getIsbn());
            return newUpdatedDto;


        }
        else
        {
            throw new RuntimeException("The book +"+id+"is not found" );
        }
    }
    public void deleteBookByID(int id)
    {
        Optional<Book> optionalBook = booksRepository.findById(id);
        if(optionalBook.isPresent())
        {
            Book book =optionalBook.get();
            booksRepository.delete(book);
        }
        else
        {
            throw new RuntimeException("The Book of book id"+id+"is not found");
        }


    }



}
