package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class gh0 implements j50 {
    public final String a;
    public final int b;
    public final Object c;
    public final k50 d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gh0(String str, int i, Object obj, k50 k50Var) {
        this.a = str;
        this.b = i;
        this.c = obj;
        if (obj instanceof k50) {
            jl.a("params should not be CryptoServicePurpose");
            throw null;
        }
        this.d = k50Var;
    }

    public gh0(String str, int i) {
        this(str, i, null, k50.ANY);
    }
}
