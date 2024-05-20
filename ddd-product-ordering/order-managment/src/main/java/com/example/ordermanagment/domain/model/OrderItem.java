package com.example.ordermanagment.domain.model;

import com.example.ordermanagment.domain.valueobjects.MobileId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.base.DomainObjectId;
import com.example.sharedkernel.domain.financial.Money;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "shopping_cart")
@Getter
public class OrderItem extends AbstractEntity<OrderItemID> {

     private Money itemPrice;

     @Column(name = "qty",nullable = false)
     private int quantity;

     @AttributeOverride(name = "id", column = @Column(name = "mobile_id", nullable = false))
     private MobileId mobileId;

     public OrderItem(@NonNull MobileId mobileId, @NonNull Money itemPrice, int qty) {
         // super(DomainObjectId.randomId(OrderItemID.class));
          this.mobileId = mobileId;
          this.itemPrice = itemPrice;
          this.quantity = qty;
     }
     public OrderItem(){

     }
     public Money subtotal() {
          return itemPrice.multiply(quantity);
     }

}
