package com.latiah.spring.demo.domain;

import com.latiah.spring.demo.domain.baseEntity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Food extends BaseEntity {
    private String foodName;
    private int foodPrice;
    private float rating;
}
