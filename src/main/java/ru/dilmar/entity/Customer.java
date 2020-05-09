package ru.dilmar.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  @Column(unique = true, nullable = false)
    @NotBlank
    // @Pattern(regexp = "^[a-zA-Zа-яА-Я/S]{3,20}")
    @Size(min = 1, max = 25)
    //@UserCheckInDb(nameField = "username", message = "Пользователь с таким именнем уже есть")
    private String name;


    @NotBlank
    @Size(min = 1, max = 50)
    private String address;


    @NotBlank
    @Email(regexp = "[a-zA-Z1-9\\-\\._]+@[a-z1-9]+(.[a-z1-9]+){1,}")
    //@UserCheckInDb(nameField = "email", message = "Пользователь с такой электронной почтой уже есть")
    private String email;

    @Column(unique = true, nullable = false)
    @NotBlank
    //@Pattern(regexp = "\\+?\\d+([\\(\\s\\-]?\\d+[\\)\\s\\-]?[\\d\\s\\-]+)?")
    //@UserCheckInDb(nameField = "phoneNumder", message = "Пользователь с таким номером уже есть")
    private String phoneNumber;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRegistrationCustomer;

    private String password;

    private boolean enabled;


    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getDateRegistrationCustomer() {
        return dateRegistrationCustomer;
    }

    public void setDateRegistrationCustomer(Date dateRegistrationCustomer) {
        this.dateRegistrationCustomer = dateRegistrationCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateRegistrationCustomer=" + dateRegistrationCustomer +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}


