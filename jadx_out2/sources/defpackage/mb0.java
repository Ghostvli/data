package defpackage;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.client.android.R;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class mb0 {
    public static final String k = "mb0";
    public ep a;
    public HandlerThread b;
    public Handler c;
    public eb0 d;
    public Handler e;
    public Rect f;
    public boolean g = false;
    public final Object h = new Object();
    public final Handler.Callback i = new a();
    public final pg3 j = new b();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Handler.Callback {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == R.id.zxing_decode) {
                mb0.this.g((eb4) message.obj);
                return true;
            }
            if (i != R.id.zxing_preview_failed) {
                return true;
            }
            mb0.this.h();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements pg3 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pg3
        public void a(Exception exc) {
            synchronized (mb0.this.h) {
                try {
                    if (mb0.this.g) {
                        mb0.this.c.obtainMessage(R.id.zxing_preview_failed).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pg3
        public void b(eb4 eb4Var) {
            synchronized (mb0.this.h) {
                try {
                    if (mb0.this.g) {
                        mb0.this.c.obtainMessage(R.id.zxing_decode, eb4Var).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mb0(ep epVar, eb0 eb0Var, Handler handler) {
        ly4.a();
        this.a = epVar;
        this.d = eb0Var;
        this.e = handler;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LuminanceSource f(eb4 eb4Var) {
        if (this.f == null) {
            return null;
        }
        return eb4Var.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(eb4 eb4Var) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        eb4Var.d(this.f);
        LuminanceSource luminanceSourceF = f(eb4Var);
        Result resultB = luminanceSourceF != null ? this.d.b(luminanceSourceF) : null;
        if (resultB != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Log.d(k, "Found barcode in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
            if (this.e != null) {
                Message messageObtain = Message.obtain(this.e, R.id.zxing_decode_succeeded, new sg(resultB, eb4Var));
                messageObtain.setData(new Bundle());
                messageObtain.sendToTarget();
            }
        } else {
            Handler handler = this.e;
            if (handler != null) {
                Message.obtain(handler, R.id.zxing_decode_failed).sendToTarget();
            }
        }
        if (this.e != null) {
            Message.obtain(this.e, R.id.zxing_possible_result_points, sg.f(this.d.c(), eb4Var)).sendToTarget();
        }
        h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        this.a.s(this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(Rect rect) {
        this.f = rect;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(eb0 eb0Var) {
        this.d = eb0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k() {
        ly4.a();
        HandlerThread handlerThread = new HandlerThread(k);
        this.b = handlerThread;
        handlerThread.start();
        this.c = new Handler(this.b.getLooper(), this.i);
        this.g = true;
        h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l() {
        ly4.a();
        synchronized (this.h) {
            this.g = false;
            this.c.removeCallbacksAndMessages(null);
            this.b.quit();
        }
    }
}
