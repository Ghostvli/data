package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Device;
import com.fongmi.android.tv.service.DLNACastService;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.jupnp.android.AndroidUpnpService;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.model.message.header.STAllHeader;
import org.jupnp.model.meta.RemoteDevice;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.types.UDADeviceType;
import org.jupnp.model.types.UDAServiceType;
import org.jupnp.registry.DefaultRegistryListener;
import org.jupnp.registry.Registry;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class e80 extends DefaultRegistryListener implements ServiceConnection {
    public static final UDADeviceType h = new UDADeviceType("MediaRenderer", 1);
    public static final UDAServiceType i = new UDAServiceType("AVTransport", 1);
    public AndroidUpnpService f;
    public a g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void g(Device device);

        void p(Device device);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static final e80 a = new e80();
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CHECK_CAST (org.jupnp.model.meta.RemoteDevice) (r0v0 org.jupnp.model.meta.Device) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ RemoteDevice a(org.jupnp.model.meta.Device device) {
        return (RemoteDevice) device;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static e80 h() {
        return b.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RemoteService f(Device device) {
        RemoteDevice remoteDeviceG = g(device);
        if (remoteDeviceG != null) {
            return remoteDeviceG.findService(i);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RemoteDevice g(final Device device) {
        AndroidUpnpService androidUpnpService = this.f;
        if (androidUpnpService == null) {
            return null;
        }
        return (RemoteDevice) androidUpnpService.getRegistry().getDevices(h).stream().filter(new Predicate() { // from class: c80
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((org.jupnp.model.meta.Device) obj).getIdentity().getUdn().getIdentifierString().equals(device.getUuid());
            }
        }).map(new Function() { // from class: d80
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return e80.a((org.jupnp.model.meta.Device) obj);
            }
        }).findFirst().orElse(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ControlPoint i() {
        AndroidUpnpService androidUpnpService = this.f;
        if (androidUpnpService != null) {
            return androidUpnpService.getControlPoint();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List j() {
        AndroidUpnpService androidUpnpService = this.f;
        return androidUpnpService == null ? Collections.EMPTY_LIST : (List) androidUpnpService.getRegistry().getDevices(h).stream().map(new Function() { // from class: b80
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Device.get((RemoteDevice) ((org.jupnp.model.meta.Device) obj));
            }
        }).collect(Collectors.toList());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(Context context) {
        context.bindService(new Intent(context, (Class<?>) DLNACastService.class), this, 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void l(Device device) {
        this.g.p(device);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void m(Device device) {
        this.g.g(device);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n(final Device device) {
        if (this.g != null) {
            App.d(new Runnable() { // from class: z70
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.l(device);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(final Device device) {
        if (this.g != null) {
            App.d(new Runnable() { // from class: a80
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.m(device);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AndroidUpnpService androidUpnpService = (AndroidUpnpService) iBinder;
        this.f = androidUpnpService;
        androidUpnpService.getRegistry().addListener(this);
        q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p(Context context) {
        AndroidUpnpService androidUpnpService = this.f;
        if (androidUpnpService == null) {
            return;
        }
        androidUpnpService.getRegistry().removeListener(this);
        context.unbindService(this);
        this.f = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q() {
        AndroidUpnpService androidUpnpService = this.f;
        if (androidUpnpService != null) {
            androidUpnpService.getControlPoint().search(new STAllHeader());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(a aVar) {
        this.g = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.DefaultRegistryListener, org.jupnp.registry.RegistryListener
    public void remoteDeviceAdded(Registry registry, RemoteDevice remoteDevice) {
        if (remoteDevice.getType().implementsVersion(h)) {
            n(Device.get(remoteDevice));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.DefaultRegistryListener, org.jupnp.registry.RegistryListener
    public void remoteDeviceRemoved(Registry registry, RemoteDevice remoteDevice) {
        if (remoteDevice.getType().implementsVersion(h)) {
            o(Device.get(remoteDevice));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.registry.DefaultRegistryListener, org.jupnp.registry.RegistryListener
    public void remoteDeviceUpdated(Registry registry, RemoteDevice remoteDevice) {
    }
}
