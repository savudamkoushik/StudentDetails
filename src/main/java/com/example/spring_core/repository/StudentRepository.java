package com.example.spring_core.repository;

import com.example.spring_core.exceptions.StudentNotFoundException;
import com.example.spring_core.pojo.Student;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    public List<Student> getAllStudents() throws IOException;
    public Student getStudentById(int id) throws IOException, StudentNotFoundException;
    public String postStudent(Student student) throws IOException;
    public String updateStudent(Student student,int id) throws IOException;
    public String deleteStudent(int id) throws IOException, StudentNotFoundException;
}
