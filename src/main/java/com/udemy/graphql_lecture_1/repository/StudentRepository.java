package com.udemy.graphql_lecture_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.graphql_lecture_1.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
