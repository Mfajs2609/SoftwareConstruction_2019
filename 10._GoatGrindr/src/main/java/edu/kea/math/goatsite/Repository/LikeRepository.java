package edu.kea.math.goatsite.Repository;


import edu.kea.math.goatsite.model.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {


}
