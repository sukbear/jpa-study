package sukbear.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author sukbear
 * @create 2019-07-12 16:15
 */
@NoRepositoryBean
public interface BasicRepository<T,ID> extends JpaRepository<T,ID>,QuerydslPredicateExecutor<T> {
}
