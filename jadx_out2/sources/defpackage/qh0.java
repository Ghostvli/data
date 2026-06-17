package defpackage;

import defpackage.ki4;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qh0 implements ki4.a {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // ki4.a
    public boolean a(t41 t41Var) {
        String str = t41Var.p;
        return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/vobsub") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // ki4.a
    public ki4 b(t41 t41Var) {
        String str = t41Var.p;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                    return new zp0(t41Var.s);
                case "application/pgs":
                    return new xa3();
                case "application/x-mp4-vtt":
                    return new bv2();
                case "text/vtt":
                    return new e95();
                case "application/x-quicktime-tx3g":
                    return new iu4(t41Var.s);
                case "text/x-ssa":
                    return new kd4(t41Var.s);
                case "application/vobsub":
                    return new u55(t41Var.s);
                case "application/x-subrip":
                    return new kh4();
                case "application/ttml+xml":
                    return new au4();
            }
        }
        c.a("Unsupported MIME type: ", str);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // ki4.a
    public int c(t41 t41Var) {
        String str = t41Var.p;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                case "application/pgs":
                case "application/x-mp4-vtt":
                    return 2;
                case "text/vtt":
                    return 1;
                case "application/x-quicktime-tx3g":
                    return 2;
                case "text/x-ssa":
                    return 1;
                case "application/vobsub":
                    return 2;
                case "application/x-subrip":
                case "application/ttml+xml":
                    return 1;
            }
        }
        c.a("Unsupported MIME type: ", str);
        return 0;
    }
}
