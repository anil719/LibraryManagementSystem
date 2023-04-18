package com.example.LMS.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateStudentMobileResponseDto {
    private String name;
    private String newNumber;
}
