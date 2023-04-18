package com.example.LMS.Dto.ResponseDto;

import com.example.LMS.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReturnBookResponseDto {
    private String transactionNumber;
    private TransactionStatus transactionStatus;
    private String bookName;
}




