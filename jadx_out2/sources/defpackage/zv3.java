package defpackage;

import android.net.Uri;
import defpackage.xi1;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zv3 {
    public final long a;
    public final int b;
    public final Uri c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zv3(long j, int i, Uri uri) {
        this.a = j;
        this.b = i;
        this.c = uri;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 a(String str, Uri uri) throws r83 {
        xi1.a aVar = new xi1.a();
        String[] strArrG1 = fy4.G1(str, ",");
        int length = strArrG1.length;
        int i = 0;
        while (i < length) {
            String str2 = strArrG1[i];
            String[] strArrG12 = fy4.G1(str2, ";");
            int length2 = strArrG12.length;
            int i2 = i;
            long j = -9223372036854775807L;
            int i3 = 0;
            Uri uriB = null;
            int i4 = -1;
            while (i3 < length2) {
                String str3 = strArrG12[i3];
                try {
                    String[] strArrH1 = fy4.H1(str3, "=");
                    String str4 = strArrH1[0];
                    String str5 = strArrH1[1];
                    int iHashCode = str4.hashCode();
                    String[] strArr = strArrG1;
                    if (iHashCode != 113759) {
                        if (iHashCode != 116079) {
                            if (iHashCode != 1524180539 || !str4.equals("rtptime")) {
                                throw r83.c(str4, null);
                            }
                            j = Long.parseLong(str5);
                            i3++;
                            strArrG1 = strArr;
                        } else {
                            if (!str4.equals("url")) {
                                throw r83.c(str4, null);
                            }
                            uriB = b(str5, uri);
                            i3++;
                            strArrG1 = strArr;
                        }
                    } else {
                        if (!str4.equals("seq")) {
                            throw r83.c(str4, null);
                        }
                        i4 = Integer.parseInt(str5);
                        i3++;
                        strArrG1 = strArr;
                    }
                } catch (Exception e) {
                    throw r83.c(str3, e);
                }
            }
            String[] strArr2 = strArrG1;
            if (uriB == null || uriB.getScheme() == null || (i4 == -1 && j == -9223372036854775807L)) {
                throw r83.c(str2, null);
            }
            aVar.a(new zv3(j, i4, uriB));
            i = i2 + 1;
            strArrG1 = strArr2;
        }
        return aVar.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Uri b(String str, Uri uri) {
        gg3.d(((String) gg3.q(uri.getScheme())).equals("rtsp"));
        Uri uri2 = Uri.parse(str);
        if (uri2.isAbsolute()) {
            return uri2;
        }
        Uri uri3 = Uri.parse("rtsp://" + str);
        String string = uri.toString();
        return ((String) gg3.q(uri3.getHost())).equals(uri.getHost()) ? uri3 : string.endsWith(ServiceReference.DELIMITER) ? kx4.g(string, str) : kx4.g(string.concat(ServiceReference.DELIMITER), str);
    }
}
