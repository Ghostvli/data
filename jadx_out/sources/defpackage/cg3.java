package defpackage;

import defpackage.jj4;
import java.io.File;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cg3 implements jj4.c {
    public final String a;
    public final File b;
    public final Callable c;
    public final jj4.c d;

    public cg3(String str, File file, Callable callable, jj4.c cVar) {
        cVar.getClass();
        this.a = str;
        this.b = file;
        this.c = callable;
        this.d = cVar;
    }

    @Override // jj4.c
    public jj4 a(jj4.b bVar) {
        bVar.getClass();
        return new bg3(bVar.a, this.a, this.b, this.c, bVar.c.a, this.d.a(bVar));
    }
}
