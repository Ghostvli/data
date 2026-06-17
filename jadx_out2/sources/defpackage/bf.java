package defpackage;

import defpackage.y43;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bf {
    public final ByteBuffer a = ByteBuffer.allocateDirect(500);
    public y43.e b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean a(y43.d dVar, boolean z) {
        y43.e eVar;
        y43.b bVarB;
        int i = dVar.a;
        if (i == 2 || i == 15) {
            return true;
        }
        if (i != 3 || z) {
            return ((i != 6 && i != 3) || (eVar = this.b) == null || (bVarB = y43.b.b(eVar, dVar)) == null || bVarB.a()) ? false : true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b() {
        ByteBuffer byteBuffer = this.a;
        byteBuffer.position(byteBuffer.limit());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, iPosition + 500));
        this.a.clear();
        this.a.put(byteBuffer);
        this.a.flip();
        byteBuffer.position(iPosition);
        byteBuffer.limit(iLimit);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d() {
        this.b = null;
        b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e(ByteBuffer byteBuffer, boolean z) {
        if (this.a.hasRemaining()) {
            f(y43.e(this.a));
            b();
        }
        List listE = y43.e(byteBuffer);
        f(listE);
        int size = listE.size() - 1;
        int i = 0;
        while (size >= 0 && a((y43.d) listE.get(size), z)) {
            if (((y43.d) listE.get(size)).a == 6 || ((y43.d) listE.get(size)).a == 3) {
                i++;
            }
            size--;
        }
        return (i > 1 || size + 1 >= 8) ? byteBuffer.limit() : size >= 0 ? ((y43.d) listE.get(size)).b.limit() : byteBuffer.position();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (((y43.d) list.get(i)).a == 1) {
                this.b = y43.e.a((y43.d) list.get(i));
            }
        }
    }
}
