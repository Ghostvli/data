package com.google.android.material.carousel;

import defpackage.e04;
import defpackage.jl;
import defpackage.k7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final float a;
    public int b;
    public final List c;
    public final int d;
    public final int e;
    public final int f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final float a;
        public final int b;
        public C0064c d;
        public C0064c e;
        public final List c = new ArrayList();
        public int f = -1;
        public int g = -1;
        public float h = 0.0f;
        public int i = -1;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(float f, int i) {
            this.a = f;
            this.b = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static float j(float f, float f2, int i, int i2) {
            return (f - (i * f2)) + (i2 * f2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b a(float f, float f2, float f3) {
            return d(f, f2, f3, false, true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(float f, float f2, float f3) {
            return c(f, f2, f3, false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c(float f, float f2, float f3, boolean z) {
            return d(f, f2, f3, z, false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d(float f, float f2, float f3, boolean z, boolean z2) {
            float fAbs;
            float f4 = f3 / 2.0f;
            float f5 = f - f4;
            float f6 = f4 + f;
            int i = this.b;
            if (f6 > i) {
                fAbs = Math.abs(f6 - Math.max(f6 - f3, i));
            } else {
                fAbs = 0.0f;
                if (f5 < 0.0f) {
                    fAbs = Math.abs(f5 - Math.min(f5 + f3, 0.0f));
                }
            }
            return e(f, f2, f3, z, z2, fAbs);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b e(float f, float f2, float f3, boolean z, boolean z2, float f4) {
            return f(f, f2, f3, z, z2, f4, 0.0f, 0.0f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b f(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5, float f6) {
            if (f3 <= 0.0f) {
                return this;
            }
            if (z2) {
                if (z) {
                    jl.a("Anchor keylines cannot be focal.");
                    return null;
                }
                int i = this.i;
                if (i != -1 && i != 0) {
                    jl.a("Anchor keylines must be either the first or last keyline.");
                    return null;
                }
                this.i = this.c.size();
            }
            C0064c c0064c = new C0064c(Float.MIN_VALUE, f, f2, f3, z2, f4, f5, f6);
            C0064c c0064c2 = this.d;
            if (z) {
                if (c0064c2 == null) {
                    this.d = c0064c;
                    this.f = this.c.size();
                }
                if (this.g != -1 && this.c.size() - this.g > 1) {
                    jl.a("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                    return null;
                }
                if (f3 != this.d.d) {
                    jl.a("Keylines that are marked as focal must all have the same masked item size.");
                    return null;
                }
                this.e = c0064c;
                this.g = this.c.size();
            } else {
                if (c0064c2 == null && c0064c.d < this.h) {
                    jl.a("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                    return null;
                }
                if (this.e != null && c0064c.d > this.h) {
                    jl.a("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                    return null;
                }
            }
            this.h = c0064c.d;
            this.c.add(c0064c);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b g(float f, float f2, float f3, int i) {
            return h(f, f2, f3, i, false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b h(float f, float f2, float f3, int i, boolean z) {
            if (i > 0 && f3 > 0.0f) {
                for (int i2 = 0; i2 < i; i2++) {
                    c((i2 * f3) + f, f2, f3, z);
                }
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c i() {
            if (this.d == null) {
                e04.a("There must be a keyline marked as focal.");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.c.size(); i++) {
                C0064c c0064c = (C0064c) this.c.get(i);
                arrayList.add(new C0064c(j(this.d.b, this.a, this.f, i), c0064c.b, c0064c.c, c0064c.d, c0064c.e, c0064c.f, c0064c.g, c0064c.h));
            }
            return new c(this.a, arrayList, this.f, this.g, this.b);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c(float f, List list, int i, int i2, int i3) {
        this.a = f;
        this.c = Collections.unmodifiableList(list);
        this.d = i;
        this.e = i2;
        while (i <= i2) {
            if (((C0064c) list.get(i)).f == 0.0f) {
                this.b++;
            }
            i++;
        }
        this.f = i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c o(c cVar, c cVar2, float f) {
        if (cVar.g() != cVar2.g()) {
            jl.a("Keylines being linearly interpolated must have the same item size.");
            return null;
        }
        List listH = cVar.h();
        List listH2 = cVar2.h();
        if (listH.size() != listH2.size()) {
            jl.a("Keylines being linearly interpolated must have the same number of keylines.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cVar.h().size(); i++) {
            arrayList.add(C0064c.a((C0064c) listH.get(i), (C0064c) listH2.get(i), f));
        }
        return new c(cVar.g(), arrayList, k7.c(cVar.c(), cVar2.c(), f), k7.c(cVar.j(), cVar2.j(), f), cVar.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c p(c cVar, int i) {
        b bVar = new b(cVar.g(), i);
        float f = (i - cVar.k().b) - (cVar.k().d / 2.0f);
        int size = cVar.h().size() - 1;
        while (size >= 0) {
            C0064c c0064c = (C0064c) cVar.h().get(size);
            bVar.d((c0064c.d / 2.0f) + f, c0064c.c, c0064c.d, size >= cVar.c() && size <= cVar.j(), c0064c.e);
            f += c0064c.d;
            size--;
        }
        return bVar.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int a() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public C0064c b() {
        return (C0064c) this.c.get(this.d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public C0064c d() {
        return (C0064c) this.c.get(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public C0064c e() {
        for (int i = 0; i < this.c.size(); i++) {
            C0064c c0064c = (C0064c) this.c.get(i);
            if (!c0064c.e) {
                return c0064c;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List f() {
        return this.c.subList(this.d, this.e + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float g() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List h() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public C0064c i() {
        return (C0064c) this.c.get(this.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int j() {
        return this.e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public C0064c k() {
        return (C0064c) this.c.get(r1.size() - 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public C0064c l() {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            C0064c c0064c = (C0064c) this.c.get(size);
            if (!c0064c.e) {
                return c0064c;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m() {
        Iterator it = this.c.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((C0064c) it.next()).e) {
                i++;
            }
        }
        return this.c.size() - i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int n() {
        return this.b;
    }

    /* JADX INFO: renamed from: com.google.android.material.carousel.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class C0064c {
        public final float a;
        public final float b;
        public final float c;
        public final float d;
        public final boolean e;
        public final float f;
        public final float g;
        public final float h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0064c(float f, float f2, float f3, float f4, boolean z, float f5, float f6, float f7) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = z;
            this.f = f5;
            this.g = f6;
            this.h = f7;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static C0064c a(C0064c c0064c, C0064c c0064c2, float f) {
            return new C0064c(k7.a(c0064c.a, c0064c2.a, f), k7.a(c0064c.b, c0064c2.b, f), k7.a(c0064c.c, c0064c2.c, f), k7.a(c0064c.d, c0064c2.d, f));
        }

        public C0064c(float f, float f2, float f3, float f4) {
            this(f, f2, f3, f4, false, 0.0f, 0.0f, 0.0f);
        }
    }
}
