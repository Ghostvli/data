package com.fongmi.android.tv.utils;

import android.content.Context;
import com.bumptech.glide.a;
import com.bumptech.glide.integration.okhttp3.b;
import defpackage.d32;
import defpackage.i32;
import defpackage.q53;
import defpackage.ra1;
import defpackage.s9;
import defpackage.up3;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class OkGlideModule extends s9 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ts1
    public void a(Context context, a aVar, up3 up3Var) {
        up3Var.s(ra1.class, InputStream.class, new b.a(q53.j()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.s9
    public void b(Context context, com.bumptech.glide.b bVar) {
        bVar.c(6);
        bVar.d(new i32(4194304L));
        bVar.b(new d32(4194304L));
    }
}
