package is.xyz.mpv;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import java.util.ArrayList;
import java.util.List;

public final class MPV {

    private long nativeHandle; // Keep this exactly as it is used by native code to store pointer!

    static {
        System.loadLibrary("xml2");
        System.loadLibrary("c++_shared");
        System.loadLibrary("mpv");
        System.loadLibrary("player");
    }

    private final List<EventObserver> observers = new ArrayList<>();
    private final List<LogObserver> log_observers = new ArrayList<>();

    public interface EventObserver {
        void event(int i, MPVNode mPVNode);
        void eventProperty(String str);
        void eventProperty(String str, double d);
        void eventProperty(String str, long j);
        void eventProperty(String str, MPVNode mPVNode);
        void eventProperty(String str, String str2);
        void eventProperty(String str, boolean z);
    }

    public interface LogObserver {
        void logMessage(String str, int i, String str2);
    }

    public void addObserver(EventObserver observer) {
        synchronized (observers) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        }
    }

    public void removeObserver(EventObserver observer) {
        synchronized (observers) {
            observers.remove(observer);
        }
    }

    public void addLogObserver(LogObserver observer) {
        synchronized (log_observers) {
            if (!log_observers.contains(observer)) {
                log_observers.add(observer);
            }
        }
    }

    public void removeLogObserver(LogObserver observer) {
        synchronized (log_observers) {
            log_observers.remove(observer);
        }
    }

    public void create(Context context) {
        nativeCreate(context);
    }

    public void init() {
        nativeInit();
    }

    public void destroy() {
        nativeDestroy();
    }

    // Callbacks invoked by JNI (must be private final as original signature and name/type)
    private final void event(int i, MPVNode mPVNode) {
        synchronized (observers) {
            for (EventObserver observer : observers) {
                observer.event(i, mPVNode);
            }
        }
    }

    private final void eventProperty(String str, long j) {
        synchronized (observers) {
            for (EventObserver observer : observers) {
                observer.eventProperty(str, j);
            }
        }
    }

    private final void eventProperty(String str, boolean z) {
        synchronized (observers) {
            for (EventObserver observer : observers) {
                observer.eventProperty(str, z);
            }
        }
    }

    private final void eventProperty(String str, double d) {
        synchronized (observers) {
            for (EventObserver observer : observers) {
                observer.eventProperty(str, d);
            }
        }
    }

    private final void eventProperty(String str, String str2) {
        synchronized (observers) {
            for (EventObserver observer : observers) {
                observer.eventProperty(str, str2);
            }
        }
    }

    private final void eventProperty(String str, MPVNode mPVNode) {
        synchronized (observers) {
            for (EventObserver observer : observers) {
                observer.eventProperty(str, mPVNode);
            }
        }
    }

    private final void eventProperty(String str) {
        synchronized (observers) {
            for (EventObserver observer : observers) {
                observer.eventProperty(str);
            }
        }
    }

    private final void logMessage(String str, int i, String str2) {
        synchronized (log_observers) {
            for (LogObserver observer : log_observers) {
                observer.logMessage(str, i, str2);
            }
        }
    }

    // Native declarations
    public final native void attachSurface(Surface surface);
    public final native void command(String... strArr);
    public final native MPVNode commandNode(String... strArr);
    public final native void detachSurface();
    public final native Boolean getPropertyBoolean(String str);
    public final native Double getPropertyDouble(String str);
    public final native Integer getPropertyInt(String str);
    public final native MPVNode getPropertyNode(String str);
    public final native String getPropertyString(String str);
    public final native Bitmap grabThumbnail(int i);
    public final native void nativeCreate(Context context);
    public final native void nativeDestroy();
    public final native void nativeInit();
    public final native void observeProperty(String str, int i);
    public final native int setOptionString(String str, String str2);
    public final native void setPropertyBoolean(String str, boolean z);
    public final native void setPropertyDouble(String str, double d);
    public final native void setPropertyInt(String str, int i);
    public final native void setPropertyNode(String str, MPVNode mPVNode);
    public final native void setPropertyString(String str, String str2);

    // Helper for long properties since JNI getPropertyInt returns Integer or we can parse string
    public Long getPropertyLong(String str) {
        try {
            String value = getPropertyString(str);
            return value == null ? null : Long.parseLong(value);
        } catch (Exception e) {
            return null;
        }
    }
}
