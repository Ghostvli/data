package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g50 extends Exception {
    public Throwable f;

    public g50(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f;
    }
}
