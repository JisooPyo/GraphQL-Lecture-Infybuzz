package com.udemy.graphql_lecture_1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udemy.graphql_lecture_1.entity.Address;
import com.udemy.graphql_lecture_1.entity.Student;
import com.udemy.graphql_lecture_1.entity.Subject;
import com.udemy.graphql_lecture_1.repository.AddressRepository;
import com.udemy.graphql_lecture_1.repository.StudentRepository;
import com.udemy.graphql_lecture_1.repository.SubjectRepository;
import com.udemy.graphql_lecture_1.request.CreateStudentRequest;
import com.udemy.graphql_lecture_1.request.CreateSubjectRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;
    private final SubjectRepository subjectRepository;

    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student(createStudentRequest);

        Address address = new Address();
        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());

        address = addressRepository.save(address);

        student.setAddress(address);
        student = studentRepository.save(student);

        List<Subject> subjectsList = new ArrayList<Subject>();

        if (createStudentRequest.getSubjectsLearning() != null) {
            for (CreateSubjectRequest createSubjectRequest :
                createStudentRequest.getSubjectsLearning()) {
                Subject subject = new Subject();
                subject.setSubjectName(createSubjectRequest.getSubjectName());
                subject.setMarksObtained(createSubjectRequest.getMarksObtained());
                subject.setStudent(student);

                subjectsList.add(subject);
            }

            subjectRepository.saveAll(subjectsList);

        }

        student.setLearningSubjects(subjectsList);

        return student;
    }
}
