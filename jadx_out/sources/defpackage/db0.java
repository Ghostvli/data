package defpackage;

import android.util.Base64;
import com.github.catvod.utils.Json;
import com.github.catvod.utils.Util;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.HttpUrl;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class db0 {
    public static final Pattern a = Pattern.compile("\"(\\.|\\.\\.)/(.?|.+?)\\.js\\?(.?|.+?)\"");

    public static String a(String str) {
        String strC = c(str);
        return strC.isEmpty() ? str : new String(Base64.decode(strC, 0));
    }

    public static String b(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String lowerCase = new String(Util.hex2byte(str)).toLowerCase();
        String strF = f(lowerCase.substring(lowerCase.indexOf("$#") + 2, lowerCase.indexOf("#$")));
        String strF2 = f(lowerCase.substring(lowerCase.length() - 13));
        SecretKeySpec secretKeySpec = new SecretKeySpec(strF.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(strF2.getBytes());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return new String(cipher.doFinal(Util.hex2byte(str.substring(str.indexOf("2324") + 4, str.length() - 26))), StandardCharsets.UTF_8);
    }

    public static String c(String str) {
        Matcher matcher = Pattern.compile("[A-Za-z0-9]{8}\\*\\*").matcher(str);
        return matcher.find() ? str.substring(str.indexOf(matcher.group()) + 10) : "";
    }

    public static String d(String str, String str2) {
        Matcher matcher = a.matcher(str2);
        while (matcher.find()) {
            str2 = g(str, str2, matcher.group());
        }
        if (str2.contains("../")) {
            str2 = str2.replace("../", qx4.h(str, "../"));
        }
        if (str2.contains("./")) {
            str2 = str2.replace("./", qx4.h(str, "./"));
        }
        if (str2.contains("__JS1__")) {
            str2 = str2.replace("__JS1__", "./");
        }
        return str2.contains("__JS2__") ? str2.replace("__JS2__", "../") : str2;
    }

    public static String e(String str, String str2) {
        Response responseExecute = q53.r(str, str2).execute();
        try {
            HttpUrl httpUrlUrl = responseExecute.request().url();
            if (httpUrlUrl.querySize() == HttpUrl.parse(str).querySize()) {
                str = httpUrlUrl.toString();
            }
            String strH = h(str, responseExecute.body().string());
            responseExecute.close();
            return strH;
        } catch (Throwable th) {
            if (responseExecute != null) {
                try {
                    responseExecute.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static String f(String str) {
        return str + "0000000000000000".substring(str.length());
    }

    public static String g(String str, String str2, String str3) {
        return str2.replace(str3, str3.replace("\"./", "\"" + qx4.h(str, "./")).replace("\"../", "\"" + qx4.h(str, "../")).replace("./", "__JS1__").replace("../", "__JS2__"));
    }

    public static String h(String str, String str2) throws Exception {
        if (str2.isEmpty()) {
            throw new Exception();
        }
        if (Json.isObj(str2)) {
            return d(str, str2);
        }
        if (str2.contains("**")) {
            str2 = a(str2);
        }
        if (str2.startsWith("2423")) {
            str2 = b(str2.replaceAll("\\s+", ""));
        }
        return d(str, str2);
    }
}
