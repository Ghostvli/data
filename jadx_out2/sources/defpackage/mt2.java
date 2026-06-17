package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mt2 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String a(t41 t41Var) {
        String str = t41Var.p;
        return nt2.t(str) ? DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4 : nt2.o(str) ? DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG_4 : nt2.q(str) ? Objects.equals(str, "image/heic") ? "image/heif" : Objects.equals(str, "image/avif") ? "image/avif" : "application/mp4" : "application/mp4";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String b(List list) {
        Iterator it = list.iterator();
        boolean z = false;
        String str = null;
        while (it.hasNext()) {
            String str2 = ((hr4) it.next()).a.g.p;
            if (nt2.t(str2)) {
                return DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4;
            }
            if (nt2.o(str2)) {
                z = true;
            } else if (nt2.q(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        return z ? DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG_4 : str != null ? str : "application/mp4";
    }
}
