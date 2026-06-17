package defpackage;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ws2 implements Serializable {
    public qj0 g;
    public String f = "";
    public List h = new ArrayList();
    public List i = new ArrayList();

    public void a(URL url) {
        this.h.add(url);
    }

    public void b(String str) {
        this.i.add(str);
    }

    public void c(qj0 qj0Var) {
        this.g = qj0Var;
    }

    public void d(String str) {
        this.f = str;
    }
}
