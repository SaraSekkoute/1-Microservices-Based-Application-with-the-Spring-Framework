package org.example.customerservice.config;

import org.example.customerservice.entities.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
       // quand il va serialiser le customer au format json je t'autorise de d'exposer id
        config.exposeIdsFor(Customer.class);
    }
}
