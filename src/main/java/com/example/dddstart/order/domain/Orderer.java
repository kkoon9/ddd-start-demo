package com.example.dddstart.order.domain;

import lombok.Getter;

import javax.persistence.*;

@Embeddable
@Getter
public class Orderer {

    // MemberId에 정의된 칼럼 이름을 변경하기 위해 @AttributeOverride 어노테이션 사용
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;
}