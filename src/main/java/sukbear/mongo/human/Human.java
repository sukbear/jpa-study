package sukbear.mongo.human;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/***
 *@ClassName Human
 *@Description
 * @author sukbear
 * @create 2019-07-16 14:31
 */
@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Human {
    private String name;
    private Integer age;
}
