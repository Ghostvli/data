package org.jupnp.transport.impl;

import java.net.InetAddress;
import org.jupnp.transport.spi.MulticastReceiverConfiguration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MulticastReceiverConfigurationImpl implements MulticastReceiverConfiguration {
    private InetAddress group;
    private int maxDatagramBytes;
    private int port;

    public MulticastReceiverConfigurationImpl(InetAddress inetAddress, int i, int i2) {
        this.group = inetAddress;
        this.port = i;
        this.maxDatagramBytes = i2;
    }

    @Override // org.jupnp.transport.spi.MulticastReceiverConfiguration
    public InetAddress getGroup() {
        return this.group;
    }

    @Override // org.jupnp.transport.spi.MulticastReceiverConfiguration
    public int getMaxDatagramBytes() {
        return this.maxDatagramBytes;
    }

    @Override // org.jupnp.transport.spi.MulticastReceiverConfiguration
    public int getPort() {
        return this.port;
    }

    public void setGroup(InetAddress inetAddress) {
        this.group = inetAddress;
    }

    public void setMaxDatagramBytes(int i) {
        this.maxDatagramBytes = i;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public MulticastReceiverConfigurationImpl(InetAddress inetAddress, int i) {
        this(inetAddress, i, 640);
    }

    public MulticastReceiverConfigurationImpl(String str, int i, int i2) {
        this(InetAddress.getByName(str), i, i2);
    }

    public MulticastReceiverConfigurationImpl(String str, int i) {
        this(InetAddress.getByName(str), i, 640);
    }
}
