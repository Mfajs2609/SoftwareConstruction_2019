package edu.kea.math.goatsite.Repository;

import edu.kea.math.goatsite.model.Goat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Data Access Object(DAO)
@Repository
public interface GoatRepository extends CrudRepository<Goat, Long> {

    Iterable<Goat> findAllByName(String name);
    Goat findFirstByName(String name);
    Iterable<Goat> findAllByGender(Enum gender);


    @Query(value = "SELECT * FROM Goats g WHERE g.id <= 2", nativeQuery = true)
    Iterable<Goat> findTheOldTimers();
}
