package defpackage;

import android.content.res.Resources;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kk4 {
    public static final a e = new a(null);
    public final int a;
    public final int b;
    public final int c;
    public final Function1 d;

    public kk4(int i, int i2, int i3, Function1 function1) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = function1;
    }

    public static final kk4 a(int i) {
        return e.a(i);
    }

    public final int b() {
        return this.b;
    }

    public final Function1 c() {
        return this.d;
    }

    public final int d() {
        return this.c;
    }

    public final int e(boolean z) {
        return z ? this.b : this.a;
    }

    public final int f(boolean z) {
        if (this.c == 0) {
            return 0;
        }
        return z ? this.b : this.a;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {

        /* JADX INFO: renamed from: kk4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0090a extends tr1 implements Function1 {
            public static final C0090a g = new C0090a();

            public C0090a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Resources resources) {
                resources.getClass();
                return Boolean.TRUE;
            }
        }

        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public final kk4 a(int i) {
            return new kk4(i, i, 2, C0090a.g, null);
        }

        public a() {
        }
    }

    public /* synthetic */ kk4(int i, int i2, int i3, Function1 function1, we0 we0Var) {
        this(i, i2, i3, function1);
    }
}
