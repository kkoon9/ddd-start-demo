package com.example.dddstart.order.infrastructure;

import com.example.dddstart.order.domain.Order;
import com.example.dddstart.order.domain.OrderNo;
import com.example.dddstart.order.domain.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order findById(OrderNo id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }
}
