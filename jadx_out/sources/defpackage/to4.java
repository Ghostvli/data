package defpackage;

import android.content.Intent;
import android.os.CountDownTimer;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.service.PlaybackService;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class to4 {
    public CountDownTimer a;
    public b b;
    public long c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            to4.this.h();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            to4.this.i(j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void d();

        void v(long j);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public static volatile to4 a = new to4();
    }

    public static to4 e() {
        return c.a;
    }

    public void c() {
        CountDownTimer countDownTimer = this.a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.a = null;
    }

    public void d() {
        c();
        l(300000 + this.c);
    }

    public long f() {
        return this.c;
    }

    public boolean g() {
        return this.a != null;
    }

    public final void h() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.d();
        }
        if (PlaybackService.isRunning()) {
            k();
        }
        j();
    }

    public final void i(long j) {
        this.c = j;
        b bVar = this.b;
        if (bVar != null) {
            bVar.v(j);
        }
    }

    public void j() {
        this.c = 0L;
        c();
    }

    public final void k() {
        Intent intent = new Intent(App.b(), (Class<?>) PlaybackService.class);
        intent.setAction(t2.f);
        App.b().startService(intent);
    }

    public void l(long j) {
        this.a = new a(j, 1000L).start();
    }

    public void m(b bVar) {
        this.b = bVar;
    }
}
