package org.jupnp.model;

import java.net.InetAddress;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NetworkAddress {
    protected InetAddress address;
    protected byte[] hardwareAddress;
    protected int port;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NetworkAddress(InetAddress inetAddress, int i, byte[] bArr) {
        this.address = inetAddress;
        this.port = i;
        this.hardwareAddress = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NetworkAddress networkAddress = (NetworkAddress) obj;
        return this.port == networkAddress.port && this.address.equals(networkAddress.address) && Arrays.equals(this.hardwareAddress, networkAddress.hardwareAddress);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public InetAddress getAddress() {
        return this.address;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getHardwareAddress() {
        return this.hardwareAddress;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getPort() {
        return this.port;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        int iHashCode = ((this.address.hashCode() * 31) + this.port) * 31;
        byte[] bArr = this.hardwareAddress;
        return iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }

    public NetworkAddress(InetAddress inetAddress, int i) {
        this(inetAddress, i, null);
    }
}
