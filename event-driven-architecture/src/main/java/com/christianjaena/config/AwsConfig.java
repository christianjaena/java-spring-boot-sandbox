package com.christianjaena.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.net.URI;

@Configuration
@EnableConfigurationProperties({ AwsProperties.class })
public class AwsConfig {

    @Bean
    public SnsClient snsClient(AwsProperties properties) {
        return SnsClient.builder()
                .endpointOverride(URI.create(properties.getSns().getEndpoint()))
                .region(Region.of(properties.getSns().getRegion()))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("test", "test")
                ))
                .build();
    }

    @Bean
    public SqsClient sqsClient(AwsProperties properties) {
        return SqsClient.builder()
                .endpointOverride(URI.create(properties.getSqs().getEndpoint()))
                .region(Region.of(properties.getSqs().getRegion()))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("test", "test")
                ))
                .build();
    }
}
