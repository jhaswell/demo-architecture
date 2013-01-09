package com.ec.deploy.model.auth;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/8/13 Time: 7:05 PM To
 * change this template use File | Settings | File Templates.
 */
public interface TenancyContextHolder
{

    Tenant getCurrentTenant();
}
