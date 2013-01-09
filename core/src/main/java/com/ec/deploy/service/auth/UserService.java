package com.ec.deploy.service.auth;

import java.util.Collection;
import java.util.UUID;

import com.ec.deploy.model.auth.User;
import com.ec.deploy.service.Service;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/8/13 Time: 4:08 PM To
 * change this template use File | Settings | File Templates.
 */
public interface UserService extends Service<User>
{
    User findByUsername(String username);
}
