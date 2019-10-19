package com.myght.flatsharing.repositories;

import com.myght.flatsharing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
