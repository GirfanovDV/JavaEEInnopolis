package ru.inno.consultation.repository;

import ru.inno.consultation.entity.Cart;

import java.util.List;

public interface CartRepository {

    List<Cart> findAll();
}
