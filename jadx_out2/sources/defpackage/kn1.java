package defpackage;

import android.net.Uri;
import com.github.catvod.utils.Path;
import com.p2p.P2PClass;
import defpackage.db4;
import j$.net.URLDecoder;
import j$.net.URLEncoder;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class kn1 implements db4.a {
    public P2PClass f;
    public String g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public void a() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public boolean b(Uri uri) {
        return av4.a(new Object[]{"tvbox-xg", "jianpian", "ftp"}).contains(qx4.i(uri));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public String c(String str) {
        e();
        stop();
        d();
        f(str);
        return "http://127.0.0.1:" + this.f.port + ServiceReference.DELIMITER + URLEncoder.encode(qx4.g(this.g), "GBK");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d() {
        double dH = w01.h(Path.jpa());
        if (((int) ((dH / (w01.f(Path.jpa()) + dH)) * 100.0d)) > 10) {
            Path.clear(Path.jpa());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e() {
        if (this.f == null) {
            this.f = new P2PClass();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(String str) {
        try {
            String str2 = URLDecoder.decode(str).split("\\|")[0];
            this.g = str2;
            String strReplace = str2.replace("jianpian://pathtype=url&path=", "");
            this.g = strReplace;
            String strReplace2 = strReplace.replace("tvbox-xg://", "").replace("tvbox-xg:", "");
            this.g = strReplace2;
            String strReplace3 = strReplace2.replace("xg://", "ftp://").replace("xgplay://", "ftp://");
            this.g = strReplace3;
            this.f.P2Pdoxstart(strReplace3.getBytes("GBK"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public void stop() {
        String str;
        try {
            P2PClass p2PClass = this.f;
            if (p2PClass != null && (str = this.g) != null) {
                p2PClass.P2Pdoxpause(str.getBytes("GBK"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.g = null;
        }
    }
}
