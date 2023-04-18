package com.example.LMS.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeleteStudentResponseDto {
    private String name;
    private String mobile;
    private int age;
}
