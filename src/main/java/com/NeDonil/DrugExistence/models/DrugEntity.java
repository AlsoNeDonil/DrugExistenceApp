package com.NeDonil.DrugExistence.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drug")
public class DrugEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String form;

    @Lob
    private String description;

    @OneToMany(mappedBy = "drug")
    List<ExistenceEntity> existenceList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DrugEntity() {

    }

    public DrugEntity(String name, String form, String description) {
        this.name = name;
        this.form = form;
        this.description = description;
    }
}
