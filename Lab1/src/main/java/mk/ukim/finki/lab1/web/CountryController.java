package mk.ukim.finki.lab1.web;

import mk.ukim.finki.lab1.service.CountryService;
import mk.ukim.finki.lab1.model.Country;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }
}
