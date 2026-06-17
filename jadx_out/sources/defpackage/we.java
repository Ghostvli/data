package defpackage;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import defpackage.we;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class we {
    public static final String i = "we";
    public static final Collection j;
    public boolean a;
    public boolean b;
    public final boolean c;
    public final Camera d;
    public Handler e;
    public int f = 1;
    public final Handler.Callback g;
    public final Camera.AutoFocusCallback h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != we.this.f) {
                return false;
            }
            we.this.h();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Camera.AutoFocusCallback {
        public b() {
        }

        public static /* synthetic */ void a(b bVar) {
            we.this.b = false;
            we.this.f();
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            we.this.e.post(new Runnable() { // from class: xe
                @Override // java.lang.Runnable
                public final void run() {
                    we.b.a(this.f);
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public we(Camera camera, jp jpVar) {
        a aVar = new a();
        this.g = aVar;
        this.h = new b();
        this.e = new Handler(aVar);
        this.d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = jpVar.c() && j.contains(focusMode);
        this.c = z;
        Log.i(i, "Current focus mode '" + focusMode + "'; use auto focus? " + z);
        i();
    }

    public final synchronized void f() {
        if (!this.a && !this.e.hasMessages(this.f)) {
            Handler handler = this.e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f), 2000L);
        }
    }

    public final void g() {
        this.e.removeMessages(this.f);
    }

    public final void h() {
        if (!this.c || this.a || this.b) {
            return;
        }
        try {
            this.d.autoFocus(this.h);
            this.b = true;
        } catch (RuntimeException e) {
            Log.w(i, "Unexpected exception while focusing", e);
            f();
        }
    }

    public void i() {
        this.a = false;
        h();
    }

    public void j() {
        this.a = true;
        this.b = false;
        g();
        if (this.c) {
            try {
                this.d.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.w(i, "Unexpected exception while cancelling focusing", e);
            }
        }
    }
}
