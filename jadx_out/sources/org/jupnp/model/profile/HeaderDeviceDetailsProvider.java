package org.jupnp.model.profile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.jupnp.model.meta.DeviceDetails;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class HeaderDeviceDetailsProvider implements DeviceDetailsProvider {
    private final DeviceDetails defaultDeviceDetails;
    private final Map<Key, DeviceDetails> headerDetails;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Key {
        final String headerName;
        final Pattern pattern;
        final String valuePattern;

        public Key(String str, String str2) {
            this.headerName = str;
            this.valuePattern = str2;
            this.pattern = Pattern.compile(str2, 2);
        }

        public String getHeaderName() {
            return this.headerName;
        }

        public String getValuePattern() {
            return this.valuePattern;
        }

        public boolean isValuePatternMatch(String str) {
            return this.pattern.matcher(str).matches();
        }
    }

    public HeaderDeviceDetailsProvider(DeviceDetails deviceDetails, Map<Key, DeviceDetails> map) {
        this.defaultDeviceDetails = deviceDetails;
        this.headerDetails = map == null ? new HashMap<>() : map;
    }

    public DeviceDetails getDefaultDeviceDetails() {
        return this.defaultDeviceDetails;
    }

    public Map<Key, DeviceDetails> getHeaderDetails() {
        return this.headerDetails;
    }

    @Override // org.jupnp.model.profile.DeviceDetailsProvider
    public DeviceDetails provide(RemoteClientInfo remoteClientInfo) {
        if (remoteClientInfo == null || remoteClientInfo.getRequestHeaders().isEmpty()) {
            return getDefaultDeviceDetails();
        }
        for (Key key : getHeaderDetails().keySet()) {
            List<String> list = remoteClientInfo.getRequestHeaders().get((Object) key.getHeaderName());
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (key.isValuePatternMatch(it.next())) {
                        return getHeaderDetails().get(key);
                    }
                }
            }
        }
        return getDefaultDeviceDetails();
    }

    public HeaderDeviceDetailsProvider(DeviceDetails deviceDetails) {
        this(deviceDetails, null);
    }
}
