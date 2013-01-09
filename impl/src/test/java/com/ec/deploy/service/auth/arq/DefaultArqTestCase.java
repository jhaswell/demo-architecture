package com.ec.deploy.service.auth.arq;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import com.ec.deploy.model.PersistentEntity;
import com.ec.deploy.model.auth.User;
import com.ec.deploy.model.destination.ScpDestination;
import com.ec.deploy.model.userdata.FileReference;
import com.ec.deploy.service.Service;
import com.ec.deploy.service.auth.UserService;
import com.ec.deploy.service.destination.ScpDestinationService;
import com.ec.deploy.service.userdata.FileReferenceService;

/**
 * Created with IntelliJ IDEA. User: jhaswell Date: 1/9/13 Time: 1:09 PM To
 * change this template use File | Settings | File Templates.
 */
public class DefaultArqTestCase
{

    public static Archive<?> createDefaultTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "impl.jar")
                         .addPackage(User.class.getPackage())
                         .addPackage(ScpDestination.class.getPackage())
                         .addPackage(FileReference.class.getPackage())
                         .addPackage(PersistentEntity.class.getPackage())
                         .addPackage(Service.class.getPackage())
                         .addPackage(FileReferenceService.class.getPackage())
                         .addPackage(ScpDestinationService.class.getPackage())
                         .addPackage(UserService.class.getPackage())
                         .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
}
