package com.jwt.SpringJWT.Repository;

import com.jwt.SpringJWT.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}
