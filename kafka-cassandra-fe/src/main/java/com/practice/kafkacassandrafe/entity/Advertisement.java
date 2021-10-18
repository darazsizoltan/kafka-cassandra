package com.practice.kafkacassandrafe.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Advertisement {

    private UUID id;
    private String author;
    private String text;
}
