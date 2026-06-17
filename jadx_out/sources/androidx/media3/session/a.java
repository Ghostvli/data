package androidx.media3.session;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.dl3;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.lr4;
import defpackage.ph2;
import defpackage.wi1;
import defpackage.xi1;
import defpackage.y14;
import defpackage.yn3;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final String k = fy4.N0(0);
    public static final String l = fy4.N0(1);
    public static final String m = fy4.N0(2);
    public static final String n = fy4.N0(3);
    public static final String o = fy4.N0(4);
    public static final String p = fy4.N0(5);
    public static final String q = fy4.N0(6);
    public static final String r = fy4.N0(7);
    public static final String s = fy4.N0(8);
    public static final String t = fy4.N0(9);
    public final y14 a;
    public final int b;
    public final int c;
    public final int d;
    public final Uri e;
    public final CharSequence f;
    public final Bundle g;
    public final wi1 h;
    public final boolean i;
    public final Object j;

    public a(y14 y14Var, int i, int i2, int i3, Uri uri, CharSequence charSequence, Bundle bundle, boolean z, wi1 wi1Var, Object obj) {
        this.a = y14Var;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = uri;
        this.f = charSequence;
        this.g = new Bundle(bundle);
        this.i = z;
        this.h = wi1Var;
        this.j = obj;
    }

    public static Object A(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        switch (i) {
            case 1:
                if (obj instanceof Integer) {
                    obj = Long.valueOf(((Integer) obj).longValue());
                }
                gg3.e(obj instanceof Long, "Parameter has incorrect type.");
                break;
            case 2:
                gg3.e(obj instanceof Integer, "Parameter has incorrect type.");
                break;
            case 3:
                gg3.e(obj instanceof Boolean, "Parameter has incorrect type.");
                break;
            case 4:
                if (obj instanceof Double) {
                    obj = Float.valueOf(((Double) obj).floatValue());
                }
                gg3.e(obj instanceof Float, "Parameter has incorrect type.");
                break;
            case 5:
                gg3.e(obj instanceof yn3, "Parameter has incorrect type.");
                break;
            case 6:
                gg3.e(obj instanceof fg2, "Parameter has incorrect type.");
                break;
            case 7:
                gg3.e(obj instanceof ph2, "Parameter has incorrect type.");
                break;
            case 8:
                gg3.e(obj instanceof lr4, "Parameter has incorrect type.");
                break;
        }
        return null;
    }

    public static boolean e(List list, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((a) list.get(i2)).h.c(0) == i) {
                return true;
            }
        }
        return false;
    }

    public static a f(y14 y14Var) {
        boolean zX = x(y14Var.b);
        String str = y14Var.b;
        if (zX) {
            int iT = t(str, "androidx.media3.session.PLAYER_COMMAND_");
            return new b(0).g(iT, q(y14Var.c, "androidx.media3.session.CUSTOM_COMMAND_PARAMETER", r(iT), 9)).a();
        }
        int iT2 = t(str, "androidx.media3.session.SESSION_COMMAND_");
        return new b(0).i(new y14(iT2), q(y14Var.c, "androidx.media3.session.CUSTOM_COMMAND_PARAMETER", s(iT2), 9)).a();
    }

    public static xi1 j(List list, d0 d0Var, hd3.b bVar) {
        xi1.a aVar = new xi1.a();
        for (int i = 0; i < list.size(); i++) {
            a aVar2 = (a) list.get(i);
            if (u(aVar2, d0Var, bVar)) {
                aVar.a(aVar2);
            } else {
                aVar.a(aVar2.h(false));
            }
        }
        return aVar.k();
    }

    public static a l(Bundle bundle, int i) {
        Bundle bundle2 = bundle.getBundle(k);
        y14 y14VarA = bundle2 == null ? null : y14.a(bundle2);
        int i2 = bundle.getInt(l, -1);
        int i3 = bundle.getInt(m, 0);
        CharSequence charSequence = bundle.getCharSequence(n, "");
        Bundle bundleY = fy4.y(bundle.getBundle(o));
        boolean z = i < 3 || bundle.getBoolean(p, true);
        Uri uri = (Uri) bundle.getParcelable(q);
        int i4 = bundle.getInt(r, 0);
        int[] intArray = bundle.getIntArray(s);
        b bVar = new b(i4, i3);
        if (y14VarA != null) {
            bVar.i(y14VarA, q(bundle, t, s(y14VarA.a), i));
        }
        if (i2 != -1) {
            bVar.g(i2, q(bundle, t, r(i2), i));
        }
        if (uri != null && (Objects.equals(uri.getScheme(), "content") || Objects.equals(uri.getScheme(), "android.resource"))) {
            bVar.e(uri);
        }
        b bVarB = bVar.b(charSequence);
        if (bundleY == null) {
            bundleY = Bundle.EMPTY;
        }
        b bVarC = bVarB.d(bundleY).c(z);
        if (intArray == null) {
            intArray = new int[]{6};
        }
        return bVarC.j(intArray).a();
    }

    public static xi1 m(List list, boolean z, boolean z2, int i) {
        int iC;
        if (list.isEmpty()) {
            return xi1.u();
        }
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < list.size(); i4++) {
            a aVar = (a) list.get(i4);
            if (aVar.i && aVar.d()) {
                int i5 = 0;
                while (true) {
                    if (i5 >= aVar.h.f() || (iC = aVar.h.c(i5)) == 6) {
                        break;
                    }
                    if (z && i2 == -1 && iC == 2) {
                        i2 = i4;
                        break;
                    }
                    if (z2 && i3 == -1 && iC == 3) {
                        i3 = i4;
                        break;
                    }
                    i5++;
                }
            }
        }
        xi1.a aVarM = xi1.m();
        if (i2 != -1) {
            aVarM.a(((a) list.get(i2)).g(2, i));
        }
        if (i3 != -1) {
            aVarM.a(((a) list.get(i3)).g(3, i));
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            a aVar2 = (a) list.get(i6);
            if (aVar2.i && aVar2.d() && i6 != i2 && i6 != i3 && aVar2.h.a(6)) {
                aVarM.a(aVar2.g(6, i));
            }
        }
        return aVarM.k();
    }

    public static int n(int i, int i2) {
        if (i == 1 || i2 == 57399 || i2 == 57396) {
            return 1;
        }
        if (i == 11 || i == 7 || i == 6 || i2 == 57413 || i2 == 57376 || i2 == 57410 || i2 == 57435 || i2 == 57433 || i2 == 1040473 || i2 == 57434) {
            return 2;
        }
        return (i == 12 || i == 9 || i == 8 || i2 == 57412 || i2 == 57375 || i2 == 63220 || i2 == 57432 || i2 == 57430 || i2 == 1040470 || i2 == 57431) ? 3 : 6;
    }

    public static int o(int i) {
        switch (i) {
            case 57369:
                return dl3.a;
            case 57370:
                return dl3.b;
            case 57372:
                return dl3.h;
            case 57375:
                return dl3.j;
            case 57376:
                return dl3.R;
            case 57396:
                return dl3.t;
            case 57399:
                return dl3.u;
            case 57403:
                return dl3.D;
            case 57408:
                return dl3.O;
            case 57409:
                return dl3.Q;
            case 57410:
                return dl3.Y;
            case 57411:
                return dl3.V;
            case 57412:
                return dl3.s;
            case 57413:
                return dl3.I;
            case 57415:
                return dl3.k0;
            case 57416:
                return dl3.l0;
            case 57421:
                return dl3.s0;
            case 57423:
                return dl3.t0;
            case 57424:
                return dl3.u0;
            case 57430:
                return dl3.e0;
            case 57431:
                return dl3.g0;
            case 57432:
                return dl3.h0;
            case 57433:
                return dl3.Z;
            case 57434:
                return dl3.b0;
            case 57435:
                return dl3.c0;
            case 57436:
                return dl3.K;
            case 57446:
                return dl3.L;
            case 57447:
                return dl3.M;
            case 57448:
                return dl3.v;
            case 57573:
                return dl3.k;
            case 57669:
                return dl3.F;
            case 57671:
                return dl3.H;
            case 57675:
                return dl3.c;
            case 57683:
                return dl3.m;
            case 57691:
                return dl3.p;
            case 58409:
                return dl3.J;
            case 58654:
                return dl3.N;
            case 58919:
                return dl3.n0;
            case 59405:
                return dl3.T;
            case 59448:
                return dl3.j0;
            case 59494:
                return dl3.e;
            case 59500:
                return dl3.g;
            case 59517:
                return dl3.o;
            case 59576:
                return dl3.S;
            case 59611:
                return dl3.p0;
            case 59612:
                return dl3.r0;
            case 60288:
                return dl3.E;
            case 61298:
                return dl3.m0;
            case 61389:
                return dl3.y;
            case 61512:
                return dl3.X;
            case 61916:
                return dl3.i;
            case 62688:
                return dl3.A;
            case 62689:
                return dl3.z;
            case 62690:
                return dl3.w;
            case 62699:
                return dl3.C;
            case 63220:
                return dl3.d0;
            case 1040448:
                return dl3.P;
            case 1040451:
                return dl3.W;
            case 1040452:
                return dl3.U;
            case 1040470:
                return dl3.f0;
            case 1040473:
                return dl3.a0;
            case 1040711:
                return dl3.G;
            case 1040712:
                return dl3.q;
            case 1040713:
                return dl3.r;
            case 1040723:
                return dl3.l;
            case 1042488:
                return dl3.i0;
            case 1042534:
                return dl3.d;
            case 1042540:
                return dl3.f;
            case 1042557:
                return dl3.n;
            case 1042651:
                return dl3.o0;
            case 1042652:
                return dl3.q0;
            case 1045728:
                return dl3.B;
            case 1045730:
                return dl3.x;
            default:
                return 0;
        }
    }

    public static xi1 p(List list, hd3.b bVar, Bundle bundle) {
        if (list.isEmpty()) {
            return xi1.u();
        }
        boolean zD = bVar.d(7, 6);
        boolean zD2 = bVar.d(9, 8);
        boolean z = bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false);
        boolean z2 = bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false);
        int i = (zD || z) ? -1 : 0;
        int i2 = (zD2 || z2) ? -1 : i == 0 ? 1 : 0;
        xi1.a aVarM = xi1.m();
        for (int i3 = 0; i3 < list.size(); i3++) {
            a aVar = (a) list.get(i3);
            if (i3 == i) {
                if (i2 == -1) {
                    aVarM.a(aVar.i(wi1.i(2, 6)));
                } else {
                    aVarM.a(aVar.i(wi1.j(2, 3, 6)));
                }
            } else if (i3 == i2) {
                aVarM.a(aVar.i(wi1.i(3, 6)));
            } else {
                aVarM.a(aVar.i(wi1.h(6)));
            }
        }
        return aVarM.k();
    }

    public static Object q(Bundle bundle, String str, int i, int i2) {
        if (!bundle.containsKey(str)) {
            return null;
        }
        switch (i) {
        }
        return null;
    }

    public static int r(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 5) {
            return 1;
        }
        if (i == 10) {
            return 2;
        }
        if (i == 19) {
            return 7;
        }
        if (i == 24) {
            return 4;
        }
        if (i == 29) {
            return 8;
        }
        if (i == 31) {
            return 6;
        }
        switch (i) {
            case 13:
                return 4;
            case 14:
                return 3;
            case 15:
                return 2;
            default:
                return 0;
        }
    }

    public static int s(int i) {
        return i == 40010 ? 5 : 0;
    }

    public static int t(String str, String str2) {
        return Integer.parseInt(str.substring(str2.length()));
    }

    public static boolean u(a aVar, d0 d0Var, hd3.b bVar) {
        y14 y14Var = aVar.a;
        if (y14Var != null && d0Var.b(y14Var)) {
            return true;
        }
        int i = aVar.b;
        return i != -1 && bVar.c(i);
    }

    public static boolean w(String str) {
        return x(str) || y(str);
    }

    public static boolean x(String str) {
        return str.startsWith("androidx.media3.session.PLAYER_COMMAND_");
    }

    public static boolean y(String str) {
        return str.startsWith("androidx.media3.session.SESSION_COMMAND_");
    }

    public final void B(Bundle bundle, String str, int i) {
        y14 y14Var = this.a;
        switch (y14Var != null ? s(y14Var.a) : r(this.b)) {
            case 1:
                bundle.putLong(str, ((Long) this.j).longValue());
                break;
            case 2:
                bundle.putInt(str, ((Integer) this.j).intValue());
                break;
            case 3:
                bundle.putBoolean(str, ((Boolean) this.j).booleanValue());
                break;
            case 4:
                bundle.putFloat(str, ((Float) this.j).floatValue());
                break;
            case 5:
                bundle.putBundle(str, ((yn3) this.j).c());
                break;
            case 6:
                bundle.putBundle(str, ((fg2) this.j).e(i));
                break;
            case 7:
                bundle.putBundle(str, ((ph2) this.j).f(i));
                break;
            case 8:
                bundle.putBundle(str, ((lr4) this.j).O());
                break;
        }
    }

    public boolean d() {
        y14 y14Var = this.a;
        if (y14Var != null) {
            int i = y14Var.a;
            if (i != 0) {
                return i == 40010 && this.j != null;
            }
            return true;
        }
        int i2 = this.b;
        if (i2 != 19) {
            if (i2 != 24) {
                if (i2 != 29 && i2 != 31) {
                    switch (i2) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 11:
                        case 12:
                        case 14:
                            break;
                        case 5:
                        case 10:
                        case 13:
                        case 15:
                            break;
                        default:
                            return false;
                    }
                }
            }
            return true;
        }
        return this.j != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Objects.equals(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && Objects.equals(this.e, aVar.e) && TextUtils.equals(this.f, aVar.f) && this.i == aVar.i && this.h.equals(aVar.h) && Objects.equals(this.j, aVar.j);
    }

    public final a g(int i, int i2) {
        String str;
        y14 y14Var = this.a;
        if (y14Var != null && y14Var.a == 0) {
            return i(wi1.h(i));
        }
        Bundle bundle = Bundle.EMPTY;
        if (this.j != null) {
            bundle = new Bundle();
            B(bundle, "androidx.media3.session.CUSTOM_COMMAND_PARAMETER", i2);
        }
        if (this.a != null) {
            str = "androidx.media3.session.SESSION_COMMAND_" + this.a.a;
        } else {
            str = "androidx.media3.session.PLAYER_COMMAND_" + this.b;
        }
        return new a(new y14(str, bundle), -1, this.c, this.d, this.e, this.f, this.g, this.i, wi1.h(i), null);
    }

    public a h(boolean z) {
        return this.i == z ? this : new a(this.a, this.b, this.c, this.d, this.e, this.f, new Bundle(this.g), z, this.h, this.j);
    }

    public int hashCode() {
        return Objects.hash(this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), this.f, Boolean.valueOf(this.i), this.e, this.h, this.j);
    }

    public a i(wi1 wi1Var) {
        return this.h.equals(wi1Var) ? this : new a(this.a, this.b, this.c, this.d, this.e, this.f, new Bundle(this.g), this.i, wi1Var, this.j);
    }

    public void k(hd3 hd3Var) {
        if (this.i) {
            int i = this.b;
            if (i == 19) {
                Object obj = this.j;
                if (obj != null) {
                    hd3Var.setPlaylistMetadata((ph2) obj);
                    return;
                }
                return;
            }
            if (i == 24) {
                Object obj2 = this.j;
                if (obj2 != null) {
                    hd3Var.setVolume(((Float) obj2).floatValue());
                    return;
                } else if (hd3Var.getVolume() == 0.0f) {
                    hd3Var.unmute();
                    return;
                } else {
                    hd3Var.mute();
                    return;
                }
            }
            if (i == 29) {
                Object obj3 = this.j;
                if (obj3 != null) {
                    hd3Var.setTrackSelectionParameters((lr4) obj3);
                    return;
                }
                return;
            }
            if (i == 31) {
                Object obj4 = this.j;
                if (obj4 != null) {
                    hd3Var.setMediaItem((fg2) obj4);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    Object obj5 = this.j;
                    if (obj5 == null) {
                        hd3Var.setPlayWhenReady(!hd3Var.getPlayWhenReady());
                    } else {
                        hd3Var.setPlayWhenReady(((Boolean) obj5).booleanValue());
                    }
                    break;
                case 2:
                    hd3Var.prepare();
                    break;
                case 3:
                    hd3Var.stop();
                    break;
                case 4:
                    hd3Var.seekToDefaultPosition();
                    break;
                case 5:
                    Object obj6 = this.j;
                    if (obj6 != null) {
                        hd3Var.seekTo(((Long) obj6).longValue());
                    }
                    break;
                case 6:
                    hd3Var.seekToPreviousMediaItem();
                    break;
                case 7:
                    hd3Var.seekToPrevious();
                    break;
                case 8:
                    hd3Var.seekToNextMediaItem();
                    break;
                case 9:
                    hd3Var.seekToNext();
                    break;
                case 10:
                    Object obj7 = this.j;
                    if (obj7 != null) {
                        hd3Var.seekToDefaultPosition(((Integer) obj7).intValue());
                    }
                    break;
                case 11:
                    hd3Var.seekBack();
                    break;
                case 12:
                    hd3Var.seekForward();
                    break;
                case 13:
                    Object obj8 = this.j;
                    if (obj8 != null) {
                        hd3Var.setPlaybackSpeed(((Float) obj8).floatValue());
                    }
                    break;
                case 14:
                    Object obj9 = this.j;
                    if (obj9 == null) {
                        hd3Var.setShuffleModeEnabled(!hd3Var.getShuffleModeEnabled());
                    } else {
                        hd3Var.setShuffleModeEnabled(((Boolean) obj9).booleanValue());
                    }
                    break;
                case 15:
                    Object obj10 = this.j;
                    if (obj10 != null) {
                        hd3Var.setRepeatMode(((Integer) obj10).intValue());
                    }
                    break;
            }
        }
    }

    public boolean v(hd3 hd3Var) {
        if (this.b != 1) {
            return false;
        }
        Object obj = this.j;
        return obj == null ? !hd3Var.getPlayWhenReady() : ((Boolean) obj).booleanValue();
    }

    public Bundle z(int i) {
        Bundle bundle = new Bundle();
        y14 y14Var = this.a;
        if (y14Var != null) {
            bundle.putBundle(k, y14Var.b());
        }
        int i2 = this.b;
        if (i2 != -1) {
            bundle.putInt(l, i2);
        }
        int i3 = this.c;
        if (i3 != 0) {
            bundle.putInt(r, i3);
        }
        int i4 = this.d;
        if (i4 != 0) {
            bundle.putInt(m, i4);
        }
        CharSequence charSequence = this.f;
        if (charSequence != "") {
            bundle.putCharSequence(n, charSequence);
        }
        if (!this.g.isEmpty()) {
            bundle.putBundle(o, this.g);
        }
        Uri uri = this.e;
        if (uri != null) {
            bundle.putParcelable(q, uri);
        }
        boolean z = this.i;
        if (!z) {
            bundle.putBoolean(p, z);
        }
        if (this.h.f() != 1 || this.h.c(0) != 6) {
            bundle.putIntArray(s, this.h.k());
        }
        if (this.j != null) {
            B(bundle, t, i);
        }
        return bundle;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public y14 b;
        public int c;
        public int d;
        public Uri e;
        public CharSequence f;
        public Bundle g;
        public boolean h;
        public wi1 i;
        public Object j;

        public b(int i, int i2) {
            this.a = i;
            this.d = i2;
            this.f = "";
            this.g = Bundle.EMPTY;
            this.c = -1;
            this.h = true;
        }

        public a a() {
            gg3.w((this.b == null) != (this.c == -1), "Exactly one of sessionCommand and playerCommand should be set");
            if (this.i == null) {
                this.i = wi1.h(a.n(this.c, this.a));
            }
            return new a(this.b, this.c, this.a, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public b b(CharSequence charSequence) {
            this.f = charSequence;
            return this;
        }

        public b c(boolean z) {
            this.h = z;
            return this;
        }

        public b d(Bundle bundle) {
            this.g = new Bundle(bundle);
            return this;
        }

        public b e(Uri uri) {
            gg3.e(Objects.equals(uri.getScheme(), "content") || Objects.equals(uri.getScheme(), "android.resource"), "Only content or resource Uris are supported for CommandButton");
            this.e = uri;
            return this;
        }

        public b f(int i) {
            gg3.e(this.b == null, "sessionCommand is already set. Only one of sessionCommand and playerCommand should be set.");
            this.c = i;
            this.j = null;
            return this;
        }

        public b g(int i, Object obj) {
            gg3.e(this.b == null, "sessionCommand is already set. Only one of sessionCommand and playerCommand should be set.");
            this.c = i;
            this.j = a.A(obj, a.r(i));
            return this;
        }

        public b h(y14 y14Var) {
            gg3.r(y14Var, "sessionCommand should not be null.");
            gg3.e(this.c == -1, "playerCommands is already set. Only one of sessionCommand and playerCommand should be set.");
            this.b = y14Var;
            this.j = null;
            return this;
        }

        public b i(y14 y14Var, Object obj) {
            gg3.r(y14Var, "sessionCommand should not be null.");
            gg3.e(this.c == -1, "playerCommands is already set. Only one of sessionCommand and playerCommand should be set.");
            this.b = y14Var;
            this.j = a.A(obj, a.s(y14Var.a));
            return this;
        }

        public b j(int... iArr) {
            gg3.d(iArr.length != 0);
            this.i = wi1.b(iArr);
            return this;
        }

        public b(int i) {
            this(i, a.o(i));
        }
    }
}
