package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class up0 implements Cloneable {
    public long f;
    public float g = 1.0f;
    public long h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public up0(long j) {
        this.f = j;
        this.h = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(float f) {
        if (this.g != f) {
            this.g = f;
            this.h = (long) (this.f * f);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(long j) {
        this.f = j;
        this.h = (long) (j * this.g);
    }
}
