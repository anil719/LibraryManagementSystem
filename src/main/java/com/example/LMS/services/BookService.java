package com.example.LMS.services;

import com.example.LMS.Dto.RequestDto.AddBookRequestDto;
import com.example.LMS.Dto.ResponseDto.AuthorBooksListResponseDto;
import com.example.LMS.Dto.ResponseDto.GetBookResponseDto;
import com.example.LMS.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public String addBook(AddBookRequestDto addBookRequestDto) throws Exception;




    public String findNoOfBooksByAuthor(int id);

   public List<GetBookResponseDto> getAllBooks();
}
