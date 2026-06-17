package androidx.media3.exoplayer;

import android.media.MediaFormat;
import android.os.Bundle;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b b = new C0016b().a();
    public final Map a;

    public b(Map map) {
        this.a = Collections.unmodifiableMap(map);
    }

    public static C0016b d(MediaFormat mediaFormat, Set set) {
        C0016b c0016b = new C0016b();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (mediaFormat.containsKey(str)) {
                int valueTypeForKey = mediaFormat.getValueTypeForKey(str);
                if (valueTypeForKey == 1) {
                    c0016b.e(str, mediaFormat.getInteger(str));
                } else if (valueTypeForKey == 2) {
                    c0016b.f(str, mediaFormat.getLong(str));
                } else if (valueTypeForKey == 3) {
                    c0016b.d(str, mediaFormat.getFloat(str));
                } else if (valueTypeForKey == 4) {
                    c0016b.g(str, mediaFormat.getString(str));
                } else if (valueTypeForKey == 5) {
                    c0016b.c(str, mediaFormat.getByteBuffer(str));
                }
            }
        }
        return c0016b;
    }

    public void b(MediaFormat mediaFormat) {
        for (Map.Entry entry : this.a.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                mediaFormat.setString(str, null);
            } else if (value instanceof Integer) {
                mediaFormat.setInteger(str, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                mediaFormat.setLong(str, ((Long) value).longValue());
            } else if (value instanceof Float) {
                mediaFormat.setFloat(str, ((Float) value).floatValue());
            } else if (value instanceof String) {
                mediaFormat.setString(str, (String) value);
            } else if (value instanceof ByteBuffer) {
                mediaFormat.setByteBuffer(str, (ByteBuffer) value);
            }
        }
    }

    public C0016b c() {
        return new C0016b();
    }

    public Set e() {
        return this.a.keySet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.a.equals(((b) obj).a);
        }
        return false;
    }

    public Bundle f() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.a.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                if (value instanceof Integer) {
                    bundle.putInt(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    bundle.putLong(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    bundle.putFloat(str, ((Float) value).floatValue());
                } else if (value instanceof String) {
                    bundle.putString(str, (String) value);
                } else if (value instanceof ByteBuffer) {
                    ByteBuffer byteBuffer = (ByteBuffer) value;
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.duplicate().get(bArr);
                    bundle.putByteArray(str, bArr);
                }
            }
        }
        return bundle;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class C0016b {
        public final Map a;

        public C0016b(b bVar) {
            this.a = new HashMap(bVar.a);
        }

        public b a() {
            return new b(this.a);
        }

        public C0016b b(String str) {
            this.a.remove(str);
            return this;
        }

        public C0016b c(String str, ByteBuffer byteBuffer) {
            if (byteBuffer == null) {
                this.a.put(str, null);
                return this;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
            byteBufferAllocate.put(byteBuffer.duplicate());
            byteBufferAllocate.flip();
            this.a.put(str, byteBufferAllocate);
            return this;
        }

        public C0016b d(String str, float f) {
            this.a.put(str, Float.valueOf(f));
            return this;
        }

        public C0016b e(String str, int i) {
            this.a.put(str, Integer.valueOf(i));
            return this;
        }

        public C0016b f(String str, long j) {
            this.a.put(str, Long.valueOf(j));
            return this;
        }

        public C0016b g(String str, String str2) {
            this.a.put(str, str2);
            return this;
        }

        public C0016b() {
            this.a = new HashMap();
        }
    }
}
