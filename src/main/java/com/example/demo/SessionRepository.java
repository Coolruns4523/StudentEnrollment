package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session,Long>{
    Session findSessionById(long id);
}
