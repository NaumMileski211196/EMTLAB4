package com.example.ordermanagment.service.forms;

import com.example.ordermanagment.domain.valueobjects.Mobile;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class OrderItemForm {
    @NotNull
    private Mobile mobile;


    private int quantity = 1;

}
