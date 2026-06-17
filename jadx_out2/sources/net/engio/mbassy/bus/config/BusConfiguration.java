package net.engio.mbassy.bus.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BusConfiguration implements IBusConfiguration {
    private final Map<Object, Object> properties = new HashMap();
    private final List<IPublicationErrorHandler> publicationErrorHandlers = new ArrayList();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.config.IBusConfiguration
    public IBusConfiguration addFeature(Feature feature) {
        this.properties.put(feature.getClass(), feature);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.config.IBusConfiguration
    public final BusConfiguration addPublicationErrorHandler(IPublicationErrorHandler iPublicationErrorHandler) {
        this.publicationErrorHandlers.add(iPublicationErrorHandler);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.config.IBusConfiguration
    public <T extends Feature> T getFeature(Class<T> cls) {
        return (T) this.properties.get(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.config.IBusConfiguration
    public <T> T getProperty(String str, T t) {
        return this.properties.containsKey(str) ? (T) this.properties.get(str) : t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.config.IBusConfiguration
    public Collection<IPublicationErrorHandler> getRegisteredPublicationErrorHandlers() {
        return Collections.unmodifiableCollection(this.publicationErrorHandlers);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.config.IBusConfiguration
    public boolean hasProperty(String str) {
        return this.properties.containsKey(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.config.IBusConfiguration
    public IBusConfiguration setProperty(String str, Object obj) {
        this.properties.put(str, obj);
        return this;
    }
}
