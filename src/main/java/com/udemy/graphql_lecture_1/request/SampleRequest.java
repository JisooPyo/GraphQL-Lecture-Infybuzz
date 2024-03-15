package com.udemy.graphql_lecture_1.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // @Getter와 @Setter는 맵핑할 때 필요하므로 꼭 설정해준다.
public class SampleRequest {
    private String firstName;
    private String lastName;
}
