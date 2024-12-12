package ru.inno.consultation.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.inno.consultation.config.JDBCTemplateConfig;
import ru.inno.consultation.entity.Cart;
import ru.inno.consultation.repository.CartRepository;

import java.util.List;

public class CartRepositoryImpl implements CartRepository {

    private final JdbcTemplate jdbcTemplate = JDBCTemplateConfig.jdbcTemplate();

    private static final String FIND_ALL = "select * from cart";

    @Override
    public List<Cart> findAll() {
        return jdbcTemplate.query(FIND_ALL, cartRowMapper);
    }

    private static final RowMapper<Cart> cartRowMapper = (row, rowNumber) -> {
        Long id = row.getLong("id");
        String owner = row.getString("owner");

        return new Cart(id, owner);
    };
}
