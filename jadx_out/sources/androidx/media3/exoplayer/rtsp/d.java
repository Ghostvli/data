package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import androidx.media3.exoplayer.rtsp.RtspMediaSource;
import androidx.media3.exoplayer.rtsp.e;
import androidx.media3.exoplayer.rtsp.f;
import androidx.media3.exoplayer.rtsp.g;
import androidx.media3.exoplayer.rtsp.h;
import defpackage.a24;
import defpackage.fv3;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.gg4;
import defpackage.km1;
import defpackage.nv3;
import defpackage.r83;
import defpackage.rv3;
import defpackage.uv3;
import defpackage.vv3;
import defpackage.wn1;
import defpackage.wv3;
import defpackage.xi1;
import defpackage.xv3;
import defpackage.xz1;
import defpackage.yf2;
import defpackage.yi1;
import defpackage.yv3;
import defpackage.zi1;
import defpackage.zv3;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Closeable {
    public final f f;
    public final e g;
    public final String h;
    public final SocketFactory i;
    public final boolean j;
    public Uri n;
    public h.a p;
    public String q;
    public b s;
    public androidx.media3.exoplayer.rtsp.c t;
    public boolean v;
    public boolean w;
    public boolean x;
    public final ArrayDeque k = new ArrayDeque();
    public final SparseArray l = new SparseArray();
    public final C0022d m = new C0022d();
    public g o = new g(new c());
    public long r = RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS;
    public long y = -9223372036854775807L;
    public int u = -1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements Runnable, Closeable {
        public final Handler f = fy4.E();
        public final long g;
        public boolean h;

        public b(long j) {
            this.g = j;
        }

        public void a() {
            if (this.h) {
                return;
            }
            this.h = true;
            this.f.postDelayed(this, this.g);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.h = false;
            this.f.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.m.e(d.this.n, d.this.q);
            this.f.postDelayed(this, this.g);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements g.d {
        public final Handler a = fy4.E();

        public c() {
        }

        @Override // androidx.media3.exoplayer.rtsp.g.d
        public void c(final List list) {
            this.a.post(new Runnable() { // from class: mv3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.e(list);
                }
            });
        }

        public final void e(List list) {
            d.this.l0(list);
            if (h.e(list)) {
                g(list);
            } else {
                f(list);
            }
        }

        public final void f(List list) {
            d.this.m.d(Integer.parseInt((String) gg3.q(h.k(list).c.d("CSeq"))));
        }

        public final void g(List list) {
            xi1 xi1VarU;
            xv3 xv3VarL = h.l(list);
            int i = Integer.parseInt((String) gg3.q(xv3VarL.b.d("CSeq")));
            wv3 wv3Var = (wv3) d.this.l.get(i);
            if (wv3Var == null) {
                return;
            }
            d.this.l.remove(i);
            int i2 = wv3Var.b;
            try {
                try {
                    int i3 = xv3VarL.a;
                    if (i3 == 200) {
                        switch (i2) {
                            case 1:
                            case 3:
                            case 7:
                            case 8:
                            case 9:
                            case 11:
                            case 12:
                                return;
                            case 2:
                                h(new nv3(xv3VarL.b, i3, a24.b(xv3VarL.c)));
                                return;
                            case 4:
                                i(new uv3(i3, h.j(xv3VarL.b.d("Public"))));
                                return;
                            case 5:
                                j();
                                return;
                            case 6:
                                String strD = xv3VarL.b.d("Range");
                                yv3 yv3VarD = strD == null ? yv3.c : yv3.d(strD);
                                try {
                                    String strD2 = xv3VarL.b.d("RTP-Info");
                                    xi1VarU = strD2 == null ? xi1.u() : zv3.a(strD2, d.this.n);
                                } catch (r83 unused) {
                                    xi1VarU = xi1.u();
                                }
                                k(new vv3(xv3VarL.a, yv3VarD, xi1VarU));
                                return;
                            case 10:
                                String strD3 = xv3VarL.b.d("Session");
                                String strD4 = xv3VarL.b.d("Transport");
                                if (strD3 == null || strD4 == null) {
                                    throw r83.c("Missing mandatory session or transport header", null);
                                }
                                l(new i(xv3VarL.a, h.m(strD3), strD4));
                                return;
                            default:
                                throw new IllegalStateException();
                        }
                    }
                    if (i3 == 401) {
                        if (d.this.p == null || d.this.w) {
                            d.this.i0(new RtspMediaSource.c(h.t(i2) + " " + xv3VarL.a));
                            return;
                        }
                        xi1 xi1VarE = xv3VarL.b.e("WWW-Authenticate");
                        if (xi1VarE.isEmpty()) {
                            throw r83.c("Missing WWW-Authenticate header in a 401 response.", null);
                        }
                        for (int i4 = 0; i4 < xi1VarE.size(); i4++) {
                            d.this.t = h.o((String) xi1VarE.get(i4));
                            if (d.this.t.a == 2) {
                                break;
                            }
                        }
                        d.this.m.b();
                        d.this.w = true;
                        return;
                    }
                    if (i3 == 461) {
                        String str = h.t(i2) + " " + xv3VarL.a;
                        d.this.i0((i2 != 10 || ((String) gg3.q(wv3Var.c.d("Transport"))).contains("TCP")) ? new RtspMediaSource.c(str) : new RtspMediaSource.d(str));
                        return;
                    }
                    if (i3 != 301 && i3 != 302) {
                        d.this.i0(new RtspMediaSource.c(h.t(i2) + " " + xv3VarL.a));
                        return;
                    }
                    if (d.this.u != -1) {
                        d.this.u = 0;
                    }
                    String strD5 = xv3VarL.b.d("Location");
                    d dVar = d.this;
                    if (strD5 == null) {
                        dVar.f.b("Redirection without new location.", null);
                        return;
                    }
                    dVar.n = Uri.parse(strD5);
                    h.a aVarN = h.n(d.this.n);
                    if (aVarN != null) {
                        d.this.p = aVarN;
                    }
                    d.this.m.c(d.this.n, d.this.q);
                } catch (IllegalArgumentException e) {
                    e = e;
                    d.this.i0(new RtspMediaSource.c(e));
                }
            } catch (r83 e2) {
                e = e2;
                d.this.i0(new RtspMediaSource.c(e));
            }
        }

        public final void h(nv3 nv3Var) {
            yv3 yv3VarD = yv3.c;
            String str = (String) nv3Var.c.a.get("range");
            if (str != null) {
                try {
                    yv3VarD = yv3.d(str);
                } catch (r83 e) {
                    d.this.f.b("SDP format error.", e);
                    return;
                }
            }
            xi1 xi1VarG0 = d.g0(nv3Var, d.this.n);
            boolean zIsEmpty = xi1VarG0.isEmpty();
            d dVar = d.this;
            if (zIsEmpty) {
                dVar.f.b("No playable track.", null);
            } else {
                dVar.f.a(yv3VarD, xi1VarG0);
                d.this.v = true;
            }
        }

        public final void i(uv3 uv3Var) {
            if (d.this.s != null) {
                return;
            }
            boolean zP0 = d.p0(uv3Var.b);
            d dVar = d.this;
            if (zP0) {
                dVar.m.c(d.this.n, d.this.q);
            } else {
                dVar.f.b("DESCRIBE not supported.", null);
            }
        }

        public final void j() {
            gg3.v(d.this.u == 2);
            d.this.u = 1;
            d.this.x = false;
            if (d.this.y != -9223372036854775807L) {
                d dVar = d.this;
                dVar.t0(fy4.S1(dVar.y));
            }
        }

        public final void k(vv3 vv3Var) {
            boolean z = true;
            if (d.this.u != 1 && d.this.u != 2) {
                z = false;
            }
            gg3.v(z);
            d.this.u = 2;
            if (d.this.s == null) {
                d dVar = d.this;
                dVar.s = dVar.new b(dVar.r / 2);
                d.this.s.a();
            }
            d.this.y = -9223372036854775807L;
            d.this.g.d(fy4.c1(vv3Var.b.a), vv3Var.c);
        }

        public final void l(i iVar) {
            gg3.v(d.this.u != -1);
            d.this.u = 1;
            d.this.q = iVar.b.a;
            d.this.r = iVar.b.b;
            d.this.h0();
        }
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.rtsp.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class C0022d {
        public int a;
        public wv3 b;

        public C0022d() {
        }

        public final wv3 a(int i, String str, Map map, Uri uri) {
            String str2 = d.this.h;
            int i2 = this.a;
            this.a = i2 + 1;
            e.b bVar = new e.b(str2, str, i2);
            if (d.this.t != null) {
                gg3.q(d.this.p);
                try {
                    bVar.b("Authorization", d.this.t.a(d.this.p, uri, i));
                } catch (r83 e) {
                    d.this.i0(new RtspMediaSource.c(e));
                }
            }
            bVar.d(map);
            return new wv3(uri, i, bVar.e(), "");
        }

        public void b() {
            gg3.q(this.b);
            yi1 yi1VarB = this.b.c.b();
            HashMap map = new HashMap();
            for (String str : yi1VarB.keySet()) {
                if (!str.equals("CSeq") && !str.equals("User-Agent") && !str.equals("Session") && !str.equals("Authorization")) {
                    map.put(str, (String) km1.d(yi1VarB.get(str)));
                }
            }
            h(a(this.b.b, d.this.q, map, this.b.a));
        }

        public void c(Uri uri, String str) {
            h(a(2, str, zi1.k("Accept", "application/sdp"), uri));
        }

        public void d(int i) {
            i(new xv3(405, new e.b(d.this.h, d.this.q, i).e()));
            this.a = Math.max(this.a, i + 1);
        }

        public void e(Uri uri, String str) {
            h(a(4, str, zi1.j(), uri));
        }

        public void f(Uri uri, String str) {
            gg3.v(d.this.u == 2);
            h(a(5, str, zi1.j(), uri));
            d.this.x = true;
        }

        public void g(Uri uri, long j, String str) {
            boolean z = true;
            if (d.this.u != 1 && d.this.u != 2) {
                z = false;
            }
            gg3.v(z);
            h(a(6, str, zi1.k("Range", yv3.b(j)), uri));
        }

        public final void h(wv3 wv3Var) {
            int i = Integer.parseInt((String) gg3.q(wv3Var.c.d("CSeq")));
            gg3.v(d.this.l.get(i) == null);
            d.this.l.append(i, wv3Var);
            xi1 xi1VarQ = h.q(wv3Var);
            d.this.l0(xi1VarQ);
            d.this.o.t(xi1VarQ);
            this.b = wv3Var;
        }

        public final void i(xv3 xv3Var) {
            xi1 xi1VarR = h.r(xv3Var);
            d.this.l0(xi1VarR);
            d.this.o.t(xi1VarR);
        }

        public void j(Uri uri, String str, String str2) {
            d.this.u = 0;
            h(a(10, str2, zi1.k("Transport", str), uri));
        }

        public void k(Uri uri, String str) {
            if (d.this.u == -1 || d.this.u == 0) {
                return;
            }
            d.this.u = 0;
            h(a(12, str, zi1.j(), uri));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        void c();

        void d(long j, xi1 xi1Var);

        void e(RtspMediaSource.c cVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        void a(yv3 yv3Var, xi1 xi1Var);

        void b(String str, Throwable th);
    }

    public d(f fVar, e eVar, String str, Uri uri, SocketFactory socketFactory, boolean z) {
        this.f = fVar;
        this.g = eVar;
        this.h = str;
        this.i = socketFactory;
        this.j = z;
        this.n = h.p(uri);
        this.p = h.n(uri);
    }

    public static xi1 g0(nv3 nv3Var, Uri uri) {
        xi1.a aVar = new xi1.a();
        for (int i = 0; i < nv3Var.c.b.size(); i++) {
            yf2 yf2Var = (yf2) nv3Var.c.b.get(i);
            if (fv3.c(yf2Var)) {
                aVar.a(new rv3(nv3Var.a, yf2Var, uri));
            }
        }
        return aVar.k();
    }

    public static boolean p0(List list) {
        return list.isEmpty() || list.contains(2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b bVar = this.s;
        if (bVar != null) {
            bVar.close();
            this.s = null;
            this.m.k(this.n, (String) gg3.q(this.q));
        }
        this.o.close();
    }

    public final void h0() {
        f.e eVar = (f.e) this.k.pollFirst();
        if (eVar == null) {
            this.g.c();
        } else {
            this.m.j(eVar.c(), eVar.d(), this.q);
        }
    }

    public final void i0(Throwable th) {
        RtspMediaSource.c cVar = th instanceof RtspMediaSource.c ? (RtspMediaSource.c) th : new RtspMediaSource.c(th);
        if (this.v) {
            this.g.e(cVar);
        } else {
            this.f.b(gg4.d(th.getMessage()), th);
        }
    }

    public final Socket j0(Uri uri) {
        gg3.d(uri.getHost() != null);
        return this.i.createSocket((String) gg3.q(uri.getHost()), uri.getPort() > 0 ? uri.getPort() : 554);
    }

    public int k0() {
        return this.u;
    }

    public final void l0(List list) {
        if (this.j) {
            xz1.b("RtspClient", wn1.h("\n").e(list));
        }
    }

    public void m0(int i, g.b bVar) {
        this.o.l(i, bVar);
    }

    public void n0() {
        try {
            close();
            g gVar = new g(new c());
            this.o = gVar;
            gVar.i(j0(this.n));
            this.q = null;
            this.w = false;
            this.t = null;
        } catch (IOException e2) {
            this.g.e(new RtspMediaSource.c(e2));
        }
    }

    public void o0(long j) {
        if (this.u == 2 && !this.x) {
            this.m.f(this.n, (String) gg3.q(this.q));
        }
        this.y = j;
    }

    public void q0(List list) {
        this.k.addAll(list);
        h0();
    }

    public void r0() {
        this.u = 1;
    }

    public void s0() throws IOException {
        try {
            this.o.i(j0(this.n));
            this.m.e(this.n, this.q);
        } catch (IOException e2) {
            fy4.p(this.o);
            throw e2;
        }
    }

    public void t0(long j) {
        this.m.g(this.n, j, (String) gg3.q(this.q));
    }
}
