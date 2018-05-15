package org.knoldus;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;
import com.lightbend.lagom.javadsl.api.transport.Method;

import static com.lightbend.lagom.javadsl.api.Service.restCall;
import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.topic;


public interface OrganisationService extends Service {

    //Topic name
    String GREETINGS_TOPIC = "greeting";


    ServiceCall<NotUsed,String> helloMethodName();

    ServiceCall<NotUsed, String> subscribe(String id);
    ServiceCall<GreetingMessage,String> publish(String id);

    default Descriptor descriptor() {
        return named("service").withCalls(
                restCall(Method.GET,"/balance",this::helloMethodName),
                pathCall("/api/hello/:id", this::subscribe),
                pathCall("/api/hello/:id", this::publish)
        ).withTopics(
                topic(GREETINGS_TOPIC, this::greetingsTopic)

        ).withAutoAcl(true);
    }
    Topic<GreetingMessage> greetingsTopic();


}
