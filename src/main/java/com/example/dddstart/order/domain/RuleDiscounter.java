package com.example.dddstart.order.domain;

import com.example.dddstart.order.domain.Customer;
import com.example.dddstart.order.domain.Money;
import com.example.dddstart.order.domain.OrderLine;

import java.util.List;

public interface RuleDiscounter {
    Money applyRules(Customer customer, List<OrderLine> orderLines);
}
