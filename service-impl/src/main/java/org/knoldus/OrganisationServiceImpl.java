package org.knoldus;

import java.util.concurrent.CompletableFuture;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;

public class OrganisationServiceImpl implements OrganisationService{
    @Override public ServiceCall<NotUsed, String> helloMethodName() {
        return request ->
        {
            return CompletableFuture.completedFuture("balance = 10");
        };
    }
}
