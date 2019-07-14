package sukbear.boot.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/***
 *@ClassName UserVO
 *@Description
 * @author sukbear
 * @create 2019-07-12 15:51
 */
@ApiModel(description = "用户",value = "用户vo")
@Data
public class UserVO {
    @ApiModelProperty(value = "用户名", required = true,example = "张三")
    @NotNull
    private String userName;
    @ApiModelProperty(value = "用户年龄",required = true,example = "20")
    @NotNull
    private Integer userAge;
    @ApiModelProperty(value = "用户电话",required = true,example = "123456")
    @NotNull
    private String userPhone;

}
