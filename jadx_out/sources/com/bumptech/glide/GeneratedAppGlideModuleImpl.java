package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.fongmi.android.tv.utils.OkGlideModule;
import defpackage.j91;
import defpackage.lf;
import defpackage.up3;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    public final OkGlideModule a = new OkGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.fongmi.android.tv.utils.OkGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.avif.AvifGlideModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule");
        }
    }

    @Override // defpackage.ts1
    public void a(Context context, a aVar, up3 up3Var) {
        new lf().a(context, aVar, up3Var);
        new com.bumptech.glide.integration.okhttp3.a().a(context, aVar, up3Var);
        this.a.a(context, aVar, up3Var);
    }

    @Override // defpackage.s9
    public void b(Context context, b bVar) {
        this.a.b(context, bVar);
    }

    @Override // defpackage.s9
    public boolean c() {
        return this.a.c();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public Set d() {
        return Collections.EMPTY_SET;
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public j91 e() {
        return new j91();
    }
}
