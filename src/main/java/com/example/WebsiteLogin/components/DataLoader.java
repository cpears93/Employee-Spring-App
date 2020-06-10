package com.example.WebsiteLogin.components;

import com.example.WebsiteLogin.models.Files;
import com.example.WebsiteLogin.models.Folders;
import com.example.WebsiteLogin.models.Users;
import com.example.WebsiteLogin.repository.FilesRepository;
import com.example.WebsiteLogin.repository.FoldersRepository;
import com.example.WebsiteLogin.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FilesRepository filesRepository;

    @Autowired
    FoldersRepository foldersRepository;

    @Autowired
    UsersRepository usersRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        File employee = new File("New User");
        filesRepository.save(employee);

        Folders project = new Folders("New Project", "File List", "User List");
        foldersRepository.save(project);

        Users JSmith = new Users("John Smith", "List of Folders");
        usersRepository.save(users);
    }
}
