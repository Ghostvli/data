package defpackage;

import android.util.AndroidRuntimeException;
import android.view.View;
import defpackage.h7;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dq0 implements h7.c {
    public final Object d;
    public final v21 e;
    public float j;
    public h7 m;
    public static final q n = new f("translationX");
    public static final q o = new g("translationY");
    public static final q p = new h("translationZ");
    public static final q q = new i("scaleX");
    public static final q r = new j("scaleY");
    public static final q s = new k("rotation");
    public static final q t = new l("rotationX");
    public static final q u = new m("rotationY");
    public static final q v = new n("x");
    public static final q w = new a("y");
    public static final q x = new b("z");
    public static final q y = new c("alpha");
    public static final q z = new d("scrollX");
    public static final q A = new e("scrollY");
    public float a = 0.0f;
    public float b = Float.MAX_VALUE;
    public boolean c = false;
    public boolean f = false;
    public float g = Float.MAX_VALUE;
    public float h = -Float.MAX_VALUE;
    public long i = 0;
    public final ArrayList k = new ArrayList();
    public final ArrayList l = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends q {
        public a(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setY(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends q {
        public b(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return l35.I(view);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            l35.y0(view, f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends q {
        public c(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends q {
        public d(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScrollX((int) f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends q {
        public e(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScrollY((int) f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f extends q {
        public f(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setTranslationX(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g extends q {
        public g(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setTranslationY(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h extends q {
        public h(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return l35.G(view);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            l35.w0(view, f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class i extends q {
        public i(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScaleX(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class j extends q {
        public j(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScaleY(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class k extends q {
        public k(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setRotation(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class l extends q {
        public l(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setRotationX(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class m extends q {
        public m(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setRotationY(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class n extends q {
        public n(String str) {
            super(str, null);
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // defpackage.v21
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setX(f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class o {
        public float a;
        public float b;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface p {
        void a(dq0 dq0Var, boolean z, float f, float f2);
    }

    public dq0(Object obj, v21 v21Var) {
        this.d = obj;
        this.e = v21Var;
        if (v21Var == s || v21Var == t || v21Var == u) {
            this.j = 0.1f;
            return;
        }
        if (v21Var == y) {
            this.j = 0.00390625f;
        } else if (v21Var == q || v21Var == r) {
            this.j = 0.002f;
        } else {
            this.j = 1.0f;
        }
    }

    public static void i(ArrayList arrayList, Object obj) {
        int iIndexOf = arrayList.indexOf(obj);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    public static void j(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // h7.c
    public boolean a(long j2) {
        long j3 = this.i;
        if (j3 == 0) {
            this.i = j2;
            l(this.b);
            return false;
        }
        long j4 = j2 - j3;
        this.i = j2;
        float fG = d().g();
        boolean zQ = q(fG == 0.0f ? 2147483647L : (long) (j4 / fG));
        float fMin = Math.min(this.b, this.g);
        this.b = fMin;
        float fMax = Math.max(fMin, this.h);
        this.b = fMax;
        l(fMax);
        if (zQ) {
            c(false);
        }
        return zQ;
    }

    public dq0 b(p pVar) {
        if (!this.k.contains(pVar)) {
            this.k.add(pVar);
        }
        return this;
    }

    public final void c(boolean z2) {
        int i2 = 0;
        this.f = false;
        d().k(this);
        this.i = 0L;
        this.c = false;
        while (true) {
            int size = this.k.size();
            ArrayList arrayList = this.k;
            if (i2 >= size) {
                j(arrayList);
                return;
            } else {
                if (arrayList.get(i2) != null) {
                    ((p) this.k.get(i2)).a(this, z2, this.b, this.a);
                }
                i2++;
            }
        }
    }

    public h7 d() {
        h7 h7Var = this.m;
        return h7Var != null ? h7Var : h7.h();
    }

    public final float e() {
        return this.e.a(this.d);
    }

    public float f() {
        return this.j * 0.75f;
    }

    public boolean g() {
        return this.f;
    }

    public void h(p pVar) {
        i(this.k, pVar);
    }

    public dq0 k(float f2) {
        if (f2 <= 0.0f) {
            jl.a("Minimum visible change must be positive.");
            return null;
        }
        this.j = f2;
        n(f2 * 0.75f);
        return this;
    }

    public void l(float f2) {
        this.e.b(this.d, f2);
        int i2 = 0;
        while (true) {
            int size = this.l.size();
            ArrayList arrayList = this.l;
            if (i2 >= size) {
                j(arrayList);
                return;
            } else {
                if (arrayList.get(i2) != null) {
                    w82.a(this.l.get(i2));
                    throw null;
                }
                i2++;
            }
        }
    }

    public dq0 m(float f2) {
        this.b = f2;
        this.c = true;
        return this;
    }

    public abstract void n(float f2);

    public void o() {
        if (!d().j()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f) {
            return;
        }
        p();
    }

    public final void p() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (!this.c) {
            this.b = e();
        }
        float f2 = this.b;
        if (f2 > this.g || f2 < this.h) {
            jl.a("Starting value need to be in between min value and max value");
        } else {
            d().d(this, 0L);
        }
    }

    public abstract boolean q(long j2);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class q extends v21 {
        public /* synthetic */ q(String str, f fVar) {
            this(str);
        }

        public q(String str) {
            super(str);
        }
    }
}
