package mk.ukim.finki.lab1.service.impl;

import mk.ukim.finki.lab1.model.Country;
import mk.ukim.finki.lab1.repository.CountryRepository;
import mk.ukim.finki.lab1.service.CountryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country create(Country country) {
        Country country1 = new Country(country.getName(), country.getContinent());
        return this.countryRepository.save(country1);
    }

    @Override
    public Country update(Long id, Country country) throws Exception {
        Country country1 = this.countryRepository.findById(id).orElseThrow(Exception::new);
        country1.setName(country.getName());
        country1.setContinent(country.getContinent());
        return this.countryRepository.save(country1);
    }

    @Override
    public void delete(Long id) throws Exception {
        this.countryRepository.deleteById(id);
    }
}