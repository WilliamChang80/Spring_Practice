package com.latiah.spring.demo.domain;

import com.latiah.spring.demo.domain.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Data
@Accessors(chain = true)
@Entity
@NoArgsConstructor
public class Store extends BaseEntity {
    private String storeName;
    private String storeAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Food> food;
}
