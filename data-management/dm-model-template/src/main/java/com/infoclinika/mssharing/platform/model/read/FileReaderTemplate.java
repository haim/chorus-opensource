package com.infoclinika.mssharing.platform.model.read;

import com.infoclinika.mssharing.platform.model.PagedItem;
import com.infoclinika.mssharing.platform.model.PagedItemInfo;
import com.infoclinika.mssharing.platform.model.common.items.FileItem;

import java.util.Date;
import java.util.Set;
import java.util.SortedSet;

/**
 * @author Herman Zamula
 */
public interface FileReaderTemplate<FILE_LINE extends FileReaderTemplate.FileLineTemplate> {

    Set<FILE_LINE> readFiles(long actor, Filter genericFilter);

    Set<FILE_LINE> readUnfinishedFiles(long user);

    Set<FILE_LINE> readFilesByInstrument(long actor, long instrument);

    Set<FILE_LINE> readByNameForInstrument(long actor, long instrument, String fileName);

    Set<FILE_LINE> readFilesByLab(long actor, long lab);

    Set<FILE_LINE> readFilesByExperiment(long actor, long experiment);

    SortedSet<FileItem> readFileItemsByExperiment(long actor, long experiment);

    PagedItem<FILE_LINE> readFiles(long actor, Filter genericFilter, PagedItemInfo pagedItemInfo);

    PagedItem<FILE_LINE> readFilesByLab(long actor, long lab, PagedItemInfo pagedInfo);

    PagedItem<FILE_LINE> readFilesByInstrument(long actor, long instrument, PagedItemInfo pagedInfo);

    PagedItem<FILE_LINE> readFilesByExperiment(long actor, long experiment, PagedItemInfo pagedInfo);

    class FileLineTemplate {

        public final long id;
        public final String name;
        public final String contentId;
        public final String uploadId;
        public final String destinationPath;
        public final long instrumentId;
        public final String instrumentName;
        public final long modelId;
        public final String instrumentModel;
        public final String labName;
        public final long labId;
        public final long labHead;
        public final Long specieId;
        public final long owner;
        public final boolean invalid;
        public final String vendorName;
        public final AccessLevel accessLevel;
        public final boolean usedInExperiments;
        public final String labels;
        public final long sizeInBytes;
        public final Date uploadDate;

        public FileLineTemplate(long id, String name, String contentId, String uploadId, String destinationPath, long instrumentId, long labId, String instrumentName, long modelId, String labName, long owner, long labHead, boolean invalid, String vendorName, String instrumentModel, Long specieId, AccessLevel accessLevel, boolean usedInExperiments, String labels, long sizeInBytes, Date uploadDate) {
            this.id = id;
            this.name = name;
            this.contentId = contentId;
            this.uploadId = uploadId;
            this.destinationPath = destinationPath;
            this.instrumentId = instrumentId;
            this.labId = labId;
            this.instrumentName = instrumentName;
            this.modelId = modelId;
            this.labName = labName;
            this.owner = owner;
            this.labHead = labHead;
            this.invalid = invalid;
            this.vendorName = vendorName;
            this.instrumentModel = instrumentModel;
            this.specieId = specieId;
            this.accessLevel = accessLevel;
            this.usedInExperiments = usedInExperiments;
            this.labels = labels;
            this.sizeInBytes = sizeInBytes;
            this.uploadDate = uploadDate;
        }

        public FileLineTemplate(FileLineTemplate other) {
            this.id = other.id;
            this.name = other.name;
            this.contentId = other.contentId;
            this.uploadId = other.uploadId;
            this.destinationPath = other.destinationPath;
            this.instrumentId = other.instrumentId;
            this.instrumentName = other.instrumentName;
            this.modelId = other.modelId;
            this.instrumentModel = other.instrumentModel;
            this.labId = other.labId;
            this.labHead = other.labHead;
            this.specieId = other.specieId;
            this.owner = other.owner;
            this.invalid = other.invalid;
            this.vendorName = other.vendorName;
            this.accessLevel = other.accessLevel;
            this.usedInExperiments = other.usedInExperiments;
            this.sizeInBytes = other.sizeInBytes;
            this.labName = other.labName;
            this.labels = other.labels;
            this.uploadDate = other.uploadDate;
        }

        @Override
        @SuppressWarnings("all")
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof FileLineTemplate)) return false;

            FileLineTemplate that = (FileLineTemplate) o;

            if (id != that.id) return false;
            if (instrumentId != that.instrumentId) return false;
            if (invalid != that.invalid) return false;
            if (labHead != that.labHead) return false;
            if (labId != that.labId) return false;
            if (modelId != that.modelId) return false;
            if (owner != that.owner) return false;
            if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
            if (destinationPath != null ? !destinationPath.equals(that.destinationPath) : that.destinationPath != null)
                return false;
            if (instrumentModel != null ? !instrumentModel.equals(that.instrumentModel) : that.instrumentModel != null)
                return false;
            if (instrumentName != null ? !instrumentName.equals(that.instrumentName) : that.instrumentName != null)
                return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;
            if (specieId != null ? !specieId.equals(that.specieId) : that.specieId != null) return false;
            if (uploadId != null ? !uploadId.equals(that.uploadId) : that.uploadId != null) return false;
            if (vendorName != null ? !vendorName.equals(that.vendorName) : that.vendorName != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = (int) (id ^ (id >>> 32));
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (contentId != null ? contentId.hashCode() : 0);
            result = 31 * result + (uploadId != null ? uploadId.hashCode() : 0);
            result = 31 * result + (destinationPath != null ? destinationPath.hashCode() : 0);
            result = 31 * result + (int) (instrumentId ^ (instrumentId >>> 32));
            result = 31 * result + (instrumentName != null ? instrumentName.hashCode() : 0);
            result = 31 * result + (int) (modelId ^ (modelId >>> 32));
            result = 31 * result + (instrumentModel != null ? instrumentModel.hashCode() : 0);
            result = 31 * result + (int) (labId ^ (labId >>> 32));
            result = 31 * result + (int) (labHead ^ (labHead >>> 32));
            result = 31 * result + (specieId != null ? specieId.hashCode() : 0);
            result = 31 * result + (int) (owner ^ (owner >>> 32));
            result = 31 * result + (invalid ? 1 : 0);
            result = 31 * result + (vendorName != null ? vendorName.hashCode() : 0);
            return result;
        }
    }

}
