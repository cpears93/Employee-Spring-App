package com.example.WebsiteLogin.repository;

import com.example.WebsiteLogin.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository <Users, Long> {
}
