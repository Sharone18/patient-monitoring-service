package com.iitj.ecgserver.repository;

import com.iitj.ecgserver.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
    Login findByUserId(String userId);
}
