package defpackage;

import android.net.Uri;
import android.util.Base64;
import j$.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class y90 extends lh {
    public ja0 e;
    public byte[] f;
    public int g;
    public int h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y90() {
        super(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public long a(ja0 ja0Var) throws ga0, r83 {
        v(ja0Var);
        this.e = ja0Var;
        Uri uriNormalizeScheme = ja0Var.a.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        gg3.k("data".equals(scheme), "Unsupported scheme: %s", scheme);
        String[] strArrG1 = fy4.G1(uriNormalizeScheme.getSchemeSpecificPart(), ",");
        if (strArrG1.length != 2) {
            throw r83.b("Unexpected URI format: " + uriNormalizeScheme, null);
        }
        String str = strArrG1[1];
        if (strArrG1[0].contains(";base64")) {
            try {
                this.f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw r83.b("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.f = fy4.F0(URLDecoder.decode(str, StandardCharsets.US_ASCII.name()));
        }
        long j = ja0Var.g;
        byte[] bArr = this.f;
        if (j > bArr.length) {
            this.f = null;
            throw new ga0(2008);
        }
        int i = (int) j;
        this.g = i;
        int length = bArr.length - i;
        this.h = length;
        long j2 = ja0Var.h;
        if (j2 != -1) {
            this.h = (int) Math.min(length, j2);
        }
        w(ja0Var);
        long j3 = ja0Var.h;
        return j3 != -1 ? j3 : this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public void close() {
        if (this.f != null) {
            this.f = null;
            u();
        }
        this.e = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public Uri getUri() {
        ja0 ja0Var = this.e;
        if (ja0Var != null) {
            return ja0Var.a;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x90
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        System.arraycopy(fy4.l(this.f), this.g, bArr, i, iMin);
        this.g += iMin;
        this.h -= iMin;
        t(iMin);
        return iMin;
    }
}
