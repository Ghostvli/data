package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fv0 {
    public final ByteArrayOutputStream a;
    public final DataOutputStream b;

    public fv0() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        this.b = new DataOutputStream(byteArrayOutputStream);
    }

    public static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(dv0 dv0Var) {
        this.a.reset();
        try {
            b(this.b, dv0Var.a);
            String str = dv0Var.b;
            if (str == null) {
                str = "";
            }
            b(this.b, str);
            this.b.writeLong(dv0Var.c);
            this.b.writeLong(dv0Var.d);
            this.b.write(dv0Var.e);
            this.b.flush();
            return this.a.toByteArray();
        } catch (IOException e) {
            wg1.a(e);
            return null;
        }
    }
}
