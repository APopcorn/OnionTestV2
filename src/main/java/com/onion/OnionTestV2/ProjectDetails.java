package com.onion.OnionTestV2;

import jakarta.persistence.*;

@Entity(name = "ProjectDetails")
@Table(name = "projectDetails")
public class ProjectDetails {

    @Id
    @SequenceGenerator(
            name = "project_details_id_sequence",
            sequenceName = "project_details_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_details_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long Id;
    private Boolean isActive;
    private String task;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "project_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "project_id_fk"
            )
    )
    private Project project;

    public ProjectDetails(Boolean isActive, String task, Project project) {
        this.isActive = isActive;
        this.task = task;
        this.project = project;
    }

    public ProjectDetails() {
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        task = task;
    }

    @Override
    public String toString() {
        return "ProjectDetails{" +
                "Id=" + Id +
                ", isActive=" + isActive +
                ", task='" + task + '\'' +
                ", project=" + project +
                '}';
    }
}
