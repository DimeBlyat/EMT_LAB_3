package mk.ukim.finki.lab1.service.domain;

import mk.ukim.finki.lab1.model.domain.Host;
import mk.ukim.finki.lab1.model.domain.User;
import mk.ukim.finki.lab1.model.projections.HostProjection;
import mk.ukim.finki.lab1.model.projections.UserProjection;
import mk.ukim.finki.lab1.model.views.HostByCountry;

import java.util.List;
import java.util.Optional;

public interface HostService {

    List<Host> findAll();

    Optional<Host> findById(Long id);

    Optional<Host> save(Host host);

    Optional<Host> update(Long id, Host host);

    void deleteById(Long id);

    List<HostByCountry> getHostsByCountry();

    List<HostProjection> findAllNames();
}
