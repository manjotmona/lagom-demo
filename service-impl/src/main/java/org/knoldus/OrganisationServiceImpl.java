package org.knoldus;

import java.util.concurrent.CompletableFuture;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;

public class OrganisationServiceImpl implements OrganisationService{
    @Override public ServiceCall<NotUsed, String> helloMethodName() {
        return request ->
        {
            return CompletableFuture.completedFuture("balance = 10");
        };
    }

    @Override public ServiceCall<NotUsed, String> subscribe(String id) {
        return null;
    }

    @Override public ServiceCall<GreetingMessage, String> publish(String id) {
        return null;
    }

    @Override public Topic<GreetingMessage> greetingsTopic() {
        return null;
    }
}
