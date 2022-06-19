package com.example.dddstart.order.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShippingInfo {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zidCode",
                    column = @Column(name = "shipping_zidcode")),
            @AttributeOverride(name = "address1",
                    column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name = "address2",
                    column = @Column(name = "shipping_addr2")),
    })
    private Address address;

    @Column(name = "shipping_message")
    private String message;

    @Embedded
    private Receiver receiver;

    public ShippingInfo(Address address, String message, Receiver receiver) {
        this.address = address;
        this.message = message;
        this.receiver = receiver;
    }
}
