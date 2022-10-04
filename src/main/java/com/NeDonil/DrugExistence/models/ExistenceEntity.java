package com.NeDonil.DrugExistence.models;

import javax.persistence.*;

@Entity
@Table(name = "existence")
public class ExistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int price;

    private int count;

    @ManyToOne
    @JoinColumn(name="vendor_id")
    private VendorEntity vendor;

    @ManyToOne
    @JoinColumn(name="pharmacy_id")
    private PharmacyEntity pharmacy;

    public void setVendor(VendorEntity vendor) {
        this.vendor = vendor;
    }

    public void setPharmacy(PharmacyEntity pharmacy) {
        this.pharmacy = pharmacy;
    }

    public void setDrug(DrugEntity drug) {
        this.drug = drug;
    }

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private DrugEntity drug;

    public ExistenceEntity(int price, int count, VendorEntity vendor, PharmacyEntity pharmacy, DrugEntity drug) {
        this.price = price;
        this.count = count;
        this.vendor = vendor;
        this.pharmacy = pharmacy;
        this.drug = drug;
    }

    public ExistenceEntity() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
