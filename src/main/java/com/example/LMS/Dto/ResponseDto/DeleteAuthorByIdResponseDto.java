package com.example.LMS.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeleteAuthorByIdResponseDto {
    private String name;
    private int age;
    private String email;

    private String Status;
}
