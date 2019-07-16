package test.mongo_test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sukbear.BootStart;
import sukbear.mongo.vehicle.Vehicle;
import sukbear.mongo.vehicle.VehicleRepository;

import javax.annotation.Resource;

/***
 *@ClassName VehicleTest
 *@Description
 * @author sukbear
 * @create 2019-07-16 11:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStart.class)
@Slf4j
public class VehicleTest {
    @Resource
    private VehicleRepository vehicleRepository;

    public void saveVehicleTest() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId("3");
        vehicle.setBrand("benz");
        vehicle.setHorsepower(15);
        vehicle.setLevel("2");
        vehicleRepository.save(vehicle);
    }

    public void delete() {
        vehicleRepository.deleteByBrand("benz");
    }

    @Test
    public void select() {
        log.info("输出{}", vehicleRepository.findVehicleByBrandLike("be"));
    }

    public void update() {

    }
}
