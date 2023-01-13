package com.onion.OnionTestV2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    private String images; // img type

    // inside information
        // checkbox lists

    public Project(String title, String description, String images) {
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}
