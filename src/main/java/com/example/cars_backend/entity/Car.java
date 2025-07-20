package com.example.cars_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "public", name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;
    @Column(name = "price_in_usd")
    private double price;
    private String description;
    @Column(name = "image_paths")
    private String imagePaths;

    public Car(String name, double price, String description, String imagePaths) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagePaths = imagePaths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(price, car.price) != 0) return false;
        if (!Objects.equals(id, car.id)) return false;
        if (!Objects.equals(name, car.name)) return false;
        if (!Objects.equals(description, car.description)) return false;
        return Objects.equals(imagePaths, car.imagePaths);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imagePaths != null ? imagePaths.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imagePaths='" + imagePaths + '\'' +
                '}';
    }
}
