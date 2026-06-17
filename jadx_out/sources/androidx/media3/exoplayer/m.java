package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.exoplayer.m;
import defpackage.bf3;
import defpackage.cr1;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.h52;
import defpackage.hs4;
import defpackage.i52;
import defpackage.ie3;
import defpackage.j5;
import defpackage.jq2;
import defpackage.mc1;
import defpackage.mi2;
import defpackage.no4;
import defpackage.o5;
import defpackage.o64;
import defpackage.oh2;
import defpackage.rq2;
import defpackage.ty1;
import defpackage.uq2;
import defpackage.v;
import defpackage.wo0;
import defpackage.xz1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public final ie3 a;
    public final d e;
    public final o5 h;
    public final mc1 i;
    public boolean k;
    public hs4 l;
    public o64 j = new o64.a(0);
    public final IdentityHashMap c = new IdentityHashMap();
    public final Map d = new HashMap();
    public final List b = new ArrayList();
    public final HashMap f = new HashMap();
    public final Set g = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements rq2, wo0 {
        public final c f;

        public a(c cVar) {
            this.f = cVar;
        }

        @Override // defpackage.rq2
        public void B(int i, jq2.b bVar, final ty1 ty1Var, final oh2 oh2Var, final IOException iOException, final boolean z) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: gr2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.B(((Integer) pair.first).intValue(), (jq2.b) pair.second, ty1Var, oh2Var, iOException, z);
                    }
                });
            }
        }

        @Override // defpackage.wo0
        public void C(int i, jq2.b bVar) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: xq2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.C(((Integer) pair.first).intValue(), (jq2.b) pair.second);
                    }
                });
            }
        }

        @Override // defpackage.wo0
        public void D(int i, jq2.b bVar) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: hr2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.D(((Integer) pair.first).intValue(), (jq2.b) pair.second);
                    }
                });
            }
        }

        @Override // defpackage.wo0
        public void F(int i, jq2.b bVar) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: cr2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.F(((Integer) pair.first).intValue(), (jq2.b) pair.second);
                    }
                });
            }
        }

        @Override // defpackage.wo0
        public void G(int i, jq2.b bVar, final cr1 cr1Var) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: yq2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.G(((Integer) pair.first).intValue(), (jq2.b) pair.second, cr1Var);
                    }
                });
            }
        }

        @Override // defpackage.rq2
        public void H(int i, jq2.b bVar, final ty1 ty1Var, final oh2 oh2Var, final int i2) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: fr2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.H(((Integer) pair.first).intValue(), (jq2.b) pair.second, ty1Var, oh2Var, i2);
                    }
                });
            }
        }

        public final Pair T(int i, jq2.b bVar) {
            jq2.b bVar2 = null;
            if (bVar != null) {
                jq2.b bVarN = m.n(this.f, bVar);
                if (bVarN == null) {
                    return null;
                }
                bVar2 = bVarN;
            }
            return Pair.create(Integer.valueOf(m.s(this.f, i)), bVar2);
        }

        @Override // defpackage.wo0
        public void a(int i, jq2.b bVar, final Exception exc) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: ar2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.a(((Integer) pair.first).intValue(), (jq2.b) pair.second, exc);
                    }
                });
            }
        }

        @Override // defpackage.rq2
        public void s(int i, jq2.b bVar, final oh2 oh2Var) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: br2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.s(((Integer) pair.first).intValue(), (jq2.b) pair.second, oh2Var);
                    }
                });
            }
        }

        @Override // defpackage.rq2
        public void v(int i, jq2.b bVar, final oh2 oh2Var) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: wq2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.v(((Integer) pair.first).intValue(), (jq2.b) gg3.q((jq2.b) pair.second), oh2Var);
                    }
                });
            }
        }

        @Override // defpackage.wo0
        public void x(int i, jq2.b bVar, final int i2) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: er2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.x(((Integer) pair.first).intValue(), (jq2.b) pair.second, i2);
                    }
                });
            }
        }

        @Override // defpackage.rq2
        public void y(int i, jq2.b bVar, final ty1 ty1Var, final oh2 oh2Var) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: zq2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.y(((Integer) pair.first).intValue(), (jq2.b) pair.second, ty1Var, oh2Var);
                    }
                });
            }
        }

        @Override // defpackage.rq2
        public void z(int i, jq2.b bVar, final ty1 ty1Var, final oh2 oh2Var) {
            final Pair pairT = T(i, bVar);
            if (pairT != null) {
                m.this.i.d(new Runnable() { // from class: dr2
                    @Override // java.lang.Runnable
                    public final void run() {
                        m.a aVar = this.f;
                        Pair pair = pairT;
                        m.this.h.z(((Integer) pair.first).intValue(), (jq2.b) pair.second, ty1Var, oh2Var);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final jq2 a;
        public final jq2.c b;
        public final a c;

        public b(jq2 jq2Var, jq2.c cVar, a aVar) {
            this.a = jq2Var;
            this.b = cVar;
            this.c = aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements uq2 {
        public final i52 a;
        public int d;
        public boolean e;
        public final List c = new ArrayList();
        public final Object b = new Object();

        public c(jq2 jq2Var, boolean z) {
            this.a = new i52(jq2Var, z);
        }

        @Override // defpackage.uq2
        public Object a() {
            return this.b;
        }

        @Override // defpackage.uq2
        public no4 b() {
            return this.a.c0();
        }

        public void c(int i) {
            this.d = i;
            this.e = false;
            this.c.clear();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void f();
    }

    public m(d dVar, o5 o5Var, mc1 mc1Var, ie3 ie3Var) {
        this.a = ie3Var;
        this.e = dVar;
        this.h = o5Var;
        this.i = mc1Var;
    }

    public static Object m(Object obj) {
        return v.C(obj);
    }

    public static jq2.b n(c cVar, jq2.b bVar) {
        for (int i = 0; i < cVar.c.size(); i++) {
            if (((jq2.b) cVar.c.get(i)).d == bVar.d) {
                return bVar.a(p(cVar, bVar.a));
            }
        }
        return null;
    }

    public static Object o(Object obj) {
        return v.D(obj);
    }

    public static Object p(c cVar, Object obj) {
        return v.F(cVar.b, obj);
    }

    public static int s(c cVar, int i) {
        return i + cVar.d;
    }

    public no4 A(int i, int i2, o64 o64Var) {
        gg3.d(i >= 0 && i <= i2 && i2 <= r());
        this.j = o64Var;
        B(i, i2);
        return i();
    }

    public final void B(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVar = (c) this.b.remove(i3);
            this.d.remove(cVar.b);
            g(i3, -cVar.a.c0().v());
            cVar.e = true;
            if (this.k) {
                u(cVar);
            }
        }
    }

    public no4 C(List list, o64 o64Var) {
        B(0, this.b.size());
        return f(this.b.size(), list, o64Var);
    }

    public no4 D(o64 o64Var) {
        int iR = r();
        if (o64Var.getLength() != iR) {
            o64Var = o64Var.i().f(0, iR);
        }
        this.j = o64Var;
        return i();
    }

    public no4 E(int i, int i2, List list) {
        gg3.d(i >= 0 && i <= i2 && i2 <= r());
        gg3.d(list.size() == i2 - i);
        for (int i3 = i; i3 < i2; i3++) {
            ((c) this.b.get(i3)).a.q((fg2) list.get(i3 - i));
        }
        return i();
    }

    public no4 f(int i, List list, o64 o64Var) {
        if (!list.isEmpty()) {
            this.j = o64Var;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = (c) list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = (c) this.b.get(i2 - 1);
                    cVar.c(cVar2.d + cVar2.a.c0().v());
                } else {
                    cVar.c(0);
                }
                g(i2, cVar.a.c0().v());
                this.b.add(i2, cVar);
                this.d.put(cVar.b, cVar);
                if (this.k) {
                    x(cVar);
                    if (this.c.isEmpty()) {
                        this.g.add(cVar);
                    } else {
                        j(cVar);
                    }
                }
            }
        }
        return i();
    }

    public final void g(int i, int i2) {
        while (i < this.b.size()) {
            ((c) this.b.get(i)).d += i2;
            i++;
        }
    }

    public mi2 h(jq2.b bVar, j5 j5Var, long j) {
        Object objO = o(bVar.a);
        jq2.b bVarA = bVar.a(m(bVar.a));
        c cVar = (c) gg3.q((c) this.d.get(objO));
        l(cVar);
        cVar.c.add(bVarA);
        h52 h52VarD = cVar.a.d(bVarA, j5Var, j);
        this.c.put(h52VarD, cVar);
        k();
        return h52VarD;
    }

    public no4 i() {
        if (this.b.isEmpty()) {
            return no4.a;
        }
        int iV = 0;
        for (int i = 0; i < this.b.size(); i++) {
            c cVar = (c) this.b.get(i);
            cVar.d = iV;
            iV += cVar.a.c0().v();
        }
        return new bf3(this.b, this.j);
    }

    public final void j(c cVar) {
        b bVar = (b) this.f.get(cVar);
        if (bVar != null) {
            bVar.a.h(bVar.b);
        }
    }

    public final void k() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.c.isEmpty()) {
                j(cVar);
                it.remove();
            }
        }
    }

    public final void l(c cVar) {
        this.g.add(cVar);
        b bVar = (b) this.f.get(cVar);
        if (bVar != null) {
            bVar.a.u(bVar.b);
        }
    }

    public o64 q() {
        return this.j;
    }

    public int r() {
        return this.b.size();
    }

    public boolean t() {
        return this.k;
    }

    public final void u(c cVar) {
        if (cVar.e && cVar.c.isEmpty()) {
            b bVar = (b) gg3.q((b) this.f.remove(cVar));
            bVar.a.k(bVar.b);
            bVar.a.c(bVar.c);
            bVar.a.g(bVar.c);
            this.g.remove(cVar);
        }
    }

    public no4 v(int i, int i2, int i3, o64 o64Var) {
        gg3.d(i >= 0 && i <= i2 && i2 <= r() && i3 >= 0);
        this.j = o64Var;
        if (i == i2 || i == i3) {
            return i();
        }
        int iMin = Math.min(i, i3);
        int iMax = Math.max(((i2 - i) + i3) - 1, i2 - 1);
        int iV = ((c) this.b.get(iMin)).d;
        fy4.b1(this.b, i, i2, i3);
        while (iMin <= iMax) {
            c cVar = (c) this.b.get(iMin);
            cVar.d = iV;
            iV += cVar.a.c0().v();
            iMin++;
        }
        return i();
    }

    public void w(hs4 hs4Var) {
        gg3.v(!this.k);
        this.l = hs4Var;
        for (int i = 0; i < this.b.size(); i++) {
            c cVar = (c) this.b.get(i);
            x(cVar);
            this.g.add(cVar);
        }
        this.k = true;
    }

    public final void x(c cVar) {
        i52 i52Var = cVar.a;
        jq2.c cVar2 = new jq2.c() { // from class: vq2
            @Override // jq2.c
            public final void a(jq2 jq2Var, no4 no4Var) {
                this.a.e.f();
            }
        };
        a aVar = new a(cVar);
        this.f.put(cVar, new b(i52Var, cVar2, aVar));
        i52Var.b(fy4.G(), aVar);
        i52Var.e(fy4.G(), aVar);
        i52Var.f(cVar2, this.l, this.a);
    }

    public void y() {
        for (b bVar : this.f.values()) {
            try {
                bVar.a.k(bVar.b);
            } catch (RuntimeException e) {
                xz1.e("MediaSourceList", "Failed to release child source.", e);
            }
            bVar.a.c(bVar.c);
            bVar.a.g(bVar.c);
        }
        this.f.clear();
        this.g.clear();
        this.k = false;
    }

    public void z(mi2 mi2Var) {
        c cVar = (c) gg3.q((c) this.c.remove(mi2Var));
        cVar.a.s(mi2Var);
        cVar.c.remove(((h52) mi2Var).f);
        if (!this.c.isEmpty()) {
            k();
        }
        u(cVar);
    }
}
