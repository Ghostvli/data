package org.jupnp.transport.impl.osgi;

import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.osgi.service.http.HttpContext;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DisableAuthenticationHttpContext implements HttpContext {
    public String getMimeType(String str) {
        return null;
    }

    public URL getResource(String str) {
        return null;
    }

    public boolean handleSecurity(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return true;
    }
}
