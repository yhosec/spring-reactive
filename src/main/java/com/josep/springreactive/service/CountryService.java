package com.josep.springreactive.service;

import com.josep.springreactive.entity.Country;
import com.josep.springreactive.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Mono<Country> find(int id) {
        return this.countryRepository.findById(id);
    }

    public Mono<Country> findByCode(String code) {
        return this.countryRepository.findCountryByCode(code);
    }

    public Mono<Country> create(Country country) {
        country.setId(null);
        return this.countryRepository.save(country);
    }

    @Transactional
    public Mono<Country> update(Country country) {
        return this.countryRepository.findById(country.getId())
            .flatMap(updateCountry -> {
                updateCountry.setCode(country.getCode());
                updateCountry.setName(country.getName());
                return this.countryRepository.save(updateCountry);
            })
            .switchIfEmpty(create(country));
    }
    @Transactional
    public Mono<Void> delete(final int id) {
        return this.countryRepository.findById(id)
            .flatMap(country -> this.countryRepository.delete(country));
    }

}
