package com.fongmi.android.tv;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import defpackage.fc1;
import defpackage.i43;
import defpackage.rf1;
import defpackage.yj1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class App extends Application implements Application.ActivityLifecycleCallbacks {
    public static volatile App k;
    public final Handler f;
    public final Gson g;
    public final long h;
    public Activity i;
    public rf1 j;

    public App() {
        k = this;
        this.g = new Gson();
        this.h = System.currentTimeMillis();
        this.f = fc1.a(Looper.getMainLooper());
    }

    public static Activity a() {
        return b().i;
    }

    public static App b() {
        return k;
    }

    public static Gson c() {
        return b().g;
    }

    public static void d(Runnable runnable) {
        b().f.post(runnable);
    }

    public static void e(Runnable runnable, long j) {
        b().f.removeCallbacks(runnable);
        if (j >= 0) {
            b().f.postDelayed(runnable, j);
        }
    }

    public static void f(Runnable runnable) {
        b().f.removeCallbacks(runnable);
    }

    public static void g(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            b().f.removeCallbacks(runnable);
        }
    }

    public static long i() {
        return b().h;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        yj1.c(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        rf1 rf1Var = this.j;
        return rf1Var != null ? rf1Var : getBaseContext().getPackageManager();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        rf1 rf1Var = this.j;
        return rf1Var != null ? rf1Var.a() : getBaseContext().getPackageName();
    }

    public void h(rf1 rf1Var) {
        this.j = rf1Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity == a()) {
            this.i = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity != a()) {
            this.i = activity;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        i43.b();
        registerActivityLifecycleCallbacks(this);
    }
}
