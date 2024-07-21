package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
User findUserByUsername(String username);
@Query("SELECT u.userId FROM User u WHERE u.username = :username")
Integer findIdByUsername(@Param("username") String username);
}
