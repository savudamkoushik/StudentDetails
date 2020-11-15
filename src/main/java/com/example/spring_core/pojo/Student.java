package com.example.spring_core.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private int id,rollNo;
    private String name,email;
}
