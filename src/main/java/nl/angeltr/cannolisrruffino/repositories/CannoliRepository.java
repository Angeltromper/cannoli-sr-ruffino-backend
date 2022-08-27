package nl.angeltr.cannolisrruffino.repositories;

import nl.angeltr.cannolisrruffino.models.Cannoli;

import java.util.List;

public interface CannoliRepository extends JpaRepository<Cannoli, Long> {

    List<Cannoli> findAllCannoliByBrandEqualsIgnoreCase(String brand);
}
