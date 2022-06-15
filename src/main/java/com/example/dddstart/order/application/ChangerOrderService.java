package com.example.dddstart.order.application;

import com.example.dddstart.order.domain.Order;
import com.example.dddstart.order.domain.OrderNo;
import com.example.dddstart.order.domain.OrderRepository;
import com.example.dddstart.order.domain.ShippingInfo;
import com.example.dddstart.user.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class ChangerOrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public void changeShippingInfo(OrderNo id, ShippingInfo newShippingInfo,
                                   boolean useNewShippingAddrAsMemberAddr) {
        Order order = orderRepository.findById(id);

        order.changeShippingInfo(newShippingInfo);
        order.shipTo(newShippingInfo);
        if (useNewShippingAddrAsMemberAddr) {
//            Member member = findMember(order.getOrderer().getMemberId());
//            member.changeAddress(newShippingInfo.getAddress());
        }
    }
}
