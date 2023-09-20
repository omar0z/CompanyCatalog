package com.pluralsight.catalog.document;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sector;

    @Column(nullable = false)
    private String contactEmail;

    public Company() {
    }

    public Company(Long id, String name, String sector, String email) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.contactEmail = email;
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String email) {
        this.contactEmail = email;
    }

    @Override
    public String toString() {
        return "{"+this.getId() + " | "
                + this.getName() + " | "
                + this.getContactEmail()+"}";
    }
}
