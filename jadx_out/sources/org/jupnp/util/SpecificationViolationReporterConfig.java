package org.jupnp.util;

import defpackage.j02;
import defpackage.n02;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Designate(ocd = Config.class)
@Component(configurationPid = {"org.jupnp.util"}, property = {"specificationViolationReporterEnabled:Boolean=true"})
public class SpecificationViolationReporterConfig {
    private final j02 logger = n02.k(getClass());

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ObjectClassDefinition(description = "Configuration for jUPnP specification violation reporting", id = "org.jupnp.util", name = "jUPnP specification violation reporting configuration")
    public @interface Config {
        @AttributeDefinition(description = "Enable specification violation reporting.", name = "specificationViolationReporterEnabled")
        boolean specificationViolationReporterEnabled() default true;
    }

    private void reconfigure(Config config) {
        boolean zSpecificationViolationReporterEnabled = config.specificationViolationReporterEnabled();
        j02 j02Var = this.logger;
        if (zSpecificationViolationReporterEnabled) {
            j02Var.info("Enabling jUPnP specification violation reporter");
            SpecificationViolationReporter.enableReporting();
        } else {
            j02Var.info("Disabling jUPnP specification violation reporter");
            SpecificationViolationReporter.disableReporting();
        }
    }

    @Activate
    public void activate(Config config) {
        reconfigure(config);
    }

    @Modified
    public void modified(Config config) {
        reconfigure(config);
    }
}
