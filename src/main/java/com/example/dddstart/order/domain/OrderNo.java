package com.example.dddstart.order.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class OrderNo implements Serializable {
    @Column(name = "order_number")
    private String id;

    public OrderNo(String id) {
        this.id = id;
    }

    public boolean is2ndGeneration() {
        return id.startsWith("N");
    }
}
