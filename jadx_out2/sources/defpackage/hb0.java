package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class hb0 extends IllegalStateException {
    public Throwable f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hb0(String str, Throwable th) {
        super(str);
        this.f = th;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f;
    }
}
