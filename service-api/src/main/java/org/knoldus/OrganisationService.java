package org.knoldus;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import static com.lightbend.lagom.javadsl.api.Service.restCall;
import static com.lightbend.lagom.javadsl.api.Service.named;


public interface OrganisationService extends Service {
    ServiceCall<NotUsed,String> helloMethodName();

    default Descriptor descriptor() {
        return named("service").withCalls(
                restCall(Method.GET,"/balance",this::helloMethodName)).withAutoAcl(true);
    }
}
