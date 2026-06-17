package defpackage;

import java.util.Map;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fv3 {
    public final int a;
    public final int b;
    public final t41 c;
    public final zi1 d;
    public final String e;

    public fv3(t41 t41Var, int i, int i2, Map map, String str) {
        this.a = i;
        this.b = i2;
        this.c = t41Var;
        this.d = zi1.c(map);
        this.e = str;
    }

    public static String a(String str) {
        String strG = xa.g(str);
        strG.getClass();
        switch (strG) {
            case "MPEG4-GENERIC":
            case "MP4A-LATM":
                return "audio/mp4a-latm";
            case "L8":
            case "L16":
                return "audio/raw";
            case "AC3":
                return "audio/ac3";
            case "AMR":
                return DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_3GP;
            case "VP8":
                return "video/x-vnd.on2.vp8";
            case "VP9":
                return "video/x-vnd.on2.vp9";
            case "H264":
                return "video/avc";
            case "H265":
                return "video/hevc";
            case "OPUS":
                return "audio/opus";
            case "PCMA":
                return "audio/g711-alaw";
            case "PCMU":
                return "audio/g711-mlaw";
            case "AMR-WB":
                return "audio/amr-wb";
            case "MP4V-ES":
                return "video/mp4v-es";
            case "H263-1998":
            case "H263-2000":
                return DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_3GP;
            default:
                jl.a(str);
                return null;
        }
    }

    public static int b(String str) {
        gg3.d(str.equals("L8") || str.equals("L16"));
        return str.equals("L8") ? 3 : 268435456;
    }

    public static boolean c(yf2 yf2Var) {
        String strG = xa.g(yf2Var.j.b);
        strG.getClass();
        switch (strG) {
            case "MPEG4-GENERIC":
            case "L8":
            case "AC3":
            case "AMR":
            case "L16":
            case "VP8":
            case "VP9":
            case "H264":
            case "H265":
            case "OPUS":
            case "PCMA":
            case "PCMU":
            case "MP4A-LATM":
            case "AMR-WB":
            case "MP4V-ES":
            case "H263-1998":
            case "H263-2000":
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && fv3.class == obj.getClass()) {
            fv3 fv3Var = (fv3) obj;
            if (this.a == fv3Var.a && this.b == fv3Var.b && this.c.equals(fv3Var.c) && this.d.equals(fv3Var.d) && this.e.equals(fv3Var.e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((217 + this.a) * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }
}
