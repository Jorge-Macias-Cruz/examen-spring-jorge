package com.examen.jorge.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="lenguages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String code;

    private String name;

    @ManyToMany(mappedBy = "sabeLanguages", cascade = CascadeType.PERSIST)
    private List<Employee> sabe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getSabe() {
        return sabe;
    }

    public void setSabe(List<Employee> sabe) {
        this.sabe = sabe;
    }

    @Override
    public String toString() {
        return "Language{" + "id=" + id + ", code='" + code + '\'' +
                ", name='" + name + '\'' + ", sabe=" + sabe + '}';
    }
}
