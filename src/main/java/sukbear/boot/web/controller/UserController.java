package sukbear.boot.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sukbear.boot.dao.UserRepository;
import sukbear.boot.dto.UserDeptDTO;
import sukbear.boot.model.User;
import sukbear.boot.web.service.UserService;
import sukbear.boot.web.validator.UserValidator;
import sukbear.boot.web.vo.UserVO;

import javax.validation.constraints.NotNull;
import java.util.List;

/***
 *@ClassName UserController
 *@Description
 * @author sukbear
 * @create 2019-07-12 15:16
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户CRUD")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserValidator userValidator;
    @DeleteMapping("/{user_id}")
    @ApiOperation(value = "根据用户id删除用户", httpMethod = "DELETE")
    public ResponseEntity deleteUser(@PathVariable("user_id") @NotNull Long userId) {
       if(!userService.isExist(userId)){
           return ResponseEntity.ok("null");
       }
        userService.deleteUser(userId);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/add")
    @ApiOperation(value = "创建用户", httpMethod = "POST")
    public ResponseEntity addUser(@RequestBody UserVO vo) {
        Long id = userService.addUser(vo);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id查找用户", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "Long")
    public ResponseEntity findUser(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("name/{name}")
    public ResponseEntity findUserInfoByName(@PathVariable("name") String name) {
        List<UserVO> vo = userService.findUserInfoByName(name);
        return ResponseEntity.ok(vo);
    }


    @GetMapping("/dept/{dept_id}")
    @ApiOperation(value = "查询部门", httpMethod = "GET")
    public ResponseEntity getUserInfo(@PathVariable("dept_id") Long id) {
        List<UserDeptDTO> dto = userService.findByDepatmentIdDTO(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/user/{name}/{phone}")
    @ApiOperation(value = "根据姓名和电话查找用户", httpMethod = "GET")
    public ResponseEntity findUserByNameAndPhone(@PathVariable("name") String name, @PathVariable String phone) {
        return ResponseEntity.ok(userService.findUserByNameAndPhone(name, phone));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新用户电话", httpMethod = "POST")
    public ResponseEntity updateUserPhone(@RequestParam String name, @RequestParam String phone) {
        return ResponseEntity.ok(userService.updateUserInfo(name, phone));
    }
}
