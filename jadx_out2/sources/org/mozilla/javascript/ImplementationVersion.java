package org.mozilla.javascript;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ImplementationVersion {
    private static final ImplementationVersion version = new ImplementationVersion();
    private String versionString;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ImplementationVersion() {
        InputStream inputStreamOpenStream;
        Attributes mainAttributes;
        try {
            Enumeration<URL> resources = ImplementationVersion.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                try {
                    inputStreamOpenStream = resources.nextElement().openStream();
                    try {
                        mainAttributes = new Manifest(inputStreamOpenStream).getMainAttributes();
                    } finally {
                    }
                } catch (IOException unused) {
                    continue;
                }
                if ("Mozilla Rhino".equals(mainAttributes.getValue("Implementation-Title"))) {
                    StringBuilder sb = new StringBuilder(23);
                    sb.append("Rhino ");
                    sb.append(mainAttributes.getValue("Implementation-Version"));
                    String value = mainAttributes.getValue("Built-Date");
                    if (value != null) {
                        String strReplaceAll = value.replaceAll("-", " ");
                        sb.append(' ');
                        sb.append(strReplaceAll);
                    }
                    this.versionString = sb.toString();
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                        return;
                    }
                    return;
                }
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                continue;
            }
            this.versionString = "Rhino Snapshot";
        } catch (IOException unused2) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String get() {
        return version.versionString;
    }
}
