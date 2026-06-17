package defpackage;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class di1 implements Serializable {
    public final String f;
    public final int g;
    public final int h;
    public final a i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        HIGH,
        MEDIUM,
        LOW,
        UNKNOWN;

        public static a a(int i) {
            return i <= 0 ? UNKNOWN : i < 175 ? LOW : i < 720 ? MEDIUM : HIGH;
        }
    }

    public di1(String str, int i, int i2, a aVar) {
        this.f = str;
        this.g = i;
        this.h = i2;
        Objects.requireNonNull(aVar, "estimatedResolutionLevel is null");
        this.i = aVar;
    }

    public String a() {
        return this.f;
    }

    public String toString() {
        return "Image {url=" + this.f + ", height=" + this.g + ", width=" + this.h + ", estimatedResolutionLevel=" + this.i + "}";
    }
}
