package defpackage;

import android.net.Uri;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class f5 implements aa0 {
    public final aa0 a;
    public final byte[] b;
    public final byte[] c;
    public CipherInputStream d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f5(aa0 aa0Var, byte[] bArr, byte[] bArr2) {
        this.a = aa0Var;
        this.b = bArr;
        this.c = bArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public final long a(ja0 ja0Var) {
        try {
            Cipher cipherH = h();
            try {
                cipherH.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(this.c));
                ha0 ha0Var = new ha0(this.a, ja0Var);
                this.d = new CipherInputStream(ha0Var, cipherH);
                ha0Var.c();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                wg1.a(e);
                return 0L;
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            wg1.a(e2);
            return 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public void close() {
        if (this.d != null) {
            this.d = null;
            this.a.close();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public final void f(hs4 hs4Var) {
        gg3.q(hs4Var);
        this.a.f(hs4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public final Uri getUri() {
        return this.a.getUri();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Cipher h() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.aa0
    public final Map o() {
        return this.a.o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x90
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        gg3.q(this.d);
        int i3 = this.d.read(bArr, i, i2);
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }
}
