package com.ec.deploy.service.userdata;

import java.util.UUID;

import com.ec.deploy.model.destination.ScpDestination;
import com.ec.deploy.model.userdata.FileReference;
import com.ec.deploy.service.Service;

public interface FileReferenceService extends Service<FileReference>
{
    void copy(
        ScpDestination destination,
        FileReference reference,
        String destinationPath);

    void copy(
        UUID destinationId,
        UUID referenceId,
        String destinationPath);
}
