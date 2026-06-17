package com.whl.quickjs.android;

import android.util.Log;
import com.whl.quickjs.wrapper.QuickJSContext;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class QuickJSLoader {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class LogcatConsole implements QuickJSContext.Console {
        private final String tag;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public LogcatConsole(String str) {
            this.tag = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.whl.quickjs.wrapper.QuickJSContext.Console
        public void error(String str) {
            Log.e(this.tag, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.whl.quickjs.wrapper.QuickJSContext.Console
        public void info(String str) {
            Log.i(this.tag, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.whl.quickjs.wrapper.QuickJSContext.Console
        public void log(String str) {
            Log.d(this.tag, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.whl.quickjs.wrapper.QuickJSContext.Console
        public void warn(String str) {
            Log.w(this.tag, str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init() {
        System.loadLibrary("quickjs-android-wrapper");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public static void initConsoleLog(QuickJSContext quickJSContext) {
        initConsoleLog(quickJSContext, new LogcatConsole("quickjs"));
    }

    public static native void startRedirectingStdoutStderr(String str);

    @Deprecated
    public static void initConsoleLog(QuickJSContext quickJSContext, QuickJSContext.Console console) {
        quickJSContext.setConsole(console);
    }

    @Deprecated
    public static void initConsoleLog(QuickJSContext quickJSContext, String str) {
        initConsoleLog(quickJSContext, new LogcatConsole(str));
    }
}
