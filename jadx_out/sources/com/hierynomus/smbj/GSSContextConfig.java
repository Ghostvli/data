package com.hierynomus.smbj;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class GSSContextConfig {
    private boolean requestCredDeleg;
    private boolean requestMutualAuth;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Builder {
        private GSSContextConfig config = new GSSContextConfig();

        public GSSContextConfig build() {
            return new GSSContextConfig();
        }

        public Builder withRequestCredDeleg(boolean z) {
            this.config.requestCredDeleg = z;
            return this;
        }

        public Builder withRequestMutualAuth(boolean z) {
            this.config.requestMutualAuth = z;
            return this;
        }
    }

    private GSSContextConfig(GSSContextConfig gSSContextConfig) {
        this();
        this.requestMutualAuth = gSSContextConfig.requestMutualAuth;
        this.requestCredDeleg = gSSContextConfig.requestCredDeleg;
    }

    public static Builder builder() {
        return new Builder().withRequestMutualAuth(true).withRequestCredDeleg(false);
    }

    public static GSSContextConfig createDefaultConfig() {
        return builder().build();
    }

    public boolean isRequestCredDeleg() {
        return this.requestCredDeleg;
    }

    public boolean isRequestMutualAuth() {
        return this.requestMutualAuth;
    }

    private GSSContextConfig() {
    }
}
