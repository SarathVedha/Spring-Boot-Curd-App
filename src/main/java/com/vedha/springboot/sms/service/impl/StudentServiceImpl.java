package com.vedha.springboot.sms.service.impl;

import com.vedha.springboot.sms.dto.StudentDTO;
import com.vedha.springboot.sms.entity.StudentEntity;
import com.vedha.springboot.sms.repository.StudentRepository;
import com.vedha.springboot.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {

        List<StudentEntity> all = studentRepository.findAll();

        return all.stream().map(studentEntity -> modelMapper.map(studentEntity, StudentDTO.class)).toList();
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {

        studentRepository.save(modelMapper.map(studentDTO, StudentEntity.class));

    }

    @Override
    public StudentDTO getStudentById(Long studentId) {

        Optional<StudentEntity> byId = studentRepository.findById(studentId);

        StudentEntity studentEntity = null;
        if (byId.isPresent()) {

            studentEntity = byId.get();
        }

        return modelMapper.map(studentEntity, StudentDTO.class);
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) {

        studentRepository.save(modelMapper.map(studentDTO, StudentEntity.class));

    }

    @Override
    public void deleteStudent(Long studentId) {

        studentRepository.deleteById(studentId);
    }

}
