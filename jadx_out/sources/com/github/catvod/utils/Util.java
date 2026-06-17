package com.github.catvod.utils;

import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Base64;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.yj1;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Locale;
import okhttp3.OkHttp;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Util {
    public static final String CHROME = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36";
    public static final String OKHTTP = "okhttp/" + OkHttp.VERSION;
    public static final int URL_SAFE = 10;

    public static String base64(String str) {
        return base64(str.getBytes());
    }

    public static boolean containOrMatch(String str, String str2) {
        try {
            if (str.contains(str2)) {
                return true;
            }
            return str.matches(str2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static byte[] decode(String str) {
        return decode(str, 2);
    }

    public static boolean equals(String str, String str2) {
        return md5(Path.jar(str)).equalsIgnoreCase(str2);
    }

    private static String getHostAddress(String str) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
            if (str.isEmpty() || networkInterfaceNextElement.getName().startsWith(str)) {
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
        }
        return "";
    }

    public static String getIp() {
        try {
            String hostAddress = getHostAddress("wlan");
            if (!hostAddress.isEmpty()) {
                return hostAddress;
            }
            String hostAddress2 = getHostAddress("eth");
            if (!hostAddress2.isEmpty()) {
                return hostAddress2;
            }
            String wifiAddress = getWifiAddress();
            return !wifiAddress.isEmpty() ? wifiAddress : getHostAddress("");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getWifiAddress() {
        int ipAddress = ((WifiManager) yj1.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress();
        return ipAddress == 0 ? "" : String.format(Locale.getDefault(), "%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
    }

    public static byte[] hex2byte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String md5(File file) {
        int i;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            fileInputStream.close();
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest.digest()) {
                sb.append(Integer.toString((b & 255) + Buffer.DEFAULT_SIZE, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String substring(String str, int i) {
        return (str == null || str.length() <= i) ? str : str.substring(0, str.length() - i);
    }

    public static byte[] decode(String str, int i) {
        return Base64.decode(str, i);
    }

    public static String base64(byte[] bArr) {
        return base64(bArr, 2);
    }

    public static String base64(String str, int i) {
        return base64(str.getBytes(), i);
    }

    public static String base64(byte[] bArr, int i) {
        return Base64.encodeToString(bArr, i);
    }

    public static String substring(String str) {
        return substring(str, 1);
    }

    public static String md5(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder(new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8))).toString(16));
            while (sb.length() < 32) {
                sb.insert(0, "0");
            }
            return sb.toString().toLowerCase();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
