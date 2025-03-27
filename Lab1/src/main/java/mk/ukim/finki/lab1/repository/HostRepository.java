package mk.ukim.finki.lab1.repository;

import mk.ukim.finki.lab1.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long>{
}
