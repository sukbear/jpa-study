package sukbear.boot.dto;

import lombok.Builder;
import lombok.Data;

/***
 *@ClassName UserDeptDTO
 *@Description
 * @author sukbear
 * @create 2019-07-12 18:41
 */
@Data
@Builder
public class UserDeptDTO {
    /**用户基础信息*/
    private String userName;
    private String userPhone;
    /**用户的部门信息*/
    private String deptName;
    private Long deptId;
}
