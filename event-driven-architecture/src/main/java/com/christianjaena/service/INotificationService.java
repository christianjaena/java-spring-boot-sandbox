package com.christianjaena.service;

public interface INotificationService {
    void send(String topicArn, String message);
}
