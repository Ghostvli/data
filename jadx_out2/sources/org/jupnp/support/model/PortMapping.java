package org.jupnp.support.model;

import java.util.Map;
import org.jupnp.model.action.ActionArgumentValue;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.model.types.UnsignedIntegerTwoBytes;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PortMapping {
    private String description;
    private boolean enabled;
    private UnsignedIntegerTwoBytes externalPort;
    private String internalClient;
    private UnsignedIntegerTwoBytes internalPort;
    private UnsignedIntegerFourBytes leaseDurationSeconds;
    private Protocol protocol;
    private String remoteHost;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Protocol {
        UDP,
        TCP
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PortMapping(Map<String, ActionArgumentValue<Service<?, ?>>> map) {
        this(((Boolean) map.get("NewEnabled").getValue()).booleanValue(), (UnsignedIntegerFourBytes) map.get("NewLeaseDuration").getValue(), (String) map.get("NewRemoteHost").getValue(), (UnsignedIntegerTwoBytes) map.get("NewExternalPort").getValue(), (UnsignedIntegerTwoBytes) map.get("NewInternalPort").getValue(), (String) map.get("NewInternalClient").getValue(), Protocol.valueOf(map.get("NewProtocol").toString()), (String) map.get("NewPortMappingDescription").getValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDescription() {
        String str = this.description;
        return str == null ? "-" : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UnsignedIntegerTwoBytes getExternalPort() {
        return this.externalPort;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getInternalClient() {
        return this.internalClient;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UnsignedIntegerTwoBytes getInternalPort() {
        return this.internalPort;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UnsignedIntegerFourBytes getLeaseDurationSeconds() {
        return this.leaseDurationSeconds;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Protocol getProtocol() {
        return this.protocol;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getRemoteHost() {
        String str = this.remoteHost;
        return str == null ? "-" : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasDescription() {
        return this.description != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean hasRemoteHost() {
        String str = this.remoteHost;
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEnabled() {
        return this.enabled;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDescription(String str) {
        if (str == null || str.equals("-") || str.isEmpty()) {
            str = null;
        }
        this.description = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setExternalPort(UnsignedIntegerTwoBytes unsignedIntegerTwoBytes) {
        this.externalPort = unsignedIntegerTwoBytes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setInternalClient(String str) {
        this.internalClient = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setInternalPort(UnsignedIntegerTwoBytes unsignedIntegerTwoBytes) {
        this.internalPort = unsignedIntegerTwoBytes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLeaseDurationSeconds(UnsignedIntegerFourBytes unsignedIntegerFourBytes) {
        this.leaseDurationSeconds = unsignedIntegerFourBytes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setRemoteHost(String str) {
        if (str == null || str.equals("-") || str.isEmpty()) {
            str = null;
        }
        this.remoteHost = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(" + getClass().getSimpleName() + ") Protocol: " + String.valueOf(getProtocol()) + ", " + String.valueOf(getExternalPort()) + " => " + getInternalClient();
    }

    public PortMapping() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PortMapping(int i, String str, Protocol protocol) {
        long j = i;
        this(true, new UnsignedIntegerFourBytes(0L), null, new UnsignedIntegerTwoBytes(j), new UnsignedIntegerTwoBytes(j), str, protocol, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PortMapping(int i, String str, Protocol protocol, String str2) {
        long j = i;
        this(true, new UnsignedIntegerFourBytes(0L), null, new UnsignedIntegerTwoBytes(j), new UnsignedIntegerTwoBytes(j), str, protocol, str2);
    }

    public PortMapping(String str, UnsignedIntegerTwoBytes unsignedIntegerTwoBytes, Protocol protocol) {
        this(true, new UnsignedIntegerFourBytes(0L), str, unsignedIntegerTwoBytes, null, null, protocol, null);
    }

    public PortMapping(boolean z, UnsignedIntegerFourBytes unsignedIntegerFourBytes, String str, UnsignedIntegerTwoBytes unsignedIntegerTwoBytes, UnsignedIntegerTwoBytes unsignedIntegerTwoBytes2, String str2, Protocol protocol, String str3) {
        this.enabled = z;
        this.leaseDurationSeconds = unsignedIntegerFourBytes;
        this.remoteHost = str;
        this.externalPort = unsignedIntegerTwoBytes;
        this.internalPort = unsignedIntegerTwoBytes2;
        this.internalClient = str2;
        this.protocol = protocol;
        this.description = str3;
    }
}
