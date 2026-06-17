package org.jupnp.transport.spi;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface NetworkAddressFactory {
    public static final String SYSTEM_PROPERTY_NET_ADDRESSES = "org.jupnp.network.useAddresses";
    public static final String SYSTEM_PROPERTY_NET_IFACES = "org.jupnp.network.useInterfaces";

    Short getAddressNetworkPrefixLength(InetAddress inetAddress);

    Iterator<InetAddress> getBindAddresses();

    InetAddress getBroadcastAddress(InetAddress inetAddress);

    byte[] getHardwareAddress(InetAddress inetAddress);

    InetAddress getLocalAddress(NetworkInterface networkInterface, boolean z, InetAddress inetAddress);

    InetAddress getMulticastGroup();

    int getMulticastPort();

    int getMulticastResponsePort();

    Iterator<NetworkInterface> getNetworkInterfaces();

    int getStreamListenPort();

    boolean hasUsableNetwork();

    void logInterfaceInformation();
}
