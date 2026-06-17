package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.media3.exoplayer.rtsp.e;
import defpackage.bx;
import defpackage.dx2;
import defpackage.k;
import defpackage.t41;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class rv3 {
    public final fv3 a;
    public final Uri b;

    public rv3(e eVar, yf2 yf2Var, Uri uri) {
        gg3.e(yf2Var.i.containsKey("control"), "missing attribute control");
        this.a = b(yf2Var);
        this.b = a(eVar, uri, (String) fy4.l((String) yf2Var.i.get("control")));
    }

    public static Uri a(e eVar, Uri uri, String str) {
        Uri uri2 = Uri.parse(str);
        if (uri2.isAbsolute()) {
            return uri2;
        }
        if (!TextUtils.isEmpty(eVar.d("Content-Base"))) {
            uri = Uri.parse(eVar.d("Content-Base"));
        } else if (!TextUtils.isEmpty(eVar.d("Content-Location"))) {
            uri = Uri.parse(eVar.d("Content-Location"));
        }
        return str.equals("*") ? uri : uri.buildUpon().appendEncodedPath(str).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.fv3 b(defpackage.yf2 r13) {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rv3.b(yf2):fv3");
    }

    public static byte[] c(String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        int length = bArrDecode.length;
        byte[] bArr = dx2.a;
        byte[] bArr2 = new byte[length + bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(bArrDecode, 0, bArr2, bArr.length, bArrDecode.length);
        return bArr2;
    }

    public static int d(int i, String str) {
        return i != -1 ? i : str.equals("audio/ac3") ? 6 : 1;
    }

    public static k.b e(String str) {
        q73 q73Var = new q73(fy4.X(str));
        gg3.e(q73Var.h(1) == 0, "Only supports audio mux version 0.");
        gg3.e(q73Var.h(1) == 1, "Only supports allStreamsSameTimeFraming.");
        q73Var.r(6);
        gg3.e(q73Var.h(4) == 0, "Only supports one program.");
        gg3.e(q73Var.h(3) == 0, "Only supports one numLayer.");
        try {
            return k.e(q73Var, false);
        } catch (r83 e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void f(t41.b bVar, zi1 zi1Var, String str, int i, int i2) {
        String str2 = (String) zi1Var.get("profile-level-id");
        if (str2 == null && str.equals("MP4A-LATM")) {
            str2 = "30";
        }
        gg3.e((str2 == null || str2.isEmpty()) ? false : true, "missing profile-level-id param");
        bVar.V("mp4a.40." + str2);
        bVar.l0(xi1.w(k.a(i2, i)));
    }

    public static void g(t41.b bVar, zi1 zi1Var) {
        gg3.e(zi1Var.containsKey("sprop-parameter-sets"), "missing sprop parameter");
        String[] strArrG1 = fy4.G1((String) gg3.q((String) zi1Var.get("sprop-parameter-sets")), ",");
        gg3.e(strArrG1.length == 2, "empty sprop value");
        xi1 xi1VarX = xi1.x(c(strArrG1[0]), c(strArrG1[1]));
        bVar.l0(xi1VarX);
        byte[] bArr = (byte[]) xi1VarX.get(0);
        dx2.m mVarD = dx2.D(bArr, dx2.a.length, bArr.length);
        bVar.v0(mVarD.h);
        bVar.i0(mVarD.g);
        bVar.H0(mVarD.f);
        bVar.W(new bx.b().d(mVarD.q).c(mVarD.r).e(mVarD.s).g(mVarD.i + 8).b(mVarD.j + 8).a());
        String str = (String) zi1Var.get("profile-level-id");
        if (str != null) {
            bVar.V("avc1.".concat(str));
        } else {
            bVar.V(gv.g(mVarD.a, mVarD.b, mVarD.c));
        }
    }

    public static void h(t41.b bVar, zi1 zi1Var) {
        if (zi1Var.containsKey("sprop-max-don-diff")) {
            int i = Integer.parseInt((String) gg3.q((String) zi1Var.get("sprop-max-don-diff")));
            gg3.g(i == 0, "non-zero sprop-max-don-diff %s is not supported", i);
        }
        gg3.e(zi1Var.containsKey("sprop-vps"), "missing sprop-vps parameter");
        String str = (String) gg3.q((String) zi1Var.get("sprop-vps"));
        gg3.e(zi1Var.containsKey("sprop-sps"), "missing sprop-sps parameter");
        String str2 = (String) gg3.q((String) zi1Var.get("sprop-sps"));
        gg3.e(zi1Var.containsKey("sprop-pps"), "missing sprop-pps parameter");
        xi1 xi1VarY = xi1.y(c(str), c(str2), c((String) gg3.q((String) zi1Var.get("sprop-pps"))));
        bVar.l0(xi1VarY);
        byte[] bArr = (byte[]) xi1VarY.get(1);
        dx2.h hVarV = dx2.v(bArr, dx2.a.length, bArr.length, null);
        bVar.v0(hVarV.l);
        bVar.i0(hVarV.i).H0(hVarV.h);
        bVar.W(new bx.b().d(hVarV.n).c(hVarV.o).e(hVarV.p).g(hVarV.e + 8).b(hVarV.f + 8).a());
        dx2.c cVar = hVarV.c;
        if (cVar != null) {
            bVar.V(gv.i(cVar.a, cVar.b, cVar.c, cVar.d, cVar.e, cVar.f));
        }
    }

    public static void i(t41.b bVar, zi1 zi1Var) {
        String str = (String) zi1Var.get("config");
        if (str != null) {
            byte[] bArrX = fy4.X(str);
            bVar.l0(xi1.w(bArrX));
            Pair pairZ = gv.z(bArrX);
            bVar.H0(((Integer) pairZ.first).intValue()).i0(((Integer) pairZ.second).intValue());
        } else {
            bVar.H0(352).i0(288);
        }
        String str2 = (String) zi1Var.get("profile-level-id");
        if (str2 == null) {
            str2 = "1";
        }
        bVar.V("mp4v.".concat(str2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && rv3.class == obj.getClass()) {
            rv3 rv3Var = (rv3) obj;
            if (this.a.equals(rv3Var.a) && this.b.equals(rv3Var.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((217 + this.a.hashCode()) * 31) + this.b.hashCode();
    }
}
