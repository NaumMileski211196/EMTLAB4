package com.example.ordermanagment.domain.model;

import com.example.ordermanagment.domain.valueobjects.Mobile;
import com.example.ordermanagment.domain.valueobjects.MobileId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.base.DomainObjectId;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderID> {

    private Instant orderedOn;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemsList;

    public Money total() {
        return orderItemsList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    public OrderItem addItem(@NonNull Mobile mobile, int qty){
        Objects.requireNonNull(mobile,"product must not be null");
        var item  = new OrderItem(mobile.getMobileId(),mobile.getPrice(),qty);
        orderItemsList.add(item);
        return item;

    }
    public void removeItem(@NonNull OrderItemID orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItemsList.removeIf(v->v.getId().equals(orderItemId));
    }

}
