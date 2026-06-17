package defpackage;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kk0 {
    public static final kk0 e = new b(0).e();
    public static final String f = fy4.N0(0);
    public static final String g = fy4.N0(1);
    public static final String h = fy4.N0(2);
    public static final String i = fy4.N0(3);
    public final int a;
    public final int b;
    public final int c;
    public final String d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public int b;
        public int c;
        public String d;

        public b(int i) {
            this.a = i;
        }

        public kk0 e() {
            gg3.d(this.b <= this.c);
            return new kk0(this);
        }

        public b f(int i) {
            this.c = i;
            return this;
        }

        public b g(int i) {
            this.b = i;
            return this;
        }

        public b h(String str) {
            gg3.d(this.a != 0 || str == null);
            this.d = str;
            return this;
        }
    }

    public kk0(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
    }

    public static kk0 a(Bundle bundle) {
        int i2 = bundle.getInt(f, 0);
        int i3 = bundle.getInt(g, 0);
        int i4 = bundle.getInt(h, 0);
        return new b(i2).g(i3).f(i4).h(bundle.getString(i)).e();
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        int i2 = this.a;
        if (i2 != 0) {
            bundle.putInt(f, i2);
        }
        int i3 = this.b;
        if (i3 != 0) {
            bundle.putInt(g, i3);
        }
        int i4 = this.c;
        if (i4 != 0) {
            bundle.putInt(h, i4);
        }
        String str = this.d;
        if (str != null) {
            bundle.putString(i, str);
        }
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kk0)) {
            return false;
        }
        kk0 kk0Var = (kk0) obj;
        return this.a == kk0Var.a && this.b == kk0Var.b && this.c == kk0Var.c && Objects.equals(this.d, kk0Var.d);
    }

    public int hashCode() {
        int i2 = (((((527 + this.a) * 31) + this.b) * 31) + this.c) * 31;
        String str = this.d;
        return i2 + (str == null ? 0 : str.hashCode());
    }
}
