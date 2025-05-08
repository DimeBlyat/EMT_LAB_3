package mk.ukim.finki.lab1.repository;

import mk.ukim.finki.lab1.model.domain.Host;
import mk.ukim.finki.lab1.model.projections.HostProjection;
import mk.ukim.finki.lab1.model.projections.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HostRepository extends JpaRepository<Host, Long>{

    List<HostProjection> findAllBy();
}
