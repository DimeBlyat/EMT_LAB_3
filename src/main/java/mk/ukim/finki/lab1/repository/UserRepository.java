package mk.ukim.finki.lab1.repository;

import mk.ukim.finki.lab1.model.domain.User;
import mk.ukim.finki.lab1.model.enumerations.Role;
import mk.ukim.finki.lab1.model.projections.UserProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"accommodations"}
    )
    @Query("select u from User u")
    List<User> fetchAll();

    @EntityGraph(
            type = EntityGraph.EntityGraphType.LOAD,
            attributePaths = {"accommodations"}
    )
    @Query("select u from User u")
    List<User> loadAll();

    UserProjection findByRole(Role role);

    @Query("select u.username, u.name, u.surname from User u")
    List<UserProjection> takeUsernameAndNameAndSurnameByProjection();
}