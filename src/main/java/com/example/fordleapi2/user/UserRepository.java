package com.example.fordleapi2.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long>{

    @Query("SELECT u FROM MyUser u WHERE u.email = ?1")
    Optional<MyUser> findUserByEmail(String email);//entity and its identifier data type



}
