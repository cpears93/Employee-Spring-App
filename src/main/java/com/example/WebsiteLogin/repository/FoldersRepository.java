package com.example.WebsiteLogin.repository;

import com.example.WebsiteLogin.models.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoldersRepository extends JpaRepository <Folders, Long> {
}
