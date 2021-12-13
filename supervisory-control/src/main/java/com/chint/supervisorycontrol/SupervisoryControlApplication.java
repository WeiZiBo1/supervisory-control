package com.chint.supervisorycontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zhouying3
 */
@SpringBootApplication
@MapperScan(basePackages = "com.chint.supervisorycontrol.mapper.*")
public class SupervisoryControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupervisoryControlApplication.class, args);
    }

}
