package com.ec.deploy.service.auth;

import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.ec.deploy.model.auth.Tenant;
import com.ec.deploy.model.auth.User;
import com.ec.deploy.service.Service;
import com.ec.deploy.service.ServiceTestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/8/13 Time: 6:44 PM To
 * change this template use File | Settings | File Templates.
 */
public class DefaultUserServiceTest extends ServiceTestCase<User>
{


    private Random random = new Random();

    @Before
    public void setUp() {
        super.setUp();
    }

    @Override
    public void setCurrentTenant(Tenant tenant) {
        super.setCurrentTenant(tenant);
        ((ThreadLocalTenancyContextHolder)
            ThreadLocalTenancyContextHolder.getInstance())
            .setCurrentTenant(tenant);
    }
    @Test
    public void ensureTenantIsNotEmpty() {
        assertNotNull(ThreadLocalTenancyContextHolder.getInstance().getCurrentTenant());

    }
    @Override
    protected User createValidEntity()
    {
        final User user = new User();
        user.setFirstName("firstName" + random.nextInt());
        user.setLastName("lastName" + random.nextInt());
        user.setUsername("user" + random.nextInt());
        return user;
    }

    @Test
    public void ensureNonExistentUsernameDoesntResolve() {
        assertNull(((UserService)service).findByUsername(UUID.randomUUID().toString()));
    }

    @Test
    public void ensureExistantusernameOnTenantResolves() {
        final User user = new User();
        String userName = "jhaswell";
        user.setFirstName("Josiah");
        user.setLastName("Haswell");
        user.setUsername(userName);
        service.add(user);
        assertEquals("Josiah", ((UserService) service).findByUsername(userName).getFirstName());
    }

    @Override
    protected Service<User> createService()
    {
        return new DefaultUserService();
    }
}
