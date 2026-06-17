package org.jupnp.model.message.header;

import com.google.zxing.client.android.Intents;
import defpackage.j02;
import defpackage.n02;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UpnpHeader<T> {
    private T value;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Type {
        USN("USN", USNRootDeviceHeader.class, DeviceUSNHeader.class, ServiceUSNHeader.class, UDNHeader.class),
        NT("NT", RootDeviceHeader.class, UDADeviceTypeHeader.class, UDAServiceTypeHeader.class, DeviceTypeHeader.class, ServiceTypeHeader.class, UDNHeader.class, NTEventHeader.class),
        NTS("NTS", NTSHeader.class),
        HOST("HOST", HostHeader.class),
        SERVER("SERVER", ServerHeader.class),
        LOCATION("LOCATION", LocationHeader.class),
        MAX_AGE("CACHE-CONTROL", MaxAgeHeader.class),
        USER_AGENT("USER-AGENT", UserAgentHeader.class),
        CONTENT_TYPE("CONTENT-TYPE", ContentTypeHeader.class),
        MAN("MAN", MANHeader.class),
        MX("MX", MXHeader.class),
        ST("ST", STAllHeader.class, RootDeviceHeader.class, UDADeviceTypeHeader.class, UDAServiceTypeHeader.class, DeviceTypeHeader.class, ServiceTypeHeader.class, UDNHeader.class),
        EXT("EXT", EXTHeader.class),
        SOAPACTION("SOAPACTION", SoapActionHeader.class),
        TIMEOUT(Intents.Scan.TIMEOUT, TimeoutHeader.class),
        CALLBACK("CALLBACK", CallbackHeader.class),
        SID("SID", SubscriptionIdHeader.class),
        SEQ("SEQ", EventSequenceHeader.class),
        RANGE("RANGE", RangeHeader.class),
        CONTENT_RANGE("CONTENT-RANGE", ContentRangeHeader.class),
        PRAGMA("PRAGMA", PragmaHeader.class),
        EXT_IFACE_MAC("X-CLING-IFACE-MAC", InterfaceMacHeader.class),
        EXT_AV_CLIENT_INFO("X-AV-CLIENT-INFO", AVClientInfoHeader.class);

        private static final Map<String, Type> byName = new HashMap<String, Type>() { // from class: org.jupnp.model.message.header.UpnpHeader.Type.1
            {
                for (Type type : Type.values()) {
                    put(type.getHttpName(), type);
                }
            }
        };
        private final Class<? extends UpnpHeader>[] headerTypes;
        private final String httpName;

        Type(String str, Class... clsArr) {
            this.httpName = str;
            this.headerTypes = clsArr;
        }

        public static Type getByHttpName(String str) {
            if (str == null) {
                return null;
            }
            return byName.get(str.toUpperCase(Locale.ENGLISH));
        }

        public Class<? extends UpnpHeader>[] getHeaderTypes() {
            return this.headerTypes;
        }

        public String getHttpName() {
            return this.httpName;
        }

        public boolean isValidHeaderType(Class<? extends UpnpHeader> cls) {
            for (Class<? extends UpnpHeader> cls2 : getHeaderTypes()) {
                if (cls2.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static UpnpHeader newInstance(Type type, String str) {
        UpnpHeader upnpHeaderNewInstance;
        Exception e;
        j02 j02VarK = n02.k(UpnpHeader.class);
        UpnpHeader upnpHeader = null;
        for (int i = 0; i < type.getHeaderTypes().length && upnpHeader == null; i++) {
            Class<? extends UpnpHeader> cls = type.getHeaderTypes()[i];
            try {
                try {
                    j02VarK.i("Trying to parse '{}' with class: {}", type, cls.getSimpleName());
                    upnpHeaderNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    if (str != null) {
                        try {
                            upnpHeaderNewInstance.setString(str);
                        } catch (Exception e2) {
                            e = e2;
                            j02VarK.p("Error instantiating header of type '{}' with value: {}", type, str, e);
                        }
                    }
                } catch (Exception e3) {
                    upnpHeaderNewInstance = upnpHeader;
                    e = e3;
                }
                upnpHeader = upnpHeaderNewInstance;
            } catch (InvalidHeaderException e4) {
                j02VarK.i("Invalid header value for tested type: {} - {}", cls.getSimpleName(), e4.getMessage());
                upnpHeader = null;
            }
        }
        return upnpHeader;
    }

    public abstract String getString();

    public T getValue() {
        return this.value;
    }

    public abstract void setString(String str);

    public void setValue(T t) {
        this.value = t;
    }

    public String toString() {
        return "(" + getClass().getSimpleName() + ") '" + String.valueOf(getValue()) + "'";
    }
}
