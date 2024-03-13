package com.udemy.graphql_lecture_1.response;

import com.udemy.graphql_lecture_1.entity.Subject;

import lombok.Getter;

@Getter
public class SubjectResponse {
    private Long id;
    private String subjectName;
    private Double marksObtained;

    public SubjectResponse(Subject subject) {
        this.id = subject.getId();
        this.subjectName = subject.getSubjectName();
        this.marksObtained = subject.getMarksObtained();
    }
}
