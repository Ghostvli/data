package org.jupnp.model.types;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class StringDatatype extends AbstractDatatype<String> {
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public String valueOf(String str) {
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }
}
