package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e35 {
    public static final e35 e = new e35(0, 0);
    public static final String f = fy4.N0(0);
    public static final String g = fy4.N0(1);
    public static final String h = fy4.N0(3);
    public final int a;
    public final int b;
    public final int c;
    public final float d;

    public e35(int i, int i2, float f2) {
        this.a = i;
        this.b = i2;
        this.c = 0;
        this.d = f2;
    }

    public static e35 a(Bundle bundle) {
        return new e35(bundle.getInt(f, 0), bundle.getInt(g, 0), bundle.getFloat(h, 1.0f));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        int i = this.a;
        if (i != 0) {
            bundle.putInt(f, i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            bundle.putInt(g, i2);
        }
        float f2 = this.d;
        if (f2 != 1.0f) {
            bundle.putFloat(h, f2);
        }
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e35) {
            e35 e35Var = (e35) obj;
            if (this.a == e35Var.a && this.b == e35Var.b && this.d == e35Var.d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((217 + this.a) * 31) + this.b) * 31) + Float.floatToRawIntBits(this.d);
    }

    public e35(int i, int i2) {
        this(i, i2, 1.0f);
    }
}
