package mk.ukim.finki.lab1.service;

import mk.ukim.finki.lab1.model.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {

    List<Host> findAllHosts();

    Optional<Host> save(Host host);

    Host create(Host host);

    Host update(Long id, Host host) throws Exception;

    void deleteById(Long id);
}
