package com.ec.deploy.service.auth;

import java.util.Collection;
import java.util.UUID;

import com.ec.deploy.model.auth.Tenant;
import com.ec.deploy.service.Service;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/8/13 Time: 4:07 PM To
 * change this template use File | Settings | File Templates.
 */
public interface TenantService extends Service<Tenant>
{

    Tenant findByName(String name);
}
