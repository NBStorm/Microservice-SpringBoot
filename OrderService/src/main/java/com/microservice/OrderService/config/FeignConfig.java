package com.microservice.OrderService.config;

import com.microservice.OrderService.external.decoder.CustomErrorDecoder;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import io.micrometer.tracing.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    public RequestInterceptor feignTracingInterceptor(Tracer tracer) {
        return template -> {
            // Propagate tracing headers
            if (tracer.currentSpan() != null) {
                template.header("X-B3-TraceId", tracer.currentSpan().context().traceId());
                template.header("X-B3-SpanId", tracer.currentSpan().context().spanId());
                template.header("X-B3-Sampled", "1");
            }
        };
    }
}
