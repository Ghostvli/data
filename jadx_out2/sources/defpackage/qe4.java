package defpackage;

import android.graphics.Bitmap;
import defpackage.nn0;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class qe4 implements ds3 {
    public final nn0 a;
    public final ma b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements nn0.b {
        public final dp3 a;
        public final jv0 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(dp3 dp3Var, jv0 jv0Var) {
            this.a = dp3Var;
            this.b = jv0Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // nn0.b
        public void a() {
            this.a.c();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // nn0.b
        public void b(kk kkVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionA = this.b.a();
            if (iOExceptionA != null) {
                if (bitmap == null) {
                    throw iOExceptionA;
                }
                kkVar.c(bitmap);
                throw iOExceptionA;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qe4(nn0 nn0Var, ma maVar) {
        this.a = nn0Var;
        this.b = maVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/Object;IILu63;)Lyr3; */
    @Override // defpackage.ds3
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public yr3 b(InputStream inputStream, int i, int i2, u63 u63Var) {
        boolean z;
        dp3 dp3Var;
        if (inputStream instanceof dp3) {
            dp3Var = (dp3) inputStream;
            z = false;
        } else {
            z = true;
            dp3Var = new dp3(inputStream, this.b);
        }
        jv0 jv0VarC = jv0.c(dp3Var);
        try {
            yr3 yr3VarF = this.a.f(new a52(jv0VarC), i, i2, u63Var, new a(dp3Var, jv0VarC));
            jv0VarC.h();
            if (z) {
                dp3Var.h();
            }
            return yr3VarF;
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;Lu63;)Z */
    @Override // defpackage.ds3
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, u63 u63Var) {
        return this.a.p(inputStream);
    }
}
