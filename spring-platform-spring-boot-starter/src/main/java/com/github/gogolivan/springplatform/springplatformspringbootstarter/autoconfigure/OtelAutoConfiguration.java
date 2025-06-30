package com.github.gogolivan.springplatform.springplatformspringbootstarter.autoconfigure;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.autoconfigure.spi.AutoConfigurationCustomizerProvider;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import io.opentelemetry.sdk.trace.samplers.SamplingDecision;
import io.opentelemetry.sdk.trace.samplers.SamplingResult;
import io.opentelemetry.semconv.UrlAttributes;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@AutoConfiguration
@Slf4j
@ConditionalOnClass(OpenTelemetry.class)
public class OtelAutoConfiguration {
    @Bean
    public AutoConfigurationCustomizerProvider otelCustomizer() {
        log.info("Configuring OpenTelemetry");
        return p ->
                p.addSamplerCustomizer(
                        (fallback, config) ->
                                new ActuatorRoutingSampler());
    }
}

class ActuatorRoutingSampler implements Sampler {
    @Override
    public SamplingResult shouldSample(Context parentContext, String traceId, String name, SpanKind spanKind, Attributes attributes, List<LinkData> parentLinks) {
        String pattern = "^/actuator";
        String url = Objects.requireNonNullElse(attributes.get(UrlAttributes.URL_PATH), StringUtils.EMPTY);

        if (SpanKind.SERVER.equals(spanKind) && Pattern.matches(pattern, url)) {
            return SamplingResult.create(SamplingDecision.DROP);
        }

        return SamplingResult.create(SamplingDecision.RECORD_AND_SAMPLE);
    }

    @Override
    public String getDescription() {
        return "IgnoreActuatorRoutingSampler: Ignores spans with endpoints starting with '/actuator'.";
    }
}
