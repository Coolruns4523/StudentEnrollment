package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepositoy extends CrudRepository<Student,Long>{
    Student findStudentById(long id);
}
