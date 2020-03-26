package com.latiah.spring.demo.domain;

import com.latiah.spring.demo.domain.base.BaseEntity;
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
public class Receipt extends BaseEntity {
    @OneToOne
    private User user;

    private Date receiptDate;
    private int receiptPrice;

    private OrderStatus receiptStatus;

    @OneToOne
    private Store store;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Food> food;
}
