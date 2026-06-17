package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class ya0 {
    public static /* synthetic */ long a(long j, long j2) {
        long j3 = j & 4294967295L;
        long j4 = j >> 32;
        long j5 = j2 & 4294967295L;
        long j6 = j2 >> 32;
        long j7 = (j5 * j4) + ((j3 * j5) >>> 32);
        return (j4 * j6) + (j7 >> 32) + (((j3 * j6) + (4294967295L & j7)) >> 32);
    }
}
