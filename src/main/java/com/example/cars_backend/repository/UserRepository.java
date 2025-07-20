package com.example.cars_backend.repository;

import com.example.cars_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Modifying
    @Query(value = "INSERT INTO public.users_favorite_cars(user_id, car_id) VALUES (:userId, :carId);", nativeQuery = true)
    void addCarToFavorites(@Param("userId") UUID userId, @Param("carId") UUID carId);

    @Modifying
    @Query(value = "DELETE FROM public.users_favorite_cars WHERE user_id = :userId AND car_id = :carId;", nativeQuery = true)
    void deleteCarFromFavorites(@Param("userId") UUID userId, @Param("carId") UUID carId);

}
