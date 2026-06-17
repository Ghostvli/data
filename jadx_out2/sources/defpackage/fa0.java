package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import defpackage.aa0;
import defpackage.ye0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fa0 implements jk {
    public static final xi4 f = zi4.a(new xi4() { // from class: ca0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.xi4
        public final Object get() {
            return du2.c(Executors.newSingleThreadExecutor());
        }
    });
    public final qu1 a;
    public final aa0.a b;
    public final BitmapFactory.Options c;
    public final int d;
    public final boolean e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final Context a;
        public qu1 b;
        public aa0.a c;
        public BitmapFactory.Options d;
        public int e = -1;
        public boolean f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Context context) {
            this.a = context;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public fa0 g() {
            return new fa0(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b h(boolean z) {
            this.f = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b i(int i) {
            this.e = i;
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fa0(b bVar) {
        this.b = bVar.c != null ? bVar.c : new ye0.a(bVar.a);
        this.a = bVar.b != null ? bVar.b : (qu1) gg3.q((qu1) f.get());
        this.c = bVar.d;
        this.d = bVar.e;
        this.e = bVar.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Bitmap g(aa0 aa0Var, Uri uri, BitmapFactory.Options options, int i, boolean z) {
        try {
            aa0Var.a(new ja0(uri));
            byte[] bArrB = ia0.b(aa0Var);
            return h(z, ok.a(bArrB, bArrB.length, options, i));
        } finally {
            aa0Var.close();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Bitmap h(boolean z, Bitmap bitmap) {
        return z ? ok.b(bitmap) : bitmap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jk
    public lu1 a(final Uri uri) {
        return this.a.submit(new Callable() { // from class: ea0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                fa0 fa0Var = this.a;
                return fa0.g(fa0Var.b.b(), uri, fa0Var.c, fa0Var.d, fa0Var.e);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.jk
    public lu1 c(final byte[] bArr) {
        return this.a.submit(new Callable() { // from class: da0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                fa0 fa0Var = this.a;
                byte[] bArr2 = bArr;
                return fa0.h(fa0Var.e, ok.a(bArr2, bArr2.length, fa0Var.c, fa0Var.d));
            }
        });
    }
}
