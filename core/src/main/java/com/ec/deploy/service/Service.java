package com.ec.deploy.service;

import java.util.Collection;
import java.util.UUID;

import com.ec.deploy.model.PersistentEntity;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/8/13 Time: 4:05 PM To
 * change this template use File | Settings | File Templates.
 */
public interface Service<T extends PersistentEntity>
{
    Collection<T> list();

    T add(T item);

    T update(T item);


    T remove(T item);

    T remove(UUID uuid);


    T find(UUID uuid);
}
