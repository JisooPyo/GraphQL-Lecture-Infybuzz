package com.udemy.graphql_lecture_1.response;

import java.util.ArrayList;
import java.util.List;

import com.udemy.graphql_lecture_1.entity.Student;
import com.udemy.graphql_lecture_1.entity.Subject;

import lombok.Getter;

@Getter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
    private List<SubjectResponse> learningSubjects;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();

        if (student.getLearningSubjects() != null) {
            learningSubjects = new ArrayList<>();
            for (Subject subject : student.getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }
    }
}
