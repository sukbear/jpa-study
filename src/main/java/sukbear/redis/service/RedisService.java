package sukbear.redis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import sukbear.redis.mode.User;

import javax.annotation.Resource;

/***
 *@ClassName Service
 *@Description
 * @author sukbear
 * @create 2019-07-15 13:25
 */


@Service
public class RedisService {
    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public Object getUserInfo(String s) {
        return redisTemplate.opsForValue().get(s);
    }

    public void setUserInfo(String s, User user) {
        redisTemplate.opsForValue().set(s, user);
    }

    public String setKey(String key,String value){
         stringRedisTemplate.opsForValue().set(key,value);
         return stringRedisTemplate.opsForValue().get(key);
    }
    public void addUserInfo(User user){
        redisTemplate.opsForHash().put(user.getDept(),user.getId().toString(),user);
    }

    public Object getInfo(String id){
      return   redisTemplate.opsForHash().values(id);
    }
}
