package com.codecentric.retailbank.model.domain.OLD;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ref_transaction_types")
public class RefTransactionType {

    @Id
    @Column(name = "transaction_type_id")
    @GeneratedValue
    private Long id;

    @Length(max = 15)
    @Column(name = "transaction_type_code", nullable = false, unique = true)
    private String code;

    @Length(max = 255)
    @Column(name = "transaction_type_description")
    private String description;

    @Length(max = 1)
    @Column(name = "deposit")
    private String isDeposit;

    @Length(max = 1)
    @Column(name = "withdrawal")
    private String isWithdrawal;


    public RefTransactionType() {
        super();
    }

    public RefTransactionType(Long id) {
        super();
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsDeposit() {
        return isDeposit;
    }

    public void setIsDeposit(String isDeposit) {
        this.isDeposit = isDeposit;
    }

    public String getIsWithdrawal() {
        return isWithdrawal;
    }

    public void setIsWithdrawal(String isWithdrawal) {
        this.isWithdrawal = isWithdrawal;
    }

    public void setFields(@Length(max = 15) String code,
                          @Length(max = 255) String description,
                          Boolean isDeposit,
                          Boolean isWithdrawal) {
        this.code = code;
        this.description = description;

        if (isDeposit != null)
            this.isDeposit = isDeposit.booleanValue() == true ? "Y" : "N";

        if (isWithdrawal != null)
            this.isWithdrawal = isWithdrawal.booleanValue() == true ? "Y" : "N";
        ;
    }
}