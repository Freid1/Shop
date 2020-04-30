package ru.aUdemy.hibernate.entity;

import javax.persistence.*;

@Entity
@Table
public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public InstructorDetails() {
    }

    public InstructorDetails(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
