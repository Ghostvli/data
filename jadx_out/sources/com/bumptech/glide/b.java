package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.a;
import com.bumptech.glide.d;
import defpackage.b32;
import defpackage.cl1;
import defpackage.d32;
import defpackage.e10;
import defpackage.i32;
import defpackage.jl;
import defpackage.ka1;
import defpackage.kk;
import defpackage.la;
import defpackage.lk;
import defpackage.ma;
import defpackage.mr3;
import defpackage.qr3;
import defpackage.s9;
import defpackage.sr2;
import defpackage.ur2;
import defpackage.us0;
import defpackage.ve0;
import defpackage.xl0;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public us0 c;
    public kk d;
    public ma e;
    public sr2 f;
    public ka1 g;
    public ka1 h;
    public xl0.a i;
    public ur2 j;
    public e10 k;
    public mr3.b n;
    public ka1 o;
    public boolean p;
    public List q;
    public final Map a = new la();
    public final d.a b = new d.a();
    public int l = 4;
    public a.InterfaceC0051a m = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements a.InterfaceC0051a {
        public a() {
        }

        @Override // com.bumptech.glide.a.InterfaceC0051a
        public qr3 build() {
            return new qr3();
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class C0052b {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
    }

    public com.bumptech.glide.a a(Context context, List list, s9 s9Var) {
        if (this.g == null) {
            this.g = ka1.y();
        }
        if (this.h == null) {
            this.h = ka1.u();
        }
        if (this.o == null) {
            this.o = ka1.l();
        }
        if (this.j == null) {
            this.j = new ur2.a(context).a();
        }
        if (this.k == null) {
            this.k = new ve0();
        }
        if (this.d == null) {
            int iB = this.j.b();
            if (iB > 0) {
                this.d = new d32(iB);
            } else {
                this.d = new lk();
            }
        }
        if (this.e == null) {
            this.e = new b32(this.j.a());
        }
        if (this.f == null) {
            this.f = new i32(this.j.d());
        }
        if (this.i == null) {
            this.i = new cl1(context);
        }
        if (this.c == null) {
            this.c = new us0(this.f, this.i, this.h, this.g, ka1.B(), this.o, this.p);
        }
        List list2 = this.q;
        if (list2 == null) {
            this.q = Collections.EMPTY_LIST;
        } else {
            this.q = Collections.unmodifiableList(list2);
        }
        return new com.bumptech.glide.a(context, this.c, this.f, this.d, this.e, new mr3(this.n), this.k, this.l, this.m, this.a, this.q, list, s9Var, this.b.b());
    }

    public b b(kk kkVar) {
        this.d = kkVar;
        return this;
    }

    public b c(int i) {
        if (i < 2 || i > 6) {
            jl.a("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
            return null;
        }
        this.l = i;
        return this;
    }

    public b d(sr2 sr2Var) {
        this.f = sr2Var;
        return this;
    }

    public void e(mr3.b bVar) {
        this.n = bVar;
    }
}
