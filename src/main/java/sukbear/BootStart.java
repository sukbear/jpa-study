package sukbear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 *@ClassName BootStart
 *@Description
 * @author sukbear
 * @create 2019-07-12 14:12
 */
@EnableSwagger2
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class BootStart {
        public static void main(String[] args) {
            SpringApplication.run(BootStart.class, args);
        }
}
