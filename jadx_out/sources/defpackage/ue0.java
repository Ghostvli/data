package defpackage;

import android.content.Context;
import defpackage.d10;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ue0 implements d10 {
    public final Context f;
    public final d10.a g;

    public ue0(Context context, d10.a aVar) {
        this.f = context.getApplicationContext();
        this.g = aVar;
    }

    @Override // defpackage.zs1
    public void b() {
        c();
    }

    public final void c() {
        p74.a(this.f).d(this.g);
    }

    public final void e() {
        p74.a(this.f).e(this.g);
    }

    @Override // defpackage.zs1
    public void h() {
    }

    @Override // defpackage.zs1
    public void onStop() {
        e();
    }
}
