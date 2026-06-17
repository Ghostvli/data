package defpackage;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r52 {
    public final TimeInterpolator a = new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
    public final View b;
    public final int c;
    public final int d;
    public final int e;
    public nf f;

    public r52(View view) {
        this.b = view;
        Context context = view.getContext();
        this.c = lu2.f(context, mk3.E, 300);
        this.d = lu2.f(context, mk3.H, 150);
        this.e = lu2.f(context, mk3.G, 100);
    }

    public float a(float f) {
        return this.a.getInterpolation(f);
    }

    public nf b() {
        if (this.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        nf nfVar = this.f;
        this.f = null;
        return nfVar;
    }

    public nf c() {
        nf nfVar = this.f;
        this.f = null;
        return nfVar;
    }

    public void d(nf nfVar) {
        this.f = nfVar;
    }

    public nf e(nf nfVar) {
        if (this.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        nf nfVar2 = this.f;
        this.f = nfVar;
        return nfVar2;
    }
}
