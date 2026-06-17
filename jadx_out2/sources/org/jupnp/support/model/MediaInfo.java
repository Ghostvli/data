package org.jupnp.support.model;

import java.util.Map;
import org.jupnp.model.action.ActionArgumentValue;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MediaInfo {
    private String currentURI;
    private String currentURIMetaData;
    private String mediaDuration;
    private String nextURI;
    private String nextURIMetaData;
    private UnsignedIntegerFourBytes numberOfTracks;
    private StorageMedium playMedium;
    private StorageMedium recordMedium;
    private RecordMediumWriteStatus writeStatus;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MediaInfo(Map<String, ActionArgumentValue<?>> map) {
        this((String) map.get("CurrentURI").getValue(), (String) map.get("CurrentURIMetaData").getValue(), (String) map.get("NextURI").getValue(), (String) map.get("NextURIMetaData").getValue(), (UnsignedIntegerFourBytes) map.get("NrTracks").getValue(), (String) map.get("MediaDuration").getValue(), StorageMedium.valueOrVendorSpecificOf((String) map.get("PlayMedium").getValue()), StorageMedium.valueOrVendorSpecificOf((String) map.get("RecordMedium").getValue()), RecordMediumWriteStatus.valueOrUnknownOf((String) map.get("WriteStatus").getValue()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getCurrentURI() {
        return this.currentURI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getCurrentURIMetaData() {
        return this.currentURIMetaData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getMediaDuration() {
        return this.mediaDuration;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getNextURI() {
        return this.nextURI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getNextURIMetaData() {
        return this.nextURIMetaData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UnsignedIntegerFourBytes getNumberOfTracks() {
        return this.numberOfTracks;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StorageMedium getPlayMedium() {
        return this.playMedium;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public StorageMedium getRecordMedium() {
        return this.recordMedium;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RecordMediumWriteStatus getWriteStatus() {
        return this.writeStatus;
    }

    public MediaInfo() {
        this.currentURI = "";
        this.currentURIMetaData = "";
        this.nextURI = "NOT_IMPLEMENTED";
        this.nextURIMetaData = "NOT_IMPLEMENTED";
        this.numberOfTracks = new UnsignedIntegerFourBytes(0L);
        this.mediaDuration = "00:00:00";
        this.playMedium = StorageMedium.NONE;
        this.recordMedium = StorageMedium.NOT_IMPLEMENTED;
        this.writeStatus = RecordMediumWriteStatus.NOT_IMPLEMENTED;
    }

    public MediaInfo(String str, String str2) {
        this.currentURI = "";
        this.currentURIMetaData = "";
        this.nextURI = "NOT_IMPLEMENTED";
        this.nextURIMetaData = "NOT_IMPLEMENTED";
        this.numberOfTracks = new UnsignedIntegerFourBytes(0L);
        this.mediaDuration = "00:00:00";
        this.playMedium = StorageMedium.NONE;
        this.recordMedium = StorageMedium.NOT_IMPLEMENTED;
        this.writeStatus = RecordMediumWriteStatus.NOT_IMPLEMENTED;
        this.currentURI = str;
        this.currentURIMetaData = str2;
    }

    public MediaInfo(String str, String str2, UnsignedIntegerFourBytes unsignedIntegerFourBytes, String str3, StorageMedium storageMedium) {
        this.currentURI = "";
        this.currentURIMetaData = "";
        this.nextURI = "NOT_IMPLEMENTED";
        this.nextURIMetaData = "NOT_IMPLEMENTED";
        this.numberOfTracks = new UnsignedIntegerFourBytes(0L);
        this.mediaDuration = "00:00:00";
        this.playMedium = StorageMedium.NONE;
        this.recordMedium = StorageMedium.NOT_IMPLEMENTED;
        this.writeStatus = RecordMediumWriteStatus.NOT_IMPLEMENTED;
        this.currentURI = str;
        this.currentURIMetaData = str2;
        this.numberOfTracks = unsignedIntegerFourBytes;
        this.mediaDuration = str3;
        this.playMedium = storageMedium;
    }

    public MediaInfo(String str, String str2, UnsignedIntegerFourBytes unsignedIntegerFourBytes, String str3, StorageMedium storageMedium, StorageMedium storageMedium2, RecordMediumWriteStatus recordMediumWriteStatus) {
        this.currentURI = "";
        this.currentURIMetaData = "";
        this.nextURI = "NOT_IMPLEMENTED";
        this.nextURIMetaData = "NOT_IMPLEMENTED";
        this.numberOfTracks = new UnsignedIntegerFourBytes(0L);
        this.mediaDuration = "00:00:00";
        this.playMedium = StorageMedium.NONE;
        this.recordMedium = StorageMedium.NOT_IMPLEMENTED;
        RecordMediumWriteStatus recordMediumWriteStatus2 = RecordMediumWriteStatus.WRITABLE;
        this.currentURI = str;
        this.currentURIMetaData = str2;
        this.numberOfTracks = unsignedIntegerFourBytes;
        this.mediaDuration = str3;
        this.playMedium = storageMedium;
        this.recordMedium = storageMedium2;
        this.writeStatus = recordMediumWriteStatus;
    }

    public MediaInfo(String str, String str2, String str3, String str4, UnsignedIntegerFourBytes unsignedIntegerFourBytes, String str5, StorageMedium storageMedium) {
        this.currentURI = "";
        this.currentURIMetaData = "";
        this.nextURI = "NOT_IMPLEMENTED";
        this.nextURIMetaData = "NOT_IMPLEMENTED";
        this.numberOfTracks = new UnsignedIntegerFourBytes(0L);
        this.mediaDuration = "00:00:00";
        this.playMedium = StorageMedium.NONE;
        this.recordMedium = StorageMedium.NOT_IMPLEMENTED;
        this.writeStatus = RecordMediumWriteStatus.NOT_IMPLEMENTED;
        this.currentURI = str;
        this.currentURIMetaData = str2;
        this.nextURI = str3;
        this.nextURIMetaData = str4;
        this.numberOfTracks = unsignedIntegerFourBytes;
        this.mediaDuration = str5;
        this.playMedium = storageMedium;
    }

    public MediaInfo(String str, String str2, String str3, String str4, UnsignedIntegerFourBytes unsignedIntegerFourBytes, String str5, StorageMedium storageMedium, StorageMedium storageMedium2, RecordMediumWriteStatus recordMediumWriteStatus) {
        this.currentURI = "";
        this.currentURIMetaData = "";
        this.nextURI = "NOT_IMPLEMENTED";
        this.nextURIMetaData = "NOT_IMPLEMENTED";
        this.numberOfTracks = new UnsignedIntegerFourBytes(0L);
        this.mediaDuration = "00:00:00";
        this.playMedium = StorageMedium.NONE;
        this.recordMedium = StorageMedium.NOT_IMPLEMENTED;
        RecordMediumWriteStatus recordMediumWriteStatus2 = RecordMediumWriteStatus.WRITABLE;
        this.currentURI = str;
        this.currentURIMetaData = str2;
        this.nextURI = str3;
        this.nextURIMetaData = str4;
        this.numberOfTracks = unsignedIntegerFourBytes;
        this.mediaDuration = str5;
        this.playMedium = storageMedium;
        this.recordMedium = storageMedium2;
        this.writeStatus = recordMediumWriteStatus;
    }
}
