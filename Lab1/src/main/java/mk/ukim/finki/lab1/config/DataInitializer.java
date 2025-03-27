package mk.ukim.finki.lab1.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab1.model.Accommodation;
import mk.ukim.finki.lab1.model.Category;
import mk.ukim.finki.lab1.model.Country;
import mk.ukim.finki.lab1.model.Host;
import mk.ukim.finki.lab1.repository.AccommodationRepository;
import mk.ukim.finki.lab1.repository.CountryRepository;
import mk.ukim.finki.lab1.repository.HostRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;
    private final AccommodationRepository accommodationRepository;

    public DataInitializer(CountryRepository countryRepository, HostRepository hostRepository, AccommodationRepository accommodationRepository) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @PostConstruct
    public void initializeData() {
        Country country1 = new Country("Macedonia", "Europe");
        Country country2 = new Country("Russia", "Europe");
        Country country3 = new Country("China", "Asia");
        Country country4 = new Country("USA", "North America");

        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);
        this.countryRepository.save(country4);

        Host host1 = new Host("Dimitar", "Geshtakovski", country1);
        Host host2 = new Host("Artyom", "Chonry", country2);
        Host host3 = new Host("Xhon", "Xhena", country3);
        Host host4 = new Host("Bruce", "Wayne", country4);

        this.hostRepository.save(host1);
        this.hostRepository.save(host2);
        this.hostRepository.save(host3);
        this.hostRepository.save(host4);

        Accommodation accommodation1 = new Accommodation("Sunny Apartment", Category.ROOM, host1, 5);
        Accommodation accommodation2 = new Accommodation("Cozy Cottage", Category.HOUSE, host2, 3);
        Accommodation accommodation3 = new Accommodation("City Loft", Category.ROOM, host3, 2);
        Accommodation accommodation4 = new Accommodation("Luxury Villa", Category.HOUSE, host4, 8);
        Accommodation accommodation5 = new Accommodation("Beach Bungalow", Category.HOUSE, host1, 4);

        this.accommodationRepository.save(accommodation1);
        this.accommodationRepository.save(accommodation2);
        this.accommodationRepository.save(accommodation3);
        this.accommodationRepository.save(accommodation4);
        this.accommodationRepository.save(accommodation5);
    }
}