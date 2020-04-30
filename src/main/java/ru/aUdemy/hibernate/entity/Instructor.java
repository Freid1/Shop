package ru.aUdemy.hibernate.entity;

import javax.persistence.*;

@Entity
@Table
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Instructor() {
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn
    private InstructorDetails instructorDetails;

    public Instructor(String name, InstructorDetails instructorDetails) {
        this.name = name;
        this.instructorDetails = instructorDetails;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructorDetails=" + instructorDetails +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstructorDetails getInstructorDetails() {
        return instructorDetails;
    }

    public void setInstructorDetails(InstructorDetails instructorDetails) {
        this.instructorDetails = instructorDetails;
    }
}
