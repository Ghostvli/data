package org.jupnp.transport.impl;

import defpackage.wg1;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import org.jupnp.model.message.Connection;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ServletConnection implements Connection {
    protected HttpServletRequest request;

    public ServletConnection(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override // org.jupnp.model.message.Connection
    public InetAddress getLocalAddress() {
        try {
            return InetAddress.getByName(getRequest().getLocalAddr());
        } catch (UnknownHostException e) {
            wg1.a(e);
            return null;
        }
    }

    @Override // org.jupnp.model.message.Connection
    public InetAddress getRemoteAddress() {
        try {
            return InetAddress.getByName(getRequest().getRemoteAddr());
        } catch (UnknownHostException e) {
            wg1.a(e);
            return null;
        }
    }

    public HttpServletRequest getRequest() {
        return this.request;
    }

    public boolean isConnectionOpen(HttpServletRequest httpServletRequest) {
        return true;
    }

    @Override // org.jupnp.model.message.Connection
    public boolean isOpen() {
        return isConnectionOpen(getRequest());
    }
}
