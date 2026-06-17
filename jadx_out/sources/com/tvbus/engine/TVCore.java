package com.tvbus.engine;

import android.content.Context;
import android.text.TextUtils;
import defpackage.yj1;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TVCore implements Runnable {
    private final long handle;
    private final Thread thread;

    public TVCore(String str) {
        System.load(str);
        this.handle = initialise();
        this.thread = new Thread(this);
    }

    private native int init(long j, Context context);

    private native long initialise();

    private native void quit(long j);

    private native int run(long j);

    private native void setAuthUrl(long j, String str);

    private native void setDomainSuffix(long j, String str);

    private native void setListener(long j, Listener listener);

    private native void setMKBroker(long j, String str);

    private native void setOption(long j, String str, String str2);

    private native void setPassword(long j, String str);

    private native void setPlayPort(long j, int i);

    private native void setRunningMode(long j, int i);

    private native void setServPort(long j, int i);

    private native void setUsername(long j, String str);

    private native void start(long j, String str);

    private native void stop(long j);

    public TVCore auth(String str) {
        try {
            if (!str.isEmpty()) {
                setAuthUrl(this.handle, str);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public TVCore broker(String str) {
        try {
            if (!str.isEmpty()) {
                setMKBroker(this.handle, str);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public TVCore domain(String str) {
        try {
            if (!str.isEmpty()) {
                setDomainSuffix(this.handle, str);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public void init() {
        this.thread.start();
    }

    public TVCore listener(Listener listener) {
        try {
            setListener(this.handle, listener);
        } catch (Throwable unused) {
        }
        return this;
    }

    public TVCore mode(int i) {
        try {
            setRunningMode(this.handle, i);
        } catch (Throwable unused) {
        }
        return this;
    }

    public TVCore name(String str) {
        try {
            if (!str.isEmpty()) {
                setUsername(this.handle, str);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public void option(String str, List<String> list) {
        try {
            if (list.isEmpty()) {
                return;
            }
            list.removeIf(new Predicate() { // from class: vk4
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return TextUtils.isEmpty((String) obj);
                }
            });
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                setOption(this.handle, str, it.next());
            }
        } catch (Throwable unused) {
        }
    }

    public TVCore pass(String str) {
        try {
            if (!str.isEmpty()) {
                setPassword(this.handle, str);
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public TVCore play(int i) {
        try {
            setPlayPort(this.handle, i);
        } catch (Throwable unused) {
        }
        return this;
    }

    public void quit() {
        try {
            quit(this.handle);
            this.thread.interrupt();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            init(this.handle, yj1.a());
            run(this.handle);
        } catch (Throwable unused) {
        }
    }

    public TVCore serv(int i) {
        try {
            setServPort(this.handle, i);
        } catch (Throwable unused) {
        }
        return this;
    }

    public void start(String str) {
        try {
            start(this.handle, str);
        } catch (Throwable unused) {
        }
    }

    public void stop() {
        try {
            stop(this.handle);
        } catch (Throwable unused) {
        }
    }
}
