package ru.aUdemy.hibernate.entity;

import javax.persistence.*;

@Entity
@Table
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    int code;

    String name;
    String path;
    @Enumerated(value = EnumType.STRING)
    Color color;


}
