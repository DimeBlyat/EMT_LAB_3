package mk.ukim.finki.lab1.service.impl;

import mk.ukim.finki.lab1.model.Host;
import mk.ukim.finki.lab1.repository.HostRepository;
import mk.ukim.finki.lab1.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> findAllHosts() {
        return this.hostRepository.findAll();
    }

    @Override
    public Optional<Host> save(Host host) {
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Host create(Host host) {
        Host host1 = new Host(host.getName(), host.getSurname(), host.getCountry());

        return this.hostRepository.save(host1);
    }

    @Override
    public Host update(Long id, Host host) throws Exception {
        Host host1 = this.hostRepository.findById(id).orElseThrow(Exception::new);
        host1.setName(host.getName());
        host1.setSurname(host.getSurname());
        host1.setCountry(host.getCountry());
        return this.hostRepository.save(host1);
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}