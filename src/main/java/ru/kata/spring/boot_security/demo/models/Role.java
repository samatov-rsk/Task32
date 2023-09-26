package ru.kata.spring.boot_security.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "role_id")
    private Integer userId;

    @Column(name = "role_name")
    private String name;

    public Role(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Role() {
    }

    public Integer getId() {
        return userId;
    }

    public void setId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
