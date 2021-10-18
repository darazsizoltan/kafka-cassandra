package com.practice.kafkacassandra.service;

import com.practice.kafkacassandra.entity.Advertisement;

import java.util.List;

public interface AdvertisementService {

    List<Advertisement> findAll();
}
