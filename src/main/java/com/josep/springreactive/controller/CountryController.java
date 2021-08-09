package com.josep.springreactive.controller;

import com.josep.springreactive.entity.Country;
import com.josep.springreactive.service.CountryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Objects;

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

    @GetMapping(value = "stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Country> getAllStream() {
        return this.countryService.getAll().delayElements(Duration.ofMillis(2500));
    }

    @GetMapping(value = "inactive", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Country> getAllInactiveStream() {
        return this.countryService.getAllInActive().delayElements(Duration.ofMillis(2500));
    }

    @GetMapping(value = "inactive-id/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Country> getInactiveIdStream(@PathVariable Integer id) {
        return this.countryService.getInActiveId(id);
    }

    @GetMapping("/find/{id}")
    public Mono<Country> find(@PathVariable int id) {
        return this.countryService.find(id);
    }

    @GetMapping("/findByCode/{code}")
    public Mono<Country> find(@PathVariable String code) {
        return this.countryService.findByCode(code);
    }

    @PostMapping("/save")
    public Mono<Country> save(@RequestBody Country country) {
        return Objects.isNull(country.getId()) ?
            this.countryService.create(country) :
            this.countryService.update(country);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable int id) {
        return this.countryService.delete(id);
    }
}
