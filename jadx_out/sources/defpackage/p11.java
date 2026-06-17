package defpackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class p11 implements t71 {
    public final Set a = Collections.newSetFromMap(new WeakHashMap());
    public volatile boolean b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements ViewTreeObserver.OnDrawListener {
        public final /* synthetic */ View f;

        /* JADX INFO: renamed from: p11$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class RunnableC0110a implements Runnable {
            public final /* synthetic */ ViewTreeObserver.OnDrawListener f;

            public RunnableC0110a(ViewTreeObserver.OnDrawListener onDrawListener) {
                this.f = onDrawListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                qc1.b().h();
                p11.this.b = true;
                p11.b(a.this.f, this.f);
                p11.this.a.clear();
            }
        }

        public a(View view) {
            this.f = view;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            iy4.w(new RunnableC0110a(this));
        }
    }

    public static void b(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }

    @Override // defpackage.t71
    public void a(Activity activity) {
        if (!this.b && this.a.add(activity)) {
            View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new a(decorView));
        }
    }
}
