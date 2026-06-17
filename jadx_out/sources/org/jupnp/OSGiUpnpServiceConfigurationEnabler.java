package org.jupnp;

import defpackage.j02;
import defpackage.n02;
import java.util.Map;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Component(configurationPid = {"org.jupnp"}, configurationPolicy = ConfigurationPolicy.REQUIRE)
public class OSGiUpnpServiceConfigurationEnabler {
    private static final String AUTO_ENABLE = "autoEnable";
    private final j02 logger = n02.k(OSGiUpnpServiceConfigurationEnabler.class);

    @Activate
    public void activate(ComponentContext componentContext, Map<String, Object> map) {
        Object obj = map.get(AUTO_ENABLE);
        if (obj != null && !Boolean.parseBoolean(obj.toString())) {
            this.logger.A("{} not enabled by {}", OSGiUpnpServiceConfiguration.class.getSimpleName(), OSGiUpnpServiceConfigurationEnabler.class);
        } else {
            componentContext.enableComponent(OSGiUpnpServiceConfiguration.class.getName());
            this.logger.A("{} enabled by {}", OSGiUpnpServiceConfiguration.class.getSimpleName(), OSGiUpnpServiceConfigurationEnabler.class);
        }
    }

    @Deactivate
    public void deactivate(ComponentContext componentContext) {
        componentContext.disableComponent(OSGiUpnpServiceConfiguration.class.getName());
        this.logger.A("{} disabled by {}", OSGiUpnpServiceConfiguration.class.getSimpleName(), OSGiUpnpServiceConfigurationEnabler.class);
    }
}
