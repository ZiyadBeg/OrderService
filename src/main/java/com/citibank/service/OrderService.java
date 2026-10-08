package com.citibank.service;

import com.citibank.client.PaymentClient;
import com.citibank.entity.Order;
import com.citibank.entity.PaymentDto;
import com.citibank.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
   private PaymentClient paymentClient;

    @Autowired
  private RestTemplate restTemplate;

    public List<Order> getListOfOrder(){
        return OrderRepository.orderList;

    }

    public String addOrderAndPayment(Order order) {
         OrderRepository.orderList.add(order);
        String s = paymentClient.processPayment(order);
        System.out.println(s);
        //payment
        //cut n inserted record

        //service Apna Database
        return s;
    }

    public List<PaymentDto>getPaymentListRest() {
        String url = "http://localhost:8081/payment/getPaymentList";

        // Since it is a bodyless POST request, pass null for payload but keep headers if needed
        HttpEntity<Void> requestEntity = new HttpEntity<>(new HttpHeaders());

        // Use exchange() to capture generic Collections safely without ClassCastExceptions
        ResponseEntity<List<PaymentDto>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<PaymentDto>>() {}
        );
        //kafka server
        //Order-->Payment
        //OrderDB-->PaymentDB
        //Request --> Order -->Validate-->OrderInsert-->New Flow -->PaymentService-->Controller--API-->Call->Reponse

        return response.getBody();

    }

    public boolean validOrderById(Long id) {
        Optional<Long> first = OrderRepository.orderList.stream().
                map(Order::getOrderId).filter(val -> val.equals(id)).findFirst();
           return first.isPresent();
    }
}
