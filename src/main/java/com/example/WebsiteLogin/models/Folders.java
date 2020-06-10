package com.example.WebsiteLogin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.catalina.User;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folders implements Serializable {

    @Column(name = "q1")
    private String q1;

    @Column(name = "list_of_files")
    private String listOfFiles;

    @Column(name = "user_list")
    private String userList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "file_id", nullable = false)
    private File files;

    @JsonIgnoreProperties("users")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "folder_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)}
    )
    private List<User> users;

    public Folders(String q1, String listOfFiles, String userList) {
        this.q1 = q1;
        this.listOfFiles = listOfFiles;
        this.userList = userList;
    }

    public String getQ1() {
        return q1;
    }

    public String getListOfFiles() {
        return listOfFiles;
    }

    public String getUserList() {
        return userList;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public void setListOfFiles(String listOfFiles) {
        this.listOfFiles = listOfFiles;
    }

    public void setUserList(String userList) {
        this.userList = userList;
    }
}
