package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.a;
import defpackage.ct4;
import defpackage.l91;
import defpackage.ma;
import defpackage.pa1;
import defpackage.qr3;
import defpackage.ri1;
import defpackage.up3;
import defpackage.us0;
import defpackage.y45;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class c extends ContextWrapper {
    public static final ct4 k = new l91();
    public final ma a;
    public final pa1.b b;
    public final ri1 c;
    public final a.InterfaceC0051a d;
    public final List e;
    public final Map f;
    public final us0 g;
    public final d h;
    public final int i;
    public qr3 j;

    public c(Context context, ma maVar, pa1.b bVar, ri1 ri1Var, a.InterfaceC0051a interfaceC0051a, Map map, List list, us0 us0Var, d dVar, int i) {
        super(context.getApplicationContext());
        this.a = maVar;
        this.c = ri1Var;
        this.d = interfaceC0051a;
        this.e = list;
        this.f = map;
        this.g = us0Var;
        this.h = dVar;
        this.i = i;
        this.b = pa1.a(bVar);
    }

    public y45 a(ImageView imageView, Class cls) {
        return this.c.a(imageView, cls);
    }

    public ma b() {
        return this.a;
    }

    public List c() {
        return this.e;
    }

    public synchronized qr3 d() {
        try {
            if (this.j == null) {
                this.j = (qr3) this.d.build().P();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.j;
    }

    public ct4 e(Class cls) {
        ct4 ct4Var = (ct4) this.f.get(cls);
        if (ct4Var == null) {
            for (Map.Entry entry : this.f.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    ct4Var = (ct4) entry.getValue();
                }
            }
        }
        return ct4Var == null ? k : ct4Var;
    }

    public us0 f() {
        return this.g;
    }

    public d g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }

    public up3 i() {
        return (up3) this.b.get();
    }
}
