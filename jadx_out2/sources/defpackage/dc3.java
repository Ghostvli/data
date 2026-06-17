package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class dc3 {
    public static final dc3 d = new dc3(1.0f);
    public static final String e = fy4.N0(0);
    public static final String f = fy4.N0(1);
    public final float a;
    public final float b;
    public final int c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dc3(float f2, float f3) {
        gg3.d(f2 > 0.0f);
        gg3.d(f3 > 0.0f);
        this.a = f2;
        this.b = f3;
        this.c = Math.round(f2 * 1000.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static dc3 a(Bundle bundle) {
        return new dc3(bundle.getFloat(e, 1.0f), bundle.getFloat(f, 1.0f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long b(long j) {
        return j * ((long) this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putFloat(e, this.a);
        bundle.putFloat(f, this.b);
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dc3 d(float f2) {
        return new dc3(f2, this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && dc3.class == obj.getClass()) {
            dc3 dc3Var = (dc3) obj;
            if (this.a == dc3Var.a && this.b == dc3Var.b) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.a)) * 31) + Float.floatToRawIntBits(this.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return fy4.M("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.a), Float.valueOf(this.b));
    }

    public dc3(float f2) {
        this(f2, 1.0f);
    }
}
