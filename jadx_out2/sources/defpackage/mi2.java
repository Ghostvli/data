package defpackage;

import androidx.media3.exoplayer.j;
import defpackage.i14;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface mi2 extends i14 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a extends i14.a {
        void e(mi2 mi2Var);
    }

    @Override // defpackage.i14
    boolean b(j jVar);

    @Override // defpackage.i14
    long c();

    long d(long j, zz3 zz3Var);

    @Override // defpackage.i14
    long f();

    @Override // defpackage.i14
    void g(long j);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    default long h(long j) {
        return Long.MIN_VALUE;
    }

    @Override // defpackage.i14
    boolean isLoading();

    long k(jy0[] jy0VarArr, boolean[] zArr, gx3[] gx3VarArr, boolean[] zArr2, long j);

    void m();

    long n(long j);

    long q();

    void r(a aVar, long j);

    er4 s();

    void t(long j, boolean z);
}
