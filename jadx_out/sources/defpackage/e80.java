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

    public static /* synthetic */ RemoteDevice a(org.jupnp.model.meta.Device device) {
        return (RemoteDevice) device;
    }

    public static e80 h() {
        return b.a;
    }

    public RemoteService f(Device device) {
        RemoteDevice remoteDeviceG = g(device);
        if (remoteDeviceG != null) {
            return remoteDeviceG.findService(i);
        }
        return null;
    }

    public RemoteDevice g(final Device device) {
        AndroidUpnpService androidUpnpService = this.f;
        if (androidUpnpService == null) {
            return null;
        }
        return (RemoteDevice) androidUpnpService.getRegistry().getDevices(h).stream().filter(new Predicate() { // from class: c80
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((org.jupnp.model.meta.Device) obj).getIdentity().getUdn().getIdentifierString().equals(device.getUuid());
            }
        }).map(new Function() { // from class: d80
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return e80.a((org.jupnp.model.meta.Device) obj);
            }
        }).findFirst().orElse(null);
    }

    public ControlPoint i() {
        AndroidUpnpService androidUpnpService = this.f;
        if (androidUpnpService != null) {
            return androidUpnpService.getControlPoint();
        }
        return null;
    }

    public List j() {
        AndroidUpnpService androidUpnpService = this.f;
        return androidUpnpService == null ? Collections.EMPTY_LIST : (List) androidUpnpService.getRegistry().getDevices(h).stream().map(new Function() { // from class: b80
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Device.get((RemoteDevice) ((org.jupnp.model.meta.Device) obj));
            }
        }).collect(Collectors.toList());
    }

    public void k(Context context) {
        context.bindService(new Intent(context, (Class<?>) DLNACastService.class), this, 1);
    }

    public final /* synthetic */ void l(Device device) {
        this.g.p(device);
    }

    public final /* synthetic */ void m(Device device) {
        this.g.g(device);
    }

    public final void n(final Device device) {
        if (this.g != null) {
            App.d(new Runnable() { // from class: z70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.l(device);
                }
            });
        }
    }

    public final void o(final Device device) {
        if (this.g != null) {
            App.d(new Runnable() { // from class: a80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.m(device);
                }
            });
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AndroidUpnpService androidUpnpService = (AndroidUpnpService) iBinder;
        this.f = androidUpnpService;
        androidUpnpService.getRegistry().addListener(this);
        q();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f = null;
    }

    public void p(Context context) {
        AndroidUpnpService androidUpnpService = this.f;
        if (androidUpnpService == null) {
            return;
        }
        androidUpnpService.getRegistry().removeListener(this);
        context.unbindService(this);
        this.f = null;
    }

    public void q() {
        AndroidUpnpService androidUpnpService = this.f;
        if (androidUpnpService != null) {
            androidUpnpService.getControlPoint().search(new STAllHeader());
        }
    }

    public void r(a aVar) {
        this.g = aVar;
    }

    @Override // org.jupnp.registry.DefaultRegistryListener, org.jupnp.registry.RegistryListener
    public void remoteDeviceAdded(Registry registry, RemoteDevice remoteDevice) {
        if (remoteDevice.getType().implementsVersion(h)) {
            n(Device.get(remoteDevice));
        }
    }

    @Override // org.jupnp.registry.DefaultRegistryListener, org.jupnp.registry.RegistryListener
    public void remoteDeviceRemoved(Registry registry, RemoteDevice remoteDevice) {
        if (remoteDevice.getType().implementsVersion(h)) {
            o(Device.get(remoteDevice));
        }
    }

    @Override // org.jupnp.registry.DefaultRegistryListener, org.jupnp.registry.RegistryListener
    public void remoteDeviceUpdated(Registry registry, RemoteDevice remoteDevice) {
    }
}
