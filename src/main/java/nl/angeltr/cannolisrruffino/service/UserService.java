package nl.angeltr.cannolisrruffino.service;

import nl.angeltr.cannolisrruffino.models.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Collection<User> getUser();

    Optional<User> getUser(String username);

    String createUser(User user);

    void deleteUser(String username);

    boolean userExists(String username);

    void assignPersonToUser(Long id, String username);

    void assignImageToUser(String fileName, String username);
}
