package com.example.demo.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class DatabaseInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initialize() throws Exception {
        // 读取并执行 schema.sql 脚本
        String schemaSql = new String(Files.readAllBytes(Paths.get("src/main/resources/schema.sql")));
        jdbcTemplate.execute(schemaSql);

        // 读取并执行 data.sql 脚本
        String dataSql = new String(Files.readAllBytes(Paths.get("src/main/resources/data.sql")));
        jdbcTemplate.execute(dataSql);

        System.out.println("Database initialization complete.");
    }
}
