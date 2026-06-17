package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import cat.ereza.customactivityoncrash.activity.DefaultErrorActivity;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c60 {
    public static Application a;
    public static bq b = new bq();
    public static final Deque c = new ArrayDeque(50);
    public static WeakReference d = new WeakReference(null);
    public static long e = 0;
    public static boolean f = true;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Application.ActivityLifecycleCallbacks {
        public int f = 0;
        public final DateFormat g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity.getClass() != c60.b.A()) {
                WeakReference unused = c60.d = new WeakReference(activity);
                long unused2 = c60.e = new Date().getTime();
            }
            if (c60.b.J()) {
                c60.c.add(this.g.format(new Date()) + ": " + activity.getClass().getSimpleName() + " created\n");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (c60.b.J()) {
                c60.c.add(this.g.format(new Date()) + ": " + activity.getClass().getSimpleName() + " destroyed\n");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (c60.b.J()) {
                c60.c.add(this.g.format(new Date()) + ": " + activity.getClass().getSimpleName() + " paused\n");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (c60.b.J()) {
                c60.c.add(this.g.format(new Date()) + ": " + activity.getClass().getSimpleName() + " resumed\n");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i = this.f + 1;
            this.f = i;
            boolean unused = c60.f = i == 0;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i = this.f - 1;
            this.f = i;
            boolean unused = c60.f = i == 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b extends Serializable {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c extends Serializable {
    }

    public static void A() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    public static void B(Activity activity, bq bqVar) {
        C(activity, new Intent(activity, (Class<?>) bqVar.E()), bqVar);
    }

    public static void C(Activity activity, Intent intent, bq bqVar) {
        intent.addFlags(270565376);
        if (intent.getComponent() != null) {
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
        }
        bqVar.C();
        activity.finish();
        activity.startActivity(intent);
        A();
    }

    public static void D(bq bqVar) {
        b = bqVar;
    }

    public static void E(Context context, long j) {
        context.getSharedPreferences("custom_activity_on_crash", 0).edit().putLong("last_crash_timestamp", j).commit();
    }

    public static /* synthetic */ void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        if (!b.F()) {
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            return;
        }
        Log.e("CustomActivityOnCrash", "App has crashed, executing CustomActivityOnCrash's UncaughtExceptionHandler", th);
        if (x(a)) {
            Log.e("CustomActivityOnCrash", "App already crashed recently, not starting custom error activity because we could enter a restart loop. Are you sure that your app does not crash directly on init?", th);
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
        } else {
            E(a, new Date().getTime());
            Class clsA = b.A();
            if (clsA == null) {
                clsA = v(a);
            }
            if (z(th, clsA)) {
                Log.e("CustomActivityOnCrash", "Your application class or your error activity have crashed, the custom activity will not be launched!");
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                    return;
                }
            } else if (b.y() == 1 || !f || e >= new Date().getTime() - 500) {
                Intent intent = new Intent(a, (Class<?>) clsA);
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                String string = stringWriter.toString();
                if (string.length() > 131071) {
                    string = string.substring(0, 131047).concat(" [stack trace too large]");
                }
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE", string);
                b.z();
                if (b.J()) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        Deque deque = c;
                        if (deque.isEmpty()) {
                            break;
                        } else {
                            sb.append((String) deque.poll());
                        }
                    }
                    intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_ACTIVITY_LOG", sb.toString());
                }
                if (b.I() && b.E() == null) {
                    b.K(w(a));
                }
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_CONFIG", b);
                intent.setFlags(268468224);
                b.C();
                a.startActivity(intent);
            } else if (b.y() == 2 && uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
        }
        Activity activity = (Activity) d.get();
        if (activity != null) {
            activity.finish();
            d.clear();
        }
        A();
    }

    public static String g(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char cCharAt = str.charAt(0);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        return Character.toUpperCase(cCharAt) + str.substring(1);
    }

    public static void h(Activity activity, bq bqVar) {
        bqVar.C();
        activity.finish();
        A();
    }

    public static String i(Intent intent) {
        return intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_ACTIVITY_LOG");
    }

    public static String j(Context context, Intent intent) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        String strK = k(context, simpleDateFormat);
        String str = "Build version: " + u(context) + " \n";
        if (strK != null) {
            str = str + "Build date: " + strK + " \n";
        }
        String strConcat = (((str + "Current date: " + simpleDateFormat.format(date) + " \n") + "Device: " + o() + " \n") + "OS version: Android " + Build.VERSION.RELEASE + " (SDK " + Build.VERSION.SDK_INT + ") \n \n").concat("Stack trace:  \n");
        StringBuilder sb = new StringBuilder();
        sb.append(strConcat);
        sb.append(t(intent));
        String string = sb.toString();
        String strI = i(intent);
        if (strI != null) {
            string = string.concat("\nUser actions: \n").concat(strI);
        }
        String strN = n(intent);
        return strN != null ? string.concat("\nAdditional data: \n").concat(strN) : string;
    }

    public static String k(Context context, DateFormat dateFormat) {
        long time;
        try {
            ZipFile zipFile = new ZipFile(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir);
            time = zipFile.getEntry("classes.dex").getTime();
            zipFile.close();
        } catch (Exception unused) {
            time = 0;
        }
        if (time > 631152000000L) {
            return dateFormat.format(new Date(time));
        }
        return null;
    }

    public static bq l() {
        return b;
    }

    public static bq m(Intent intent) {
        bq bqVar = (bq) intent.getSerializableExtra("cat.ereza.customactivityoncrash.EXTRA_CONFIG");
        if (bqVar != null && bqVar.G() && t(intent) != null) {
            Log.e("CustomActivityOnCrash", "The previous app process crashed. This is the stack trace of the crash:\n" + t(intent));
        }
        return bqVar;
    }

    public static String n(Intent intent) {
        return intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_CUSTOM_CRASH_DATA");
    }

    public static String o() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return g(str2);
        }
        return g(str) + " " + str2;
    }

    public static Class p(Context context) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction("cat.ereza.customactivityoncrash.ERROR").setPackage(context.getPackageName()), 64);
        if (listQueryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(listQueryIntentActivities.get(0).activityInfo.name);
        } catch (ClassNotFoundException e2) {
            Log.e("CustomActivityOnCrash", "Failed when resolving the error activity class via intent filter, stack trace follows!", e2);
            return null;
        }
    }

    public static long q(Context context) {
        return context.getSharedPreferences("custom_activity_on_crash", 0).getLong("last_crash_timestamp", -1L);
    }

    public static Class r(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) {
            return null;
        }
        try {
            return Class.forName(launchIntentForPackage.getComponent().getClassName());
        } catch (ClassNotFoundException e2) {
            Log.e("CustomActivityOnCrash", "Failed when resolving the restart activity class via getLaunchIntentForPackage, stack trace follows!", e2);
            return null;
        }
    }

    public static Class s(Context context) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction("cat.ereza.customactivityoncrash.RESTART").setPackage(context.getPackageName()), 64);
        if (listQueryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(listQueryIntentActivities.get(0).activityInfo.name);
        } catch (ClassNotFoundException e2) {
            Log.e("CustomActivityOnCrash", "Failed when resolving the restart activity class via intent filter, stack trace follows!", e2);
            return null;
        }
    }

    public static String t(Intent intent) {
        return intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE");
    }

    public static String u(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    public static Class v(Context context) {
        Class clsP = p(context);
        return clsP == null ? DefaultErrorActivity.class : clsP;
    }

    public static Class w(Context context) {
        Class clsS = s(context);
        return clsS == null ? r(context) : clsS;
    }

    public static boolean x(Context context) {
        long jQ = q(context);
        long time = new Date().getTime();
        return jQ <= time && time - jQ < ((long) b.D());
    }

    public static void y(Context context) {
        try {
            if (context == null) {
                Log.e("CustomActivityOnCrash", "Install failed: context is null!");
                return;
            }
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler == null || !defaultUncaughtExceptionHandler.getClass().getName().startsWith("cat.ereza.customactivityoncrash")) {
                if (defaultUncaughtExceptionHandler != null && !defaultUncaughtExceptionHandler.getClass().getName().startsWith("com.android.internal.os")) {
                    Log.e("CustomActivityOnCrash", "IMPORTANT WARNING! You already have an UncaughtExceptionHandler, are you sure this is correct? If you use a custom UncaughtExceptionHandler, you must initialize it AFTER CustomActivityOnCrash! Installing anyway, but your original handler will not be called.");
                }
                a = (Application) context.getApplicationContext();
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: b60
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public final void uncaughtException(Thread thread, Throwable th) {
                        c60.a(defaultUncaughtExceptionHandler, thread, th);
                    }
                });
                a.registerActivityLifecycleCallbacks(new a());
            } else {
                Log.e("CustomActivityOnCrash", "CustomActivityOnCrash was already installed, doing nothing!");
            }
            Log.i("CustomActivityOnCrash", "CustomActivityOnCrash has been installed.");
        } catch (Throwable th) {
            Log.e("CustomActivityOnCrash", "An unknown error occurred while installing CustomActivityOnCrash, it may not have been properly initialized. Please report this as a bug if needed.", th);
        }
    }

    public static boolean z(Throwable th, Class cls) {
        String strTrim;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/cmdline"));
            strTrim = bufferedReader.readLine().trim();
            bufferedReader.close();
        } catch (IOException unused) {
            strTrim = null;
        }
        if (strTrim != null && strTrim.endsWith(":error_activity")) {
            return true;
        }
        do {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("android.app.ActivityThread") && stackTraceElement.getMethodName().equals("handleBindApplication")) {
                    return true;
                }
            }
            th = th.getCause();
        } while (th != null);
        return false;
    }
}
