package com.darvasr.movies.repository;

import com.darvasr.movies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    @Nullable
    User findUserByUsername(String username);

    Optional<User> findByUsernameOrEmail(String username, String email);
}
