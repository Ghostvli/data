package org.jupnp.transport.impl;

import org.jupnp.transport.spi.ServletContainerAdapter;
import org.jupnp.transport.spi.StreamServerConfiguration;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ServletStreamServerConfigurationImpl implements StreamServerConfiguration {
    protected int asyncTimeoutSeconds;
    protected int listenPort;
    protected ServletContainerAdapter servletContainerAdapter;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ServletStreamServerConfigurationImpl(ServletContainerAdapter servletContainerAdapter) {
        this.listenPort = 0;
        this.asyncTimeoutSeconds = 60;
        this.servletContainerAdapter = servletContainerAdapter;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getAsyncTimeoutSeconds() {
        return this.asyncTimeoutSeconds;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.spi.StreamServerConfiguration
    public int getListenPort() {
        return this.listenPort;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ServletContainerAdapter getServletContainerAdapter() {
        return this.servletContainerAdapter;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAsyncTimeoutSeconds(int i) {
        this.asyncTimeoutSeconds = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setListenPort(int i) {
        this.listenPort = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setServletContainerAdapter(ServletContainerAdapter servletContainerAdapter) {
        this.servletContainerAdapter = servletContainerAdapter;
    }

    public ServletStreamServerConfigurationImpl(ServletContainerAdapter servletContainerAdapter, int i) {
        this.asyncTimeoutSeconds = 60;
        this.servletContainerAdapter = servletContainerAdapter;
        this.listenPort = i;
    }

    public ServletStreamServerConfigurationImpl(ServletContainerAdapter servletContainerAdapter, int i, int i2) {
        this.servletContainerAdapter = servletContainerAdapter;
        this.listenPort = i;
        this.asyncTimeoutSeconds = i2;
    }
}
