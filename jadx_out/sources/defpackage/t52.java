package defpackage;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class t52 {
    public final d a = a();
    public final s52 b;
    public final View c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements d {
        public OnBackInvokedCallback a;

        public b() {
        }

        @Override // t52.d
        public void a(View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.a == null || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.a);
            this.a = null;
        }

        @Override // t52.d
        public void b(s52 s52Var, View view, boolean z) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.a == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackC = c(s52Var);
                this.a = onBackInvokedCallbackC;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z ? 1000000 : 0, onBackInvokedCallbackC);
            }
        }

        public OnBackInvokedCallback c(final s52 s52Var) {
            Objects.requireNonNull(s52Var);
            return new OnBackInvokedCallback() { // from class: u52
                public final void onBackInvoked() {
                    s52Var.c();
                }
            };
        }

        public boolean d() {
            return this.a != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends b {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements OnBackAnimationCallback {
            public final /* synthetic */ s52 a;

            public a(s52 s52Var) {
                this.a = s52Var;
            }

            public void onBackCancelled() {
                if (c.this.d()) {
                    this.a.f();
                }
            }

            public void onBackInvoked() {
                this.a.c();
            }

            public void onBackProgressed(BackEvent backEvent) {
                if (c.this.d()) {
                    this.a.d(new nf(backEvent));
                }
            }

            public void onBackStarted(BackEvent backEvent) {
                if (c.this.d()) {
                    this.a.e(new nf(backEvent));
                }
            }
        }

        public c() {
            super();
        }

        @Override // t52.b
        public OnBackInvokedCallback c(s52 s52Var) {
            return new a(s52Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void a(View view);

        void b(s52 s52Var, View view, boolean z);
    }

    public t52(s52 s52Var, View view) {
        this.b = s52Var;
        this.c = view;
    }

    public static d a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            return new c();
        }
        if (i >= 33) {
            return new b();
        }
        return null;
    }

    public void b() {
        c(false);
    }

    public final void c(boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.b(this.b, this.c, z);
        }
    }

    public void d() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(this.c);
        }
    }
}
