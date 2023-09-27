package com.taha.DatabasePostgres;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DatabasePostgresApplication {
	public final DataSource dataSource;

	DatabasePostgresApplication(DataSource dataSource){
		this.dataSource = dataSource;
	}
	public static void main(String[] args) {
		SpringApplication.run(DatabasePostgresApplication.class, args);
	}
}
