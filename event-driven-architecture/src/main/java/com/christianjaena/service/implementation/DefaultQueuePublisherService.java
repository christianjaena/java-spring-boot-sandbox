package com.christianjaena.service.implementation;

import com.christianjaena.service.IQueuePublisherService;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class DefaultQueuePublisherService implements IQueuePublisherService {

    private final SqsClient sqsClient;

    public DefaultQueuePublisherService(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    @Override
    public void publish(String queueUrl, String message) {
        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .build());
    }
}
