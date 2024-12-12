package ru.inno.consultation.repository;

import ru.inno.consultation.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

}
