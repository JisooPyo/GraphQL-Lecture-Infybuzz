Client 측에서 GraphQL 쿼리를 요청할 때 변수를 이용하여 요청할 수 있다.

### Query example

query student($id : Long) {
    student(id : $id) {
        id
        firstName
        lastName
        email
        street
        city
        learningSubjects (subjectNameFilter : All) {
            id
            subjectName
            marksObtained
        }
        fullName
    }
}

-----------------VARIABLES

{
    "id" : 1
}

<br>

### Mutation example

mutation createStudent ($createStudentRequest : CreateStudentRequest){
    createStudent(createStudentRequest: $createStudentRequest) {
        id
        firstName
        lastName
        email
        street
        city
        learningSubjects(subjectNameFilters: [All]) {
            id
            subjectName
            marksObtained
        }
        fullName
    }
}

-------------------VARIABLES

{
    "createStudentRequest" : {
        "firstName": "Peter",
        "lastName": "John",
        "email": "peter@gmail.com",
        "street": "Down the street",
        "city": "New York",
        "subjectsLearning": [
        {
            "subjectName": "Java",
            "marksObtained": 55.0
        },
        {
            "subjectName": "PHP",
            "marksObtained": 50.0
        }
        ]
    }
}

### Multiple GraphQL Variables

query student($id: ID, $subName: [SubjectNameFilter]){
    student(id: $id) {
        id
        firstName
        lastName
        email
        street
        city
        learningSubjects(subjectNameFilters: $subName) {
            id
            subjectName
            marksObtained
        }
        fullName
    }
}

-------------------VARIABLES

{
    "id": 7,
    "subName": [
        "Java", "MySQL"
    ]
}
