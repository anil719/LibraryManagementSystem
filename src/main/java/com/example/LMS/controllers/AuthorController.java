package com.example.LMS.controllers;

import com.example.LMS.Dto.RequestDto.AddAuthorRequestDto;
import com.example.LMS.Dto.ResponseDto.AuthorResponseDto;
import com.example.LMS.Dto.ResponseDto.AuthorsWithGivenAgeResponseDto;
import com.example.LMS.Dto.ResponseDto.DeleteAuthorByIdResponseDto;
import com.example.LMS.Dto.ResponseDto.GetBookResponseDto;
import com.example.LMS.entities.Author;
import com.example.LMS.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {


    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AddAuthorRequestDto addAuthorRequestDto){
        return authorService.addAuthor(addAuthorRequestDto);
    }
    @DeleteMapping("/delete_by_id")
    public DeleteAuthorByIdResponseDto deleteAuthor(@RequestParam("id")int id) throws Exception {
        return authorService.deleteAuthor(id);
    }

    @GetMapping("/get_all_books")
    public List<GetBookResponseDto> getAllBooksByAuthorId(@RequestParam("id")int id) throws Exception{
        return authorService.getAllBooksByAuthorId(id);
    }

    @GetMapping("/get_by_email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam("email")String email){
        return authorService.getAuthorByEmail(email);
    }

//    @GetMapping("/authors_with_given_age")
//    public List<AuthorResponseDto> getAuthorsWithGivenAge(@RequestParam("age")int age){
//        return authorService.getAuthorsWithGivenAge(age);
//    }

}
