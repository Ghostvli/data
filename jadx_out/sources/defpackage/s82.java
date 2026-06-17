package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.o;
import androidx.media3.exoplayer.p;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.c35;
import defpackage.d35;
import defpackage.fd3;
import defpackage.jq2;
import defpackage.l25;
import defpackage.no4;
import defpackage.y72;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;
import net.engio.mbassy.listener.MessageHandler;
import okio.Utf8;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class s82 extends i82 implements l25.b {
    public static final int[] M1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public static boolean N1;
    public static boolean O1;
    public e35 A1;
    public e35 B1;
    public int C1;
    public boolean D1;
    public int E1;
    public f F1;
    public j25 G1;
    public long H1;
    public long I1;
    public boolean J1;
    public int K1;
    public long L1;
    public final Context Q0;
    public final boolean R0;
    public final c35.a S0;
    public final int T0;
    public final boolean U0;
    public final l25 V0;
    public final l25.a W0;
    public final bf X0;
    public final long Y0;
    public final m25 Z0;
    public final PriorityQueue a1;
    public final boolean b1;
    public final boolean c1;
    public e d1;
    public boolean e1;
    public boolean f1;
    public d35 g1;
    public boolean h1;
    public int i1;
    public List j1;
    public Surface k1;
    public hb3 l1;
    public d94 m1;
    public boolean n1;
    public int o1;
    public int p1;
    public long q1;
    public int r1;
    public int s1;
    public int t1;
    public fz3 u1;
    public long v1;
    public boolean w1;
    public long x1;
    public int y1;
    public long z1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements d35.a {
        public a() {
        }

        @Override // d35.a
        public void a() {
            if (s82.this.k1 != null) {
                s82.this.X2();
            }
        }

        @Override // d35.a
        public void b() {
            if (s82.this.k1 != null) {
                s82.this.s3(0, 1);
            }
        }

        @Override // d35.a
        public void c() {
            o.a aVarF1 = s82.this.f1();
            if (aVarF1 != null) {
                aVarF1.b();
            }
        }

        @Override // d35.a
        public void onVideoSizeChanged(e35 e35Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements d35.b {
        public final /* synthetic */ y72 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public b(y72 y72Var, int i, long j) {
            this.a = y72Var;
            this.b = i;
            this.c = j;
        }

        @Override // d35.b
        public void a(long j) {
            s82.this.c3(this.a, this.b, this.c, j);
        }

        @Override // d35.b
        public void skip() {
            s82.this.z2(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public static boolean a(Context context) {
            Display.HdrCapabilities hdrCapabilities;
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr() || (hdrCapabilities = display.getHdrCapabilities()) == null) {
                return false;
            }
            for (int i : hdrCapabilities.getSupportedHdrTypes()) {
                if (i == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final Context a;
        public boolean b;
        public y72.b d;
        public long e;
        public boolean f;
        public Handler g;
        public c35 h;
        public int i;
        public d35 k;
        public boolean n;
        public boolean o;
        public l82 c = l82.a;
        public float j = 30.0f;
        public boolean l = true;
        public long m = 15000;

        public d(Context context) {
            this.a = context;
            this.d = y72.b.b(context);
        }

        public s82 o() {
            gg3.v(!this.b);
            Handler handler = this.g;
            gg3.v((handler == null && this.h == null) || !(handler == null || this.h == null));
            this.b = true;
            return new s82(this);
        }

        public d p(boolean z) {
            this.n = z;
            return this;
        }

        public d q(long j) {
            this.m = j;
            return this;
        }

        public d r(boolean z) {
            this.l = z;
            return this;
        }

        public d s(long j) {
            this.e = j;
            return this;
        }

        public d t(y72.b bVar) {
            this.d = bVar;
            return this;
        }

        public d u(boolean z) {
            this.f = z;
            return this;
        }

        public d v(boolean z) {
            this.o = z;
            return this;
        }

        public d w(Handler handler) {
            this.g = handler;
            return this;
        }

        public d x(c35 c35Var) {
            this.h = c35Var;
            return this;
        }

        public d y(int i) {
            this.i = i;
            return this;
        }

        public d z(l82 l82Var) {
            this.c = l82Var;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final int a;
        public final int b;
        public final int c;

        public e(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class f implements y72.d, Handler.Callback {
        public final Handler f;

        public f(y72 y72Var) {
            Handler handlerF = fy4.F(this);
            this.f = handlerF;
            y72Var.s(this, handlerF);
        }

        @Override // y72.d
        public void a(y72 y72Var, long j, long j2) {
            if (Build.VERSION.SDK_INT >= 30) {
                b(j);
            } else {
                this.f.sendMessageAtFrontOfQueue(Message.obtain(this.f, 0, (int) (j >> 32), (int) j));
            }
        }

        public final void b(long j) {
            s82 s82Var = s82.this;
            if (this != s82Var.F1 || s82Var.O0() == null) {
                return;
            }
            s82 s82Var2 = s82.this;
            if (j == Long.MAX_VALUE) {
                s82Var2.Z2();
                return;
            }
            try {
                s82Var2.Y2(j);
            } catch (zv0 e) {
                s82.this.U1(e);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(fy4.O1(message.arg1, message.arg2));
            return true;
        }
    }

    public s82(d dVar) {
        super(dVar.a.getApplicationContext(), 2, dVar.d, dVar.c, dVar.f, dVar.j);
        Context applicationContext = dVar.a.getApplicationContext();
        this.Q0 = applicationContext;
        this.T0 = dVar.i;
        this.g1 = dVar.k;
        this.S0 = new c35.a(dVar.g, dVar.h);
        this.R0 = this.g1 == null;
        this.V0 = new l25(applicationContext, this, dVar.e);
        this.W0 = new l25.a();
        this.U0 = y2();
        this.m1 = d94.c;
        this.o1 = 1;
        this.p1 = 0;
        this.A1 = e35.e;
        this.E1 = 0;
        this.B1 = null;
        this.C1 = -1000;
        this.H1 = -9223372036854775807L;
        this.I1 = -9223372036854775807L;
        this.X0 = dVar.l ? new bf() : null;
        this.a1 = new PriorityQueue();
        if (dVar.m != -9223372036854775807L) {
            this.Y0 = -dVar.m;
            this.Z0 = new m25(1.0f);
        } else {
            this.Y0 = -9223372036854775807L;
            this.Z0 = null;
        }
        this.b1 = dVar.n;
        this.c1 = dVar.o;
        this.L1 = -9223372036854775807L;
        this.u1 = null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean A2() {
        String str;
        int i = Build.VERSION.SDK_INT;
        byte b2 = 7;
        if (i <= 28) {
            String str2 = Build.DEVICE;
            str2.getClass();
            switch (str2) {
            }
            return true;
        }
        if (i <= 27 && "HWEML".equals(Build.DEVICE)) {
            return true;
        }
        str = Build.MODEL;
        str.getClass();
        switch (str) {
            case "AFTJMST12":
            case "AFTKMST12":
            case "AFTA":
            case "AFTN":
            case "AFTR":
            case "AFTEU011":
            case "AFTEU014":
            case "AFTSO001":
            case "AFTEUFF014":
                break;
            default:
                if (i <= 26) {
                    String str3 = Build.DEVICE;
                    str3.getClass();
                    switch (str3.hashCode()) {
                        case -2144781245:
                            b2 = !str3.equals("GIONEE_SWW1609") ? (byte) -1 : (byte) 0;
                            break;
                        case -2144781185:
                            b2 = !str3.equals("GIONEE_SWW1627") ? (byte) -1 : (byte) 1;
                            break;
                        case -2144781160:
                            b2 = !str3.equals("GIONEE_SWW1631") ? (byte) -1 : (byte) 2;
                            break;
                        case -2097309513:
                            b2 = !str3.equals("K50a40") ? (byte) -1 : (byte) 3;
                            break;
                        case -2022874474:
                            b2 = !str3.equals("CP8676_I02") ? (byte) -1 : (byte) 4;
                            break;
                        case -1978993182:
                            b2 = !str3.equals("NX541J") ? (byte) -1 : (byte) 5;
                            break;
                        case -1978990237:
                            b2 = !str3.equals("NX573J") ? (byte) -1 : (byte) 6;
                            break;
                        case -1936688988:
                            if (!str3.equals("PGN528")) {
                                b2 = -1;
                            }
                            break;
                        case -1936688066:
                            b2 = !str3.equals("PGN610") ? (byte) -1 : (byte) 8;
                            break;
                        case -1936688065:
                            b2 = !str3.equals("PGN611") ? (byte) -1 : (byte) 9;
                            break;
                        case -1931988508:
                            b2 = !str3.equals("AquaPowerM") ? (byte) -1 : (byte) 10;
                            break;
                        case -1885099851:
                            b2 = !str3.equals("RAIJIN") ? (byte) -1 : (byte) 11;
                            break;
                        case -1696512866:
                            b2 = !str3.equals("XT1663") ? (byte) -1 : (byte) 12;
                            break;
                        case -1680025915:
                            b2 = !str3.equals("ComioS1") ? (byte) -1 : (byte) 13;
                            break;
                        case -1615810839:
                            b2 = !str3.equals("Phantom6") ? (byte) -1 : (byte) 14;
                            break;
                        case -1600724499:
                            b2 = !str3.equals("pacificrim") ? (byte) -1 : (byte) 15;
                            break;
                        case -1554255044:
                            b2 = !str3.equals("vernee_M5") ? (byte) -1 : (byte) 16;
                            break;
                        case -1481772737:
                            b2 = !str3.equals("panell_dl") ? (byte) -1 : (byte) 17;
                            break;
                        case -1481772730:
                            b2 = !str3.equals("panell_ds") ? (byte) -1 : (byte) 18;
                            break;
                        case -1481772729:
                            b2 = !str3.equals("panell_dt") ? (byte) -1 : (byte) 19;
                            break;
                        case -1320080169:
                            b2 = !str3.equals("GiONEE_GBL7319") ? (byte) -1 : (byte) 20;
                            break;
                        case -1217592143:
                            b2 = !str3.equals("BRAVIA_ATV2") ? (byte) -1 : (byte) 21;
                            break;
                        case -1180384755:
                            b2 = !str3.equals("iris60") ? (byte) -1 : (byte) 22;
                            break;
                        case -1139198265:
                            b2 = !str3.equals("Slate_Pro") ? (byte) -1 : (byte) 23;
                            break;
                        case -1052835013:
                            b2 = !str3.equals("namath") ? (byte) -1 : (byte) 24;
                            break;
                        case -993250464:
                            b2 = !str3.equals("A10-70F") ? (byte) -1 : (byte) 25;
                            break;
                        case -993250458:
                            b2 = !str3.equals("A10-70L") ? (byte) -1 : (byte) 26;
                            break;
                        case -965403638:
                            b2 = !str3.equals("s905x018") ? (byte) -1 : (byte) 27;
                            break;
                        case -958336948:
                            b2 = !str3.equals("ELUGA_Ray_X") ? (byte) -1 : (byte) 28;
                            break;
                        case -879245230:
                            b2 = !str3.equals("tcl_eu") ? (byte) -1 : (byte) 29;
                            break;
                        case -842500323:
                            b2 = !str3.equals("nicklaus_f") ? (byte) -1 : (byte) 30;
                            break;
                        case -821392978:
                            b2 = !str3.equals("A7000-a") ? (byte) -1 : (byte) 31;
                            break;
                        case -797483286:
                            b2 = !str3.equals("SVP-DTV15") ? (byte) -1 : (byte) 32;
                            break;
                        case -794946968:
                            b2 = !str3.equals("watson") ? (byte) -1 : (byte) 33;
                            break;
                        case -788334647:
                            b2 = !str3.equals("whyred") ? (byte) -1 : (byte) 34;
                            break;
                        case -782144577:
                            b2 = !str3.equals("OnePlus5T") ? (byte) -1 : (byte) 35;
                            break;
                        case -575125681:
                            b2 = !str3.equals("GiONEE_CBL7513") ? (byte) -1 : (byte) 36;
                            break;
                        case -521118391:
                            b2 = !str3.equals("GIONEE_GBL7360") ? (byte) -1 : (byte) 37;
                            break;
                        case -430914369:
                            b2 = !str3.equals("Pixi4-7_3G") ? (byte) -1 : (byte) 38;
                            break;
                        case -290434366:
                            b2 = !str3.equals("taido_row") ? (byte) -1 : (byte) 39;
                            break;
                        case -282781963:
                            b2 = !str3.equals("BLACK-1X") ? (byte) -1 : (byte) 40;
                            break;
                        case -277133239:
                            b2 = !str3.equals("Z12_PRO") ? (byte) -1 : (byte) 41;
                            break;
                        case -173639913:
                            b2 = !str3.equals("ELUGA_A3_Pro") ? (byte) -1 : (byte) 42;
                            break;
                        case -56598463:
                            b2 = !str3.equals("woods_fn") ? (byte) -1 : (byte) 43;
                            break;
                        case 2126:
                            b2 = !str3.equals("C1") ? (byte) -1 : (byte) 44;
                            break;
                        case 2564:
                            b2 = !str3.equals("Q5") ? (byte) -1 : (byte) 45;
                            break;
                        case 2715:
                            b2 = !str3.equals("V1") ? (byte) -1 : (byte) 46;
                            break;
                        case 2719:
                            b2 = !str3.equals("V5") ? (byte) -1 : (byte) 47;
                            break;
                        case 3091:
                            b2 = !str3.equals("b5") ? (byte) -1 : (byte) 48;
                            break;
                        case 3483:
                            b2 = !str3.equals("mh") ? (byte) -1 : (byte) 49;
                            break;
                        case 73405:
                            b2 = !str3.equals("JGZ") ? (byte) -1 : (byte) 50;
                            break;
                        case 75537:
                            b2 = !str3.equals("M04") ? (byte) -1 : (byte) 51;
                            break;
                        case 75739:
                            b2 = !str3.equals("M5c") ? (byte) -1 : (byte) 52;
                            break;
                        case 76779:
                            b2 = !str3.equals("MX6") ? (byte) -1 : (byte) 53;
                            break;
                        case 78669:
                            b2 = !str3.equals("P85") ? (byte) -1 : (byte) 54;
                            break;
                        case 79305:
                            b2 = !str3.equals("PLE") ? (byte) -1 : (byte) 55;
                            break;
                        case 80618:
                            b2 = !str3.equals("QX1") ? (byte) -1 : (byte) 56;
                            break;
                        case 88274:
                            b2 = !str3.equals("Z80") ? (byte) -1 : (byte) 57;
                            break;
                        case 98846:
                            b2 = !str3.equals("cv1") ? (byte) -1 : (byte) 58;
                            break;
                        case 98848:
                            b2 = !str3.equals("cv3") ? (byte) -1 : (byte) 59;
                            break;
                        case 99329:
                            b2 = !str3.equals("deb") ? (byte) -1 : (byte) 60;
                            break;
                        case 101481:
                            b2 = !str3.equals("flo") ? (byte) -1 : (byte) 61;
                            break;
                        case 1513190:
                            b2 = !str3.equals("1601") ? (byte) -1 : (byte) 62;
                            break;
                        case 1514184:
                            b2 = !str3.equals("1713") ? (byte) -1 : Utf8.REPLACEMENT_BYTE;
                            break;
                        case 1514185:
                            b2 = !str3.equals("1714") ? (byte) -1 : (byte) 64;
                            break;
                        case 2133089:
                            b2 = !str3.equals("F01H") ? (byte) -1 : (byte) 65;
                            break;
                        case 2133091:
                            b2 = !str3.equals("F01J") ? (byte) -1 : (byte) 66;
                            break;
                        case 2133120:
                            b2 = !str3.equals("F02H") ? (byte) -1 : (byte) 67;
                            break;
                        case 2133151:
                            b2 = !str3.equals("F03H") ? (byte) -1 : (byte) 68;
                            break;
                        case 2133182:
                            b2 = !str3.equals("F04H") ? (byte) -1 : (byte) 69;
                            break;
                        case 2133184:
                            b2 = !str3.equals("F04J") ? (byte) -1 : (byte) 70;
                            break;
                        case 2436959:
                            b2 = !str3.equals("P681") ? (byte) -1 : (byte) 71;
                            break;
                        case 2463773:
                            b2 = !str3.equals("Q350") ? (byte) -1 : (byte) 72;
                            break;
                        case 2464648:
                            b2 = !str3.equals("Q427") ? (byte) -1 : (byte) 73;
                            break;
                        case 2689555:
                            b2 = !str3.equals("XE2X") ? (byte) -1 : (byte) 74;
                            break;
                        case 3154429:
                            b2 = !str3.equals("fugu") ? (byte) -1 : (byte) 75;
                            break;
                        case 3284551:
                            b2 = !str3.equals("kate") ? (byte) -1 : (byte) 76;
                            break;
                        case 3351335:
                            b2 = !str3.equals("mido") ? (byte) -1 : (byte) 77;
                            break;
                        case 3386211:
                            b2 = !str3.equals("p212") ? (byte) -1 : (byte) 78;
                            break;
                        case 41325051:
                            b2 = !str3.equals("MEIZU_M5") ? (byte) -1 : (byte) 79;
                            break;
                        case 51349633:
                            b2 = !str3.equals("601LV") ? (byte) -1 : (byte) 80;
                            break;
                        case 51350594:
                            b2 = !str3.equals("602LV") ? (byte) -1 : (byte) 81;
                            break;
                        case 55178625:
                            b2 = !str3.equals("Aura_Note_2") ? (byte) -1 : (byte) 82;
                            break;
                        case 61542055:
                            b2 = !str3.equals("A1601") ? (byte) -1 : (byte) 83;
                            break;
                        case 65355429:
                            b2 = !str3.equals("E5643") ? (byte) -1 : (byte) 84;
                            break;
                        case 66214468:
                            b2 = !str3.equals("F3111") ? (byte) -1 : (byte) 85;
                            break;
                        case 66214470:
                            b2 = !str3.equals("F3113") ? (byte) -1 : (byte) 86;
                            break;
                        case 66214473:
                            b2 = !str3.equals("F3116") ? (byte) -1 : (byte) 87;
                            break;
                        case 66215429:
                            b2 = !str3.equals("F3211") ? (byte) -1 : (byte) 88;
                            break;
                        case 66215431:
                            b2 = !str3.equals("F3213") ? (byte) -1 : (byte) 89;
                            break;
                        case 66215433:
                            b2 = !str3.equals("F3215") ? (byte) -1 : (byte) 90;
                            break;
                        case 66216390:
                            b2 = !str3.equals("F3311") ? (byte) -1 : (byte) 91;
                            break;
                        case 76402249:
                            b2 = !str3.equals("PRO7S") ? (byte) -1 : (byte) 92;
                            break;
                        case 76404105:
                            b2 = !str3.equals("Q4260") ? (byte) -1 : (byte) 93;
                            break;
                        case 76404911:
                            b2 = !str3.equals("Q4310") ? (byte) -1 : (byte) 94;
                            break;
                        case 80963634:
                            b2 = !str3.equals("V23GB") ? (byte) -1 : (byte) 95;
                            break;
                        case 82882791:
                            b2 = !str3.equals("X3_HK") ? (byte) -1 : (byte) 96;
                            break;
                        case 98715550:
                            b2 = !str3.equals("i9031") ? (byte) -1 : (byte) 97;
                            break;
                        case 101370885:
                            b2 = !str3.equals("l5460") ? (byte) -1 : (byte) 98;
                            break;
                        case 102844228:
                            b2 = !str3.equals("le_x6") ? (byte) -1 : (byte) 99;
                            break;
                        case 165221241:
                            b2 = !str3.equals("A2016a40") ? (byte) -1 : (byte) 100;
                            break;
                        case 182191441:
                            b2 = !str3.equals("CPY83_I00") ? (byte) -1 : (byte) 101;
                            break;
                        case 245388979:
                            b2 = !str3.equals("marino_f") ? (byte) -1 : (byte) 102;
                            break;
                        case 287431619:
                            b2 = !str3.equals("griffin") ? (byte) -1 : (byte) 103;
                            break;
                        case 307593612:
                            b2 = !str3.equals("A7010a48") ? (byte) -1 : (byte) 104;
                            break;
                        case 308517133:
                            b2 = !str3.equals("A7020a48") ? (byte) -1 : (byte) 105;
                            break;
                        case 316215098:
                            b2 = !str3.equals("TB3-730F") ? (byte) -1 : (byte) 106;
                            break;
                        case 316215116:
                            b2 = !str3.equals("TB3-730X") ? (byte) -1 : (byte) 107;
                            break;
                        case 316246811:
                            b2 = !str3.equals("TB3-850F") ? (byte) -1 : (byte) 108;
                            break;
                        case 316246818:
                            b2 = !str3.equals("TB3-850M") ? (byte) -1 : (byte) 109;
                            break;
                        case 407160593:
                            b2 = !str3.equals("Pixi5-10_4G") ? (byte) -1 : (byte) 110;
                            break;
                        case 507412548:
                            b2 = !str3.equals("QM16XE_U") ? (byte) -1 : (byte) 111;
                            break;
                        case 793982701:
                            b2 = !str3.equals("GIONEE_WBL5708") ? (byte) -1 : (byte) 112;
                            break;
                        case 794038622:
                            b2 = !str3.equals("GIONEE_WBL7365") ? (byte) -1 : (byte) 113;
                            break;
                        case 794040393:
                            b2 = !str3.equals("GIONEE_WBL7519") ? (byte) -1 : (byte) 114;
                            break;
                        case 835649806:
                            b2 = !str3.equals("manning") ? (byte) -1 : (byte) 115;
                            break;
                        case 917340916:
                            b2 = !str3.equals("A7000plus") ? (byte) -1 : (byte) 116;
                            break;
                        case 958008161:
                            b2 = !str3.equals("j2xlteins") ? (byte) -1 : (byte) 117;
                            break;
                        case 1060579533:
                            b2 = !str3.equals("panell_d") ? (byte) -1 : (byte) 118;
                            break;
                        case 1150207623:
                            b2 = !str3.equals("LS-5017") ? (byte) -1 : (byte) 119;
                            break;
                        case 1176899427:
                            b2 = !str3.equals("itel_S41") ? (byte) -1 : (byte) 120;
                            break;
                        case 1280332038:
                            b2 = !str3.equals("hwALE-H") ? (byte) -1 : (byte) 121;
                            break;
                        case 1306947716:
                            b2 = !str3.equals("EverStar_S") ? (byte) -1 : (byte) 122;
                            break;
                        case 1349174697:
                            b2 = !str3.equals("htc_e56ml_dtul") ? (byte) -1 : (byte) 123;
                            break;
                        case 1522194893:
                            b2 = !str3.equals("woods_f") ? (byte) -1 : (byte) 124;
                            break;
                        case 1691543273:
                            b2 = !str3.equals("CPH1609") ? (byte) -1 : (byte) 125;
                            break;
                        case 1691544261:
                            b2 = !str3.equals("CPH1715") ? (byte) -1 : (byte) 126;
                            break;
                        case 1709443163:
                            b2 = !str3.equals("iball8735_9806") ? (byte) -1 : (byte) 127;
                            break;
                        case 1865889110:
                            b2 = !str3.equals("santoni") ? (byte) -1 : (byte) 128;
                            break;
                        case 1906253259:
                            b2 = !str3.equals("PB2-670M") ? (byte) -1 : (byte) 129;
                            break;
                        case 1977196784:
                            b2 = !str3.equals("Infinix-X572") ? (byte) -1 : (byte) 130;
                            break;
                        case 2006372676:
                            b2 = !str3.equals("BRAVIA_ATV3_4K") ? (byte) -1 : (byte) 131;
                            break;
                        case 2019281702:
                            b2 = !str3.equals("DM-01K") ? (byte) -1 : (byte) 132;
                            break;
                        case 2029784656:
                            b2 = !str3.equals("HWBLN-H") ? (byte) -1 : (byte) 133;
                            break;
                        case 2030379515:
                            b2 = !str3.equals("HWCAM-H") ? (byte) -1 : (byte) 134;
                            break;
                        case 2033393791:
                            b2 = !str3.equals("ASUS_X00AD_2") ? (byte) -1 : (byte) 135;
                            break;
                        case 2047190025:
                            b2 = !str3.equals("ELUGA_Note") ? (byte) -1 : (byte) 136;
                            break;
                        case 2047252157:
                            b2 = !str3.equals("ELUGA_Prim") ? (byte) -1 : (byte) 137;
                            break;
                        case 2048319463:
                            b2 = !str3.equals("HWVNS-H") ? (byte) -1 : (byte) 138;
                            break;
                        case 2048855701:
                            b2 = !str3.equals("HWWAS-H") ? (byte) -1 : (byte) 139;
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    switch (b2) {
                        default:
                            str.getClass();
                            if (!str.equals("JSN-L21")) {
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case Token.GETPROPNOWARN /* 34 */:
                        case 35:
                        case 36:
                        case Token.SETPROP /* 37 */:
                        case Token.SETPROP_SUPER /* 38 */:
                        case Token.GETELEM /* 39 */:
                        case 40:
                        case Token.SETELEM /* 41 */:
                        case Token.SETELEM_SUPER /* 42 */:
                        case Token.CALL /* 43 */:
                        case Token.NAME /* 44 */:
                        case Token.NUMBER /* 45 */:
                        case Token.STRING /* 46 */:
                        case Token.NULL /* 47 */:
                        case 48:
                        case Token.FALSE /* 49 */:
                        case 50:
                        case Token.SHEQ /* 51 */:
                        case Token.SHNE /* 52 */:
                        case Token.REGEXP /* 53 */:
                        case Token.BINDNAME /* 54 */:
                        case Token.THROW /* 55 */:
                        case Token.RETHROW /* 56 */:
                        case Token.IN /* 57 */:
                        case Token.INSTANCEOF /* 58 */:
                        case Token.LOCAL_LOAD /* 59 */:
                        case 60:
                        case Token.SETVAR /* 61 */:
                        case Token.CATCH_SCOPE /* 62 */:
                        case Token.ENUM_INIT_KEYS /* 63 */:
                        case 64:
                        case Token.ENUM_INIT_ARRAY /* 65 */:
                        case Token.ENUM_INIT_VALUES_IN_ORDER /* 66 */:
                        case Token.ENUM_NEXT /* 67 */:
                        case Token.ENUM_ID /* 68 */:
                        case Token.THISFN /* 69 */:
                        case 70:
                        case Token.ARRAYLIT /* 71 */:
                        case Token.OBJECTLIT /* 72 */:
                        case Token.GET_REF /* 73 */:
                        case Token.SET_REF /* 74 */:
                        case Token.DEL_REF /* 75 */:
                        case Token.REF_CALL /* 76 */:
                        case Token.REF_SPECIAL /* 77 */:
                        case Token.YIELD /* 78 */:
                        case Token.SUPER /* 79 */:
                        case Token.STRICT_SETNAME /* 80 */:
                        case Token.EXP /* 81 */:
                        case Token.DEFAULTNAMESPACE /* 82 */:
                        case Token.ESCXMLATTR /* 83 */:
                        case Token.ESCXMLTEXT /* 84 */:
                        case Token.REF_MEMBER /* 85 */:
                        case Token.REF_NS_MEMBER /* 86 */:
                        case Token.REF_NAME /* 87 */:
                        case Token.REF_NS_NAME /* 88 */:
                        case 89:
                        case 90:
                        case Token.SEMI /* 91 */:
                        case Token.LB /* 92 */:
                        case Token.RB /* 93 */:
                        case Token.LC /* 94 */:
                        case Token.RC /* 95 */:
                        case Token.LP /* 96 */:
                        case Token.RP /* 97 */:
                        case Token.COMMA /* 98 */:
                        case 99:
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case Token.ASSIGN_LOGICAL_AND /* 104 */:
                        case Token.ASSIGN_LSH /* 105 */:
                        case Token.ASSIGN_RSH /* 106 */:
                        case Token.ASSIGN_URSH /* 107 */:
                        case Token.ASSIGN_ADD /* 108 */:
                        case Token.ASSIGN_SUB /* 109 */:
                        case 110:
                        case Token.ASSIGN_DIV /* 111 */:
                        case Token.ASSIGN_MOD /* 112 */:
                        case Token.ASSIGN_EXP /* 113 */:
                        case 114:
                        case Token.HOOK /* 115 */:
                        case Token.COLON /* 116 */:
                        case Token.OR /* 117 */:
                        case Token.AND /* 118 */:
                        case Token.INC /* 119 */:
                        case 120:
                        case Token.DOT /* 121 */:
                        case Token.FUNCTION /* 122 */:
                        case Token.EXPORT /* 123 */:
                        case Token.IMPORT /* 124 */:
                        case Token.IF /* 125 */:
                        case 126:
                        case 127:
                        case 128:
                        case Token.DEFAULT /* 129 */:
                        case 130:
                        case Token.DO /* 131 */:
                        case Token.FOR /* 132 */:
                        case Token.BREAK /* 133 */:
                        case Token.CONTINUE /* 134 */:
                        case Token.VAR /* 135 */:
                        case Token.WITH /* 136 */:
                        case Token.CATCH /* 137 */:
                        case Token.FINALLY /* 138 */:
                        case Token.VOID /* 139 */:
                            return true;
                    }
                }
                break;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int C2(defpackage.c82 r10, defpackage.t41 r11) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s82.C2(c82, t41):int");
    }

    public static Point D2(c82 c82Var, t41 t41Var) {
        int i = t41Var.x;
        int i2 = t41Var.w;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f2 = i / i3;
        for (int i4 : M1) {
            int i5 = (int) (i4 * f2);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            int i6 = z ? i5 : i4;
            if (!z) {
                i4 = i5;
            }
            Point pointC = c82Var.c(i6, i4);
            float f3 = t41Var.A;
            if (pointC != null && c82Var.w(pointC.x, pointC.y, f3)) {
                return pointC;
            }
        }
        return null;
    }

    public static List F2(Context context, l82 l82Var, t41 t41Var, boolean z, boolean z2) {
        String str = t41Var.p;
        if (str == null) {
            return xi1.u();
        }
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !c.a(context)) {
            List listH = q82.h(l82Var, t41Var, z, z2);
            if (!listH.isEmpty()) {
                return listH;
            }
        }
        return q82.m(l82Var, t41Var, z, z2);
    }

    public static int G2(c82 c82Var, t41 t41Var) {
        if (t41Var.q == -1) {
            return C2(c82Var, t41Var);
        }
        int size = t41Var.s.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += ((byte[]) t41Var.s.get(i)).length;
        }
        return t41Var.q + length;
    }

    public static int H2(int i, int i2) {
        return (i * 3) / (i2 * 2);
    }

    public static void e3(y72 y72Var, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        y72Var.b(bundle);
    }

    public static int q3(Context context, l82 l82Var, t41 t41Var) {
        boolean z;
        int i = 0;
        if (!nt2.t(t41Var.p)) {
            return p.C(0);
        }
        boolean z2 = t41Var.t != null;
        List listF2 = F2(context, l82Var, t41Var, z2, false);
        if (z2 && listF2.isEmpty()) {
            listF2 = F2(context, l82Var, t41Var, false, false);
        }
        if (listF2.isEmpty()) {
            return p.C(1);
        }
        if (!i82.f2(t41Var)) {
            return p.C(2);
        }
        c82 c82Var = (c82) listF2.get(0);
        boolean zQ = c82Var.q(context, t41Var);
        if (zQ) {
            z = true;
        } else {
            for (int i2 = 1; i2 < listF2.size(); i2++) {
                c82 c82Var2 = (c82) listF2.get(i2);
                if (c82Var2.q(context, t41Var)) {
                    z = false;
                    zQ = true;
                    c82Var = c82Var2;
                    break;
                }
            }
            z = true;
        }
        int i3 = zQ ? 4 : 3;
        int i4 = c82Var.t(t41Var) ? 16 : 8;
        int i5 = c82Var.h ? 64 : 0;
        int i6 = z ? 128 : 0;
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(t41Var.p) && !c.a(context)) {
            i6 = Buffer.DEFAULT_SIZE;
        }
        if (zQ) {
            List listF22 = F2(context, l82Var, t41Var, z2, true);
            if (!listF22.isEmpty()) {
                c82 c82Var3 = (c82) q82.n(context, listF22, t41Var).get(0);
                if (c82Var3.q(context, t41Var) && c82Var3.t(t41Var)) {
                    i = 32;
                }
            }
        }
        return p.r(i3, i4, i, i5, i6);
    }

    private void r3() {
        y72 y72VarO0 = O0();
        if (y72VarO0 != null && Build.VERSION.SDK_INT >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.C1));
            y72VarO0.b(bundle);
        }
    }

    public static boolean s2() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return i == 30 && Build.MODEL.startsWith("MiTV");
        }
        return true;
    }

    public static boolean y2() {
        return "NVIDIA".equals(Build.MANUFACTURER);
    }

    @Override // l25.b
    public boolean A(long j, long j2, boolean z) {
        return k3(j, j2, z);
    }

    @Override // defpackage.i82
    public b82 B0(Throwable th, c82 c82Var) {
        return new r82(th, c82Var, this.k1);
    }

    @Override // defpackage.i82
    public void B1(long j) {
        super.B1(j);
        if (this.D1) {
            return;
        }
        this.t1--;
    }

    public long B2() {
        return -this.H1;
    }

    @Override // defpackage.i82
    public void C1() {
        super.C1();
        d35 d35Var = this.g1;
        if (d35Var != null) {
            d35Var.j();
            if (this.H1 == -9223372036854775807L) {
                this.H1 = c1();
            }
            this.g1.i(B2());
        } else {
            this.V0.j(2);
        }
        this.J1 = true;
        V2();
    }

    @Override // defpackage.i82
    public void D1(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (this.X0 != null && ((c82) gg3.q(Q0())).b.equals("video/av01") && decoderInputBuffer.isKeyFrame() && (byteBuffer = decoderInputBuffer.data) != null) {
            this.X0.c(byteBuffer);
        }
        this.K1 = 0;
        int iP0 = P0(decoderInputBuffer);
        if ((Build.VERSION.SDK_INT < 34 || (iP0 & 32) == 0) && !this.D1) {
            this.t1++;
        }
    }

    public e E2(c82 c82Var, t41 t41Var, t41[] t41VarArr) {
        int iC2;
        int iMax = t41Var.w;
        int iMax2 = t41Var.x;
        int iG2 = G2(c82Var, t41Var);
        if (t41VarArr.length == 1) {
            if (iG2 != -1 && (iC2 = C2(c82Var, t41Var)) != -1) {
                iG2 = Math.min((int) (iG2 * 1.5f), iC2);
            }
            return new e(iMax, iMax2, iG2);
        }
        int length = t41VarArr.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            t41 t41VarQ = t41VarArr[i];
            if (t41Var.F != null && t41VarQ.F == null) {
                t41VarQ = t41VarQ.b().W(t41Var.F).Q();
            }
            if (c82Var.e(t41Var, t41VarQ).d != 0) {
                int i2 = t41VarQ.w;
                z |= i2 == -1 || t41VarQ.x == -1;
                iMax = Math.max(iMax, i2);
                iMax2 = Math.max(iMax2, t41VarQ.x);
                iG2 = Math.max(iG2, G2(c82Var, t41VarQ));
            }
        }
        if (z) {
            xz1.i("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointD2 = D2(c82Var, t41Var);
            if (pointD2 != null) {
                iMax = Math.max(iMax, pointD2.x);
                iMax2 = Math.max(iMax2, pointD2.y);
                iG2 = Math.max(iG2, C2(c82Var, t41Var.b().H0(iMax).i0(iMax2).Q()));
                xz1.i("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new e(iMax, iMax2, iG2);
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.a, androidx.media3.exoplayer.n.b
    public void F(int i, Object obj) throws zv0 {
        if (i == 1) {
            f3(obj);
            return;
        }
        if (i == 7) {
            j25 j25Var = (j25) gg3.q(obj);
            this.G1 = j25Var;
            d35 d35Var = this.g1;
            if (d35Var != null) {
                d35Var.t(j25Var);
                return;
            }
            return;
        }
        if (i == 10) {
            int iIntValue = ((Integer) gg3.q(obj)).intValue();
            if (this.E1 != iIntValue) {
                this.E1 = iIntValue;
                if (this.D1) {
                    J1();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4) {
            this.o1 = ((Integer) gg3.q(obj)).intValue();
            y72 y72VarO0 = O0();
            if (y72VarO0 != null) {
                y72VarO0.n(this.o1);
                return;
            }
            return;
        }
        if (i == 5) {
            int iIntValue2 = ((Integer) gg3.q(obj)).intValue();
            this.p1 = iIntValue2;
            d35 d35Var2 = this.g1;
            if (d35Var2 != null) {
                d35Var2.k(iIntValue2);
                return;
            } else {
                this.V0.l(iIntValue2);
                return;
            }
        }
        if (i == 13) {
            i3((List) gg3.q(obj));
            return;
        }
        if (i == 14) {
            d94 d94Var = (d94) gg3.q(obj);
            if (d94Var.b() == 0 || d94Var.a() == 0) {
                return;
            }
            this.m1 = d94Var;
            d35 d35Var3 = this.g1;
            if (d35Var3 != null) {
                d35Var3.e((Surface) gg3.q(this.k1), d94Var);
                return;
            }
            return;
        }
        switch (i) {
            case 16:
                this.C1 = ((Integer) gg3.q(obj)).intValue();
                r3();
                break;
            case 17:
                Surface surface = this.k1;
                f3(null);
                ((s82) gg3.q(obj)).F(1, surface);
                break;
            case 18:
                fz3 fz3Var = this.u1;
                boolean z = fz3Var != null && fz3Var.d;
                fz3 fz3Var2 = (fz3) obj;
                this.u1 = fz3Var2;
                if (z != (fz3Var2 != null && fz3Var2.d)) {
                    g2();
                }
                break;
            default:
                super.F(i, obj);
                break;
        }
    }

    @Override // defpackage.i82
    public boolean F1(long j, long j2, y72 y72Var, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, t41 t41Var) {
        gg3.q(y72Var);
        long jB1 = j3 - b1();
        t3(j3);
        d35 d35Var = this.g1;
        if (d35Var != null) {
            if (!z || z2) {
                return d35Var.f(j3, new b(y72Var, i, jB1));
            }
            p3(y72Var, i, jB1);
            return true;
        }
        long j4 = j3;
        int iC = this.V0.c(j4, j, j2, c1(), z, z2, this.W0);
        m25 m25Var = this.Z0;
        if (m25Var != null && iC != 5 && iC != 4) {
            m25Var.b(j4, this.W0.f());
        }
        if (iC != 5) {
            j4 = -9223372036854775807L;
        }
        this.L1 = j4;
        if (iC == 0) {
            long jNanoTime = R().nanoTime();
            W2(jB1, jNanoTime, t41Var);
            c3(y72Var, i, jB1, jNanoTime);
            v3(this.W0.f());
            return true;
        }
        if (iC == 1) {
            a3((y72) gg3.q(y72Var), i, jB1, t41Var);
            return true;
        }
        if (iC == 2) {
            z2(y72Var, i, jB1);
            v3(this.W0.f());
            return true;
        }
        if (iC == 3) {
            p3(y72Var, i, jB1);
            v3(this.W0.f());
            return true;
        }
        if (iC == 4 || iC == 5) {
            return false;
        }
        e04.a(String.valueOf(iC));
        return false;
    }

    public MediaFormat I2(t41 t41Var, String str, e eVar, float f2, boolean z, int i) {
        Pair pairU;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", t41Var.w);
        mediaFormat.setInteger("height", t41Var.x);
        eg2.e(mediaFormat, t41Var.s);
        eg2.c(mediaFormat, "frame-rate", t41Var.A);
        eg2.d(mediaFormat, "rotation-degrees", t41Var.B);
        eg2.b(mediaFormat, t41Var.F);
        if ("video/dolby-vision".equals(t41Var.p) && (pairU = gv.u(t41Var)) != null) {
            eg2.d(mediaFormat, "profile", ((Integer) pairU.first).intValue());
        }
        mediaFormat.setInteger("max-width", eVar.a);
        mediaFormat.setInteger("max-height", eVar.b);
        eg2.d(mediaFormat, "max-input-size", eVar.c);
        mediaFormat.setInteger(MessageHandler.Properties.Priority, 0);
        if (f2 != -1.0f) {
            mediaFormat.setFloat("operating-rate", f2);
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i);
        }
        if (Build.VERSION.SDK_INT >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.C1));
        }
        s0(mediaFormat);
        return mediaFormat;
    }

    public final Surface J2(c82 c82Var) {
        d35 d35Var = this.g1;
        if (d35Var != null) {
            return d35Var.d();
        }
        Surface surface = this.k1;
        if (surface != null) {
            return surface;
        }
        if (n3(c82Var)) {
            return null;
        }
        gg3.v(o3(c82Var));
        hb3 hb3Var = this.l1;
        if (hb3Var != null && hb3Var.f != c82Var.g) {
            b3();
        }
        if (this.l1 == null) {
            this.l1 = hb3.s(this.Q0, c82Var.g);
        }
        return this.l1;
    }

    @Override // l25.b
    public boolean K(long j, long j2) {
        return l3(j, j2);
    }

    @Override // defpackage.i82
    public void K1() {
        d35 d35Var = this.g1;
        if (d35Var != null) {
            d35Var.j();
        } else if (X0() != -9223372036854775807L) {
            this.L1 = X0();
        }
    }

    public final boolean K2(c82 c82Var) {
        if (this.g1 != null) {
            return true;
        }
        Surface surface = this.k1;
        return (surface != null && surface.isValid()) || n3(c82Var) || o3(c82Var);
    }

    public final boolean L2(DecoderInputBuffer decoderInputBuffer) {
        return decoderInputBuffer.timeUs < V();
    }

    @Override // androidx.media3.exoplayer.o
    public boolean M(long j) {
        if (W0() == -9223372036854775807L || j < this.v1) {
            return false;
        }
        long jZ0 = Z0();
        return jZ0 == -9223372036854775807L || j > jZ0;
    }

    @Override // defpackage.i82
    public void M1() {
        super.M1();
        this.a1.clear();
        this.t1 = 0;
        this.K1 = 0;
        this.w1 = false;
        this.L1 = -9223372036854775807L;
        bf bfVar = this.X0;
        if (bfVar != null) {
            bfVar.d();
        }
    }

    public final boolean M2(DecoderInputBuffer decoderInputBuffer) {
        if (j() || decoderInputBuffer.isLastSample() || this.I1 == -9223372036854775807L) {
            return true;
        }
        return this.I1 - (decoderInputBuffer.timeUs - b1()) <= 100000;
    }

    public boolean N2(long j, boolean z) throws zv0 {
        int iP0 = p0(j);
        if (iP0 == 0) {
            return false;
        }
        this.v1 = j;
        gb0 gb0Var = this.F0;
        if (z) {
            int i = gb0Var.d + iP0;
            gb0Var.d = i;
            gb0Var.f += this.t1;
            gb0Var.d = i + this.a1.size();
        } else {
            gb0Var.j++;
            s3(iP0 + this.a1.size(), this.t1);
        }
        L0();
        d35 d35Var = this.g1;
        if (d35Var != null) {
            d35Var.n(false);
        }
        return true;
    }

    public final void O2() {
        if (this.r1 > 0) {
            long jE = R().e();
            this.S0.o(this.r1, jE - this.q1);
            this.r1 = 0;
            this.q1 = jE;
        }
    }

    @Override // defpackage.i82
    public int P0(DecoderInputBuffer decoderInputBuffer) {
        fz3 fz3Var;
        if (Build.VERSION.SDK_INT >= 34) {
            return ((this.b1 || (((fz3Var = this.u1) != null && fz3Var.h) || this.D1)) && L2(decoderInputBuffer) && !M2(decoderInputBuffer)) ? 32 : 0;
        }
        return 0;
    }

    public final void P2() {
        if (!this.V0.g() || this.k1 == null) {
            return;
        }
        X2();
    }

    public final void Q2() {
        int i = this.y1;
        if (i != 0) {
            this.S0.s(this.x1, i);
            this.x1 = 0L;
            this.y1 = 0;
        }
    }

    public final void R2(e35 e35Var) {
        if (e35Var.equals(e35.e) || e35Var.equals(this.B1)) {
            return;
        }
        this.B1 = e35Var;
        this.S0.v(e35Var);
    }

    @Override // defpackage.i82
    public float S0(float f2, t41 t41Var, t41[] t41VarArr) {
        c82 c82VarQ0;
        float fMax = -1.0f;
        for (t41 t41Var2 : t41VarArr) {
            float f3 = t41Var2.A;
            if (f3 != -1.0f) {
                fMax = Math.max(fMax, f3);
            }
        }
        float f4 = fMax == -1.0f ? -1.0f : fMax * f2;
        if (this.u1 == null || (c82VarQ0 = Q0()) == null) {
            return f4;
        }
        float fH = c82VarQ0.h(t41Var.w, t41Var.x);
        return f4 != -1.0f ? Math.max(f4, fH) : fH;
    }

    public final void S2() {
        Surface surface = this.k1;
        if (surface == null || !this.n1) {
            return;
        }
        this.S0.r(surface);
    }

    public final void T2() {
        e35 e35Var = this.B1;
        if (e35Var != null) {
            this.S0.v(e35Var);
        }
    }

    @Override // defpackage.i82
    public List U0(l82 l82Var, t41 t41Var, boolean z) {
        Context context = this.Q0;
        return q82.n(context, F2(context, l82Var, t41Var, z, this.D1), t41Var);
    }

    public final void U2(MediaFormat mediaFormat) {
        if (this.g1 == null || fy4.S0(this.Q0)) {
            return;
        }
        mediaFormat.setInteger("allow-frame-drop", 0);
    }

    @Override // defpackage.i82
    public long V0(long j, long j2, boolean z) {
        if (!this.c1 || !z) {
            return super.V0(j, j2, z);
        }
        if (getState() != 2) {
            return (isReady() || b()) ? 1000000L : 10000L;
        }
        if (this.L1 != -9223372036854775807L && this.g1 == null) {
            if (b()) {
                return Math.max(10000L, (long) (((this.L1 - j) / d1()) / 2.0f));
            }
            try {
                if (this.V0.c(this.L1, j, j2, c1(), false, false, this.W0) != 5) {
                    return 0L;
                }
                return Math.max(0L, (this.W0.f() + (fy4.c1(R().e()) - j2)) - 25000);
            } catch (zv0 unused) {
                xz1.i("MediaCodecVideoRenderer", "Error while evaluating frame release action");
            }
        }
        return 10000L;
    }

    public final void V2() {
        y72 y72VarO0;
        if (this.D1 && (y72VarO0 = O0()) != null) {
            this.F1 = new f(y72VarO0);
            if (Build.VERSION.SDK_INT >= 33) {
                Bundle bundle = new Bundle();
                bundle.putInt("tunnel-peek", 1);
                y72VarO0.b(bundle);
            }
        }
    }

    public final void W2(long j, long j2, t41 t41Var) {
        j25 j25Var = this.G1;
        if (j25Var != null) {
            j25Var.h(j, j2, t41Var, T0());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4  */
    @Override // defpackage.i82
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean X1(androidx.media3.decoder.DecoderInputBuffer r9) {
        /*
            r8 = this;
            boolean r0 = r8.M2(r9)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            boolean r0 = r8.L2(r9)
            m25 r2 = r8.Z0
            r3 = 1
            if (r2 == 0) goto L28
            long r4 = r9.timeUs
            long r4 = r2.c(r4)
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L28
            long r6 = r8.Y0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L28
            r2 = r3
            goto L29
        L28:
            r2 = r1
        L29:
            if (r0 != 0) goto L2e
            if (r2 != 0) goto L2e
            return r1
        L2e:
            boolean r2 = r9.hasSupplementalData()
            if (r2 == 0) goto L35
            return r1
        L35:
            boolean r2 = r9.notDependedOn()
            if (r2 == 0) goto L40
            r9.clear()
        L3e:
            r1 = r3
            goto La2
        L40:
            bf r2 = r8.X0
            if (r2 == 0) goto La2
            c82 r2 = r8.Q0()
            java.lang.Object r2 = defpackage.gg3.q(r2)
            c82 r2 = (defpackage.c82) r2
            java.lang.String r2 = r2.b
            java.lang.String r4 = "video/av01"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto La2
            java.nio.ByteBuffer r2 = r9.data
            if (r2 == 0) goto La2
            if (r0 != 0) goto L65
            int r4 = r8.K1
            if (r4 > 0) goto L63
            goto L65
        L63:
            r4 = r1
            goto L66
        L65:
            r4 = r3
        L66:
            java.nio.ByteBuffer r2 = r2.asReadOnlyBuffer()
            r2.flip()
            bf r5 = r8.X0
            int r4 = r5.e(r2, r4)
            if (r4 != 0) goto L79
            r9.clear()
            goto L3e
        L79:
            int r5 = r2.limit()
            if (r4 == r5) goto La2
            s82$e r5 = r8.d1
            java.lang.Object r5 = defpackage.gg3.q(r5)
            s82$e r5 = (s82.e) r5
            int r5 = r5.c
            int r5 = r5 + r4
            int r2 = r2.capacity()
            if (r5 >= r2) goto La2
            boolean r2 = r9.isEncrypted()
            if (r2 != 0) goto La2
            java.nio.ByteBuffer r1 = r9.data
            java.lang.Object r1 = defpackage.gg3.q(r1)
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            r1.position(r4)
            goto L3e
        La2:
            if (r1 == 0) goto Lbe
            if (r0 == 0) goto Lae
            gb0 r8 = r8.F0
            int r9 = r8.d
            int r9 = r9 + r3
            r8.d = r9
            return r1
        Lae:
            java.util.PriorityQueue r0 = r8.a1
            long r4 = r9.timeUs
            java.lang.Long r9 = java.lang.Long.valueOf(r4)
            r0.add(r9)
            int r9 = r8.K1
            int r9 = r9 + r3
            r8.K1 = r9
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s82.X1(androidx.media3.decoder.DecoderInputBuffer):boolean");
    }

    public final void X2() {
        this.S0.r(this.k1);
        this.n1 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // defpackage.i82
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Y1() {
        /*
            r12 = this;
            t41 r0 = r12.R0()
            long r1 = r12.I1
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L2d
            r8 = 1
            long r1 = r1 + r8
            long r8 = r12.b1()
            long r10 = r12.I1
            long r8 = r8 + r10
            long r10 = r12.e1()
            long r10 = r10 + r1
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r1 = r1 - r8
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 <= 0) goto L2b
            goto L2d
        L2b:
            r1 = r6
            goto L2e
        L2d:
            r1 = r7
        L2e:
            fz3 r2 = r12.u1
            if (r2 != 0) goto L37
            boolean r12 = super.Y1()
            return r12
        L37:
            boolean r2 = r2.f
            if (r2 == 0) goto L55
            boolean r2 = r12.w1
            if (r2 != 0) goto L55
            boolean r2 = r12.D1
            if (r2 != 0) goto L55
            if (r0 == 0) goto L49
            int r0 = r0.r
            if (r0 > 0) goto L55
        L49:
            if (r1 != 0) goto L55
            long r0 = r12.X0()
            int r12 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r12 == 0) goto L54
            goto L55
        L54:
            return r6
        L55:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s82.Y1():boolean");
    }

    public void Y2(long j) {
        k2(j);
        R2(this.A1);
        this.F0.e++;
        P2();
        B1(j);
    }

    @Override // defpackage.i82
    public boolean Z1(c82 c82Var) {
        return K2(c82Var);
    }

    public final void Z2() {
        T1();
    }

    @Override // defpackage.i82
    public y72.a a1(c82 c82Var, t41 t41Var, MediaCrypto mediaCrypto, float f2) {
        String str = c82Var.c;
        e eVarE2 = E2(c82Var, t41Var, Y());
        this.d1 = eVarE2;
        MediaFormat mediaFormatI2 = I2(t41Var, str, eVarE2, f2, this.U0, this.D1 ? this.E1 : 0);
        Surface surfaceJ2 = J2(c82Var);
        U2(mediaFormatI2);
        return y72.a.b(c82Var, mediaFormatI2, t41Var, surfaceJ2, mediaCrypto);
    }

    public final void a3(y72 y72Var, int i, long j, t41 t41Var) {
        s82 s82Var;
        long jG = this.W0.g();
        long jF = this.W0.f();
        if (m3() && jG == this.z1) {
            p3(y72Var, i, j);
            s82Var = this;
        } else {
            s82Var = this;
            s82Var.W2(j, jG, t41Var);
            s82Var.d3(y72Var, i, j, jG);
            jG = jG;
        }
        s82Var.v3(jF);
        s82Var.z1 = jG;
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.o
    public boolean b() {
        if (!super.b()) {
            return false;
        }
        d35 d35Var = this.g1;
        return d35Var == null || d35Var.b();
    }

    @Override // defpackage.i82
    public final boolean b2() {
        c82 c82VarQ0 = Q0();
        if (this.g1 == null || c82VarQ0 == null || !(c82VarQ0.a.equals("c2.mtk.avc.decoder") || c82VarQ0.a.equals("c2.mtk.hevc.decoder"))) {
            return super.b2();
        }
        return true;
    }

    public final void b3() {
        hb3 hb3Var = this.l1;
        if (hb3Var != null) {
            hb3Var.release();
            this.l1 = null;
        }
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.o
    public void c(long j, long j2) throws zv0 {
        d35 d35Var = this.g1;
        if (d35Var != null) {
            try {
                d35Var.c(j, j2);
            } catch (d35.c e2) {
                throw P(e2, e2.f, 7001);
            }
        }
        super.c(j, j2);
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void c0() {
        this.B1 = null;
        this.I1 = -9223372036854775807L;
        V2();
        this.n1 = false;
        this.F1 = null;
        this.w1 = true;
        this.L1 = -9223372036854775807L;
        try {
            super.c0();
        } finally {
            this.S0.n(this.F0);
            this.S0.v(e35.e);
        }
    }

    public final void c3(y72 y72Var, int i, long j, long j2) {
        d3(y72Var, i, j, j2);
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void d0(boolean z, boolean z2) {
        super.d0(z, z2);
        boolean z3 = S().b;
        gg3.v((z3 && this.E1 == 0) ? false : true);
        if (this.D1 != z3) {
            this.D1 = z3;
            J1();
        }
        this.S0.p(this.F0);
        if (!this.h1) {
            if (this.j1 != null && this.g1 == null) {
                fd3 fd3VarW2 = w2(this.Q0, this.V0);
                fd3VarW2.S(1);
                this.g1 = fd3VarW2.F(0);
            }
            this.h1 = true;
        }
        if (this.g1 == null) {
            this.V0.m(R());
            this.V0.j(!z2 ? 1 : 0);
        } else {
            v2();
            this.i1 = !z2 ? 1 : 0;
            I0();
        }
    }

    public void d3(y72 y72Var, int i, long j, long j2) {
        hq4.a("releaseOutputBuffer");
        y72Var.j(i, j2);
        hq4.b();
        this.F0.e++;
        this.s1 = 0;
        if (this.g1 == null) {
            R2(this.A1);
            P2();
        }
    }

    @Override // androidx.media3.exoplayer.a
    public void e0() {
        super.e0();
    }

    @Override // defpackage.i82
    public int e2(l82 l82Var, t41 t41Var) {
        return q3(this.Q0, l82Var, t41Var);
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void f0(long j, boolean z, boolean z2) throws zv0 {
        d35 d35Var = this.g1;
        if (d35Var != null && !z) {
            d35Var.n(true);
        }
        if (z2) {
            this.v1 = j;
        }
        super.f0(j, z, z2);
        if (this.g1 == null) {
            this.V0.k();
        }
        m25 m25Var = this.Z0;
        if (m25Var != null) {
            m25Var.d();
        }
        if (z) {
            d35 d35Var2 = this.g1;
            if (d35Var2 != null) {
                d35Var2.p(false);
            } else {
                this.V0.e(false);
            }
        }
        V2();
        this.s1 = 0;
        this.L1 = -9223372036854775807L;
    }

    public final void f3(Object obj) throws zv0 {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.k1 == surface) {
            if (surface != null) {
                T2();
                S2();
                return;
            }
            return;
        }
        this.k1 = surface;
        if (this.g1 == null) {
            this.V0.o(surface);
        }
        this.n1 = false;
        int state = getState();
        y72 y72VarO0 = O0();
        if (y72VarO0 != null && this.g1 == null) {
            c82 c82Var = (c82) gg3.q(Q0());
            if (!K2(c82Var) || this.e1) {
                J1();
                r1();
            } else {
                g3(y72VarO0, J2(c82Var));
            }
        }
        if (surface != null) {
            T2();
        } else {
            this.B1 = null;
            d35 d35Var = this.g1;
            if (d35Var != null) {
                d35Var.l();
            }
        }
        if (state == 2) {
            d35 d35Var2 = this.g1;
            if (d35Var2 != null) {
                d35Var2.p(true);
            } else {
                this.V0.e(true);
            }
        }
        V2();
    }

    @Override // l25.b
    public boolean g(long j, long j2, long j3, boolean z, boolean z2) {
        if (this.g1 != null && this.R0) {
            j2 -= B2();
        }
        return j3(j, j3, z) && N2(j2, z2);
    }

    @Override // androidx.media3.exoplayer.a
    public void g0() {
        super.g0();
        d35 d35Var = this.g1;
        if (d35Var == null || !this.R0) {
            return;
        }
        d35Var.release();
    }

    @Override // defpackage.i82
    public void g1(DecoderInputBuffer decoderInputBuffer) {
        if (this.f1) {
            ByteBuffer byteBuffer = (ByteBuffer) gg3.q(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4) {
                    if (b4 == 0 || b4 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        e3((y72) gg3.q(O0()), bArr);
                    }
                }
            }
        }
    }

    public final void g3(y72 y72Var, Surface surface) {
        if (surface != null) {
            h3(y72Var, surface);
        } else if (Build.VERSION.SDK_INT >= 35) {
            x2(y72Var);
        } else {
            z20.a();
        }
    }

    @Override // androidx.media3.exoplayer.o, androidx.media3.exoplayer.p
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public void h3(y72 y72Var, Surface surface) {
        y72Var.p(surface);
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void i0() {
        try {
            super.i0();
        } finally {
            this.h1 = false;
            this.H1 = -9223372036854775807L;
            this.L1 = -9223372036854775807L;
            b3();
        }
    }

    public void i3(List list) {
        if (list.equals(k25.a)) {
            d35 d35Var = this.g1;
            if (d35Var == null || !d35Var.isInitialized()) {
                return;
            }
            this.g1.u();
            return;
        }
        this.j1 = list;
        d35 d35Var2 = this.g1;
        if (d35Var2 != null) {
            d35Var2.o(list);
        }
    }

    @Override // androidx.media3.exoplayer.o
    public boolean isReady() {
        boolean zQ1 = q1();
        d35 d35Var = this.g1;
        if (d35Var != null) {
            return d35Var.q(zQ1);
        }
        if (zQ1 && (O0() == null || this.D1)) {
            return true;
        }
        return this.V0.d(zQ1);
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void j0() {
        super.j0();
        this.r1 = 0;
        this.q1 = R().e();
        this.x1 = 0L;
        this.y1 = 0;
        d35 d35Var = this.g1;
        if (d35Var != null) {
            d35Var.h();
        } else {
            this.V0.h();
        }
    }

    public boolean j3(long j, long j2, boolean z) {
        return j < -500000 && !z;
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void k0() {
        O2();
        Q2();
        d35 d35Var = this.g1;
        if (d35Var != null) {
            d35Var.g();
        } else {
            this.V0.i();
        }
        m25 m25Var = this.Z0;
        if (m25Var != null) {
            m25Var.d();
        }
        super.k0();
    }

    public boolean k3(long j, long j2, boolean z) {
        return j < -30000 && !z;
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.a
    public void l0(t41[] t41VarArr, long j, long j2, jq2.b bVar) {
        super.l0(t41VarArr, j, j2, bVar);
        u3(bVar);
        m25 m25Var = this.Z0;
        if (m25Var != null) {
            m25Var.d();
        }
    }

    public boolean l3(long j, long j2) {
        return j < -30000 && j2 > 100000;
    }

    @Override // androidx.media3.exoplayer.a
    public void m0(no4 no4Var) {
        super.m0(no4Var);
        jq2.b bVarW = W();
        if (bVarW != null) {
            u3(bVarW);
        }
    }

    public boolean m3() {
        return true;
    }

    public boolean n3(c82 c82Var) {
        return Build.VERSION.SDK_INT >= 35 && c82Var.k;
    }

    public boolean o3(c82 c82Var) {
        if (this.D1 || u2(c82Var.a)) {
            return false;
        }
        return !c82Var.g || hb3.d(this.Q0);
    }

    @Override // androidx.media3.exoplayer.o
    public void p() {
        d35 d35Var = this.g1;
        if (d35Var == null) {
            this.V0.a();
            return;
        }
        int i = this.i1;
        if (i == 0 || i == 1) {
            this.i1 = 0;
        } else {
            d35Var.v();
        }
    }

    public void p3(y72 y72Var, int i, long j) {
        hq4.a("skipVideoBuffer");
        y72Var.m(i, false);
        hq4.b();
        this.F0.f++;
    }

    public void s3(int i, int i2) {
        gb0 gb0Var = this.F0;
        gb0Var.h += i;
        int i3 = i + i2;
        gb0Var.g += i3;
        this.r1 += i3;
        int i4 = this.s1 + i3;
        this.s1 = i4;
        gb0Var.i = Math.max(i4, gb0Var.i);
        int i5 = this.T0;
        if (i5 <= 0 || this.r1 < i5) {
            return;
        }
        O2();
    }

    @Override // defpackage.i82
    public boolean t1(t41 t41Var) throws zv0 {
        d35 d35Var = this.g1;
        if (d35Var == null || d35Var.isInitialized()) {
            return true;
        }
        try {
            return this.g1.m(t41Var);
        } catch (d35.c e2) {
            throw this.P(e2, t41Var, 7000);
        }
    }

    public void t2(d35 d35Var, int i, t41 t41Var, int i2) {
        List listU = this.j1;
        if (listU == null) {
            listU = xi1.u();
        }
        d35Var.r(i, t41Var, c1(), i2, listU);
    }

    public final void t3(long j) {
        int i = 0;
        while (true) {
            Long l = (Long) this.a1.peek();
            if (l == null || l.longValue() >= j) {
                break;
            }
            i++;
            this.a1.poll();
        }
        s3(i, 0);
    }

    @Override // defpackage.i82
    public void u1(Exception exc) {
        xz1.e("MediaCodecVideoRenderer", "Video codec error", exc);
        this.S0.t(exc);
    }

    public boolean u2(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (s82.class) {
            try {
                if (!N1) {
                    O1 = A2();
                    N1 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return O1;
    }

    public final void u3(jq2.b bVar) {
        no4 no4VarA0 = a0();
        if (no4VarA0.w()) {
            this.I1 = -9223372036854775807L;
            return;
        }
        int iH = no4VarA0.h(bVar.a);
        if (iH == -1) {
            this.I1 = -9223372036854775807L;
        } else {
            this.I1 = no4VarA0.l(iH, new no4.b()).l();
        }
    }

    @Override // defpackage.i82
    public lb0 v0(c82 c82Var, t41 t41Var, t41 t41Var2) {
        lb0 lb0VarE = c82Var.e(t41Var, t41Var2);
        int i = lb0VarE.e;
        e eVar = (e) gg3.q(this.d1);
        if (t41Var2.w > eVar.a || t41Var2.x > eVar.b) {
            i |= Buffer.DEFAULT_SIZE;
        }
        if (G2(c82Var, t41Var2) > eVar.c) {
            i |= 64;
        }
        if (this.p1 != Integer.MIN_VALUE) {
            float f2 = t41Var.A;
            if (f2 != -1.0f) {
                float f3 = t41Var2.A;
                if (f3 != -1.0f && Math.abs(f3 - f2) > 1.0f && s2()) {
                    i |= 65536;
                }
            }
        }
        int i2 = i;
        return new lb0(c82Var.a, t41Var, t41Var2, i2 != 0 ? 0 : lb0VarE.d, i2);
    }

    @Override // defpackage.i82
    public void v1(String str, y72.a aVar, long j, long j2) {
        this.S0.l(str, j, j2);
        this.e1 = u2(str);
        this.f1 = ((c82) gg3.q(Q0())).r();
        V2();
    }

    public final void v2() {
        this.g1.s(new a(), du2.b());
        j25 j25Var = this.G1;
        if (j25Var != null) {
            this.g1.t(j25Var);
        }
        if (this.k1 != null && !this.m1.equals(d94.c)) {
            this.g1.e(this.k1, this.m1);
        }
        this.g1.k(this.p1);
        this.g1.setPlaybackSpeed(d1());
        List list = this.j1;
        if (list != null) {
            this.g1.o(list);
        }
    }

    public void v3(long j) {
        this.F0.a(j);
        this.x1 += j;
        this.y1++;
    }

    @Override // defpackage.i82
    public void w1(androidx.media3.exoplayer.b bVar) {
        this.S0.u(bVar);
    }

    public fd3 w2(Context context, l25 l25Var) {
        fd3.b bVarK = new fd3.b(context, l25Var).k(true);
        long j = this.Y0;
        return bVarK.i(j != -9223372036854775807L ? -j : -9223372036854775807L).j(R()).h();
    }

    @Override // defpackage.i82
    public void x1(String str) {
        this.S0.m(str);
    }

    public void x2(y72 y72Var) {
        y72Var.h();
    }

    @Override // defpackage.i82
    public lb0 y1(u41 u41Var) throws zv0 {
        lb0 lb0VarY1 = super.y1(u41Var);
        this.S0.q((t41) gg3.q(u41Var.b), lb0VarY1);
        m25 m25Var = this.Z0;
        if (m25Var != null) {
            m25Var.d();
        }
        return lb0VarY1;
    }

    @Override // defpackage.i82, androidx.media3.exoplayer.o
    public void z(float f2, float f3) throws zv0 {
        super.z(f2, f3);
        d35 d35Var = this.g1;
        if (d35Var != null) {
            d35Var.setPlaybackSpeed(f2);
        } else {
            this.V0.p(f2);
        }
        m25 m25Var = this.Z0;
        if (m25Var != null) {
            m25Var.e(f2);
        }
    }

    @Override // defpackage.i82
    public void z1(t41 t41Var, MediaFormat mediaFormat) {
        int integer;
        int i;
        y72 y72VarO0 = O0();
        if (y72VarO0 != null) {
            y72VarO0.n(this.o1);
        }
        if (this.D1) {
            i = t41Var.w;
            integer = t41Var.x;
        } else {
            gg3.q(mediaFormat);
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            integer = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
            i = integer2;
        }
        float f2 = t41Var.C;
        int i2 = t41Var.B;
        if (i2 == 90 || i2 == 270) {
            f2 = 1.0f / f2;
            int i3 = integer;
            integer = i;
            i = i3;
        }
        this.A1 = new e35(i, integer, f2);
        d35 d35Var = this.g1;
        if (d35Var == null || !this.J1) {
            this.V0.n(t41Var.A);
        } else {
            t2(d35Var, 1, t41Var.b().H0(i).i0(integer).v0(f2).Q(), this.i1);
            this.i1 = 2;
        }
        this.J1 = false;
    }

    public void z2(y72 y72Var, int i, long j) {
        hq4.a("dropVideoBuffer");
        y72Var.m(i, false);
        hq4.b();
        s3(0, 1);
    }
}
