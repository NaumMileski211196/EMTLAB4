package com.example.ordermanagment.domain.valueobjects;

import com.example.sharedkernel.domain.base.ValueObject;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class Mobile implements ValueObject {

    private final MobileId mobileId;

    private final String name;

    private final Money price;




    @JsonCreator
    public Mobile(MobileId mobileId, String name,Money price){
         this.mobileId=mobileId;
         this.name=name;
         this.price=price;
    }





}
