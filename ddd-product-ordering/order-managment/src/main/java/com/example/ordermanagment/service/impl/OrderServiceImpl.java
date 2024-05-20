package com.example.ordermanagment.service.impl;

import com.example.ordermanagment.domain.exceptions.OrderIdNotExistException;
import com.example.ordermanagment.domain.exceptions.OrderItemIdNotExistException;
import com.example.ordermanagment.domain.model.Order;
import com.example.ordermanagment.domain.model.OrderID;
import com.example.ordermanagment.domain.model.OrderItemID;
import com.example.ordermanagment.domain.repository.OrderRepository;
import com.example.ordermanagment.service.OrderService;
import com.example.ordermanagment.service.forms.OrderForm;
import com.example.ordermanagment.service.forms.OrderItemForm;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;



    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderID id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addItem(OrderID orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);
        order.addItem(orderItemForm.getMobile(),orderItemForm.getQuantity());
        orderRepository.saveAndFlush(order);

    }

    @Override
    public void deleteItem(OrderID orderId, OrderItemID orderItemId) throws OrderItemIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);
        order.removeItem(orderItemId);

    }
}
