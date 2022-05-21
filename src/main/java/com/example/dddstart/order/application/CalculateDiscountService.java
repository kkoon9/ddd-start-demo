package com.example.dddstart.order.application;

import com.example.dddstart.order.domain.Customer;
import com.example.dddstart.order.domain.RuleDiscounter;
import com.example.dddstart.order.domain.Money;
import com.example.dddstart.order.domain.OrderLine;

import java.util.List;

public class CalculateDiscountService {
    private RuleDiscounter ruleDiscounter;

    public CalculateDiscountService(RuleDiscounter ruleDiscounter) {
        this.ruleDiscounter = ruleDiscounter;
    }

    public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
        Customer customer = findCustomer(customerId);
        return ruleDiscounter.applyRules(customer, orderLines);
    }

    private Customer findCustomer(String customerId) {
        return new Customer(customerId);
    }
}
