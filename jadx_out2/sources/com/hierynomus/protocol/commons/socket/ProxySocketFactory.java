package com.hierynomus.protocol.commons.socket;

import defpackage.j02;
import defpackage.n02;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import javax.net.SocketFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ProxySocketFactory extends SocketFactory {
    public static final int DEFAULT_CONNECT_TIMEOUT = 5000;
    private static final j02 logger = n02.k(ProxySocketFactory.class);
    private int connectTimeout;
    private Proxy proxy;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ProxySocketFactory(String str, int i) {
        this(getHttpProxy(str, i), 5000);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Socket createSocket(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) throws IOException {
        Socket socket = new Socket(this.proxy);
        if (inetSocketAddress2 != null) {
            socket.bind(inetSocketAddress2);
        }
        logger.q("Connecting to {}", inetSocketAddress);
        socket.connect(inetSocketAddress, this.connectTimeout);
        return socket;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Proxy getHttpProxy(String str, int i) {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
    }

    public ProxySocketFactory() {
        this(Proxy.NO_PROXY, 5000);
    }

    public ProxySocketFactory(Proxy proxy) {
        this(proxy, 5000);
    }

    public ProxySocketFactory(int i) {
        this(Proxy.NO_PROXY, i);
    }

    public ProxySocketFactory(Proxy proxy, int i) {
        this.proxy = proxy;
        this.connectTimeout = i;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return createSocket(new InetSocketAddress(str, i), (InetSocketAddress) null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return createSocket(new InetSocketAddress(str, i), new InetSocketAddress(inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return createSocket(new InetSocketAddress(inetAddress, i), (InetSocketAddress) null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return createSocket(new InetSocketAddress(inetAddress, i), new InetSocketAddress(inetAddress2, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        return new Socket(this.proxy);
    }
}
