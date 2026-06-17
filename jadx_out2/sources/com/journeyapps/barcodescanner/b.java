package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.client.android.BeepManager;
import com.google.zxing.client.android.InactivityTimer;
import com.google.zxing.client.android.Intents;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.a;
import com.journeyapps.barcodescanner.b;
import defpackage.a3;
import defpackage.c30;
import defpackage.rg;
import defpackage.sg;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final String o = "b";
    public static int p = 250;
    public Activity a;
    public DecoratedBarcodeView b;
    public InactivityTimer h;
    public BeepManager i;
    public Handler j;
    public final a.f m;
    public boolean n;
    public int c = -1;
    public boolean d = false;
    public boolean e = true;
    public String f = "";
    public boolean g = false;
    public boolean k = false;
    public rg l = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements rg {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.rg
        public void R0(final sg sgVar) {
            b.this.b.f();
            b.this.i.playBeepSoundAndVibrate();
            b.this.j.post(new Runnable() { // from class: hq
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.y(sgVar);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.rg
        public void X(List list) {
        }
    }

    /* JADX INFO: renamed from: com.journeyapps.barcodescanner.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class C0073b implements a.f {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0073b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.journeyapps.barcodescanner.a.f
        public void a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.journeyapps.barcodescanner.a.f
        public void b(Exception exc) {
            b bVar = b.this;
            bVar.m(bVar.a.getString(R.string.zxing_msg_camera_framework_bug));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.journeyapps.barcodescanner.a.f
        public void c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.journeyapps.barcodescanner.a.f
        public void d() {
            if (b.this.k) {
                Log.d(b.o, "Camera closed; finishing activity");
                b.this.n();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.journeyapps.barcodescanner.a.f
        public void e() {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        C0073b c0073b = new C0073b();
        this.m = c0073b;
        this.n = false;
        this.a = activity;
        this.b = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().i(c0073b);
        this.j = new Handler();
        this.h = new InactivityTimer(activity, new Runnable() { // from class: dq
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                b.c(this.f);
            }
        });
        this.i = new BeepManager(activity);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void c(b bVar) {
        bVar.getClass();
        Log.d(o, "Finishing due to inactivity");
        bVar.n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Intent x(sg sgVar, String str) {
        Intent intent = new Intent(Intents.Scan.ACTION);
        intent.addFlags(524288);
        intent.putExtra(Intents.Scan.RESULT, sgVar.toString());
        intent.putExtra(Intents.Scan.RESULT_FORMAT, sgVar.a().toString());
        byte[] bArrC = sgVar.c();
        if (bArrC != null && bArrC.length > 0) {
            intent.putExtra(Intents.Scan.RESULT_BYTES, bArrC);
        }
        Map mapD = sgVar.d();
        if (mapD != null) {
            ResultMetadataType resultMetadataType = ResultMetadataType.UPC_EAN_EXTENSION;
            if (mapD.containsKey(resultMetadataType)) {
                intent.putExtra(Intents.Scan.RESULT_UPC_EAN_EXTENSION, mapD.get(resultMetadataType).toString());
            }
            Number number = (Number) mapD.get(ResultMetadataType.ORIENTATION);
            if (number != null) {
                intent.putExtra(Intents.Scan.RESULT_ORIENTATION, number.intValue());
            }
            String str2 = (String) mapD.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra(Intents.Scan.RESULT_ERROR_CORRECTION_LEVEL, str2);
            }
            Iterable iterable = (Iterable) mapD.get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                Iterator it = iterable.iterator();
                int i = 0;
                while (it.hasNext()) {
                    intent.putExtra(Intents.Scan.RESULT_BYTE_SEGMENTS_PREFIX + i, (byte[]) it.next());
                    i++;
                }
            }
        }
        if (str != null) {
            intent.putExtra(Intents.Scan.RESULT_BARCODE_IMAGE_PATH, str);
        }
        return intent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void A() {
        Intent intent = new Intent(Intents.Scan.ACTION);
        intent.putExtra(Intents.Scan.MISSING_CAMERA_PERMISSION, true);
        this.a.setResult(0, intent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B(boolean z, String str) {
        this.e = z;
        if (str == null) {
            str = "";
        }
        this.f = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k() {
        if (this.b.getBarcodeView().s()) {
            n();
        } else {
            this.k = true;
        }
        this.b.f();
        this.h.cancel();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l() {
        this.b.b(this.l);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(String str) {
        if (this.a.isFinishing() || this.g || this.k) {
            return;
        }
        if (str.isEmpty()) {
            str = this.a.getString(R.string.zxing_msg_camera_framework_bug);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getString(R.string.zxing_app_name));
        builder.setMessage(str);
        builder.setPositiveButton(R.string.zxing_button_ok, new DialogInterface.OnClickListener() { // from class: fq
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.n();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: gq
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f.n();
            }
        });
        builder.show();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n() {
        this.a.finish();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String o(sg sgVar) {
        if (!this.d) {
            return null;
        }
        Bitmap bitmapB = sgVar.b();
        try {
            File fileCreateTempFile = File.createTempFile("barcodeimage", ".jpg", this.a.getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            bitmapB.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            return fileCreateTempFile.getAbsolutePath();
        } catch (IOException e) {
            Log.w(o, "Unable to create temporary file and store bitmap! " + e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p(Intent intent, Bundle bundle) {
        this.a.getWindow().addFlags(128);
        if (bundle != null) {
            this.c = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra(Intents.Scan.ORIENTATION_LOCKED, true)) {
                q();
            }
            if (Intents.Scan.ACTION.equals(intent.getAction())) {
                this.b.e(intent);
            }
            if (!intent.getBooleanExtra(Intents.Scan.BEEP_ENABLED, true)) {
                this.i.setBeepEnabled(false);
            }
            if (intent.hasExtra(Intents.Scan.SHOW_MISSING_CAMERA_PERMISSION_DIALOG)) {
                B(intent.getBooleanExtra(Intents.Scan.SHOW_MISSING_CAMERA_PERMISSION_DIALOG, true), intent.getStringExtra(Intents.Scan.MISSING_CAMERA_PERMISSION_DIALOG_MESSAGE));
            }
            if (intent.hasExtra(Intents.Scan.TIMEOUT)) {
                this.j.postDelayed(new Runnable() { // from class: eq
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.z();
                    }
                }, intent.getLongExtra(Intents.Scan.TIMEOUT, 0L));
            }
            if (intent.getBooleanExtra(Intents.Scan.BARCODE_IMAGE_ENABLED, false)) {
                this.d = true;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q() {
        if (this.c == -1) {
            int rotation = this.a.getWindowManager().getDefaultDisplay().getRotation();
            int i = this.a.getResources().getConfiguration().orientation;
            int i2 = 0;
            if (i == 2) {
                if (rotation != 0 && rotation != 1) {
                    i2 = 8;
                }
            } else if (i == 1) {
                i2 = (rotation == 0 || rotation == 3) ? 1 : 9;
            }
            this.c = i2;
        }
        this.a.setRequestedOrientation(this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r() {
        this.g = true;
        this.h.cancel();
        this.j.removeCallbacksAndMessages(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s() {
        this.h.cancel();
        this.b.g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t(int i, String[] strArr, int[] iArr) {
        if (i == p) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.b.h();
                return;
            }
            A();
            if (this.e) {
                m(this.f);
            } else {
                k();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u() {
        w();
        this.h.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v(Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void w() {
        if (c30.a(this.a, "android.permission.CAMERA") == 0) {
            this.b.h();
        } else {
            if (this.n) {
                return;
            }
            a3.p(this.a, new String[]{"android.permission.CAMERA"}, p);
            this.n = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void y(sg sgVar) {
        this.a.setResult(-1, x(sgVar, o(sgVar)));
        k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z() {
        Intent intent = new Intent(Intents.Scan.ACTION);
        intent.putExtra(Intents.Scan.TIMEOUT, true);
        this.a.setResult(0, intent);
        k();
    }
}
