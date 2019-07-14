package sukbear.boot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/***
 *@ClassName User
 *@Description
 * @author sukbear
 * @create 2019-07-12 14:18
 */
@Data
@Builder
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", columnDefinition = "varchar(10) not null comment '用户名'")
    private String userName;

    @Column(name = "user_age", columnDefinition = "tinyint(1) not null comment '年龄'")
    private Integer userAge;

    @Column(name = "user_phone", columnDefinition = "varchar(11) not null comment '手机号'")
    private String userPhone;

    @Column(name = "create_time", columnDefinition = "datetime")
    @CreatedDate
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "datetime")
    @LastModifiedDate
    private Date updateTime;

    private Long departmentId;

}
