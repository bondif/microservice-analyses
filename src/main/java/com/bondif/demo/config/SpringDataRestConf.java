package com.bondif.demo.config;

import com.bondif.demo.entities.Analyse;
import com.bondif.demo.entities.Client;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class SpringDataRestConf extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Client.class);
        config.exposeIdsFor(Analyse.class);
    }
}
