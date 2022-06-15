package com.example.dddstart.order.domain;

import java.util.List;

public interface RuleDiscounter {
    Money applyRules(Customer customer, List<OrderLine> orderLines);

    interface OrderRepository {
        Order findById(OrderNo no);
        void save(Order order);
    }
}
