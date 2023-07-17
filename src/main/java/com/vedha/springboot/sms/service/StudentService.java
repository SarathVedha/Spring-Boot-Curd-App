package com.vedha.springboot.sms.service;

import com.vedha.springboot.sms.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    void saveStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Long studentId);

    void updateStudent(StudentDTO studentDTO);

    void deleteStudent(Long studentId);

}
