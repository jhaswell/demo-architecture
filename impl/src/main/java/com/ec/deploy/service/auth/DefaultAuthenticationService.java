package com.ec.deploy.service.auth;

import java.util.NoSuchElementException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ec.deploy.model.auth.Tenant;
import com.ec.deploy.model.auth.User;

@Stateless
public class DefaultAuthenticationService implements AuthenticationService
{
    @Inject
    UserService userService;
    @Inject
    TenantService tenantService;


    @Override
    public User authenticate(
        String tenantName,
        String username)
        throws AuthenticationException
    {
        final Tenant tenant = resolveTenant(tenantName, username);
        setCurrentTenant(tenant);
        return resolveUserOnTenant(tenantName, username);
    }

    private User resolveUserOnTenant(
        String tenantName,
        String username)
    {
        final User user = userService.findByUsername(username);
        if(user == null) {
            throw new AuthenticationException(
                String.format(
                    "Could not find user named " +
                        "'%s' on tenant '%s'", username, tenantName),
                tenantName, username
            );
        }
        return user;
    }

    private void setCurrentTenant(Tenant tenant)
    {
        ((ThreadLocalTenancyContextHolder)
            ThreadLocalTenancyContextHolder.getInstance()).setCurrentTenant(tenant);
    }

    private Tenant resolveTenant(
        String tenantName,
        String username)
    {
        Tenant tenant;
        try {
            tenant = tenantService.findByName(tenantName);
        } catch(NoSuchElementException ex) {
            throw new AuthenticationException(
                String.format("Could not find tenant named '%s'", tenantName),
                tenantName, username
            );
        }
        return tenant;
    }
}
