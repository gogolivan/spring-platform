package com.github.gogolivan.springplatform.springplatformspringbootstarter.autoconfigure;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.autoconfigure.spi.AutoConfigurationCustomizerProvider;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import io.opentelemetry.sdk.trace.samplers.SamplingDecision;
import io.opentelemetry.sdk.trace.samplers.SamplingResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@AutoConfiguration
@Slf4j
public class OtelAutoConfiguration {
    @Bean
    public AutoConfigurationCustomizerProvider otelCustomizer() {
        log.info("Creating otelCustomizer");
        return p ->
                p.addSamplerCustomizer(
                        (fallback, config) ->
                                new ActuatorRoutingSampler());
    }
}


class ActuatorRoutingSampler implements Sampler {

    @Override
    public SamplingResult shouldSample(Context parentContext, String traceId, String name, SpanKind spanKind, Attributes attributes, List<LinkData> parentLinks) {
        if (name != null && name.startsWith("/actuator")) {
            return SamplingResult.create(SamplingDecision.DROP);
        }

        return SamplingResult.create(SamplingDecision.RECORD_AND_SAMPLE);
    }

    @Override
    public String getDescription() {
        return "IgnoreActuatorRoutingSampler: Ignores spans with endpoints starting with '/actuator'.";
    }
}
