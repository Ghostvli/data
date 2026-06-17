package defpackage;

import android.content.Context;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.rtsp.RtspMediaSource;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import defpackage.aa0;
import defpackage.dz0;
import defpackage.fg2;
import defpackage.jq2;
import defpackage.ki4;
import defpackage.m74;
import defpackage.t41;
import defpackage.ug0;
import defpackage.xh3;
import defpackage.xu;
import defpackage.ye0;
import defpackage.yz3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ug0 implements sq2 {
    public final a c;
    public aa0.a d;
    public ki4.a e;
    public jq2.a f;
    public sy1 g;
    public long h;
    public long i;
    public long j;
    public float k;
    public float l;
    public boolean m;
    public boolean n;
    public boolean o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final pz0 a;
        public aa0.a d;
        public ki4.a f;
        public boolean h;
        public zo0 i;
        public sy1 j;
        public xi4 k;
        public final Map b = new HashMap();
        public final Map c = new HashMap();
        public boolean e = true;
        public int g = 3;

        public a(pz0 pz0Var, ki4.a aVar) {
            this.a = pz0Var;
            this.f = aVar;
        }

        public static /* synthetic */ jq2.a c(a aVar, aa0.a aVar2) {
            aVar.getClass();
            return new xh3.b(aVar2, aVar.a).m(aVar.h);
        }

        public jq2.a g(int i) {
            jq2.a aVar = (jq2.a) this.c.get(Integer.valueOf(i));
            if (aVar != null) {
                return aVar;
            }
            jq2.a aVar2 = (jq2.a) h(i).get();
            zo0 zo0Var = this.i;
            if (zo0Var != null) {
                aVar2.f(zo0Var);
            }
            sy1 sy1Var = this.j;
            if (sy1Var != null) {
                aVar2.g(sy1Var);
            }
            xi4 xi4Var = this.k;
            if (xi4Var != null) {
                aVar2.d(xi4Var);
            }
            aVar2.a(this.f);
            aVar2.b(this.e);
            aVar2.c(this.g);
            this.c.put(Integer.valueOf(i), aVar2);
            return aVar2;
        }

        public final xi4 h(int i) {
            xi4 xi4Var;
            xi4 xi4Var2;
            xi4 xi4Var3 = (xi4) this.b.get(Integer.valueOf(i));
            if (xi4Var3 != null) {
                return xi4Var3;
            }
            final aa0.a aVar = (aa0.a) gg3.q(this.d);
            if (i == 0) {
                int i2 = DashMediaSource.Factory.l;
                final Class clsAsSubclass = DashMediaSource.Factory.class.asSubclass(jq2.a.class);
                xi4Var = new xi4() { // from class: pg0
                    @Override // defpackage.xi4
                    public final Object get() {
                        return ug0.p(clsAsSubclass, aVar);
                    }
                };
            } else if (i == 1) {
                int i3 = SsMediaSource.Factory.k;
                final Class clsAsSubclass2 = SsMediaSource.Factory.class.asSubclass(jq2.a.class);
                xi4Var = new xi4() { // from class: qg0
                    @Override // defpackage.xi4
                    public final Object get() {
                        return ug0.p(clsAsSubclass2, aVar);
                    }
                };
            } else {
                if (i != 2) {
                    if (i == 3) {
                        int i4 = RtspMediaSource.Factory.h;
                        final Class clsAsSubclass3 = RtspMediaSource.Factory.class.asSubclass(jq2.a.class);
                        xi4Var2 = new xi4() { // from class: sg0
                            @Override // defpackage.xi4
                            public final Object get() {
                                return ug0.o(clsAsSubclass3);
                            }
                        };
                    } else {
                        if (i != 4) {
                            defpackage.b.a("Unrecognized contentType: ", i);
                            return null;
                        }
                        xi4Var2 = new xi4() { // from class: tg0
                            @Override // defpackage.xi4
                            public final Object get() {
                                return ug0.a.c(this.f, aVar);
                            }
                        };
                    }
                    this.b.put(Integer.valueOf(i), xi4Var2);
                    return xi4Var2;
                }
                int i5 = HlsMediaSource.Factory.s;
                final Class clsAsSubclass4 = HlsMediaSource.Factory.class.asSubclass(jq2.a.class);
                xi4Var = new xi4() { // from class: rg0
                    @Override // defpackage.xi4
                    public final Object get() {
                        return ug0.p(clsAsSubclass4, aVar);
                    }
                };
            }
            xi4Var2 = xi4Var;
            this.b.put(Integer.valueOf(i), xi4Var2);
            return xi4Var2;
        }

        public void i(int i) {
            this.g = i;
            this.a.c(i);
        }

        public void j(aa0.a aVar) {
            if (aVar != this.d) {
                this.d = aVar;
                this.b.clear();
                this.c.clear();
            }
        }

        public void k(xi4 xi4Var) {
            this.k = xi4Var;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                ((jq2.a) it.next()).d(xi4Var);
            }
        }

        public void l(zo0 zo0Var) {
            this.i = zo0Var;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                ((jq2.a) it.next()).f(zo0Var);
            }
        }

        public final void m(int i) {
            pz0 pz0Var = this.a;
            if (pz0Var instanceof vf0) {
                ((vf0) pz0Var).n(i);
            }
        }

        public void n(int i) {
            pz0 pz0Var = this.a;
            if (pz0Var instanceof vf0) {
                ((vf0) pz0Var).o(i);
            }
        }

        public void o(sy1 sy1Var) {
            this.j = sy1Var;
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                ((jq2.a) it.next()).g(sy1Var);
            }
        }

        public void p(boolean z) {
            this.e = z;
            this.a.e(z);
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                ((jq2.a) it.next()).b(z);
            }
        }

        public void q(ki4.a aVar) {
            this.f = aVar;
            this.a.a(aVar);
            Iterator it = this.c.values().iterator();
            while (it.hasNext()) {
                ((jq2.a) it.next()).a(aVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements hz0 {
        public final t41 a;

        public b(t41 t41Var) {
            this.a = t41Var;
        }

        @Override // defpackage.hz0
        public void a(long j, long j2) {
        }

        @Override // defpackage.hz0
        public void b(mz0 mz0Var) {
            gr4 gr4VarE = mz0Var.e(0, 3);
            mz0Var.u(new yz3.b(-9223372036854775807L));
            mz0Var.o();
            gr4VarE.g(this.a.b().A0("text/x-unknown").V(this.a.p).Q());
        }

        @Override // defpackage.hz0
        public int d(jz0 jz0Var, yf3 yf3Var) {
            return jz0Var.b(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        @Override // defpackage.hz0
        public boolean e(jz0 jz0Var) {
            return true;
        }

        @Override // defpackage.hz0
        public void release() {
        }
    }

    public ug0(aa0.a aVar, pz0 pz0Var, ki4.a aVar2) {
        this.d = aVar;
        this.e = aVar2;
        a aVar3 = new a(pz0Var, aVar2);
        this.c = aVar3;
        aVar3.j(aVar);
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.j = -9223372036854775807L;
        this.k = -3.4028235E38f;
        this.l = -3.4028235E38f;
        this.m = true;
    }

    public static /* synthetic */ hz0[] h(ug0 ug0Var, t41 t41Var) {
        return new hz0[]{ug0Var.e.a(t41Var) ? new fi4(ug0Var.e.b(t41Var), null) : new b(t41Var)};
    }

    public static jq2 m(fg2 fg2Var, jq2 jq2Var, boolean z) {
        fg2.d dVar = fg2Var.f;
        return (dVar.b == 0 && dVar.d == Long.MIN_VALUE && !dVar.f) ? jq2Var : new xu.b(jq2Var).p(fg2Var.f.b).n(fg2Var.f.d).m(!fg2Var.f.g).j(fg2Var.f.e).o(fg2Var.f.f).k(fg2Var.f.h).l(z).i();
    }

    public static jq2.a o(Class cls) {
        try {
            return (jq2.a) cls.getConstructor(null).newInstance(null);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static jq2.a p(Class cls, aa0.a aVar) {
        try {
            return (jq2.a) cls.getConstructor(aa0.a.class).newInstance(aVar);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // jq2.a
    public jq2.a d(xi4 xi4Var) {
        this.c.k(xi4Var);
        return this;
    }

    @Override // jq2.a
    public jq2 e(fg2 fg2Var) {
        gg3.q(fg2Var.b);
        String scheme = fg2Var.b.a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((jq2.a) gg3.q(this.f)).e(fg2Var);
        }
        boolean zEquals = Objects.equals(fg2Var.b.b, "application/x-image-uri");
        fg2.h hVar = fg2Var.b;
        if (zEquals) {
            long jC1 = fy4.c1(hVar.j);
            w82.a(gg3.q(null));
            return new dz0.b(jC1, null).e(fg2Var);
        }
        int iL0 = fy4.L0(hVar.a, hVar.b);
        if (fg2Var.b.j != -9223372036854775807L) {
            this.c.n(1);
            this.c.m(1);
        }
        try {
            jq2.a aVarG = this.c.g(iL0);
            fg2.g.a aVarA = fg2Var.d.a();
            if (fg2Var.d.a == -9223372036854775807L) {
                aVarA.k(this.h);
            }
            if (fg2Var.d.d == -3.4028235E38f) {
                aVarA.j(this.k);
            }
            if (fg2Var.d.e == -3.4028235E38f) {
                aVarA.h(this.l);
            }
            if (fg2Var.d.b == -9223372036854775807L) {
                aVarA.i(this.i);
            }
            if (fg2Var.d.c == -9223372036854775807L) {
                aVarA.g(this.j);
            }
            fg2.g gVarF = aVarA.f();
            if (!gVarF.equals(fg2Var.d)) {
                fg2Var = fg2Var.a().d(gVarF).a();
            }
            jq2 jq2VarE = aVarG.e(fg2Var);
            xi1 xi1Var = ((fg2.h) fy4.l(fg2Var.b)).g;
            if (!xi1Var.isEmpty()) {
                jq2[] jq2VarArr = new jq2[xi1Var.size() + 1];
                jq2VarArr[0] = jq2VarE;
                for (int i = 0; i < xi1Var.size(); i++) {
                    if (this.m) {
                        final t41 t41VarQ = new t41.b().A0(((fg2.k) xi1Var.get(i)).b).o0(((fg2.k) xi1Var.get(i)).c).C0(((fg2.k) xi1Var.get(i)).d).y0(((fg2.k) xi1Var.get(i)).e).m0(((fg2.k) xi1Var.get(i)).f).k0(((fg2.k) xi1Var.get(i)).g).Q();
                        xh3.b bVar = new xh3.b(this.d, new pz0() { // from class: og0
                            @Override // defpackage.pz0
                            public final hz0[] d() {
                                return ug0.h(this.b, t41VarQ);
                            }
                        });
                        if (this.e.a(t41VarQ)) {
                            t41VarQ = t41VarQ.b().A0("application/x-media3-cues").V(t41VarQ.p).Z(this.e.c(t41VarQ)).Q();
                        }
                        xh3.b bVarM = bVar.j(0, t41VarQ).m(this.n);
                        sy1 sy1Var = this.g;
                        if (sy1Var != null) {
                            bVarM.g(sy1Var);
                        }
                        jq2VarArr[i + 1] = bVarM.e(fg2.d(((fg2.k) xi1Var.get(i)).a.toString()));
                    } else {
                        m74.b bVar2 = new m74.b(this.d);
                        sy1 sy1Var2 = this.g;
                        if (sy1Var2 != null) {
                            bVar2.b(sy1Var2);
                        }
                        jq2VarArr[i + 1] = bVar2.a((fg2.k) xi1Var.get(i), -9223372036854775807L);
                    }
                }
                jq2VarE = new ns2(jq2VarArr);
            }
            return n(fg2Var, m(fg2Var, jq2VarE, this.o));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // jq2.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ug0 b(boolean z) {
        this.m = z;
        this.c.p(z);
        return this;
    }

    @Override // jq2.a
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public ug0 c(int i) {
        this.c.i(i);
        return this;
    }

    public final jq2 n(fg2 fg2Var, jq2 jq2Var) {
        gg3.q(fg2Var.b);
        if (fg2Var.b.d == null) {
            return jq2Var;
        }
        xz1.i("DMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
        return jq2Var;
    }

    @Override // jq2.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public ug0 f(zo0 zo0Var) {
        this.c.l((zo0) gg3.r(zo0Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @Override // jq2.a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public ug0 g(sy1 sy1Var) {
        this.g = (sy1) gg3.r(sy1Var, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.c.o(sy1Var);
        return this;
    }

    @Override // jq2.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public ug0 a(ki4.a aVar) {
        this.e = (ki4.a) gg3.q(aVar);
        this.c.q(aVar);
        return this;
    }

    public ug0(aa0.a aVar, pz0 pz0Var) {
        this(aVar, pz0Var, new qh0());
    }

    public ug0(Context context, pz0 pz0Var) {
        this(new ye0.a(context), pz0Var);
    }
}
