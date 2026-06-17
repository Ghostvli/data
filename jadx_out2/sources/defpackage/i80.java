package defpackage;

import android.os.Build;
import defpackage.y94;
import defpackage.z53;
import java.util.concurrent.ExecutorService;
import org.jupnp.android.AndroidUpnpServiceConfiguration;
import org.jupnp.model.ServerClientTokens;
import org.jupnp.transport.spi.NetworkAddressFactory;
import org.jupnp.transport.spi.StreamClient;
import org.jupnp.transport.spi.StreamServer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i80 extends AndroidUpnpServiceConfiguration {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends z53.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(ExecutorService executorService) {
            super(executorService);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.jupnp.transport.spi.AbstractStreamClientConfiguration, org.jupnp.transport.spi.StreamClientConfiguration
        public String getUserAgentValue(int i, int i2) {
            ServerClientTokens serverClientTokens = new ServerClientTokens(i, i2);
            serverClientTokens.setOsVersion(Build.VERSION.RELEASE);
            serverClientTokens.setOsName("Android");
            return serverClientTokens.toString();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.android.AndroidUpnpServiceConfiguration, org.jupnp.DefaultUpnpServiceConfiguration, org.jupnp.UpnpServiceConfiguration
    public StreamClient createStreamClient() {
        return new z53(new a(getSyncProtocolExecutorService()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.android.AndroidUpnpServiceConfiguration, org.jupnp.DefaultUpnpServiceConfiguration, org.jupnp.UpnpServiceConfiguration
    public StreamServer createStreamServer(NetworkAddressFactory networkAddressFactory) {
        return new y94(new y94.a(networkAddressFactory.getStreamListenPort()));
    }
}
