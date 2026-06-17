package defpackage;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import defpackage.jq2;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zv0 extends ac3 {
    public final int o;
    public final String p;
    public final int q;
    public final t41 r;
    public final int s;
    public final jq2.b t;
    public final boolean u;

    public zv0(String str, Throwable th, int i, int i2, String str2, int i3, t41 t41Var, int i4, jq2.b bVar, long j, boolean z) {
        super(str, th, i, Bundle.EMPTY, j);
        gg3.d(!z || i2 == 1);
        gg3.d(th != null || i2 == 3);
        this.o = i2;
        this.p = str2;
        this.q = i3;
        this.r = t41Var;
        this.s = i4;
        this.t = bVar;
        this.u = z;
    }

    public static zv0 k(Throwable th, String str, int i, t41 t41Var, int i2, jq2.b bVar, boolean z, int i3) {
        if (t41Var == null) {
            i2 = 4;
        }
        return new zv0(1, th, null, i3, str, i, t41Var, i2, bVar, z);
    }

    public static zv0 l(IOException iOException, int i) {
        return new zv0(0, iOException, i);
    }

    public static zv0 m(RuntimeException runtimeException, int i) {
        return new zv0(2, runtimeException, i);
    }

    public static String n(int i, String str, String str2, int i2, t41 t41Var, int i3) {
        String str3;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = i != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i2 + ", format=" + t41Var + ", format_supported=" + fy4.l0(i3);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    @Override // defpackage.ac3
    public boolean c(ac3 ac3Var) {
        if (!super.c(ac3Var)) {
            return false;
        }
        zv0 zv0Var = (zv0) fy4.l(ac3Var);
        return this.o == zv0Var.o && Objects.equals(this.p, zv0Var.p) && this.q == zv0Var.q && Objects.equals(this.r, zv0Var.r) && this.s == zv0Var.s && Objects.equals(this.t, zv0Var.t) && this.u == zv0Var.u;
    }

    public zv0 j(jq2.b bVar) {
        return new zv0((String) fy4.l(getMessage()), getCause(), this.f, this.o, this.p, this.q, this.r, this.s, bVar, this.g, this.u);
    }

    public zv0(int i, Throwable th, String str, int i2, String str2, int i3, t41 t41Var, int i4, jq2.b bVar, boolean z) {
        this(n(i, str, str2, i3, t41Var, i4), th, i2, i, str2, i3, t41Var, i4, bVar, SystemClock.elapsedRealtime(), z);
    }

    public zv0(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, null, false);
    }
}
