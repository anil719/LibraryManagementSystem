package com.example.LMS.controllers;

import com.example.LMS.Dto.RequestDto.IssueBookRequestDto;
import com.example.LMS.Dto.RequestDto.ReturnBookRequestDto;
import com.example.LMS.Dto.ResponseDto.IssueBookResponseDto;
import com.example.LMS.Dto.ResponseDto.ReturnBookResponseDto;
import com.example.LMS.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue_book")
    public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception{
        return transactionService.issueBook(issueBookRequestDto);
    }

    @PostMapping("/return_book")
    public ReturnBookResponseDto returnBook(@RequestBody ReturnBookRequestDto returnBookRequestDto) throws Exception{
        return transactionService.returnBook(returnBookRequestDto);
    }
}
