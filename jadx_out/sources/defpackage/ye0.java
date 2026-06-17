package defpackage;

import android.content.Context;
import android.net.Uri;
import defpackage.aa0;
import defpackage.cg0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ye0 implements aa0 {
    public final Context a;
    public final List b = new ArrayList();
    public final aa0 c;
    public aa0 d;
    public aa0 e;
    public aa0 f;
    public aa0 g;
    public aa0 h;
    public aa0 i;
    public aa0 j;
    public aa0 k;

    public ye0(Context context, aa0 aa0Var) {
        this.a = context.getApplicationContext();
        this.c = (aa0) gg3.q(aa0Var);
    }

    public final void A(aa0 aa0Var, hs4 hs4Var) {
        if (aa0Var != null) {
            aa0Var.f(hs4Var);
        }
    }

    @Override // defpackage.aa0
    public long a(ja0 ja0Var) {
        gg3.v(this.k == null);
        String scheme = ja0Var.a.getScheme();
        if (fy4.U0(ja0Var.a)) {
            String path = ja0Var.a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.k = w();
            } else {
                this.k = t();
            }
        } else if ("asset".equals(scheme)) {
            this.k = t();
        } else if ("content".equals(scheme)) {
            this.k = u();
        } else if ("rtmp".equals(scheme)) {
            this.k = y();
        } else if ("udp".equals(scheme)) {
            this.k = z();
        } else if ("data".equals(scheme)) {
            this.k = v();
        } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
            this.k = x();
        } else {
            this.k = this.c;
        }
        return this.k.a(ja0Var);
    }

    @Override // defpackage.aa0
    public void close() {
        aa0 aa0Var = this.k;
        if (aa0Var != null) {
            try {
                aa0Var.close();
            } finally {
                this.k = null;
            }
        }
    }

    @Override // defpackage.aa0
    public void f(hs4 hs4Var) {
        gg3.q(hs4Var);
        this.c.f(hs4Var);
        this.b.add(hs4Var);
        A(this.d, hs4Var);
        A(this.e, hs4Var);
        A(this.f, hs4Var);
        A(this.g, hs4Var);
        A(this.h, hs4Var);
        A(this.i, hs4Var);
        A(this.j, hs4Var);
    }

    @Override // defpackage.aa0
    public Uri getUri() {
        aa0 aa0Var = this.k;
        if (aa0Var == null) {
            return null;
        }
        return aa0Var.getUri();
    }

    public final void h(aa0 aa0Var) {
        for (int i = 0; i < this.b.size(); i++) {
            aa0Var.f((hs4) this.b.get(i));
        }
    }

    @Override // defpackage.aa0
    public Map o() {
        aa0 aa0Var = this.k;
        return aa0Var == null ? Collections.EMPTY_MAP : aa0Var.o();
    }

    @Override // defpackage.x90
    public int read(byte[] bArr, int i, int i2) {
        return ((aa0) gg3.q(this.k)).read(bArr, i, i2);
    }

    public final aa0 t() {
        if (this.e == null) {
            ya yaVar = new ya(this.a);
            this.e = yaVar;
            h(yaVar);
        }
        return this.e;
    }

    public final aa0 u() {
        if (this.f == null) {
            n20 n20Var = new n20(this.a);
            this.f = n20Var;
            h(n20Var);
        }
        return this.f;
    }

    public final aa0 v() {
        if (this.i == null) {
            y90 y90Var = new y90();
            this.i = y90Var;
            h(y90Var);
        }
        return this.i;
    }

    public final aa0 w() {
        if (this.d == null) {
            h01 h01Var = new h01();
            this.d = h01Var;
            h(h01Var);
        }
        return this.d;
    }

    public final aa0 x() {
        if (this.j == null) {
            do3 do3Var = new do3(this.a);
            this.j = do3Var;
            h(do3Var);
        }
        return this.j;
    }

    public final aa0 y() {
        if (this.g == null) {
            try {
                int i = qu3.g;
                aa0 aa0Var = (aa0) qu3.class.getConstructor(null).newInstance(null);
                this.g = aa0Var;
                h(aa0Var);
            } catch (ClassNotFoundException unused) {
                xz1.i("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e) {
                cx4.a("Error instantiating RTMP extension", e);
                return null;
            }
            if (this.g == null) {
                this.g = this.c;
            }
        }
        return this.g;
    }

    public final aa0 z() {
        if (this.h == null) {
            uv4 uv4Var = new uv4();
            this.h = uv4Var;
            h(uv4Var);
        }
        return this.h;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements aa0.a {
        public final Context a;
        public final aa0.a b;
        public hs4 c;

        public a(Context context, aa0.a aVar) {
            this.a = context.getApplicationContext();
            this.b = (aa0.a) gg3.q(aVar);
        }

        @Override // aa0.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ye0 b() {
            ye0 ye0Var = new ye0(this.a, this.b.b());
            hs4 hs4Var = this.c;
            if (hs4Var != null) {
                ye0Var.f(hs4Var);
            }
            return ye0Var;
        }

        public a(Context context) {
            this(context, new cg0.b());
        }
    }
}
