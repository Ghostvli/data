package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class v5 {
    public static final Uri g = Uri.parse("content://androidx.car.app.connection");
    public final Context a;
    public final Runnable b;
    public final Executor c;
    public final b d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b extends BroadcastReceiver {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Executor executor = v5.this.c;
            final v5 v5Var = v5.this;
            executor.execute(new Runnable() { // from class: w5
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    v5Var.h();
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v5(Context context, Runnable runnable) {
        this.a = context.getApplicationContext();
        this.b = runnable;
        Executor executorA = sf.a();
        this.c = executorA;
        this.d = new b();
        this.e = new AtomicBoolean();
        this.f = new AtomicBoolean();
        executorA.execute(new Runnable() { // from class: u5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                v5.a(this.f);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(v5 v5Var) {
        v5Var.getClass();
        IntentFilter intentFilter = new IntentFilter("androidx.car.app.connection.action.CAR_CONNECTION_UPDATED");
        int i = Build.VERSION.SDK_INT;
        Context context = v5Var.a;
        b bVar = v5Var.d;
        if (i >= 33) {
            context.registerReceiver(bVar, intentFilter, 2);
        } else {
            context.registerReceiver(bVar, intentFilter);
        }
        v5Var.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e() {
        return this.e.get();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public final boolean f() {
        Cursor cursorQuery;
        try {
            cursorQuery = this.a.getContentResolver().query(g, new String[]{"CarConnectionState"}, null, null, null);
        } catch (Exception unused) {
            return false;
        }
        if (cursorQuery == null) {
            if (cursorQuery != null) {
            }
            return false;
        }
        try {
            int columnIndex = cursorQuery.getColumnIndex("CarConnectionState");
            if (columnIndex != -1 && cursorQuery.moveToNext()) {
                boolean z = cursorQuery.getInt(columnIndex) != 0;
                cursorQuery.close();
                return z;
            }
        } finally {
        }
        return false;
        cursorQuery.close();
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g() {
        if (this.f.getAndSet(true)) {
            return;
        }
        this.c.execute(new Runnable() { // from class: t5
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                v5 v5Var = this.f;
                v5Var.a.unregisterReceiver(v5Var.d);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        boolean z = this.e.get();
        boolean zF = f();
        this.e.set(zF);
        if (z == zF || this.f.get()) {
            return;
        }
        this.b.run();
    }
}
