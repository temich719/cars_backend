package com.example.cars_backend.repository;

import com.example.cars_backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    @Query(value = "SELECT * FROM public.cars LIMIT :size OFFSET :offset", nativeQuery = true)
    List<Car> getCarsPage(@Param("offset") int offset, @Param("size") int size);

}
