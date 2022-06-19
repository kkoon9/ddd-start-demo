package com.example.dddstart.order.domain;

import com.example.dddstart.product.Product;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Embeddable
public class OrderLine {
    @Embedded
    private Product product;
    @Column(name = "price")
    private Money price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "amounts")
    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }
}
