package com.example.fordleapi.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Long>{//entity and its identifier data type


}
