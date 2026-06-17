package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.session.MediaLibraryService;
import defpackage.b24;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.xi1;
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

    public j(int i2, long j2, MediaLibraryService.b bVar, b24 b24Var, Object obj, int i3) {
        this.a = i2;
        this.b = j2;
        this.e = bVar;
        this.f = b24Var;
        this.c = obj;
        this.d = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.session.j c(android.os.Bundle r10, java.lang.Integer r11, final int r12) {
        /*
            java.lang.String r0 = androidx.media3.session.j.g
            r1 = 0
            int r3 = r10.getInt(r0, r1)
            java.lang.String r0 = androidx.media3.session.j.h
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r4 = r10.getLong(r0, r4)
            java.lang.String r0 = androidx.media3.session.j.i
            android.os.Bundle r0 = r10.getBundle(r0)
            r2 = 0
            if (r0 != 0) goto L1c
            r6 = r2
            goto L21
        L1c:
            androidx.media3.session.MediaLibraryService$b r0 = androidx.media3.session.MediaLibraryService.b.a(r0)
            r6 = r0
        L21:
            java.lang.String r0 = androidx.media3.session.j.l
            android.os.Bundle r0 = r10.getBundle(r0)
            if (r0 == 0) goto L2f
            b24 r0 = defpackage.b24.a(r0)
        L2d:
            r7 = r0
            goto L3a
        L2f:
            if (r3 == 0) goto L39
            b24 r0 = new b24
            java.lang.String r7 = "no error message provided"
            r0.<init>(r3, r7)
            goto L2d
        L39:
            r7 = r2
        L3a:
            java.lang.String r0 = androidx.media3.session.j.k
            int r9 = r10.getInt(r0)
            r0 = 1
            if (r9 == r0) goto L73
            r8 = 2
            if (r9 == r8) goto L75
            r8 = 3
            if (r9 == r8) goto L51
            r10 = 4
            if (r9 != r10) goto L4d
            goto L73
        L4d:
            defpackage.z20.a()
            return r2
        L51:
            if (r11 == 0) goto L59
            int r11 = r11.intValue()
            if (r11 != r8) goto L5a
        L59:
            r1 = r0
        L5a:
            defpackage.gg3.v(r1)
            java.lang.String r11 = androidx.media3.session.j.j
            android.os.IBinder r10 = defpackage.hm.a(r10, r11)
            if (r10 != 0) goto L66
            goto L73
        L66:
            vs1 r11 = new vs1
            r11.<init>()
            xi1 r10 = defpackage.km.a(r10)
            xi1 r2 = defpackage.fm.d(r11, r10)
        L73:
            r8 = r2
            goto L8f
        L75:
            if (r11 == 0) goto L7d
            int r11 = r11.intValue()
            if (r11 != r8) goto L7e
        L7d:
            r1 = r0
        L7e:
            defpackage.gg3.v(r1)
            java.lang.String r11 = androidx.media3.session.j.j
            android.os.Bundle r10 = r10.getBundle(r11)
            if (r10 != 0) goto L8a
            goto L73
        L8a:
            fg2 r2 = defpackage.fg2.b(r10, r12)
            goto L73
        L8f:
            androidx.media3.session.j r2 = new androidx.media3.session.j
            r2.<init>(r3, r4, r6, r7, r8, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.j.c(android.os.Bundle, java.lang.Integer, int):androidx.media3.session.j");
    }

    public static j d(Bundle bundle, int i2) {
        return c(bundle, null, i2);
    }

    public static j e(int i2) {
        return g(new b24(i2, "no error message provided", Bundle.EMPTY));
    }

    public static j f(int i2, MediaLibraryService.b bVar) {
        return new j(i2, SystemClock.elapsedRealtime(), bVar, new b24(i2, "no error message provided", Bundle.EMPTY), null, 4);
    }

    public static j g(b24 b24Var) {
        return new j(b24Var.a, SystemClock.elapsedRealtime(), null, b24Var, null, 4);
    }

    public static j h(fg2 fg2Var, MediaLibraryService.b bVar) {
        m(fg2Var);
        return new j(0, SystemClock.elapsedRealtime(), bVar, null, fg2Var, 2);
    }

    public static j i(List list, MediaLibraryService.b bVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m((fg2) it.next());
        }
        return new j(0, SystemClock.elapsedRealtime(), bVar, null, xi1.p(list), 3);
    }

    public static j j() {
        return new j(0, SystemClock.elapsedRealtime(), null, null, null, 1);
    }

    public static j k(MediaLibraryService.b bVar) {
        return new j(0, SystemClock.elapsedRealtime(), bVar, null, null, 1);
    }

    public static void m(fg2 fg2Var) {
        gg3.e(!TextUtils.isEmpty(fg2Var.a), "mediaId must not be empty");
        gg3.e(fg2Var.e.r != null, "mediaMetadata must specify isBrowsable");
        gg3.e(fg2Var.e.s != null, "mediaMetadata must specify isPlayable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r2 != 4) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle l(final int r5) {
        /*
            r4 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = androidx.media3.session.j.g
            int r2 = r4.a
            r0.putInt(r1, r2)
            java.lang.String r1 = androidx.media3.session.j.h
            long r2 = r4.b
            r0.putLong(r1, r2)
            androidx.media3.session.MediaLibraryService$b r1 = r4.e
            if (r1 == 0) goto L20
            java.lang.String r2 = androidx.media3.session.j.i
            android.os.Bundle r1 = r1.b()
            r0.putBundle(r2, r1)
        L20:
            b24 r1 = r4.f
            if (r1 == 0) goto L2d
            java.lang.String r2 = androidx.media3.session.j.l
            android.os.Bundle r1 = r1.b()
            r0.putBundle(r2, r1)
        L2d:
            java.lang.String r1 = androidx.media3.session.j.k
            int r2 = r4.d
            r0.putInt(r1, r2)
            java.lang.Object r1 = r4.c
            if (r1 != 0) goto L39
            goto L47
        L39:
            int r2 = r4.d
            r3 = 1
            if (r2 == r3) goto L6c
            r3 = 2
            if (r2 == r3) goto L60
            r1 = 3
            if (r2 == r1) goto L48
            r4 = 4
            if (r2 == r4) goto L6c
        L47:
            return r0
        L48:
            java.lang.String r1 = androidx.media3.session.j.j
            km r2 = new km
            java.lang.Object r4 = r4.c
            xi1 r4 = (defpackage.xi1) r4
            ws1 r3 = new ws1
            r3.<init>()
            xi1 r4 = defpackage.fm.i(r4, r3)
            r2.<init>(r4)
            defpackage.hm.b(r0, r1, r2)
            return r0
        L60:
            java.lang.String r4 = androidx.media3.session.j.j
            fg2 r1 = (defpackage.fg2) r1
            android.os.Bundle r5 = r1.e(r5)
            r0.putBundle(r4, r5)
            return r0
        L6c:
            defpackage.z20.a()
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.j.l(int):android.os.Bundle");
    }
}
