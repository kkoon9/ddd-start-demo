package com.example.dddstart.order.query.dao;

import com.example.dddstart.order.query.dto.OrderSummary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderSummaryDao extends Repository<OrderSummary, String> {

}
