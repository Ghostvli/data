package defpackage;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class la3 extends yn3 {
    public static final String c = fy4.N0(1);
    public final float b;

    public la3(float f) {
        gg3.e(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.b = f;
    }

    public static la3 d(Bundle bundle) {
        gg3.d(bundle.getInt(yn3.a, -1) == 1);
        float f = bundle.getFloat(c, -1.0f);
        return f == -1.0f ? new la3() : new la3(f);
    }

    @Override // defpackage.yn3
    public boolean b() {
        return this.b != -1.0f;
    }

    @Override // defpackage.yn3
    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(yn3.a, 1);
        bundle.putFloat(c, this.b);
        return bundle;
    }

    public float e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof la3) && this.b == ((la3) obj).b;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.b));
    }

    public la3() {
        this.b = -1.0f;
    }
}
