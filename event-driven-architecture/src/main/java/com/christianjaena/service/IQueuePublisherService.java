package com.christianjaena.service;

public interface IQueuePublisherService {
    void publish(String queueUrl, String message);
}
