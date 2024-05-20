package com.example.mobilecatalog.domain.models;

import com.example.mobilecatalog.domain.valueobjects.Quantity;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "mobilephone")
@Getter
public class MobilePhone  extends AbstractEntity<MobilePhoneID> {

    private String mobileName;

    private Quantity quantity;

    private Money price;

    private String model;
    private String brand;

    public static MobilePhone build(String mobileName,Quantity quantity, Money price, String model,String brand) {
        MobilePhone m = new MobilePhone();
        m.mobileName=mobileName;
        m.quantity=quantity;
        m.price = price;
        m.model=model;
        m.brand=brand;
        return m;
    }


}
