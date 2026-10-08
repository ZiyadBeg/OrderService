package com.citibank.client;

import com.citibank.entity.Order;
import com.citibank.entity.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "payment-service", url = "http://localhost:8081/payment")
public interface PaymentClient {

    @PostMapping("/deduct")
    public String deductPaymentForOrder(@RequestBody Order order);

    @GetMapping("/getPaymentList")
    public List<PaymentDto> getPaymentList();

    @PostMapping("/processPayment")
    public String processPayment(@RequestBody Order order);


}
