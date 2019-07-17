package sukbear.mongo.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sukbear
 * @create 2019-07-16 15:51
 */
@Repository
public interface UserDaoRepository extends MongoRepository<User, Integer> {
    /**
     * 根据字段里是否包含某些值（可以是一个或多个）
     * @params
     * @return
     * @throws
    */
    List<User> findByFavoritesIn(List<String> str);}