package com.example.spring_core.repository;

import com.example.spring_core.config.StudConfigRepostory;
import com.example.spring_core.exceptions.StudentNotFoundException;
import com.example.spring_core.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Component("repositoryDao")
public class StudentRepositoryDaoImpl implements StudentRepository{
    @Autowired
    private StudConfigRepostory studConfigRepostory;

    @Override
    public List<Student> getAllStudents() throws IOException {
        return studConfigRepostory.getSession().selectList("getAll");
    }

    @Override
    public Student getStudentById(int id) throws IOException {
        return studConfigRepostory.getSession().selectOne("getById", id);
    }

    @Override
    public String postStudent(Student student) throws IOException {
        studConfigRepostory.getSession().insert("myStudent.insert",student);
        return "inserted";
    }

    @Override
    public String updateStudent(Student student, int id) throws IOException {
        studConfigRepostory.getSession().update("update",student);
        return "updated";
    }

    @Override
    public String deleteStudent(int id) throws IOException {
        studConfigRepostory.getSession().delete("myStudent.delete",id);
        return "deleted";
    }
}
