package com.github.gogolivan.springplatform.springplatformspringbootstarter.autoconfigure;

import graphql.scalars.ExtendedScalars;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.graphql.GraphQlAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@AutoConfiguration
@ConditionalOnClass(value = {GraphQlAutoConfiguration.class, ExtendedScalars.class})
@Slf4j
public class GraphQlConfiguration {
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        log.trace("Configuring GraphQL scalars");
        return wiringBuilder -> wiringBuilder
                .scalar(ExtendedScalars.DateTime);
    }
}
