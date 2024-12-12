package ru.inno.consultation.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.inno.consultation.config.JDBCTemplateConfig;
import ru.inno.consultation.entity.Product;
import ru.inno.consultation.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final JdbcTemplate jdbcTemplate = JDBCTemplateConfig.jdbcTemplate();

    private static final String FIND_ALL = "select * from product";

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL, productRowMapper);
    }

    private static final RowMapper<Product> productRowMapper = (row, rowNumber) -> {
        Long id = row.getLong("id");
        String name = row.getString("name");
        Long price = row.getLong("price");

        return new Product(id, name, price);
    };
}
