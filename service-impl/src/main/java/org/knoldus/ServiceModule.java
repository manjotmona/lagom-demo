package org.knoldus;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import play.Configuration;
import play.Environment;
import org.knoldus.OrganisationService;

/**
 * Created by pallavi on 15/5/18.
 */
public class ServiceModule extends AbstractModule implements ServiceGuiceSupport {
    private final Environment environment;
    private final Configuration configuration;  //NOSONAR as this is required field.

    public ServiceModule(Environment environment, Configuration configuration) {
        this.environment = environment;
        this.configuration = configuration;
    }

    @Override
    protected void configure() {
        bindService(OrganisationService.class , OrganisationServiceImpl.class);

    }
}
