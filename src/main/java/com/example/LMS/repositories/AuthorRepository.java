package com.example.LMS.repositories;

import com.example.LMS.Dto.ResponseDto.AuthorResponseDto;
import com.example.LMS.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {


    Author getAuthorByEmail(String email);
  //  List<Author> getAuthorsWithGivenAge(int age);
}
