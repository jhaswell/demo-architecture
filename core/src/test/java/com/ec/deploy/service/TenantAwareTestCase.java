package com.ec.deploy.service;

import java.util.UUID;

import com.ec.deploy.model.auth.Tenant;

public class TenantAwareTestCase
{
    private Tenant currentTenant;

    public void setUp() {
        final Tenant pepsi = new Tenant();
        pepsi.setName("pepsi");
        pepsi.setDescription("Pepsico");
        pepsi.setId(UUID.randomUUID());
        setCurrentTenant(pepsi);
    }

    protected Tenant getCurrentTenant() {
        return currentTenant;
    }

    public void setCurrentTenant(Tenant tenant)
    {
        this.currentTenant = tenant;
    }
}
