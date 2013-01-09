package com.ec.deploy.service.auth;

import com.ec.deploy.model.auth.TenancyContextHolder;
import com.ec.deploy.model.auth.Tenant;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/8/13 Time: 7:06 PM To
 * change this template use File | Settings | File Templates.
 */
public class ThreadLocalTenancyContextHolder implements TenancyContextHolder
{

    private static final InheritableThreadLocal<Tenant>
        threadContext = new InheritableThreadLocal<Tenant>();

    private static final TenancyContextHolder INSTANCE =
        new ThreadLocalTenancyContextHolder();

    public static TenancyContextHolder getInstance() {
        return INSTANCE;
    }

    private ThreadLocalTenancyContextHolder() {  }


    public void setCurrentTenant(Tenant tenant) {
        threadContext.set(tenant);
    }
    @Override
    public Tenant getCurrentTenant()
    {
        return threadContext.get();
    }


}
