package org.jupnp.model;

import defpackage.jl;
import defpackage.wg1;
import defpackage.zt2;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import javax.xml.XMLConstants;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ModelUtil {
    public static final boolean ANDROID_EMULATOR;
    public static final boolean ANDROID_RUNTIME;

    static {
        boolean z = true;
        boolean z2 = false;
        ANDROID_RUNTIME = Thread.currentThread().getContextClassLoader().loadClass("android.os.Build").getField("ID").get(null) != null;
        try {
            String str = (String) Thread.currentThread().getContextClassLoader().loadClass("android.os.Build").getField("PRODUCT").get(null);
            if (!"google_sdk".equals(str)) {
                if (!"sdk".equals(str)) {
                    z = false;
                }
            }
            z2 = z;
        } catch (Exception unused) {
        }
        ANDROID_EMULATOR = z2;
    }

    public static String commaToNewline(String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split(",")) {
            sb.append(str2);
            sb.append(",\n");
        }
        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length() - 2);
        }
        return sb.toString();
    }

    public static String[] fromCommaSeparatedList(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (z) {
            str = str.replaceAll("\\\\,", "XXX1122334455XXX");
        }
        String[] strArrSplit = str.split(",");
        for (int i = 0; i < strArrSplit.length; i++) {
            String strReplaceAll = strArrSplit[i].replaceAll("XXX1122334455XXX", ",");
            strArrSplit[i] = strReplaceAll;
            strArrSplit[i] = strReplaceAll.replaceAll("\\\\\\\\", "\\\\");
        }
        return strArrSplit;
    }

    public static long fromTimeString(String str) {
        if (str.lastIndexOf(".") != -1) {
            str = str.substring(0, str.lastIndexOf("."));
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 3) {
            return (Long.parseLong(strArrSplit[0]) * 3600) + (Long.parseLong(strArrSplit[1]) * 60) + Long.parseLong(strArrSplit[2]);
        }
        jl.a("Can't parse time string: ".concat(str));
        return 0L;
    }

    public static byte[] getFirstNetworkInterfaceHardwareAddress() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (!networkInterface.isLoopback() && networkInterface.isUp() && networkInterface.getHardwareAddress() != null) {
                    return networkInterface.getHardwareAddress();
                }
            }
            zt2.a("Could not discover first network interface hardware address");
            return null;
        } catch (Exception unused) {
            zt2.a("Could not discover first network interface hardware address");
            return null;
        }
    }

    public static InetAddress getInetAddressByName(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (Exception e) {
            wg1.a(e);
            return null;
        }
    }

    public static String getLocalHostName(boolean z) {
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            if (!z && hostName.contains(".")) {
                return hostName.substring(0, hostName.indexOf("."));
            }
            return hostName;
        } catch (Exception unused) {
            return "UNKNOWN HOST";
        }
    }

    public static boolean isStringConvertibleType(Set<Class> set, Class cls) {
        if (cls.isEnum()) {
            return true;
        }
        Iterator<Class> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidUDAName(String str) {
        return ANDROID_RUNTIME ? (str == null || str.isEmpty()) ? false : true : (str == null || str.isEmpty() || str.toLowerCase(Locale.ENGLISH).startsWith(XMLConstants.XML_NS_PREFIX) || !str.matches(Constants.REGEX_UDA_NAME)) ? false : true;
    }

    public static String toCommaSeparatedList(Object[] objArr, boolean z, boolean z2) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            String strReplaceAll = obj.toString().replaceAll("\\\\", "\\\\\\\\");
            if (z) {
                strReplaceAll = strReplaceAll.replaceAll(",", "\\\\,");
            }
            if (z2) {
                strReplaceAll = strReplaceAll.replaceAll("\"", "\\\"");
            }
            sb.append(strReplaceAll);
            sb.append(",");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String toTimeString(long j) {
        long j2 = j / 3600;
        long j3 = j % 3600;
        long j4 = j3 / 60;
        long j5 = j3 % 60;
        return (j2 < 10 ? "0" : "") + j2 + ":" + (j4 < 10 ? "0" : "") + j4 + ":" + (j5 < 10 ? "0" : "") + j5;
    }

    public static String[] fromCommaSeparatedList(String str) {
        return fromCommaSeparatedList(str, true);
    }

    public static String toCommaSeparatedList(Object[] objArr) {
        return toCommaSeparatedList(objArr, true, false);
    }
}
