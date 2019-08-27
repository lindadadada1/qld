package com.qld.springboot.bobo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: bobo
 * @description:
 * @author: 秦令达
 * @create: 2019-06-28 15:50
 */
@Component
@ConfigurationProperties(prefix = "bsfit")
public class Deliver {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
