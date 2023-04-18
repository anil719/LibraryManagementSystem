package com.example.LMS.Dto.RequestDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddAuthorRequestDto {
    private String name;
    private int age;
    private String email;
}
