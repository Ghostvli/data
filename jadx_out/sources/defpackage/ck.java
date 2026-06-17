package defpackage;

import android.graphics.drawable.BitmapDrawable;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ck implements gs3 {
    public final kk a;
    public final gs3 b;

    public ck(kk kkVar, gs3 gs3Var) {
        this.a = kkVar;
        this.b = gs3Var;
    }

    @Override // defpackage.gs3
    public ms0 b(u63 u63Var) {
        return this.b.b(u63Var);
    }

    @Override // defpackage.ns0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(yr3 yr3Var, File file, u63 u63Var) {
        return this.b.a(new mk(((BitmapDrawable) yr3Var.get()).getBitmap(), this.a), file, u63Var);
    }
}
