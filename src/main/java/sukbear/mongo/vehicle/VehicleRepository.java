package sukbear.mongo.vehicle;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sukbear
 * @create 2019-07-16 11:35
 */
@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    List<Vehicle> findVehicleByBrand(String brand);

    void deleteByBrand(String brand);

    List<Vehicle> findVehicleByBrandLike(String brand);

}
