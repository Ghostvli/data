package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import android.util.Base64;
import androidx.media3.exoplayer.rtsp.h;
import defpackage.fy4;
import defpackage.r83;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final int a;
    public final String b;
    public final String c;
    public final String d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c(int i, String str, String str2, String str3) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String a(h.a aVar, Uri uri, int i) throws r83 {
        int i2 = this.a;
        if (i2 == 1) {
            return b(aVar);
        }
        if (i2 == 2) {
            return c(aVar, uri, i);
        }
        throw r83.d(null, new UnsupportedOperationException());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String b(h.a aVar) {
        return fy4.M("Basic %s", Base64.encodeToString(h.d(aVar.a + ":" + aVar.b), 0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String c(h.a aVar, Uri uri, int i) throws r83 {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String strT = h.t(i);
            String strN1 = fy4.N1(messageDigest.digest(h.d(aVar.a + ":" + this.b + ":" + aVar.b)));
            StringBuilder sb = new StringBuilder();
            sb.append(strT);
            sb.append(":");
            sb.append(uri);
            String strN12 = fy4.N1(messageDigest.digest(h.d(strN1 + ":" + this.c + ":" + fy4.N1(messageDigest.digest(h.d(sb.toString()))))));
            return this.d.isEmpty() ? fy4.M("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"", aVar.a, this.b, this.c, uri, strN12) : fy4.M("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"", aVar.a, this.b, this.c, uri, strN12, this.d);
        } catch (NoSuchAlgorithmException e) {
            throw r83.d(null, e);
        }
    }
}
