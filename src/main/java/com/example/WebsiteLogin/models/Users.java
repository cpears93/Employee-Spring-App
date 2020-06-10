package com.example.WebsiteLogin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Column(name = "name")
    private String name;

    @Column(name = "folder_list")
    private String folderList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "folder_id", nullable = false)
    private Folders folders;

    @JsonIgnoreProperties("folders")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "folder_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "files_id", nullable = false, updatable = false)}
    )
    private List<Files> files;

    public Users(String name, String folderList) {
        this.name = name;
        this.folderList = folderList;
    }

    public String getName() {
        return name;
    }

    public String getFolderList() {
        return folderList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFolderList(String folderList) {
        this.folderList = folderList;
    }
}
