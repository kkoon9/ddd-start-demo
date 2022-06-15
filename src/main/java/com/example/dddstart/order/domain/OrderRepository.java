package com.example.dddstart.order.domain;

import com.example.dddstart.order.domain.Order;
import com.example.dddstart.order.domain.OrderNo;

public interface OrderRepository {
    Order findById(OrderNo orderNo);
    void save(Order order);
}
