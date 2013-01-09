package com.ec.deploy.model.auth;

import com.ec.deploy.model.PersistentEntity;

public class User extends PersistentEntity
{
    private Tenant tenant;
    private String firstName;
    private String lastName;
    private String username;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }


    public Tenant getTenant()
    {
        return tenant;
    }

    public void setTenant(Tenant tenant)
    {
        this.tenant = tenant;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }



}
