package com.mousika.sea.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 网关授权的核心过滤器
 * order的规则： order的值越小，优先级越高 order如果不标注数字，默认最低优先级，因为其默认值是int最大值
 */
@Order(-100)
@Slf4j
@Component
public class GatewayAuthFilter implements WebFilter {

    private static final AntPathMatcher MATCHER = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return this.doAuth(exchange, chain);
    }

    private Mono<Void> doAuth(ServerWebExchange exchange, WebFilterChain chain) {
        String path = exchange.getRequest().getPath().value();
        log.info("Gateway过滤到的Path路径：" + path);
        return chain.filter(exchange);
    }
}
