package com.latiah.spring.demo.domain;

import com.latiah.spring.demo.domain.baseEntity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Order extends BaseEntity {
    @OneToOne
    private User user;

    private Date orderDate;
    private int orderPrice;
    private String orderLocation;

    private OrderStatus orderStatus;

    @OneToOne
    private Store store;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Food> food;
}
