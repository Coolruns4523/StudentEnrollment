package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollment,Long> {
    Enrollment findEnrollmentById(long id);
}
