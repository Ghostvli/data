package defpackage;

import defpackage.t41;
import defpackage.wt4;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class aq0 implements cr0 {
    public final List a;
    public final String b;
    public final gr4[] c;
    public boolean d;
    public int e;
    public int f;
    public long g = -9223372036854775807L;

    public aq0(List list, String str) {
        this.a = list;
        this.b = str;
        this.c = new gr4[list.size()];
    }

    @Override // defpackage.cr0
    public void a(r73 r73Var) {
        if (this.d) {
            if (this.e != 2 || b(r73Var, 32)) {
                if (this.e != 1 || b(r73Var, 0)) {
                    int iG = r73Var.g();
                    int iA = r73Var.a();
                    for (gr4 gr4Var : this.c) {
                        r73Var.f0(iG);
                        gr4Var.a(r73Var, iA);
                    }
                    this.f += iA;
                }
            }
        }
    }

    public final boolean b(r73 r73Var, int i) {
        if (r73Var.a() == 0) {
            return false;
        }
        if (r73Var.Q() != i) {
            this.d = false;
        }
        this.e--;
        return this.d;
    }

    @Override // defpackage.cr0
    public void c() {
        this.d = false;
        this.g = -9223372036854775807L;
    }

    @Override // defpackage.cr0
    public void d(boolean z) {
        if (this.d) {
            gg3.v(this.g != -9223372036854775807L);
            for (gr4 gr4Var : this.c) {
                gr4Var.b(this.g, 1, this.f, 0, null);
            }
            this.d = false;
        }
    }

    @Override // defpackage.cr0
    public void e(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.d = true;
        this.g = j;
        this.f = 0;
        this.e = 2;
    }

    @Override // defpackage.cr0
    public void f(mz0 mz0Var, wt4.d dVar) {
        for (int i = 0; i < this.c.length; i++) {
            wt4.a aVar = (wt4.a) this.a.get(i);
            dVar.a();
            gr4 gr4VarE = mz0Var.e(dVar.c(), 3);
            gr4VarE.g(new t41.b().k0(dVar.b()).X(this.b).A0("application/dvbsubs").l0(Collections.singletonList(aVar.c)).o0(aVar.a).Q());
            this.c[i] = gr4VarE;
        }
    }
}
