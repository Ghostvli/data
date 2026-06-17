package org.jupnp.android;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import org.jupnp.UpnpService;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.UpnpServiceImpl;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.registry.Registry;
import org.jupnp.transport.Router;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AndroidUpnpServiceImpl extends Service {
    protected Binder binder = new Binder();
    protected UpnpService upnpService;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class Binder extends android.os.Binder implements AndroidUpnpService {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Binder() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.android.AndroidUpnpService
        public UpnpService get() {
            return AndroidUpnpServiceImpl.this.upnpService;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.android.AndroidUpnpService
        public UpnpServiceConfiguration getConfiguration() {
            return AndroidUpnpServiceImpl.this.upnpService.getConfiguration();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.android.AndroidUpnpService
        public ControlPoint getControlPoint() {
            return AndroidUpnpServiceImpl.this.upnpService.getControlPoint();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.android.AndroidUpnpService
        public Registry getRegistry() {
            return AndroidUpnpServiceImpl.this.upnpService.getRegistry();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UpnpServiceConfiguration createConfiguration() {
        return new AndroidUpnpServiceConfiguration();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AndroidRouter createRouter(UpnpServiceConfiguration upnpServiceConfiguration, ProtocolFactory protocolFactory, Context context) {
        return new AndroidRouter(upnpServiceConfiguration, protocolFactory, context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.upnpService = new UpnpServiceImpl(createConfiguration()) { // from class: org.jupnp.android.AndroidUpnpServiceImpl.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.jupnp.UpnpServiceImpl
            public Router createRouter(ProtocolFactory protocolFactory, Registry registry) {
                return AndroidUpnpServiceImpl.this.createRouter(getConfiguration(), protocolFactory, AndroidUpnpServiceImpl.this);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.jupnp.UpnpServiceImpl, org.jupnp.UpnpService
            public synchronized void shutdown() {
                ((AndroidRouter) getRouter()).unregisterBroadcastReceiver();
                super.shutdown(true);
            }
        };
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public void onDestroy() {
        this.upnpService.shutdown();
        super.onDestroy();
    }
}
