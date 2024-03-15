package com.udemy.graphql_lecture_1.response;

import java.util.ArrayList;
import java.util.List;

import com.udemy.graphql_lecture_1.entity.Student;

import lombok.Getter;

@Getter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
    private List<SubjectResponse> learningSubjects = new ArrayList<>();

    // this is for internal use. DO NOT PUT IN SCHEMA.
    private Student student;

    // 단순히 firstName과 lastName을 더해서 반환해줘도 되지만,
    // 이 필드를 생성하는데 어떤 로직이 조금이라도 더 들어가면 @SchemaMapping 하는 것을 권한다.
    // 모든 클라이언트가 모든 값을 원하지 않기 때문에. => Application의 Performance를 향상시키기 때문
    private String fullName;

    public StudentResponse(Student student) {
        this.student = student;
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();

        // GraphQL에서 이 방식은 추천되지 않는다.
        // if (student.getLearningSubjects() != null) {
        //     learningSubjects = new ArrayList<>();
        //     for (Subject subject : student.getLearningSubjects()) {
        //         learningSubjects.add(new SubjectResponse(subject));
        //     }
        // }
    }
}
