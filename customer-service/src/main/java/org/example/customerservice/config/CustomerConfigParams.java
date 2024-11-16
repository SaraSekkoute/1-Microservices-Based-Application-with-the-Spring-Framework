package org.example.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "customer.params")
public record CustomerConfigParams(int x, int y) {
    /*injecter en x==>customer.params.x
    injecter en y==>customer.params.y*/
}
