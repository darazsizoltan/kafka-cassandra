package com.practice.kafkacassandra.repository;

import com.practice.kafkacassandra.entity.Advertisement;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdvertisementRepository extends CassandraRepository<Advertisement, UUID> {
}
