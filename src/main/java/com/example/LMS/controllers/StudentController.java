package com.example.LMS.controllers;

import com.example.LMS.Dto.RequestDto.AddStudentRequestDto;
import com.example.LMS.Dto.RequestDto.UpdateStudentMobileNumRequestDto;
import com.example.LMS.Dto.ResponseDto.DeleteStudentResponseDto;
import com.example.LMS.Dto.ResponseDto.StudentFindResponseDto;
import com.example.LMS.Dto.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.LMS.Dto.ResponseDto.GetStudentResponseDto;
import com.example.LMS.Exception.StudentNotFound;
import com.example.LMS.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody AddStudentRequestDto addStudentRequestDto ){
        return studentService.addStudent(addStudentRequestDto);
    }

    //delete student
    @DeleteMapping("/delete_by_id")
    public DeleteStudentResponseDto deleteStudent(@RequestParam("id")int id) throws StudentNotFound{
        return studentService.deleteStudent(id);
    }

    //api for updating mobile number
    @PutMapping("/update_mobile")
    public UpdateStudentMobileResponseDto updateNumber(@RequestBody UpdateStudentMobileNumRequestDto updateStudentMobileNumRequestDto) throws StudentNotFound {
        return studentService.updateNumber(updateStudentMobileNumRequestDto);
    }

    //find
    @GetMapping("/find_by_id")
    public StudentFindResponseDto findStudent(@RequestParam("id")int id) throws StudentNotFound {
        return studentService.findStudent(id);
    }

    @GetMapping("/find_all")
    public List<GetStudentResponseDto> findAll(){
        return studentService.findAll();
    }
}


