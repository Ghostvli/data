package defpackage;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class vv4 implements Thread.UncaughtExceptionHandler {
    public final Context a;
    public final Thread.UncaughtExceptionHandler b;

    public vv4(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = context.getApplicationContext();
        this.b = uncaughtExceptionHandler;
    }

    public static void a(Context context) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof vv4) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new vv4(context, defaultUncaughtExceptionHandler));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            printWriter.println("Thread: " + thread.getName());
            th.printStackTrace(printWriter);
            printWriter.flush();
            o01.g(this.a, stringWriter.toString());
        } catch (Exception unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
