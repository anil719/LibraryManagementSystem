package com.example.LMS.Dto.ResponseDto;

import com.example.LMS.enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetBookResponseDto {

    private int id;
    private String title;
    private Genre genre ;
    private String author;
    private int price;
}
