package com.example.dddstart.order;

public class Order {
    private OrderState state;
    private ShippingInfo shippingInfo;

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        if (!state.isShippingChaneable()) {
            throw new IllegalStateException("배송지를 변경할 수 없는 상태입니다. : " + state);
        }
        this.shippingInfo = newShippingInfo;
    }

    public boolean isShippingChangeable() {
        return state == OrderState.PAYMENT_WAITING ||
                state == OrderState.PREPARING;
    }
}