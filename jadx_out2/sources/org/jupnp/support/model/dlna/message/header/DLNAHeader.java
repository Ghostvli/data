package org.jupnp.support.model.dlna.message.header;

import defpackage.j02;
import defpackage.n02;
import java.util.HashMap;
import java.util.Map;
import org.jupnp.model.message.header.InvalidHeaderException;
import org.jupnp.model.message.header.UpnpHeader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DLNAHeader<T> extends UpnpHeader<T> {
    private static final j02 LOGGER = n02.k(DLNAHeader.class);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Type {
        TimeSeekRange("TimeSeekRange.dlna.org", TimeSeekRangeHeader.class),
        XSeekRange("X-Seek-Range", TimeSeekRangeHeader.class),
        PlaySpeed("PlaySpeed.dlna.org", PlaySpeedHeader.class),
        AvailableSeekRange("availableSeekRange.dlna.org", AvailableSeekRangeHeader.class),
        GetAvailableSeekRange("getAvailableSeekRange.dlna.org", GetAvailableSeekRangeHeader.class),
        GetContentFeatures("getcontentFeatures.dlna.org", GetContentFeaturesHeader.class),
        ContentFeatures("contentFeatures.dlna.org", ContentFeaturesHeader.class),
        TransferMode("transferMode.dlna.org", TransferModeHeader.class),
        FriendlyName("friendlyName.dlna.org", FriendlyNameHeader.class),
        PeerManager("peerManager.dlna.org", PeerManagerHeader.class),
        AvailableRange("Available-Range.dlna.org", AvailableRangeHeader.class),
        SCID("scid.dlna.org", SCIDHeader.class),
        RealTimeInfo("realTimeInfo.dlna.org", RealTimeInfoHeader.class),
        ScmsFlag("scmsFlag.dlna.org", ScmsFlagHeader.class),
        WCT("WCT.dlna.org", WCTHeader.class),
        MaxPrate("Max-Prate.dlna.org", MaxPrateHeader.class),
        EventType("Event-Type.dlna.org", EventTypeHeader.class),
        Supported("Supported", SupportedHeader.class),
        BufferInfo("Buffer-Info.dlna.org", BufferInfoHeader.class),
        RTPH264DeInterleaving("rtp-h264-deint-buf-cap.dlna.org", BufferBytesHeader.class),
        RTPAACDeInterleaving("rtp-aac-deint-buf-cap.dlna.org", BufferBytesHeader.class),
        RTPAMRDeInterleaving("rtp-amr-deint-buf-cap.dlna.org", BufferBytesHeader.class),
        RTPAMRWBPlusDeInterleaving("rtp-amrwbplus-deint-buf-cap.dlna.org", BufferBytesHeader.class),
        PRAGMA("PRAGMA", PragmaHeader.class);

        private static final Map<String, Type> byName = new HashMap<String, Type>() { // from class: org.jupnp.support.model.dlna.message.header.DLNAHeader.Type.1
            private static final long serialVersionUID = 2786641076120338594L;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            {
                for (Type type : Type.values()) {
                    put(type.getHttpName(), type);
                }
            }
        };
        private final Class<? extends DLNAHeader<?>>[] headerTypes;
        private final String httpName;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @SafeVarargs
        Type(String str, Class... clsArr) {
            this.httpName = str;
            this.headerTypes = clsArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Type getByHttpName(String str) {
            if (str == null) {
                return null;
            }
            return byName.get(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Class<? extends DLNAHeader<?>>[] getHeaderTypes() {
            return this.headerTypes;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getHttpName() {
            return this.httpName;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean isValidHeaderType(Class<? extends DLNAHeader<?>> cls) {
            for (Class<? extends DLNAHeader<?>> cls2 : getHeaderTypes()) {
                if (cls2.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static DLNAHeader<?> newInstance(Type type, String str) {
        DLNAHeader<?> dLNAHeaderNewInstance;
        Exception e;
        DLNAHeader<?> dLNAHeader = null;
        for (int i = 0; i < type.getHeaderTypes().length && dLNAHeader == null; i++) {
            Class<? extends DLNAHeader<?>> cls = type.getHeaderTypes()[i];
            try {
                try {
                    LOGGER.i("Trying to parse '{}' with class: {}", type, cls.getSimpleName());
                    dLNAHeaderNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    if (str != null) {
                        try {
                            dLNAHeaderNewInstance.setString(str);
                        } catch (Exception e2) {
                            e = e2;
                            LOGGER.p("Error instantiating header of type '{}' with value: {}", type, str, e);
                        }
                    }
                } catch (Exception e3) {
                    dLNAHeaderNewInstance = dLNAHeader;
                    e = e3;
                }
                dLNAHeader = dLNAHeaderNewInstance;
            } catch (InvalidHeaderException e4) {
                LOGGER.i("Invalid header value for tested type: {} - {}", cls.getSimpleName(), e4.getMessage());
                dLNAHeader = null;
            }
        }
        return dLNAHeader;
    }
}
