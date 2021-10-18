package com.practice.kafkacassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories
@SpringBootApplication
public class KafkaCassandraApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaCassandraApplication.class, args);
    }

}
