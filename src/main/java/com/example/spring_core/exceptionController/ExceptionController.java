package com.example.spring_core.exceptionController;

import com.example.spring_core.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
    @ResponseBody
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ExceptionHandler(StudentNotFoundException studentNotFoundException){
        return studentNotFoundException.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus
    String ExceptionHandlerUser(UsernameNotFoundException msg){
        return msg.getMessage();
    }
}
