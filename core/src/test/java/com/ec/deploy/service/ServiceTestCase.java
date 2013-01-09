package com.ec.deploy.service;

import org.junit.Before;
import org.junit.Test;

import com.ec.deploy.model.PersistentEntity;
import com.ec.deploy.model.auth.Tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class ServiceTestCase<T extends PersistentEntity> extends TenantAwareTestCase
{

    protected Service<T> service;



    @Before
    public void setUp() {
        super.setUp();
        service = createService();
    }

    @Test
    public void ensureEmptyServiceHasNoItems() {
        assertTrue(service.list().isEmpty());
    }

    @Test
    public void ensureValidCreateResultsInFindReturningItem() {
        final T item = createValidEntity();
        final T added = service.add(item);
        assertEquals(item, service.find(added.getId()));
    }

    @Test
    public void ensureCreateValidEntityResultsInListCountIncrement() {
        final T item = createValidEntity();
        service.add(item);
        assertEquals(1, service.list().size());
    }

    @Test
    public void ensureItemCreatedByOneTenantCannotBeAccessedByAnotherTenant() {

        final Tenant coke = new Tenant();
        coke.setName("coke");
        coke.setDescription("Coca-cola");


        final T item = createValidEntity();
        service.add(item);
        setCurrentTenant(coke);

        assertEquals(0, service.list().size());
    }

    @Test
    public void ensureRemovingItemResultsInItemRemoved() {
        final T saved = service.add(createValidEntity());
        service.remove(saved);
        assertEquals(0, service.list().size());
    }


    protected abstract T createValidEntity();


    protected abstract Service<T> createService();




}
