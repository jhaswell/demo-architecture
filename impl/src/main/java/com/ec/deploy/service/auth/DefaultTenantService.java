package com.ec.deploy.service.auth;

import java.util.NoSuchElementException;

import javax.ejb.Stateless;

import com.ec.deploy.model.auth.Tenant;
import com.ec.deploy.service.AbstractService;

@Stateless
public class DefaultTenantService
    extends  AbstractService<Tenant>
    implements TenantService
{
    @Override
    protected Tenant cloneExceptForId(
        Tenant source,
        Tenant target)
    {
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }

    @Override
    public Tenant findByName(String name)
    {
        if(name == null) {
            throw new IllegalArgumentException("Name must not be null!");
        }
        for(Tenant tenant : resolveRepository()) {
            if(name.equals(tenant.getName())) return tenant;
        }
        throw new NoSuchElementException(
            String.format("Could not find tenant named '%s'", name)
        );
    }
}
