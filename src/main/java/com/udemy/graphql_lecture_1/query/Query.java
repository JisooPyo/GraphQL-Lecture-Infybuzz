package com.udemy.graphql_lecture_1.query;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.udemy.graphql_lecture_1.request.SampleRequest;

@Controller
public class Query {

    @QueryMapping
    public String firstQuery() {
        return "First Query";
    }

    @QueryMapping
    public String secondQuery() {
        return "Second Query";
    }

    // @QueryMapping
    // public String fullName(@Argument String firstName, @Argument String lastName) {
    //     return firstName + " " + lastName;
    // }

    @QueryMapping
    public String fullName(@Argument SampleRequest sampleRequest) {
        return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
    }
}
