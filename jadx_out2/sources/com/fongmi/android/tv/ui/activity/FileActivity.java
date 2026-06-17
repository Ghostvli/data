package com.fongmi.android.tv.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.github.catvod.utils.Path;
import defpackage.c3;
import defpackage.f01;
import defpackage.i35;
import defpackage.ta3;
import defpackage.xg;
import java.io.File;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class FileActivity extends xg implements f01.a {
    public c3 H;
    public f01 I;
    public File J;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void X1() {
        this.H.c.setHasFixedSize(true);
        RecyclerView recyclerView = this.H.c;
        f01 f01Var = new f01(this);
        this.I = f01Var;
        recyclerView.setAdapter(f01Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.x7
    public void D1(Toolbar toolbar) {
        super.D1(toolbar);
        u1().r(true);
        setTitle("");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public i35 J1() {
        c3 c3VarC = c3.c(getLayoutInflater());
        this.H = c3VarC;
        return c3VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public void L1(Bundle bundle) {
        D1(this.H.e);
        X1();
        U1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xg
    public void P1() {
        if (V1()) {
            super.P1();
        } else {
            Y1(this.J.getParentFile());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void U1() {
        ta3.b(this, new Consumer() { // from class: d01
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.W1((Boolean) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean V1() {
        return Path.root().equals(this.J);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void W1(Boolean bool) {
        Y1(Path.root());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y1(File file) {
        this.H.c.t1(0);
        f01 f01Var = this.I;
        this.J = file;
        f01Var.H(Path.list(file));
        this.H.d.setText(file.getAbsolutePath());
        this.H.b.f(true, this.I.g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            P1();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // f01.a
    public void s(File file) {
        if (file.isDirectory()) {
            Y1(file);
        } else {
            setResult(-1, new Intent().setData(Uri.fromFile(file)));
            finish();
        }
    }
}
