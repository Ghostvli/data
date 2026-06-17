package defpackage;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class eo implements jk {
    public final jk a;
    public b b;

    public eo(jk jkVar) {
        this.a = jkVar;
    }

    @Override // defpackage.jk
    public lu1 a(Uri uri) {
        b bVar = this.b;
        if (bVar != null && bVar.g(uri)) {
            return this.b.e();
        }
        lu1 lu1VarA = this.a.a(uri);
        this.b = new b(uri, lu1VarA);
        return lu1VarA;
    }

    @Override // defpackage.jk
    public lu1 b(ph2 ph2Var) {
        b bVar = this.b;
        if (bVar != null && bVar.f(ph2Var)) {
            return this.b.e();
        }
        lu1 lu1VarB = this.a.b(ph2Var);
        if (lu1VarB == null) {
            return null;
        }
        this.b = new b(ph2Var, lu1VarB);
        return lu1VarB;
    }

    @Override // defpackage.jk
    public lu1 c(byte[] bArr) {
        b bVar = this.b;
        if (bVar != null && bVar.h(bArr)) {
            return this.b.e();
        }
        lu1 lu1VarC = this.a.c(bArr);
        this.b = new b(bArr, lu1VarC);
        return lu1VarC;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final byte[] a;
        public final Uri b;
        public final lu1 c;

        public b(ph2 ph2Var, lu1 lu1Var) {
            this.a = ph2Var.k;
            this.b = ph2Var.n;
            this.c = lu1Var;
        }

        public final lu1 e() {
            return (lu1) gg3.q(this.c);
        }

        public final boolean f(ph2 ph2Var) {
            Uri uri = this.b;
            if (uri != null && uri.equals(ph2Var.n)) {
                return true;
            }
            byte[] bArr = this.a;
            return bArr != null && Arrays.equals(bArr, ph2Var.k);
        }

        public final boolean g(Uri uri) {
            Uri uri2 = this.b;
            return uri2 != null && uri2.equals(uri);
        }

        public final boolean h(byte[] bArr) {
            byte[] bArr2 = this.a;
            return bArr2 != null && Arrays.equals(bArr2, bArr);
        }

        public b(byte[] bArr, lu1 lu1Var) {
            this.a = bArr;
            this.b = null;
            this.c = lu1Var;
        }

        public b(Uri uri, lu1 lu1Var) {
            this.a = null;
            this.b = uri;
            this.c = lu1Var;
        }
    }
}
