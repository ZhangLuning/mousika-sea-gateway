package com.mousika.sea.gateway;

import com.mousika.sea.gateway.utils.AppLogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDiscoveryClient
@SpringBootApplication
public class MousikaSeaGatewayApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MousikaSeaGatewayApplication.class, args);
        AppLogUtil.logApplicationStartup(context.getEnvironment());
    }

}
