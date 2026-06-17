package defpackage;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ku3 {
    public int a;
    public WindowManager b;
    public OrientationEventListener c;
    public ju3 d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends OrientationEventListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Context context, int i) {
            super(context, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int rotation;
            WindowManager windowManager = ku3.this.b;
            ju3 ju3Var = ku3.this.d;
            if (ku3.this.b == null || ju3Var == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == ku3.this.a) {
                return;
            }
            ku3.this.a = rotation;
            ju3Var.a(rotation);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(Context context, ju3 ju3Var) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.d = ju3Var;
        this.b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.c = aVar;
        aVar.enable();
        this.a = this.b.getDefaultDisplay().getRotation();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f() {
        OrientationEventListener orientationEventListener = this.c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.c = null;
        this.b = null;
        this.d = null;
    }
}
