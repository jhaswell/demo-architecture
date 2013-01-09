package com.ec.deploy.model.destination;

import com.ec.deploy.model.PersistentEntity;
import com.ec.deploy.model.auth.Tenant;

public class ScpDestination extends PersistentEntity
{
    private int port;
    private Tenant tenant;
    private String hostname;
    private String username;
    private String password;

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String getHostname()
    {
        return hostname;
    }

    public void setHostname(String hostname)
    {
        this.hostname = hostname;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


}
