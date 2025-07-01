package com.github.gogolivan.springplatform.notification;

import com.github.gogolivan.springplatform.notification.controller.NotificationController;
import com.github.gogolivan.springplatform.springplatformspringbootstarter.autoconfigure.GraphQlConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.ContextConfiguration;

@GraphQlTest(NotificationController.class)
@ContextConfiguration(classes = {GraphQlConfiguration.class})
class NotificationControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void notification() {
    }
}