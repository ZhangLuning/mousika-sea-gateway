package com.mousika.sea.gateway.web.webservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RefreshScope
@Slf4j
public class GatewayWebservice {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/webservice/serverList")
    public Mono<List> register() {
        List<String> services = discoveryClient.getServices();
        return Mono.just(services);
    }
}
