package com.fongmi.android.tv.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import defpackage.q45;
import defpackage.v35;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ProgressLayout extends RelativeLayout {
    public List f;
    public View g;
    public View h;
    public a i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        CONTENT,
        PROGRESS,
        EMPTY
    }

    public ProgressLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private void setContentVisibility(boolean z) {
        for (View view : this.f) {
            if (z) {
                i(view);
            } else {
                a(view);
            }
        }
    }

    public final void a(View view) {
        view.setVisibility(4);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getTag() == null || !view.getTag().equals("ProgressLayout.TAG_PROGRESS")) {
            this.f.add(view);
        }
    }

    public final void b() {
        this.i = a.CONTENT;
        this.f = new ArrayList();
        c();
    }

    public final void c() {
        LinearLayoutCompat root = v35.c(LayoutInflater.from(getContext())).getRoot();
        this.h = root;
        root.setTag("ProgressLayout.TAG_PROGRESS");
        this.h.setVisibility(8);
        FrameLayout root2 = q45.c(LayoutInflater.from(getContext())).getRoot();
        this.g = root2;
        root2.setTag("ProgressLayout.TAG_PROGRESS");
        this.g.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.g, layoutParams);
        addView(this.h, layoutParams);
    }

    public boolean d() {
        return this.i == a.EMPTY;
    }

    public void e() {
        j(a.CONTENT);
    }

    public void f(boolean z, int i) {
        if (z && i == 0) {
            g();
        } else {
            e();
        }
    }

    public void g() {
        j(a.EMPTY);
    }

    public void h() {
        j(a.PROGRESS);
    }

    public final void i(View view) {
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(100L);
    }

    public void j(a aVar) {
        if (this.i == aVar) {
            return;
        }
        this.i = aVar;
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            this.h.setVisibility(8);
            this.g.setVisibility(8);
            setContentVisibility(true);
        } else if (iOrdinal == 1) {
            this.h.setVisibility(8);
            this.g.setVisibility(0);
            setContentVisibility(false);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.h.setVisibility(0);
            this.g.setVisibility(8);
            setContentVisibility(false);
        }
    }

    public ProgressLayout(Context context) {
        super(context);
    }

    public ProgressLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }
}
