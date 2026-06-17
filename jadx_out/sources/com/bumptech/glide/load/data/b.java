package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.a;
import defpackage.fg3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final a.InterfaceC0054a b = new a();
    public final Map a = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements a.InterfaceC0054a {
        @Override // com.bumptech.glide.load.data.a.InterfaceC0054a
        public Class a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0054a
        public com.bumptech.glide.load.data.a b(Object obj) {
            return new C0055b(obj);
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.data.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class C0055b implements com.bumptech.glide.load.data.a {
        public final Object a;

        public C0055b(Object obj) {
            this.a = obj;
        }

        @Override // com.bumptech.glide.load.data.a
        public Object a() {
            return this.a;
        }

        @Override // com.bumptech.glide.load.data.a
        public void b() {
        }
    }

    public synchronized com.bumptech.glide.load.data.a a(Object obj) {
        a.InterfaceC0054a interfaceC0054a;
        try {
            fg3.e(obj);
            interfaceC0054a = (a.InterfaceC0054a) this.a.get(obj.getClass());
            if (interfaceC0054a == null) {
                Iterator it = this.a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.InterfaceC0054a interfaceC0054a2 = (a.InterfaceC0054a) it.next();
                    if (interfaceC0054a2.a().isAssignableFrom(obj.getClass())) {
                        interfaceC0054a = interfaceC0054a2;
                        break;
                    }
                }
            }
            if (interfaceC0054a == null) {
                interfaceC0054a = b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return interfaceC0054a.b(obj);
    }

    public synchronized void b(a.InterfaceC0054a interfaceC0054a) {
        this.a.put(interfaceC0054a.a(), interfaceC0054a);
    }
}
