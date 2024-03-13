package com.udemy.graphql_lecture_1.service;

import org.springframework.stereotype.Service;

import com.udemy.graphql_lecture_1.entity.Student;
import com.udemy.graphql_lecture_1.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }
}
