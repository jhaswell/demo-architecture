package com.ec.deploy.service.auth;

import java.util.NoSuchElementException;

import com.ec.deploy.model.auth.Tenant;

public class DefaultAuthenticationServiceTest extends AuthenticationServiceTest
{
    final UserService userService = new DefaultUserService();
    final TenantService tenantService = new DefaultTenantService();
    @Override
    protected UserService createUserService()
    {
        return userService;
    }

    @Override
    protected AuthenticationService createAuthenticationService()
    {
        DefaultAuthenticationService result =
            new DefaultAuthenticationService();
        result.userService = userService;
        result.tenantService = tenantService;
        return result;
    }

    @Override
    public void setCurrentTenant(Tenant tenant) {
        super.setCurrentTenant(tenant);
        ((ThreadLocalTenancyContextHolder)
            ThreadLocalTenancyContextHolder.getInstance())
            .setCurrentTenant(tenant);
        try {
            tenantService.findByName(tenant.getName());
        } catch(NoSuchElementException ex) {
            tenantService.add(tenant);
        }
    }
}
