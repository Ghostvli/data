package net.engio.mbassy.bus.config;

import java.util.Collection;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface IBusConfiguration {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Properties {
        public static final String AsynchronousHandlerExecutor = "bus.handlers.async-executor";
        public static final String BusId = "bus.id";
        public static final String PublicationErrorHandlers = "bus.handlers.error";
    }

    IBusConfiguration addFeature(Feature feature);

    BusConfiguration addPublicationErrorHandler(IPublicationErrorHandler iPublicationErrorHandler);

    <T extends Feature> T getFeature(Class<T> cls);

    <T> T getProperty(String str, T t);

    Collection<IPublicationErrorHandler> getRegisteredPublicationErrorHandlers();

    boolean hasProperty(String str);

    IBusConfiguration setProperty(String str, Object obj);
}
