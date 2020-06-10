package com.example.WebsiteLogin.repository;

import com.example.WebsiteLogin.models.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository <Files, Long> {
}
