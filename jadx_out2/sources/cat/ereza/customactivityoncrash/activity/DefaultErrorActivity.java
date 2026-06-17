package cat.ereza.customactivityoncrash.activity;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import cat.ereza.customactivityoncrash.activity.DefaultErrorActivity;
import defpackage.bq;
import defpackage.c60;
import defpackage.em3;
import defpackage.ll3;
import defpackage.ln3;
import defpackage.ps3;
import defpackage.rm3;
import defpackage.x7;
import defpackage.xm3;
import defpackage.yk3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultErrorActivity extends x7 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void G1(DefaultErrorActivity defaultErrorActivity, bq bqVar, View view) {
        defaultErrorActivity.getClass();
        c60.h(defaultErrorActivity, bqVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void H1(final DefaultErrorActivity defaultErrorActivity, View view) {
        defaultErrorActivity.getClass();
        TextView textView = (TextView) new a.C0002a(defaultErrorActivity).m(rm3.e).f(c60.j(defaultErrorActivity, defaultErrorActivity.getIntent())).setPositiveButton(rm3.b, null).h(rm3.d, new DialogInterface.OnClickListener() { // from class: pf0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.K1();
            }
        }).n().findViewById(R.id.message);
        if (textView != null) {
            textView.setTextSize(0, defaultErrorActivity.getResources().getDimension(yk3.a));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void J1(DefaultErrorActivity defaultErrorActivity, bq bqVar, View view) {
        defaultErrorActivity.getClass();
        c60.B(defaultErrorActivity, bqVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K1() {
        String strJ = c60.j(this, getIntent());
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(getString(rm3.a), strJ));
            Toast.makeText(this, rm3.c, 0).show();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u51, defpackage.iy, defpackage.ky, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(ln3.a);
        if (!typedArrayObtainStyledAttributes.hasValue(ln3.b)) {
            setTheme(xm3.a);
        }
        typedArrayObtainStyledAttributes.recycle();
        setContentView(em3.a);
        Button button = (Button) findViewById(ll3.c);
        final bq bqVarM = c60.m(getIntent());
        if (bqVarM == null) {
            finish();
            return;
        }
        if (!bqVarM.I() || bqVarM.E() == null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: nf0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefaultErrorActivity.G1(this.f, bqVarM, view);
                }
            });
        } else {
            button.setText(rm3.f);
            button.setOnClickListener(new View.OnClickListener() { // from class: mf0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefaultErrorActivity.J1(this.f, bqVarM, view);
                }
            });
        }
        Button button2 = (Button) findViewById(ll3.b);
        if (bqVarM.H()) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: of0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefaultErrorActivity.H1(this.f, view);
                }
            });
        } else {
            button2.setVisibility(8);
        }
        Integer numB = bqVarM.B();
        ImageView imageView = (ImageView) findViewById(ll3.a);
        if (numB != null) {
            imageView.setImageDrawable(ps3.e(getResources(), numB.intValue(), getTheme()));
        }
    }
}
