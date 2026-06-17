package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g50 extends Exception {
    public Throwable f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g50(String str) {
        super(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f;
    }
}
