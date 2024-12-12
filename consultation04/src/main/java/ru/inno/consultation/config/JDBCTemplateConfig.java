package ru.inno.consultation.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCTemplateConfig {

    public static JdbcTemplate jdbcTemplate() {
        var driver =new DriverManagerDataSource("jdbc:postgresql://localhost:5433/postgres", "postgres", "postgres");
        driver.setDriverClassName("org.postgresql.Driver");
        driver.setSchema("consultations");
        return new JdbcTemplate(driver);
    }

}
