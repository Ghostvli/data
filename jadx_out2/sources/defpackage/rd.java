package defpackage;

import defpackage.bl4;
import defpackage.k;
import defpackage.t41;
import java.util.Collections;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class rd extends bl4 {
    public static final int[] e = {5512, 11025, 22050, 44100};
    public boolean b;
    public boolean c;
    public int d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public rd(gr4 gr4Var) {
        super(gr4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bl4
    public boolean b(r73 r73Var) throws bl4.a {
        if (this.b) {
            r73Var.g0(1);
        } else {
            int iQ = r73Var.Q();
            int i = (iQ >> 4) & 15;
            this.d = i;
            if (i == 2) {
                this.a.g(new t41.b().X("video/x-flv").A0(DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG).U(1).B0(e[(iQ >> 2) & 3]).Q());
                this.c = true;
            } else if (i == 7 || i == 8) {
                this.a.g(new t41.b().X("video/x-flv").A0(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").U(1).B0(8000).Q());
                this.c = true;
            } else if (i != 10) {
                throw new bl4.a("Audio format not supported: " + this.d);
            }
            this.b = true;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bl4
    public boolean c(r73 r73Var, long j) {
        if (this.d == 2) {
            int iA = r73Var.a();
            this.a.a(r73Var, iA);
            this.a.b(j, 1, iA, 0, null);
            return true;
        }
        int iQ = r73Var.Q();
        if (iQ != 0 || this.c) {
            if (this.d == 10 && iQ != 1) {
                return false;
            }
            int iA2 = r73Var.a();
            this.a.a(r73Var, iA2);
            this.a.b(j, 1, iA2, 0, null);
            return true;
        }
        int iA3 = r73Var.a();
        byte[] bArr = new byte[iA3];
        r73Var.u(bArr, 0, iA3);
        k.b bVarF = k.f(bArr);
        this.a.g(new t41.b().X("video/x-flv").A0("audio/mp4a-latm").V(bVarF.c).U(bVarF.b).B0(bVarF.a).l0(Collections.singletonList(bArr)).Q());
        this.c = true;
        return false;
    }
}
