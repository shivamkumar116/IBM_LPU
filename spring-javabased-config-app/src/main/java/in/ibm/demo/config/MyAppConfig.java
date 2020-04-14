package in.ibm.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JDBCConfig.class})
@ComponentScan(basePackages ="in.ibm.demo")
public class MyAppConfig {

}
