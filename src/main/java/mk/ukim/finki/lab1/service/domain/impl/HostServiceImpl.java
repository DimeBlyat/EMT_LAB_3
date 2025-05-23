package mk.ukim.finki.lab1.service.domain.impl;

import mk.ukim.finki.lab1.model.domain.Host;
import mk.ukim.finki.lab1.model.projections.HostProjection;
import mk.ukim.finki.lab1.model.projections.UserProjection;
import mk.ukim.finki.lab1.model.views.HostByCountry;
import mk.ukim.finki.lab1.repository.CountryRepository;
import mk.ukim.finki.lab1.repository.HostRepository;
import mk.ukim.finki.lab1.repository.HostsByCountryRepository;
import mk.ukim.finki.lab1.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryRepository countryService;
    private final HostsByCountryRepository repository;

    public HostServiceImpl(HostRepository hostRepository, CountryRepository countryService, HostsByCountryRepository repository) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
        this.repository = repository;
    }

    public List<HostByCountry> getHostsByCountry() {
        return repository.findAll();
    }

    @Override
    public List<HostProjection> findAllNames() {
        return hostRepository.findAllBy();
    }

    @Override
    public List<Host> findAll() {
        return this.hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

//    @Override
//    public Optional<Host> save(Host host) {
//        if(host.getCountry() != null &&
//                countryService.findById(host.getCountry().getId()).isPresent()){
//            return Optional.of(hostRepository.save(new Host(host.getName(), host.getSurname(), countryService.findById(host.getCountry().getId()).get())));
//        }
//        return Optional.empty();
//    }

    @Override
    public Optional<Host> save(Host host) {
        if (host.getCountry() != null && countryService.findById(host.getCountry().getId()).isPresent()) {
            Host saved = hostRepository.save(new Host(
                    host.getName(),
                    host.getSurname(),
                    countryService.findById(host.getCountry().getId()).get()
            ));
            repository.refreshView();
            return Optional.of(saved);
        }
        return Optional.empty();
    }

//    @Override
//    public Optional<Host> update(Long id, Host host) {
//        return hostRepository.findById(id).map(existingHost -> {
//            if(host.getName()!=null){
//                existingHost.setName(host.getName());
//            }
//            if(host.getSurname()!=null){
//                existingHost.setSurname(host.getSurname());
//            }
//            if(host.getCountry()!=null && countryService.findById(host.getCountry().getId()).isPresent()){
//                existingHost.setCountry(countryService.findById(host.getCountry().getId()).get());
//            }
//            return hostRepository.save(existingHost);
//        });
//    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return hostRepository.findById(id).map(existingHost -> {
            if (host.getName() != null) existingHost.setName(host.getName());
            if (host.getSurname() != null) existingHost.setSurname(host.getSurname());
            if (host.getCountry() != null && countryService.findById(host.getCountry().getId()).isPresent()) {
                existingHost.setCountry(countryService.findById(host.getCountry().getId()).get());
            }
            Host updated = hostRepository.save(existingHost);
            repository.refreshView();
            return updated;
        });
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
        repository.refreshView();
    }
}