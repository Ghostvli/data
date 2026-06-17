package org.jupnp.registry;

import java.util.List;
import org.jupnp.model.ValidationError;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RegistrationException extends RuntimeException {
    public List<ValidationError> errors;

    public RegistrationException(String str, List<ValidationError> list) {
        super(str);
        this.errors = list;
    }

    public List<ValidationError> getErrors() {
        return this.errors;
    }

    public RegistrationException(String str, Throwable th) {
        super(str, th);
    }

    public RegistrationException(String str) {
        super(str);
    }
}
