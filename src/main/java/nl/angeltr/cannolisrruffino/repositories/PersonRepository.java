package nl.angeltr.cannolisrruffino.repositories;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByPersonFirstnameContainingIgnoreCase(String personFirstname);

    List<Person> findByPersonLastnameContainingIgnoreCase(String personLastname);
}
