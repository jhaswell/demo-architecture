package com.ec.deploy.service.auth;

import com.ec.deploy.model.auth.User;
import com.ec.deploy.service.AbstractService;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/8/13 Time: 6:43 PM To
 * change this template use File | Settings | File Templates.
 */
public class DefaultUserService extends AbstractService<User> implements UserService
{
    @Override
    protected User cloneExceptForId(User source, User target) {
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setUsername(source.getUsername());
        target.setTenant(source.getTenant());
        return target;
    }

    @Override
    public User findByUsername(String username)
    {
        for(User user : resolveRepository()) {
            if(username.equals(username)) return user;
        }
        return null;
    }
}
