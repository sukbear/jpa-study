package sukbear.boot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * created by liufa 2019/06/27
 */
@Data
@Entity
@Table(name = "t_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 部门Id
     */
    private Long deptId;
    private String deptName;
    private Date createDate;
}
