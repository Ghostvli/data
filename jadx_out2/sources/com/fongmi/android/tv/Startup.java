package com.fongmi.android.tv;

import android.content.Context;
import com.fongmi.android.tv.ui.activity.CrashActivity;
import defpackage.an0;
import defpackage.bk1;
import defpackage.bq;
import defpackage.d6;
import defpackage.g02;
import defpackage.o01;
import defpackage.og3;
import defpackage.q24;
import defpackage.q53;
import defpackage.uu0;
import defpackage.vv4;
import defpackage.xu0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Startup implements bk1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: create(Landroid/content/Context;)Ljava/lang/Object; */
    @Override // defpackage.bk1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void create(Context context) {
        bq.a.c().e(true).b(0).d(CrashActivity.class).a();
        g02.a(new d6(og3.k().b(0).c(false).d("TV").a()));
        g02.a(new o01(context));
        vv4.a(context);
        uu0.b().a(new xu0()).e();
        q53.m().i(an0.h(q24.c()));
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bk1
    public List dependencies() {
        return Collections.EMPTY_LIST;
    }
}
