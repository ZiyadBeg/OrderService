package com.citibank.repository;

import com.citibank.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    public  static List<Order> orderList=new ArrayList<>();
    static {
    Order order=new Order(101,"Briyani",200d,"amir@gmail.com");
    Order order1=new Order(102,"Pulao",180.90d,"pulao@gmail.com");
    Order order2=new Order(103,"Butter Chicken",350d,"butter@gmail.com");
    Order order3=new Order(103,"Pasta",189.27d,"Pasta@gmail.com");
    orderList.add(order);
    orderList.add(order1);
    orderList.add(order2);
    orderList.add(order3);
    }
}
