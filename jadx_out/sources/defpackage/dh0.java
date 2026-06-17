package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class dh0 {
    public gv3 a(fv3 fv3Var) {
        String str = (String) gg3.q(fv3Var.c.p);
        str.getClass();
        switch (str) {
            case "video/3gpp":
                return new wu3(fv3Var);
            case "video/hevc":
                return new yu3(fv3Var);
            case "audio/amr-wb":
            case "audio/3gpp":
                return new tu3(fv3Var);
            case "audio/mp4a-latm":
                return fv3Var.e.equals("MP4A-LATM") ? new zu3(fv3Var) : new ru3(fv3Var);
            case "audio/ac3":
                return new su3(fv3Var);
            case "audio/raw":
            case "audio/g711-alaw":
            case "audio/g711-mlaw":
                return new hv3(fv3Var);
            case "video/mp4v-es":
                return new av3(fv3Var);
            case "video/avc":
                return new xu3(fv3Var);
            case "audio/opus":
                return new bv3(fv3Var);
            case "video/x-vnd.on2.vp8":
                return new kv3(fv3Var);
            case "video/x-vnd.on2.vp9":
                return new lv3(fv3Var);
            default:
                return null;
        }
    }
}
