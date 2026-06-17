package org.jupnp.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import defpackage.j02;
import defpackage.n02;
import org.jupnp.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NetworkUtils {
    private static final j02 LOGGER = n02.k(NetworkUtils.class);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static NetworkInfo getConnectedNetworkInfo(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            return activeNetworkInfo;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.isAvailable() && networkInfo2.isConnected()) {
            return networkInfo2;
        }
        NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(6);
        if (networkInfo3 != null && networkInfo3.isAvailable() && networkInfo3.isConnected()) {
            return networkInfo3;
        }
        NetworkInfo networkInfo4 = connectivityManager.getNetworkInfo(9);
        if (networkInfo4 != null && networkInfo4.isAvailable() && networkInfo4.isConnected()) {
            return networkInfo4;
        }
        LOGGER.info("Could not find any connected network...");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isEthernet(NetworkInfo networkInfo) {
        return isNetworkType(networkInfo, 9);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isMobile(NetworkInfo networkInfo) {
        return isNetworkType(networkInfo, 0) || isNetworkType(networkInfo, 6);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isNetworkType(NetworkInfo networkInfo, int i) {
        return networkInfo != null && networkInfo.getType() == i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isSSDPAwareNetwork(NetworkInfo networkInfo) {
        return isWifi(networkInfo) || isEthernet(networkInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isWifi(NetworkInfo networkInfo) {
        return isNetworkType(networkInfo, 1) || ModelUtil.ANDROID_EMULATOR;
    }
}
