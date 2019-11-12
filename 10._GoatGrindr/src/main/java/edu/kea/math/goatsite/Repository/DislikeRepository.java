package edu.kea.math.goatsite.Repository;

import edu.kea.math.goatsite.model.Dislike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DislikeRepository extends CrudRepository<Dislike, Long> {

}
