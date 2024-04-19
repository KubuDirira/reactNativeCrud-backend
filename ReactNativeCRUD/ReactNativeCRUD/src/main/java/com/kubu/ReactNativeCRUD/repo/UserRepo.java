package com.kubu.ReactNativeCRUD.repo;


import com.kubu.ReactNativeCRUD.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findById(int id);
}
