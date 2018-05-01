package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String courseName;
    private String courseNumber;

    @ManyToMany(mappedBy = "course")
    public Set<Session> mySession;
    @ManyToMany(mappedBy = "courses")
    public Set<Enrollment> myEnrollment;

    @ManyToMany()
    private Student students;

    public Course(String courseName, String courseNumber)
    {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        mySession = new HashSet<>();
        myEnrollment = new HashSet<>();

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Set<Session> getMySession() {
        return mySession;
    }

    public void setMySession(Set<Session> mySession) {
        this.mySession = mySession;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    public Set<Enrollment> getMyEnrollment() {
        return myEnrollment;
    }

    public void setMyEnrollment(Set<Enrollment> myEnrollment) {
        this.myEnrollment = myEnrollment;
    }
}
