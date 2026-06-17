package org.jupnp.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import defpackage.j02;
import defpackage.n02;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.model.ModelUtil;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.transport.RouterException;
import org.jupnp.transport.RouterImpl;
import org.jupnp.util.Exceptions;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AndroidRouter extends RouterImpl {
    protected BroadcastReceiver broadcastReceiver;
    private final Context context;
    private final j02 logger;
    protected WifiManager.MulticastLock multicastLock;
    protected NetworkInfo networkInfo;
    protected WifiManager.WifiLock wifiLock;
    private final WifiManager wifiManager;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class ConnectivityBroadcastReceiver extends BroadcastReceiver {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ConnectivityBroadcastReceiver() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void displayIntentInfo(Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            String stringExtra = intent.getStringExtra("reason");
            boolean booleanExtra2 = intent.getBooleanExtra("isFailover", false);
            Object obj = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            Object obj2 = (NetworkInfo) intent.getParcelableExtra("otherNetwork");
            AndroidRouter.this.logger.info("Connectivity change detected...");
            AndroidRouter.this.logger.c("EXTRA_NO_CONNECTIVITY: {}", Boolean.valueOf(booleanExtra));
            AndroidRouter.this.logger.c("EXTRA_REASON: {}", stringExtra);
            AndroidRouter.this.logger.c("EXTRA_IS_FAILOVER: {}", Boolean.valueOf(booleanExtra2));
            j02 j02Var = AndroidRouter.this.logger;
            if (obj == null) {
                obj = "none";
            }
            j02Var.c("EXTRA_NETWORK_INFO: {}", obj);
            j02 j02Var2 = AndroidRouter.this.logger;
            if (obj2 == null) {
                obj2 = "none";
            }
            j02Var2.c("EXTRA_OTHER_NETWORK_INFO: {}", obj2);
            AndroidRouter.this.logger.c("EXTRA_EXTRA_INFO: {}", intent.getStringExtra("extraInfo"));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean isSameNetworkType(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
            if (networkInfo == null && networkInfo2 == null) {
                return true;
            }
            return (networkInfo == null || networkInfo2 == null || networkInfo.getType() != networkInfo2.getType()) ? false : true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                displayIntentInfo(intent);
                NetworkInfo connectedNetworkInfo = NetworkUtils.getConnectedNetworkInfo(context);
                if (AndroidRouter.this.networkInfo != null && connectedNetworkInfo == null) {
                    for (int i = 1; i <= 3; i++) {
                        try {
                            Thread.sleep(1000L);
                            AndroidRouter.this.logger.m("{} => NONE network transition, waiting for new network... retry #{}", AndroidRouter.this.networkInfo.getTypeName(), Integer.valueOf(i));
                            connectedNetworkInfo = NetworkUtils.getConnectedNetworkInfo(context);
                            if (connectedNetworkInfo != null) {
                                break;
                            }
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
                boolean zIsSameNetworkType = isSameNetworkType(AndroidRouter.this.networkInfo, connectedNetworkInfo);
                AndroidRouter androidRouter = AndroidRouter.this;
                if (zIsSameNetworkType) {
                    androidRouter.logger.info("No actual network change... ignoring event!");
                    return;
                }
                try {
                    androidRouter.onNetworkTypeChange(androidRouter.networkInfo, connectedNetworkInfo);
                } catch (RouterException e) {
                    AndroidRouter.this.handleRouterExceptionOnNetworkTypeChange(e);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AndroidRouter(UpnpServiceConfiguration upnpServiceConfiguration, ProtocolFactory protocolFactory, Context context) {
        super(upnpServiceConfiguration, protocolFactory);
        this.logger = n02.k(AndroidRouter.class);
        this.context = context;
        this.wifiManager = (WifiManager) context.getSystemService("wifi");
        this.networkInfo = NetworkUtils.getConnectedNetworkInfo(context);
        if (ModelUtil.ANDROID_EMULATOR) {
            return;
        }
        BroadcastReceiver broadcastReceiverCreateConnectivityBroadcastReceiver = createConnectivityBroadcastReceiver();
        this.broadcastReceiver = broadcastReceiverCreateConnectivityBroadcastReceiver;
        context.registerReceiver(broadcastReceiverCreateConnectivityBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BroadcastReceiver createConnectivityBroadcastReceiver() {
        return new ConnectivityBroadcastReceiver();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.RouterImpl, org.jupnp.transport.Router
    public boolean disable() {
        lock(this.writeLock);
        try {
            if (isWifi()) {
                setWiFiMulticastLock(false);
                setWifiLock(false);
            }
            boolean zDisable = super.disable();
            unlock(this.writeLock);
            return zDisable;
        } catch (Throwable th) {
            unlock(this.writeLock);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.RouterImpl, org.jupnp.transport.Router
    public boolean enable() {
        lock(this.writeLock);
        try {
            boolean zEnable = super.enable();
            if (zEnable && isWifi()) {
                setWiFiMulticastLock(true);
                setWifiLock(true);
            }
            return zEnable;
        } finally {
            unlock(this.writeLock);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean enableWiFi() {
        this.logger.info("Enabling WiFi...");
        try {
            return this.wifiManager.setWifiEnabled(true);
        } catch (Exception e) {
            this.logger.u("SetWifiEnabled failed", e);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.RouterImpl
    public int getLockTimeoutMillis() {
        return 15000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NetworkInfo getNetworkInfo() {
        return this.networkInfo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void handleRouterExceptionOnNetworkTypeChange(RouterException routerException) {
        boolean z = Exceptions.unwrap(routerException) instanceof InterruptedException;
        j02 j02Var = this.logger;
        if (z) {
            j02Var.t("Router was interrupted", routerException);
        } else {
            j02Var.u("Router error on network change", routerException);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEthernet() {
        return NetworkUtils.isEthernet(this.networkInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isMobile() {
        return NetworkUtils.isMobile(this.networkInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isWifi() {
        return NetworkUtils.isWifi(this.networkInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onNetworkTypeChange(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        this.logger.A("Network type changed {} => {}", networkInfo == null ? "" : networkInfo.getTypeName(), networkInfo2 == null ? "NONE" : networkInfo2.getTypeName());
        if (disable()) {
            this.logger.c("Disabled router on network type change (old network: {})", networkInfo == null ? "NONE" : networkInfo.getTypeName());
        }
        this.networkInfo = networkInfo2;
        if (enable()) {
            this.logger.c("Enabled router on network type change (new network: {})", networkInfo2 != null ? networkInfo2.getTypeName() : "NONE");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWiFiMulticastLock(boolean z) {
        if (this.multicastLock == null) {
            this.multicastLock = this.wifiManager.createMulticastLock(getClass().getSimpleName());
        }
        WifiManager.MulticastLock multicastLock = this.multicastLock;
        if (z) {
            boolean zIsHeld = multicastLock.isHeld();
            j02 j02Var = this.logger;
            if (zIsHeld) {
                j02Var.warn("WiFi multicast lock already acquired");
                return;
            } else {
                j02Var.info("WiFi multicast lock acquired");
                this.multicastLock.acquire();
                return;
            }
        }
        boolean zIsHeld2 = multicastLock.isHeld();
        j02 j02Var2 = this.logger;
        if (!zIsHeld2) {
            j02Var2.warn("WiFi multicast lock already released");
        } else {
            j02Var2.info("WiFi multicast lock released");
            this.multicastLock.release();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWifiLock(boolean z) {
        if (this.wifiLock == null) {
            this.wifiLock = this.wifiManager.createWifiLock(3, getClass().getSimpleName());
        }
        WifiManager.WifiLock wifiLock = this.wifiLock;
        if (z) {
            boolean zIsHeld = wifiLock.isHeld();
            j02 j02Var = this.logger;
            if (zIsHeld) {
                j02Var.warn("WiFi lock already acquired");
                return;
            } else {
                j02Var.info("WiFi lock acquired");
                this.wifiLock.acquire();
                return;
            }
        }
        boolean zIsHeld2 = wifiLock.isHeld();
        j02 j02Var2 = this.logger;
        if (!zIsHeld2) {
            j02Var2.warn("WiFi lock already released");
        } else {
            j02Var2.info("WiFi lock released");
            this.wifiLock.release();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.transport.RouterImpl, org.jupnp.transport.Router
    public void shutdown() {
        super.shutdown();
        unregisterBroadcastReceiver();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void unregisterBroadcastReceiver() {
        BroadcastReceiver broadcastReceiver = this.broadcastReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
            this.broadcastReceiver = null;
        }
    }
}
