package org.jupnp.binding.xml;

import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Descriptor {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface Device {
        public static final String DLNA_NAMESPACE_URI = "urn:schemas-dlna-org:device-1-0";
        public static final String DLNA_PREFIX = "dlna";
        public static final String NAMESPACE_URI = "urn:schemas-upnp-org:device-1-0";
        public static final String SEC_NAMESPACE_URI = "http://www.sec.co.kr/dlna";
        public static final String SEC_PREFIX = "sec";

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum ELEMENT {
            root,
            specVersion,
            major,
            minor,
            URLBase,
            device,
            UDN,
            X_DLNADOC,
            X_DLNACAP,
            ProductCap,
            X_ProductCap,
            deviceType,
            friendlyName,
            manufacturer,
            manufacturerURL,
            modelDescription,
            modelName,
            modelNumber,
            modelURL,
            presentationURL,
            UPC,
            serialNumber,
            iconList,
            icon,
            width,
            height,
            depth,
            url,
            mimetype,
            serviceList,
            service,
            serviceType,
            serviceId,
            SCPDURL,
            controlURL,
            eventSubURL,
            deviceList;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public static ELEMENT valueOrNullOf(String str) {
                try {
                    return valueOf(str);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public boolean equals(Node node) {
                return toString().equals(node.getLocalName());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface Service {
        public static final String NAMESPACE_URI = "urn:schemas-upnp-org:service-1-0";

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum ATTRIBUTE {
            sendEvents
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public enum ELEMENT {
            scpd,
            specVersion,
            major,
            minor,
            actionList,
            action,
            name,
            argumentList,
            argument,
            direction,
            relatedStateVariable,
            retval,
            serviceStateTable,
            stateVariable,
            dataType,
            defaultValue,
            allowedValueList,
            allowedValue,
            allowedValueRange,
            minimum,
            maximum,
            step;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public static ELEMENT valueOrNullOf(String str) {
                try {
                    return valueOf(str);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public boolean equals(Node node) {
                return toString().equals(node.getLocalName());
            }
        }
    }
}
