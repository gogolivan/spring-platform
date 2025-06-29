package com.github.gogolivan.springplatform.springplatformspringbootstarter.autoconfigure;

import com.github.gogolivan.springplatform.springplatformspringbootstarter.properties.SecurityIgnoreEndpointProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

@AutoConfiguration
@EnableWebSecurity
@EnableConfigurationProperties({OAuth2ResourceServerProperties.class, SecurityIgnoreEndpointProperties.class})
@Slf4j
@ConditionalOnProperty(prefix = "spring.security.oauth2.resourceserver.jwt", name = "issuer-uri")
public class SecurityConfig {
    private final OAuth2ResourceServerProperties resourceServerProperties;
    private final SecurityIgnoreEndpointProperties securityIgnoreEndpointProperties;

    @Autowired
    public SecurityConfig(OAuth2ResourceServerProperties resourceServerProperties,
                          SecurityIgnoreEndpointProperties securityIgnoreEndpointProperties) {
        this.resourceServerProperties = resourceServerProperties;
        this.securityIgnoreEndpointProperties = securityIgnoreEndpointProperties;

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("Configuring OAuth2 security filter chain");
        http.authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated())
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(securityIgnoreEndpointProperties.patterns().toArray(new String[0]));
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation(resourceServerProperties.getJwt().getIssuerUri());
    }
}
