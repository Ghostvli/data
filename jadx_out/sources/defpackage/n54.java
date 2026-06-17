package defpackage;

import android.graphics.Paint;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class n54 implements v20 {
    public final String a;
    public final j6 b;
    public final List c;
    public final i6 d;
    public final l6 e;
    public final j6 f;
    public final b g;
    public final c h;
    public final float i;
    public final boolean j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[c.values().length];
            b = iArr;
            try {
                iArr[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            a = iArr2;
            try {
                iArr2[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap b() {
            int i2 = a.a[ordinal()];
            return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join b() {
            int i2 = a.b[ordinal()];
            if (i2 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i2 == 2) {
                return Paint.Join.MITER;
            }
            if (i2 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public n54(String str, j6 j6Var, List list, i6 i6Var, l6 l6Var, j6 j6Var2, b bVar, c cVar, float f, boolean z) {
        this.a = str;
        this.b = j6Var;
        this.c = list;
        this.d = i6Var;
        this.e = l6Var;
        this.f = j6Var2;
        this.g = bVar;
        this.h = cVar;
        this.i = f;
        this.j = z;
    }

    @Override // defpackage.v20
    public k20 a(g22 g22Var, f12 f12Var, bi biVar) {
        return new ah4(g22Var, biVar, this);
    }

    public b b() {
        return this.g;
    }

    public i6 c() {
        return this.d;
    }

    public j6 d() {
        return this.b;
    }

    public c e() {
        return this.h;
    }

    public List f() {
        return this.c;
    }

    public float g() {
        return this.i;
    }

    public String h() {
        return this.a;
    }

    public l6 i() {
        return this.e;
    }

    public j6 j() {
        return this.f;
    }

    public boolean k() {
        return this.j;
    }
}
