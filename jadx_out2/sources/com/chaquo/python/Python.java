package com.chaquo.python;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Python {
    private static boolean failed;
    private static Python instance = new Python();
    private static Platform platform;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Platform {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getPath() {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void onStart(Python python) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Python() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized Python getInstance() {
        try {
            if (!isStarted()) {
                start(new GenericPlatform());
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    private native long getModuleNative(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized Platform getPlatform() {
        return platform;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized boolean isStarted() {
        return platform != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized void start(Platform platform2) {
        try {
            if (isStarted()) {
                throw new IllegalStateException("Python already started");
            }
            if (failed) {
                throw new IllegalStateException("Python startup previously failed, and cannot be retried");
            }
            try {
                startNative(platform2, platform2.getPath());
                platform2.onStart(instance);
                platform = platform2;
            } catch (Throwable th) {
                failed = true;
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static native void startNative(Platform platform2, String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyObject getBuiltins() {
        return getModule("builtins");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PyObject getModule(String str) {
        PyObject pyObject = PyObject.getInstance(getModuleNative(str));
        Objects.requireNonNull(pyObject);
        return pyObject;
    }
}
