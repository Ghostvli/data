package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioProfile;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import defpackage.dj1;
import defpackage.xi1;
import defpackage.zi1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ec {
    public static final xi1 e;
    public static final xi1 f;
    public static final ec g;
    public static final xi1 h;
    public static final zi1 i;
    public final SparseArray a;
    public final int b;
    public final xi1 c;
    public final xi1 d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static xi1 a(yb ybVar) {
            xi1.a aVarM = xi1.m();
            pw4 it = ec.i.keySet().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                int iIntValue = num.intValue();
                if (Build.VERSION.SDK_INT >= fy4.Q(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), ybVar.c())) {
                    aVarM.a(num);
                }
            }
            aVarM.a(2);
            return aVarM.k();
        }

        public static int b(int i, int i2, yb ybVar) {
            for (int i3 = 10; i3 > 0; i3--) {
                int iS = fy4.S(i3);
                if (iS != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(iS).build(), ybVar.c())) {
                    return i3;
                }
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public static ec a(AudioManager audioManager, yb ybVar, List list, List list2) {
            return new ec(ec.c(audioManager.getDirectProfilesForAttributes(ybVar.c())), list, list2);
        }

        public static AudioDeviceInfo b(AudioManager audioManager, yb ybVar) {
            List<AudioDeviceInfo> audioDevicesForAttributes = ((AudioManager) gg3.q(audioManager)).getAudioDevicesForAttributes(ybVar.c());
            if (audioDevicesForAttributes.isEmpty()) {
                return null;
            }
            return audioDevicesForAttributes.get(0);
        }
    }

    static {
        xi1 xi1VarW = xi1.w(12);
        e = xi1VarW;
        xi1 xi1VarU = xi1.u();
        f = xi1VarU;
        g = new ec(xi1.w(d.d), xi1VarW, xi1VarU);
        h = xi1.y(2, 5, 6);
        i = new zi1.a().g(5, 6).g(17, 6).g(7, 6).g(30, 10).g(18, 6).g(6, 8).g(8, 8).g(14, 8).d();
    }

    public ec(List list, List list2, List list3) {
        this.a = new SparseArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = (d) list.get(i2);
            this.a.put(dVar.a, dVar);
        }
        int iMax = 0;
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            iMax = Math.max(iMax, ((d) this.a.valueAt(i3)).b);
        }
        this.b = iMax;
        this.c = xi1.p(list2);
        this.d = xi1.p(list3);
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        return str.equals("Amazon") || str.equals("Xiaomi");
    }

    public static xi1 c(List list) {
        HashMap map = new HashMap();
        map.put(2, new HashSet(ll1.c(12)));
        for (int i2 = 0; i2 < list.size(); i2++) {
            AudioProfile audioProfileA = dc.a(list.get(i2));
            if (audioProfileA.getEncapsulationType() != 1) {
                int format = audioProfileA.getFormat();
                if (fy4.R0(format) || i.containsKey(Integer.valueOf(format))) {
                    if (map.containsKey(Integer.valueOf(format))) {
                        ((Set) gg3.q((Set) map.get(Integer.valueOf(format)))).addAll(ll1.c(audioProfileA.getChannelMasks()));
                    } else {
                        map.put(Integer.valueOf(format), new HashSet(ll1.c(audioProfileA.getChannelMasks())));
                    }
                }
            }
        }
        xi1.a aVarM = xi1.m();
        for (Map.Entry entry : map.entrySet()) {
            aVarM.a(new d(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
        }
        return aVarM.k();
    }

    public static xi1 d(int[] iArr, int i2) {
        xi1.a aVarM = xi1.m();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i3 : iArr) {
            aVarM.a(new d(i3, i2));
        }
        return aVarM.k();
    }

    public static ec e(Context context, yb ybVar, AudioDeviceInfo audioDeviceInfo, List list) {
        return f(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), ybVar, audioDeviceInfo, list);
    }

    public static ec f(Context context, Intent intent, yb ybVar, AudioDeviceInfo audioDeviceInfo, List list) {
        AudioManager audioManagerC = tc.c(context);
        if (audioDeviceInfo == null) {
            audioDeviceInfo = Build.VERSION.SDK_INT >= 33 ? c.b(audioManagerC, ybVar) : null;
        }
        xi1 xi1VarG = audioDeviceInfo != null ? qb4.g(audioDeviceInfo) : e;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33 && (fy4.W0(context) || fy4.O0(context))) {
            return c.a(audioManagerC, ybVar, xi1VarG, list);
        }
        if (l(audioManagerC, audioDeviceInfo)) {
            return new ec(xi1.w(d.d), xi1VarG, list);
        }
        dj1.a aVar = new dj1.a();
        aVar.a(2);
        if (i2 >= 29 && (fy4.W0(context) || fy4.O0(context))) {
            aVar.i(b.a(ybVar));
            return new ec(d(ll1.n(aVar.k()), 10), xi1VarG, list);
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z || b()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            aVar.i(h);
        }
        if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new ec(d(ll1.n(aVar.k()), 10), xi1VarG, list);
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            aVar.i(ll1.c(intArrayExtra));
        }
        return new ec(d(ll1.n(aVar.k()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)), xi1VarG, list);
    }

    public static int g(int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 28) {
            if (i2 == 7) {
                i2 = 8;
            } else if (i2 == 3 || i2 == 4 || i2 == 5) {
                i2 = 6;
            }
        }
        if (i3 <= 26 && "fugu".equals(Build.DEVICE) && i2 == 1) {
            i2 = 2;
        }
        return fy4.S(i2);
    }

    public static Uri i() {
        if (b()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public static boolean l(AudioManager audioManager, AudioDeviceInfo audioDeviceInfo) {
        for (AudioDeviceInfo audioDeviceInfo2 : audioDeviceInfo == null ? ((AudioManager) gg3.q(audioManager)).getDevices(2) : new AudioDeviceInfo[]{audioDeviceInfo}) {
            if (mk0.a(audioDeviceInfo2.getType())) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ec)) {
            return false;
        }
        ec ecVar = (ec) obj;
        return fy4.w(this.a, ecVar.a) && this.b == ecVar.b && Objects.equals(this.c, ecVar.c) && Objects.equals(this.d, ecVar.d);
    }

    public Pair h(t41 t41Var, yb ybVar) {
        int iF = nt2.f((String) gg3.q(t41Var.p), t41Var.k);
        if (!i.containsKey(Integer.valueOf(iF))) {
            return null;
        }
        if (iF == 18 && !n(18)) {
            iF = 6;
        } else if ((iF == 8 && !n(8)) || (iF == 30 && !n(30))) {
            iF = 7;
        }
        if (!n(iF)) {
            return null;
        }
        d dVar = (d) gg3.q((d) this.a.get(iF));
        int iB = t41Var.H;
        if (iB == -1 || iF == 18) {
            int i2 = t41Var.I;
            if (i2 == -1) {
                i2 = 48000;
            }
            iB = dVar.b(i2, ybVar);
        } else if (!t41Var.p.equals("audio/vnd.dts.uhd;profile=p2") || Build.VERSION.SDK_INT >= 33) {
            if (!dVar.c(iB)) {
                return null;
            }
        } else if (iB > 10) {
            return null;
        }
        int iG = g(iB);
        if (iG == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iF), Integer.valueOf(iG));
    }

    public int hashCode() {
        return (((((this.b * 31) + fy4.x(this.a)) * 31) + Objects.hashCode(this.c)) * 31) + Objects.hashCode(this.d);
    }

    public xi1 j() {
        return this.d;
    }

    public xi1 k() {
        return this.c;
    }

    public boolean m(t41 t41Var, yb ybVar) {
        return h(t41Var, ybVar) != null;
    }

    public boolean n(int i2) {
        return fy4.u(this.a, i2);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.b + ", audioProfiles=" + this.a + ", speakerLayoutChannelMasks=" + this.c + ", spatializerChannelMasks=" + this.d + "]";
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public static final d d;
        public final int a;
        public final int b;
        public final dj1 c;

        static {
            d = Build.VERSION.SDK_INT >= 33 ? new d(2, a(10)) : new d(2, 10);
        }

        public d(int i, Set set) {
            this.a = i;
            dj1 dj1VarP = dj1.p(set);
            this.c = dj1VarP;
            pw4 it = dj1VarP.iterator();
            int iMax = 0;
            while (it.hasNext()) {
                iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
            }
            this.b = iMax;
        }

        public static dj1 a(int i) {
            dj1.a aVar = new dj1.a();
            for (int i2 = 1; i2 <= i; i2++) {
                aVar.a(Integer.valueOf(fy4.S(i2)));
            }
            return aVar.k();
        }

        public int b(int i, yb ybVar) {
            return this.c != null ? this.b : Build.VERSION.SDK_INT >= 29 ? b.b(this.a, i, ybVar) : ((Integer) gg3.q((Integer) ec.i.getOrDefault(Integer.valueOf(this.a), 0))).intValue();
        }

        public boolean c(int i) {
            if (this.c == null) {
                return i <= this.b;
            }
            int iS = fy4.S(i);
            if (iS == 0) {
                return false;
            }
            return this.c.contains(Integer.valueOf(iS));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b && Objects.equals(this.c, dVar.c);
        }

        public int hashCode() {
            int i = ((this.a * 31) + this.b) * 31;
            dj1 dj1Var = this.c;
            return i + (dj1Var == null ? 0 : dj1Var.hashCode());
        }

        public String toString() {
            return "AudioProfile[format=" + this.a + ", maxChannelCount=" + this.b + ", channelMasks=" + this.c + "]";
        }

        public d(int i, int i2) {
            this.a = i;
            this.b = i2;
            this.c = null;
        }
    }
}
