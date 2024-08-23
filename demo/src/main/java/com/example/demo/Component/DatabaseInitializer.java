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

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize() throws Exception {
        // 检查 "machine" 和 "human" 表是否存在
        boolean machineTableExists = tableExists("machine");
        boolean humanTableExists = tableExists("human");

        // 如果有任一表不存在，则初始化数据库
        if (!machineTableExists || !humanTableExists) {
            System.out.println("One or both tables do not exist, initializing database...");

            // 读取并执行 schema.sql 脚本
            String schemaSql = new String(Files.readAllBytes(Paths.get("src/main/resources/schema.sql")));
            jdbcTemplate.execute(schemaSql);

            // 读取并执行 data.sql 脚本
            String dataSql = new String(Files.readAllBytes(Paths.get("src/main/resources/data.sql")));
            jdbcTemplate.execute(dataSql);

            System.out.println("Database initialization complete.");
        }
    }

    private boolean tableExists(String tableName) {
        try {
            jdbcTemplate.queryForObject("SELECT 1 FROM " + tableName + " LIMIT 1", Long.class);
            return true;
        } catch (Exception e) {
            return false; // 表不存在
        }
    }
}
