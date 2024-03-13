package com.udemy.graphql_lecture_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.graphql_lecture_1.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
