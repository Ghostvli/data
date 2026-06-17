package org.jupnp.support.model.dlna.types;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ScmsFlagType {
    private boolean copyright;
    private boolean original;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ScmsFlagType() {
        this.copyright = true;
        this.original = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isCopyright() {
        return this.copyright;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isOriginal() {
        return this.original;
    }

    public ScmsFlagType(boolean z, boolean z2) {
        this.copyright = z;
        this.original = z2;
    }
}
