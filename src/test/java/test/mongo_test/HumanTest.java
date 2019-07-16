package test.mongo_test;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sukbear.BootStart;
import sukbear.mongo.human.Human;
import sukbear.mongo.human.HumanRepository;

import java.util.ArrayList;
import java.util.List;

/***
 *@ClassName HumanTest
 *@Description
 * @author sukbear
 * @create 2019-07-16 14:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStart.class)
@Slf4j
public class HumanTest {
    @Autowired
    HumanRepository humanRepository;

    /**
     * 批量插入mongo
     *
     * @return
     * @throws
     * @params
     */

    public void insert() {
        Human human = new Human("张三", 20);
        Human human1 = new Human("张三", 23);
        Human human2 = new Human("张三", 18);
        Human human3 = new Human("张三", 90);
        Human human4 = new Human("张三", 100);
        List<Human> lists = new ArrayList<>();
        lists.add(human);
        lists.add(human1);
        lists.add(human2);
        lists.add(human3);
        lists.add(human4);
        lists.add(human);
        lists.add(human);
        humanRepository.insert(lists);
    }

    public void deleteByNameAndAge() {
        humanRepository.deleteHumanByNameEqualsAndAgeEquals("张三", 20);
    }
}
