package sukbear.boot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import sukbear.boot.model.User;
import sukbear.util.BasicRepository;

/**
 * @author sukbear
 * @created 2019-07-12 14:21
 */
@Repository
public interface UserRepository extends BasicRepository<User,Long> {

    User findUserByUserPhone(String userPhone);

    @Override
    Page<User> findAll(Pageable pageable);
}
