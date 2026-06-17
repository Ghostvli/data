package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class pk {
    public static long a(long j, long j2, int i) {
        long j3 = j2 & ((j >>> i) ^ j);
        return j ^ (j3 ^ (j3 << i));
    }
}
