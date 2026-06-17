package defpackage;

import defpackage.dh1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class f90 {
    public e a = null;
    public e b = null;
    public e c = null;
    public e d = null;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends d {
        public a d;
        public e90 e;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends dh1.b {
            public fh1 a;
            public int b = 0;
            public ih c = null;
            public ih d = null;
            public ih e = null;
            public boolean f = false;
            public float g;

            public a() {
            }

            @Override // dh1.b
            public void c() {
                this.b = 0;
                this.d = null;
                this.c = null;
                this.f = false;
            }

            @Override // dh1.b
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(ih ihVar) {
                if (b.this.b) {
                    return 1;
                }
                this.b++;
                if (ihVar == this.e) {
                    this.c = null;
                    this.f = false;
                    return 1;
                }
                if (this.d == null) {
                    this.d = ihVar;
                    if (ihVar.d() != this.a.a()) {
                        return 1;
                    }
                }
                if (this.g < this.a.o()) {
                    this.c = null;
                    return 1;
                }
                fh1 fh1Var = this.a;
                ih ihVar2 = this.e;
                boolean zH = d90.h(fh1Var, ihVar, ihVar2, ihVar2.f(), this.e.k().a);
                this.f = zH;
                if (zH) {
                    this.g = (ihVar.l() - this.a.j()) - this.e.p;
                    return 0;
                }
                this.c = ihVar;
                return 1;
            }

            @Override // dh1.b
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public f d() {
                f fVar = new f();
                fVar.a = this.b;
                fVar.c = this.d;
                fVar.f = this.c;
                fVar.i = this.f;
                return fVar;
            }
        }

        public b() {
            super();
            this.d = new a();
            this.e = new e90(2);
        }

        @Override // f90.c, f90.e
        public void a(ih ihVar, fh1 fh1Var, g gVar) {
            fh1 fh1Var2;
            boolean z;
            boolean z2;
            ih ihVar2;
            int i;
            if (ihVar.s()) {
                return;
            }
            boolean zV = ihVar.v();
            float fL = zV ? ihVar.l() : -1.0f;
            int i2 = 1;
            boolean z3 = false;
            boolean z4 = (zV || this.e.isEmpty()) ? false : true;
            if (fL < fh1Var.o()) {
                fL = fh1Var.a() - ihVar.p;
            }
            ih ihVar3 = null;
            if (zV) {
                fh1Var2 = fh1Var;
                i2 = 0;
            } else {
                this.b = false;
                a aVar = this.d;
                aVar.g = fL;
                aVar.a = fh1Var;
                aVar.e = ihVar;
                this.e.g(aVar);
                f fVarD = this.d.d();
                float f = this.d.g;
                if (fVarD != null) {
                    int i3 = fVarD.a;
                    ihVar3 = fVarD.c;
                    ih ihVar4 = fVarD.f;
                    boolean z5 = fVarD.h;
                    z2 = fVarD.i;
                    ihVar2 = ihVar4;
                    z = z5;
                    i = i3;
                } else {
                    z = zV;
                    z2 = z4;
                    ihVar2 = null;
                    i = 0;
                }
                boolean zB = b(false, ihVar, fh1Var, f, ihVar3, null);
                fh1Var2 = fh1Var;
                if (zB) {
                    z3 = zB;
                    z4 = true;
                    ihVar3 = ihVar2;
                    fL = fh1Var2.a() - ihVar.p;
                } else {
                    boolean z6 = f >= ((float) fh1Var2.o()) ? false : z2;
                    if (ihVar2 != null) {
                        z3 = zB;
                        fL = f;
                        z4 = z6;
                        ihVar3 = ihVar2;
                        i2 = i - 1;
                    } else {
                        z3 = zB;
                        fL = f;
                        z4 = z6;
                        i2 = i;
                        zV = z;
                        ihVar3 = ihVar2;
                    }
                }
                zV = z;
            }
            if (gVar == null || !gVar.a(ihVar, fL, i2, z4)) {
                if (z3) {
                    clear();
                }
                ihVar.y(fh1Var2, ihVar.g(), fL);
                if (zV) {
                    return;
                }
                this.e.f(ihVar3);
                this.e.c(ihVar);
            }
        }

        @Override // f90.d, f90.c
        public boolean b(boolean z, ih ihVar, fh1 fh1Var, float f, ih ihVar2, ih ihVar3) {
            if (f >= fh1Var.o()) {
                return (ihVar2 == null || ihVar2.d() == ((float) fh1Var.a())) ? false : true;
            }
            return true;
        }

        @Override // f90.c, f90.e
        public void clear() {
            this.b = true;
            this.e.clear();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements e {
        public e90 a;
        public boolean b;
        public a c;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends dh1.b {
            public fh1 a;
            public int b = 0;
            public ih c = null;
            public ih d = null;
            public ih e = null;
            public ih f = null;
            public ih g = null;
            public boolean h = false;
            public boolean i = false;
            public boolean j = false;

            public a() {
            }

            @Override // dh1.b
            public void c() {
                this.b = 0;
                this.f = null;
                this.e = null;
                this.d = null;
                this.c = null;
                this.j = false;
                this.i = false;
                this.h = false;
            }

            @Override // dh1.b
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(ih ihVar) {
                if (c.this.b) {
                    return 1;
                }
                this.b++;
                ih ihVar2 = this.g;
                if (ihVar == ihVar2) {
                    this.c = ihVar;
                    this.e = null;
                    this.i = true;
                    this.j = false;
                    return 1;
                }
                if (this.d == null) {
                    this.d = ihVar;
                }
                if (ihVar2.p + ihVar.l() > this.a.a()) {
                    this.h = true;
                    return 1;
                }
                ih ihVar3 = this.f;
                if (ihVar3 == null || ihVar3.i() >= ihVar.i()) {
                    this.f = ihVar;
                }
                fh1 fh1Var = this.a;
                ih ihVar4 = this.g;
                boolean zH = d90.h(fh1Var, ihVar, ihVar4, ihVar4.f(), this.g.k().a);
                this.j = zH;
                if (zH) {
                    this.e = ihVar;
                    return 0;
                }
                this.c = ihVar;
                return 1;
            }

            @Override // dh1.b
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public f d() {
                f fVar = new f();
                fVar.a = this.b;
                fVar.c = this.d;
                fVar.b = this.c;
                fVar.d = this.e;
                fVar.e = this.f;
                fVar.g = this.h;
                fVar.h = this.i;
                fVar.i = this.j;
                return fVar;
            }
        }

        public c() {
            this.a = new e90(1);
            this.b = false;
            this.c = new a();
        }

        @Override // f90.e
        public void a(ih ihVar, fh1 fh1Var, g gVar) {
            boolean z;
            boolean z2;
            int i;
            boolean z3;
            ih ihVar2;
            ih ihVar3;
            ih ihVar4;
            ih ihVar5;
            float fO;
            boolean z4;
            boolean z5;
            ih ihVar6;
            boolean z6;
            float fD;
            if (ihVar.s()) {
                return;
            }
            float fO2 = fh1Var.o();
            boolean zV = ihVar.v();
            int i2 = 1;
            int i3 = 0;
            boolean z7 = (zV || this.a.isEmpty()) ? false : true;
            int iJ = fh1Var.j();
            ih ihVar7 = null;
            if (zV) {
                z = false;
            } else {
                this.b = false;
                a aVar = this.c;
                aVar.a = fh1Var;
                aVar.g = ihVar;
                this.a.g(aVar);
                f fVarD = this.c.d();
                if (fVarD != null) {
                    int i4 = fVarD.a;
                    ihVar2 = fVarD.b;
                    ih ihVar8 = fVarD.c;
                    ih ihVar9 = fVarD.d;
                    ih ihVar10 = fVarD.e;
                    boolean z8 = fVarD.g;
                    boolean z9 = fVarD.h;
                    z2 = fVarD.i;
                    i = i4;
                    zV = z9;
                    z3 = z8;
                    ihVar5 = ihVar10;
                    ihVar4 = ihVar9;
                    ihVar3 = ihVar8;
                } else {
                    z2 = z7;
                    i = 0;
                    z3 = false;
                    ihVar2 = null;
                    ihVar3 = null;
                    ihVar4 = null;
                    ihVar5 = null;
                }
                if (ihVar2 != null) {
                    fO = ihVar4 != null ? ihVar4.d() + iJ : ihVar2.l();
                    if (ihVar2 != ihVar) {
                        z4 = z2;
                        ihVar6 = ihVar2;
                        z5 = true;
                        fD = fO;
                        z6 = false;
                    }
                    float f = fO;
                    z6 = zV;
                    fD = f;
                    ihVar6 = null;
                    z4 = z2;
                    z5 = true;
                } else if (z3 && ihVar5 != null) {
                    ihVar6 = null;
                    fD = ihVar5.l();
                    z4 = z2;
                    z5 = false;
                    z6 = false;
                } else if (ihVar4 != null) {
                    z6 = zV;
                    fD = ihVar4.d() + iJ;
                    z5 = true;
                    ihVar6 = null;
                    z4 = false;
                } else if (ihVar3 != null) {
                    fO = ihVar3.l();
                    z4 = z2;
                    z5 = true;
                    ihVar6 = ihVar3;
                    fD = fO;
                    z6 = false;
                } else {
                    fO = fh1Var.o();
                    float f2 = fO;
                    z6 = zV;
                    fD = f2;
                    ihVar6 = null;
                    z4 = z2;
                    z5 = true;
                }
                boolean zB = z5 ? b(z3, ihVar, fh1Var, fD, ihVar3, ihVar4) : false;
                if (zB) {
                    fD = fh1Var.o();
                    z4 = true;
                } else {
                    i2 = ihVar6 != null ? i - 1 : i;
                }
                z = zB;
                fO2 = fD;
                if (fD == fh1Var.o()) {
                    zV = false;
                    z7 = z4;
                    ihVar7 = ihVar6;
                    i3 = i2;
                } else {
                    i3 = i2;
                    z7 = z4;
                    zV = z6;
                    ihVar7 = ihVar6;
                }
            }
            if (gVar == null || !gVar.a(ihVar, fO2, i3, z7)) {
                if (z) {
                    clear();
                }
                ihVar.y(fh1Var, ihVar.g(), fO2);
                if (zV) {
                    return;
                }
                this.a.f(ihVar7);
                this.a.c(ihVar);
            }
        }

        public boolean b(boolean z, ih ihVar, fh1 fh1Var, float f, ih ihVar2, ih ihVar3) {
            if (f >= fh1Var.o()) {
                return (ihVar2 != null && ihVar2.l() > 0.0f) || f + ihVar.p > ((float) fh1Var.a());
            }
            return true;
        }

        @Override // f90.e
        public void clear() {
            this.b = true;
            this.a.clear();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends c {
        public d() {
            super();
        }

        @Override // f90.c
        public boolean b(boolean z, ih ihVar, fh1 fh1Var, float f, ih ihVar2, ih ihVar3) {
            return f + ihVar.p > ((float) fh1Var.a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        void a(ih ihVar, fh1 fh1Var, g gVar);

        void clear();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f {
        public int a;
        public ih b;
        public ih c;
        public ih d;
        public ih e;
        public ih f;
        public boolean g;
        public boolean h;
        public boolean i;

        public f() {
            this.a = 0;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = false;
            this.h = false;
            this.i = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface g {
        boolean a(ih ihVar, float f, int i, boolean z);
    }

    public f90(boolean z) {
        a(z);
    }

    public void a(boolean z) {
        this.a = z ? new b() : new c();
        this.b = z ? new b() : new c();
        if (this.c == null) {
            this.c = new d();
        }
        if (this.d == null) {
            this.d = new b();
        }
    }

    public void b() {
        e eVar = this.a;
        if (eVar != null) {
            eVar.clear();
        }
        e eVar2 = this.b;
        if (eVar2 != null) {
            eVar2.clear();
        }
        e eVar3 = this.c;
        if (eVar3 != null) {
            eVar3.clear();
        }
        e eVar4 = this.d;
        if (eVar4 != null) {
            eVar4.clear();
        }
    }

    public void c(ih ihVar, fh1 fh1Var, g gVar) {
        int iM = ihVar.m();
        if (iM == 1) {
            this.a.a(ihVar, fh1Var, gVar);
            return;
        }
        if (iM == 4) {
            this.d.a(ihVar, fh1Var, gVar);
            return;
        }
        if (iM == 5) {
            this.c.a(ihVar, fh1Var, gVar);
        } else if (iM == 6) {
            this.b.a(ihVar, fh1Var, gVar);
        } else {
            if (iM != 7) {
                return;
            }
            ihVar.y(fh1Var, 0.0f, 0.0f);
        }
    }

    public void d() {
        b();
    }
}
