package mk.ukim.finki.lab1.service.application;

import mk.ukim.finki.lab1.model.domain.Host;
import mk.ukim.finki.lab1.dto.CreateHostDto;
import mk.ukim.finki.lab1.dto.DisplayHostDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {

    List<DisplayHostDto> findAll();

    Optional<DisplayHostDto> findById(Long id);

    Optional<DisplayHostDto> save(CreateHostDto host);

    Optional<DisplayHostDto> update(Long id, CreateHostDto host);

    void deleteById(Long id);
}
