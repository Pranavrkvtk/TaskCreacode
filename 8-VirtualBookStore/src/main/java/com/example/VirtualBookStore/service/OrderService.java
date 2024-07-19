package com.example.VirtualBookStore.service;

import java.util.UUID;

import com.example.VirtualBookStore.dto.OrderRequestDTO;
import com.example.VirtualBookStore.model.BookOrder;

public interface OrderService {
    BookOrder saveOrder(OrderRequestDTO orderRequest);
    BookOrder getOrderById(UUID id);
}
