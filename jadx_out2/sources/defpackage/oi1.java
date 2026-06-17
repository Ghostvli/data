package defpackage;

import defpackage.di1;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class oi1 implements Serializable {
    public final String f;
    public final int g;
    public final int h;
    public final di1.a i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public oi1(String str, int i, int i2, di1.a aVar) {
        this.f = str;
        this.g = i;
        this.h = i2;
        Objects.requireNonNull(aVar, "estimatedResolutionLevel is null");
        this.i = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int a() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public di1.a b() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String c() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int d() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "ImageSuffix {suffix=" + this.f + ", height=" + this.g + ", width=" + this.h + ", resolutionLevel=" + this.i + "}";
    }
}
