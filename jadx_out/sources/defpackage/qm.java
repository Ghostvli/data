package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qm implements rh3 {
    public final pz0 a;
    public hz0 b;
    public jz0 c;

    public qm(pz0 pz0Var) {
        this.a = pz0Var;
    }

    @Override // defpackage.rh3
    public void a(long j, long j2) {
        ((hz0) gg3.q(this.b)).a(j, j2);
    }

    @Override // defpackage.rh3
    public long b() {
        jz0 jz0Var = this.c;
        if (jz0Var != null) {
            return jz0Var.getPosition();
        }
        return -1L;
    }

    @Override // defpackage.rh3
    public void c() {
        hz0 hz0Var = this.b;
        if (hz0Var == null) {
            return;
        }
        hz0 hz0VarC = hz0Var.c();
        if (hz0VarC instanceof pu2) {
            ((pu2) hz0VarC).m();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    @Override // defpackage.rh3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(defpackage.x90 r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, defpackage.mz0 r15) throws defpackage.tw4 {
        /*
            r7 = this;
            sf0 r1 = new sf0
            r2 = r8
            r3 = r11
            r5 = r13
            r1.<init>(r2, r3, r5)
            r7.c = r1
            hz0 r8 = r7.b
            if (r8 == 0) goto Lf
            return
        Lf:
            pz0 r8 = r7.a
            hz0[] r8 = r8.f(r9, r10)
            int r10 = r8.length
            xi1$a r10 = defpackage.xi1.n(r10)
            int r11 = r8.length
            r12 = 0
            r13 = 1
            if (r11 != r13) goto L25
            r8 = r8[r12]
            r7.b = r8
            goto L83
        L25:
            int r11 = r8.length
            r14 = r12
        L27:
            if (r14 >= r11) goto L7f
            r0 = r8[r14]
            boolean r2 = r0.e(r1)     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6f
            if (r2 == 0) goto L3d
            r7.b = r0     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6f
            defpackage.gg3.v(r13)
            r1.p()
            goto L7f
        L3a:
            r0 = move-exception
            r8 = r0
            goto L5b
        L3d:
            java.util.List r0 = r0.f()     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6f
            r10.j(r0)     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6f
            hz0 r0 = r7.b
            if (r0 != 0) goto L53
            long r5 = r1.getPosition()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L51
            goto L53
        L51:
            r0 = r12
            goto L54
        L53:
            r0 = r13
        L54:
            defpackage.gg3.v(r0)
            r1.p()
            goto L7c
        L5b:
            hz0 r7 = r7.b
            if (r7 != 0) goto L67
            long r9 = r1.getPosition()
            int r7 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r7 != 0) goto L68
        L67:
            r12 = r13
        L68:
            defpackage.gg3.v(r12)
            r1.p()
            throw r8
        L6f:
            hz0 r0 = r7.b
            if (r0 != 0) goto L53
            long r5 = r1.getPosition()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L51
            goto L53
        L7c:
            int r14 = r14 + 1
            goto L27
        L7f:
            hz0 r11 = r7.b
            if (r11 == 0) goto L89
        L83:
            hz0 r7 = r7.b
            r7.b(r15)
            return
        L89:
            tw4 r7 = new tw4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "None of the available extractors ("
            r11.<init>(r12)
            java.lang.String r12 = ", "
            wn1 r12 = defpackage.wn1.h(r12)
            xi1 r8 = defpackage.xi1.q(r8)
            pm r13 = new pm
            r13.<init>()
            java.util.List r8 = defpackage.ru1.i(r8, r13)
            java.lang.String r8 = r12.e(r8)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            java.lang.Object r9 = defpackage.gg3.q(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            xi1 r10 = r10.k()
            r7.<init>(r8, r9, r10)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qm.d(x90, android.net.Uri, java.util.Map, long, long, mz0):void");
    }

    @Override // defpackage.rh3
    public int e(yf3 yf3Var) {
        return ((hz0) gg3.q(this.b)).d((jz0) gg3.q(this.c), yf3Var);
    }

    @Override // defpackage.rh3
    public void release() {
        hz0 hz0Var = this.b;
        if (hz0Var != null) {
            hz0Var.release();
            this.b = null;
        }
        this.c = null;
    }
}
