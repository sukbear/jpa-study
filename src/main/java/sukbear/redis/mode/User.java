package sukbear.redis.mode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/***
 *@ClassName User
 *@Description
 * @author sukbear
 * @create 2019-07-15 11:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable{
    private Integer id;
    private static final long SERIALVERSIONID = 1L;
    private String name;
    private Integer age;
    private String dept;
}
