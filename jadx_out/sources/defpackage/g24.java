package defpackage;

import android.content.ComponentName;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.e24;
import defpackage.pi2;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class g24 implements e24.a {
    public static final String g = fy4.N0(0);
    public static final String h = fy4.N0(1);
    public static final String i = fy4.N0(2);
    public static final String j = fy4.N0(3);
    public static final String k = fy4.N0(4);
    public static final String l = fy4.N0(5);
    public final pi2.h a;
    public final int b;
    public final int c;
    public final ComponentName d;
    public final String e;
    public final Bundle f;

    public g24(pi2.h hVar, int i2, int i3, ComponentName componentName, String str, Bundle bundle) {
        gg3.d((Build.MANUFACTURER.equals("samsung") && Build.VERSION.SDK_INT == 36) || !TextUtils.isEmpty(str));
        this.a = hVar;
        this.b = i2;
        this.c = i3;
        this.d = componentName;
        this.e = str;
        this.f = bundle;
    }

    @Override // e24.a
    public int a() {
        return this.b;
    }

    @Override // e24.a
    public String b() {
        return this.e;
    }

    @Override // e24.a
    public ComponentName c() {
        return this.d;
    }

    @Override // e24.a
    public Object d() {
        return this.a;
    }

    @Override // e24.a
    public String e() {
        ComponentName componentName = this.d;
        return componentName == null ? "" : componentName.getClassName();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g24)) {
            return false;
        }
        g24 g24Var = (g24) obj;
        int i2 = this.c;
        if (i2 != g24Var.c) {
            return false;
        }
        if (i2 == 100) {
            return Objects.equals(this.a, g24Var.a);
        }
        if (i2 != 101) {
            return false;
        }
        return Objects.equals(this.d, g24Var.d);
    }

    @Override // e24.a
    public boolean f() {
        return true;
    }

    @Override // e24.a
    public int g() {
        return 0;
    }

    @Override // e24.a
    public Bundle getExtras() {
        return new Bundle(this.f);
    }

    @Override // e24.a
    public int getType() {
        return this.c != 101 ? 0 : 2;
    }

    @Override // e24.a
    public Bundle h() {
        Bundle bundle = new Bundle();
        String str = g;
        pi2.h hVar = this.a;
        bundle.putBundle(str, hVar == null ? null : hVar.y());
        bundle.putInt(h, this.b);
        bundle.putInt(i, this.c);
        bundle.putParcelable(j, this.d);
        bundle.putString(k, this.e);
        bundle.putBundle(l, this.f);
        return bundle;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.c), this.d, this.a);
    }

    @Override // e24.a
    public MediaSession.Token i() {
        pi2.h hVar = this.a;
        if (hVar == null) {
            return null;
        }
        return hVar.v();
    }

    public String toString() {
        return "SessionToken {legacy, uid=" + this.b + "}";
    }

    public g24(ComponentName componentName, int i2) {
        this(null, i2, 101, (ComponentName) gg3.q(componentName), componentName.getPackageName(), Bundle.EMPTY);
    }
}
