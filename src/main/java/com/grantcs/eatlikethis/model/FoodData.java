package com.grantcs.eatlikethis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "food_data")
public class FoodData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String foodGroup;
    private Double calories;
    private Double fat;
    private Double protein;
    private Double carbohydrate;
}
