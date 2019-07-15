package sukbear.boot.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sukbear.boot.dto.UserDeptDTO;
import sukbear.boot.model.User;
import sukbear.boot.web.vo.UserVO;

import java.util.List;

/**
 * @author sukbear
 * @create 2019-07-12 15:06
 */
public interface UserService {

    void deleteUser(Long userId);

    Long addUser(UserVO userVO);

    User findUserById(Long id);

    List<UserVO> findUserInfoByName(String name);

    void Insert();

    User findUserByNameAndPhone(String name, String phone);

    Page findUserByProperties(Pageable page, String name, Integer age, String phone, Long departmentId);

    List<UserDeptDTO> findByDepatmentIdDTO(Long departmentId);

    Boolean updateUserInfo(String name, String phone);

    Boolean isExist(Long userId);
}
