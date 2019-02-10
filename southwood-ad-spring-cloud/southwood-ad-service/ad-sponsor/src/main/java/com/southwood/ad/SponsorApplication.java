package com.southwood.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by nanzhao on 2019/2/10 11:32 AM
 */
@EnableFeignClients      //增加这个注解，就可以在该服务中调用别的微服务
@EnableCircuitBreaker
@EnableEurekaClient      //从注册中心拿到别的微服务的client信息
@SpringBootApplication
public class SponsorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SponsorApplication.class, args);

    }
}
