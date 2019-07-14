package sukbear.boot.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/***
 *@ClassName JpaFactoryBean
 *@Description
 * @author sukbear
 * @create 2019-07-12 17:12
 */
@Configuration
public class JpaFactoryBean {
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager manager) {
        return new JPAQueryFactory(manager);
    }
}
