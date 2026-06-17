package java.nio.file;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public class FileSystemException extends IOException {
    private final String a;
    private final String b;

    public FileSystemException(String str) {
        super((String) null);
        this.a = str;
        this.b = null;
    }

    public String getFile() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.a == null && this.b == null) {
            return getReason();
        }
        StringBuilder sb = new StringBuilder();
        if (this.a != null) {
            sb.append(this.a);
        }
        if (this.b != null) {
            sb.append(" -> ");
            sb.append(this.b);
        }
        if (getReason() != null) {
            sb.append(": ");
            sb.append(getReason());
        }
        return sb.toString();
    }

    public String getOtherFile() {
        return this.b;
    }

    public String getReason() {
        return super.getMessage();
    }

    public FileSystemException(String str, String str2, String str3) {
        super(str3);
        this.a = str;
        this.b = str2;
    }
}
