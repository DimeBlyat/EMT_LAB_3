package mk.ukim.finki.lab1.service;

import mk.ukim.finki.lab1.model.Country;
import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();

    Country create(Country country);

    Country update(Long id, Country country) throws Exception;

    void delete(Long id) throws Exception;
}