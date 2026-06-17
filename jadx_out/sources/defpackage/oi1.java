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

    public oi1(String str, int i, int i2, di1.a aVar) {
        this.f = str;
        this.g = i;
        this.h = i2;
        Objects.requireNonNull(aVar, "estimatedResolutionLevel is null");
        this.i = aVar;
    }

    public int a() {
        return this.g;
    }

    public di1.a b() {
        return this.i;
    }

    public String c() {
        return this.f;
    }

    public int d() {
        return this.h;
    }

    public String toString() {
        return "ImageSuffix {suffix=" + this.f + ", height=" + this.g + ", width=" + this.h + ", resolutionLevel=" + this.i + "}";
    }
}
