package com.example.LMS.Dto.ResponseDto;

import com.example.LMS.entities.Student;
import com.example.LMS.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetStudentResponseDto {

   private int id;
   private String name;
   private int age;
   private Department department;
   private String mobile;
   private String email;

}
