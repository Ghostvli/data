package com.fongmi.android.tv.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.x;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.CastVideo;
import com.fongmi.android.tv.bean.Channel;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Epg;
import com.fongmi.android.tv.bean.EpgData;
import com.fongmi.android.tv.bean.Group;
import com.fongmi.android.tv.bean.Keep;
import com.fongmi.android.tv.bean.Live;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Track;
import com.fongmi.android.tv.service.PlaybackService;
import com.fongmi.android.tv.ui.custom.CustomSeekView;
import defpackage.bb3;
import defpackage.db4;
import defpackage.di4;
import defpackage.dk3;
import defpackage.el3;
import defpackage.f10;
import defpackage.fl3;
import defpackage.ge3;
import defpackage.gz;
import defpackage.h3;
import defpackage.i35;
import defpackage.i43;
import defpackage.jy4;
import defpackage.kt0;
import defpackage.lh4;
import defpackage.lv1;
import defpackage.lx1;
import defpackage.mb1;
import defpackage.me1;
import defpackage.me3;
import defpackage.p60;
import defpackage.ph2;
import defpackage.q24;
import defpackage.qp3;
import defpackage.rr;
import defpackage.ry1;
import defpackage.si1;
import defpackage.sm3;
import defpackage.to;
import defpackage.u83;
import defpackage.uj;
import defpackage.uj1;
import defpackage.uq;
import defpackage.v60;
import defpackage.vr3;
import defpackage.w83;
import defpackage.x43;
import defpackage.xq4;
import defpackage.yr4;
import defpackage.ys4;
import defpackage.yw1;
import defpackage.yx1;
import defpackage.zb3;
import defpackage.zj3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class LiveActivity extends zb3 implements p60.a, xq4.a, uj.b, u83, gz, yw1, mb1.a, rr.a, kt0.a, uq.a, uj1.a {
    public h3 U;
    public rr V;
    public kt0 W;
    public x43 X;
    public mb1 Y;
    public x43 Z;
    public ry1 a0;
    public p60 b0;
    public List c0;
    public String d0;
    public Channel e0;
    public Group f0;
    public Runnable g0;
    public Runnable h0;
    public Runnable i0;
    public boolean j0;
    public int k0;
    public bb3 l0;
    public final PlaybackService.NavigationCallback m0 = new c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends to {
        public a() {
        }

        @Override // defpackage.to
        public void b(String str) {
            i43.i(str);
        }

        @Override // defpackage.to
        public void d() {
            LiveActivity.this.f4();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends v60 {
        public b() {
        }

        @Override // defpackage.rl4
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(Drawable drawable, ys4 ys4Var) {
            LiveActivity.this.U.e.setDefaultArtwork(drawable);
        }

        @Override // defpackage.w60, defpackage.rl4
        public void j(Drawable drawable) {
            LiveActivity.this.U.e.setDefaultArtwork(drawable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements PlaybackService.NavigationCallback {
        public c() {
        }

        @Override // com.fongmi.android.tv.service.PlaybackService.NavigationCallback
        public void onAudio() {
            LiveActivity.this.moveTaskToBack(true);
            LiveActivity.this.R2(true);
        }

        @Override // com.fongmi.android.tv.service.PlaybackService.NavigationCallback
        public void onNext() {
            LiveActivity.this.O4();
        }

        @Override // com.fongmi.android.tv.service.PlaybackService.NavigationCallback
        public void onPrev() {
            LiveActivity.this.o5();
        }

        @Override // com.fongmi.android.tv.service.PlaybackService.NavigationCallback
        public void onStop() {
            LiveActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends to {
        public final /* synthetic */ Config f;

        public d(Config config) {
            this.f = config;
        }

        @Override // defpackage.to
        public void b(String str) {
            lx1.b0(this.f, new to());
            i43.i(str);
            LiveActivity.this.l4();
        }

        @Override // defpackage.to
        public void c() {
            LiveActivity.this.T5();
        }

        @Override // defpackage.to
        public void d() {
            LiveActivity liveActivity = LiveActivity.this;
            liveActivity.B(liveActivity.d4());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[qp3.a.values().length];
            a = iArr;
            try {
                iArr[qp3.a.LIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[qp3.a.PLAYER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B4(View view) {
        a5();
    }

    private void F5() {
        this.U.f.setItemAnimator(null);
        this.U.b.setItemAnimator(null);
        this.U.d.setItemAnimator(null);
        RecyclerView recyclerView = this.U.f;
        mb1 mb1Var = new mb1(this);
        this.Y = mb1Var;
        recyclerView.setAdapter(mb1Var);
        RecyclerView recyclerView2 = this.U.b;
        rr rrVar = new rr(this);
        this.V = rrVar;
        recyclerView2.setAdapter(rrVar);
        RecyclerView recyclerView3 = this.U.d;
        kt0 kt0Var = new kt0(this);
        this.W = kt0Var;
        recyclerView3.setAdapter(kt0Var);
    }

    private void I5() {
        this.U.c.b.n.setVisibility((K2().M(3) || K2().U()) ? 0 : 8);
        this.U.c.b.c.setVisibility(K2().M(1) ? 0 : 8);
        this.U.c.b.o.setVisibility(K2().M(2) ? 0 : 8);
        this.U.c.b.m.setVisibility(K2().U() ? 0 : 8);
    }

    public static void V5(Context context) {
        context.startActivity(new Intent(context, (Class<?>) LiveActivity.class).putExtra("empty", lx1.X()));
    }

    private to b4() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p4(View view) {
        T4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q4(View view) {
        U4();
    }

    @Override // p60.a
    public void A() {
        m5();
    }

    @Override // defpackage.zb3
    public void A2(String str) {
        Track.delete(K2().B());
        K2().e0();
        K2().d0();
        K2().v0();
        R5(str);
        X5();
    }

    public final /* synthetic */ boolean A4(View view) {
        return l5();
    }

    public final void A5() {
        K2().m0(R3());
    }

    @Override // defpackage.yw1
    public void B(Live live) {
        if (live.isActivated()) {
            live.getGroups().clear();
        }
        lx1.J().i0(live);
        K2().d0();
        K2().s();
        K2().v0();
        q5();
        h4();
        f4();
    }

    public final void B5() {
        Channel channel = this.e0;
        if (channel == null) {
            return;
        }
        Group group = channel.getGroup();
        this.f0 = group;
        int iM = this.Y.M(group);
        boolean z = this.Y.L() != iM;
        if (z) {
            this.Y.Q(iM);
        }
        if (z) {
            this.V.I(this.f0.getChannel());
        }
        if (z) {
            this.V.R(this.f0.getPosition());
        }
        s5(this.U.b, this.f0.getPosition());
        s5(this.U.f, iM);
    }

    @Override // p60.a
    public void C0() {
        this.U.j.p.setVisibility(8);
        this.U.j.q.setVisibility(8);
        this.U.j.c.setVisibility(8);
        this.U.j.s.setVisibility(8);
    }

    @Override // defpackage.zb3
    public void C2(boolean z) {
        if (z) {
            this.l0.g(this, true);
            this.U.c.i.setImageResource(el3.c);
        } else if (w2()) {
            this.l0.g(this, false);
            this.U.c.i.setImageResource(el3.d);
        }
    }

    public final /* synthetic */ boolean C4(View view) {
        return k5();
    }

    public final void C5(int[] iArr) {
        int iG;
        int i;
        if (iArr[0] == -1 || (iG = this.Y.g()) == 1 || (i = iArr[0]) >= iG) {
            return;
        }
        Group groupK = this.Y.K(i);
        this.f0 = groupK;
        groupK.setPosition(iArr[1]);
        Z(this.f0);
        i0(this.f0.current());
    }

    @Override // defpackage.zb3
    public void D2() {
        u5();
        v5();
    }

    public final /* synthetic */ boolean D4(View view, MotionEvent motionEvent) {
        return this.b0.y(motionEvent);
    }

    public final void D5() {
        App.e(this.g0, f10.b);
    }

    @Override // defpackage.zb3
    public void E2() {
        Result result = (Result) this.a0.G().e();
        if (result != null) {
            W5(result);
        }
    }

    public final /* synthetic */ void E4(View view) {
        X3();
    }

    public final void E5() {
        App.e(this.i0, f10.b);
    }

    @Override // p60.a
    public void F(int i) {
        this.U.j.c.setVisibility(0);
        this.U.j.e.setProgress(i);
        if (i < 35) {
            this.U.j.d.setImageResource(fl3.v);
            return;
        }
        h3 h3Var = this.U;
        if (i < 70) {
            h3Var.j.d.setImageResource(fl3.w);
        } else {
            h3Var.j.d.setImageResource(fl3.u);
        }
    }

    @Override // defpackage.zb3
    public void F2() {
        this.U.c.b.m.setText(K2().H());
        this.U.c.b.f.setText(K2().y());
        U3();
    }

    public final /* synthetic */ void F4(View view) {
        O4();
    }

    @Override // defpackage.xg
    public boolean G1() {
        return false;
    }

    public final /* synthetic */ void G4(View view) {
        o5();
    }

    public void G5(boolean z) {
        this.j0 = z;
        h3 h3Var = this.U;
        if (z) {
            O1(h3Var.h);
            O1(this.U.c.getRoot());
        } else {
            S1(h3Var.h, true);
            R1(this.U.c.getRoot());
        }
    }

    @Override // defpackage.zb3
    public void H2(int i) {
        if (i == 2) {
            T5();
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            T3();
        } else {
            l4();
            S3();
            K2().d0();
        }
    }

    public final /* synthetic */ void H4(View view) {
        d5();
    }

    public final void H5(int i) {
        q24.g0(i);
        this.U.e.setResizeMode(i);
        if (K2().Q()) {
            K2().n0(i);
        }
        this.U.c.b.l.setText(vr3.n(dk3.j)[i]);
    }

    @Override // kt0.a
    public void I0(EpgData epgData) {
        if (epgData.isSelected()) {
            a4(epgData);
            return;
        }
        if (this.e0.hasCatchup() || this.e0.isRtsp()) {
            this.U.c.m.setText(getString(sm3.m, this.e0.getShow(), epgData.getTitle()));
            i43.i(getString(sm3.c0, epgData.getTitle()));
            this.W.N(epgData);
            a4(epgData);
        }
    }

    public final /* synthetic */ void I4(View view) {
        g5();
    }

    @Override // uj.b
    public void J() {
        Y5(null);
    }

    @Override // defpackage.xg
    public i35 J1() {
        h3 h3VarC = h3.c(getLayoutInflater());
        this.U = h3VarC;
        return h3VarC;
    }

    @Override // defpackage.zb3
    public void J2() {
        I5();
    }

    public final /* synthetic */ void J4(View view) {
        Z4();
    }

    public final void J5() {
        yr4.c(this.U.g.b);
        App.e(this.h0, 1000L);
    }

    @Override // defpackage.xg
    public void K1() {
        this.U.c.c.setOnClickListener(new View.OnClickListener() { // from class: dv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.p4(view);
            }
        });
        this.U.c.e.setOnClickListener(new View.OnClickListener() { // from class: vu1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.q4(view);
            }
        });
        this.U.c.g.setOnClickListener(new View.OnClickListener() { // from class: cv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.B4(view);
            }
        });
        this.U.c.i.setOnClickListener(new View.OnClickListener() { // from class: ev1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.E4(view);
            }
        });
        this.U.c.h.setOnClickListener(new View.OnClickListener() { // from class: fv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.F4(view);
            }
        });
        this.U.c.j.setOnClickListener(new View.OnClickListener() { // from class: gv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.G4(view);
            }
        });
        this.U.c.k.b.setOnClickListener(new View.OnClickListener() { // from class: hv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.H4(view);
            }
        });
        this.U.c.k.d.setOnClickListener(new View.OnClickListener() { // from class: iv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.I4(view);
            }
        });
        this.U.c.b.n.setOnClickListener(new View.OnClickListener() { // from class: ov1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.n5(view);
            }
        });
        this.U.c.b.c.setOnClickListener(new View.OnClickListener() { // from class: ov1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.n5(view);
            }
        });
        this.U.c.b.o.setOnClickListener(new View.OnClickListener() { // from class: ov1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.n5(view);
            }
        });
        this.U.c.b.g.setOnClickListener(new View.OnClickListener() { // from class: uv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.J4(view);
            }
        });
        this.U.c.b.i.setOnClickListener(new View.OnClickListener() { // from class: vv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.K4(view);
            }
        });
        this.U.c.b.l.setOnClickListener(new View.OnClickListener() { // from class: wv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.r4(view);
            }
        });
        this.U.c.b.m.setOnClickListener(new View.OnClickListener() { // from class: xv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.s4(view);
            }
        });
        this.U.c.b.e.setOnClickListener(new View.OnClickListener() { // from class: yv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.t4(view);
            }
        });
        this.U.c.b.h.setOnClickListener(new View.OnClickListener() { // from class: zv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.u4(view);
            }
        });
        this.U.c.b.b.setOnClickListener(new View.OnClickListener() { // from class: aw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.v4(view);
            }
        });
        this.U.c.b.d.setOnClickListener(new View.OnClickListener() { // from class: tu1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.w4(view);
            }
        });
        this.U.c.b.j.setOnClickListener(new View.OnClickListener() { // from class: uu1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.x4(view);
            }
        });
        this.U.c.b.f.setOnClickListener(new View.OnClickListener() { // from class: wu1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.y4(view);
            }
        });
        this.U.c.b.k.setOnClickListener(new View.OnClickListener() { // from class: xu1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.z4(view);
            }
        });
        this.U.c.b.n.setOnLongClickListener(new View.OnLongClickListener() { // from class: yu1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.A4(view);
            }
        });
        this.U.c.b.m.setOnLongClickListener(new View.OnLongClickListener() { // from class: zu1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.C4(view);
            }
        });
        this.U.c.b.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: av1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f.S4(view, motionEvent);
            }
        });
        this.U.i.setOnTouchListener(new View.OnTouchListener() { // from class: bv1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f.D4(view, motionEvent);
            }
        });
    }

    public final /* synthetic */ void K4(View view) {
        c5();
    }

    public final void K5() {
        H5(q24.g());
        this.U.c.b.h.setActivated(q24.J());
        this.U.c.b.b.setActivated(q24.w());
        this.U.c.b.d.setActivated(q24.D());
        this.U.i.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: rv1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.a.M4(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    @Override // defpackage.zb3, defpackage.xg
    public void L1(Bundle bundle) {
        super.L1(bundle);
        this.b0 = p60.l(this, this.U.e);
        R1(this.U.c.getRoot());
        S1(this.U.h, true);
        this.Z = new x43() { // from class: jv1
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.w5((Epg) obj);
            }
        };
        this.X = new x43() { // from class: kv1
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.W5((Result) obj);
            }
        };
        this.c0 = new ArrayList();
        this.g0 = new lv1(this);
        this.h0 = new Runnable() { // from class: mv1
            @Override // java.lang.Runnable
            public final void run() {
                this.f.J5();
            }
        };
        this.i0 = new Runnable() { // from class: nv1
            @Override // java.lang.Runnable
            public final void run() {
                this.f.k4();
            }
        };
        this.l0 = new bb3();
        F5();
        K5();
        L5();
    }

    public final /* synthetic */ void L4() {
        di4.V2().Z2(this.U.e.getSubtitleView()).W2(true).Y2(this);
    }

    public final void L5() {
        ry1 ry1Var = (ry1) new x(this).b(ry1.class);
        this.a0 = ry1Var;
        ry1Var.G().g(this.X);
        this.a0.H().f(this, new x43() { // from class: sv1
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.x5(((Boolean) obj).booleanValue());
            }
        });
        this.a0.q().g(this.Z);
        this.a0.C().f(this, new x43() { // from class: tv1
            @Override // defpackage.x43
            public final void a(Object obj) {
                this.a.N4((Live) obj);
            }
        });
    }

    @Override // p60.a
    public void M0(int i) {
        this.U.j.s.setVisibility(0);
        this.U.j.u.setProgress(i);
        if (i < 35) {
            this.U.j.t.setImageResource(fl3.A);
            return;
        }
        h3 h3Var = this.U;
        if (i < 70) {
            h3Var.j.t.setImageResource(fl3.B);
        } else {
            h3Var.j.t.setImageResource(fl3.z);
        }
    }

    public final /* synthetic */ void M4(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.l0.f(this, view);
    }

    public final void M5(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width == i) {
            return;
        }
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    public final /* synthetic */ void N4(Live live) {
        this.a0.E(live);
        y5(live);
        O5(live);
    }

    public final void N5(Epg epg) {
        int iA = vr3.a(48);
        if (epg.getList().isEmpty()) {
            return;
        }
        int iO = vr3.o(epg.getList().get(0).getTime(), 12);
        if (epg.getWidth() == 0) {
            Iterator<EpgData> it = epg.getList().iterator();
            while (it.hasNext()) {
                epg.setWidth(Math.max(epg.getWidth(), vr3.o(it.next().getTitle(), 14)));
            }
        }
        M5(this.U.d, epg.getWidth() != 0 ? Math.min(Math.max(epg.getWidth(), iO) + iA, vr3.j() / 2) : 0);
    }

    public final void O4() {
        Group group = this.f0;
        if (group == null) {
            return;
        }
        int position = group.getPosition() + 1;
        boolean z = position > this.V.g() - 1;
        if (q24.w() && z) {
            P4();
        } else {
            Group group2 = this.f0;
            if (z) {
                position = 0;
            }
            group2.setPosition(position);
        }
        if (this.f0.isEmpty()) {
            return;
        }
        i0(this.f0.current());
    }

    public final void O5(Live live) {
        int iA = vr3.a(48);
        if (live.getWidth() == 0) {
            Iterator<Group> it = live.getGroups().iterator();
            while (it.hasNext()) {
                live.setWidth(Math.max(live.getWidth(), vr3.o(it.next().getName(), 14)));
            }
        }
        M5(this.U.f, live.getWidth() == 0 ? 0 : Math.min(live.getWidth() + iA, vr3.j() / 4));
    }

    @Override // p60.a
    public void P() {
        this.U.j.q.clearAnimation();
        this.U.c.b.m.setText(K2().q0(1.0f));
    }

    @Override // uj1.a
    public void P0(CharSequence charSequence) {
        ge3.f(this, K2().I(), K2().A(), charSequence);
        T2(true);
    }

    @Override // defpackage.xg
    public void P1() {
        if (N1(this.U.c.getRoot())) {
            h4();
            return;
        }
        if (N1(this.U.j.g)) {
            k4();
            return;
        }
        if (N1(this.U.h)) {
            m4();
        } else {
            if (u2()) {
                return;
            }
            if (isTaskRoot()) {
                startActivity(new Intent(this, (Class<?>) HomeActivity.class).addFlags(872415232));
            }
            super.P1();
        }
    }

    public final boolean P4() {
        int iL = this.Y.L() + 1;
        if (iL > this.Y.g() - 1) {
            iL = 0;
        }
        if (this.f0.equals(this.Y.K(iL))) {
            return false;
        }
        this.f0 = this.Y.K(iL);
        this.Y.Q(iL);
        if (this.f0.skip()) {
            return P4();
        }
        this.V.I(this.f0.getChannel());
        this.f0.setPosition(0);
        return true;
    }

    public final void P5() {
        if (Q2() == null || isInPictureInPictureMode()) {
            return;
        }
        this.U.c.g.setVisibility(K2().N() ? 8 : 0);
        this.U.c.e.setVisibility(K2().N() ? 8 : 0);
        this.U.c.k.d.setVisibility(u2() ? 8 : 0);
        this.U.c.f.setVisibility(u2() ? 8 : 0);
        this.U.c.d.setVisibility(u2() ? 8 : 0);
        this.U.c.c.setVisibility(u2() ? 8 : 0);
        this.U.c.n.setVisibility(u2() ? 8 : 0);
        this.U.c.getRoot().setVisibility(0);
        D5();
        k4();
    }

    @Override // uq.a
    public void Q0() {
        K2().v0();
    }

    public final void Q3(Channel channel) {
        e4().add(channel);
        Keep keep = new Keep();
        keep.setKey(channel.getName());
        keep.setType(1);
        keep.save();
    }

    public final void Q4(boolean z) {
        Channel channel = this.e0;
        if (channel == null || channel.isOnly()) {
            return;
        }
        this.e0.switchLine(true);
        if (z) {
            S5();
        } else {
            z5();
        }
        Z3();
    }

    public final void Q5(Channel channel) {
        Channel channel2 = this.e0;
        if (channel2 == null || channel2.getData(this.a0.v()).getList().isEmpty() || this.W.g() == 0 || !this.e0.equals(channel) || !this.e0.getGroup().equals(this.f0)) {
            return;
        }
        s5(this.U.d, channel.getData(this.a0.v()).getSelected());
        this.U.d.setVisibility(0);
        this.U.b.setVisibility(8);
        this.U.f.setVisibility(8);
    }

    public final ph2 R3() {
        return me3.o(this.e0.getShow(), this.U.j.o.getText().toString(), this.e0.getLogo());
    }

    public final void R4() {
        D5();
        q24.O(!q24.w());
        this.U.c.b.b.setActivated(q24.w());
    }

    public final void R5(String str) {
        this.U.j.f.setVisibility(0);
        this.U.j.f.setText(str);
        l4();
    }

    @Override // mb1.a
    public void S(Group group) {
        int iA = vr3.a(56);
        int iA2 = vr3.a(60);
        if (group.isKeep()) {
            group.setWidth(0);
        }
        if (group.getWidth() == 0) {
            for (Channel channel : group.getChannel()) {
                group.setWidth(Math.max(group.getWidth(), (channel.getLogo().isEmpty() ? 0 : iA) + vr3.o(channel.getNumber() + channel.getName(), 14)));
            }
        }
        M5(this.U.b, group.getWidth() != 0 ? Math.min(group.getWidth() + iA2, vr3.j() / 2) : 0);
    }

    public final void S3() {
        if (N1(this.U.c.getRoot())) {
            P5();
        }
    }

    public final boolean S4(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        D5();
        return false;
    }

    public final void S5() {
        this.U.j.h.setVisibility(isInPictureInPictureMode() ? 0 : 8);
        this.U.j.g.setVisibility(isInPictureInPictureMode() ? 8 : 0);
        E5();
        h4();
        z5();
    }

    public final void T3() {
        if (K2().P()) {
            W3();
        } else {
            O4();
        }
    }

    public final void T4() {
        finish();
    }

    public final void T5() {
        this.U.g.getRoot().setVisibility(0);
        App.e(this.h0, 0L);
        j4();
    }

    public final void U3() {
        if (n4()) {
            lx1.J().U().n(b4());
        } else {
            f4();
        }
    }

    public final void U4() {
        uq.c3().p3(new CastVideo(this.U.c.m.getText().toString(), K2().I(), -9223372036854775807L, K2().A())).d3(false).o3(this);
    }

    public final void U5() {
        if (N1(this.U.h) || this.Y.g() == 0) {
            return;
        }
        this.U.h.setVisibility(0);
        this.U.b.requestFocus();
        B5();
        i4();
    }

    public final void V3() {
        this.U.c.k.b.setImageResource(u2() ? fl3.j : fl3.i);
    }

    public final void V4() {
        D5();
        q24.V(!q24.D());
        this.U.c.b.d.setActivated(q24.D());
    }

    public final void W3() {
        int inRange = this.e0.getData(this.a0.v()).getInRange();
        int selected = this.e0.getData(this.a0.v()).getSelected() + 1;
        if (selected > inRange || selected <= 0) {
            Z3();
        } else {
            I0(this.e0.getData(this.a0.v()).getList().get(selected));
        }
    }

    public final void W4() {
        me1.d(this).f().j(1).i();
        h4();
    }

    public final void W5(Result result) {
        String realUrl = result.getRealUrl();
        this.d0 = realUrl;
        X2(realUrl, result, false, d4().getTimeout(), R3());
    }

    public final void X3() {
        if (K2().S()) {
            e5();
        } else {
            f5();
        }
    }

    public final void X4() {
        K2().z0();
        D5();
        u5();
        v5();
    }

    public final void X5() {
        if (q24.D() && !this.e0.isLast()) {
            Q4(true);
        }
    }

    public final void Y3(Channel channel) {
        if (this.f0.isKeep()) {
            this.V.P(channel);
        }
        e4().getChannel().remove(channel);
        Keep.delete(channel.getName());
    }

    public final void Y4() {
        K2().A0();
        D5();
        v5();
        u5();
        d2();
    }

    public final void Y5(String str) {
        Iterator it = this.c0.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Group group = (Group) it.next();
            if (str == null || str.equals(group.getPass())) {
                this.Y.H(group);
                if (z) {
                    Z(group);
                }
                it.remove();
                z = false;
            }
        }
    }

    @Override // mb1.a
    public void Z(Group group) {
        mb1 mb1Var = this.Y;
        this.f0 = group;
        mb1Var.R(group);
        this.V.I(group.getChannel());
        this.V.R(group.getPosition());
        s5(this.U.b, Math.max(group.getPosition(), 0));
        if (group.isKeep()) {
            int i = this.k0 + 1;
            this.k0 = i;
            if (i < 5 || this.c0.isEmpty()) {
                return;
            }
            if (uj.b()) {
                uj.e(this);
            } else {
                w83.V2().Y2(this);
            }
            r5();
        }
    }

    public final void Z3() {
        if (this.e0 == null) {
            return;
        }
        lx1.J().j0(this.e0);
        this.a0.t(this.e0);
        K2().s();
        K2().v0();
        T5();
    }

    public final void Z4() {
        if (lx1.Y()) {
            B(d4());
        } else {
            yx1.i(this).n();
        }
        h4();
    }

    public final void Z5() {
        Channel channel = this.e0;
        boolean z = channel != null && channel.isRtsp();
        this.U.c.b.k.setVisibility(z ? 0 : 8);
        if (z) {
            this.U.c.b.k.setText(vr3.n(dk3.i)[q24.m()]);
        }
    }

    public final void a4(EpgData epgData) {
        Channel channel = this.e0;
        if (channel == null) {
            return;
        }
        this.a0.u(channel, epgData);
        K2().s();
        K2().v0();
        m4();
    }

    public final void a5() {
        uj1.d(this).o(this.U.c.m.getText()).f(K2().A()).p(K2().I()).n();
    }

    @Override // defpackage.gz
    public void b0(Config config) {
        lx1.b0(config, c4(lx1.J().i()));
    }

    public final void b5() {
        D5();
        q24.e0(!q24.J());
        this.U.c.b.h.setActivated(q24.J());
    }

    public final to c4(Config config) {
        return new d(config);
    }

    public final void c5() {
        Q4(false);
    }

    public final Live d4() {
        return lx1.J().M();
    }

    public final void d5() {
        S2(!u2());
        setRequestedOrientation(g4());
        this.b0.C(u2());
        V3();
        P5();
    }

    @Override // p60.a
    public void e0(long j) {
        if (K2().P()) {
            return;
        }
        this.U.j.b.setImageResource(j > 0 ? fl3.x : fl3.y);
        this.U.j.r.setText(K2().F(j));
        this.U.j.p.setVisibility(0);
        l4();
    }

    public final Group e4() {
        return this.Y.K(0);
    }

    public final void e5() {
        if (K2().Q()) {
            K2().X();
        } else {
            i2().pause();
        }
    }

    @Override // rr.a
    public boolean f0(Channel channel) {
        if (this.f0.isHidden()) {
            return false;
        }
        boolean zExist = Keep.exist(channel.getName());
        i43.h(zExist ? sm3.L : sm3.K);
        if (zExist) {
            Y3(channel);
            return true;
        }
        Q3(channel);
        return true;
    }

    public final void f4() {
        this.U.c.b.g.setText(lx1.Y() ? getString(sm3.N) : d4().getName());
        this.a0.D(d4());
        T5();
    }

    public final void f5() {
        if (K2().Q()) {
            K2().Y();
        } else {
            i2().play();
        }
    }

    public final int g4() {
        return u2() ? vr3.i(this) : (!o4() && vr3.r(this)) ? 6 : 12;
    }

    public final void g5() {
        D5();
        G5(!o4());
        setRequestedOrientation(vr3.r(this) ? 12 : 6);
    }

    public final void h4() {
        this.U.c.getRoot().setVisibility(8);
        App.f(this.g0);
    }

    public final void h5() {
        int iM = q24.m();
        String[] strArrN = vr3.n(dk3.i);
        int length = (iM + 1) % strArrN.length;
        q24.n0(length);
        this.U.c.b.k.setText(strArrN[length]);
    }

    @Override // rr.a
    public void i0(Channel channel) {
        Channel channel2;
        if (!channel.getData(this.a0.v()).getList().isEmpty() && channel.isSelected() && (channel2 = this.e0) != null && channel2.equals(channel) && this.e0.getGroup().equals(this.f0)) {
            Q5(channel);
            return;
        }
        Group group = this.f0;
        if (group != null) {
            group.setPosition(this.V.Q(channel.group(group)));
            this.e0 = channel;
            t5();
            S5();
            m4();
            Z3();
        }
    }

    public final void i4() {
        this.U.b.setVisibility(0);
        this.U.f.setVisibility(0);
        this.U.d.setVisibility(8);
    }

    public final void i5() {
        int iG = q24.g();
        String[] strArrN = vr3.n(dk3.j);
        if (this.b0.m() != 1.0f) {
            this.b0.A();
        } else {
            H5(iG == strArrN.length + (-1) ? 0 : iG + 1);
        }
        D5();
    }

    public final void j4() {
        this.U.j.f.setVisibility(8);
        this.U.j.f.setText("");
    }

    public final void j5() {
        this.U.c.b.m.setText(K2().n());
        D5();
    }

    @Override // p60.a
    public void k0() {
        if (N1(this.U.h)) {
            m4();
        }
        if (N1(this.U.c.getRoot())) {
            h4();
        } else {
            P5();
        }
    }

    public final void k4() {
        this.U.j.h.setVisibility(8);
        this.U.j.g.setVisibility(8);
        App.f(this.i0);
    }

    public final boolean k5() {
        this.U.c.b.m.setText(K2().B0());
        D5();
        return true;
    }

    public final void l4() {
        this.U.g.getRoot().setVisibility(8);
        App.f(this.h0);
        yr4.b();
    }

    public final boolean l5() {
        if (!K2().M(3)) {
            return false;
        }
        z0();
        return true;
    }

    @Override // p60.a
    public void m0() {
        if (q24.J()) {
            O4();
        } else {
            o5();
        }
    }

    @Override // defpackage.zb3
    public PlayerView m2() {
        return this.U.e;
    }

    public final void m4() {
        if (M1(this.U.h)) {
            return;
        }
        this.U.h.setVisibility(8);
        B5();
    }

    public final void m5() {
        if (N1(this.U.c.getRoot())) {
            h4();
        } else if (N1(this.U.h)) {
            m4();
        } else {
            U5();
        }
        k4();
    }

    @Override // defpackage.u83
    public void n0(String str) {
        Y5(str);
    }

    @Override // defpackage.zb3
    public PlaybackService.NavigationCallback n2() {
        return this.m0;
    }

    public final boolean n4() {
        return getIntent().getBooleanExtra("empty", true);
    }

    public final void n5(View view) {
        xq4.a3().j3(Integer.parseInt(view.getTag().toString())).g3(K2()).h3(this);
        h4();
    }

    @Override // defpackage.zb3
    public String o2() {
        return this.d0;
    }

    public boolean o4() {
        return this.j0;
    }

    public final void o5() {
        Group group = this.f0;
        if (group == null) {
            return;
        }
        int position = group.getPosition() - 1;
        boolean z = position < 0;
        if (q24.w() && z) {
            p5();
        } else {
            Group group2 = this.f0;
            if (z) {
                position = this.V.g() - 1;
            }
            group2.setPosition(position);
        }
        if (this.f0.isEmpty()) {
            return;
        }
        i0(this.f0.current());
    }

    @Override // defpackage.x7, defpackage.iy, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        jy4.m(this);
    }

    @Override // defpackage.xg, defpackage.u51, defpackage.iy, defpackage.ky, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jy4.m(this);
    }

    @Override // defpackage.zb3, defpackage.xg, defpackage.x7, defpackage.u51, android.app.Activity
    public void onDestroy() {
        db4.f().d();
        App.g(this.g0, this.h0, this.i0);
        this.a0.G().k(this.X);
        this.a0.q().k(this.Z);
        super.onDestroy();
    }

    @Override // defpackage.iy, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        super.onPictureInPictureModeChanged(z, configuration);
        if (z) {
            h4();
            k4();
            m4();
        } else {
            k4();
            if (y2()) {
                finish();
            }
        }
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onRefreshEvent(qp3 qp3Var) {
        int i = e.a[qp3Var.e().ordinal()];
        if (i == 1) {
            B(d4());
        } else {
            if (i != 2) {
                return;
            }
            Z3();
        }
    }

    @Override // defpackage.x7, defpackage.u51, android.app.Activity
    public void onStart() {
        super.onStart();
        R2(false);
        V2(false);
    }

    @Override // defpackage.zb3, defpackage.x7, defpackage.u51, android.app.Activity
    public void onStop() {
        super.onStop();
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
            App.e(new Runnable() { // from class: su1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.d5();
                }
            }, 500L);
        }
        if (K2().M(2)) {
            this.l0.b(this, K2().K(), K2().J(), q24.g());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            jy4.m(this);
        }
    }

    @Override // p60.a
    public void p0() {
        if (q24.J()) {
            o5();
        } else {
            O4();
        }
    }

    @Override // defpackage.zb3
    public CustomSeekView p2() {
        return this.U.c.l;
    }

    public final boolean p5() {
        int iL = this.Y.L() - 1;
        if (iL < 0) {
            iL = this.Y.g() - 1;
        }
        if (this.f0.equals(this.Y.K(iL))) {
            return false;
        }
        this.f0 = this.Y.K(iL);
        this.Y.Q(iL);
        if (this.f0.skip()) {
            return p5();
        }
        this.V.I(this.f0.getChannel());
        Group group = this.f0;
        group.setPosition(group.getChannel().size() - 1);
        return true;
    }

    public final void q5() {
        this.U.c.b.i.setVisibility(8);
        this.U.c.m.setText("");
        this.W.I();
        this.V.J();
        this.Y.J();
        this.c0.clear();
        this.e0 = null;
        this.f0 = null;
    }

    @Override // p60.a
    public void r0(long j) {
        if (K2().P()) {
            return;
        }
        P2(j);
    }

    public final /* synthetic */ void r4(View view) {
        i5();
    }

    public final void r5() {
        this.k0 = 0;
    }

    public final /* synthetic */ void s4(View view) {
        j5();
    }

    public final void s5(final RecyclerView recyclerView, final int i) {
        recyclerView.post(new Runnable() { // from class: pv1
            @Override // java.lang.Runnable
            public final void run() {
                recyclerView.t1(i);
            }
        });
    }

    public final /* synthetic */ void t4(View view) {
        W4();
    }

    public final void t5() {
        si1.g(this, this.e0.getLogo(), new b());
    }

    @Override // p60.a
    public void u0() {
        if (!K2().P() && K2().S()) {
            this.U.j.q.setVisibility(0);
            this.U.j.q.startAnimation(vr3.b(zj3.a));
            this.U.c.b.m.setText(K2().q0(q24.p()));
        }
    }

    public final /* synthetic */ void u4(View view) {
        b5();
    }

    public final void u5() {
        this.U.c.b.f.setText(K2().y());
    }

    public final /* synthetic */ void v4(View view) {
        R4();
    }

    public final void v5() {
        this.U.c.b.j.setText(K2().Q() ? sm3.a0 : sm3.X);
    }

    public final /* synthetic */ void w4(View view) {
        V4();
    }

    public final void w5(Epg epg) {
        Channel channel = this.e0;
        if (channel == null || !channel.getTvgId().equals(epg.getKey())) {
            return;
        }
        EpgData epgData = epg.getEpgData();
        boolean zIsEmpty = epgData.getTitle().isEmpty();
        this.W.H(epg.getList());
        if (!zIsEmpty) {
            this.U.c.m.setText(getString(sm3.m, this.e0.getShow(), epgData.getTitle()));
        }
        this.U.j.k.setMaxEms(!zIsEmpty ? 12 : 48);
        this.U.j.o.setText(epgData.format());
        N5(epg);
        A5();
    }

    public final /* synthetic */ void x4(View view) {
        Y4();
    }

    public final void x5(boolean z) {
        Channel channel = this.e0;
        if (channel == null || !z) {
            return;
        }
        this.a0.s(channel);
    }

    public final /* synthetic */ void y4(View view) {
        X4();
    }

    public final void y5(Live live) {
        ArrayList arrayList = new ArrayList();
        for (Group group : live.getGroups()) {
            (group.isHidden() ? this.c0 : arrayList).add(group);
        }
        this.Y.I(arrayList);
        C5(lx1.J().I(arrayList));
    }

    @Override // xq4.a
    public void z0() {
        App.e(new lv1(this), 200L);
        App.e(new Runnable() { // from class: qv1
            @Override // java.lang.Runnable
            public final void run() {
                this.f.L4();
            }
        }, 200L);
    }

    public final /* synthetic */ void z4(View view) {
        h5();
    }

    public final void z5() {
        this.a0.s(this.e0);
        this.U.j.o.setText("");
        this.U.j.k.setMaxEms(48);
        this.e0.loadLogo(this.U.j.j);
        this.U.c.m.setSelected(true);
        this.U.j.i.setText(this.e0.getLine());
        this.U.j.k.setText(this.e0.getShow());
        this.U.c.m.setText(this.e0.getShow());
        this.U.j.l.setText(this.e0.getShow());
        this.U.j.m.setText(this.e0.getNumber());
        this.U.j.n.setText(this.e0.getNumber());
        this.U.j.i.setVisibility(this.e0.getLineVisible());
        h3 h3Var = this.U;
        h3Var.c.b.i.setText(h3Var.j.i.getText());
        h3 h3Var2 = this.U;
        h3Var2.c.b.i.setVisibility(h3Var2.j.i.getVisibility());
        Z5();
        v5();
    }
}
