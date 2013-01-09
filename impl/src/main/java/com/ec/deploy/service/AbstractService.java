package com.ec.deploy.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ec.deploy.model.PersistentEntity;
import com.ec.deploy.model.auth.TenancyContextHolder;
import com.ec.deploy.model.auth.Tenant;
import com.ec.deploy.service.auth.ThreadLocalTenancyContextHolder;

public abstract class AbstractService<T extends PersistentEntity> implements Service<T>
{

    private Map<UUID, List<T>> repository;
    private final TenancyContextHolder tenancyContextHolder;

    protected AbstractService() {
        repository = new HashMap<UUID, List<T>>();
        tenancyContextHolder = ThreadLocalTenancyContextHolder.getInstance();
    }
    @Override
    public Collection<T> list()
    {
        return resolveRepository();
    }

    protected final List<T> resolveRepository()
    {
        final Tenant currentTenant =
            tenancyContextHolder.getCurrentTenant();
        List<T> users = repository.get(currentTenant.getId());
        if(users == null) {
            repository.put(currentTenant.getId(), users = new ArrayList<T>());
        }
        return users;
    }

    @Override
    public T add(T item)
    {
        item.setId(UUID.randomUUID());
        resolveRepository().add(item);
        return item;
    }

    @Override
    public T update(T item)
    {
        final T user;
        if(item.getId() == null || (user = find(item.getId())) == null) {
            return add(item);
        }
        return cloneExceptForId(item, user);
    }

   protected abstract T cloneExceptForId(T source, T target);

    @Override
    public T remove(T item)
    {
        if(item.getId() != null)  {
            return remove(item.getId());
        }
        return item;
    }

    @Override
    public T remove(UUID uuid)
    {
        if(uuid != null) {
            for(final Iterator<T> iter = resolveRepository().iterator(); iter.hasNext();) {
                final T next = iter.next();
                if(uuid.equals(next.getId())) {
                    iter.remove();
                    return next;
                }
            }
        }
        return null;
    }

    @Override
    public T find(UUID uuid)
    {
        for(T user : resolveRepository()) {
            if(uuid.equals(user.getId())) return user;
        }
        return null;
    }
}
