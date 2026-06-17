package org.jupnp.binding.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface UpnpServiceType {
    String namespace() default "schemas-upnp-org";

    String value();

    int version() default 1;
}
