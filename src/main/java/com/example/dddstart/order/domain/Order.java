package com.example.dddstart.order.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "purchase_order")
public class Order {

    @EmbeddedId
    private OrderNo id;
    private OrderState state;
    @Embedded
    private ShippingInfo shippingInfo;
    private Money totalAmounts;
    @Embedded
    private Orderer orderer;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;
    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        changeOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void changeOrderLines(List<OrderLine> newLines) {
        orderLines.changeOrderLines(newLines);
        this.totalAmounts = orderLines.getTotalAmounts();
    }

    private void setShippingInfo(ShippingInfo newShippingInfo) {
        if(shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = newShippingInfo;
    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalStateException("already shipped");
        }
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    public void changeShipped() {
    }

    public void completePayment() {
    }


    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        int sum = orderLines
                .getLines()
                .stream()
                .mapToInt(x -> x.getPrice().getValue() * x.getQuantity())
                .sum();
        this.totalAmounts = new Money(sum);
    }

    public void shipTo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}