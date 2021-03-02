package com.josep.springreactive.repository;

import com.josep.springreactive.entity.Country;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends ReactiveCrudRepository<Country, Integer> {
}
