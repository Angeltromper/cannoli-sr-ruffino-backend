package nl.angeltr.cannolisrruffino.repositories;

import nl.angeltr.cannolisrruffino.models.Cannoli;

import java.util.List;
import java.util.Optional;

public interface CannoliRepository {
    Optional<Cannoli> findById(Long id);

    void deleteById(Long id);

    List<Cannoli> findAllCannoliByBrandEqualsIgnoreCase(String cannoliName);

    List<Cannoli> findByCannoliTypeContainingIgnoreCase(String productType);
}
