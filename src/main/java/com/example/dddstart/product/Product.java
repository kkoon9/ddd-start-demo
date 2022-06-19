package com.example.dddstart.product;

import com.example.dddstart.common.jpa.MoneyConverter;
import com.example.dddstart.order.domain.Money;
import com.example.dddstart.order.domain.OrderLine;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = MoneyConverter.class)
    private Money price;

    private String detail;

    // @Entity 컬렉션에 대한 즉시 로딩 설정
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();

    // @Embeddable 컬렉션에 대한 즉시 로딩 설정
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_line",
            joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    public void removeOption(int optIdx) {
        // 실제 컬렉션에 접근할 때 로딩
        this.options.remove(optIdx);
    }
    public void changeImages(List<Image> newImages) {
        images.clear();
        images.addAll(newImages);
    }
}
