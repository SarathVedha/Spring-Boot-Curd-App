package com.vedha.springboot.sms.mapper;

import com.vedha.springboot.sms.dto.StudentDTO;
import com.vedha.springboot.sms.entity.StudentEntity;

public class StudentMapper {

    public static StudentDTO mapToStudentDto(StudentEntity studentEntity) {

        return new StudentDTO(
                studentEntity.getStudentId(),
                studentEntity.getStudentName(),
                studentEntity.getStudentAddress(),
                studentEntity.getStudentEmail()
        );
    }

    public static StudentEntity mapToStudentEntity(StudentDTO studentDTO) {

        return new StudentEntity(
                studentDTO.getStudentId(),
                studentDTO.getStudentName(),
                studentDTO.getStudentAddress(),
                studentDTO.getStudentEmail()
        );
    }
}
