package com.fongmi.android.tv.ui.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.a;
import com.github.catvod.utils.Prefers;
import defpackage.b3;
import defpackage.bq;
import defpackage.c60;
import defpackage.i35;
import defpackage.o01;
import defpackage.sm3;
import defpackage.xg;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class CrashActivity extends xg {
    public b3 H;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(View view) {
        b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(View view) {
        bq bqVarM = c60.m(getIntent());
        Objects.requireNonNull(bqVarM);
        c60.B(this, bqVarM);
    }

    @Override // defpackage.xg
    public boolean G1() {
        return false;
    }

    @Override // defpackage.xg
    public i35 J1() {
        b3 b3VarC = b3.c(getLayoutInflater());
        this.H = b3VarC;
        return b3VarC;
    }

    @Override // defpackage.xg
    public void K1() {
        this.H.b.setOnClickListener(new View.OnClickListener() { // from class: a50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.W1(view);
            }
        });
        this.H.c.setOnClickListener(new View.OnClickListener() { // from class: b50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.X1(view);
            }
        });
    }

    public final /* synthetic */ void Y1(String str, DialogInterface dialogInterface, int i) {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("crash", str));
        Toast.makeText(this, "已复制", 0).show();
    }

    public final void Z1() {
        try {
            o01.g(this, c60.j(this, getIntent()));
        } catch (Exception unused) {
        }
    }

    public final void a2() {
        String strI = c60.i(getIntent());
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        String[] strArrSplit = strI.split("\n");
        for (int length = strArrSplit.length - 1; length >= 0; length--) {
            if (!strArrSplit[length].isEmpty() && strArrSplit[length].contains(HomeActivity.class.getSimpleName())) {
                Prefers.put("crash", Boolean.TRUE);
                return;
            }
        }
    }

    public final void b2() {
        final String strJ = c60.j(this, getIntent());
        new a.C0002a(this).m(sm3.g).f(strJ).setPositiveButton(sm3.f, null).i("复制", new DialogInterface.OnClickListener() { // from class: c50
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.Y1(strJ, dialogInterface, i);
            }
        }).n();
    }

    @Override // defpackage.xg, defpackage.u51, defpackage.iy, defpackage.ky, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Z1();
        a2();
    }
}
