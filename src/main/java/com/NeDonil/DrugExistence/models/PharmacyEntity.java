package com.NeDonil.DrugExistence.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pharmacy")
public class PharmacyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String address;

    @Column(length = 15)
    private String phone;

    @OneToMany(mappedBy = "pharmacy")
    List<ExistenceEntity> existenceList = new ArrayList<>();

    public PharmacyEntity() {
    }

    public PharmacyEntity(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
