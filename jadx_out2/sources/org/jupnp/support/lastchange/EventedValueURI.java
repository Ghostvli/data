package org.jupnp.support.lastchange;

import defpackage.j02;
import defpackage.n02;
import java.net.URI;
import java.util.Map;
import org.jupnp.model.types.Datatype;
import org.jupnp.model.types.InvalidValueException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EventedValueURI extends EventedValue<URI> {
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public EventedValueURI(URI uri) {
        super(uri);
        this.logger = n02.k(EventedValueURI.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.support.lastchange.EventedValue
    public Datatype<?> getDatatype() {
        return Datatype.Builtin.URI.getDatatype();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: valueOf(Ljava/lang/String;)Ljava/lang/Object; */
    @Override // org.jupnp.support.lastchange.EventedValue
    public URI valueOf(String str) {
        try {
            return (URI) super.valueOf(str);
        } catch (InvalidValueException e) {
            this.logger.f("Ignoring invalid URI in evented value '{}'", str, e);
            return null;
        }
    }

    public EventedValueURI(Map.Entry<String, String>[] entryArr) {
        super(entryArr);
        this.logger = n02.k(EventedValueURI.class);
    }
}
