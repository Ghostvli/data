package defpackage;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class td4 extends yn3 {
    public static final String d = fy4.N0(1);
    public static final String e = fy4.N0(2);
    public final int b;
    public final float c;

    public td4(int i, float f) {
        boolean z = false;
        gg3.e(i > 0, "maxStars must be a positive integer");
        if (f >= 0.0f && f <= i) {
            z = true;
        }
        gg3.e(z, "starRating is out of range [0, maxStars]");
        this.b = i;
        this.c = f;
    }

    public static td4 d(Bundle bundle) {
        gg3.d(bundle.getInt(yn3.a, -1) == 2);
        int i = bundle.getInt(d, 5);
        float f = bundle.getFloat(e, -1.0f);
        return f == -1.0f ? new td4(i) : new td4(i, f);
    }

    @Override // defpackage.yn3
    public boolean b() {
        return this.c != -1.0f;
    }

    @Override // defpackage.yn3
    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(yn3.a, 2);
        bundle.putInt(d, this.b);
        bundle.putFloat(e, this.c);
        return bundle;
    }

    public int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof td4)) {
            return false;
        }
        td4 td4Var = (td4) obj;
        return this.b == td4Var.b && this.c == td4Var.c;
    }

    public float f() {
        return this.c;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.b), Float.valueOf(this.c));
    }

    public td4(int i) {
        gg3.e(i > 0, "maxStars must be a positive integer");
        this.b = i;
        this.c = -1.0f;
    }
}
