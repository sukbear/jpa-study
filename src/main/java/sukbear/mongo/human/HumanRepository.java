package sukbear.mongo.human;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sukbear
 * @create 2019-07-16 14:35
 */
@Repository
public interface HumanRepository extends MongoRepository<Human, Integer> {
    List<Human> findHumanByNameContains(String name);

    void deleteHumanByNameEqualsAndAgeEquals(String name, Integer age);

    List<Human> findHumanByNameOrderByAgeAsc(String name);
}

