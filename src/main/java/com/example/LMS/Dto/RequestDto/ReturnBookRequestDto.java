package com.example.LMS.Dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReturnBookRequestDto {
    private int cardId;
    private int bookId;
}
