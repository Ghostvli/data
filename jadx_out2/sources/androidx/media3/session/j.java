package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.session.MediaLibraryService;
import defpackage.b24;
import defpackage.fg2;
import defpackage.fm;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hm;
import defpackage.km;
import defpackage.p81;
import defpackage.xi1;
import defpackage.z20;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final String g = fy4.N0(0);
    public static final String h = fy4.N0(1);
    public static final String i = fy4.N0(2);
    public static final String j = fy4.N0(3);
    public static final String k = fy4.N0(4);
    public static final String l = fy4.N0(5);
    public final int a;
    public final long b;
    public final Object c;
    public final int d;
    public final MediaLibraryService.b e;
    public final b24 f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public j(int i2, long j2, MediaLibraryService.b bVar, b24 b24Var, Object obj, int i3) {
        this.a = i2;
        this.b = j2;
        this.e = bVar;
        this.f = b24Var;
        this.c = obj;
        this.d = i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static j c(Bundle bundle, Integer num, final int i2) {
        b24 b24Var;
        b24 b24Var2;
        int i3;
        int i4 = bundle.getInt(g, 0);
        long j2 = bundle.getLong(h, SystemClock.elapsedRealtime());
        Bundle bundle2 = bundle.getBundle(i);
        Object objB = null;
        MediaLibraryService.b bVarA = bundle2 == null ? null : MediaLibraryService.b.a(bundle2);
        Bundle bundle3 = bundle.getBundle(l);
        if (bundle3 != null) {
            b24Var2 = b24.a(bundle3);
        } else {
            if (i4 == 0) {
                b24Var = null;
                i3 = bundle.getInt(k);
                if (i3 != 1) {
                    if (i3 == 2) {
                        gg3.v(num == null || num.intValue() == 2);
                        Bundle bundle4 = bundle.getBundle(j);
                        if (bundle4 != null) {
                            objB = fg2.b(bundle4, i2);
                        }
                    } else if (i3 == 3) {
                        gg3.v(num == null || num.intValue() == 3);
                        IBinder iBinderA = hm.a(bundle, j);
                        if (iBinderA != null) {
                            objB = fm.d(new p81() { // from class: vs1
                                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                                @Override // defpackage.p81
                                public final Object apply(Object obj) {
                                    return fg2.b((Bundle) obj, i2);
                                }
                            }, km.a(iBinderA));
                        }
                    } else if (i3 != 4) {
                        z20.a();
                        return null;
                    }
                }
                return new j(i4, j2, bVarA, b24Var, objB, i3);
            }
            b24Var2 = new b24(i4, "no error message provided");
        }
        b24Var = b24Var2;
        i3 = bundle.getInt(k);
        if (i3 != 1) {
        }
        return new j(i4, j2, bVarA, b24Var, objB, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j d(Bundle bundle, int i2) {
        return c(bundle, null, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j e(int i2) {
        return g(new b24(i2, "no error message provided", Bundle.EMPTY));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j f(int i2, MediaLibraryService.b bVar) {
        return new j(i2, SystemClock.elapsedRealtime(), bVar, new b24(i2, "no error message provided", Bundle.EMPTY), null, 4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j g(b24 b24Var) {
        return new j(b24Var.a, SystemClock.elapsedRealtime(), null, b24Var, null, 4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j h(fg2 fg2Var, MediaLibraryService.b bVar) {
        m(fg2Var);
        return new j(0, SystemClock.elapsedRealtime(), bVar, null, fg2Var, 2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j i(List list, MediaLibraryService.b bVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m((fg2) it.next());
        }
        return new j(0, SystemClock.elapsedRealtime(), bVar, null, xi1.p(list), 3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j j() {
        return new j(0, SystemClock.elapsedRealtime(), null, null, null, 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static j k(MediaLibraryService.b bVar) {
        return new j(0, SystemClock.elapsedRealtime(), bVar, null, null, 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void m(fg2 fg2Var) {
        gg3.e(!TextUtils.isEmpty(fg2Var.a), "mediaId must not be empty");
        gg3.e(fg2Var.e.r != null, "mediaMetadata must specify isBrowsable");
        gg3.e(fg2Var.e.s != null, "mediaMetadata must specify isPlayable");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r2 != 4) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bundle l(final int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(g, this.a);
        bundle.putLong(h, this.b);
        MediaLibraryService.b bVar = this.e;
        if (bVar != null) {
            bundle.putBundle(i, bVar.b());
        }
        b24 b24Var = this.f;
        if (b24Var != null) {
            bundle.putBundle(l, b24Var.b());
        }
        bundle.putInt(k, this.d);
        Object obj = this.c;
        if (obj != null) {
            int i3 = this.d;
            if (i3 != 1) {
                if (i3 == 2) {
                    bundle.putBundle(j, ((fg2) obj).e(i2));
                    return bundle;
                }
                if (i3 == 3) {
                    hm.b(bundle, j, new km(fm.i((xi1) this.c, new p81() { // from class: ws1
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // defpackage.p81
                        public final Object apply(Object obj2) {
                            return ((fg2) obj2).e(i2);
                        }
                    })));
                    return bundle;
                }
            }
            z20.a();
            return null;
        }
        return bundle;
    }
}
