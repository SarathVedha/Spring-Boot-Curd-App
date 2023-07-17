package com.vedha.springboot.sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long studentId;

    @NotEmpty(message = "*Name Should Not Be Blank")
    private String studentName;

    @NotEmpty(message = "*Address Should Not Be Blank")
    private String studentAddress;

    @NotEmpty(message = "*Email Should Not Be Blank")
    @Email(message = "*Enter Valid Email")
    private String studentEmail;
}
