package com.josep.springreactive.repository;

import com.josep.springreactive.entity.Country;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CountryRepository extends ReactiveCrudRepository<Country, Integer> {
    Mono<Country> findCountryByCode(@Param("code") String code);
}
