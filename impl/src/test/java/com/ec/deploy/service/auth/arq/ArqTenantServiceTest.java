package com.ec.deploy.service.auth.arq;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;

import com.ec.deploy.model.PersistentEntity;
import com.ec.deploy.model.auth.User;
import com.ec.deploy.model.destination.ScpDestination;
import com.ec.deploy.model.userdata.FileReference;
import com.ec.deploy.service.Service;
import com.ec.deploy.service.auth.DefaultTenantServiceTest;
import com.ec.deploy.service.auth.TenantService;
import com.ec.deploy.service.auth.UserService;
import com.ec.deploy.service.destination.ScpDestinationService;
import com.ec.deploy.service.userdata.FileReferenceService;

import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class ArqTenantServiceTest extends DefaultTenantServiceTest
{

    @Deployment
    public static Archive<?> createDeployment() {
        return DefaultArqTestCase.createDefaultTestArchive();
    }
    @Inject
    public TenantService tenantService;


    @Test
    public void ensureNotNull() {
        assertNotNull(tenantService);
    }

}
