package com.grantcs.eatlikethis.repository;

import com.grantcs.eatlikethis.model.FoodData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDataRepository extends JpaRepository<FoodData, Long> {
}
