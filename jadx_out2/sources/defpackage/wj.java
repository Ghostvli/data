package defpackage;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.x;
import defpackage.yj;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class wj extends p51 {
    public Handler i0 = new Handler(Looper.getMainLooper());
    public zj j0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public final /* synthetic */ int f;
        public final /* synthetic */ CharSequence g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i, CharSequence charSequence) {
            this.f = i;
            this.g = charSequence;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            wj.this.j0.l().a(this.f, this.g);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            wj.this.j0.l().b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements x43 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)V */
        @Override // defpackage.x43
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(yj.b bVar) {
            if (bVar != null) {
                wj.this.N2(bVar);
                wj.this.j0.J(null);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements x43 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)V */
        @Override // defpackage.x43
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(vj vjVar) {
            if (vjVar != null) {
                wj.this.K2(vjVar.b(), vjVar.c());
                wj.this.j0.H(null);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements x43 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)V */
        @Override // defpackage.x43
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CharSequence charSequence) {
            if (charSequence != null) {
                wj.this.M2(charSequence);
                wj.this.j0.H(null);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements x43 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)V */
        @Override // defpackage.x43
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            if (bool.booleanValue()) {
                wj.this.L2();
                wj.this.j0.I(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g implements x43 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)V */
        @Override // defpackage.x43
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            if (bool.booleanValue()) {
                boolean zG2 = wj.this.G2();
                wj wjVar = wj.this;
                if (zG2) {
                    wjVar.P2();
                } else {
                    wjVar.O2();
                }
                wj.this.j0.X(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h implements x43 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)V */
        @Override // defpackage.x43
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            if (bool.booleanValue()) {
                wj.this.w2(1);
                wj.this.z2();
                wj.this.j0.R(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class i implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            wj.this.j0.S(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class j implements Runnable {
        public final /* synthetic */ int f;
        public final /* synthetic */ CharSequence g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j(int i, CharSequence charSequence) {
            this.f = i;
            this.g = charSequence;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            wj.this.Q2(this.f, this.g);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class k implements Runnable {
        public final /* synthetic */ yj.b f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public k(yj.b bVar) {
            this.f = bVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            wj.this.j0.l().c(this.f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class l {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Intent a(KeyguardManager keyguardManager, CharSequence charSequence, CharSequence charSequence2) {
            return keyguardManager.createConfirmDeviceCredentialIntent(charSequence, charSequence2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class m {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(BiometricPrompt biometricPrompt, BiometricPrompt.CryptoObject cryptoObject, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt$AuthenticationCallback biometricPrompt$AuthenticationCallback) {
            biometricPrompt.authenticate(cryptoObject, cancellationSignal, executor, biometricPrompt$AuthenticationCallback);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void b(BiometricPrompt biometricPrompt, CancellationSignal cancellationSignal, Executor executor, BiometricPrompt$AuthenticationCallback biometricPrompt$AuthenticationCallback) {
            biometricPrompt.authenticate(cancellationSignal, executor, biometricPrompt$AuthenticationCallback);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static BiometricPrompt c(BiometricPrompt.Builder builder) {
            return builder.build();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static BiometricPrompt.Builder d(Context context) {
            return new BiometricPrompt.Builder(context);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void e(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void f(BiometricPrompt.Builder builder, CharSequence charSequence, Executor executor, DialogInterface.OnClickListener onClickListener) {
            builder.setNegativeButton(charSequence, executor, onClickListener);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void g(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void h(BiometricPrompt.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class n {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(BiometricPrompt.Builder builder, boolean z) {
            builder.setConfirmationRequired(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void b(BiometricPrompt.Builder builder, boolean z) {
            builder.setDeviceCredentialAllowed(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class o {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(BiometricPrompt.Builder builder, int i) {
            builder.setAllowedAuthenticators(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class p implements Executor {
        public final Handler f = new Handler(Looper.getMainLooper());

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f.post(runnable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class q implements Runnable {
        public final WeakReference f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public q(wj wjVar) {
            this.f = new WeakReference(wjVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            if (this.f.get() != null) {
                ((wj) this.f.get()).Y2();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class r implements Runnable {
        public final WeakReference f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public r(zj zjVar) {
            this.f = new WeakReference(zjVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            if (this.f.get() != null) {
                ((zj) this.f.get()).Q(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class s implements Runnable {
        public final WeakReference f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public s(zj zjVar) {
            this.f = new WeakReference(zjVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            if (this.f.get() != null) {
                ((zj) this.f.get()).W(false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean D2() {
        u51 u51VarO = O();
        return u51VarO != null && u51VarO.isChangingConfigurations();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static wj J2() {
        return new wj();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int x2(n11 n11Var) {
        if (n11Var.f()) {
            return !n11Var.e() ? 11 : 0;
        }
        return 12;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A2() {
        this.j0.a0(false);
        if (H0()) {
            k61 k61VarK0 = k0();
            m11 m11Var = (m11) k61VarK0.j0("androidx.biometric.FingerprintDialogFragment");
            if (m11Var != null) {
                if (m11Var.H0()) {
                    m11Var.x2();
                } else {
                    k61VarK0.o().p(m11Var).i();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int B2() {
        Context contextU = U();
        return (contextU == null || !ok0.f(contextU, Build.MODEL)) ? 2000 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C2(int i2) {
        if (i2 == -1) {
            T2(new yj.b(null, 1));
        } else {
            Q2(10, y0(mm3.l));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean E2() {
        u51 u51VarO = O();
        return (u51VarO == null || this.j0.n() == null || !ok0.g(u51VarO, Build.MANUFACTURER, Build.MODEL)) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean F2() {
        return Build.VERSION.SDK_INT == 28 && !d73.a(U());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean G2() {
        return Build.VERSION.SDK_INT <= 28 && me.c(this.j0.e());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean H2() {
        return Build.VERSION.SDK_INT < 28 || E2() || F2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I2() {
        u51 u51VarO = O();
        if (u51VarO == null) {
            Log.e("BiometricFragment", "Failed to check device credential. Client FragmentActivity not found.");
            return;
        }
        KeyguardManager keyguardManagerA = hr1.a(u51VarO);
        if (keyguardManagerA == null) {
            Q2(12, y0(mm3.k));
            return;
        }
        CharSequence charSequenceW = this.j0.w();
        CharSequence charSequenceV = this.j0.v();
        CharSequence charSequenceO = this.j0.o();
        if (charSequenceV == null) {
            charSequenceV = charSequenceO;
        }
        Intent intentA = l.a(keyguardManagerA, charSequenceW, charSequenceV);
        if (intentA == null) {
            Q2(14, y0(mm3.j));
            return;
        }
        this.j0.O(true);
        if (H2()) {
            A2();
        }
        intentA.setFlags(134742016);
        q2(intentA, 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K2(int i2, CharSequence charSequence) {
        if (!pu0.b(i2)) {
            i2 = 8;
        }
        Context contextU = U();
        if (Build.VERSION.SDK_INT < 29 && pu0.c(i2) && contextU != null && hr1.b(contextU) && me.c(this.j0.e())) {
            I2();
            return;
        }
        if (!H2()) {
            if (charSequence == null) {
                charSequence = y0(mm3.b) + " " + i2;
            }
            Q2(i2, charSequence);
            return;
        }
        if (charSequence == null) {
            charSequence = pu0.a(U(), i2);
        }
        zj zjVar = this.j0;
        if (i2 == 5) {
            int iJ = zjVar.j();
            if (iJ == 0 || iJ == 3) {
                R2(i2, charSequence);
            }
            z2();
            return;
        }
        if (zjVar.D()) {
            Q2(i2, charSequence);
        } else {
            X2(charSequence);
            this.i0.postDelayed(new j(i2, charSequence), B2());
        }
        this.j0.S(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L2() {
        if (H2()) {
            X2(y0(mm3.i));
        }
        S2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M2(CharSequence charSequence) {
        if (H2()) {
            X2(charSequence);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N2(yj.b bVar) {
        T2(bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O2() {
        CharSequence charSequenceU = this.j0.u();
        if (charSequenceU == null) {
            charSequenceU = y0(mm3.b);
        }
        Q2(13, charSequenceU);
        w2(2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P2() {
        I2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.p51
    public void Q0(int i2, int i3, Intent intent) {
        super.Q0(i2, i3, intent);
        if (i2 == 1) {
            this.j0.O(false);
            C2(i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q2(int i2, CharSequence charSequence) {
        R2(i2, charSequence);
        z2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R2(int i2, CharSequence charSequence) {
        if (this.j0.A()) {
            Log.v("BiometricFragment", "Error not sent to client. User is confirming their device credential.");
        } else if (!this.j0.y()) {
            Log.w("BiometricFragment", "Error not sent to client. Client is not awaiting a result.");
        } else {
            this.j0.K(false);
            this.j0.m().execute(new a(i2, charSequence));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S2() {
        if (this.j0.y()) {
            this.j0.m().execute(new b());
        } else {
            Log.w("BiometricFragment", "Failure not sent to client. Client is not awaiting a result.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T2(yj.b bVar) {
        U2(bVar);
        z2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void U2(yj.b bVar) {
        if (!this.j0.y()) {
            Log.w("BiometricFragment", "Success not sent to client. Client is not awaiting a result.");
        } else {
            this.j0.K(false);
            this.j0.m().execute(new k(bVar));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.p51
    public void V0(Bundle bundle) {
        super.V0(bundle);
        y2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V2() {
        BiometricPrompt.Builder builderD = m.d(Y1().getApplicationContext());
        CharSequence charSequenceW = this.j0.w();
        CharSequence charSequenceV = this.j0.v();
        CharSequence charSequenceO = this.j0.o();
        if (charSequenceW != null) {
            m.h(builderD, charSequenceW);
        }
        if (charSequenceV != null) {
            m.g(builderD, charSequenceV);
        }
        if (charSequenceO != null) {
            m.e(builderD, charSequenceO);
        }
        CharSequence charSequenceU = this.j0.u();
        if (!TextUtils.isEmpty(charSequenceU)) {
            m.f(builderD, charSequenceU, this.j0.m(), this.j0.t());
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            n.a(builderD, this.j0.z());
        }
        int iE = this.j0.e();
        if (i2 >= 30) {
            o.a(builderD, iE);
        } else if (i2 >= 29) {
            n.b(builderD, me.c(iE));
        }
        u2(m.c(builderD), U());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void W2() {
        Context applicationContext = Y1().getApplicationContext();
        n11 n11VarC = n11.c(applicationContext);
        int iX2 = x2(n11VarC);
        if (iX2 != 0) {
            Q2(iX2, pu0.a(applicationContext, iX2));
            return;
        }
        if (H0()) {
            this.j0.S(true);
            if (!ok0.f(applicationContext, Build.MODEL)) {
                this.i0.postDelayed(new i(), 500L);
                m11.K2().G2(k0(), "androidx.biometric.FingerprintDialogFragment");
            }
            this.j0.L(0);
            v2(n11VarC, applicationContext);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = y0(mm3.b);
        }
        this.j0.V(2);
        this.j0.T(charSequence);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y2() {
        if (this.j0.G()) {
            return;
        }
        if (U() == null) {
            Log.w("BiometricFragment", "Not showing biometric prompt. Context is null.");
            return;
        }
        this.j0.a0(true);
        this.j0.K(true);
        if (H2()) {
            W2();
        } else {
            V2();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.p51
    public void s1() {
        super.s1();
        if (Build.VERSION.SDK_INT == 29 && me.c(this.j0.e())) {
            this.j0.W(true);
            this.i0.postDelayed(new s(this.j0), 250L);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.p51
    public void t1() {
        super.t1();
        if (Build.VERSION.SDK_INT >= 29 || this.j0.A() || D2()) {
            return;
        }
        w2(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t2(yj.d dVar, yj.c cVar) {
        u51 u51VarO = O();
        if (u51VarO == null) {
            Log.e("BiometricFragment", "Not launching prompt. Client activity was null.");
            return;
        }
        this.j0.Z(dVar);
        int iB = me.b(dVar, cVar);
        if (Build.VERSION.SDK_INT < 30 && iB == 15 && cVar == null) {
            this.j0.P(i50.a());
        } else {
            this.j0.P(cVar);
        }
        boolean zG2 = G2();
        zj zjVar = this.j0;
        if (zG2) {
            zjVar.Y(y0(mm3.a));
        } else {
            zjVar.Y(null);
        }
        if (G2() && xj.g(u51VarO).a(255) != 0) {
            this.j0.K(true);
            I2();
        } else if (this.j0.B()) {
            this.i0.postDelayed(new q(this), 600L);
        } else {
            Y2();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u2(BiometricPrompt biometricPrompt, Context context) {
        BiometricPrompt.CryptoObject cryptoObjectC = i50.c(this.j0.n());
        CancellationSignal cancellationSignalB = this.j0.k().b();
        p pVar = new p();
        BiometricPrompt$AuthenticationCallback biometricPrompt$AuthenticationCallbackA = this.j0.f().a();
        try {
            if (cryptoObjectC == null) {
                m.b(biometricPrompt, cancellationSignalB, pVar, biometricPrompt$AuthenticationCallbackA);
            } else {
                m.a(biometricPrompt, cryptoObjectC, cancellationSignalB, pVar, biometricPrompt$AuthenticationCallbackA);
            }
        } catch (NullPointerException e2) {
            Log.e("BiometricFragment", "Got NPE while authenticating with biometric prompt.", e2);
            Q2(1, context != null ? context.getString(mm3.b) : "");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v2(n11 n11Var, Context context) {
        try {
            n11Var.a(i50.d(this.j0.n()), 0, this.j0.k().c(), this.j0.f().b(), null);
        } catch (NullPointerException e2) {
            Log.e("BiometricFragment", "Got NPE while authenticating with fingerprint.", e2);
            Q2(1, pu0.a(context, 1));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w2(int i2) {
        if (i2 == 3 || !this.j0.E()) {
            if (H2()) {
                this.j0.L(i2);
                if (i2 == 1) {
                    R2(10, pu0.a(U(), 10));
                }
            }
            this.j0.k().a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y2() {
        if (O() == null) {
            return;
        }
        zj zjVar = (zj) new x(O()).b(zj.class);
        this.j0 = zjVar;
        zjVar.i().f(this, new c());
        this.j0.g().f(this, new d());
        this.j0.h().f(this, new e());
        this.j0.x().f(this, new f());
        this.j0.F().f(this, new g());
        this.j0.C().f(this, new h());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z2() {
        this.j0.a0(false);
        A2();
        if (!this.j0.A() && H0()) {
            k0().o().p(this).i();
        }
        Context contextU = U();
        if (contextU == null || !ok0.e(contextU, Build.MODEL)) {
            return;
        }
        this.j0.Q(true);
        this.i0.postDelayed(new r(this.j0), 600L);
    }
}
