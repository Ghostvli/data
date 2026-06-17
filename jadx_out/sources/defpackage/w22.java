package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class w22 {
    public final String[] a = new String[5];
    public final long[] b = new long[5];
    public int c = 0;
    public int d = 0;

    public void a(String str) {
        int i = this.c;
        if (i == 5) {
            this.d++;
            return;
        }
        this.a[i] = str;
        this.b[i] = System.nanoTime();
        gq4.a(str);
        this.c++;
    }

    public float b(String str) {
        int i = this.d;
        if (i > 0) {
            this.d = i - 1;
            return 0.0f;
        }
        int i2 = this.c - 1;
        this.c = i2;
        if (i2 == -1) {
            e04.a("Can't end trace section. There are none.");
            return 0.0f;
        }
        if (str.equals(this.a[i2])) {
            gq4.b();
            return (System.nanoTime() - this.b[this.c]) / 1000000.0f;
        }
        v22.a("Unbalanced trace call ", str, ". Expected ", this.a[this.c], ".");
        return 0.0f;
    }
}
