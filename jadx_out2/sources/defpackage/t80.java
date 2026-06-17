package defpackage;

import android.graphics.Typeface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class t80 implements Cloneable {
    public boolean A;
    public n r;
    public List v;
    public boolean z;
    public Typeface f = null;
    public int g = k5.a;
    public float h = 1.0f;
    public int i = 0;
    public boolean j = true;
    public boolean k = true;
    public boolean l = true;
    public boolean m = true;
    public boolean n = true;
    public List o = new ArrayList();
    public int p = -1;
    public float q = 1.0f;
    public List s = new ArrayList();
    public List t = new ArrayList();
    public List u = new ArrayList();
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public o B = new a6();
    public ta1 C = new ta1();
    public z80 D = new z80();
    public y80 E = y80.a();
    public ro F = ro.j;
    public byte G = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        boolean a(t80 t80Var, b bVar, Object... objArr);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum b {
        FT_DANMAKU_VISIBILITY,
        FB_DANMAKU_VISIBILITY,
        L2R_DANMAKU_VISIBILITY,
        R2L_DANMAKU_VISIBILIY,
        SPECIAL_DANMAKU_VISIBILITY,
        TYPEFACE,
        TRANSPARENCY,
        SCALE_TEXTSIZE,
        MAXIMUM_NUMS_IN_SCREEN,
        DANMAKU_STYLE,
        DANMAKU_BOLD,
        COLOR_VALUE_WHITE_LIST,
        USER_ID_BLACK_LIST,
        USER_HASH_BLACK_LIST,
        SCROLL_SPEED_FACTOR,
        BLOCK_GUEST_DANMAKU,
        DUPLICATE_MERGING_ENABLED,
        MAXIMUN_LINES,
        OVERLAPPING_ENABLE,
        ALIGN_BOTTOM,
        DANMAKU_MARGIN,
        DANMAKU_SYNC;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a() {
            return equals(FT_DANMAKU_VISIBILITY) || equals(FB_DANMAKU_VISIBILITY) || equals(L2R_DANMAKU_VISIBILITY) || equals(R2L_DANMAKU_VISIBILIY) || equals(SPECIAL_DANMAKU_VISIBILITY) || equals(COLOR_VALUE_WHITE_LIST) || equals(USER_ID_BLACK_LIST);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t80 a() {
        return new t80();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public o b() {
        return this.B;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c() {
        return this.y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object clone() {
        return super.clone();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e() {
        return this.z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f() {
        return this.A;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(b bVar, Object... objArr) {
        List list = this.v;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a aVar = (a) ((WeakReference) it.next()).get();
                if (aVar != null) {
                    aVar.a(this, bVar, objArr);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(a aVar) {
        if (aVar == null || this.v == null) {
            this.v = Collections.synchronizedList(new ArrayList());
        }
        Iterator it = this.v.iterator();
        while (it.hasNext()) {
            if (aVar.equals(((WeakReference) it.next()).get())) {
                return;
            }
        }
        this.v.add(new WeakReference(aVar));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t80 i(int i) {
        if (this.i != i) {
            this.i = i;
            this.B.f(i);
            this.C.b();
            this.C.g();
            g(b.DANMAKU_MARGIN, Integer.valueOf(i));
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t80 j(int i, float... fArr) {
        this.B.h(i, fArr);
        g(b.DANMAKU_STYLE, Integer.valueOf(i), fArr);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t80 k(n nVar) {
        this.r = nVar;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t80 l(float f) {
        int i = (int) (k5.a * f);
        if (i != this.g) {
            this.g = i;
            this.B.A(i);
            g(b.TRANSPARENCY, Float.valueOf(f));
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(String str, Object obj, boolean z) {
        this.D.d(str, z).b(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t80 n(Map map) {
        this.z = map != null;
        if (map == null) {
            this.D.i("1018_Filter", false);
        } else {
            m("1018_Filter", map, false);
        }
        this.C.b();
        g(b.MAXIMUN_LINES, map);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t80 o(float f) {
        if (this.h != f) {
            this.h = f;
            this.B.u();
            this.B.z(f);
            this.C.d();
            this.C.g();
            g(b.SCALE_TEXTSIZE, Float.valueOf(f));
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t80 p(float f) {
        if (this.q != f) {
            this.q = f;
            this.E.g(f);
            this.C.d();
            this.C.g();
            g(b.SCROLL_SPEED_FACTOR, Float.valueOf(f));
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q() {
        List list = this.v;
        if (list != null) {
            list.clear();
            this.v = null;
        }
    }
}
