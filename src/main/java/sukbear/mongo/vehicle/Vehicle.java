package sukbear.mongo.vehicle;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/***
 *@ClassName Vehicle
 *@Description
 * @author sukbear
 * @create 2019-07-16 11:31
 */
@Document(collection = "vehicle_collection")
@Data
public class Vehicle {
    /**
     * 车辆唯一ID
     * 这个字段在写入数据库后会变为"_id"
     */
    @Id
    private String vehicleId;
    /**
     * 车辆品牌
     */
    private String brand;
    /**
     * 车辆型号
     */
    private String model;
    /**
     * 车辆等级
     */
    private String level;
    /**
     * 车辆价格
     */
    private Integer prices;
    /**
     * 车辆类型
     */
    private String type;
    /**
     * 车辆综合马力
     */
    private Integer horsepower;
}
