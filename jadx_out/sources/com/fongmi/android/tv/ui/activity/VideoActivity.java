package com.fongmi.android.tv.ui.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.x;
import androidx.media3.session.l;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.CastVideo;
import com.fongmi.android.tv.bean.Danmaku;
import com.fongmi.android.tv.bean.Episode;
import com.fongmi.android.tv.bean.Flag;
import com.fongmi.android.tv.bean.History;
import com.fongmi.android.tv.bean.Keep;
import com.fongmi.android.tv.bean.Parse;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Site;
import com.fongmi.android.tv.bean.Sub;
import com.fongmi.android.tv.bean.Track;
import com.fongmi.android.tv.bean.Vod;
import com.fongmi.android.tv.service.PlaybackService;
import com.fongmi.android.tv.ui.activity.VideoActivity;
import com.fongmi.android.tv.ui.custom.CustomSeekView;
import com.google.android.material.bottomsheet.b;
import com.google.android.material.textview.MaterialTextView;
import defpackage.au0;
import defpackage.b40;
import defpackage.b75;
import defpackage.b94;
import defpackage.bb3;
import defpackage.bt4;
import defpackage.d63;
import defpackage.di4;
import defpackage.dk3;
import defpackage.e35;
import defpackage.el3;
import defpackage.eu0;
import defpackage.f10;
import defpackage.fj3;
import defpackage.fl3;
import defpackage.g01;
import defpackage.gb4;
import defpackage.ge3;
import defpackage.i35;
import defpackage.i43;
import defpackage.ju0;
import defpackage.jy4;
import defpackage.l35;
import defpackage.lh4;
import defpackage.lr;
import defpackage.me3;
import defpackage.n21;
import defpackage.p51;
import defpackage.p60;
import defpackage.ph2;
import defpackage.pj3;
import defpackage.pz4;
import defpackage.q24;
import defpackage.q60;
import defpackage.qo3;
import defpackage.qp3;
import defpackage.rk3;
import defpackage.si1;
import defpackage.sm3;
import defpackage.to4;
import defpackage.u51;
import defpackage.u73;
import defpackage.u94;
import defpackage.uj1;
import defpackage.ul4;
import defpackage.uq;
import defpackage.v3;
import defpackage.v60;
import defpackage.vr3;
import defpackage.w95;
import defpackage.wq;
import defpackage.x43;
import defpackage.x80;
import defpackage.xq4;
import defpackage.yr4;
import defpackage.ys4;
import defpackage.yu;
import defpackage.zb3;
import defpackage.zj3;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.greenrobot.eventbus.ThreadMode;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class VideoActivity extends zb3 implements yu.b, p60.a, xq4.a, b40.a, n21.a, au0.a, fj3.a, pj3.a, u73.a, uq.a, uj1.a {
    public v3 U;
    public ViewGroup.LayoutParams V;
    public x43 W;
    public x43 X;
    public x43 Y;
    public au0 Z;
    public fj3 a0;
    public pj3 b0;
    public u73 c0;
    public b94 d0;
    public n21 e0;
    public ValueAnimator f0;
    public p60 g0;
    public List h0;
    public History i0;
    public boolean j0;
    public boolean k0;
    public boolean l0;
    public boolean m0;
    public boolean n0;
    public Runnable o0;
    public Runnable p0;
    public Runnable q0;
    public Runnable r0;
    public yu s0;
    public bb3 t0;
    public final PlaybackService.NavigationCallback u0 = new c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ClickableSpan {
        public final /* synthetic */ Result f;

        public a(Result result) {
            this.f = result;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            FolderActivity.W1(VideoActivity.this.I1(), VideoActivity.this.a5(), this.f);
            ((TextView) view).setMaxLines(Integer.MAX_VALUE);
            VideoActivity.this.T2(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends v60 {
        public b() {
        }

        @Override // defpackage.rl4
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(Drawable drawable, ys4 ys4Var) {
            VideoActivity.this.U.i.setDefaultArtwork(drawable);
        }

        @Override // defpackage.w60, defpackage.rl4
        public void j(Drawable drawable) {
            VideoActivity.this.U.i.setDefaultArtwork(drawable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements PlaybackService.NavigationCallback {
        public c() {
        }

        @Override // com.fongmi.android.tv.service.PlaybackService.NavigationCallback
        public void onAudio() {
            VideoActivity.this.moveTaskToBack(true);
            VideoActivity.this.R2(true);
        }

        @Override // com.fongmi.android.tv.service.PlaybackService.NavigationCallback
        public void onLoop() {
            VideoActivity.this.R6();
        }

        @Override // com.fongmi.android.tv.service.PlaybackService.NavigationCallback
        public void onNext() {
            VideoActivity.this.G4();
        }

        @Override // com.fongmi.android.tv.service.PlaybackService.NavigationCallback
        public void onPrev() {
            VideoActivity.this.L4();
        }

        @Override // com.fongmi.android.tv.service.PlaybackService.NavigationCallback
        public void onReplay() {
            VideoActivity.this.Z6();
        }

        @Override // com.fongmi.android.tv.service.PlaybackService.NavigationCallback
        public void onStop() {
            VideoActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B5(View view) {
        T6();
    }

    private void B6() {
        if (s5()) {
            S4();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C5(View view) {
        C6();
    }

    private void C6() {
        uq.c3().f3(this.i0).p3(new CastVideo(this.U.l.getText().toString(), K2().I(), K2().E(), K2().A())).d3(true).o3(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D5(View view) {
        O6();
    }

    private void D7() {
        this.U.e.b.i.setText(K2().Q() ? sm3.a0 : sm3.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E5(View view) {
        P6();
    }

    private void F4() {
        this.U.e.n.b.setImageResource(u2() ? fl3.j : fl3.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F5(View view) {
        K4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G4() {
        H4(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G5(View view) {
        G4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H5(View view) {
        L4();
    }

    private void H7() {
        K2().m0(t4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I5(View view) {
        f7();
    }

    private void I6() {
        this.s0.f(null);
        K2().z0();
        P7();
        y7();
        D7();
    }

    private void K4() {
        P7();
        if (K2().S()) {
            W6();
        } else if (K2().N()) {
            Y6();
        } else {
            X6();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K5(View view) {
        Q6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M5(View view) {
        S6();
    }

    private void M6() {
        this.s0.f(null);
        K2().A0();
        P7();
        D7();
        y7();
        d2();
    }

    private void N7() {
        if (this.i0 != null) {
            K2().f0(Math.max(this.i0.getOpening(), this.i0.getPosition()));
        }
    }

    public static void O4(Activity activity, String str, String str2, String str3, String str4) {
        p8(activity, str, str2, str3, str4, null, true);
    }

    private void O6() {
        uj1.d(this).o(this.U.e.q.getText()).f(K2().A()).p(K2().I()).n();
    }

    private void P7() {
        App.e(this.o0, f10.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q6() {
        S2(!u2());
        setRequestedOrientation(b5());
        this.g0.C(u2());
        F4();
        g8();
    }

    private void Q7() {
        this.U.j.setHasFixedSize(true);
        this.U.j.setItemAnimator(null);
        this.U.j.i(new gb4(8));
        RecyclerView recyclerView = this.U.j;
        n21 n21Var = new n21(this);
        this.e0 = n21Var;
        recyclerView.setAdapter(n21Var);
        RecyclerView recyclerView2 = this.U.r;
        pj3 pj3Var = new pj3(this);
        this.b0 = pj3Var;
        recyclerView2.setAdapter(pj3Var);
        this.U.h.setHasFixedSize(true);
        this.U.h.setItemAnimator(null);
        this.U.h.i(new gb4(8));
        RecyclerView recyclerView3 = this.U.h;
        au0 au0Var = new au0(this, 0);
        this.Z = au0Var;
        recyclerView3.setAdapter(au0Var);
        this.U.p.setHasFixedSize(true);
        this.U.p.setItemAnimator(null);
        this.U.p.i(new gb4(8));
        RecyclerView recyclerView4 = this.U.p;
        fj3 fj3Var = new fj3(this);
        this.a0 = fj3Var;
        recyclerView4.setAdapter(fj3Var);
        this.U.e.k.setHasFixedSize(true);
        this.U.e.k.setItemAnimator(null);
        this.U.e.k.i(new gb4(8));
        RecyclerView recyclerView5 = this.U.e.k;
        u73 u73Var = new u73(this, 0);
        this.c0 = u73Var;
        recyclerView5.setAdapter(u73Var);
    }

    private void S7(int i) {
        this.i0.setScale(i);
        this.U.i.setResizeMode(i);
        if (K2().Q()) {
            K2().n0(i);
        }
        this.U.e.b.k.setText(vr3.n(dk3.j)[i]);
    }

    public static void T4(u51 u51Var, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m8(u51Var, "push_agent", "file://" + str, new File(str).getName());
    }

    private void W6() {
        if (K2().Q()) {
            K2().X();
        } else {
            i2().pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X5(View view) {
        A6();
    }

    private void X6() {
        if (this.i0 != null && s2()) {
            if (K2().Q()) {
                K2().f0(this.i0.getOpening());
            } else {
                i2().seekTo(this.i0.getOpening());
            }
        }
        if (!K2().N() && t2()) {
            if (K2().Q()) {
                K2().Y();
            } else {
                i2().prepare();
            }
        }
        if (K2().Q()) {
            K2().Y();
        } else {
            i2().play();
        }
    }

    private void X7() {
        this.U.e.b.n.setVisibility(8);
    }

    private void Y6() {
        o7();
        K2().v0();
        K2().s();
        this.s0.f(null);
        if (this.e0.N() || this.Z.M()) {
            return;
        }
        f5(X4(), W4());
    }

    private void Y7() {
        this.U.e.b.m.setVisibility((K2().M(3) || K2().U()) ? 0 : 8);
        this.U.e.b.b.setVisibility(K2().M(1) ? 0 : 8);
        this.U.e.b.o.setVisibility(K2().M(2) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z7() {
        yr4.c(this.U.n.b);
        App.e(this.p0, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a5() {
        return Objects.toString(getIntent().getStringExtra("key"), "");
    }

    private int b5() {
        if (u2()) {
            return vr3.i(this);
        }
        if (y5()) {
            return 12;
        }
        if (w5() && q5()) {
            return 13;
        }
        return vr3.r(this) ? 6 : 12;
    }

    private void c8() {
        this.U.e.b.c.setVisibility(q24.E() ? 0 : 8);
        this.U.e.b.j.setText(vr3.n(dk3.h)[q24.l()]);
        this.U.y.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: z15
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.a.p6(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    private void d7() {
        P7();
        R7(!y5());
        setRequestedOrientation(vr3.r(this) ? 12 : 6);
    }

    private void e7() {
        int iG5 = g5();
        String[] strArrN = vr3.n(dk3.j);
        if (this.g0.m() != 1.0f) {
            this.g0.A();
        } else {
            S7(iG5 == strArrN.length + (-1) ? 0 : iG5 + 1);
        }
        P7();
    }

    private void e8() {
        b94 b94Var = (b94) new x(this).b(b94.class);
        this.d0 = b94Var;
        b94Var.v().g(this.W);
        this.d0.u().g(this.X);
        this.d0.w().g(this.Y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g6(View view) {
        E6();
    }

    private void g7() {
        this.U.e.b.l.setText(K2().n());
        this.i0.setSpeed(K2().G());
        P7();
    }

    private void g8() {
        if (Q2() == null || isInPictureInPictureMode()) {
            return;
        }
        this.U.e.g.setVisibility((u2() || !K2().L()) ? 8 : 0);
        this.U.e.p.setVisibility((this.i0 == null || s5()) ? 8 : 0);
        this.U.e.n.d.setVisibility((!s5() || u2()) ? 8 : 0);
        this.U.e.i.setVisibility((this.i0 == null || s5()) ? 8 : 0);
        this.U.e.k.setVisibility((s5() && z5()) ? 0 : 8);
        this.U.e.b.getRoot().setVisibility(s5() ? 0 : 8);
        this.U.e.n.b.setVisibility(s5() ? 0 : 8);
        this.U.e.h.setVisibility((K2().N() || q24.H()) ? 8 : 0);
        this.U.e.e.setVisibility(K2().N() ? 8 : 0);
        this.U.e.f.setVisibility(u2() ? 8 : 0);
        this.U.e.d.setVisibility(u2() ? 8 : 0);
        this.U.e.c.setVisibility(u2() ? 8 : 0);
        this.U.e.r.setVisibility(u2() ? 8 : 0);
        this.U.e.getRoot().setVisibility(0);
        P7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h6(View view) {
        c7();
    }

    private boolean h7() {
        this.U.e.b.l.setText(K2().B0());
        this.i0.setSpeed(K2().G());
        P7();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i5() {
        this.U.e.getRoot().setVisibility(8);
        App.f(this.o0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i6(View view) {
        J6();
    }

    private boolean j7() {
        if (!K2().M(3)) {
            return false;
        }
        z0();
        return true;
    }

    private void j8(String str) {
        this.U.z.f.setVisibility(0);
        this.U.z.f.setText(str);
        l5();
    }

    private void k5() {
        this.U.z.f.setVisibility(8);
        this.U.z.f.setText("");
    }

    private void k8() {
        this.U.n.getRoot().setVisibility(0);
        App.e(this.p0, 0L);
        k5();
    }

    private void l5() {
        this.U.n.getRoot().setVisibility(8);
        App.f(this.p0);
        yr4.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l6(View view) {
        B6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l7(View view) {
        xq4.a3().j3(Integer.parseInt(view.getTag().toString())).g3(K2()).h3(this);
        i5();
    }

    public static void l8(Activity activity, String str) {
        m8(activity, "push_agent", str, str);
    }

    public static void m7(u51 u51Var, String str) {
        if (g01.r(u51Var, Uri.parse(str))) {
            T4(u51Var, g01.m(Uri.parse(str)));
        } else {
            l8(u51Var, u94.d(str));
        }
    }

    public static void m8(Activity activity, String str, String str2, String str3) {
        n8(activity, str, str2, str3, null);
    }

    public static void n8(Activity activity, String str, String str2, String str3, String str4) {
        o8(activity, str, str2, str3, str4, null);
    }

    public static void o8(Activity activity, String str, String str2, String str3, String str4, String str5) {
        p8(activity, str, str2, str3, str4, str5, false);
    }

    public static void p8(Activity activity, String str, String str2, String str3, String str4, String str5, boolean z) {
        Intent intent = new Intent(activity, (Class<?>) VideoActivity.class);
        intent.putExtra("collect", z);
        intent.putExtra("mark", str5);
        intent.putExtra("name", str3);
        intent.putExtra("pic", str4);
        intent.putExtra("key", str);
        intent.putExtra(Name.MARK, str2);
        activity.startActivity(intent);
    }

    public static /* synthetic */ com.google.android.material.bottomsheet.b q3(p51 p51Var) {
        return (com.google.android.material.bottomsheet.b) p51Var;
    }

    private void q7(final RecyclerView recyclerView, final int i) {
        recyclerView.post(new Runnable() { // from class: a15
            @Override // java.lang.Runnable
            public final void run() {
                recyclerView.t1(i);
            }
        });
    }

    private void q8() {
        if (h5().isChangeable()) {
            if (z5()) {
                J4();
            } else {
                z4();
            }
        }
    }

    private ph2 t4() {
        String vodName = this.i0.getVodName();
        String name = W4().getName();
        if (name.isEmpty() || vodName.equals(name)) {
            name = "";
        }
        return me3.o(vodName, name, this.i0.getVodPic());
    }

    private void t7() {
        si1.g(this, this.i0.getVodPic(), new b());
    }

    public static /* synthetic */ boolean u3(p51 p51Var) {
        return p51Var instanceof com.google.android.material.bottomsheet.b;
    }

    public static void u4(Activity activity, History history) {
        n8(activity, history.getSiteKey(), history.getVodId(), history.getVodName(), history.getVodPic());
    }

    private void w4() {
        if (N1(this.U.e.getRoot())) {
            g8();
        }
    }

    private void y7() {
        this.U.e.b.d.setText(K2().y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z6(View view, MotionEvent motionEvent) {
        P7();
        return false;
    }

    @Override // p60.a
    public void A() {
        if (N1(this.U.e.getRoot())) {
            i5();
        } else {
            g8();
        }
    }

    @Override // defpackage.zb3
    public void A2(String str) {
        this.U.x.setEnabled(true);
        Track.delete(K2().B());
        this.s0.f(null);
        K2().e0();
        K2().d0();
        K2().v0();
        j8(str);
        q8();
    }

    public final void A4(Vod vod) {
        boolean zIsEmpty = vod.getFlags().isEmpty();
        this.U.j.setVisibility(zIsEmpty ? 8 : 0);
        if (zIsEmpty) {
            q8();
            return;
        }
        O0(this.i0.getFlag());
        if (this.i0.isRevSort()) {
            n7(true);
        }
    }

    public final /* synthetic */ void A5() {
        this.U.h.t1(this.Z.K());
    }

    public final void A6() {
        MaterialTextView materialTextView = this.U.b;
        materialTextView.setMaxLines(materialTextView.getMaxLines() == 1 ? Integer.MAX_VALUE : 1);
    }

    public final void A7(Vod vod) {
        vod.checkPic(e5());
        vod.checkName(d5());
        this.U.o.e();
        this.U.l.setText(vod.getName());
        this.e0.I(vod.getFlags());
        App.f(this.r0);
        B4(vod);
        A4(vod);
        D4();
        W7(vod);
        v8();
    }

    public final void B4(Vod vod) {
        try {
            this.i0 = History.find(Y4());
        } catch (Exception unused) {
            this.i0 = null;
        }
        History historyP4 = this.i0;
        if (historyP4 == null) {
            historyP4 = P4(vod);
        }
        this.i0 = historyP4;
        if (!TextUtils.isEmpty(c5())) {
            this.i0.setVodRemarks(c5());
        }
        try {
            if (q24.I() && this.i0.getKey().equals(Y4())) {
                this.i0.delete();
            }
        } catch (Exception unused2) {
        }
        this.U.e.b.h.setText(this.i0.getOpening() <= 0 ? getString(sm3.b0) : jy4.u(this.i0.getOpening()));
        this.U.e.b.e.setText(this.i0.getEnding() <= 0 ? getString(sm3.W) : jy4.u(this.i0.getEnding()));
        this.U.e.b.l.setText(K2().q0(1.0f));
        this.i0.setVodName(vod.getName());
        u7(vod.getPic());
        S7(g5());
    }

    public final void B7(boolean z) {
        if (r5() || z) {
            finish();
        } else {
            if (d5().isEmpty()) {
                i8();
                return;
            }
            this.U.l.setText(d5());
            App.e(this.r0, 10000L);
            M4(false);
        }
    }

    @Override // p60.a
    public void C0() {
        this.U.z.g.setVisibility(8);
        this.U.z.h.setVisibility(8);
        this.U.z.c.setVisibility(8);
        this.U.z.j.setVisibility(8);
    }

    @Override // defpackage.zb3
    public void C2(boolean z) {
        if (z) {
            this.t0.g(this, true);
            this.U.e.l.setImageResource(el3.c);
        } else if (w2()) {
            this.t0.g(this, false);
            this.U.e.l.setImageResource(el3.d);
        }
    }

    public final void C4() {
        if (Z4().startsWith("push://")) {
            getIntent().putExtra("key", "push_agent").putExtra(Name.MARK, Z4().substring(7));
        }
        if (Z4().isEmpty() || Z4().startsWith("msearch:")) {
            B7(false);
        } else {
            U4();
        }
    }

    public final void C7(long j) {
        this.i0.setEnding(j);
        this.U.e.b.e.setText(j <= 0 ? getString(sm3.W) : jy4.u(this.i0.getEnding()));
    }

    @Override // fj3.a
    public void D0(Result result) {
        X2(Y4(), result, z5(), h5().getTimeout(), t4());
    }

    @Override // defpackage.zb3
    public void D2() {
        y7();
        D7();
        N7();
    }

    public final void D4() {
        this.U.e.i.setImageResource(Keep.find(Y4()) == null ? fl3.g : fl3.h);
    }

    public final boolean D6() {
        M4(true);
        return true;
    }

    @Override // au0.a
    public void E(Episode episode) {
        if (f8(episode)) {
            return;
        }
        this.e0.T(episode);
        y6(this.U.h, this.Z);
        q7(this.U.h, this.Z.K());
        if (s5()) {
            i43.i(getString(sm3.c0, episode.getName()));
        }
        Y6();
    }

    @Override // defpackage.zb3
    public void E2() {
        Result result = (Result) this.d0.u().e();
        if (result != null) {
            M7(result);
        }
    }

    public final void E4() {
        if (w5() && vr3.r(this)) {
            R4();
        }
    }

    public final void E6() {
        MaterialTextView materialTextView = this.U.c;
        materialTextView.setMaxLines(materialTextView.getMaxLines() == 3 ? Integer.MAX_VALUE : 3);
    }

    public final void E7(List list) {
        this.U.e.b.f.setVisibility(list.size() < 2 ? 8 : 0);
        this.U.e.j.setVisibility(list.size() < 2 ? 8 : 0);
        this.U.e.m.setVisibility(list.size() < 2 ? 8 : 0);
        this.U.t.setVisibility(list.size() < 2 ? 8 : 0);
        this.U.h.setVisibility(list.isEmpty() ? 8 : 0);
        this.U.k.setVisibility(list.size() < 10 ? 8 : 0);
        this.Z.G(list);
    }

    @Override // p60.a
    public void F(int i) {
        this.U.z.c.setVisibility(0);
        this.U.z.e.setProgress(i);
        if (i < 35) {
            this.U.z.d.setImageResource(fl3.v);
            return;
        }
        v3 v3Var = this.U;
        if (i < 70) {
            v3Var.z.d.setImageResource(fl3.w);
        } else {
            v3Var.z.d.setImageResource(fl3.u);
        }
    }

    @Override // defpackage.zb3
    public void F2() {
        K2().i0(this.U.f);
        E4();
        C4();
    }

    public final boolean F6() {
        jy4.c(this.U.c.getText().toString());
        return true;
    }

    public final void F7(boolean z) {
        this.j0 = z;
        jy4.v(this, z);
    }

    @Override // defpackage.zb3
    public void G2(e35 e35Var) {
        super.G2(e35Var);
        v4();
        I4();
    }

    public final void G6() {
        x80.X2().a3(K2()).b3(this);
        i5();
    }

    public final void G7(boolean z) {
        this.k0 = z;
    }

    @Override // defpackage.zb3
    public void H2(int i) {
        if (i == 2) {
            k8();
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            y4(true);
        } else {
            l5();
            w4();
            K2().d0();
        }
    }

    public final void H4(boolean z) {
        P7();
        Episode episodeJ = this.Z.J();
        if (!episodeJ.isActivated()) {
            E(episodeJ);
        } else if (z) {
            i43.h(sm3.D);
        }
    }

    public final void H6() {
        q24.X(!q24.F());
        x4();
        h8();
    }

    @Override // defpackage.zb3
    public void I2() {
        X7();
    }

    public final void I4() {
        if (s5() && !y5() && K2().T()) {
            setRequestedOrientation(12);
            R7(true);
        } else if (s5() && y5() && K2().O()) {
            setRequestedOrientation(11);
            R7(false);
        }
    }

    public final void I7(long j) {
        this.i0.setOpening(j);
        this.U.e.b.h.setText(j <= 0 ? getString(sm3.b0) : jy4.u(this.i0.getOpening()));
    }

    @Override // defpackage.xg
    public i35 J1() {
        v3 v3VarB = v3.b(getLayoutInflater());
        this.U = v3VarB;
        return v3VarB;
    }

    @Override // defpackage.zb3
    public void J2() {
        Y7();
        this.s0.f(this);
    }

    public final void J4() {
        int iJ = this.c0.J();
        boolean z = true;
        boolean z2 = iJ == this.c0.g() - 1;
        if (iJ != 0 && !z2) {
            z = false;
        }
        if (z2) {
            n5();
        }
        if (z) {
            z4();
        } else {
            w6(iJ);
        }
    }

    public final /* synthetic */ boolean J5(View view) {
        return D6();
    }

    public final void J6() {
        MaterialTextView materialTextView = this.U.g;
        materialTextView.setMaxLines(materialTextView.getMaxLines() == 1 ? Integer.MAX_VALUE : 1);
    }

    public final void J7() {
        if (w5() && q5()) {
            setRequestedOrientation(13);
        }
        if (u5() && q5()) {
            setRequestedOrientation(11);
        }
    }

    @Override // yu.b
    public void K(long j) {
        if (v2()) {
            this.i0.setCreateTime(j);
            History history = this.i0;
            long jE = K2().E();
            history.setPosition(jE);
            History history2 = this.i0;
            long jZ = K2().z();
            history2.setDuration(jZ);
            if (this.i0.canSave() && this.i0.canSync()) {
                s8();
            }
            if (this.i0.getEnding() <= 0 || jZ <= 0 || this.i0.getEnding() + jE < jZ) {
                return;
            }
            y4(false);
        }
    }

    @Override // defpackage.xg
    public void K1() {
        this.U.l.setOnClickListener(new View.OnClickListener() { // from class: a05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.B5(view);
            }
        });
        this.U.k.setOnClickListener(new View.OnClickListener() { // from class: sz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.M5(view);
            }
        });
        this.U.b.setOnClickListener(new View.OnClickListener() { // from class: c05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.X5(view);
            }
        });
        this.U.c.setOnClickListener(new View.OnClickListener() { // from class: o05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.g6(view);
            }
        });
        this.U.t.setOnClickListener(new View.OnClickListener() { // from class: r05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.h6(view);
            }
        });
        this.U.g.setOnClickListener(new View.OnClickListener() { // from class: s05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.i6(view);
            }
        });
        this.U.l.setOnLongClickListener(new View.OnLongClickListener() { // from class: t05
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.j6(view);
            }
        });
        this.U.c.setOnLongClickListener(new View.OnLongClickListener() { // from class: u05
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.k6(view);
            }
        });
        this.U.e.c.setOnClickListener(new View.OnClickListener() { // from class: v05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.l6(view);
            }
        });
        this.U.e.e.setOnClickListener(new View.OnClickListener() { // from class: x05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.C5(view);
            }
        });
        this.U.e.h.setOnClickListener(new View.OnClickListener() { // from class: l05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.D5(view);
            }
        });
        this.U.e.i.setOnClickListener(new View.OnClickListener() { // from class: w05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.E5(view);
            }
        });
        this.U.e.l.setOnClickListener(new View.OnClickListener() { // from class: h15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.F5(view);
            }
        });
        this.U.e.j.setOnClickListener(new View.OnClickListener() { // from class: s15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.G5(view);
            }
        });
        this.U.e.m.setOnClickListener(new View.OnClickListener() { // from class: b25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.H5(view);
            }
        });
        this.U.e.p.setOnClickListener(new View.OnClickListener() { // from class: c25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.I5(view);
            }
        });
        this.U.e.q.setOnLongClickListener(new View.OnLongClickListener() { // from class: d25
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.J5(view);
            }
        });
        this.U.e.n.b.setOnClickListener(new View.OnClickListener() { // from class: e25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.K5(view);
            }
        });
        this.U.e.n.d.setOnClickListener(new View.OnClickListener() { // from class: qz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.L5(view);
            }
        });
        this.U.e.g.setOnClickListener(new View.OnClickListener() { // from class: rz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.N5(view);
            }
        });
        this.U.e.b.m.setOnClickListener(new View.OnClickListener() { // from class: tz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.l7(view);
            }
        });
        this.U.e.b.b.setOnClickListener(new View.OnClickListener() { // from class: tz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.l7(view);
            }
        });
        this.U.e.b.o.setOnClickListener(new View.OnClickListener() { // from class: tz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.l7(view);
            }
        });
        this.U.e.b.g.setOnClickListener(new View.OnClickListener() { // from class: uz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.O5(view);
            }
        });
        this.U.e.b.k.setOnClickListener(new View.OnClickListener() { // from class: vz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.P5(view);
            }
        });
        this.U.e.b.l.setOnClickListener(new View.OnClickListener() { // from class: wz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Q5(view);
            }
        });
        this.U.e.b.j.setOnClickListener(new View.OnClickListener() { // from class: xz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.R5(view);
            }
        });
        this.U.e.b.n.setOnClickListener(new View.OnClickListener() { // from class: yz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.S5(view);
            }
        });
        this.U.e.b.i.setOnClickListener(new View.OnClickListener() { // from class: zz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.T5(view);
            }
        });
        this.U.e.b.d.setOnClickListener(new View.OnClickListener() { // from class: b05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.U5(view);
            }
        });
        this.U.e.b.e.setOnClickListener(new View.OnClickListener() { // from class: d05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.V5(view);
            }
        });
        this.U.e.b.h.setOnClickListener(new View.OnClickListener() { // from class: e05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.W5(view);
            }
        });
        this.U.e.b.c.setOnClickListener(new View.OnClickListener() { // from class: f05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Y5(view);
            }
        });
        this.U.e.b.f.setOnClickListener(new View.OnClickListener() { // from class: g05
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Z5(view);
            }
        });
        this.U.e.b.m.setOnLongClickListener(new View.OnLongClickListener() { // from class: h05
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.a6(view);
            }
        });
        this.U.e.b.l.setOnLongClickListener(new View.OnLongClickListener() { // from class: i05
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.b6(view);
            }
        });
        this.U.e.b.j.setOnLongClickListener(new View.OnLongClickListener() { // from class: j05
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.c6(view);
            }
        });
        this.U.e.b.e.setOnLongClickListener(new View.OnLongClickListener() { // from class: k05
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.d6(view);
            }
        });
        this.U.e.b.h.setOnLongClickListener(new View.OnLongClickListener() { // from class: m05
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.e6(view);
            }
        });
        this.U.y.setOnTouchListener(new View.OnTouchListener() { // from class: n05
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f.f6(view, motionEvent);
            }
        });
        this.U.e.b.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: p05
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f.z6(view, motionEvent);
            }
        });
        this.U.x.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: q05
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void q() {
                this.f.i7();
            }
        });
    }

    public final void K6() {
        long jE = K2().E();
        long jZ = K2().z();
        if (K2().p(jE, jZ)) {
            C7(jZ - jE);
        }
        P7();
    }

    public final void K7(TextView textView, Vod vod) {
        StringBuilder sb = new StringBuilder();
        if (!vod.getYear().isEmpty()) {
            sb.append(getString(sm3.o, vod.getYear()));
            sb.append("  ");
        }
        if (!vod.getArea().isEmpty()) {
            sb.append(getString(sm3.i, vod.getArea()));
            sb.append("  ");
        }
        if (!vod.getTypeName().isEmpty()) {
            sb.append(getString(sm3.n, vod.getTypeName()));
            sb.append("  ");
        }
        textView.setVisibility(sb.length() == 0 ? 8 : 0);
        textView.setText(jy4.t(sb.toString(), 2));
    }

    @Override // defpackage.zb3, defpackage.xg
    public void L1(Bundle bundle) {
        super.L1(bundle);
        l35.p0(this.U.getRoot(), new d63() { // from class: k15
            @Override // defpackage.d63
            public final w95 a(View view, w95 w95Var) {
                return this.a.m6(view, w95Var);
            }
        });
        this.U.x.setColorSchemeResources(rk3.a);
        this.g0 = p60.l(this, this.U.i);
        this.V = this.U.y.getLayoutParams();
        this.U.o.h();
        this.U.x.setEnabled(false);
        this.W = new x43() { // from class: l15
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.z7((Result) obj);
            }
        };
        this.X = new x43() { // from class: m15
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.M7((Result) obj);
            }
        };
        this.Y = new x43() { // from class: n15
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.T7((Result) obj);
            }
        };
        this.h0 = new ArrayList();
        this.s0 = yu.c();
        this.o0 = new Runnable() { // from class: o15
            @Override // java.lang.Runnable
            public final void run() {
                this.f.i5();
            }
        };
        this.p0 = new Runnable() { // from class: p15
            @Override // java.lang.Runnable
            public final void run() {
                this.f.Z7();
            }
        };
        this.q0 = new Runnable() { // from class: q15
            @Override // java.lang.Runnable
            public final void run() {
                this.f.J7();
            }
        };
        this.r0 = new Runnable() { // from class: r15
            @Override // java.lang.Runnable
            public final void run() {
                this.f.i8();
            }
        };
        this.t0 = new bb3();
        x4();
        Q7();
        c8();
        e8();
        k8();
        h8();
        s7();
    }

    public final void L4() {
        P7();
        Episode episodeL = this.Z.L();
        if (episodeL.isActivated()) {
            i43.h(sm3.F);
        } else {
            E(episodeL);
        }
    }

    public final /* synthetic */ void L5(View view) {
        d7();
    }

    public final boolean L6() {
        P7();
        C7(0L);
        return true;
    }

    public final void L7(Parse parse) {
        b75.I().s0(parse);
        y6(this.U.e.k, this.c0);
    }

    @Override // p60.a
    public void M0(int i) {
        this.U.z.j.setVisibility(0);
        this.U.z.l.setProgress(i);
        if (i < 35) {
            this.U.z.k.setImageResource(fl3.A);
            return;
        }
        v3 v3Var = this.U;
        if (i < 70) {
            v3Var.z.k.setImageResource(fl3.B);
        } else {
            v3Var.z.k.setImageResource(fl3.z);
        }
    }

    public final void M4(boolean z) {
        if (this.b0.K()) {
            o5(this.U.l.getText().toString(), true);
        } else if (p5() || z) {
            x6();
        }
    }

    public final void M7(Result result) {
        this.a0.H(result);
        b8(result.shouldUseParse());
        this.U.x.setRefreshing(false);
        O7(result.getUrl().isMulti());
        result.getUrl().set(this.a0.I());
        if (result.hasArtwork()) {
            u7(result.getArtwork());
        }
        if (result.hasPosition()) {
            this.i0.setPosition(result.getPosition().longValue());
        }
        if (result.hasDesc()) {
            V7(this.U.c, 0, result.getDesc());
        }
        this.U.e.k.setVisibility(z5() ? 0 : 8);
        X2(Y4(), result, z5(), h5().getTimeout(), t4());
    }

    public final ClickableSpan N4(Result result) {
        return new a(result);
    }

    public final /* synthetic */ void N5(View view) {
        H6();
    }

    public final void N6() {
        ju0.a(this).b(this.Z.I()).h();
    }

    @Override // n21.a
    public void O0(Flag flag) {
        if (flag.isActivated()) {
            return;
        }
        this.e0.S(flag);
        q7(this.U.j, this.e0.M());
        E7(flag.getEpisodes());
        O7(false);
        r7(flag);
    }

    public final /* synthetic */ void O5(View view) {
        R6();
    }

    public final void O7(boolean z) {
        this.U.q.setVisibility(z ? 0 : 8);
        this.U.p.setVisibility(z ? 0 : 8);
    }

    @Override // p60.a
    public void P() {
        this.U.z.h.clearAnimation();
        this.U.e.b.l.setText(K2().q0(this.i0.getSpeed()));
    }

    @Override // uj1.a
    public void P0(CharSequence charSequence) {
        ge3.f(this, K2().I(), K2().A(), charSequence);
        T2(true);
    }

    @Override // defpackage.xg
    public void P1() {
        if (N1(this.U.e.getRoot())) {
            i5();
            return;
        }
        if (s5() && !u2()) {
            S4();
        } else {
            if (u2()) {
                return;
            }
            this.d0.E();
            if (isTaskRoot()) {
                startActivity(new Intent(this, (Class<?>) HomeActivity.class).addFlags(872415232));
            }
            super.P1();
        }
    }

    public final History P4(Vod vod) {
        History history = new History();
        history.setKey(Y4());
        history.setCid(b75.K());
        history.setVodName(vod.getName());
        history.findEpisode(vod.getFlags());
        return history;
    }

    public final /* synthetic */ void P5(View view) {
        e7();
    }

    public final void P6() {
        Keep keepFind = Keep.find(Y4());
        i43.h(keepFind != null ? sm3.L : sm3.K);
        if (keepFind != null) {
            keepFind.delete();
        } else {
            Q4();
        }
        D4();
    }

    @Override // uq.a
    public void Q0() {
        K2().v0();
    }

    public final void Q4() {
        Keep keep = new Keep();
        keep.setKey(Y4());
        keep.setCid(b75.K());
        keep.setVodPic(this.i0.getVodPic());
        keep.setVodName(this.i0.getVodName());
        keep.setSiteName(h5().getName());
        keep.setCreateTime(System.currentTimeMillis());
        keep.save();
    }

    public final /* synthetic */ void Q5(View view) {
        g7();
    }

    public final void R4() {
        if (s5()) {
            return;
        }
        F7(true);
        if (u5() && !K2().T()) {
            a8();
        }
        this.U.y.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setRequestedOrientation(K2().T() ? 12 : 6);
        this.U.e.q.setVisibility(0);
        R7(K2().T());
        this.g0.A();
        App.e(this.q0, 2000L);
        x7();
        i5();
    }

    public final /* synthetic */ void R5(View view) {
        a7();
    }

    public final void R6() {
        this.U.e.b.g.setActivated(!r1.isActivated());
    }

    public void R7(boolean z) {
        this.n0 = z;
        if (!this.j0 || z) {
            O1(this.U.e.getRoot());
        } else {
            R1(this.U.e.getRoot());
        }
    }

    public final void S4() {
        if (s5()) {
            F7(false);
            if (u5() && !K2().T()) {
                a8();
            }
            setRequestedOrientation(w5() ? 12 : 13);
            this.U.h.postDelayed(new Runnable() { // from class: b15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.A5();
                }
            }, 100L);
            this.U.e.q.setVisibility(4);
            this.U.y.setLayoutParams(this.V);
            this.g0.A();
            App.e(this.q0, 2000L);
            R7(false);
            x7();
            i5();
        }
    }

    public final /* synthetic */ void S5(View view) {
        k7();
    }

    public final void S6() {
        eu0.a3().e3(this.i0.isRevSort()).b3(this.Z.I()).j3(this);
    }

    public final /* synthetic */ void T5(View view) {
        M6();
    }

    public final void T6() {
        String string = this.U.l.getText().toString();
        i43.i(getString(sm3.k, string));
        o5(string, false);
    }

    public final void T7(Result result) {
        List<Vod> list = result.getList();
        list.removeIf(new Predicate() { // from class: y15
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.a.u6((Vod) obj);
            }
        });
        this.U.r.setVisibility(0);
        this.b0.H(list);
        if (t5()) {
            x6();
        }
        if (list.isEmpty()) {
            return;
        }
        App.f(this.r0);
    }

    public final void U4() {
        this.d0.r(a5(), Z4());
    }

    public final /* synthetic */ void U5(View view) {
        I6();
    }

    public final void U6() {
        long jE = K2().E();
        if (K2().q(jE, K2().z())) {
            I7(jE);
        }
        P7();
    }

    public final w95 U7(w95 w95Var) {
        int i = w95Var.f(w95.n.d()).b;
        ViewGroup.LayoutParams layoutParams = this.U.w.getLayoutParams();
        layoutParams.height = i;
        this.U.w.setLayoutParams(layoutParams);
        return w95Var;
    }

    public final void V4(Vod vod) {
        getIntent().putExtra("key", vod.getSiteKey());
        getIntent().putExtra("pic", vod.getPic());
        getIntent().putExtra(Name.MARK, vod.getId());
        this.U.x.setRefreshing(true);
        this.U.x.setEnabled(false);
        this.U.u.scrollTo(0, 0);
        this.s0.f(null);
        K2().d0();
        K2().v0();
        o7();
        U4();
    }

    public final /* synthetic */ void V5(View view) {
        K6();
    }

    public final boolean V6() {
        P7();
        I7(0L);
        return true;
    }

    public final void V7(TextView textView, int i, String str) {
        if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(textView.getText())) {
            textView.setText(u94.a(i > 0 ? getString(i, str) : str, new Function() { // from class: y05
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.N4((Result) obj);
                }
            }), TextView.BufferType.SPANNABLE);
            textView.setVisibility(str.isEmpty() ? 8 : 0);
            if (textView == this.U.c) {
                w7();
            }
            textView.setLinkTextColor(-5317);
            q60.b(textView);
        }
    }

    public final Episode W4() {
        return this.Z.M() ? new Episode() : this.Z.H();
    }

    public final /* synthetic */ void W5(View view) {
        U6();
    }

    public final void W7(Vod vod) {
        V7(this.U.v, sm3.l, h5().getName());
        V7(this.U.g, sm3.j, vod.getDirector());
        V7(this.U.b, sm3.h, vod.getActor());
        V7(this.U.c, 0, vod.getContent());
        V7(this.U.s, 0, vod.getRemarks());
        K7(this.U.m, vod);
    }

    public final Flag X4() {
        return this.e0.K();
    }

    public final String Y4() {
        return a5().concat("@@@").concat(Z4()).concat("@@@") + b75.K();
    }

    public final /* synthetic */ void Y5(View view) {
        G6();
    }

    public final String Z4() {
        return Objects.toString(getIntent().getStringExtra(Name.MARK), "");
    }

    public final /* synthetic */ void Z5(View view) {
        N6();
    }

    public final void Z6() {
        this.i0.setPosition(-9223372036854775807L);
        if (K2().N()) {
            Y6();
        } else {
            K2().k0();
        }
    }

    @Override // pj3.a
    public void a(Vod vod) {
        v7(false);
        V4(vod);
    }

    public final /* synthetic */ boolean a6(View view) {
        return j7();
    }

    public final void a7() {
        if (x5()) {
            Z6();
        } else {
            Y6();
        }
    }

    public final void a8() {
        lr lrVar = new lr();
        lrVar.Y(150L);
        bt4.a((ViewGroup) this.U.y.getParent(), lrVar);
    }

    public final /* synthetic */ boolean b6(View view) {
        return h7();
    }

    public final boolean b7() {
        q24.m0(Math.abs(q24.l() - 1));
        this.U.e.b.j.setText(vr3.n(dk3.h)[q24.l()]);
        return true;
    }

    public void b8(boolean z) {
        this.m0 = z;
    }

    public final String c5() {
        return Objects.toString(getIntent().getStringExtra("mark"), "");
    }

    public final /* synthetic */ boolean c6(View view) {
        return b7();
    }

    public final void c7() {
        this.i0.setRevSort(!r0.isRevSort());
        n7(false);
    }

    public final String d5() {
        return Objects.toString(getIntent().getStringExtra("name"), "");
    }

    public final /* synthetic */ boolean d6(View view) {
        return L6();
    }

    public final void d8(boolean z) {
        v3 v3Var = this.U;
        if (z) {
            v3Var.y.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        } else {
            v3Var.y.setLayoutParams(this.V);
        }
    }

    @Override // p60.a
    public void e0(long j) {
        this.U.z.b.setImageResource(j > 0 ? fl3.x : fl3.y);
        this.U.z.i.setText(K2().F(j));
        this.U.z.g.setVisibility(0);
        l5();
    }

    public final String e5() {
        return Objects.toString(getIntent().getStringExtra("pic"), "");
    }

    public final /* synthetic */ boolean e6(View view) {
        return V6();
    }

    public final void f5(Flag flag, Episode episode) {
        v3 v3Var = this.U;
        v3Var.e.q.setText(getString(sm3.m, v3Var.l.getText(), episode.getName()));
        this.d0.B(a5(), flag.getFlag(), episode.getUrl());
        this.U.e.q.setSelected(true);
        u8(episode);
        k8();
    }

    public final /* synthetic */ boolean f6(View view, MotionEvent motionEvent) {
        return this.g0.y(motionEvent);
    }

    public final void f7() {
        b40.n3().G3(this.U).p3(this.i0).H3(z5()).I3(K2()).R3(this);
    }

    public final boolean f8(Episode episode) {
        boolean z = !s5() && episode.isActivated();
        if (z) {
            R4();
        }
        return z;
    }

    public final int g5() {
        History history = this.i0;
        return (history == null || history.getScale() == -1) ? q24.n() : this.i0.getScale();
    }

    public final Site h5() {
        return b75.I().W(a5());
    }

    public final void h8() {
        this.U.f.setVisibility(q24.F() ? 0 : 4);
    }

    public final void i7() {
        if (this.U.o.d()) {
            U4();
        } else {
            Y6();
        }
    }

    public final void i8() {
        j8(getString(sm3.B));
        this.U.x.setEnabled(true);
        this.U.o.g();
    }

    public final void j5() {
        this.U.f.setVisibility(4);
    }

    public final /* synthetic */ boolean j6(View view) {
        return D6();
    }

    @Override // p60.a
    public void k0() {
        if (u2()) {
            return;
        }
        if (!s5()) {
            R4();
        } else if (K2().S()) {
            g8();
            W6();
        } else {
            i5();
            X6();
        }
    }

    public final /* synthetic */ boolean k6(View view) {
        return F6();
    }

    public final void k7() {
        i5();
    }

    @Override // p60.a
    public void m0() {
        if (this.Z.g() == 1) {
            Y6();
        } else {
            G4();
        }
    }

    @Override // defpackage.zb3
    public PlayerView m2() {
        return this.U.i;
    }

    public final void m5() {
        n1().w0().stream().filter(new Predicate() { // from class: c15
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return VideoActivity.u3((p51) obj);
            }
        }).map(new Function() { // from class: d15
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return VideoActivity.q3((p51) obj);
            }
        }).forEach(new Consumer() { // from class: e15
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((b) obj).w2();
            }
        });
    }

    public final /* synthetic */ w95 m6(View view, w95 w95Var) {
        return U7(w95Var);
    }

    @Override // defpackage.zb3
    public PlaybackService.NavigationCallback n2() {
        return this.u0;
    }

    public final void n5() {
        if (this.c0.K()) {
            return;
        }
        L7(this.c0.H());
    }

    public final /* synthetic */ void n6(boolean z) {
        try {
            this.i0.merge().save();
        } catch (Exception unused) {
        }
        if (z) {
            qp3.g();
        }
    }

    public final void n7(boolean z) {
        this.e0.R();
        E7(X4().getEpisodes());
        if (z) {
            q7(this.U.h, this.Z.K());
        }
    }

    @Override // u73.a
    public void o0(Parse parse) {
        L7(parse);
        Y6();
    }

    @Override // defpackage.zb3
    public String o2() {
        return Y4();
    }

    public final void o5(String str, boolean z) {
        v7(z);
        G7(z);
        r8(str);
    }

    public final /* synthetic */ void o6(ValueAnimator valueAnimator) {
        if (u5() || s5() || isInPictureInPictureMode()) {
            return;
        }
        this.V.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.U.y.setLayoutParams(this.V);
    }

    public final void o7() {
        p7(false);
    }

    @Override // defpackage.u51, defpackage.iy, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1001) {
            final PlaybackService playbackServiceQ2 = Q2();
            Objects.requireNonNull(playbackServiceQ2);
            Runnable runnable = new Runnable() { // from class: i15
                @Override // java.lang.Runnable
                public final void run() {
                    playbackServiceQ2.dispatchNext();
                }
            };
            final l lVarI2 = i2();
            Objects.requireNonNull(lVarI2);
            ge3.e(intent, runnable, new LongConsumer() { // from class: j15
                @Override // java.util.function.LongConsumer
                public final void accept(long j) {
                    lVarI2.seekTo(j);
                }
            });
        }
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onCastEvent(wq wqVar) {
        if (x2()) {
            return;
        }
        qo3.X2().Y2(wqVar).e3(this);
    }

    @Override // defpackage.x7, defpackage.iy, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (q5() && w5() && configuration.orientation == 1 && !y5() && !u2()) {
            S4();
        }
        if (q5() && w5() && configuration.orientation == 2) {
            R4();
        }
        if (s5()) {
            jy4.m(this);
        }
    }

    @Override // defpackage.zb3, defpackage.xg, defpackage.x7, defpackage.u51, android.app.Activity
    public void onDestroy() {
        this.s0.e();
        p7(true);
        to4.e().j();
        qp3.i();
        App.g(this.o0, this.p0, this.q0, this.r0);
        this.d0.v().k(this.W);
        this.d0.u().k(this.X);
        this.d0.w().k(this.Y);
        super.onDestroy();
    }

    @Override // defpackage.iy, android.app.Activity
    public void onNewIntent(Intent intent) {
        String strZ4 = Z4();
        super.onNewIntent(intent);
        String string = Objects.toString(intent.getStringExtra(Name.MARK), "");
        if (TextUtils.isEmpty(string) || string.equals(strZ4)) {
            return;
        }
        this.U.x.setRefreshing(true);
        getIntent().putExtras(intent);
        o7();
        J7();
        C4();
    }

    @Override // defpackage.iy, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        super.onPictureInPictureModeChanged(z, configuration);
        if (!s5()) {
            d8(z);
        }
        if (z) {
            i5();
            j5();
            m5();
        } else {
            h8();
            if (y2()) {
                finish();
            }
        }
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onRefreshEvent(qp3 qp3Var) {
        if (x2()) {
            return;
        }
        if (qp3Var.e() == qp3.a.DETAIL) {
            U4();
            return;
        }
        if (qp3Var.e() == qp3.a.PLAYER) {
            Y6();
            return;
        }
        if (qp3Var.e() == qp3.a.VOD) {
            w8(qp3Var.f());
        } else if (qp3Var.e() == qp3.a.SUBTITLE) {
            K2().r0(Sub.from(qp3Var.d()));
        } else if (qp3Var.e() == qp3.a.DANMAKU) {
            K2().g0(Danmaku.from(qp3Var.d()));
        }
    }

    @Override // defpackage.x7, defpackage.u51, android.app.Activity
    public void onStart() {
        super.onStart();
        this.s0.h().g();
        R2(false);
        V2(false);
    }

    @Override // defpackage.zb3, defpackage.x7, defpackage.u51, android.app.Activity
    public void onStop() {
        super.onStop();
        if (q24.z()) {
            this.s0.h();
        }
        if (q2()) {
            return;
        }
        V2(true);
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (x2()) {
            return;
        }
        if (u2()) {
            App.e(new Runnable() { // from class: z05
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.Q6();
                }
            }, 500L);
        }
        if (K2().M(2)) {
            this.t0.b(this, K2().K(), K2().J(), g5());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (s5() && z) {
            jy4.m(this);
        }
    }

    @Override // p60.a
    public void p0() {
        if (this.Z.g() == 1) {
            Y6();
        } else {
            L4();
        }
    }

    @Override // defpackage.zb3
    public CustomSeekView p2() {
        return this.U.e.o;
    }

    public final boolean p5() {
        return this.l0;
    }

    public final /* synthetic */ void p6(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.t0.f(this, view);
    }

    public final void p7(final boolean z) {
        History history = this.i0;
        if (history == null || !history.canSave() || q24.I()) {
            return;
        }
        ul4.c(new Runnable() { // from class: f15
            @Override // java.lang.Runnable
            public final void run() {
                this.f.n6(z);
            }
        });
    }

    public final boolean q5() {
        return Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1;
    }

    public final /* synthetic */ void q6() {
        try {
            this.i0.save();
        } catch (Exception unused) {
        }
    }

    @Override // p60.a
    public void r0(long j) {
        P2(j);
    }

    public final boolean r5() {
        return getIntent().getBooleanExtra("collect", false);
    }

    public final /* synthetic */ void r6(Flag flag, Flag flag2, Flag flag3) {
        flag3.mergeEpisodes(flag.getEpisodes(), this.i0.isRevSort());
        if (flag3.equals(flag2)) {
            E7(flag3.getEpisodes());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r7(com.fongmi.android.tv.bean.Flag r3) {
        /*
            r2 = this;
            com.fongmi.android.tv.bean.History r0 = r2.i0
            java.lang.String r0 = r0.getVodRemarks()
            java.lang.String r1 = r2.c5()
            boolean r1 = r1.isEmpty()
            com.fongmi.android.tv.bean.Episode r3 = r3.find(r0, r1)
            if (r3 == 0) goto L24
            boolean r0 = r3.isActivated()
            if (r0 == 0) goto L24
            fj3 r0 = r2.a0
            int r0 = r0.g()
            r1 = 1
            if (r0 <= r1) goto L24
            goto L25
        L24:
            r1 = 0
        L25:
            r2.O7(r1)
            if (r3 == 0) goto L3d
            boolean r0 = r3.isActivated()
            if (r0 == 0) goto L31
            goto L3d
        L31:
            com.fongmi.android.tv.bean.History r0 = r2.i0
            java.lang.String r1 = r3.getName()
            r0.setVodRemarks(r1)
            r2.E(r3)
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fongmi.android.tv.ui.activity.VideoActivity.r7(com.fongmi.android.tv.bean.Flag):void");
    }

    public final void r8(String str) {
        this.b0.I();
        ArrayList arrayList = new ArrayList();
        for (Site site : b75.I().Y()) {
            if (v5(site)) {
                arrayList.add(site);
            }
        }
        this.d0.D(arrayList, str, true);
    }

    public final boolean s5() {
        return this.j0;
    }

    public final /* synthetic */ void s6(Flag flag) {
        this.e0.H(flag);
    }

    public final void s7() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f0 = valueAnimator;
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        this.f0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a25
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.o6(valueAnimator2);
            }
        });
    }

    public final void s8() {
        if (this.i0 == null || q24.I()) {
            return;
        }
        ul4.c(new Runnable() { // from class: g15
            @Override // java.lang.Runnable
            public final void run() {
                this.f.q6();
            }
        });
    }

    public final boolean t5() {
        return this.k0;
    }

    public final /* synthetic */ void t6(final Flag flag, final Flag flag2) {
        Stream stream = this.e0.L().stream();
        Objects.requireNonNull(flag2);
        pz4.a(stream.filter(new Predicate() { // from class: v15
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return flag2.equals((Flag) obj);
            }
        }).findFirst(), new Consumer() { // from class: w15
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.r6(flag2, flag, (Flag) obj);
            }
        }, new Runnable() { // from class: x15
            @Override // java.lang.Runnable
            public final void run() {
                this.f.s6(flag2);
            }
        });
    }

    public final void t8(final Flag flag, List list) {
        list.forEach(new Consumer() { // from class: t15
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.t6(flag, (Flag) obj);
            }
        });
    }

    @Override // p60.a
    public void u0() {
        if (K2().S()) {
            this.U.z.h.setVisibility(0);
            this.U.z.h.startAnimation(vr3.b(zj3.a));
            this.U.e.b.l.setText(K2().q0(q24.p()));
        }
    }

    public final boolean u5() {
        return this.U.getRoot().getTag().equals("land");
    }

    public final boolean u6(Vod vod) {
        if (Z4().equals(vod.getId()) || this.h0.contains(vod.getId())) {
            return true;
        }
        String string = this.U.l.getText().toString();
        return !(p5() ? vod.getName().equals(string) : vod.getName().contains(string));
    }

    public final void u7(String str) {
        this.i0.setVodPic(str);
        t7();
    }

    public final void u8(Episode episode) {
        History history = this.i0;
        history.setPosition(episode.matchesName(history.getEpisode()) ? this.i0.getPosition() : -9223372036854775807L);
        this.i0.setVodFlag(X4().getFlag());
        this.i0.setVodRemarks(episode.getName());
        this.i0.setEpisodeUrl(episode.getUrl());
    }

    public final void v4() {
        if (u5() || s5() || isInPictureInPictureMode()) {
            return;
        }
        int iK = K2().K();
        int iJ = K2().J();
        if (iK == 0 || iJ == 0) {
            return;
        }
        int iMax = Math.max(vr3.a(150), Math.min(vr3.g() / 2, (int) (vr3.j() * (iJ / iK))));
        if (iMax == this.U.y.getHeight()) {
            return;
        }
        if (this.f0.isRunning()) {
            this.f0.cancel();
        }
        this.f0.setIntValues(this.U.y.getHeight(), iMax);
        this.f0.setDuration(300L);
        this.f0.start();
    }

    public final boolean v5(Site site) {
        if (!p5() || site.isChangeable()) {
            return site.isSearchable();
        }
        return false;
    }

    public final void v6(int i) {
        Flag flagJ = this.e0.J(i + 1);
        i43.i(getString(sm3.e0, flagJ.getFlag()));
        O0(flagJ);
    }

    public final void v7(boolean z) {
        this.l0 = z;
    }

    public final void v8() {
        Keep keepFind = Keep.find(Y4());
        if (keepFind != null) {
            keepFind.setVodName(this.i0.getVodName());
            keepFind.setVodPic(this.i0.getVodPic());
            keepFind.save();
        }
    }

    @Override // b40.a
    public void w0(Parse parse) {
        o0(parse);
    }

    public final boolean w5() {
        return this.U.getRoot().getTag().equals("port");
    }

    public final void w6(int i) {
        Parse parseI = this.c0.I(i + 1);
        i43.i(getString(sm3.f0, parseI.getName()));
        o0(parseI);
    }

    public final void w7() {
        v3 v3Var = this.U;
        v3Var.d.setVisibility(v3Var.c.getVisibility());
    }

    public final void w8(Vod vod) {
        boolean zIsEmpty = vod.getId().isEmpty();
        boolean zIsEmpty2 = vod.getPic().isEmpty();
        boolean zIsEmpty3 = vod.getName().isEmpty();
        if (!zIsEmpty) {
            getIntent().putExtra(Name.MARK, vod.getId());
        }
        if (!zIsEmpty) {
            this.i0.replace(Y4());
        }
        if (!zIsEmpty3) {
            this.i0.setVodName(vod.getName());
        }
        if (!zIsEmpty3) {
            this.U.l.setText(vod.getName());
        }
        if (!zIsEmpty3) {
            this.U.e.q.setText(vod.getName());
        }
        t8(X4(), vod.getFlags());
        if (!zIsEmpty2) {
            u7(vod.getPic());
        }
        if (!zIsEmpty2 || !zIsEmpty3) {
            H7();
        }
        if (!zIsEmpty2 || !zIsEmpty3) {
            s8();
        }
        if (!zIsEmpty2 || !zIsEmpty3) {
            v8();
        }
        W7(vod);
    }

    public final void x4() {
        this.U.e.g.setImageResource(q24.F() ? fl3.f : fl3.e);
    }

    public final boolean x5() {
        return q24.l() == 1;
    }

    public final void x6() {
        if (this.b0.K()) {
            return;
        }
        Vod vodJ = this.b0.J(0);
        i43.i(getString(sm3.g0, vodJ.getSiteName()));
        this.b0.O(0);
        this.h0.add(Z4());
        G7(false);
        V4(vodJ);
    }

    public final void x7() {
        if (Q2() == null) {
            return;
        }
        K2().h0(s5() ? 1.0f : 0.8f);
    }

    @Override // b40.a
    public void y0(int i) {
        this.g0.A();
        S7(i);
    }

    public final void y4(boolean z) {
        if (this.U.e.b.g.isActivated()) {
            Z6();
            return;
        }
        int i = q24.i();
        if (i == 0) {
            return;
        }
        if (i == 2) {
            onBackPressed();
        } else {
            H4(z);
        }
    }

    public boolean y5() {
        return this.n0;
    }

    public final void y6(RecyclerView recyclerView, final RecyclerView.h hVar) {
        recyclerView.post(new Runnable() { // from class: u15
            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView.h hVar2 = hVar;
                hVar2.p(0, hVar2.g());
            }
        });
    }

    @Override // xq4.a
    public void z0() {
        di4.V2().Z2(this.U.i.getSubtitleView()).W2(s5()).Y2(this);
        i5();
    }

    public final void z4() {
        int iM = M1(this.U.j) ? -1 : this.e0.M();
        if (iM == this.e0.g() - 1) {
            M4(false);
        } else {
            v6(iM);
        }
    }

    public boolean z5() {
        return this.m0;
    }

    public final void z7(Result result) {
        this.U.x.setRefreshing(false);
        if (result.getList().isEmpty()) {
            B7(result.hasMsg());
        } else {
            A7(result.getVod());
        }
        i43.i(result.getMsg());
    }
}
