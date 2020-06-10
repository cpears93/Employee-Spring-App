package com.example.WebsiteLogin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.catalina.User;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "files")
public class Files implements Serializable {
    @Column(name = "Project")
    private String project;

    @Column(name = "java")
    private String java;

    @Column(name = "size")
    private String size;

    @Column(name = "folder")
    private String folder;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "user_id", nullable = false)
    private User users;

    @JsonIgnoreProperties("folders")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "folder_id", nullable = false, updatable = false)}
    )
    private List<Folders> folders;

    public Files(String project, String java, String size, String folder) {
        this.project = project;
        this.java = java;
        this.size = size;
        this.folder = folder;
    }

    public String getProject() {
        return project;
    }

    public String getJava() {
        return java;
    }

    public String getSize() {
        return size;
    }

    public String getFolder() {
        return folder;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
