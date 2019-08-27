package spring.springboot;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import spring.springboot.config.DataSourceConfig;

/**
 * @program: bobo
 * @description:
 * @author: 秦令达
 * @create: 2019-07-09 21:07
 */
@SpringBootApplication
//@PropertySource(value={"file:application.yml"})
//@EnableAutoConfiguration
//@ComponentScan(basePackages={"spring.*", "com.*", "net.*"}, includeFilters={@org.springframework.context.annotation.ComponentScan.Filter(value={spring.springboot.config.DataSourceConfig.class}, type=org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE)})
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        SpringApplication builder = new SpringApplicationBuilder().sources(Application.class).build();
        builder.run(args);
    }
}
