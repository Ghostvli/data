package androidx.media3.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.a;
import androidx.media3.session.d0;
import defpackage.ac3;
import defpackage.b24;
import defpackage.cd3;
import defpackage.dc3;
import defpackage.dd1;
import defpackage.dj1;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.kk0;
import defpackage.la3;
import defpackage.nm3;
import defpackage.no4;
import defpackage.ph2;
import defpackage.pi2;
import defpackage.pw4;
import defpackage.qh2;
import defpackage.td4;
import defpackage.v82;
import defpackage.vn4;
import defpackage.x3;
import defpackage.xi1;
import defpackage.xz1;
import defpackage.y14;
import defpackage.yn3;
import defpackage.z62;
import defpackage.zf2;
import defpackage.zn3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static final dj1 a = dj1.B("android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.DURATION", "android.media.metadata.ALBUM", "android.media.metadata.AUTHOR", "android.media.metadata.WRITER", "android.media.metadata.COMPOSER", "android.media.metadata.COMPILATION", "android.media.metadata.DATE", "android.media.metadata.YEAR", "android.media.metadata.GENRE", "android.media.metadata.TRACK_NUMBER", "android.media.metadata.NUM_TRACKS", "android.media.metadata.DISC_NUMBER", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.ART", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART", "android.media.metadata.ALBUM_ART_URI", "android.media.metadata.USER_RATING", "android.media.metadata.RATING", "android.media.metadata.DISPLAY_TITLE", "android.media.metadata.DISPLAY_SUBTITLE", "android.media.metadata.DISPLAY_DESCRIPTION", "android.media.metadata.DISPLAY_ICON", "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.MEDIA_ID", "android.media.metadata.MEDIA_URI", "android.media.metadata.BT_FOLDER_TYPE", "android.media.metadata.ADVERTISEMENT", "android.media.metadata.DOWNLOAD_STATUS", "androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ph2 A(zf2 zf2Var, int i, boolean z, boolean z2) {
        if (zf2Var == null) {
            return ph2.M;
        }
        ph2.b bVar = new ph2.b();
        bVar.q0(zf2Var.A()).Y(zf2Var.d()).U(zf2Var.w()).w0(Q(zn3.D(i)));
        byte[] bArrV = zf2Var.v();
        if (bArrV != null) {
            bVar.T(bArrV, 3);
        }
        Bundle bundleS = zf2Var.s();
        Bundle bundle = bundleS == null ? null : new Bundle(bundleS);
        if (bundle != null && bundle.containsKey("android.media.extra.BT_FOLDER_TYPE")) {
            bVar.d0(Integer.valueOf(j(bundle.getLong("android.media.extra.BT_FOLDER_TYPE"))));
            bundle.remove("android.media.extra.BT_FOLDER_TYPE");
        }
        bVar.f0(Boolean.valueOf(z));
        if (bundle != null && bundle.containsKey("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")) {
            bVar.h0(Integer.valueOf((int) bundle.getLong("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")));
            bundle.remove("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
        }
        if (bundle != null && bundle.containsKey("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ID_LIST")) {
            bVar.r0(xi1.p((Collection) gg3.q(bundle.getStringArrayList("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ID_LIST"))));
        }
        if (bundle == null || !bundle.containsKey("androidx.media3.mediadescriptioncompat.title")) {
            bVar.s0(zf2Var.B());
        } else {
            bVar.s0(bundle.getCharSequence("androidx.media3.mediadescriptioncompat.title"));
            bVar.a0(zf2Var.B());
            bundle.remove("androidx.media3.mediadescriptioncompat.title");
        }
        if (bundle != null && !bundle.isEmpty()) {
            bVar.c0(bundle);
        }
        bVar.g0(Boolean.valueOf(z2));
        return bVar.L();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ph2 B(qh2 qh2Var, int i) {
        CharSequence charSequenceE;
        CharSequence charSequenceE2;
        if (qh2Var == null) {
            return ph2.M;
        }
        ph2.b bVar = new ph2.b();
        CharSequence charSequenceE3 = qh2Var.E("android.media.metadata.DISPLAY_TITLE");
        if (charSequenceE3 != null) {
            charSequenceE2 = qh2Var.E("android.media.metadata.DISPLAY_SUBTITLE");
            charSequenceE = qh2Var.E("android.media.metadata.DISPLAY_DESCRIPTION");
        } else {
            CharSequence[] charSequenceArr = new CharSequence[3];
            int i2 = 0;
            int i3 = 0;
            while (i2 < 3) {
                String[] strArr = qh2.j;
                if (i3 >= strArr.length) {
                    break;
                }
                int i4 = i3 + 1;
                CharSequence charSequenceE4 = qh2Var.E(strArr[i3]);
                if (!TextUtils.isEmpty(charSequenceE4)) {
                    charSequenceArr[i2] = charSequenceE4;
                    i2++;
                }
                i3 = i4;
            }
            CharSequence charSequence = charSequenceArr[0];
            CharSequence charSequence2 = charSequenceArr[1];
            charSequenceE = charSequenceArr[2];
            charSequenceE3 = charSequence;
            charSequenceE2 = charSequence2;
        }
        CharSequence charSequenceE5 = qh2Var.E("android.media.metadata.TITLE");
        if (charSequenceE5 == null) {
            charSequenceE5 = charSequenceE3;
        }
        bVar.s0(charSequenceE5).a0(charSequenceE3).q0(charSequenceE2).Y(charSequenceE).S(qh2Var.E("android.media.metadata.ARTIST")).R(qh2Var.E("android.media.metadata.ALBUM")).Q(qh2Var.E("android.media.metadata.ALBUM_ARTIST")).i0(Q(qh2Var.C("android.media.metadata.RATING")));
        if (qh2Var.c("android.media.metadata.DURATION")) {
            long jX = qh2Var.x("android.media.metadata.DURATION");
            if (jX >= 0) {
                bVar.b0(Long.valueOf(jX));
            }
        }
        yn3 yn3VarQ = Q(qh2Var.C("android.media.metadata.USER_RATING"));
        if (yn3VarQ != null) {
            bVar.w0(yn3VarQ);
        } else {
            bVar.w0(Q(zn3.D(i)));
        }
        if (qh2Var.c("android.media.metadata.YEAR")) {
            bVar.l0(Integer.valueOf((int) qh2Var.x("android.media.metadata.YEAR")));
        }
        Uri uriB = qh2Var.B();
        if (uriB != null) {
            bVar.U(uriB);
        }
        byte[] bArrA = qh2Var.A();
        if (bArrA != null) {
            bVar.T(bArrA, 3);
        }
        boolean zC = qh2Var.c("android.media.metadata.BT_FOLDER_TYPE");
        bVar.f0(Boolean.valueOf(zC));
        if (zC) {
            bVar.d0(Integer.valueOf(j(qh2Var.x("android.media.metadata.BT_FOLDER_TYPE"))));
        }
        if (qh2Var.c("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")) {
            bVar.h0(Integer.valueOf((int) qh2Var.x("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")));
        }
        bVar.g0(Boolean.TRUE);
        Bundle bundleU = qh2Var.u();
        pw4 it = a.iterator();
        while (it.hasNext()) {
            bundleU.remove((String) it.next());
        }
        if (!bundleU.isEmpty()) {
            bVar.c0(bundleU);
        }
        return bVar.L();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ph2 C(CharSequence charSequence) {
        return charSequence == null ? ph2.M : new ph2.b().s0(charSequence).L();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static qh2 D(ph2 ph2Var, String str, Uri uri, long j, Bitmap bitmap) {
        Long l;
        qh2.b bVarE = new qh2.b().e("android.media.metadata.MEDIA_ID", str);
        CharSequence charSequence = ph2Var.a;
        if (charSequence != null) {
            bVarE.f("android.media.metadata.TITLE", charSequence);
        }
        CharSequence charSequence2 = ph2Var.e;
        if (charSequence2 != null) {
            bVarE.f("android.media.metadata.DISPLAY_TITLE", charSequence2);
        }
        CharSequence charSequence3 = ph2Var.f;
        if (charSequence3 != null) {
            bVarE.f("android.media.metadata.DISPLAY_SUBTITLE", charSequence3);
        }
        CharSequence charSequence4 = ph2Var.g;
        if (charSequence4 != null) {
            bVarE.f("android.media.metadata.DISPLAY_DESCRIPTION", charSequence4);
        }
        CharSequence charSequence5 = ph2Var.b;
        if (charSequence5 != null) {
            bVarE.f("android.media.metadata.ARTIST", charSequence5);
        }
        CharSequence charSequence6 = ph2Var.c;
        if (charSequence6 != null) {
            bVarE.f("android.media.metadata.ALBUM", charSequence6);
        }
        CharSequence charSequence7 = ph2Var.d;
        if (charSequence7 != null) {
            bVarE.f("android.media.metadata.ALBUM_ARTIST", charSequence7);
        }
        if (ph2Var.u != null) {
            bVarE.c("android.media.metadata.YEAR", r0.intValue());
        }
        CharSequence charSequence8 = ph2Var.B;
        if (charSequence8 != null) {
            bVarE.f("android.media.metadata.AUTHOR", charSequence8);
        }
        CharSequence charSequence9 = ph2Var.A;
        if (charSequence9 != null) {
            bVarE.f("android.media.metadata.WRITER", charSequence9);
        }
        CharSequence charSequence10 = ph2Var.C;
        if (charSequence10 != null) {
            bVarE.f("android.media.metadata.COMPOSER", charSequence10);
        }
        if (uri != null) {
            bVarE.e("android.media.metadata.MEDIA_URI", uri.toString());
        }
        Uri uri2 = ph2Var.n;
        if (uri2 != null) {
            bVarE.e("android.media.metadata.DISPLAY_ICON_URI", uri2.toString());
            bVarE.e("android.media.metadata.ALBUM_ART_URI", ph2Var.n.toString());
            bVarE.e("android.media.metadata.ART_URI", ph2Var.n.toString());
        }
        if (bitmap != null) {
            bVarE.b("android.media.metadata.DISPLAY_ICON", bitmap);
            bVarE.b("android.media.metadata.ALBUM_ART", bitmap);
        }
        Integer num = ph2Var.q;
        if (num != null && num.intValue() != -1) {
            bVarE.c("android.media.metadata.BT_FOLDER_TYPE", i(ph2Var.q.intValue()));
        }
        if (j == -9223372036854775807L && (l = ph2Var.h) != null) {
            j = l.longValue();
        }
        if (j == -9223372036854775807L) {
            j = -1;
        }
        bVarE.c("android.media.metadata.DURATION", j);
        zn3 zn3VarR = R(ph2Var.i);
        if (zn3VarR != null) {
            bVarE.d("android.media.metadata.USER_RATING", zn3VarR);
        }
        zn3 zn3VarR2 = R(ph2Var.j);
        if (zn3VarR2 != null) {
            bVarE.d("android.media.metadata.RATING", zn3VarR2);
        }
        if (ph2Var.J != null) {
            bVarE.c("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT", r5.intValue());
        }
        Bundle bundle = ph2Var.K;
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object obj = ph2Var.K.get(str2);
                if (obj == null || (obj instanceof CharSequence)) {
                    bVarE.f(str2, (CharSequence) obj);
                } else if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
                    bVarE.c(str2, ((Number) obj).longValue());
                }
            }
        }
        return bVarE.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static no4.b E(int i) {
        no4.b bVar = new no4.b();
        bVar.v(null, null, i, -9223372036854775807L, 0L, x3.g, true);
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean F(cd3 cd3Var) {
        if (cd3Var == null) {
            return false;
        }
        switch (cd3Var.E()) {
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ac3 G(cd3 cd3Var, Context context) {
        if (cd3Var == null || cd3Var.E() != 7) {
            return null;
        }
        CharSequence charSequenceY = cd3Var.y();
        if (charSequenceY == null) {
            charSequenceY = f0(X(cd3Var.x()), context);
        }
        Bundle bundleZ = cd3Var.z();
        String string = charSequenceY != null ? charSequenceY.toString() : null;
        int iH = H(cd3Var.x());
        if (bundleZ == null) {
            bundleZ = Bundle.EMPTY;
        }
        return new ac3(string, null, iH, bundleZ);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int H(int i) {
        int iX = X(i);
        if (iX == -5) {
            return 2000;
        }
        if (iX != -1) {
            return iX;
        }
        return 1000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static dc3 I(cd3 cd3Var) {
        return cd3Var == null ? dc3.d : new dc3(cd3Var.B());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int J(cd3 cd3Var, qh2 qh2Var, long j) {
        if (cd3Var == null) {
            return 1;
        }
        boolean zL = l(cd3Var, qh2Var, j);
        switch (cd3Var.E()) {
            case 1:
                if (zL) {
                    return 4;
                }
            case 0:
            case 7:
            case 8:
                return 1;
            case 2:
                return zL ? 4 : 3;
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
            case 11:
                return 2;
            default:
                throw new b("Invalid state of PlaybackStateCompat: " + cd3Var.E());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int K(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                xz1.i("LegacyConversions", "Unrecognized RepeatMode: " + i + " was converted to `PlaybackStateCompat.REPEAT_MODE_NONE`");
                return 0;
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int L(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int M(hd3 hd3Var, boolean z) {
        if (hd3Var.getPlayerError() != null) {
            return 7;
        }
        int playbackState = hd3Var.getPlaybackState();
        if (playbackState == 1) {
            return 0;
        }
        if (playbackState == 2) {
            return z ? 2 : 6;
        }
        if (playbackState == 3) {
            return z ? 2 : 3;
        }
        if (playbackState == 4) {
            return 1;
        }
        defpackage.b.a("Unrecognized State: ", playbackState);
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static hd3.b N(cd3 cd3Var, int i, long j, boolean z) {
        hd3.b.a aVar = new hd3.b.a();
        long jD = cd3Var == null ? 0L : cd3Var.d();
        boolean zF = F(cd3Var);
        if ((h0(jD, 4L) && !zF) || ((h0(jD, 2L) && zF) || h0(jD, 512L))) {
            aVar.a(1);
        }
        if (h0(jD, Http2Stream.EMIT_BUFFER_SIZE)) {
            aVar.a(2);
        }
        if ((h0(jD, 32768L) && h0(jD, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE)) || ((h0(jD, 65536L) && h0(jD, 2048L)) || (h0(jD, 131072L) && h0(jD, 8192L)))) {
            aVar.c(31, 2);
        }
        if (h0(jD, 8L)) {
            aVar.a(11);
        }
        if (h0(jD, 64L)) {
            aVar.a(12);
        }
        if (h0(jD, 256L)) {
            aVar.c(5, 4);
        }
        if (h0(jD, 32L)) {
            aVar.c(9, 8);
        }
        if (h0(jD, 16L)) {
            aVar.c(7, 6);
        }
        if (h0(jD, 4194304L)) {
            aVar.a(13);
        }
        if (h0(jD, 1L)) {
            aVar.a(3);
        }
        if (i == 1) {
            aVar.c(26, 34);
        } else if (i == 2) {
            aVar.c(26, 34, 25, 33);
        }
        aVar.c(23, 17, 18, 16, 21, 32);
        if ((j & 4) != 0) {
            aVar.a(20);
            if (h0(jD, 4096L)) {
                aVar.a(10);
            }
        }
        if (z) {
            if (h0(jD, 262144L)) {
                aVar.a(15);
            }
            if (h0(jD, 2097152L)) {
                aVar.a(14);
            }
        }
        return aVar.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static pi2.g O(fg2 fg2Var, int i, Bitmap bitmap) {
        return new pi2.g(s(fg2Var, bitmap), P(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long P(int i) {
        if (i == -1) {
            return -1L;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static yn3 Q(zn3 zn3Var) {
        if (zn3Var == null) {
            return null;
        }
        switch (zn3Var.u()) {
            case 1:
                if (!zn3Var.x()) {
                }
                break;
            case 2:
                if (!zn3Var.x()) {
                }
                break;
            case 3:
                if (!zn3Var.x()) {
                }
                break;
            case 4:
                if (!zn3Var.x()) {
                }
                break;
            case 5:
                if (!zn3Var.x()) {
                }
                break;
            case 6:
                if (!zn3Var.x()) {
                }
                break;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zn3 R(yn3 yn3Var) {
        if (yn3Var == null) {
            return null;
        }
        int iE0 = e0(yn3Var);
        if (!yn3Var.b()) {
            return zn3.D(iE0);
        }
        switch (iE0) {
            case 1:
                return zn3.z(((dd1) yn3Var).e());
            case 2:
                return zn3.C(((vn4) yn3Var).e());
            case 3:
            case 4:
            case 5:
                return zn3.B(iE0, ((td4) yn3Var).f());
            case 6:
                return zn3.A(((la3) yn3Var).e());
            default:
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int S(int i) {
        if (i == -1 || i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 3) {
                xz1.i("LegacyConversions", "Unrecognized PlaybackStateCompat.RepeatMode: " + i + " was converted to `Player.REPEAT_MODE_OFF`");
                return 0;
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Bundle T(MediaLibraryService.b bVar) {
        if (bVar == null) {
            return null;
        }
        Bundle bundle = new Bundle(bVar.a);
        if (bVar.a.containsKey("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY")) {
            boolean z = bVar.a.getBoolean("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY", false);
            bundle.remove("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY");
            bundle.putInt("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS", z ? 1 : 3);
        }
        bundle.putBoolean("android.service.media.extra.RECENT", bVar.b);
        bundle.putBoolean("android.service.media.extra.OFFLINE", bVar.c);
        bundle.putBoolean("android.service.media.extra.SUGGESTED", bVar.d);
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static d0 U(cd3 cd3Var, boolean z) {
        d0.b bVar = new d0.b();
        bVar.c();
        if (!z) {
            bVar.f(40010);
        }
        if (cd3Var != null) {
            for (cd3.c cVar : cd3Var.w()) {
                String strD = cVar.d();
                Bundle bundleU = cVar.u();
                if (bundleU == null) {
                    bundleU = Bundle.EMPTY;
                }
                bVar.a(new y14(strD, bundleU));
            }
        }
        return bVar.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b24 V(int i, int i2, CharSequence charSequence, Bundle bundle, Context context) {
        if (i == 7 || i2 == 0) {
            return null;
        }
        int iX = X(i2);
        String string = charSequence != null ? charSequence.toString() : f0(iX, context);
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        return new b24(iX, string, bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b24 W(cd3 cd3Var, Context context) {
        if (cd3Var == null) {
            return null;
        }
        return V(cd3Var.E(), cd3Var.x(), cd3Var.y(), cd3Var.z(), context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int X(int i) {
        switch (i) {
            case 1:
                return -2;
            case 2:
                return -6;
            case 3:
                return -102;
            case 4:
                return -103;
            case 5:
                return -104;
            case 6:
                return -105;
            case 7:
                return -106;
            case 8:
                return -110;
            case 9:
                return -107;
            case 10:
                return 1;
            case 11:
                return -109;
            default:
                return -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean Y(int i) {
        if (i == -1 || i == 0) {
            return false;
        }
        if (i == 1 || i == 2) {
            return true;
        }
        defpackage.b.a("Unrecognized ShuffleMode: ", i);
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long Z(cd3 cd3Var, qh2 qh2Var, long j) {
        return c(cd3Var, qh2Var, j) - e(cd3Var, qh2Var, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static z62.g a(fg2 fg2Var, Bitmap bitmap) {
        zf2 zf2VarS = s(fg2Var, bitmap);
        ph2 ph2Var = fg2Var.e;
        Boolean bool = ph2Var.r;
        int i = (bool == null || !bool.booleanValue()) ? 0 : 1;
        Boolean bool2 = ph2Var.s;
        if (bool2 != null && bool2.booleanValue()) {
            i |= 2;
        }
        return new z62.g(zf2VarS, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static no4.d a0(fg2 fg2Var, int i) {
        no4.d dVar = new no4.d();
        dVar.h(0, fg2Var, null, 0L, 0L, 0L, true, false, null, 0L, -9223372036854775807L, i, i, 0L);
        return dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(cd3 cd3Var, qh2 qh2Var, long j) {
        return a0.c(c(cd3Var, qh2Var, j), h(qh2Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b0(Bundle bundle) {
        return Math.max(0, bundle.getInt("androidx.media.utils.MediaBrowserCompat.extras.CUSTOM_BROWSER_ACTION_LIMIT", 0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long c(cd3 cd3Var, qh2 qh2Var, long j) {
        long jU = cd3Var == null ? 0L : cd3Var.u();
        long jE = e(cd3Var, qh2Var, j);
        long jH = h(qh2Var);
        return jH == -9223372036854775807L ? Math.max(jE, jU) : fy4.t(jU, jE, jH);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long c0(cd3 cd3Var, long j) {
        return cd3Var.v(j == -9223372036854775807L ? null : Long.valueOf(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Bundle d(androidx.media3.session.a aVar) {
        Bundle bundle = new Bundle();
        y14 y14Var = aVar.a;
        if (y14Var != null) {
            bundle.putString("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_ID", y14Var.b);
        }
        bundle.putString("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_LABEL", aVar.f.toString());
        Uri uri = aVar.e;
        if (uri != null) {
            bundle.putString("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_ICON_URI", uri.toString());
        }
        if (!aVar.g.isEmpty()) {
            bundle.putBundle("androidx.media.utils.extras.KEY_CUSTOM_BROWSER_ACTION_EXTRAS", aVar.g);
        }
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object d0(Future future, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j2 = j;
        while (true) {
            try {
                try {
                    return future.get(j2, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    z = true;
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    if (jElapsedRealtime2 >= j) {
                        throw new TimeoutException();
                    }
                    j2 = j - jElapsedRealtime2;
                }
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long e(cd3 cd3Var, qh2 qh2Var, long j) {
        if (cd3Var == null) {
            return 0L;
        }
        long jC0 = cd3Var.E() == 3 ? c0(cd3Var, j) : cd3Var.D();
        long jH = h(qh2Var);
        return jH == -9223372036854775807L ? Math.max(0L, jC0) : fy4.t(jC0, 0L, jH);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e0(yn3 yn3Var) {
        if (yn3Var instanceof dd1) {
            return 1;
        }
        if (yn3Var instanceof vn4) {
            return 2;
        }
        if (!(yn3Var instanceof td4)) {
            return yn3Var instanceof la3 ? 6 : 0;
        }
        int iE = ((td4) yn3Var).e();
        int i = 3;
        if (iE != 3) {
            i = 4;
            if (iE != 4) {
                i = 5;
                if (iE != 5) {
                    return 0;
                }
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static kk0 f(v82.e eVar) {
        if (eVar == null) {
            return kk0.e;
        }
        return new kk0.b(eVar.d() == 2 ? 1 : 0).f(eVar.c()).h(eVar.f()).e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String f0(int i, Context context) {
        if (i == -100) {
            return context.getString(nm3.f);
        }
        if (i == 1) {
            return context.getString(nm3.i);
        }
        if (i == -6) {
            return context.getString(nm3.m);
        }
        if (i == -5) {
            return context.getString(nm3.k);
        }
        if (i == -4) {
            return context.getString(nm3.o);
        }
        if (i == -3) {
            return context.getString(nm3.c);
        }
        if (i == -2) {
            return context.getString(nm3.j);
        }
        switch (i) {
            case -110:
                return context.getString(nm3.e);
            case -109:
                return context.getString(nm3.g);
            case -108:
                return context.getString(nm3.q);
            case -107:
                return context.getString(nm3.r);
            case -106:
                return context.getString(nm3.l);
            case -105:
                return context.getString(nm3.n);
            case -104:
                return context.getString(nm3.d);
            case -103:
                return context.getString(nm3.p);
            case -102:
                return context.getString(nm3.b);
            default:
                return context.getString(nm3.h);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(v82.e eVar) {
        if (eVar == null) {
            return 0;
        }
        return eVar.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static CharSequence g0(String str, ph2 ph2Var) {
        str.getClass();
        switch (str) {
            case "android.media.metadata.ARTIST":
                return ph2Var.b;
            case "android.media.metadata.AUTHOR":
                return ph2Var.B;
            case "android.media.metadata.WRITER":
                return ph2Var.A;
            case "android.media.metadata.DISPLAY_SUBTITLE":
                return ph2Var.f;
            case "android.media.metadata.DISPLAY_DESCRIPTION":
                return ph2Var.g;
            case "android.media.metadata.COMPOSER":
                return ph2Var.C;
            case "android.media.metadata.ALBUM":
                return ph2Var.c;
            case "android.media.metadata.TITLE":
                return ph2Var.a;
            case "android.media.metadata.ALBUM_ARTIST":
                return ph2Var.d;
            default:
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long h(qh2 qh2Var) {
        if (qh2Var == null || !qh2Var.c("android.media.metadata.DURATION")) {
            return -9223372036854775807L;
        }
        long jX = qh2Var.x("android.media.metadata.DURATION");
        if (jX <= 0) {
            return -9223372036854775807L;
        }
        return jX;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean h0(long j, long j2) {
        return (j & j2) != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long i(int i) {
        switch (i) {
            case 0:
                return 0L;
            case 1:
                return 1L;
            case 2:
                return 2L;
            case 3:
                return 3L;
            case 4:
                return 4L;
            case 5:
                return 5L;
            case 6:
                return 6L;
            default:
                defpackage.b.a("Unrecognized FolderType: ", i);
                return 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int j(long j) {
        if (j == 0) {
            return 0;
        }
        if (j == 1) {
            return 1;
        }
        if (j == 2) {
            return 2;
        }
        if (j == 3) {
            return 3;
        }
        if (j == 4) {
            return 4;
        }
        if (j == 5) {
            return 5;
        }
        return j == 6 ? 6 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean k(v82.e eVar) {
        return eVar != null && eVar.b() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean l(cd3 cd3Var, qh2 qh2Var, long j) {
        long jH = h(qh2Var);
        return jH != -9223372036854775807L && e(cd3Var, qh2Var, j) >= jH;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean m(cd3 cd3Var) {
        return cd3Var != null && cd3Var.E() == 3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean n(qh2 qh2Var) {
        return (qh2Var == null || qh2Var.x("android.media.metadata.ADVERTISEMENT") == 0) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int o(int i) {
        if (i == -110) {
            return 8;
        }
        if (i == -109) {
            return 11;
        }
        if (i == -6) {
            return 2;
        }
        if (i == -2) {
            return 1;
        }
        if (i == 1) {
            return 10;
        }
        switch (i) {
            case -107:
                return 9;
            case -106:
                return 7;
            case -105:
                return 6;
            case -104:
                return 5;
            case -103:
                return 4;
            case -102:
                return 3;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int p(ac3 ac3Var) {
        return o(ac3Var.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static MediaLibraryService.b q(Context context, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            bundle.setClassLoader(context.getClassLoader());
            int i = bundle.getInt("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS", -1);
            if (i >= 0) {
                bundle.remove("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS");
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                bundle.putBoolean("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY", z);
            }
            return new MediaLibraryService.b.a().b(bundle).d(bundle.getBoolean("android.service.media.extra.RECENT")).c(bundle.getBoolean("android.service.media.extra.OFFLINE")).e(bundle.getBoolean("android.service.media.extra.SUGGESTED")).a();
        } catch (Exception unused) {
            return new MediaLibraryService.b.a().b(bundle).a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 r(cd3 cd3Var, hd3.b bVar, Bundle bundle) {
        if (cd3Var == null) {
            return xi1.u();
        }
        List<cd3.c> listW = cd3Var.w();
        xi1.a aVar = new xi1.a();
        for (cd3.c cVar : listW) {
            String strD = cVar.d();
            Bundle bundleU = cVar.u();
            a.b bVarC = new a.b(bundleU != null ? bundleU.getInt("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_COMPAT", 0) : 0, cVar.v()).h(new y14(strD, bundleU == null ? Bundle.EMPTY : bundleU)).b(cVar.w()).c(true);
            if (bundleU != null) {
                bVarC.d(bundleU);
            }
            String string = bundleU != null ? bundleU.getString("androidx.media3.session.EXTRAS_KEY_COMMAND_BUTTON_ICON_URI_COMPAT") : null;
            if (string != null) {
                Uri uri = Uri.parse(string);
                String scheme = uri.getScheme();
                if (Objects.equals(scheme, "content") || Objects.equals(scheme, "android.resource")) {
                    bVarC.e(uri);
                }
            }
            aVar.a(bVarC.a());
        }
        return androidx.media3.session.a.p(aVar.k(), bVar, bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zf2 s(fg2 fg2Var, Bitmap bitmap) {
        CharSequence charSequence;
        CharSequence charSequence2;
        zf2.b bVarF = new zf2.b().f(fg2Var.a.equals("") ? null : fg2Var.a);
        ph2 ph2Var = fg2Var.e;
        if (bitmap != null) {
            bVarF.d(bitmap);
        }
        Bundle bundle = ph2Var.K;
        if (bundle != null) {
            bundle = new Bundle(bundle);
        }
        Integer num = ph2Var.q;
        boolean z = (num == null || num.intValue() == -1) ? false : true;
        boolean z2 = ph2Var.J != null;
        if (z || z2) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (z) {
                bundle.putLong("android.media.extra.BT_FOLDER_TYPE", i(((Integer) gg3.q(ph2Var.q)).intValue()));
            }
            if (z2) {
                bundle.putLong("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT", ((Integer) gg3.q(ph2Var.J)).intValue());
            }
        }
        if (!ph2Var.L.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putStringArrayList("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ID_LIST", new ArrayList<>(ph2Var.L));
        }
        CharSequence charSequence3 = ph2Var.e;
        if (charSequence3 != null) {
            charSequence = ph2Var.f;
            charSequence2 = ph2Var.g;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putCharSequence("androidx.media3.mediadescriptioncompat.title", ph2Var.a);
        } else {
            CharSequence[] charSequenceArr = new CharSequence[3];
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                String[] strArr = qh2.j;
                if (i2 >= strArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                CharSequence charSequenceG0 = g0(strArr[i2], ph2Var);
                if (!TextUtils.isEmpty(charSequenceG0)) {
                    charSequenceArr[i] = charSequenceG0;
                    i++;
                }
                i2 = i3;
            }
            charSequence3 = charSequenceArr[0];
            charSequence = charSequenceArr[1];
            charSequence2 = charSequenceArr[2];
        }
        return bVarF.i(charSequence3).h(charSequence).b(charSequence2).e(ph2Var.n).g(fg2Var.h.a).c(bundle).a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 t(zf2 zf2Var) {
        gg3.q(zf2Var);
        return u(zf2Var, false, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 u(zf2 zf2Var, boolean z, boolean z2) {
        String strY = zf2Var.y();
        fg2.c cVar = new fg2.c();
        if (strY == null) {
            strY = "";
        }
        return cVar.e(strY).h(new fg2.i.a().f(zf2Var.z()).d()).f(A(zf2Var, 0, z, z2)).a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 v(qh2 qh2Var, int i) {
        return x(qh2Var.D("android.media.metadata.MEDIA_ID"), qh2Var, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 w(pi2.g gVar) {
        return t(gVar.s());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 x(String str, qh2 qh2Var, int i) {
        fg2.c cVar = new fg2.c();
        if (str != null) {
            cVar.e(str);
        }
        String strD = qh2Var.D("android.media.metadata.MEDIA_URI");
        if (strD != null) {
            cVar.h(new fg2.i.a().f(Uri.parse(strD)).d());
        }
        cVar.f(B(qh2Var, i));
        return cVar.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List y(no4 no4Var) {
        ArrayList arrayList = new ArrayList();
        no4.d dVar = new no4.d();
        for (int i = 0; i < no4Var.v(); i++) {
            arrayList.add(no4Var.t(i, dVar).c);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ph2 z(zf2 zf2Var, int i) {
        return A(zf2Var, i, false, true);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends Exception {
        public b(String str) {
            super(str);
        }
    }
}
