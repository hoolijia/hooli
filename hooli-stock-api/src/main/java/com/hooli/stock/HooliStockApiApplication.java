package com.hooli.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HooliStockApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HooliStockApiApplication.class, args);
    }

}
