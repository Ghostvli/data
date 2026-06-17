package defpackage;

import android.util.Pair;
import android.util.SparseArray;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.gr4;
import defpackage.ki4;
import defpackage.oo0;
import defpackage.yz3;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.jupnp.support.model.dlna.DLNAProfiles;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class u62 implements hz0 {
    public static final pz0 k0 = new pz0() { // from class: t62
        @Override // defpackage.pz0
        public final hz0[] d() {
            return u62.g();
        }
    };
    public static final byte[] l0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] m0 = fy4.F0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    public static final byte[] n0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    public static final byte[] o0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    public static final UUID p0 = new UUID(72057594037932032L, -9223371306706625679L);
    public static final Map q0;
    public int A;
    public long B;
    public final SparseArray C;
    public boolean D;
    public long E;
    public int F;
    public long G;
    public long H;
    public int I;
    public boolean J;
    public long K;
    public long L;
    public long M;
    public boolean N;
    public int O;
    public long P;
    public long Q;
    public int R;
    public int S;
    public int[] T;
    public int U;
    public int V;
    public int W;
    public int X;
    public boolean Y;
    public long Z;
    public final hq0 a;
    public int a0;
    public final dz4 b;
    public int b0;
    public final SparseArray c;
    public int c0;
    public final boolean d;
    public boolean d0;
    public final boolean e;
    public boolean e0;
    public final ki4.a f;
    public boolean f0;
    public final r73 g;
    public int g0;
    public final r73 h;
    public byte h0;
    public final r73 i;
    public boolean i0;
    public final r73 j;
    public mz0 j0;
    public final r73 k;
    public final r73 l;
    public final r73 m;
    public final r73 n;
    public final r73 o;
    public final r73 p;
    public ByteBuffer q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public boolean w;
    public boolean x;
    public d y;
    public boolean z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements gq0 {
        public b() {
        }

        @Override // defpackage.gq0
        public void a(int i) throws r83 {
            u62.this.p(i);
        }

        @Override // defpackage.gq0
        public int b(int i) {
            return u62.this.v(i);
        }

        @Override // defpackage.gq0
        public boolean c(int i) {
            return u62.this.A(i);
        }

        @Override // defpackage.gq0
        public void d(int i, String str) throws r83 {
            u62.this.I(i, str);
        }

        @Override // defpackage.gq0
        public void e(int i, double d) throws r83 {
            u62.this.s(i, d);
        }

        @Override // defpackage.gq0
        public void f(int i, int i2, jz0 jz0Var) throws r83 {
            u62.this.n(i, i2, jz0Var);
        }

        @Override // defpackage.gq0
        public void g(int i, long j, long j2) throws r83 {
            u62.this.H(i, j, j2);
        }

        @Override // defpackage.gq0
        public void h(int i, long j) throws r83 {
            u62.this.y(i, j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements yz3, ut {
        public final st a;
        public final SparseArray b;
        public final long c;
        public final int d;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a implements Comparable {
            public final long f;
            public final long g;
            public final long h;

            public a(long j, long j2, long j3) {
                this.f = j;
                this.g = j2;
                this.h = j3;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f == aVar.f && this.g == aVar.g && this.h == aVar.h;
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public int compareTo(a aVar) {
                return Long.compare(this.f, aVar.f);
            }

            public int hashCode() {
                return Objects.hash(Long.valueOf(this.f), Long.valueOf(this.g), Long.valueOf(this.h));
            }
        }

        public c(SparseArray sparseArray, long j, int i, long j2, long j3) {
            this.b = sparseArray;
            this.c = j;
            this.d = i;
            this.a = j(sparseArray, j, i, j2, j3);
        }

        public static st j(SparseArray sparseArray, long j, int i, long j2, long j3) {
            int i2;
            List list = (List) sparseArray.get(i);
            if (list == null || list.isEmpty()) {
                return null;
            }
            int size = list.size();
            int[] iArrCopyOf = new int[size];
            long[] jArrCopyOf = new long[size];
            long[] jArrCopyOf2 = new long[size];
            long[] jArrCopyOf3 = new long[size];
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = (a) list.get(i4);
                jArrCopyOf3[i4] = aVar.f;
                jArrCopyOf[i4] = aVar.g;
            }
            while (true) {
                i2 = size - 1;
                if (i3 >= i2) {
                    break;
                }
                int i5 = i3 + 1;
                iArrCopyOf[i3] = (int) (jArrCopyOf[i5] - jArrCopyOf[i3]);
                jArrCopyOf2[i3] = jArrCopyOf3[i5] - jArrCopyOf3[i3];
                i3 = i5;
            }
            int i6 = i2;
            while (i6 > 0 && jArrCopyOf3[i6] >= j) {
                i6--;
            }
            iArrCopyOf[i6] = (int) ((j2 + j3) - jArrCopyOf[i6]);
            jArrCopyOf2[i6] = j - jArrCopyOf3[i6];
            if (i6 < i2) {
                xz1.i("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration.");
                int i7 = i6 + 1;
                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i7);
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i7);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i7);
                jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i7);
            }
            return new st(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
        }

        @Override // defpackage.ut
        public st b() {
            return this.a;
        }

        @Override // defpackage.yz3
        public boolean e() {
            return k(this.d);
        }

        @Override // defpackage.yz3
        public yz3.a g(long j) {
            st stVar = this.a;
            return stVar != null ? stVar.g(j) : new yz3.a(a04.c);
        }

        @Override // defpackage.yz3
        public long i() {
            return this.c;
        }

        public boolean k(int i) {
            List list = (List) this.b.get(i);
            return (list == null || list.isEmpty()) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public byte[] P;
        public qt4 V;
        public boolean X;
        public boolean a;
        public gr4 a0;
        public String b;
        public t41 b0;
        public String c;
        public int c0;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public boolean i;
        public byte[] j;
        public gr4.a k;
        public byte[] l;
        public oo0 m;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = 0;
        public int t = -1;
        public float u = 0.0f;
        public float v = 0.0f;
        public float w = 0.0f;
        public byte[] x = null;
        public int y = -1;
        public boolean z = false;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = 1000;
        public int E = 200;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public float N = -1.0f;
        public float O = -1.0f;
        public int Q = 1;
        public int R = -1;
        public int S = 8000;
        public long T = 0;
        public long U = 0;
        public boolean W = false;
        public boolean Y = true;
        public String Z = "eng";

        public static long h(List list, long j, long j2, long j3) {
            long j4;
            long j5;
            if (list.isEmpty()) {
                return -9223372036854775807L;
            }
            int iMin = Math.min(list.size(), 20);
            double d = 0.0d;
            int i = -1;
            for (int i2 = 0; i2 < iMin; i2++) {
                c.a aVar = (c.a) list.get(i2);
                if (aVar.f > 10000000) {
                    break;
                }
                if (i2 < list.size() - 1) {
                    c.a aVar2 = (c.a) list.get(i2 + 1);
                    j4 = (aVar2.g + aVar2.h) - (aVar.g + aVar.h);
                    j5 = aVar2.f - aVar.f;
                } else {
                    j4 = (j2 + j3) - (aVar.g + aVar.h);
                    j5 = j - aVar.f;
                }
                if (j5 > 0) {
                    double d2 = j4 / j5;
                    if (d2 > d) {
                        i = i2;
                        d = d2;
                    }
                }
            }
            if (i == -1) {
                return -9223372036854775807L;
            }
            return ((c.a) list.get(i)).f;
        }

        public static Pair n(r73 r73Var) throws r83 {
            try {
                r73Var.g0(16);
                long jG = r73Var.G();
                if (jG == 1482049860) {
                    return new Pair(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_DIVX, null);
                }
                if (jG == 859189832) {
                    return new Pair(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_3GP, null);
                }
                if (jG != 826496599) {
                    xz1.i("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair("video/x-unknown", null);
                }
                byte[] bArrF = r73Var.f();
                for (int iG = r73Var.g() + 20; iG < bArrF.length - 4; iG++) {
                    if (bArrF[iG] == 0 && bArrF[iG + 1] == 0 && bArrF[iG + 2] == 1 && bArrF[iG + 3] == 15) {
                        return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrF, iG, bArrF.length)));
                    }
                }
                throw r83.a("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw r83.a("Error parsing FourCC private data", null);
            }
        }

        public static boolean o(r73 r73Var) throws r83 {
            try {
                int I = r73Var.I();
                if (I == 1) {
                    return true;
                }
                if (I == 65534) {
                    r73Var.f0(24);
                    if (r73Var.J() == u62.p0.getMostSignificantBits()) {
                        if (r73Var.J() == u62.p0.getLeastSignificantBits()) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw r83.a("Error parsing MS/ACM codec private", null);
            }
        }

        public static List p(byte[] bArr) throws r83 {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw r83.a("Error parsing vorbis codec private", null);
                }
                int i3 = 0;
                int i4 = 1;
                while (true) {
                    i = bArr[i4];
                    if ((i & 255) != 255) {
                        break;
                    }
                    i3 += 255;
                    i4++;
                }
                int i5 = i4 + 1;
                int i6 = i3 + (i & 255);
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if ((i2 & 255) != 255) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + (i2 & 255);
                if (bArr[i8] != 1) {
                    throw r83.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw r83.a("Error parsing vorbis codec private", null);
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw r83.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw r83.a("Error parsing vorbis codec private", null);
            }
        }

        public final void g() {
            gg3.q(this.a0);
        }

        public final byte[] i(String str) throws r83 {
            byte[] bArr = this.l;
            if (bArr != null) {
                return bArr;
            }
            throw r83.a("Missing CodecPrivate for codec " + str, null);
        }

        public final byte[] j() {
            if (this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f || this.N == -1.0f || this.O == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.F * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.G * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.H * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.I * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.J * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.K * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.L * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.M * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.N + 0.5f));
            byteBufferOrder.putShort((short) (this.O + 0.5f));
            byteBufferOrder.putShort((short) this.D);
            byteBufferOrder.putShort((short) this.E);
            return bArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:221:0x0430  */
        /* JADX WARN: Removed duplicated region for block: B:226:0x0449  */
        /* JADX WARN: Removed duplicated region for block: B:227:0x044c  */
        /* JADX WARN: Removed duplicated region for block: B:230:0x045b  */
        /* JADX WARN: Removed duplicated region for block: B:231:0x046c  */
        /* JADX WARN: Removed duplicated region for block: B:279:0x0543  */
        /* JADX WARN: Removed duplicated region for block: B:298:0x0598  */
        /* JADX WARN: Removed duplicated region for block: B:303:0x05b3  */
        /* JADX WARN: Removed duplicated region for block: B:304:0x05b6  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void k(int r21) throws defpackage.r83 {
            /*
                Method dump skipped, instruction units count: 1718
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: u62.d.k(int):void");
        }

        public final void l(SparseArray sparseArray, long j, long j2, long j3) {
            List list;
            if (this.e != 2 || (list = (List) sparseArray.get(this.d)) == null || list.isEmpty()) {
                return;
            }
            long jH = h(list, j, j2, j3);
            if (jH != -9223372036854775807L) {
                xs2 xs2Var = ((t41) gg3.q(this.b0)).l;
                wn4 wn4Var = new wn4(jH);
                this.b0 = this.b0.b().s0(xs2Var == null ? new xs2(wn4Var) : xs2Var.a(wn4Var)).Q();
            }
        }

        public void m() {
            qt4 qt4Var = this.V;
            if (qt4Var != null) {
                qt4Var.a(this.a0, this.k);
            }
        }

        public void q() {
            qt4 qt4Var = this.V;
            if (qt4Var != null) {
                qt4Var.b();
            }
        }

        public final boolean r(boolean z) {
            return "A_OPUS".equals(this.c) ? z : this.g > 0;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        q0 = Collections.unmodifiableMap(map);
    }

    public u62(hq0 hq0Var, int i, ki4.a aVar) {
        this.s = -1L;
        this.t = -9223372036854775807L;
        this.u = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.E = -9223372036854775807L;
        this.F = -1;
        this.G = -1L;
        this.H = -1L;
        this.I = -1;
        this.K = -1L;
        this.L = -1L;
        this.M = -9223372036854775807L;
        this.a = hq0Var;
        hq0Var.b(new b());
        this.f = aVar;
        this.C = new SparseArray();
        this.d = (i & 1) == 0;
        this.e = (i & 2) == 0;
        this.b = new dz4();
        this.c = new SparseArray();
        this.i = new r73(4);
        this.j = new r73(ByteBuffer.allocate(4).putInt(-1).array());
        this.k = new r73(4);
        this.g = new r73(dx2.a);
        this.h = new r73(4);
        this.l = new r73();
        this.m = new r73();
        this.n = new r73(8);
        this.o = new r73();
        this.p = new r73();
        this.T = new int[1];
        this.x = true;
    }

    public static void G(String str, long j, byte[] bArr) {
        byte[] bArrT;
        int i;
        str.getClass();
        switch (str) {
            case "S_TEXT/ASS":
            case "S_TEXT/SSA":
                bArrT = t(j, "%01d:%02d:%02d:%02d", 10000L);
                i = 21;
                break;
            case "S_TEXT/WEBVTT":
                bArrT = t(j, "%02d:%02d:%02d.%03d", 1000L);
                i = 25;
                break;
            case "S_TEXT/UTF8":
                bArrT = t(j, "%02d:%02d:%02d,%03d", 1000L);
                i = 19;
                break;
            default:
                d04.a();
                return;
        }
        System.arraycopy(bArrT, 0, bArr, i, bArrT.length);
    }

    public static /* synthetic */ hz0[] g() {
        return new hz0[]{new u62(ki4.a.a, 2)};
    }

    private void m() {
        gg3.q(this.j0);
    }

    public static int[] q(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    public static byte[] t(long j, String str, long j2) {
        gg3.d(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        return fy4.F0(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))));
    }

    public static boolean z(String str) {
        str.getClass();
        switch (str) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "S_TEXT/SSA":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/WEBVTT":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                return true;
            default:
                return false;
        }
    }

    public boolean A(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public final void B() {
        if (this.x) {
            for (int i = 0; i < this.c.size(); i++) {
                if (((d) this.c.valueAt(i)).W) {
                    return;
                }
            }
            ((mz0) gg3.q(this.j0)).o();
            this.x = false;
        }
    }

    public final boolean C(yf3 yf3Var, long j) {
        if (this.J) {
            this.L = j;
            yf3Var.a = this.K;
            this.J = false;
            return true;
        }
        if (this.z) {
            long j2 = this.L;
            if (j2 != -1) {
                yf3Var.a = j2;
                this.L = -1L;
                return true;
            }
        }
        return false;
    }

    public final void D(jz0 jz0Var, int i) {
        if (this.i.j() >= i) {
            return;
        }
        if (this.i.b() < i) {
            r73 r73Var = this.i;
            r73Var.d(Math.max(r73Var.b() * 2, i));
        }
        jz0Var.readFully(this.i.f(), this.i.j(), i - this.i.j());
        this.i.e0(i);
    }

    public final void E() {
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = false;
        this.e0 = false;
        this.f0 = false;
        this.g0 = 0;
        this.h0 = (byte) 0;
        this.i0 = false;
        this.l.b0(0);
    }

    public final long F(long j) throws r83 {
        long j2 = this.t;
        if (j2 != -9223372036854775807L) {
            return fy4.u1(j, j2, 1000L);
        }
        throw r83.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    public void H(int i, long j, long j2) throws r83 {
        m();
        if (i == 160) {
            this.Y = false;
            this.Z = 0L;
            return;
        }
        if (i == 174) {
            d dVar = new d();
            this.y = dVar;
            dVar.a = this.w;
            return;
        }
        if (i == 183) {
            if (this.z) {
                return;
            }
            k(i);
            this.F = -1;
            this.G = -1L;
            this.H = -1L;
            return;
        }
        if (i == 187) {
            if (this.z) {
                return;
            }
            k(i);
            this.E = -9223372036854775807L;
            return;
        }
        if (i == 19899) {
            this.A = -1;
            this.B = -1L;
            return;
        }
        if (i == 20533) {
            u(i).i = true;
            return;
        }
        if (i == 21968) {
            u(i).z = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.s;
            if (j3 != -1 && j3 != j) {
                throw r83.a("Multiple Segment elements not supported", null);
            }
            this.s = j;
            this.r = j2;
            return;
        }
        if (i == 475249515) {
            if (this.z) {
                return;
            }
            this.D = true;
        } else if (i == 524531317 && !this.z) {
            if (this.d && this.K != -1) {
                this.J = true;
            } else {
                this.j0.u(new yz3.b(this.v));
                this.z = true;
            }
        }
    }

    public void I(int i, String str) throws r83 {
        if (i == 134) {
            u(i).c = str;
            return;
        }
        if (i != 17026) {
            if (i == 21358) {
                u(i).b = str;
                return;
            } else {
                if (i != 2274716) {
                    return;
                }
                u(i).Z = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            this.w = Objects.equals(str, "webm");
            return;
        }
        throw r83.a("DocType " + str + " not supported", null);
    }

    public final int J(jz0 jz0Var, d dVar, int i, boolean z) throws r83 {
        int i2;
        if ("S_TEXT/UTF8".equals(dVar.c)) {
            K(jz0Var, l0, i);
            return r();
        }
        if ("S_TEXT/ASS".equals(dVar.c) || "S_TEXT/SSA".equals(dVar.c)) {
            K(jz0Var, n0, i);
            return r();
        }
        if ("S_TEXT/WEBVTT".equals(dVar.c)) {
            K(jz0Var, o0, i);
            return r();
        }
        if (dVar.W) {
            gg3.q(dVar.b0);
            if (rp0.f(jz0Var, i)) {
                dVar.b0 = dVar.b0.b().A0("audio/vnd.dts.hd").Q();
            }
            dVar.a0.g(dVar.b0);
            dVar.W = false;
            B();
        }
        gr4 gr4Var = dVar.a0;
        if (!this.d0) {
            if (dVar.i) {
                this.W &= -1073741825;
                if (!this.e0) {
                    jz0Var.readFully(this.i.f(), 0, 1);
                    this.a0++;
                    if ((this.i.f()[0] & 128) == 128) {
                        throw r83.a("Extension bit is set in signal byte", null);
                    }
                    this.h0 = this.i.f()[0];
                    this.e0 = true;
                }
                byte b2 = this.h0;
                if ((b2 & 1) == 1) {
                    boolean z2 = (b2 & 2) == 2;
                    this.W |= Buffer.MAX_SIZE;
                    if (!this.i0) {
                        jz0Var.readFully(this.n.f(), 0, 8);
                        this.a0 += 8;
                        this.i0 = true;
                        this.i.f()[0] = (byte) ((z2 ? 128 : 0) | 8);
                        this.i.f0(0);
                        gr4Var.c(this.i, 1, 1);
                        this.b0++;
                        this.n.f0(0);
                        gr4Var.c(this.n, 8, 1);
                        this.b0 += 8;
                    }
                    if (z2) {
                        if (!this.f0) {
                            jz0Var.readFully(this.i.f(), 0, 1);
                            this.a0++;
                            this.i.f0(0);
                            this.g0 = this.i.Q();
                            this.f0 = true;
                        }
                        int i3 = this.g0 * 4;
                        this.i.b0(i3);
                        jz0Var.readFully(this.i.f(), 0, i3);
                        this.a0 += i3;
                        short s = (short) ((this.g0 / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.q;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.q = ByteBuffer.allocate(i4);
                        }
                        this.q.position(0);
                        this.q.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.g0;
                            if (i5 >= i2) {
                                break;
                            }
                            int iU = this.i.U();
                            int i7 = i5 % 2;
                            ByteBuffer byteBuffer2 = this.q;
                            if (i7 == 0) {
                                byteBuffer2.putShort((short) (iU - i6));
                            } else {
                                byteBuffer2.putInt(iU - i6);
                            }
                            i5++;
                            i6 = iU;
                        }
                        int i8 = (i - this.a0) - i6;
                        int i9 = i2 % 2;
                        ByteBuffer byteBuffer3 = this.q;
                        if (i9 == 1) {
                            byteBuffer3.putInt(i8);
                        } else {
                            byteBuffer3.putShort((short) i8);
                            this.q.putInt(0);
                        }
                        this.o.d0(this.q.array(), i4);
                        gr4Var.c(this.o, i4, 1);
                        this.b0 += i4;
                    }
                }
            } else {
                byte[] bArr = dVar.j;
                if (bArr != null) {
                    this.l.d0(bArr, bArr.length);
                }
            }
            if (dVar.r(z)) {
                this.W |= 268435456;
                this.p.b0(0);
                int iJ = (this.l.j() + i) - this.a0;
                this.i.b0(4);
                this.i.f()[0] = (byte) ((iJ >> 24) & 255);
                this.i.f()[1] = (byte) ((iJ >> 16) & 255);
                this.i.f()[2] = (byte) ((iJ >> 8) & 255);
                this.i.f()[3] = (byte) (iJ & 255);
                gr4Var.c(this.i, 4, 2);
                this.b0 += 4;
            }
            this.d0 = true;
        }
        int iJ2 = i + this.l.j();
        if (!"V_MPEG4/ISO/AVC".equals(dVar.c) && !"V_MPEGH/ISO/HEVC".equals(dVar.c)) {
            if (dVar.V != null) {
                gg3.v(this.l.j() == 0);
                dVar.V.d(jz0Var);
            }
            while (true) {
                int i10 = this.a0;
                if (i10 >= iJ2) {
                    break;
                }
                int iL = L(jz0Var, gr4Var, iJ2 - i10);
                this.a0 += iL;
                this.b0 += iL;
            }
        } else {
            byte[] bArrF = this.h.f();
            bArrF[0] = 0;
            bArrF[1] = 0;
            bArrF[2] = 0;
            int i11 = dVar.c0;
            int i12 = 4 - i11;
            while (this.a0 < iJ2) {
                int i13 = this.c0;
                if (i13 == 0) {
                    M(jz0Var, bArrF, i12, i11);
                    this.a0 += i11;
                    this.h.f0(0);
                    this.c0 = this.h.U();
                    this.g.f0(0);
                    gr4Var.a(this.g, 4);
                    this.b0 += 4;
                } else {
                    int iL2 = L(jz0Var, gr4Var, i13);
                    this.a0 += iL2;
                    this.b0 += iL2;
                    this.c0 -= iL2;
                }
            }
        }
        if ("A_VORBIS".equals(dVar.c)) {
            this.j.f0(0);
            gr4Var.a(this.j, 4);
            this.b0 += 4;
        }
        return r();
    }

    public final void K(jz0 jz0Var, byte[] bArr, int i) {
        int length = bArr.length + i;
        int iB = this.m.b();
        r73 r73Var = this.m;
        if (iB < length) {
            r73Var.c0(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, r73Var.f(), 0, bArr.length);
        }
        jz0Var.readFully(this.m.f(), bArr.length, i);
        this.m.f0(0);
        this.m.e0(length);
    }

    public final int L(jz0 jz0Var, gr4 gr4Var, int i) {
        int iA = this.l.a();
        if (iA <= 0) {
            return gr4Var.d(jz0Var, i, false);
        }
        int iMin = Math.min(i, iA);
        gr4Var.a(this.l, iMin);
        return iMin;
    }

    public final void M(jz0 jz0Var, byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, this.l.a());
        jz0Var.readFully(bArr, i + iMin, i2 - iMin);
        if (iMin > 0) {
            this.l.u(bArr, i, iMin);
        }
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        this.M = -9223372036854775807L;
        this.O = 0;
        this.a.reset();
        this.b.e();
        E();
        this.D = false;
        this.E = -9223372036854775807L;
        this.F = -1;
        this.G = -1L;
        this.H = -1L;
        if (!this.z) {
            this.C.clear();
        }
        for (int i = 0; i < this.c.size(); i++) {
            ((d) this.c.valueAt(i)).q();
        }
    }

    @Override // defpackage.hz0
    public final void b(mz0 mz0Var) {
        if (this.e) {
            mz0Var = new li4(mz0Var, this.f);
        }
        this.j0 = mz0Var;
    }

    @Override // defpackage.hz0
    public final int d(jz0 jz0Var, yf3 yf3Var) {
        this.N = false;
        boolean zA = true;
        while (zA && !this.N) {
            zA = this.a.a(jz0Var);
            if (zA && C(yf3Var, jz0Var.getPosition())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i = 0; i < this.c.size(); i++) {
            d dVar = (d) this.c.valueAt(i);
            dVar.g();
            dVar.m();
        }
        return -1;
    }

    @Override // defpackage.hz0
    public final boolean e(jz0 jz0Var) {
        return new v94().b(jz0Var);
    }

    public final void k(int i) throws r83 {
        if (this.D) {
            return;
        }
        throw r83.a("Element " + i + " must be in a Cues", null);
    }

    public final void l(int i) throws r83 {
        if (this.y != null) {
            return;
        }
        throw r83.a("Element " + i + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0294  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(int r27, int r28, defpackage.jz0 r29) throws defpackage.r83 {
        /*
            Method dump skipped, instruction units count: 770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u62.n(int, int, jz0):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(u62.d r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u62.o(u62$d, long, int, int, int):void");
    }

    public void p(int i) throws r83 {
        int i2;
        SparseArray sparseArray;
        m();
        if (i == 160) {
            if (this.O != 2) {
                return;
            }
            d dVar = (d) this.c.get(this.U);
            dVar.g();
            if (this.Z > 0 && "A_OPUS".equals(dVar.c)) {
                this.p.c0(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.Z).array());
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.S; i4++) {
                i3 += this.T[i4];
            }
            int i5 = 0;
            while (i5 < this.S) {
                long j = this.P + ((long) ((dVar.f * i5) / 1000));
                int i6 = this.W;
                if (i5 == 0 && !this.Y) {
                    i6 |= 1;
                }
                int i7 = this.T[i5];
                int i8 = i3 - i7;
                o(dVar, j, i6, i7, i8);
                i5++;
                i3 = i8;
            }
            this.O = 0;
            return;
        }
        if (i == 174) {
            d dVar2 = (d) gg3.q(this.y);
            String str = dVar2.c;
            if (str == null) {
                throw r83.a("CodecId is missing in TrackEntry element", null);
            }
            if (z(str)) {
                dVar2.k(dVar2.d);
                dVar2.a0 = this.j0.e(dVar2.d, dVar2.e);
                this.c.put(dVar2.d, dVar2);
            }
            this.y = null;
            return;
        }
        if (i == 183) {
            if (this.z) {
                return;
            }
            k(i);
            if (this.E == -9223372036854775807L || (i2 = this.F) == -1 || this.G == -1) {
                return;
            }
            List arrayList = (List) this.C.get(i2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.C.put(this.F, arrayList);
            }
            arrayList.add(new c.a(this.E, this.s + this.G, this.H));
            return;
        }
        if (i == 19899) {
            int i9 = this.A;
            if (i9 != -1) {
                long j2 = this.B;
                if (j2 != -1) {
                    if (i9 == 475249515) {
                        this.K = j2;
                        return;
                    }
                    return;
                }
            }
            throw r83.a("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i == 25152) {
            l(i);
            d dVar3 = this.y;
            if (dVar3.i) {
                if (dVar3.k == null) {
                    throw r83.a("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                dVar3.m = new oo0(new oo0.b(kn.b, "video/webm", this.y.k.b));
                return;
            }
            return;
        }
        if (i == 28032) {
            l(i);
            d dVar4 = this.y;
            if (dVar4.i && dVar4.j != null) {
                throw r83.a("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i == 357149030) {
            if (this.t == -9223372036854775807L) {
                this.t = 1000000L;
            }
            long j3 = this.u;
            if (j3 != -9223372036854775807L) {
                this.v = F(j3);
                return;
            }
            return;
        }
        if (i != 374648427) {
            if (i == 475249515 && !this.z) {
                int i10 = 0;
                while (true) {
                    if (i10 >= this.C.size()) {
                        break;
                    }
                    if (((List) this.C.valueAt(i10)).isEmpty()) {
                        i10++;
                    } else {
                        if (this.v == -9223372036854775807L) {
                            break;
                        }
                        int i11 = 0;
                        while (true) {
                            int size = this.C.size();
                            sparseArray = this.C;
                            if (i11 >= size) {
                                break;
                            }
                            Collections.sort((List) sparseArray.valueAt(i11));
                            i11++;
                        }
                        this.j0.u(new c(sparseArray, this.v, this.I, this.s, this.r));
                    }
                }
                this.j0.u(new yz3.b(this.v));
                this.z = true;
                this.D = false;
                for (int i12 = 0; i12 < this.c.size(); i12++) {
                    d dVar5 = (d) this.c.valueAt(i12);
                    dVar5.l(this.C, this.v, this.s, this.r);
                    if (!dVar5.W) {
                        dVar5.g();
                        dVar5.a0.g((t41) gg3.q(dVar5.b0));
                    }
                }
                B();
                return;
            }
            return;
        }
        if (this.c.size() == 0) {
            throw r83.a("No valid tracks were found", null);
        }
        boolean z = !this.d || this.K == -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < this.c.size(); i17++) {
            d dVar6 = (d) this.c.valueAt(i17);
            int i18 = dVar6.e;
            if (i18 == 2) {
                if (dVar6.Y) {
                    i13 = dVar6.d;
                }
                if (i14 == -1) {
                    i14 = dVar6.d;
                }
            } else if (i18 == 1) {
                if (dVar6.Y) {
                    i15 = dVar6.d;
                }
                if (i16 == -1) {
                    i16 = dVar6.d;
                }
            }
            if (z) {
                dVar6.g();
                if (!dVar6.W) {
                    dVar6.a0.g((t41) gg3.q(dVar6.b0));
                }
            }
        }
        if (i13 != -1) {
            this.I = i13;
        } else if (i14 != -1) {
            this.I = i14;
        } else if (i15 != -1) {
            this.I = i15;
        } else if (i16 != -1) {
            this.I = i16;
        } else {
            this.I = this.c.size() > 0 ? ((d) this.c.valueAt(0)).d : -1;
        }
        if (z) {
            B();
        }
    }

    public final int r() {
        int i = this.b0;
        E();
        return i;
    }

    @Override // defpackage.hz0
    public final void release() {
    }

    public void s(int i, double d2) throws r83 {
        if (i == 181) {
            u(i).S = (int) d2;
            return;
        }
        if (i == 17545) {
            this.u = (long) d2;
            return;
        }
        switch (i) {
            case 21969:
                u(i).F = (float) d2;
                break;
            case 21970:
                u(i).G = (float) d2;
                break;
            case 21971:
                u(i).H = (float) d2;
                break;
            case 21972:
                u(i).I = (float) d2;
                break;
            case 21973:
                u(i).J = (float) d2;
                break;
            case 21974:
                u(i).K = (float) d2;
                break;
            case 21975:
                u(i).L = (float) d2;
                break;
            case 21976:
                u(i).M = (float) d2;
                break;
            case 21977:
                u(i).N = (float) d2;
                break;
            case 21978:
                u(i).O = (float) d2;
                break;
            default:
                switch (i) {
                    case 30323:
                        u(i).u = (float) d2;
                        break;
                    case 30324:
                        u(i).v = (float) d2;
                        break;
                    case 30325:
                        u(i).w = (float) d2;
                        break;
                }
                break;
        }
    }

    public d u(int i) throws r83 {
        l(i);
        return this.y;
    }

    public int v(int i) {
        switch (i) {
            case Token.DO /* 131 */:
            case Token.WITH /* 136 */:
            case Token.LOCAL_BLOCK /* 155 */:
            case Token.XML /* 159 */:
            case Token.GENEXPR /* 176 */:
            case Token.YIELD_STAR /* 179 */:
            case Token.QUESTION_DOT /* 186 */:
            case 215:
            case 231:
            case 238:
            case 240:
            case 241:
            case 247:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21938:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case Token.CONTINUE /* 134 */:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case Token.SET /* 166 */:
            case Token.DEBUGGER /* 174 */:
            case Token.TAGGED_TEMPLATE_LITERAL /* 183 */:
            case Token.LAST_TOKEN /* 187 */:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case Token.XMLATTR /* 161 */:
            case Token.TO_OBJECT /* 163 */:
            case Token.GET /* 165 */:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case Token.TEMPLATE_CHARS /* 181 */:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    public void w(d dVar, jz0 jz0Var, int i) {
        if (dVar.h != 1685485123 && dVar.h != 1685480259) {
            jz0Var.q(i);
            return;
        }
        byte[] bArr = new byte[i];
        dVar.P = bArr;
        jz0Var.readFully(bArr, 0, i);
    }

    public void x(d dVar, int i, jz0 jz0Var, int i2) {
        if (i != 4 || !"V_VP9".equals(dVar.c)) {
            jz0Var.q(i2);
        } else {
            this.p.b0(i2);
            jz0Var.readFully(this.p.f(), 0, i2);
        }
    }

    public void y(int i, long j) throws r83 {
        if (i == 240) {
            if (this.z) {
                return;
            }
            k(i);
            if (this.H == -1) {
                this.H = j;
                return;
            }
            return;
        }
        if (i == 241) {
            if (this.z) {
                return;
            }
            k(i);
            if (this.G == -1) {
                this.G = j;
                return;
            }
            return;
        }
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw r83.a("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw r83.a("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case Token.DO /* 131 */:
                int i2 = (int) j;
                if (i2 == 1) {
                    u(i).e = 2;
                    return;
                }
                if (i2 == 2) {
                    u(i).e = 1;
                    return;
                }
                if (i2 == 17) {
                    u(i).e = 3;
                    return;
                } else if (i2 != 33) {
                    u(i).e = -1;
                    return;
                } else {
                    u(i).e = 5;
                    return;
                }
            case Token.WITH /* 136 */:
                u(i).Y = j == 1;
                return;
            case Token.LOCAL_BLOCK /* 155 */:
                this.Q = F(j);
                return;
            case Token.XML /* 159 */:
                u(i).Q = (int) j;
                return;
            case Token.GENEXPR /* 176 */:
                u(i).n = (int) j;
                return;
            case Token.YIELD_STAR /* 179 */:
                if (this.z) {
                    return;
                }
                k(i);
                this.E = F(j);
                return;
            case Token.QUESTION_DOT /* 186 */:
                u(i).o = (int) j;
                return;
            case 215:
                u(i).d = (int) j;
                return;
            case 231:
                this.M = F(j);
                return;
            case 238:
                this.X = (int) j;
                return;
            case 247:
                if (this.z) {
                    return;
                }
                k(i);
                this.F = (int) j;
                return;
            case 251:
                this.Y = true;
                return;
            case 16871:
                u(i).h = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw r83.a("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw r83.a("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw r83.a("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw r83.a("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw r83.a("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.B = j + this.s;
                return;
            case 21432:
                int i3 = (int) j;
                l(i);
                if (i3 == 0) {
                    this.y.y = 0;
                    return;
                }
                if (i3 == 1) {
                    this.y.y = 2;
                    return;
                } else if (i3 == 3) {
                    this.y.y = 1;
                    return;
                } else {
                    if (i3 != 15) {
                        return;
                    }
                    this.y.y = 3;
                    return;
                }
            case 21680:
                u(i).q = (int) j;
                return;
            case 21682:
                u(i).s = (int) j;
                return;
            case 21690:
                u(i).r = (int) j;
                return;
            case 21930:
                u(i).X = j == 1;
                return;
            case 21938:
                l(i);
                d dVar = this.y;
                dVar.z = true;
                dVar.p = (int) j;
                return;
            case 21998:
                u(i).g = (int) j;
                return;
            case 22186:
                u(i).T = j;
                return;
            case 22203:
                u(i).U = j;
                return;
            case 25188:
                u(i).R = (int) j;
                return;
            case 30114:
                this.Z = j;
                return;
            case 30321:
                l(i);
                int i4 = (int) j;
                if (i4 == 0) {
                    this.y.t = 0;
                    return;
                }
                if (i4 == 1) {
                    this.y.t = 1;
                    return;
                } else if (i4 == 2) {
                    this.y.t = 2;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.y.t = 3;
                    return;
                }
            case 2352003:
                u(i).f = (int) j;
                return;
            case 2807729:
                this.t = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        l(i);
                        int i5 = (int) j;
                        if (i5 == 1) {
                            this.y.C = 2;
                            return;
                        } else {
                            if (i5 != 2) {
                                return;
                            }
                            this.y.C = 1;
                            return;
                        }
                    case 21946:
                        l(i);
                        int iL = bx.l((int) j);
                        if (iL != -1) {
                            this.y.B = iL;
                            return;
                        }
                        return;
                    case 21947:
                        l(i);
                        this.y.z = true;
                        int iK = bx.k((int) j);
                        if (iK != -1) {
                            this.y.A = iK;
                            return;
                        }
                        return;
                    case 21948:
                        u(i).D = (int) j;
                        return;
                    case 21949:
                        u(i).E = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    public u62(ki4.a aVar, int i) {
        this(new lf0(), i, aVar);
    }
}
