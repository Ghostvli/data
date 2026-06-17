package defpackage;

import android.net.Uri;
import defpackage.ki4;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vf0 implements pz0 {
    public static final int[] t = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    public static final a u = new a(new a.InterfaceC0127a() { // from class: tf0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // vf0.a.InterfaceC0127a
        public final Constructor a() {
            return vf0.l();
        }
    });
    public static final a v = new a(new a.InterfaceC0127a() { // from class: uf0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // vf0.a.InterfaceC0127a
        public final Constructor a() {
            return vf0.m();
        }
    });
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int l;
    public xi1 m;
    public int r;
    public int s;
    public int k = 1;
    public int n = 112800;
    public ki4.a p = new qh0();
    public boolean o = true;
    public int q = 3;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final InterfaceC0127a a;
        public final AtomicBoolean b = new AtomicBoolean(false);
        public Constructor c;

        /* JADX INFO: renamed from: vf0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public interface InterfaceC0127a {
            Constructor a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(InterfaceC0127a interfaceC0127a) {
            this.a = interfaceC0127a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public hz0 a(Object... objArr) {
            Constructor constructorB = b();
            if (constructorB == null) {
                return null;
            }
            try {
                return (hz0) constructorB.newInstance(objArr);
            } catch (Exception e) {
                l02.a("Unexpected error creating extractor", e);
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Constructor b() {
            synchronized (this.b) {
                if (this.b.get()) {
                    return this.c;
                }
                try {
                    return this.a.a();
                } catch (ClassNotFoundException unused) {
                    this.b.set(true);
                    return this.c;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Constructor l() {
        if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(hz0.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Constructor m() {
        return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(hz0.class).getConstructor(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pz0
    public synchronized hz0[] d() {
        return f(Uri.EMPTY, new HashMap());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pz0
    public synchronized hz0[] f(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            int[] iArr = t;
            arrayList = new ArrayList(iArr.length);
            int iB = s01.b(map);
            if (iB != -1) {
                i(iB, arrayList);
            }
            int iC = s01.c(uri);
            if (iC != -1 && iC != iB) {
                i(iC, arrayList);
            }
            for (int i : iArr) {
                if (i != iB && i != iC) {
                    i(i, arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (hz0[]) arrayList.toArray(new hz0[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(int i, List list) {
        switch (i) {
            case 0:
                list.add(new j1());
                break;
            case 1:
                list.add(new n1());
                break;
            case 2:
                list.add(new d5(this.d | (this.b ? 1 : 0) | (this.c ? 2 : 0)));
                break;
            case 3:
                list.add(new n5(this.e | (this.b ? 1 : 0) | (this.c ? 2 : 0)));
                break;
            case 4:
                hz0 hz0VarA = u.a(Integer.valueOf(this.f));
                if (hz0VarA == null) {
                    list.add(new a21(this.f));
                } else {
                    list.add(hz0VarA);
                }
                break;
            case 5:
                list.add(new r31());
                break;
            case 6:
                list.add(new u62(this.p, this.g | (this.o ? 0 : 2)));
                break;
            case 7:
                list.add(new pu2(this.j | (this.b ? 1 : 0) | (this.c ? 2 : 0)));
                break;
            case 8:
                list.add(new q71(this.p, this.i | q71.k(this.q) | (this.o ? 0 : 32)));
                list.add(new yu2(this.p, this.h | yu2.q(this.q) | (this.o ? 0 : 16)));
                break;
            case 9:
                list.add(new d53());
                break;
            case 10:
                list.add(new vi3());
                break;
            case 11:
                if (this.m == null) {
                    this.m = xi1.u();
                }
                list.add(new vt4(this.k, !this.o ? 1 : 0, this.p, new yo4(0L), new wi0(this.l, this.m), this.n));
                break;
            case 12:
                list.add(new o85());
                break;
            case 14:
                list.add(new xn1(this.r));
                break;
            case 15:
                hz0 hz0VarA2 = v.a(new Object[0]);
                if (hz0VarA2 != null) {
                    list.add(hz0VarA2);
                }
                break;
            case 16:
                list.add(new ef(!this.o ? 1 : 0, this.p));
                break;
            case 17:
                list.add(new cf3());
                break;
            case 18:
                list.add(new x85());
                break;
            case 19:
                list.add(new zk());
                break;
            case 20:
                list.add(new fd1(this.s));
                break;
            case 21:
                list.add(new kf());
                break;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: c(I)Lpz0; */
    @Override // defpackage.pz0
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public synchronized vf0 c(int i) {
        this.q = i;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: e(Z)Lpz0; */
    @Override // defpackage.pz0
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public synchronized vf0 e(boolean z) {
        this.o = z;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized vf0 n(int i) {
        this.s = i;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized vf0 o(int i) {
        this.r = i;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Lki4$a;)Lpz0; */
    @Override // defpackage.pz0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public synchronized vf0 a(ki4.a aVar) {
        this.p = aVar;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized vf0 q(int i) {
        this.l = i;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized vf0 r(int i) {
        this.n = i;
        return this;
    }
}
