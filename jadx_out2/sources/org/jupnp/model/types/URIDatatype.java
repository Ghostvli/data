package org.jupnp.model.types;

import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class URIDatatype extends AbstractDatatype<URI> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: valueOf(Ljava/lang/String;)Ljava/lang/Object; */
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public URI valueOf(String str) {
        if (str.isEmpty()) {
            return null;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new InvalidValueException(e.getMessage(), e);
        }
    }
}
