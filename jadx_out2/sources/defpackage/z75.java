package defpackage;

import android.media.VolumeProvider;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z75 {
    public final int a;
    public final int b;
    public final String c;
    public int d;
    public VolumeProvider e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends VolumeProvider {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i, int i2, int i3, String str) {
            super(i, i2, i3, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i) {
            z75.this.b(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i) {
            z75.this.c(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends VolumeProvider {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i) {
            z75.this.b(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i) {
            z75.this.c(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public z75(int i, int i2, int i3, String str) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.c = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object a() {
        z75 z75Var;
        if (this.e != null) {
            z75Var = this;
        } else if (Build.VERSION.SDK_INT >= 30) {
            z75Var = this;
            z75Var.e = z75Var.new a(this.a, this.b, this.d, this.c);
        } else {
            z75Var = this;
            z75Var.e = z75Var.new b(z75Var.a, z75Var.b, z75Var.d);
        }
        return z75Var.e;
    }

    public abstract void b(int i);

    public abstract void c(int i);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(int i) {
        this.d = i;
        ((VolumeProvider) a()).setCurrentVolume(i);
    }
}
