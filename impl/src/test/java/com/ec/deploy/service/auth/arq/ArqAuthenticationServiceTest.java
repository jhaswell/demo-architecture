package com.ec.deploy.service.auth.arq;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.runner.RunWith;

import com.ec.deploy.service.auth.AuthenticationService;
import com.ec.deploy.service.auth.DefaultAuthenticationServiceTest;
import com.ec.deploy.service.auth.TenantService;

@RunWith(Arquillian.class)
public class ArqAuthenticationServiceTest extends DefaultAuthenticationServiceTest
{


    @Deployment
    public static Archive<?> createDeployment() {
        return DefaultArqTestCase.createDefaultTestArchive();
    }

    @Inject
    private AuthenticationService authenticationService;


    @Override
    protected void configureServices() {

    }

    @Override
    protected AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}
