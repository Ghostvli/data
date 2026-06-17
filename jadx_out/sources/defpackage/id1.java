package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class id1 {
    public static final jd1 a = new jd1();

    public static byte[] a(String str) {
        try {
            return a.a(str, 0, str.length());
        } catch (Exception e) {
            throw new hb0("exception decoding Hex string: " + e.getMessage(), e);
        }
    }
}
