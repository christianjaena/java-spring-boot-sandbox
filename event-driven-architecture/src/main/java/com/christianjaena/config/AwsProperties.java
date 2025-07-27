package com.christianjaena.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "aws")
public class AwsProperties {

    private SnsProperties sns;
    private SqsProperties sqs;

    @Data
    public static class SnsProperties {
        private String region;
        private String endpoint;
    }

    @Data
    public static class SqsProperties {
        private String region;
        private String endpoint;
    }
}
