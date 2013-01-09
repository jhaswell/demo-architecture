package com.ec.deploy.model.auth;

import com.ec.deploy.model.PersistentEntity;

public class Tenant extends PersistentEntity
{
    private String name;
    private String description;


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
