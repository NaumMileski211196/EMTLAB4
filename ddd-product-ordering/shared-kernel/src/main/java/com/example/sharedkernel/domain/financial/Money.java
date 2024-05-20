package com.example.sharedkernel.domain.financial;

import com.example.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

import java.util.Currency;

@Embeddable
@Getter
public class Money implements ValueObject {

    @Enumerated(value = EnumType.STRING)
    private final com.example.sharedkernel.domain.financial.Currency currency;

    private final double amount;

    protected Money(){
        this.currency=null;
        this.amount=0.0;
    }

   public Money(@NonNull com.example.sharedkernel.domain.financial.Currency currency,@NonNull double amount){
        this.currency=currency;
        this.amount=amount;
   }

   public static Money valueOf(com.example.sharedkernel.domain.financial.Currency currency,int amount){
        return new Money(currency,amount);
   }
    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }
        return new Money(currency,amount + money.amount);
    }

    public Money subtract(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }
        return new Money(currency,amount - money.amount);
    }

    public Money multiply(int m)  {
        return new Money(currency,amount*m);
    }


}
