package mk.ukim.finki.lab1.service.domain;

import mk.ukim.finki.lab1.model.domain.Country;
import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(Country country);

    Optional<Country> update(Long id, Country country) throws Exception;

    void deleteById(Long id) throws Exception;
}