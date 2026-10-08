package com.citibank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private  long orderId;
    private  String orderName;
    private  double amount;
    private  String emailId;

}
