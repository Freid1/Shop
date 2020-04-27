package ru.dilmar.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@Setter
public class Buyer {

    @Id
    @GeneratedValue
    int id;


    String name;
    String email;
    String numberPhone;
    String password;

    public Buyer(String name, String email, String numberPhone, String password) {
        this.name = name;
        this.email = email;
        this.numberPhone = numberPhone;
        this.password = password;
    }

    public Buyer() {
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // List<Goods> buyStoryGoods;


}
