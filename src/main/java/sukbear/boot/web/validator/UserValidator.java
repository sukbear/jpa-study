package sukbear.boot.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import sukbear.boot.web.service.UserService;

/***
 *@ClassName UserValidator
 *@Description
 * @author sukbear
 * @create 2019-07-15 9:56
 */
@Component
public class UserValidator {
@Autowired
    UserService userService;

    public void deleteValidator(Long userId, BindingResult errors){
        if(errors.hasErrors()){
            return;
        }
        if(!userService.isExist(userId)){
            errors.rejectValue("userId","用户Id不存在");
        }
    }
}
