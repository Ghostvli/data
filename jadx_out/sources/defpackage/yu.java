package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import j$.time.LocalDateTime;
import j$.time.format.DateTimeFormatter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class yu {
    public DateTimeFormatter b;
    public b c;
    public TextView d;
    public boolean e;
    public final Runnable f = new a();
    public final Handler a = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yu.this.d();
            yu.this.a.postDelayed(this, 1000L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void K(long j);
    }

    public static yu c() {
        return new yu();
    }

    public final void d() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            b bVar = this.c;
            if (bVar != null) {
                bVar.K(jCurrentTimeMillis);
            }
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(this.b.format(LocalDateTime.now()));
            }
        } catch (Exception unused) {
        }
    }

    public void e() {
        h();
        this.c = null;
    }

    public void f(b bVar) {
        this.c = bVar;
    }

    public void g() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.a.removeCallbacks(this.f);
        this.a.post(this.f);
    }

    public yu h() {
        this.e = false;
        this.a.removeCallbacks(this.f);
        return this;
    }
}
