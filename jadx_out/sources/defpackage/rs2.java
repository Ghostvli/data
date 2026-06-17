package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface rs2 extends ss2 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a extends ss2, Cloneable {
        rs2 buildPartial();

        a mergeFrom(hv hvVar, xy0 xy0Var);

        a mergeFrom(rs2 rs2Var);
    }

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    void writeTo(jv jvVar);
}
