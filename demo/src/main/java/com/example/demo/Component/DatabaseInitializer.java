package com.example.demo.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        boolean machineTableExists = tableExists("machine");
        boolean humanTableExists = tableExists("human");

        if (!machineTableExists || !humanTableExists) {
            System.out.println("One or both tables do not exist, initializing database...");

            // 執行 schema.sql
            String schemaSql = new String(Files.readAllBytes(Paths.get("src/main/resources/schema.sql")));
            jdbcTemplate.execute(schemaSql);

            // 執行 data.sql
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
