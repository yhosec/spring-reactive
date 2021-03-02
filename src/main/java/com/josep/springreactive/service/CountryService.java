package com.josep.springreactive.service;

import com.josep.springreactive.entity.Country;
import com.josep.springreactive.repository.CountryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Flux<Country> getAll() {
        return this.countryRepository
            .findAll();
    }
}
