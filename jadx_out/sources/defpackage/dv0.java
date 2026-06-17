package defpackage;

import defpackage.t41;
import defpackage.xs2;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class dv0 implements xs2.a {
    public static final t41 g = new t41.b().A0("application/id3").Q();
    public static final t41 h = new t41.b().A0("application/x-scte35").Q();
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final byte[] e;
    public int f;

    public dv0(String str, String str2, long j, long j2, byte[] bArr) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = bArr;
    }

    @Override // xs2.a
    public t41 a() {
        String str = this.a;
        str.getClass();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return g;
            default:
                return null;
        }
    }

    @Override // xs2.a
    public byte[] c() {
        if (a() != null) {
            return this.e;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && dv0.class == obj.getClass()) {
            dv0 dv0Var = (dv0) obj;
            if (this.c == dv0Var.c && this.d == dv0Var.d && Objects.equals(this.a, dv0Var.a) && Objects.equals(this.b, dv0Var.b) && Arrays.equals(this.e, dv0Var.e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f == 0) {
            String str = this.a;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.b;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j = this.c;
            int i = (((iHashCode + iHashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.d;
            this.f = ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.e);
        }
        return this.f;
    }

    public String toString() {
        return "EMSG: scheme=" + this.a + ", id=" + this.d + ", durationMs=" + this.c + ", value=" + this.b;
    }
}
