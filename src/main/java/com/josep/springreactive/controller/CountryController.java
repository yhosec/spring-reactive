package com.josep.springreactive.controller;

import com.josep.springreactive.entity.Country;
import com.josep.springreactive.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public Flux<Country> getAll() {
        return this.countryService.getAll();
    }
}
