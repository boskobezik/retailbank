package com.codecentric.retailbank.model.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @Column(name = "bank_id")
    @GeneratedValue
    private Long id;

    @Length(max = 255)
    @Column(name = "bank_details")
    private String details;

    public Bank() {
        super();
    }

    public Bank(String details) {
        this.details = details;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
