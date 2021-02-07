package com.him.woll.singleservershiro;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * main process
 *
 * @author xiaoniaodepangci
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.him.woll.*.mapper"})
public class SingleServerShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingleServerShiroApplication.class, args);
    }

}
