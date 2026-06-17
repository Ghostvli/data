package defpackage;

import android.content.Context;
import android.content.Intent;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.bu3;
import defpackage.jj4;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ma0 {
    public final Context a;
    public final String b;
    public final jj4.c c;
    public final bu3.e d;
    public final List e;
    public final boolean f;
    public final bu3.d g;
    public final Executor h;
    public final Executor i;
    public final Intent j;
    public final boolean k;
    public final boolean l;
    public final Set m;
    public final String n;
    public final File o;
    public final Callable p;
    public final List q;
    public final List r;
    public final boolean s;
    public final nw3 t;
    public final g40 u;
    public final boolean v;
    public boolean w;
    public int x;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ma0(Context context, String str, jj4.c cVar, bu3.e eVar, List list, boolean z, bu3.d dVar, Executor executor, Executor executor2, Intent intent, boolean z2, boolean z3, Set set, String str2, File file, Callable callable, bu3.f fVar, List list2, List list3, boolean z4, nw3 nw3Var, g40 g40Var) {
        context.getClass();
        eVar.getClass();
        dVar.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
        this.a = context;
        this.b = str;
        this.c = cVar;
        this.d = eVar;
        this.e = list;
        this.f = z;
        this.g = dVar;
        this.h = executor;
        this.i = executor2;
        this.j = intent;
        this.k = z2;
        this.l = z3;
        this.m = set;
        this.n = str2;
        this.o = file;
        this.p = callable;
        this.q = list2;
        this.r = list3;
        this.s = z4;
        this.t = nw3Var;
        this.u = g40Var;
        this.v = intent != null;
        this.w = true;
        this.x = 25;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ ma0 b(ma0 ma0Var, Context context, String str, jj4.c cVar, bu3.e eVar, List list, boolean z, bu3.d dVar, Executor executor, Executor executor2, Intent intent, boolean z2, boolean z3, Set set, String str2, File file, Callable callable, bu3.f fVar, List list2, List list3, boolean z4, nw3 nw3Var, g40 g40Var, int i, Object obj) {
        bu3.f fVar2;
        g40 g40Var2;
        nw3 nw3Var2;
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: copy");
            return null;
        }
        Context context2 = (i & 1) != 0 ? ma0Var.a : context;
        String str3 = (i & 2) != 0 ? ma0Var.b : str;
        jj4.c cVar2 = (i & 4) != 0 ? ma0Var.c : cVar;
        bu3.e eVar2 = (i & 8) != 0 ? ma0Var.d : eVar;
        List list4 = (i & 16) != 0 ? ma0Var.e : list;
        boolean z5 = (i & 32) != 0 ? ma0Var.f : z;
        bu3.d dVar2 = (i & 64) != 0 ? ma0Var.g : dVar;
        Executor executor3 = (i & 128) != 0 ? ma0Var.h : executor;
        Executor executor4 = (i & Buffer.DEFAULT_SIZE) != 0 ? ma0Var.i : executor2;
        Intent intent2 = (i & 512) != 0 ? ma0Var.j : intent;
        boolean z6 = (i & 1024) != 0 ? ma0Var.k : z2;
        boolean z7 = (i & 2048) != 0 ? ma0Var.l : z3;
        Set set2 = (i & okio.internal.Buffer.SEGMENTING_THRESHOLD) != 0 ? ma0Var.m : set;
        String str4 = (i & 8192) != 0 ? ma0Var.n : str2;
        Context context3 = context2;
        File file2 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? ma0Var.o : file;
        Callable callable2 = (i & 32768) != 0 ? ma0Var.p : callable;
        if ((i & 65536) != 0) {
            ma0Var.getClass();
            fVar2 = null;
        } else {
            fVar2 = fVar;
        }
        Callable callable3 = callable2;
        List list5 = (i & 131072) != 0 ? ma0Var.q : list2;
        List list6 = (i & 262144) != 0 ? ma0Var.r : list3;
        boolean z8 = (i & 524288) != 0 ? ma0Var.s : z4;
        nw3 nw3Var3 = (i & 1048576) != 0 ? ma0Var.t : nw3Var;
        if ((i & 2097152) != 0) {
            nw3Var2 = nw3Var3;
            g40Var2 = ma0Var.u;
        } else {
            g40Var2 = g40Var;
            nw3Var2 = nw3Var3;
        }
        return ma0Var.a(context3, str3, cVar2, eVar2, list4, z5, dVar2, executor3, executor4, intent2, z6, z7, set2, str4, file2, callable3, fVar2, list5, list6, z8, nw3Var2, g40Var2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ma0 a(Context context, String str, jj4.c cVar, bu3.e eVar, List list, boolean z, bu3.d dVar, Executor executor, Executor executor2, Intent intent, boolean z2, boolean z3, Set set, String str2, File file, Callable callable, bu3.f fVar, List list2, List list3, boolean z4, nw3 nw3Var, g40 g40Var) {
        context.getClass();
        eVar.getClass();
        dVar.getClass();
        executor.getClass();
        executor2.getClass();
        list2.getClass();
        list3.getClass();
        ma0 ma0Var = new ma0(context, str, cVar, eVar, list, z, dVar, executor, executor2, intent, z2, z3, set, str2, file, callable, fVar, list2, list3, z4, nw3Var, g40Var);
        ma0Var.w = this.w;
        ma0Var.x = this.x;
        return ma0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Set c() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int d() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean e() {
        return this.w;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f(int i, int i2) {
        return jt2.d(this, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(boolean z) {
        this.w = z;
    }
}
