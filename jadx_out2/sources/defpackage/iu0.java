package defpackage;

import android.view.View;
import com.fongmi.android.tv.bean.Episode;
import defpackage.au0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class iu0 extends th {
    public final g4 A;
    public final int B;
    public final au0.a z;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public iu0(g4 g4Var, au0.a aVar) {
        super(g4Var.getRoot());
        this.A = g4Var;
        this.z = aVar;
        this.B = vr3.j() - vr3.a(32);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(Episode episode, View view) {
        this.z.E(episode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.th
    public void N(final Episode episode) {
        this.A.b.setMaxWidth(this.B);
        this.A.b.setSelected(episode.isSelected());
        this.A.b.setActivated(episode.isActivated());
        this.A.b.setText(episode.getDesc().concat(episode.getName()));
        this.A.b.setOnClickListener(new View.OnClickListener() { // from class: hu0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.P(episode, view);
            }
        });
    }
}
