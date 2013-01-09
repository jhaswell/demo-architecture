package com.ec.deploy.service.auth;

import org.junit.Before;
import org.junit.Test;

import com.ec.deploy.model.auth.Tenant;
import com.ec.deploy.model.auth.User;
import com.ec.deploy.service.TenantAwareTestCase;

import static org.junit.Assert.assertEquals;

public abstract class AuthenticationServiceTest
    extends TenantAwareTestCase
{
    private UserService userService;
    private TenantService tenantService;
    private AuthenticationService authenticationService;

    @Before
    public void setUp()
    {
        super.setUp();
        configureServices();
    }

    protected void configureServices()
    {
        userService = createUserService();
        getAuthenticationService() = createAuthenticationService();
    }

    @Test(expected = AuthenticationService.AuthenticationException.class)
    public void ensureAttemptingToAuthenticateAgainstEmptyServiceFails()
    {
        getAuthenticationService().authenticate("tenantName", "username");
    }

    @Test(expected = AuthenticationService.AuthenticationException.class)
    public void ensureAttemptingToAuthenticateAgainstWrongTenantFails()
    {
        final User newUser = new User();
        newUser.setFirstName("Josiah");
        newUser.setLastName("Haswell");
        newUser.setUsername("jhaswell");
        userService.add(newUser);
        final Tenant coke = new Tenant();
        coke.setName("coke");
        coke.setDescription("Coca-Cola");
        setCurrentTenant(coke);
        getAuthenticationService().authenticate("coke", "jhaswell");
    }

    @Test
    public void ensureAttemptingToAuthenticateValidUserAgainstCorrectTenantSucceeds()
    {
        final User newUser = new User();
        newUser.setFirstName("Josiah");
        newUser.setLastName("Haswell");
        newUser.setUsername("jhaswell");
        userService.add(newUser);
        assertEquals("Josiah", authenticationService.authenticate(
            getCurrentTenant().getName(), "jhaswell").getFirstName());
    }

    protected AuthenticationService getAuthenticationService() {
        return authenticationService;
    }


    protected abstract UserService createUserService();

    protected abstract AuthenticationService createAuthenticationService();
}
