package com.example.LMS.Dto.ResponseDto;

import com.example.LMS.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorBooksListResponseDto {
    private List<Book> bookList;
}
