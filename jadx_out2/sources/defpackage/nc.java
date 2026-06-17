package defpackage;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import defpackage.qc;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class nc {
    public final xi4 a;
    public final Handler b;
    public a c;
    public yb d;
    public int f;
    public qc h;
    public boolean i;
    public float g = 1.0f;
    public int e = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void c(float f);

        void d(int i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nc(final Context context, Looper looper, a aVar) {
        this.a = zi4.a(new xi4() { // from class: mc
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.xi4
            public final Object get() {
                return tc.c(context);
            }
        });
        this.c = aVar;
        this.b = new Handler(looper);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(yb ybVar) {
        if (ybVar == null) {
            return 0;
        }
        switch (ybVar.c) {
            case 0:
                xz1.i("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (ybVar.a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                xz1.i("AudioFocusManager", "Unidentified audio usage: " + ybVar.c);
                return 0;
            case 16:
                return 4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c() {
        int i = this.e;
        if (i == 1 || i == 0 || this.h == null) {
            return;
        }
        tc.b((AudioManager) this.a.get(), this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(int i) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float f() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(int i) {
        if (i == -3 || i == -2) {
            if (i != -2 && !o()) {
                l(4);
                return;
            } else {
                e(0);
                l(3);
                return;
            }
        }
        if (i == -1) {
            e(-1);
            c();
            l(1);
        } else if (i == 1) {
            l(2);
            e(1);
        } else {
            xz1.i("AudioFocusManager", "Unknown focus change type: " + i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h() {
        this.c = null;
        c();
        l(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int i() {
        if (this.e == 2) {
            return 1;
        }
        int iJ = j();
        if (iJ == 1 || iJ == 2) {
            l(2);
            return 1;
        }
        l(1);
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int j() {
        qc qcVar = this.h;
        if (qcVar == null || this.i) {
            this.h = (qcVar == null ? new qc.b(this.f) : qcVar.a()).c((yb) gg3.q(this.d)).e(o()).b(true).d(new AudioManager.OnAudioFocusChangeListener() { // from class: lc
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final void onAudioFocusChange(int i) {
                    this.a.g(i);
                }
            }, this.b).a();
            this.i = false;
        }
        return tc.h((AudioManager) this.a.get(), this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(yb ybVar) {
        if (Objects.equals(this.d, ybVar)) {
            return;
        }
        this.d = ybVar;
        int iD = d(ybVar);
        this.f = iD;
        boolean z = true;
        if (iD != 1 && iD != 0) {
            z = false;
        }
        gg3.e(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 4 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        a aVar = this.c;
        if (aVar != null) {
            aVar.c(f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m(int i) {
        return i != 1 && this.f == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int n(boolean z, int i) {
        if (!m(i)) {
            c();
            l(0);
            return 1;
        }
        if (z) {
            return i();
        }
        int i2 = this.e;
        if (i2 != 1) {
            return i2 != 3 ? 1 : 0;
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o() {
        yb ybVar = this.d;
        return ybVar != null && ybVar.a == 1;
    }
}
