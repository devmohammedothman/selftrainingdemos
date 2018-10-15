package com.selftraining.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.selftraining.model.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car,Integer> {

}
