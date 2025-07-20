package com.example.cars_backend.util.mapper;

public interface Mapper<T, S> {

    T mapToEntity(S s);

    S mapToDto(T t);

}
