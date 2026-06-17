package org.jupnp.support.avtransport.lastchange;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.lastchange.EventedValue;
import org.jupnp.support.lastchange.EventedValueEnum;
import org.jupnp.support.lastchange.EventedValueEnumArray;
import org.jupnp.support.lastchange.EventedValueString;
import org.jupnp.support.lastchange.EventedValueURI;
import org.jupnp.support.lastchange.EventedValueUnsignedIntegerFourBytes;
import org.jupnp.support.model.PlayMode;
import org.jupnp.support.model.RecordQualityMode;
import org.jupnp.support.model.StorageMedium;
import org.jupnp.support.model.TransportAction;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AVTransportVariable {
    public static Set<Class<? extends EventedValue<?>>> ALL = new HashSet<Class<? extends EventedValue<?>>>() { // from class: org.jupnp.support.avtransport.lastchange.AVTransportVariable.1
        private static final long serialVersionUID = 4641676953130701810L;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        {
            add(TransportState.class);
            add(TransportStatus.class);
            add(RecordStorageMedium.class);
            add(PossibleRecordStorageMedia.class);
            add(PossiblePlaybackStorageMedia.class);
            add(CurrentPlayMode.class);
            add(TransportPlaySpeed.class);
            add(RecordMediumWriteStatus.class);
            add(CurrentRecordQualityMode.class);
            add(PossibleRecordQualityModes.class);
            add(NumberOfTracks.class);
            add(CurrentTrack.class);
            add(CurrentTrackDuration.class);
            add(CurrentMediaDuration.class);
            add(CurrentTrackMetaData.class);
            add(CurrentTrackURI.class);
            add(AVTransportURI.class);
            add(NextAVTransportURI.class);
            add(AVTransportURIMetaData.class);
            add(NextAVTransportURIMetaData.class);
            add(CurrentTransportActions.class);
            add(RelativeTimePosition.class);
            add(AbsoluteTimePosition.class);
            add(RelativeCounterPosition.class);
            add(AbsoluteCounterPosition.class);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class AVTransportURI extends EventedValueURI {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AVTransportURI(URI uri) {
            super(uri);
        }

        public AVTransportURI(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class AVTransportURIMetaData extends EventedValueString {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AVTransportURIMetaData(String str) {
            super(str);
        }

        public AVTransportURIMetaData(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class AbsoluteCounterPosition extends EventedValueString {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AbsoluteCounterPosition(String str) {
            super(str);
        }

        public AbsoluteCounterPosition(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class AbsoluteTimePosition extends EventedValueString {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AbsoluteTimePosition(String str) {
            super(str);
        }

        public AbsoluteTimePosition(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class CurrentMediaDuration extends EventedValueString {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CurrentMediaDuration(String str) {
            super(str);
        }

        public CurrentMediaDuration(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class CurrentPlayMode extends EventedValueEnum<PlayMode> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CurrentPlayMode(PlayMode playMode) {
            super(playMode);
        }

        public CurrentPlayMode(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }

        /* JADX DEBUG: Method merged with bridge method: enumValueOf(Ljava/lang/String;)Ljava/lang/Enum; */
        @Override // org.jupnp.support.lastchange.EventedValueEnum
        public PlayMode enumValueOf(String str) {
            return PlayMode.valueOf(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class CurrentRecordQualityMode extends EventedValueEnum<RecordQualityMode> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CurrentRecordQualityMode(RecordQualityMode recordQualityMode) {
            super(recordQualityMode);
        }

        public CurrentRecordQualityMode(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }

        /* JADX DEBUG: Method merged with bridge method: enumValueOf(Ljava/lang/String;)Ljava/lang/Enum; */
        @Override // org.jupnp.support.lastchange.EventedValueEnum
        public RecordQualityMode enumValueOf(String str) {
            return RecordQualityMode.valueOf(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class CurrentTrack extends EventedValueUnsignedIntegerFourBytes {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CurrentTrack(UnsignedIntegerFourBytes unsignedIntegerFourBytes) {
            super(unsignedIntegerFourBytes);
        }

        public CurrentTrack(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class CurrentTrackDuration extends EventedValueString {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CurrentTrackDuration(String str) {
            super(str);
        }

        public CurrentTrackDuration(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class CurrentTrackMetaData extends EventedValueString {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CurrentTrackMetaData(String str) {
            super(str);
        }

        public CurrentTrackMetaData(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class CurrentTrackURI extends EventedValueURI {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CurrentTrackURI(URI uri) {
            super(uri);
        }

        public CurrentTrackURI(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class CurrentTransportActions extends EventedValueEnumArray<TransportAction> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public CurrentTransportActions(TransportAction[] transportActionArr) {
            super(transportActionArr);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: enumValueOf([Ljava/lang/String;)[Ljava/lang/Enum; */
        @Override // org.jupnp.support.lastchange.EventedValueEnumArray
        public TransportAction[] enumValueOf(String[] strArr) {
            if (strArr == null) {
                return new TransportAction[0];
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(TransportAction.valueOf(str));
            }
            return (TransportAction[]) arrayList.toArray(new TransportAction[arrayList.size()]);
        }

        public CurrentTransportActions(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class NextAVTransportURI extends EventedValueURI {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public NextAVTransportURI(URI uri) {
            super(uri);
        }

        public NextAVTransportURI(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class NextAVTransportURIMetaData extends EventedValueString {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public NextAVTransportURIMetaData(String str) {
            super(str);
        }

        public NextAVTransportURIMetaData(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class NumberOfTracks extends EventedValueUnsignedIntegerFourBytes {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public NumberOfTracks(UnsignedIntegerFourBytes unsignedIntegerFourBytes) {
            super(unsignedIntegerFourBytes);
        }

        public NumberOfTracks(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class PossiblePlaybackStorageMedia extends PossibleRecordStorageMedia {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public PossiblePlaybackStorageMedia(StorageMedium[] storageMediumArr) {
            super(storageMediumArr);
        }

        public PossiblePlaybackStorageMedia(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class PossibleRecordQualityModes extends EventedValueEnumArray<RecordQualityMode> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public PossibleRecordQualityModes(RecordQualityMode[] recordQualityModeArr) {
            super(recordQualityModeArr);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: enumValueOf([Ljava/lang/String;)[Ljava/lang/Enum; */
        @Override // org.jupnp.support.lastchange.EventedValueEnumArray
        public RecordQualityMode[] enumValueOf(String[] strArr) {
            if (strArr == null) {
                return new RecordQualityMode[0];
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(RecordQualityMode.valueOf(str));
            }
            return (RecordQualityMode[]) arrayList.toArray(new RecordQualityMode[arrayList.size()]);
        }

        public PossibleRecordQualityModes(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class PossibleRecordStorageMedia extends EventedValueEnumArray<StorageMedium> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public PossibleRecordStorageMedia(StorageMedium[] storageMediumArr) {
            super(storageMediumArr);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: enumValueOf([Ljava/lang/String;)[Ljava/lang/Enum; */
        @Override // org.jupnp.support.lastchange.EventedValueEnumArray
        public StorageMedium[] enumValueOf(String[] strArr) {
            if (strArr == null) {
                return new StorageMedium[0];
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(StorageMedium.valueOrVendorSpecificOf(str));
            }
            return (StorageMedium[]) arrayList.toArray(new StorageMedium[arrayList.size()]);
        }

        public PossibleRecordStorageMedia(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class RecordMediumWriteStatus extends EventedValueEnum<org.jupnp.support.model.RecordMediumWriteStatus> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public RecordMediumWriteStatus(org.jupnp.support.model.RecordMediumWriteStatus recordMediumWriteStatus) {
            super(recordMediumWriteStatus);
        }

        public RecordMediumWriteStatus(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }

        /* JADX DEBUG: Method merged with bridge method: enumValueOf(Ljava/lang/String;)Ljava/lang/Enum; */
        @Override // org.jupnp.support.lastchange.EventedValueEnum
        public org.jupnp.support.model.RecordMediumWriteStatus enumValueOf(String str) {
            return org.jupnp.support.model.RecordMediumWriteStatus.valueOf(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class RecordStorageMedium extends EventedValueEnum<StorageMedium> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public RecordStorageMedium(StorageMedium storageMedium) {
            super(storageMedium);
        }

        public RecordStorageMedium(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }

        /* JADX DEBUG: Method merged with bridge method: enumValueOf(Ljava/lang/String;)Ljava/lang/Enum; */
        @Override // org.jupnp.support.lastchange.EventedValueEnum
        public StorageMedium enumValueOf(String str) {
            return StorageMedium.valueOrVendorSpecificOf(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class RelativeCounterPosition extends EventedValueString {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public RelativeCounterPosition(String str) {
            super(str);
        }

        public RelativeCounterPosition(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class RelativeTimePosition extends EventedValueString {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public RelativeTimePosition(String str) {
            super(str);
        }

        public RelativeTimePosition(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class TransportState extends EventedValueEnum<org.jupnp.support.model.TransportState> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public TransportState(org.jupnp.support.model.TransportState transportState) {
            super(transportState);
        }

        public TransportState(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }

        /* JADX DEBUG: Method merged with bridge method: enumValueOf(Ljava/lang/String;)Ljava/lang/Enum; */
        @Override // org.jupnp.support.lastchange.EventedValueEnum
        public org.jupnp.support.model.TransportState enumValueOf(String str) {
            return org.jupnp.support.model.TransportState.valueOf(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class TransportStatus extends EventedValueEnum<org.jupnp.support.model.TransportStatus> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public TransportStatus(org.jupnp.support.model.TransportStatus transportStatus) {
            super(transportStatus);
        }

        public TransportStatus(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }

        /* JADX DEBUG: Method merged with bridge method: enumValueOf(Ljava/lang/String;)Ljava/lang/Enum; */
        @Override // org.jupnp.support.lastchange.EventedValueEnum
        public org.jupnp.support.model.TransportStatus enumValueOf(String str) {
            return org.jupnp.support.model.TransportStatus.valueOf(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class TransportPlaySpeed extends EventedValueString {
        static final Pattern pattern = Pattern.compile("^-?\\d+(/\\d+)?$", 2);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public TransportPlaySpeed(String str) {
            super(str);
            if (!pattern.matcher(str).matches()) {
                throw new InvalidValueException("Can't parse TransportPlaySpeed speeds.");
            }
        }

        public TransportPlaySpeed(Map.Entry<String, String>[] entryArr) {
            super(entryArr);
        }
    }
}
