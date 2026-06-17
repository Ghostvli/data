package com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.google.zxing.DecodeHintType;
import com.google.zxing.client.android.R;
import defpackage.eb0;
import defpackage.jb0;
import defpackage.kb0;
import defpackage.ly4;
import defpackage.mb0;
import defpackage.rg;
import defpackage.sg;
import defpackage.ze0;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BarcodeView extends com.journeyapps.barcodescanner.a {
    public b G;
    public rg H;
    public mb0 I;
    public jb0 J;
    public Handler K;
    public final Handler.Callback L;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Handler.Callback {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == R.id.zxing_decode_succeeded) {
                sg sgVar = (sg) message.obj;
                if (sgVar != null && BarcodeView.this.H != null && BarcodeView.this.G != b.NONE) {
                    BarcodeView.this.H.R0(sgVar);
                    if (BarcodeView.this.G == b.SINGLE) {
                        BarcodeView.this.M();
                    }
                }
                return true;
            }
            if (i == R.id.zxing_decode_failed) {
                return true;
            }
            if (i != R.id.zxing_possible_result_points) {
                return false;
            }
            List list = (List) message.obj;
            if (BarcodeView.this.H != null && BarcodeView.this.G != b.NONE) {
                BarcodeView.this.H.X(list);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum b {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public BarcodeView(Context context) {
        super(context);
        this.G = b.NONE;
        this.H = null;
        this.L = new a();
        J();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final eb0 G() {
        if (this.J == null) {
            this.J = H();
        }
        kb0 kb0Var = new kb0();
        HashMap map = new HashMap();
        map.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, kb0Var);
        eb0 eb0VarA = this.J.a(map);
        kb0Var.a(eb0VarA);
        return eb0VarA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jb0 H() {
        return new ze0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(rg rgVar) {
        this.G = b.SINGLE;
        this.H = rgVar;
        K();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J() {
        this.J = new ze0();
        this.K = new Handler(this.L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K() {
        L();
        if (this.G == b.NONE || !t()) {
            return;
        }
        mb0 mb0Var = new mb0(getCameraInstance(), G(), this.K);
        this.I = mb0Var;
        mb0Var.i(getPreviewFramingRect());
        this.I.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L() {
        mb0 mb0Var = this.I;
        if (mb0Var != null) {
            mb0Var.l();
            this.I = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M() {
        this.G = b.NONE;
        this.H = null;
        L();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jb0 getDecoderFactory() {
        return this.J;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDecoderFactory(jb0 jb0Var) {
        ly4.a();
        this.J = jb0Var;
        mb0 mb0Var = this.I;
        if (mb0Var != null) {
            mb0Var.j(G());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.journeyapps.barcodescanner.a
    public void u() {
        L();
        super.u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.journeyapps.barcodescanner.a
    public void x() {
        super.x();
        K();
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = b.NONE;
        this.H = null;
        this.L = new a();
        J();
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = b.NONE;
        this.H = null;
        this.L = new a();
        J();
    }
}
