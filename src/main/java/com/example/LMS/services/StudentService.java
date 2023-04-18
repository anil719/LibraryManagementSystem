package com.example.LMS.services;

import com.example.LMS.Dto.RequestDto.AddStudentRequestDto;
import com.example.LMS.Dto.RequestDto.UpdateStudentMobileNumRequestDto;
import com.example.LMS.Dto.ResponseDto.DeleteStudentResponseDto;
import com.example.LMS.Dto.ResponseDto.GetStudentResponseDto;
import com.example.LMS.Dto.ResponseDto.StudentFindResponseDto;
import com.example.LMS.Dto.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.LMS.Exception.StudentNotFound;
import com.example.LMS.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public String addStudent(AddStudentRequestDto addStudentRequestDto);

    public DeleteStudentResponseDto deleteStudent(int id) throws StudentNotFound;

    public String updateStudent(int id, Student student);

    public UpdateStudentMobileResponseDto updateNumber(UpdateStudentMobileNumRequestDto updateStudentMobileNumRequestDto) throws StudentNotFound;

    public StudentFindResponseDto findStudent(int id) throws StudentNotFound;

    public List<GetStudentResponseDto> findAll();

}
