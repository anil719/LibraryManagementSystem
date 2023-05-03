package com.example.LMS.services.Impl;

import com.example.LMS.Dto.RequestDto.AddStudentRequestDto;
import com.example.LMS.Dto.RequestDto.UpdateStudentMobileNumRequestDto;
import com.example.LMS.Dto.ResponseDto.*;
import com.example.LMS.Exception.StudentNotFound;
import com.example.LMS.entities.Card;
import com.example.LMS.entities.Student;
import com.example.LMS.enums.Status;
import com.example.LMS.repositories.StudentRepository;
import com.example.LMS.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/add")
    public String addStudent(AddStudentRequestDto addStudentRequestDto){
        Student student = new Student();
        student.setName(addStudentRequestDto.getName());
        student.setAge(addStudentRequestDto.getAge());
        student.setMobile(addStudentRequestDto.getMobile());
        student.setEmail(addStudentRequestDto.getEmail());
        student.setDepartment(addStudentRequestDto.getDepartment());
        Card card = new Card();
        card.setStatus(Status.ACTIVE);
        card.setValidTill("2024-04-16");
        card.setStudent(student);
        student.setCard(card);
        studentRepository.save(student);
        return "Student added Successfully";
    }

    @Override
    public UpdateStudentMobileResponseDto updateNumber(UpdateStudentMobileNumRequestDto updateStudentMobileNumRequestDto) throws StudentNotFound {
        Student student;
        try{
            student = studentRepository.findById(updateStudentMobileNumRequestDto.getId()).get();
            student.setMobile(updateStudentMobileNumRequestDto.getMobile());
            Student updated = studentRepository.save(student);

            UpdateStudentMobileResponseDto updateStudentMobileResponseDto = new UpdateStudentMobileResponseDto();
            updateStudentMobileResponseDto.setName(updated.getName());
            updateStudentMobileResponseDto.setNewNumber(updated.getMobile());

            return updateStudentMobileResponseDto;

        }
        catch (Exception e){
            throw new StudentNotFound("Student number not present");
        }
    }

    @Override
    public DeleteStudentResponseDto deleteStudent(int id) throws StudentNotFound {
       Student student;
       try{
           student = studentRepository.findById(id).get();
           studentRepository.delete(student);
           DeleteStudentResponseDto deleteStudentResponseDto = new DeleteStudentResponseDto();
           deleteStudentResponseDto.setName(student.getName());
           deleteStudentResponseDto.setMobile(student.getMobile());
           deleteStudentResponseDto.setAge(student.getAge());
           return deleteStudentResponseDto;
       }
       catch (Exception e){
           throw new StudentNotFound("student Id need to be deleted is not present ") ;
       }
    }

    @Override
    public String updateStudent(int id, Student student){
        Student std = studentRepository.findById(id).get();

        std.setName(student.getName());
        std.setId(id);
        std.setAge(student.getAge());
        std.setMobile(student.getMobile());
        std.setEmail(student.getEmail());
        std.setDepartment(student.getDepartment());
        studentRepository.save(std);
        return "student updated" ;
    }

    @Override
    public StudentFindResponseDto findStudent(int id) throws StudentNotFound {
        Student student;
        try{
            student = studentRepository.findById(id).get();
            StudentFindResponseDto studentFindResponseDto = new StudentFindResponseDto();
            studentFindResponseDto.setId(student.getId());
            studentFindResponseDto.setName(student.getName());
            studentFindResponseDto.setAge(student.getAge());
            studentFindResponseDto.setDepartment(student.getDepartment());
            studentFindResponseDto.setMobile(student.getMobile());
            studentFindResponseDto.setEmail(student.getEmail());

            CardResponseDto cardResponseDto = new CardResponseDto();
            cardResponseDto.setId(student.getCard().getId());
            cardResponseDto.setStatus(student.getCard().getStatus());
            cardResponseDto.setIssueDate(student.getCard().getIssuedDate());
            cardResponseDto.setValidTill(student.getCard().getValidTill());
            cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());

            studentFindResponseDto.setCardResponseDto(cardResponseDto);
            return studentFindResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFound("Student Id is not valid");
        }

    }


    @Override
    public List<GetStudentResponseDto> findAll() {
        List<Student> studentList = studentRepository.findAll();
        List<GetStudentResponseDto> findAllStudents = new ArrayList<>();
        for(Student s : studentList){
            GetStudentResponseDto getStudentResponseDto = new GetStudentResponseDto();
            getStudentResponseDto.setId(s.getId());
            getStudentResponseDto.setName(s.getName());
            getStudentResponseDto.setDepartment(s.getDepartment());
            getStudentResponseDto.setMobile(s.getMobile());
            getStudentResponseDto.setEmail(s.getEmail());
            getStudentResponseDto.setAge(s.getAge());
            findAllStudents.add(getStudentResponseDto);
        }
        return findAllStudents;

    }
}
