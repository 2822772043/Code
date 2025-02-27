package com.xinpo.pojo;

import lombok.Data;

@Data
public class Order {

    private int orderId;

    private String orderName;

    private int customerId;

    private Customer customer;


}
