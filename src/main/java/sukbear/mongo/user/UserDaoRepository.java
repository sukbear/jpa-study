package sukbear.mongo.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sukbear
 * @create 2019-07-16 15:51
 */
@Repository
public interface UserDaoRepository extends MongoRepository<User, Integer> {

}
