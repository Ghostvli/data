package org.jupnp.model;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UnsupportedDataException extends RuntimeException {
    private static final long serialVersionUID = 661795454401413339L;
    protected Object data;

    public UnsupportedDataException(String str, Throwable th, Object obj) {
        super(str, th);
        this.data = obj;
    }

    public Object getData() {
        return this.data;
    }

    public UnsupportedDataException(String str, Throwable th) {
        super(str, th);
    }

    public UnsupportedDataException(String str) {
        super(str);
    }
}
