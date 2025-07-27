package com.christianjaena.service.implementation;

import com.christianjaena.service.INotificationService;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class DefaultNotificationService implements INotificationService {

    private final SnsClient snsClient;

    public DefaultNotificationService(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    @Override
    public void send(String topicArn, String message) {
        snsClient.publish(PublishRequest.builder()
                .topicArn(topicArn)
                .message(message)
                .build());
    }
}
