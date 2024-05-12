package com.cris.crudtestex.service;

import com.cris.crudtestex.entities.Student;
import com.cris.crudtestex.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student setStudentWorkingStatus(Long studentId, boolean isWorking) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (!student.isPresent()) return null;
        student.get().setWorking(isWorking);
        return studentRepository.save(student.get());
    }
}
