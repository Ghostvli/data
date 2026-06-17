package org.jupnp.model;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ValidationError {
    private Class clazz;
    private String message;
    private String propertyName;

    public ValidationError(Class cls, String str, String str2) {
        this.clazz = cls;
        this.propertyName = str;
        this.message = str2;
    }

    public Class getClazz() {
        return this.clazz;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public String toString() {
        return getClass().getSimpleName() + " (Class: " + getClazz().getSimpleName() + ", propertyName: " + getPropertyName() + "): " + this.message;
    }

    public ValidationError(Class cls, String str) {
        this.clazz = cls;
        this.message = str;
    }
}
