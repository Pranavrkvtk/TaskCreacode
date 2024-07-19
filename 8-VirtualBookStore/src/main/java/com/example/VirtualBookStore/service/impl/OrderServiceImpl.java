package com.example.VirtualBookStore.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.VirtualBookStore.dto.OrderRequestDTO;
import com.example.VirtualBookStore.model.BookOrder;
import com.example.VirtualBookStore.model.Books;
import com.example.VirtualBookStore.repository.IBookRepository;
import com.example.VirtualBookStore.repository.IorderRepository;
import com.example.VirtualBookStore.service.OrderService;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private IorderRepository orderRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public BookOrder saveOrder(OrderRequestDTO orderRequest) {
        // Find the book by id
        Books book = bookRepository.findById(orderRequest.getId())
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + orderRequest.getId()));

        // Calculate total price
        double totalPrice = orderRequest.getQuantity() * book.getPrice();

        // Create the order object
        BookOrder order = new BookOrder();
        order.setBook(book);
        order.setQuantity(orderRequest.getQuantity());
        order.setTotalPrice(totalPrice);

        // Save the order
        BookOrder savedOrder = orderRepository.save(order);

        // Print saved order details (for debugging purposes)
        System.out.println("Saved order details:");
        System.out.println("ID: " + savedOrder.getId());
        System.out.println("Book: " + savedOrder.getBook().getBookname());
        System.out.println("Quantity: " + savedOrder.getQuantity());
        System.out.println("Total Price: " + savedOrder.getTotalPrice());

        return savedOrder;
    }

    @Override
    public BookOrder getOrderById(UUID id) {
        return orderRepository.findById(id).orElse(null);
    }
}
