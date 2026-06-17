package com.fongmi.android.tv.bean;

import com.github.catvod.utils.Path;
import com.github.catvod.utils.Util;
import defpackage.t14;
import defpackage.to3;
import defpackage.xq;
import defpackage.yq;
import java.util.Map;
import java.util.Objects;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class CastVideo extends to3 {
    private final Map<String, String> headers;
    private final String name;
    private final long position;
    private final String url;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CastVideo(String str, String str2, long j, Map<String, String> map) {
        if (str2.startsWith("file")) {
            str2 = t14.b().c() + ServiceReference.DELIMITER + str2.replace(Path.rootPath(), "").replace("://", "");
        }
        str2 = str2.contains("127.0.0.1") ? str2.replace("127.0.0.1", Util.getIp()) : str2;
        this.name = str;
        this.url = str2;
        this.position = j;
        this.headers = map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private /* synthetic */ boolean a(Object obj) {
        if (!(obj instanceof CastVideo)) {
            return false;
        }
        CastVideo castVideo = (CastVideo) obj;
        return this.position == castVideo.position && Objects.equals(this.name, castVideo.name) && Objects.equals(this.url, castVideo.url) && Objects.equals(this.headers, castVideo.headers);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private /* synthetic */ Object[] b() {
        return new Object[]{this.name, this.url, Long.valueOf(this.position), this.headers};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean equals(Object obj) {
        return a(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int hashCode() {
        return xq.a(this.position, this.name, this.url, this.headers);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map<String, String> headers() {
        return this.headers;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String name() {
        return this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long position() {
        return this.position;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String toString() {
        return yq.a(b(), CastVideo.class, "name;url;position;headers");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String url() {
        return this.url;
    }
}
