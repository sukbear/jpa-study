package test.mongo_test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import sukbear.BootStart;
import sukbear.mongo.user.User;

import java.util.Arrays;

/***
 *@ClassName UserTest
 *@Description
 * @author sukbear
 * @create 2019-07-16 15:52
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStart.class)
public class UserTest {
    @Autowired
    private sukbear.mongo.user.UserDaoRepository userDaoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public void insert() {
        String[] str = new String[]{"code", "rap", "singAndDance"};
        User user = User.builder().id(5).name("张三").favorites(Arrays.asList(str)).build();
        log.info("插入的数据: {}", userDaoRepository.save(user));
    }

    @Test
    public void select() {

        log.info("res-> {}");
    }
}
