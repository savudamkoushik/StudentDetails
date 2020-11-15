package com.example.spring_core.service;

import com.example.spring_core.exceptions.StudentNotFoundException;
import com.example.spring_core.pojo.Student;
import com.example.spring_core.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StudentServiceImple {
    @Autowired
    @Qualifier("repositoryDao")
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() throws IOException{
        return studentRepository.getAllStudents();
    }
    public Student getStudentById(int id) throws IOException, StudentNotFoundException{
        return studentRepository.getStudentById(id);
    }
    public String postStudent(Student student) throws IOException{
        return studentRepository.postStudent(student);
    }
    public String updateStudent(Student student,int id) throws IOException{
        return studentRepository.updateStudent(student,id);
    }
    public String deleteStudent(int id) throws IOException, StudentNotFoundException{
        return studentRepository.deleteStudent(id);
    }
}
