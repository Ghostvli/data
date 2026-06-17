package defpackage;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yb {
    public static final yb i = new d().a();
    public static final String j = fy4.N0(0);
    public static final String k = fy4.N0(1);
    public static final String l = fy4.N0(2);
    public static final String m = fy4.N0(3);
    public static final String n = fy4.N0(4);
    public static final String o = fy4.N0(5);
    public static final String p = fy4.N0(6);
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public AudioAttributes h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void b(AudioAttributes.Builder builder, int i) {
            builder.setAllowedCapturePolicy(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void c(AudioAttributes.Builder builder, boolean z) {
            builder.setHapticChannelsMuted(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(AudioAttributes.Builder builder, boolean z) {
            builder.setIsContentSpatialized(z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void b(AudioAttributes.Builder builder, int i) {
            builder.setSpatializationBehavior(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public int a = 0;
        public int b = 0;
        public int c = 1;
        public int d = 1;
        public int e = 0;
        public boolean f = false;
        public boolean g = true;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public yb a() {
            return new yb(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d b(int i) {
            this.d = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d c(int i) {
            this.a = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d d(int i) {
            this.b = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d e(boolean z) {
            this.g = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d f(boolean z) {
            this.f = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d g(int i) {
            this.e = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d h(int i) {
            this.c = i;
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yb(int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
        this.f = z;
        this.g = z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yb a(Bundle bundle) {
        d dVar = new d();
        String str = j;
        if (bundle.containsKey(str)) {
            dVar.c(bundle.getInt(str));
        }
        String str2 = k;
        if (bundle.containsKey(str2)) {
            dVar.d(bundle.getInt(str2));
        }
        String str3 = l;
        if (bundle.containsKey(str3)) {
            dVar.h(bundle.getInt(str3));
        }
        String str4 = m;
        if (bundle.containsKey(str4)) {
            dVar.b(bundle.getInt(str4));
        }
        String str5 = n;
        if (bundle.containsKey(str5)) {
            dVar.g(bundle.getInt(str5));
        }
        String str6 = o;
        if (bundle.containsKey(str6)) {
            dVar.f(bundle.getBoolean(str6));
        }
        String str7 = p;
        if (bundle.containsKey(str7)) {
            dVar.e(bundle.getBoolean(str7));
        }
        return dVar.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yb b(AudioAttributes audioAttributes) {
        d dVarH = new d().c(audioAttributes.getContentType()).d(audioAttributes.getFlags()).h(audioAttributes.getUsage());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            dVarH.b(audioAttributes.getAllowedCapturePolicy());
            dVarH.e(audioAttributes.areHapticChannelsMuted());
        }
        if (i2 >= 32) {
            dVarH.g(audioAttributes.getSpatializationBehavior());
            dVarH.f(audioAttributes.isContentSpatialized());
        }
        return dVarH.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AudioAttributes c() {
        if (this.h == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.a).setFlags(this.b).setUsage(this.c);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                b.b(usage, this.d);
                b.c(usage, this.g);
            }
            if (i2 >= 32) {
                c.b(usage, this.e);
                c.a(usage, this.f);
            }
            this.h = usage.build();
        }
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int d() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                int volumeControlStream = c().getVolumeControlStream();
                if (volumeControlStream == Integer.MIN_VALUE) {
                    return 3;
                }
                return volumeControlStream;
            } catch (RuntimeException unused) {
                return 3;
            }
        }
        if ((this.b & 1) == 1) {
            return 1;
        }
        switch (this.c) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 12:
            default:
                return 3;
            case 13:
                return 1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e() {
        return d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && yb.class == obj.getClass()) {
            yb ybVar = (yb) obj;
            if (this.a == ybVar.a && this.b == ybVar.b && this.c == ybVar.c && this.d == ybVar.d && this.e == ybVar.e && this.f == ybVar.f && this.g == ybVar.g) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle f() {
        Bundle bundle = new Bundle();
        int i2 = this.a;
        if (i2 != 0) {
            bundle.putInt(j, i2);
        }
        int i3 = this.b;
        if (i3 != 0) {
            bundle.putInt(k, i3);
        }
        int i4 = this.c;
        if (i4 != 1) {
            bundle.putInt(l, i4);
        }
        int i5 = this.d;
        if (i5 != 1) {
            bundle.putInt(m, i5);
        }
        int i6 = this.e;
        if (i6 != 0) {
            bundle.putInt(n, i6);
        }
        boolean z = this.f;
        if (z) {
            bundle.putBoolean(o, z);
        }
        boolean z2 = this.g;
        if (!z2) {
            bundle.putBoolean(p, z2);
        }
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return ((((((((((((527 + this.a) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0);
    }
}
