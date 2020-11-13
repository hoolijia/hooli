package com.hooli.order.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/30 9:19 上午
 * @description：
 */
@Data
@Component
@ConfigurationProperties(prefix = "server")
public class ServerProperties {
    private Integer port;
}
