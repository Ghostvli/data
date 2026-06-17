package defpackage;

import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class py1 implements Consumer {
    public final /* synthetic */ ry1 a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [ry1.t(com.fongmi.android.tv.bean.Channel):void, ry1.u(com.fongmi.android.tv.bean.Channel, com.fongmi.android.tv.bean.EpgData):void] */
    public /* synthetic */ py1(ry1 ry1Var) {
        this.a = ry1Var;
    }

    /* JADX DEBUG: Class process forced to load method for inline: ry1.p(ry1, java.lang.Throwable):void */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.a.w((Throwable) obj);
    }
}
