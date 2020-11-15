package com.example.spring_core.controller;

import com.example.spring_core.exceptions.StudentNotFoundException;
import com.example.spring_core.pojo.Student;
import com.example.spring_core.pojo.StudentReq;
import com.example.spring_core.pojo.MyUser;
import com.example.spring_core.service.MyUserService;
import com.example.spring_core.service.StudentServiceImple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@Component
public class StudentController {
    @Autowired
    private StudentServiceImple studentServiceImple;
    @Autowired
    private MyUserService myUserService;
    Logger logger= LoggerFactory.getLogger(StudentController.class);
    @PostMapping("/student")
    public ResponseEntity<String> postStudent(@RequestBody StudentReq studentReq) throws IOException{
        Student student=Student.builder()
                .name(studentReq.getName())
                .email(studentReq.getEmail())
                .rollNo(studentReq.getRollNo())
                .build();
         String status=studentServiceImple.postStudent(student);
        return new ResponseEntity<>("inserted", HttpStatus.ACCEPTED);
    }
    @PutMapping("/student/{theId}")
    public ResponseEntity<String> updateStudent(@RequestBody StudentReq studentReq,@PathVariable("theId") int id)
            throws IOException, StudentNotFoundException {
        Student student=studentServiceImple.getStudentById(id);
        Optional.ofNullable(student)
                .orElseThrow(()->
                        new StudentNotFoundException(id));
        student.setRollNo(studentReq.getRollNo());
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        String status=studentServiceImple.updateStudent(student,id);
        return new ResponseEntity<>(status,HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) throws IOException, StudentNotFoundException {
        return studentServiceImple.deleteStudent(id);
    }
    @GetMapping("/student")
    public ResponseEntity<Student> getStudentById(@RequestParam("theId") int id) throws IOException,
            StudentNotFoundException {
        Student student=studentServiceImple.getStudentById(id);
        Optional.ofNullable(student)
                .orElseThrow(()->
                    new StudentNotFoundException(id)
                );
        MyUser user=myUserService.getUserByName("user");
        logger.info("<-------User details----------->"+user.getName()+" "+user.getPassword());
        return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() throws IOException{
        List<Student> studentList=studentServiceImple.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.ACCEPTED);
    }
}
