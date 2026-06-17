package defpackage;

import defpackage.t41;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ve4 implements df {
    public final t41 a;

    public ve4(t41 t41Var) {
        this.a = t41Var;
    }

    public static String a(int i) {
        switch (i) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return "video/mp4v-es";
            case 826496577:
            case 828601953:
            case 875967048:
                return "video/avc";
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    public static String b(int i) {
        if (i == 1) {
            return "audio/raw";
        }
        if (i == 85) {
            return DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG;
        }
        if (i == 255) {
            return "audio/mp4a-latm";
        }
        if (i == 8192) {
            return "audio/ac3";
        }
        if (i != 8193) {
            return null;
        }
        return "audio/vnd.dts";
    }

    public static df c(r73 r73Var) {
        r73Var.g0(4);
        int iD = r73Var.D();
        int iD2 = r73Var.D();
        r73Var.g0(4);
        int iD3 = r73Var.D();
        String strA = a(iD3);
        if (strA != null) {
            t41.b bVar = new t41.b();
            bVar.H0(iD).i0(iD2).A0(strA);
            return new ve4(bVar.Q());
        }
        xz1.i("StreamFormatChunk", "Ignoring track with unsupported compression " + iD3);
        return null;
    }

    public static df d(int i, r73 r73Var) {
        if (i == 2) {
            return c(r73Var);
        }
        if (i == 1) {
            return e(r73Var);
        }
        xz1.i("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + fy4.D0(i));
        return null;
    }

    public static df e(r73 r73Var) {
        int I = r73Var.I();
        String strB = b(I);
        if (strB == null) {
            xz1.i("StreamFormatChunk", "Ignoring track with unsupported format tag " + I);
            return null;
        }
        int I2 = r73Var.I();
        int iD = r73Var.D();
        r73Var.g0(6);
        int iR0 = fy4.r0(r73Var.I());
        int I3 = r73Var.a() > 0 ? r73Var.I() : 0;
        t41.b bVar = new t41.b();
        bVar.A0(strB).U(I2).B0(iD);
        if (strB.equals("audio/raw") && iR0 != 0) {
            bVar.t0(iR0);
        }
        if (strB.equals("audio/mp4a-latm") && I3 > 0) {
            byte[] bArr = new byte[I3];
            r73Var.u(bArr, 0, I3);
            bVar.l0(xi1.w(bArr));
        }
        return new ve4(bVar.Q());
    }

    @Override // defpackage.df
    public int getType() {
        return 1718776947;
    }
}
