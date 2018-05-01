package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String studentNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    @ManyToMany (mappedBy = "students")
    public Set<Course> courses;

    @ManyToMany (mappedBy = "students")
    public Set<Enrollment> myEnrollment;

    @ManyToMany(mappedBy = "students")
    public Set<Session> mySession;


    public Student(String studentNumber, String firstName, String lastName, String phoneNumber, String address) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        myEnrollment= new HashSet<>();
        mySession = new HashSet<>();

    }

    public Student()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Enrollment> getMyEnrollment() {
        return myEnrollment;
    }

    public void setMyEnrollment(Set<Enrollment> myEnrollment) {
        this.myEnrollment = myEnrollment;
    }

    public Set<Session> getMySession() {
        return mySession;
    }

    public void setMySession(Set<Session> mySession) {
        this.mySession = mySession;
    }
}
