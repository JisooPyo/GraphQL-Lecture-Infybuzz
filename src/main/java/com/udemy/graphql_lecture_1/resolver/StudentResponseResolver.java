package com.udemy.graphql_lecture_1.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.udemy.graphql_lecture_1.entity.Student;
import com.udemy.graphql_lecture_1.entity.Subject;
import com.udemy.graphql_lecture_1.response.StudentResponse;
import com.udemy.graphql_lecture_1.response.SubjectResponse;

// Lazy Loading의 경우 @SchemaMapping으로 처리 가능
// 클라이언트쪽에서 원하지 않는다면 쿼리를 여러 번 날리지 않고 한 번만 날리기 때문에 효율적
// Eager Loading의 경우 Dto에 바로 method로 넣어주면 된다.
// Spring Boot 2에서는 특정 Response Model에 대한 GraphQLResolver를 implement했기 때문에
// 필요시 한 Response Model 당 한 Resolver였는데,
// Spring Boot 3에서는 @SchemaMapping으로 이를 대체했기 때문에 한 Resolver에서 여러 모델을 써도 될 것 같다.
// 분류를 잘 해야 할 듯..!
@Controller
public class StudentResponseResolver {

    @SchemaMapping(typeName = "StudentResponse", field = "learningSubjects")
    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse) {
        // System.out.println("getLearningSubjects method is called");
        Student student = studentResponse.getStudent();
        List<SubjectResponse> learningSubjects = new ArrayList<>();
        if (student.getLearningSubjects() == null) {
            return learningSubjects;
        }
        for (Subject subject : student.getLearningSubjects()) {
            learningSubjects.add(new SubjectResponse(subject));
        }
        return learningSubjects;
    }

    @SchemaMapping(typeName = "StudentResponse", field = "fullName")
    public String getFullName(StudentResponse studentResponse) {
        // System.out.println("getFullName method is called");
        return studentResponse.getFirstName() + " " + studentResponse.getLastName();
    }
}
