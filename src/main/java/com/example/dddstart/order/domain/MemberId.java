package com.example.dddstart.order.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
public class MemberId implements Serializable {
    @Column(name = "member_id")
    private Long id;
}
