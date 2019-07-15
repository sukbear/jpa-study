package test.redis_test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import sukbear.BootStart;
import sukbear.boot.model.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 *@ClassName RedisTest
 *@Description
 * @author sukbear
 * @create 2019-07-15 16:34
 */
@Slf4j
@SpringBootTest(classes = BootStart.class)
@RunWith(SpringRunner.class)
public class RedisTest {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private String LISTKEY = "listkey";
    private String SETKEY = "setkey";
    private String ZSETKEY = "zsetkey";

    private List<User> userList() {
        List<User> list = new ArrayList<>();
        User user = User.builder().userName("张三").userAge(12).build();
        User user1 = User.builder().userName("李四").userAge(22).build();
        User user2 = User.builder().userName("王五").userAge(30).build();
        list.add(user);
        list.add(user1);
        list.add(user2);
        return list;
    }

    @Test
    public void ListSetAndGet() {

        userList().parallelStream().forEach(value -> redisTemplate.opsForList().leftPush(LISTKEY, value));
        log.info("取出列表元素->{}", redisTemplate.opsForList().range(LISTKEY,0,-1l));
    }

    @Test
    public void opsForSet() {
        userList().forEach(v -> redisTemplate.opsForSet().add(SETKEY, v));
        log.info("取出元素->{}", redisTemplate.opsForSet().members(SETKEY));
    }

    @Test
    public void opsForZset(){
        userList().forEach(v->redisTemplate.opsForZSet().add(ZSETKEY,v,v.getUserAge()));
    }

    @Test
    public void getForZset(){
       log.info("output:{}",redisTemplate.opsForZSet().rangeWithScores(ZSETKEY,0,-1));
    }
}
