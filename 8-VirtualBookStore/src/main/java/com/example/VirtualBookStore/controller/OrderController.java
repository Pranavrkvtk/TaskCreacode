package com.example.VirtualBookStore.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VirtualBookStore.dto.OrderRequestDTO;
import com.example.VirtualBookStore.model.BookOrder;
import com.example.VirtualBookStore.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/Ordercreate")
    public BookOrder createOrder(@RequestBody OrderRequestDTO orderRequest) {
        return orderService.saveOrder(orderRequest);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<BookOrder> getOrderById(@PathVariable UUID orderId) {
        BookOrder order = orderService.getOrderById(orderId);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

