package defpackage;

import android.os.Build;
import android.security.identity.IdentityCredential;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.x;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yj {
    public k61 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a {
        public void a(int i, CharSequence charSequence) {
        }

        public void b() {
        }

        public void c(b bVar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final c a;
        public final int b;

        public b(c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        public int a() {
            return this.b;
        }

        public c b() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final CharSequence a;
        public final CharSequence b;
        public final CharSequence c;
        public final CharSequence d;
        public final boolean e;
        public final boolean f;
        public final int g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a {
            public CharSequence a = null;
            public CharSequence b = null;
            public CharSequence c = null;
            public CharSequence d = null;
            public boolean e = true;
            public boolean f = false;
            public int g = 0;

            public d a() {
                if (TextUtils.isEmpty(this.a)) {
                    jl.a("Title must be set and non-empty.");
                    return null;
                }
                if (!me.e(this.g)) {
                    throw new IllegalArgumentException("Authenticator combination is unsupported on API " + Build.VERSION.SDK_INT + ": " + me.a(this.g));
                }
                int i = this.g;
                boolean zC = i != 0 ? me.c(i) : this.f;
                if (TextUtils.isEmpty(this.d) && !zC) {
                    jl.a("Negative text must be set and non-empty.");
                    return null;
                }
                if (TextUtils.isEmpty(this.d) || !zC) {
                    return new d(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
                }
                jl.a("Negative text must not be set if device credential authentication is allowed.");
                return null;
            }

            public a b(CharSequence charSequence) {
                this.d = charSequence;
                return this;
            }

            public a c(CharSequence charSequence) {
                this.a = charSequence;
                return this;
            }
        }

        public d(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z, boolean z2, int i) {
            this.a = charSequence;
            this.b = charSequence2;
            this.c = charSequence3;
            this.d = charSequence4;
            this.e = z;
            this.f = z2;
            this.g = i;
        }

        public int a() {
            return this.g;
        }

        public CharSequence b() {
            return this.c;
        }

        public CharSequence c() {
            CharSequence charSequence = this.d;
            return charSequence != null ? charSequence : "";
        }

        public CharSequence d() {
            return this.b;
        }

        public CharSequence e() {
            return this.a;
        }

        public boolean f() {
            return this.e;
        }

        public boolean g() {
            return this.f;
        }
    }

    public yj(u51 u51Var, Executor executor, a aVar) {
        if (u51Var == null) {
            jl.a("FragmentActivity must not be null.");
            throw null;
        }
        if (executor == null) {
            jl.a("Executor must not be null.");
            throw null;
        }
        if (aVar != null) {
            f(u51Var.n1(), e(u51Var), executor, aVar);
        } else {
            jl.a("AuthenticationCallback must not be null.");
            throw null;
        }
    }

    public static wj c(k61 k61Var) {
        return (wj) k61Var.j0("androidx.biometric.BiometricFragment");
    }

    public static wj d(k61 k61Var) {
        wj wjVarC = c(k61Var);
        if (wjVarC != null) {
            return wjVarC;
        }
        wj wjVarJ2 = wj.J2();
        k61Var.o().d(wjVarJ2, "androidx.biometric.BiometricFragment").i();
        k61Var.f0();
        return wjVarJ2;
    }

    public static zj e(u51 u51Var) {
        if (u51Var != null) {
            return (zj) new x(u51Var).b(zj.class);
        }
        return null;
    }

    public void a(d dVar) {
        if (dVar != null) {
            b(dVar, null);
        } else {
            jl.a("PromptInfo cannot be null.");
        }
    }

    public final void b(d dVar, c cVar) {
        k61 k61Var = this.a;
        if (k61Var == null) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
        } else if (k61Var.R0()) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Called after onSaveInstanceState().");
        } else {
            d(this.a).t2(dVar, cVar);
        }
    }

    public final void f(k61 k61Var, zj zjVar, Executor executor, a aVar) {
        this.a = k61Var;
        if (zjVar != null) {
            if (executor != null) {
                zjVar.N(executor);
            }
            zjVar.M(aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public final Signature a;
        public final Cipher b;
        public final Mac c;
        public final IdentityCredential d;

        public c(Signature signature) {
            this.a = signature;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        public Cipher a() {
            return this.b;
        }

        public IdentityCredential b() {
            return this.d;
        }

        public Mac c() {
            return this.c;
        }

        public Signature d() {
            return this.a;
        }

        public c(Cipher cipher) {
            this.a = null;
            this.b = cipher;
            this.c = null;
            this.d = null;
        }

        public c(Mac mac) {
            this.a = null;
            this.b = null;
            this.c = mac;
            this.d = null;
        }

        public c(IdentityCredential identityCredential) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = identityCredential;
        }
    }
}
