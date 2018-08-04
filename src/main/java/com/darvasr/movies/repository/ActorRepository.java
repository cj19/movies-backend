package com.darvasr.movies.repository;

import com.darvasr.movies.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository  extends JpaRepository<Actor, Long> {
}
