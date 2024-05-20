package com.example.ordermanagment.service.forms;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderForm {

    private List<OrderItemForm> items = new ArrayList<>();

}
