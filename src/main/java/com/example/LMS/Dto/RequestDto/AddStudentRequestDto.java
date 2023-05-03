package com.example.LMS.Dto.RequestDto;

import com.example.LMS.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AddStudentRequestDto {
    private String name;
    private int age;
    private String mobile;
    private String email;
    private Department department;
}
