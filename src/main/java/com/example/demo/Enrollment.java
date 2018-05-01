package com.example.demo;

import javax.persistence.*;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean enroll;

    @ManyToMany
    private Student students;

    public Enrollment()
    {
        this.enroll = true;

    }
}
