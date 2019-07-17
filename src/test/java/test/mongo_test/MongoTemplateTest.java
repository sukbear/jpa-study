package test.mongo_test;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import sukbear.BootStart;

/***
 *@ClassName MongoTemplateTest
 *@Description
 * @author sukbear
 * @create 2019-07-17 10:45
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStart.class)
public class MongoTemplateTest {
    @Autowired
    MongoTemplate mongoTemplate;
}
