package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.DecodeFormatManager;
import com.google.zxing.client.android.DecodeHintManager;
import com.google.zxing.client.android.Intents;
import com.google.zxing.client.android.R;
import defpackage.jb0;
import defpackage.jl;
import defpackage.jp;
import defpackage.rg;
import defpackage.sg;
import defpackage.ze0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DecoratedBarcodeView extends FrameLayout {
    public BarcodeView f;
    public ViewfinderView g;
    public TextView h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements rg {
        public rg f;

        public b(rg rgVar) {
            this.f = rgVar;
        }

        @Override // defpackage.rg
        public void R0(sg sgVar) {
            this.f.R0(sgVar);
        }

        @Override // defpackage.rg
        public void X(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DecoratedBarcodeView.this.g.a((ResultPoint) it.next());
            }
            this.f.X(list);
        }
    }

    public DecoratedBarcodeView(Context context) {
        super(context);
        c();
    }

    public void b(rg rgVar) {
        this.f.I(new b(rgVar));
    }

    public final void c() {
        d(null);
    }

    public final void d(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_view);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.zxing_view_zxing_scanner_layout, R.layout.zxing_barcode_scanner);
        typedArrayObtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(R.id.zxing_barcode_surface);
        this.f = barcodeView;
        if (barcodeView == null) {
            jl.a("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
            return;
        }
        barcodeView.q(attributeSet);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.g = viewfinderView;
        if (viewfinderView == null) {
            jl.a("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        } else {
            viewfinderView.setCameraPreview(this.f);
            this.h = (TextView) findViewById(R.id.zxing_status_view);
        }
    }

    public void e(Intent intent) {
        int intExtra;
        Set<BarcodeFormat> decodeFormats = DecodeFormatManager.parseDecodeFormats(intent);
        Map<DecodeHintType, ?> decodeHints = DecodeHintManager.parseDecodeHints(intent);
        jp jpVar = new jp();
        if (intent.hasExtra(Intents.Scan.CAMERA_ID) && (intExtra = intent.getIntExtra(Intents.Scan.CAMERA_ID, -1)) >= 0) {
            jpVar.i(intExtra);
        }
        if (intent.hasExtra(Intents.Scan.TORCH_ENABLED) && intent.getBooleanExtra(Intents.Scan.TORCH_ENABLED, false)) {
            j();
        }
        String stringExtra = intent.getStringExtra(Intents.Scan.PROMPT_MESSAGE);
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        int intExtra2 = intent.getIntExtra(Intents.Scan.SCAN_TYPE, 0);
        String stringExtra2 = intent.getStringExtra(Intents.Scan.CHARACTER_SET);
        new MultiFormatReader().setHints(decodeHints);
        this.f.setCameraSettings(jpVar);
        this.f.setDecoderFactory(new ze0(decodeFormats, decodeHints, stringExtra2, intExtra2));
    }

    public void f() {
        this.f.u();
    }

    public void g() {
        this.f.v();
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(R.id.zxing_barcode_surface);
    }

    public jp getCameraSettings() {
        return this.f.getCameraSettings();
    }

    public jb0 getDecoderFactory() {
        return this.f.getDecoderFactory();
    }

    public TextView getStatusView() {
        return this.h;
    }

    public ViewfinderView getViewFinder() {
        return this.g;
    }

    public void h() {
        this.f.y();
    }

    public void i() {
        this.f.setTorch(false);
    }

    public void j() {
        this.f.setTorch(true);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            j();
            return true;
        }
        if (i == 25) {
            i();
            return true;
        }
        if (i == 27 || i == 80) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void setCameraSettings(jp jpVar) {
        this.f.setCameraSettings(jpVar);
    }

    public void setDecoderFactory(jb0 jb0Var) {
        this.f.setDecoderFactory(jb0Var);
    }

    public void setStatusText(String str) {
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(attributeSet);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(attributeSet);
    }
}
