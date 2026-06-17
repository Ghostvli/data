package defpackage;

import android.view.View;
import com.bumptech.glide.a;
import com.fongmi.android.tv.bean.Vod;
import defpackage.y55;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class r75 extends gj {
    public final x4 A;
    public final y55.a z;

    public r75(x4 x4Var, y55.a aVar) {
        super(x4Var.getRoot());
        this.A = x4Var;
        this.z = aVar;
    }

    @Override // defpackage.gj
    public void N(final Vod vod) {
        this.A.c.setText(vod.getName());
        this.A.d.setText(vod.getRemarks());
        this.A.c.setVisibility(vod.getNameVisible());
        this.A.d.setVisibility(vod.getRemarkVisible());
        this.A.getRoot().setOnClickListener(new View.OnClickListener() { // from class: p75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.R(vod, view);
            }
        });
        this.A.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: q75
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.S(vod, view);
            }
        });
        si1.h(vod.getName(), vod.getPic(), this.A.b);
    }

    @Override // defpackage.gj
    public void O() {
        a.u(this.A.b).o(this.A.b);
    }

    public final /* synthetic */ void R(Vod vod, View view) {
        this.z.a(vod);
    }

    public final /* synthetic */ boolean S(Vod vod, View view) {
        return this.z.D(vod);
    }
}
