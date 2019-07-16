package sukbear.mongo.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

/***
 *@ClassName User
 *@Description
 * @author sukbear
 * @create 2019-07-16 15:46
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private Integer id;
    private String name;
    private List<String> favorites;
}
