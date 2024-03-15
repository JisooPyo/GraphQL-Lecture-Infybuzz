package com.udemy.graphql_lecture_1.mutation;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.udemy.graphql_lecture_1.request.CreateStudentRequest;
import com.udemy.graphql_lecture_1.response.StudentResponse;
import com.udemy.graphql_lecture_1.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Mutation {
    private final StudentService studentService;

    @MutationMapping
    public StudentResponse createStudent(@Argument CreateStudentRequest createStudentRequest){
        return new StudentResponse(studentService.createStudent(createStudentRequest));
    }
}
