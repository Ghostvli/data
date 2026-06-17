package com.bumptech.glide.integration.okhttp3;

import defpackage.a63;
import defpackage.bw2;
import defpackage.ra1;
import defpackage.u63;
import defpackage.vt2;
import defpackage.wt2;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b implements vt2 {
    public final Call.Factory a;

    public b(Call.Factory factory) {
        this.a = factory;
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vt2.a b(ra1 ra1Var, int i, int i2, u63 u63Var) {
        return new vt2.a(ra1Var, new a63(this.a, ra1Var));
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ra1 ra1Var) {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements wt2 {
        public static volatile Call.Factory b;
        public final Call.Factory a;

        public a() {
            this(a());
        }

        public static Call.Factory a() {
            if (b == null) {
                synchronized (a.class) {
                    try {
                        if (b == null) {
                            b = new OkHttpClient();
                        }
                    } finally {
                    }
                }
            }
            return b;
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new b(this.a);
        }

        public a(Call.Factory factory) {
            this.a = factory;
        }
    }
}
