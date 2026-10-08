package com.citibank.controller;

import com.citibank.client.PaymentClient;
import com.citibank.entity.Order;
import com.citibank.entity.PaymentDto;
import com.citibank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentClient paymentClient;

    @GetMapping("")
    public ResponseEntity<List<Order>> getListOfOrder(){
        List<Order> listOfOrder = orderService.getListOfOrder();
       return ResponseEntity.ok(listOfOrder);
    }

    @PostMapping("addOrderAndPayment")
    public ResponseEntity<String> addOrderAndPayment(@RequestBody Order order){
       String s= orderService.addOrderAndPayment(order);
        return ResponseEntity.ok(s);
    }
    @GetMapping("/validOrderById/{id}")
    public ResponseEntity<Boolean> validOrderById(@PathVariable Long id){
        boolean b = orderService.validOrderById(id);
        return ResponseEntity.ok(b);

    }

    /* Testing API for Feign Client n REST
    @GetMapping("payment")
    public ResponseEntity<List<PaymentDto>> getPaymentList(){
        return ResponseEntity.ok(paymentClient.getPaymentList());
    }

    @GetMapping("paymentRest")
    public ResponseEntity<List<PaymentDto>> getPaymentListRest(){
        return ResponseEntity.ok(orderService.getPaymentListRest());
    } */
    //Order
    //payment

    //Functional
    //1 Login
    // 2 List Of Order
    // 3 select a order Mandi
    // 4 payment Method
    // 5 payment confirmed VS cancel/failed
    // 6 Notification SMS/MAIL OrderId
    // 7 track

    //OrderService
    // OrderAdd--> button double click hua
    // OrderAdd--> Network Issue
    // Jo Request dogae usska same output duga
    // GET,PUT DELETE,
    //getUserById(10);
    //updateUserById(10)
    //updateUserById(10)
    //POST --> new Request orderId,OrderID
    //UserID ne koi 2 second bheji naa ho

    //First userId/123e4567-e89b-12d3-a456-426614174000 OrderAdd-->
    //Redis Database
    //-->123e4567-e89b-12d3-a456-426614174000
    //-->UserID-->  //123e4567-e89b-12d3-a456-426614174000




}
