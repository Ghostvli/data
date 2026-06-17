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
import defpackage.yf2;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class rv3 {
    public final fv3 a;
    public final Uri b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public rv3(e eVar, yf2 yf2Var, Uri uri) {
        gg3.e(yf2Var.i.containsKey("control"), "missing attribute control");
        this.a = b(yf2Var);
        this.b = a(eVar, uri, (String) fy4.l((String) yf2Var.i.get("control")));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static fv3 b(yf2 yf2Var) {
        int iD;
        String str;
        t41.b bVar = new t41.b();
        int i = yf2Var.e;
        if (i > 0) {
            bVar.T(i);
        }
        yf2.c cVar = yf2Var.j;
        int i2 = cVar.a;
        String str2 = cVar.b;
        String strA = fv3.a(str2);
        bVar.A0(strA);
        int i3 = yf2Var.j.c;
        if ("audio".equals(yf2Var.a)) {
            iD = d(yf2Var.j.d, strA);
            bVar.B0(i3).U(iD);
        } else {
            iD = -1;
        }
        zi1 zi1VarA = yf2Var.a();
        switch (strA.hashCode()) {
            case -1664118616:
                if (strA.equals(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_3GP)) {
                    bVar.H0(352).i0(288);
                }
                break;
            case -1662541442:
                if (strA.equals("video/hevc")) {
                    gg3.e(!zi1VarA.isEmpty(), "missing attribute fmtp");
                    h(bVar, zi1VarA);
                }
                break;
            case -1606874997:
                if (strA.equals("audio/amr-wb")) {
                    gg3.e(iD == 1, "Multi channel AMR is not currently supported.");
                    gg3.e(!zi1VarA.isEmpty(), "fmtp parameters must include octet-align.");
                    gg3.e(zi1VarA.containsKey("octet-align"), "Only octet aligned mode is currently supported.");
                    gg3.e(!zi1VarA.containsKey("interleaving"), "Interleaving mode is not currently supported.");
                }
                break;
            case -53558318:
                if (strA.equals("audio/mp4a-latm")) {
                    gg3.d(iD != -1);
                    gg3.e(!zi1VarA.isEmpty(), "missing attribute fmtp");
                    if (str2.equals("MP4A-LATM")) {
                        gg3.e(zi1VarA.containsKey("cpresent") && ((String) zi1VarA.get("cpresent")).equals("0"), "Only supports cpresent=0 in AAC audio.");
                        String str3 = (String) zi1VarA.get("config");
                        gg3.r(str3, "AAC audio stream must include config fmtp parameter");
                        gg3.k(str3.length() % 2 == 0, "Malformat MPEG4 config: %s", str3);
                        k.b bVarE = e(str3);
                        bVar.B0(bVarE.a).U(bVarE.b).V(bVarE.c);
                    }
                    f(bVar, zi1VarA, str2, iD, i3);
                }
                break;
            case 187078296:
                str = "audio/ac3";
                strA.equals(str);
                break;
            case 187094639:
                if (strA.equals("audio/raw")) {
                    bVar.t0(fv3.b(str2));
                }
                break;
            case 1187890754:
                if (strA.equals("video/mp4v-es")) {
                    gg3.d(!zi1VarA.isEmpty());
                    i(bVar, zi1VarA);
                }
                break;
            case 1331836730:
                if (strA.equals("video/avc")) {
                    gg3.e(!zi1VarA.isEmpty(), "missing attribute fmtp");
                    g(bVar, zi1VarA);
                }
                break;
            case 1503095341:
                if (strA.equals(DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_3GP)) {
                }
                break;
            case 1504891608:
                if (strA.equals("audio/opus")) {
                    gg3.d(iD != -1);
                    gg3.e(i3 == 48000, "Invalid OPUS clock rate.");
                }
                break;
            case 1599127256:
                if (strA.equals("video/x-vnd.on2.vp8")) {
                    bVar.H0(320).i0(240);
                }
                break;
            case 1599127257:
                if (strA.equals("video/x-vnd.on2.vp9")) {
                    bVar.H0(320).i0(240);
                }
                break;
            case 1903231877:
                str = "audio/g711-alaw";
                strA.equals(str);
                break;
            case 1903589369:
                str = "audio/g711-mlaw";
                strA.equals(str);
                break;
        }
        gg3.d(i3 > 0);
        return new fv3(bVar.Q(), i2, i3, zi1VarA, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] c(String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        int length = bArrDecode.length;
        byte[] bArr = dx2.a;
        byte[] bArr2 = new byte[length + bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(bArrDecode, 0, bArr2, bArr.length, bArrDecode.length);
        return bArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(int i, String str) {
        return i != -1 ? i : str.equals("audio/ac3") ? 6 : 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f(t41.b bVar, zi1 zi1Var, String str, int i, int i2) {
        String str2 = (String) zi1Var.get("profile-level-id");
        if (str2 == null && str.equals("MP4A-LATM")) {
            str2 = "30";
        }
        gg3.e((str2 == null || str2.isEmpty()) ? false : true, "missing profile-level-id param");
        bVar.V("mp4a.40." + str2);
        bVar.l0(xi1.w(k.a(i2, i)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return ((217 + this.a.hashCode()) * 31) + this.b.hashCode();
    }
}
