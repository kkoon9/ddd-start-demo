package com.example.dddstart.order.query.dao;

import com.example.dddstart.order.query.dto.OrderSummary;
import com.example.dddstart.order.query.dto.OrderSummary_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

public class OrdererSummarySpecs {

    public static Specification<OrderSummary> ordererId(String ordererId) {
        return (Root<OrderSummary> root,
        CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.equal(root.get(OrderSummary_.ordererId), ordererId);
    }

    public static Specification<OrderSummary> orderDateBetween(
            LocalDateTime from, LocalDateTime to) {
        return (Root<OrderSummary> root,
                CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.between(root.get(OrderSummary_.ordererDate), from, to);
    }
}
