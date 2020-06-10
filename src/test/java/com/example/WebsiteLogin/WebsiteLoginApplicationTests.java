package com.example.WebsiteLogin;

import com.example.WebsiteLogin.models.Folders;
import com.example.WebsiteLogin.models.Users;
import com.example.WebsiteLogin.repository.FilesRepository;
import com.example.WebsiteLogin.repository.FoldersRepository;
import com.example.WebsiteLogin.repository.UsersRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class WebsiteLoginApplicationTests {

	@Autowired
	FilesRepository filesRepository;

	@Autowired
	FoldersRepository foldersRepository;

	@Autowired
	UsersRepository usersRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createFileAndUserThenSave(){
		File project = new File("Project");
		filesRepository.save(project);
		User john = new Users("John Smith");
		usersRepository.save(john);

		Folders folders - new Folders("Q1");
		foldersRepository.save(folders);

		john.addFolder(folders);
		folder.addUser(john);
		foldersRepository.save(folders);

	}

}
