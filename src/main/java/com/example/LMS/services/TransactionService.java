package com.example.LMS.services;

import com.example.LMS.Dto.RequestDto.IssueBookRequestDto;
import com.example.LMS.Dto.RequestDto.ReturnBookRequestDto;
import com.example.LMS.Dto.ResponseDto.IssueBookResponseDto;
import com.example.LMS.Dto.ResponseDto.ReturnBookResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
   public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;

   public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) throws Exception;
}
