package org.jupnp.android;

import defpackage.d;
import defpackage.j02;
import defpackage.n02;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import org.jupnp.transport.impl.NetworkAddressFactoryImpl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AndroidNetworkAddressFactory extends NetworkAddressFactoryImpl {
    private final j02 logger;

    public AndroidNetworkAddressFactory(int i, int i2) {
        super(i, i2);
        this.logger = n02.k(AndroidNetworkAddressFactory.class);
    }

    @Override // org.jupnp.transport.impl.NetworkAddressFactoryImpl
    public void discoverNetworkInterfaces() {
        try {
            super.discoverNetworkInterfaces();
        } catch (Exception e) {
            this.logger.u("Exception while enumerating network interfaces, trying once more", e);
            super.discoverNetworkInterfaces();
        }
    }

    @Override // org.jupnp.transport.impl.NetworkAddressFactoryImpl, org.jupnp.transport.spi.NetworkAddressFactory
    public InetAddress getLocalAddress(NetworkInterface networkInterface, boolean z, InetAddress inetAddress) {
        for (InetAddress inetAddress2 : getInetAddresses(networkInterface)) {
            if (z && (inetAddress2 instanceof Inet6Address)) {
                return inetAddress2;
            }
            if (!z && (inetAddress2 instanceof Inet4Address)) {
                return inetAddress2;
            }
        }
        d.a("Can't find any IPv4 or IPv6 address on interface: ", networkInterface.getDisplayName());
        return null;
    }

    @Override // org.jupnp.transport.impl.NetworkAddressFactoryImpl
    public boolean isUsableAddress(NetworkInterface networkInterface, InetAddress inetAddress) {
        Field declaredField;
        Object obj;
        boolean zIsUsableAddress = super.isUsableAddress(networkInterface, inetAddress);
        if (zIsUsableAddress) {
            String hostAddress = inetAddress.getHostAddress();
            try {
                try {
                    Field declaredField2 = InetAddress.class.getDeclaredField("holder");
                    declaredField2.setAccessible(true);
                    obj = declaredField2.get(inetAddress);
                    declaredField = obj.getClass().getDeclaredField("hostName");
                } catch (NoSuchFieldException unused) {
                    declaredField = InetAddress.class.getDeclaredField("hostName");
                    obj = inetAddress;
                }
                if (declaredField == null || hostAddress == null) {
                    return false;
                }
                declaredField.setAccessible(true);
                declaredField.set(obj, hostAddress);
            } catch (Exception e) {
                this.logger.o("Failed injecting hostName to work around Android InetAddress DNS bug: {}", inetAddress, e);
                return false;
            }
        }
        return zIsUsableAddress;
    }

    @Override // org.jupnp.transport.impl.NetworkAddressFactoryImpl
    public boolean requiresNetworkInterface() {
        return false;
    }
}
