package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import defpackage.ct2;
import defpackage.dt2;
import defpackage.gq4;
import defpackage.hg3;
import defpackage.jv4;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public final ct2 a;
    public final char[] b;
    public final a c = new a(1024);
    public final Typeface d;

    public f(Typeface typeface, ct2 ct2Var) {
        this.d = typeface;
        this.a = ct2Var;
        this.b = new char[ct2Var.k() * 2];
        a(ct2Var);
    }

    public static f b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            gq4.a("EmojiCompat.MetadataRepo.create");
            return new f(typeface, dt2.b(byteBuffer));
        } finally {
            gq4.b();
        }
    }

    public final void a(ct2 ct2Var) {
        int iK = ct2Var.k();
        for (int i = 0; i < iK; i++) {
            jv4 jv4Var = new jv4(this, i);
            Character.toChars(jv4Var.f(), this.b, i * 2);
            h(jv4Var);
        }
    }

    public char[] c() {
        return this.b;
    }

    public ct2 d() {
        return this.a;
    }

    public int e() {
        return this.a.l();
    }

    public a f() {
        return this.c;
    }

    public Typeface g() {
        return this.d;
    }

    public void h(jv4 jv4Var) {
        hg3.h(jv4Var, "emoji metadata cannot be null");
        hg3.b(jv4Var.c() > 0, "invalid metadata codepoint length");
        this.c.c(jv4Var, 0, jv4Var.c() - 1);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final SparseArray a;
        public jv4 b;

        public a(int i) {
            this.a = new SparseArray(i);
        }

        public a a(int i) {
            SparseArray sparseArray = this.a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i);
        }

        public final jv4 b() {
            return this.b;
        }

        public void c(jv4 jv4Var, int i, int i2) {
            a aVarA = a(jv4Var.b(i));
            if (aVarA == null) {
                aVarA = new a();
                this.a.put(jv4Var.b(i), aVarA);
            }
            if (i2 > i) {
                aVarA.c(jv4Var, i + 1, i2);
            } else {
                aVarA.b = jv4Var;
            }
        }

        public a() {
            this(1);
        }
    }
}
