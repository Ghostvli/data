package defpackage;

import android.util.Base64;
import com.github.catvod.utils.Util;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e50 {
    public static String a(String str, boolean z, String str2, boolean z2, String str3, String str4, boolean z3) {
        try {
            byte[] bytes = str3.getBytes();
            if (bytes.length < 16) {
                bytes = Arrays.copyOf(bytes, 16);
            }
            byte[] bytes2 = str4 == null ? new byte[0] : str4.getBytes();
            if (bytes2.length < 16) {
                bytes2 = Arrays.copyOf(bytes2, 16);
            }
            Cipher cipher = Cipher.getInstance(str + "Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            int i = 1;
            if (str4 == null) {
                if (!z) {
                    i = 2;
                }
                cipher.init(i, secretKeySpec);
            } else {
                if (!z) {
                    i = 2;
                }
                cipher.init(i, secretKeySpec, new IvParameterSpec(bytes2));
            }
            byte[] bArrDecode = z2 ? Base64.decode(str2.replaceAll("_", ServiceReference.DELIMITER).replaceAll("-", "+"), 0) : str2.getBytes(StandardCharsets.UTF_8);
            return z3 ? Base64.encodeToString(cipher.doFinal(bArrDecode), 2) : new String(cipher.doFinal(bArrDecode), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Key b(boolean z, String str) {
        String strReplace = z ? str.replaceAll("[\\r\\n]", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "") : str.replaceAll("[\\r\\n]", "").replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "");
        return z ? KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(strReplace, 0))) : KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(strReplace, 0)));
    }

    public static String c(String str) {
        try {
            return Util.md5(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String d(String str, boolean z, boolean z2, String str2, boolean z3, String str3, boolean z4) {
        try {
            Key keyB = b(z, str3);
            byte[] bArrDecode = z3 ? Base64.decode(str2.replaceAll("_", ServiceReference.DELIMITER).replaceAll("-", "+"), 0) : str2.getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance(("RSA/PKCS1".equals(str) || !"RSA/None/NoPadding".equals(str)) ? "RSA/ECB/PKCS1Padding" : "RSA/None/NoPadding");
            cipher.init(z2 ? 1 : 2, keyB);
            byte[] bArrDoFinal = cipher.doFinal(bArrDecode);
            return z4 ? Base64.encodeToString(bArrDoFinal, 2) : new String(bArrDoFinal, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
