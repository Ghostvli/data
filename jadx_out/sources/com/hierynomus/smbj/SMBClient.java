package com.hierynomus.smbj;

import com.hierynomus.protocol.commons.IOUtils;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.event.ConnectionClosed;
import com.hierynomus.smbj.event.SMBEventBus;
import com.hierynomus.smbj.server.ServerList;
import defpackage.j02;
import defpackage.n02;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.engio.mbassy.listener.Handler;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMBClient implements Closeable {
    public static final int DEFAULT_PORT = 445;
    private static final j02 logger = n02.k(SMBClient.class);
    private SMBEventBus bus;
    private SmbConfig config;
    private Map<String, Connection> connectionTable;
    private ServerList serverList;

    public SMBClient(SmbConfig smbConfig, SMBEventBus sMBEventBus) {
        this.connectionTable = new ConcurrentHashMap();
        this.serverList = new ServerList();
        this.config = smbConfig;
        this.bus = sMBEventBus;
        sMBEventBus.subscribe(this);
    }

    @Handler
    private void connectionClosed(ConnectionClosed connectionClosed) {
        synchronized (this) {
            String str = connectionClosed.getHostname() + ":" + connectionClosed.getPort();
            this.connectionTable.remove(str);
            this.serverList.unregister(connectionClosed.getHostname());
            logger.q("Connection to << {} >> closed", str);
        }
    }

    private Connection getEstablishedOrConnect(String str, int i) {
        synchronized (this) {
            try {
                String str2 = str + ":" + i;
                Connection connectionLease = this.connectionTable.get(str2);
                if (connectionLease != null) {
                    connectionLease = connectionLease.lease();
                }
                if (connectionLease != null && connectionLease.isConnected()) {
                    return connectionLease;
                }
                Connection connection = new Connection(this.config, this, this.bus, this.serverList);
                try {
                    connection.connect(str, i);
                    this.connectionTable.put(str2, connection);
                    return connection;
                } catch (IOException e) {
                    IOUtils.closeSilently(connection);
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        logger.info("Going to close all remaining connections");
        for (Connection connection : this.connectionTable.values()) {
            try {
                connection.close();
            } catch (Exception e) {
                logger.q("Error closing connection to host {}", connection.getRemoteHostname());
                logger.w("Exception was: ", e);
            }
        }
    }

    public Connection connect(String str) {
        return getEstablishedOrConnect(str, DEFAULT_PORT);
    }

    public ServerList getServerList() {
        return this.serverList;
    }

    public Connection connect(String str, int i) {
        return getEstablishedOrConnect(str, i);
    }

    public SMBClient(SmbConfig smbConfig) {
        this(smbConfig, new SMBEventBus());
    }

    public SMBClient() {
        this(SmbConfig.createDefaultConfig());
    }
}
