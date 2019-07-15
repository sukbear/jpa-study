package sukbear.redis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sukbear.redis.mode.User;
import sukbear.redis.service.RedisService;

import javax.annotation.Resource;

/***
 *@ClassName RedisController
 *@Description
 * @author sukbear
 * @create 2019-07-15 13:32
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
  private   RedisService redisService;
    @GetMapping("/{key}")
    public ResponseEntity getUserInfo(@PathVariable("key") String s){
        return  ResponseEntity.ok(redisService.getUserInfo(s));
    }
    @PostMapping
    public ResponseEntity setUserInfo(String key,@RequestBody User user){
        redisService.setUserInfo(key,user);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/key")
    public ResponseEntity setKey(String k,String v){
        return ResponseEntity.ok(redisService.setKey(k,v));
    }

    @PostMapping("/hash")
    public ResponseEntity putUserInfo(User user){
        redisService.addUserInfo(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/hash/{id}")
    public ResponseEntity getInfo(@PathVariable("id")String id){
        return ResponseEntity.ok(redisService.getInfo(id));
    }
}
