package net.engio.mbassy.bus.config;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ConfigurationError extends RuntimeException {
    private String message;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private ConfigurationError(String str) {
        this.message = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ConfigurationError MissingFeature(Class<? extends Feature> cls) {
        return new ConfigurationError("The expected feature " + cls + " was missing. Use addFeature() in IBusConfiguration to add features.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Throwable
    public String toString() {
        return this.message;
    }
}
