package com.vedha.springboot.sms.repository;

import com.vedha.springboot.sms.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
