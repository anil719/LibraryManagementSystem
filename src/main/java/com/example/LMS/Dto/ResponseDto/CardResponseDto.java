package com.example.LMS.Dto.ResponseDto;

import com.example.LMS.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardResponseDto {
    private int id;

    private Date issueDate;

    private Date updatedOn;

    private Status status;

    private String validTill;
}
