package defpackage;

import androidx.media3.session.r;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hh2 implements Executor {
    public final /* synthetic */ r f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [androidx.media3.session.r.G1(androidx.media3.session.u$g, java.lang.String, int, int, androidx.media3.session.MediaLibraryService$b):lu1, androidx.media3.session.r.H1(androidx.media3.session.u$g, java.lang.String):lu1, androidx.media3.session.r.J1(androidx.media3.session.u$g, java.lang.String, int, int, androidx.media3.session.MediaLibraryService$b):lu1, androidx.media3.session.r.K1(androidx.media3.session.u$g, java.lang.String, androidx.media3.session.MediaLibraryService$b):lu1, androidx.media3.session.r.L1(androidx.media3.session.u$g, java.lang.String, androidx.media3.session.MediaLibraryService$b):lu1, androidx.media3.session.r.M1(androidx.media3.session.u$g, java.lang.String):lu1] */
    public /* synthetic */ hh2(r rVar) {
        this.f = rVar;
    }

    /* JADX DEBUG: Class process forced to load method for inline: androidx.media3.session.r.w1(androidx.media3.session.r, java.lang.Runnable):void */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f.Y0(runnable);
    }
}
