package com.infoclinika.mssharing.platform.web.uploader;

import com.google.common.base.Optional;
import com.infoclinika.mssharing.platform.fileserver.StorageService;
import com.infoclinika.mssharing.platform.fileserver.StoredObject;
import com.infoclinika.mssharing.platform.fileserver.model.NodePath;
import com.infoclinika.mssharing.platform.fileserver.model.StoredFile;
import com.infoclinika.mssharing.platform.model.ObjectNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;

import javax.inject.Inject;

/**
 * @author Pavel Kaplin
 *         <p/>
 *         TODO: Move it to Data Management Platform
 */
public abstract class AbstractStorageHelper {

    private static final Logger LOGGER = Logger.getLogger(AbstractStorageHelper.class);
    @Inject
    private StorageService fileStorageService;

    @Async
    public void feedContentToStorage(long fileItemId, long userId, StoredFile storedFile) {
        final NodePath nodePath = getData(fileItemId, userId).nodePath;
        LOGGER.debug("Posting the attachment binary contents to the project. File item ID = " + fileItemId + "; user ID = " + userId + ".");

        fileStorageService.put(nodePath, storedFile);


        LOGGER.debug("Project attachment saved successfully. File item ID = " + fileItemId + "; user ID = " + userId + ". Path = " + nodePath);
    }

    public Optional<FileContent> getContent(long itemId, long userId) {
        try {
            final FileData data = getData(itemId, userId);
            final StoredObject storedObject = fileStorageService.get(data.nodePath);
            return Optional.of(new FileContent(data.name, (StoredFile) storedObject));
        } catch (ObjectNotFoundException ex) {
            return Optional.absent();
        }

    }

    protected abstract FileData getData(long item, long userId);

    public static class FileContent {
        public final String name;
        public final StoredFile storedFile;

        public FileContent(String name, StoredFile storedFile) {
            this.name = name;
            this.storedFile = storedFile;
        }
    }

    public static class FileData {
        public final String name;
        public final NodePath nodePath;

        public FileData(String name, NodePath nodePath) {
            this.name = name;
            this.nodePath = nodePath;
        }
    }


}
