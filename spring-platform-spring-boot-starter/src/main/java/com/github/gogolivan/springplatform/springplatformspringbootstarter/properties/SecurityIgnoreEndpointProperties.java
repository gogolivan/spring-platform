package com.github.gogolivan.springplatform.springplatformspringbootstarter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "security.ignore")
public record SecurityIgnoreEndpointProperties(List<String> patterns) {
    public SecurityIgnoreEndpointProperties {
        patterns = (patterns == null) ? List.of() : List.copyOf(patterns);
    }
}
