package com.example.LMS.controllers;

import com.example.LMS.Dto.RequestDto.AddBookRequestDto;
import com.example.LMS.Dto.ResponseDto.AuthorBooksListResponseDto;
import com.example.LMS.Dto.ResponseDto.GetBookResponseDto;
import com.example.LMS.entities.Book;
import com.example.LMS.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody AddBookRequestDto addBookRequestDto) throws Exception {
        return bookService.addBook(addBookRequestDto);
    }

    @GetMapping("/get_all_books")
    public List<GetBookResponseDto> getAllBooks(){
        return bookService.getAllBooks();
    }


}
