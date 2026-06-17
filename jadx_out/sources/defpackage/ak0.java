package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.bean.Device;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ak0 extends rh {
    public final a e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void A(Device device);

        boolean z(Device device);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends RecyclerView.g0 {
        public final d4 z;

        public b(d4 d4Var) {
            super(d4Var.getRoot());
            this.z = d4Var;
        }
    }

    public ak0(a aVar) {
        this.e = aVar;
    }

    public final int a0(Device device) {
        return device.isMobile() ? fl3.c : fl3.d;
    }

    public final /* synthetic */ void b0(Device device, View view) {
        this.e.A(device);
    }

    public final /* synthetic */ boolean c0(Device device, View view) {
        return this.e.z(device);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void v(b bVar, int i) {
        final Device device = (Device) M(i);
        bVar.z.c.setText(device.getName());
        bVar.z.b.setText(device.getHost());
        bVar.z.d.setImageResource(a0(device));
        bVar.z.getRoot().setOnClickListener(new View.OnClickListener() { // from class: yj0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.b0(device, view);
            }
        });
        bVar.z.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: zj0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.c0(device, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b x(ViewGroup viewGroup, int i) {
        return new b(d4.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }
}
