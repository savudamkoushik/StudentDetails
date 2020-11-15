package com.example.spring_core.exceptions;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(int id){
        super("student not exist "+ id);
    }

}
