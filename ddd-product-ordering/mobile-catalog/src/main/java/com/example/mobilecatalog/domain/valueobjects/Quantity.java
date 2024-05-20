package com.example.mobilecatalog.domain.valueobjects;

import com.example.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Quantity implements ValueObject {

    private final int quantity;

    protected Quantity(){
        this.quantity=0;
    }

}
