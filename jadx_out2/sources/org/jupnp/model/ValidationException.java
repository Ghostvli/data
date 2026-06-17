package org.jupnp.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ValidationException extends Exception {
    public List<ValidationError> errors;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ValidationException(String str, List<ValidationError> list) {
        super(str);
        this.errors = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<ValidationError> getErrors() {
        return this.errors;
    }

    public ValidationException(String str, Throwable th) {
        super(str, th);
    }

    public ValidationException(String str) {
        super(str);
    }
}
