package com.example.LMS.services;

import com.example.LMS.Dto.RequestDto.AddAuthorRequestDto;
import com.example.LMS.Dto.ResponseDto.AuthorResponseDto;
import com.example.LMS.Dto.ResponseDto.AuthorsWithGivenAgeResponseDto;
import com.example.LMS.Dto.ResponseDto.DeleteAuthorByIdResponseDto;
import com.example.LMS.Dto.ResponseDto.GetBookResponseDto;
import com.example.LMS.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService  {

    public String addAuthor(AddAuthorRequestDto addAuthorRequestDto);

    public DeleteAuthorByIdResponseDto deleteAuthor(int id) throws Exception;

    public AuthorResponseDto getAuthorByEmail(String email);

   public List<GetBookResponseDto> getAllBooksByAuthorId(int id) throws Exception;

   //public List<AuthorResponseDto> getAuthorsWithGivenAge(int age);
}
