package com.example.LMS.Dto.RequestDto;

import com.example.LMS.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddBookRequestDto {
    private String title;
    private Genre genre;
    private int noOfPages;
    private int price;
    private int authorId;
}
