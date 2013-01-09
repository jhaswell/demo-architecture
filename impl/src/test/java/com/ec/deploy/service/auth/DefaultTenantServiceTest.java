package com.ec.deploy.service.auth;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;

import com.ec.deploy.model.auth.Tenant;
import com.ec.deploy.service.Service;
import com.ec.deploy.service.ServiceTestCase;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/8/13 Time: 7:55 PM To
 * change this template use File | Settings | File Templates.
 */
public class DefaultTenantServiceTest extends ServiceTestCase<Tenant>
{

    Random random = new Random();

    @Override
    public void setCurrentTenant(Tenant tenant) {
        super.setCurrentTenant(tenant);
        ((ThreadLocalTenancyContextHolder)
            ThreadLocalTenancyContextHolder.getInstance())
            .setCurrentTenant(tenant);
    }
    @Test(expected = NoSuchElementException.class)
    public void ensureCantFindUnknownName() {
        ((TenantService)service).findByName(UUID.randomUUID().toString());
    }
    @Override
    protected Tenant createValidEntity()
    {
        final Tenant tenant = new Tenant();
        tenant.setName("name" + random.nextInt());
        tenant.setDescription("description" + random.nextInt());
        return tenant;
    }

    @Override
    protected Service<Tenant> createService()
    {
        return new DefaultTenantService();
    }
}
