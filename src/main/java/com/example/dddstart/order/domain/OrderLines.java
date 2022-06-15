package com.example.dddstart.order.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderLines {
    private List<OrderLine> lines;

    public Money getTotalAmounts() {
        // 구현
        return null;
    }

    protected void changeOrderLines(List<OrderLine> newLines) {
        this.lines = lines;
    }
}
