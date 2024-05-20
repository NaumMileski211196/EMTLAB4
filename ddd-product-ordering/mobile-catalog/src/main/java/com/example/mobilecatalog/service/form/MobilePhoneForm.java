package com.example.mobilecatalog.service.form;

import com.example.mobilecatalog.domain.valueobjects.Quantity;
import com.example.sharedkernel.domain.financial.Money;
import lombok.Data;

@Data
public class MobilePhoneForm {


    private String mobileName;

    private Quantity quantity;

    private Money price;

    private String model;

    private String brand;
}
