package sukbear.boot.web.service;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sukbear.boot.dao.UserRepository;
import sukbear.boot.dto.UserDeptDTO;
import sukbear.boot.model.QDepartment;
import sukbear.boot.model.QUser;
import sukbear.boot.model.User;
import sukbear.boot.web.vo.UserVO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *@ClassName UserServiceImp
 *@Description
 * @author sukbear
 * @create 2019-07-12 15:07
 */
@Service
@Transactional(rollbackOn = Exception.class)
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Override
    public Long addUser(UserVO userVO) {
        return Optional.of(userVO).map(userVO2PO).map(userRepository::saveAndFlush).get().getId();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).ifPresent(u -> userRepository.delete(u));
    }

    private Function<UserVO, User> userVO2PO = vo -> {
        User po = User.builder().build();
        BeanUtils.copyProperties(vo, po);
        return po;
    };

    private Function<User, UserVO> userPO2VO = po -> {
        UserVO vo = new UserVO();
        vo.setUserName(po.getUserName());
        vo.setUserAge(po.getUserAge());
        vo.setUserPhone(po.getUserPhone());
        return vo;
    };

    @Override
    public List<UserVO> findUserInfoByName(String name) {
        QUser qUser = QUser.user;
        List<User> user = jpaQueryFactory.selectFrom(qUser).where(qUser.userName.eq(name)).fetch();
        return user.stream().map(userPO2VO).collect(Collectors.toList());
    }

    @Override
    public void Insert() {
        User user = User.builder().userName("李四").userAge(12).userPhone("12321312").build();
        User user1 = User.builder().userName("李四").userAge(12).userPhone("12321312").build();
        User user2 = User.builder().userName("李四").userAge(12).userPhone("12321312").build();
        User user3 = User.builder().userName("李四").userAge(12).userPhone("12321312").build();
        User user4 = User.builder().userName("李四").userAge(12).userPhone("12321312").build();
        Stream.of(user, user1, user2, user3).forEach(userRepository::saveAndFlush);
    }

    @Override
    public User findUserByNameAndPhone(String name, String phone) {
        QUser qUser = QUser.user;
        return jpaQueryFactory.selectFrom(qUser).where(
                qUser.userName.eq(name),
                qUser.userPhone.eq(phone)
        ).fetchOne();
    }

    @Override
    public Page findUserByProperties(Pageable pageable, String name, Integer age, String phone, Long departmentId) {
        QUser qUser = QUser.user;
        Predicate predicate = qUser.isNotNull().or(qUser.isNull());
        predicate = name == null ? predicate : ExpressionUtils.and(predicate, qUser.userName.eq(name));
        predicate = age == null ? predicate : ExpressionUtils.and(predicate, qUser.userAge.eq(age));
        predicate = phone == null ? predicate : ExpressionUtils.and(predicate, qUser.userPhone.eq(phone));
        predicate = departmentId == null ? predicate : ExpressionUtils.and(predicate, qUser.departmentId.eq(departmentId));
        Page<User> page = userRepository.findAll(predicate, pageable);
        return page;
    }


    @Override
    public List<UserDeptDTO> findByDepatmentIdDTO(Long departmentId) {
        log.info("{}查询",departmentId.toString());
        QUser qUser = QUser.user;
        QDepartment qDepartment = QDepartment.department;
        return jpaQueryFactory.select(
                qUser.userName,
                qUser.userAge,
                qUser.userPhone,
                qDepartment.deptId,
                qDepartment.deptName
        ).from(qDepartment, qUser)
                .where(qUser.departmentId.eq(qDepartment.deptId).and(qDepartment.deptId.eq(departmentId)))
                .fetch()
                .stream()
                .map(e ->
                        UserDeptDTO.builder().userName(e.get(qUser.userName))
                                .userPhone(e.get(qUser.userPhone))
                                .deptName(e.get(qDepartment.deptName))
                                .deptId(e.get(qDepartment.deptId))
                                .build()
                ).collect(Collectors.toList());
    }

    @Override
    public Boolean updateUserInfo(String name,String phone) {
        QUser qUser = QUser.user;
        jpaQueryFactory.update(qUser)
                .set(qUser.userPhone, phone)
                .where(qUser.userName.eq(name))
                .execute();
        return true;

    }

    @Override
    public Boolean isExist(Long userId) {
        return userRepository.existsById(userId);
    }
}
