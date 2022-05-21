package com.example.dddstart.order.application;

import com.example.dddstart.order.domain.OrderRepository;
import com.example.dddstart.order.domain.Order;
import com.example.dddstart.order.domain.OrderNo;
import org.springframework.transaction.annotation.Transactional;

public class CancelOrderService {

    private OrderRepository orderRepository;

    @Transactional
    public void cancelOrder(OrderNo orderId) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            // throw new OrderNotFoundException(orderId);
        }
        order.cancel();
    }

}
