package defpackage;

import android.view.View;
import com.bumptech.glide.a;
import com.fongmi.android.tv.bean.Vod;
import defpackage.y55;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class u75 extends gj {
    public final y4 A;
    public final y55.a z;

    public u75(y4 y4Var, y55.a aVar) {
        super(y4Var.getRoot());
        this.A = y4Var;
        this.z = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(Vod vod, View view) {
        this.z.a(vod);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean S(Vod vod, View view) {
        return this.z.D(vod);
    }

    @Override // defpackage.gj
    public void N(final Vod vod) {
        this.A.c.setText(vod.getName());
        this.A.c.setVisibility(vod.getNameVisible());
        this.A.getRoot().setOnClickListener(new View.OnClickListener() { // from class: s75
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.R(vod, view);
            }
        });
        this.A.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: t75
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

    public u75 T(int[] iArr) {
        this.A.b.getLayoutParams().width = iArr[0];
        this.A.b.getLayoutParams().height = iArr[1];
        return this;
    }
}
