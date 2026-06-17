package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Registry {
    private final Cache<Converter> cache = new ConcurrentCache();
    private final RegistryBinder binder = new RegistryBinder();

    private Converter create(Class cls) {
        Converter converterLookup = this.binder.lookup(cls);
        if (converterLookup != null) {
            this.cache.cache(cls, converterLookup);
        }
        return converterLookup;
    }

    public Registry bind(Class cls, Class cls2) {
        if (cls != null) {
            this.binder.bind(cls, cls2);
        }
        return this;
    }

    public Converter lookup(Class cls) {
        Converter converterFetch = this.cache.fetch(cls);
        return converterFetch == null ? create(cls) : converterFetch;
    }

    public Registry bind(Class cls, Converter converter) {
        if (cls != null) {
            this.cache.cache(cls, converter);
        }
        return this;
    }
}
