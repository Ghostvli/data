package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.a;
import defpackage.dp3;
import defpackage.ma;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements com.bumptech.glide.load.data.a {
    public final dp3 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements a.InterfaceC0054a {
        public final ma a;

        public a(ma maVar) {
            this.a = maVar;
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0054a
        public Class a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0054a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.load.data.a b(InputStream inputStream) {
            return new c(inputStream, this.a);
        }
    }

    public c(InputStream inputStream, ma maVar) {
        dp3 dp3Var = new dp3(inputStream, maVar);
        this.a = dp3Var;
        dp3Var.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.a
    public void b() {
        this.a.h();
    }

    public void c() {
        this.a.c();
    }

    @Override // com.bumptech.glide.load.data.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream a() {
        this.a.reset();
        return this.a;
    }
}
