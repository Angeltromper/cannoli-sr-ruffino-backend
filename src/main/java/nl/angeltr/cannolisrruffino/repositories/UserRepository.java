package nl.angeltr.cannolisrruffino.repositories;

import nl.angeltr.cannolisrruffino.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User>findUserById(Long id);
}
