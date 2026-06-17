package defpackage;

import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.CastVideo;
import com.fongmi.android.tv.bean.Device;
import java.util.Locale;
import java.util.Objects;
import org.jupnp.controlpoint.ControlPoint;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.meta.RemoteService;
import org.jupnp.model.meta.Service;
import org.jupnp.support.avtransport.callback.Play;
import org.jupnp.support.avtransport.callback.Seek;
import org.jupnp.support.avtransport.callback.SetAVTransportURI;
import org.jupnp.support.contentdirectory.DIDLParser;
import org.jupnp.support.model.DIDLContent;
import org.jupnp.support.model.DIDLObject;
import org.jupnp.support.model.ProtocolInfo;
import org.jupnp.support.model.Res;
import org.jupnp.support.model.SeekMode;
import org.jupnp.support.model.item.VideoItem;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class x70 extends to3 {
    public final CastVideo a;
    public final Runnable b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends SetAVTransportURI {
        public final /* synthetic */ ControlPoint f;
        public final /* synthetic */ RemoteService g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Service service, String str, String str2, ControlPoint controlPoint, RemoteService remoteService) {
            super((Service<?, ?>) service, str, str2);
            this.f = controlPoint;
            this.g = remoteService;
        }

        @Override // org.jupnp.controlpoint.ActionCallback
        public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, final String str) {
            App.d(new Runnable() { // from class: w70
                @Override // java.lang.Runnable
                public final void run() {
                    i43.i(str);
                }
            });
        }

        @Override // org.jupnp.support.avtransport.callback.SetAVTransportURI, org.jupnp.controlpoint.ActionCallback
        public void success(ActionInvocation actionInvocation) {
            ControlPoint controlPoint = this.f;
            controlPoint.execute(x70.this.k(controlPoint, this.g));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends Play {
        public final /* synthetic */ ControlPoint f;
        public final /* synthetic */ RemoteService g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Service service, ControlPoint controlPoint, RemoteService remoteService) {
            super(service);
            this.f = controlPoint;
            this.g = remoteService;
        }

        @Override // org.jupnp.controlpoint.ActionCallback
        public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, final String str) {
            App.d(new Runnable() { // from class: y70
                @Override // java.lang.Runnable
                public final void run() {
                    i43.i(str);
                }
            });
        }

        @Override // org.jupnp.support.avtransport.callback.Play, org.jupnp.controlpoint.ActionCallback
        public void success(ActionInvocation actionInvocation) {
            if (x70.this.a.position() > 0) {
                this.f.execute(x70.this.l(this.g));
            }
            App.d(x70.this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends Seek {
        public c(Service service, SeekMode seekMode, String str) {
            super((Service<?, ?>) service, seekMode, str);
        }

        @Override // org.jupnp.controlpoint.ActionCallback
        public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, String str) {
        }

        @Override // org.jupnp.support.avtransport.callback.Seek, org.jupnp.controlpoint.ActionCallback
        public void success(ActionInvocation actionInvocation) {
        }
    }

    public x70(CastVideo castVideo, Runnable runnable) {
        this.a = castVideo;
        this.b = runnable;
    }

    private /* synthetic */ boolean b(Object obj) {
        if (!(obj instanceof x70)) {
            return false;
        }
        x70 x70Var = (x70) obj;
        return Objects.equals(this.a, x70Var.a) && Objects.equals(this.b, x70Var.b);
    }

    private /* synthetic */ Object[] c() {
        return new Object[]{this.a, this.b};
    }

    public final boolean equals(Object obj) {
        return b(obj);
    }

    public final String h() {
        try {
            DIDLContent dIDLContent = new DIDLContent();
            VideoItem videoItem = new VideoItem("0", "-1", this.a.name(), "", new Res(new ProtocolInfo("http-get:*:video/*:*"), (Long) 0L, this.a.url()));
            if (!this.a.headers().isEmpty()) {
                videoItem.addProperty(new DIDLObject.Property.DC.DESCRIPTION(App.c().toJson(this.a.headers())));
            }
            dIDLContent.addItem(videoItem);
            return new DIDLParser().generate(dIDLContent);
        } catch (Exception unused) {
            return "";
        }
    }

    public final int hashCode() {
        return v70.a(this.a, this.b);
    }

    public void i(Device device) {
        e80 e80VarH = e80.h();
        ControlPoint controlPointI = e80VarH.i();
        RemoteService remoteServiceF = e80VarH.f(device);
        if (remoteServiceF == null || controlPointI == null) {
            App.d(new Runnable() { // from class: u70
                @Override // java.lang.Runnable
                public final void run() {
                    i43.h(sm3.p);
                }
            });
        } else {
            controlPointI.execute(m(controlPointI, remoteServiceF));
        }
    }

    public final String j(long j) {
        if (j <= 0) {
            return "00:00:00";
        }
        long j2 = j / 1000;
        return String.format(Locale.US, "%02d:%02d:%02d", Long.valueOf(j2 / 3600), Long.valueOf((j2 % 3600) / 60), Long.valueOf(j2 % 60));
    }

    public final Play k(ControlPoint controlPoint, RemoteService remoteService) {
        return new b(remoteService, controlPoint, remoteService);
    }

    public final Seek l(RemoteService remoteService) {
        return new c(remoteService, SeekMode.REL_TIME, j(this.a.position()));
    }

    public final SetAVTransportURI m(ControlPoint controlPoint, RemoteService remoteService) {
        return new a(remoteService, this.a.url(), h(), controlPoint, remoteService);
    }

    public final String toString() {
        return yq.a(c(), x70.class, "a;b");
    }
}
