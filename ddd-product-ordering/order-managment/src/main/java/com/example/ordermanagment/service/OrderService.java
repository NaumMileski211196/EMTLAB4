package com.example.ordermanagment.service;

import com.example.ordermanagment.domain.exceptions.OrderIdNotExistException;
import com.example.ordermanagment.domain.exceptions.OrderItemIdNotExistException;
import com.example.ordermanagment.domain.model.Order;
import com.example.ordermanagment.domain.model.OrderID;
import com.example.ordermanagment.domain.model.OrderItemID;
import com.example.ordermanagment.service.forms.OrderForm;
import com.example.ordermanagment.service.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findById(OrderID id);

    void addItem(OrderID orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException;

    void deleteItem(OrderID orderId, OrderItemID orderItemId) throws OrderItemIdNotExistException;

}
